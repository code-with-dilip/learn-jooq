package com.learnjooq.config

import com.zaxxer.hikari.HikariDataSource
import org.jooq.ConnectionProvider
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.TransactionProvider
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource


@Configuration
class DatabaseConfigurationFirst {

    @Value("\${app.db-first.driverClassName}")
    private lateinit var databaseFirstDriver: String

    @Value("\${app.db-first.url}")
    private lateinit var databaseFirstUrl: String

    @Value("\${app.db-first.username}")
    private lateinit var databaseFirstUser: String

    @Value("\${app.db-first.password}")
    private lateinit var databaseFirstPassword: String

    @Bean("datasourceFirst")
    fun datasourceFirst(): DataSource {
        val datasoruce = HikariDataSource()
        datasoruce.driverClassName = databaseFirstDriver
        datasoruce.jdbcUrl = databaseFirstUrl
        datasoruce.username = databaseFirstUser
        datasoruce.password = databaseFirstPassword
        datasoruce.schema= "jooqtest"
        return datasoruce
    }

    @Bean("txManagerFirst")
    fun transactionManagerFirst(): DataSourceTransactionManager {
        return DataSourceTransactionManager(datasourceFirst())
    }

    @Bean("connectionProviderFirst")
    fun connectionProviderFirst(): ConnectionProvider {
        return DataSourceConnectionProvider(TransactionAwareDataSourceProxy(datasourceFirst()))
    }

    @Bean("txProviderFirst")
    fun transactionProviderFirst(): TransactionProvider {
        return SpringTransactionProvider(transactionManagerFirst())
    }

    @Bean("jooqFirst")
    fun dslContextFirst(): DSLContext {
        val defaultConfiguration = DefaultConfiguration()
            .derive(connectionProviderFirst())
            .derive(transactionProviderFirst())
            .derive(SQLDialect.POSTGRES)
        return DefaultDSLContext(defaultConfiguration)

    }
}