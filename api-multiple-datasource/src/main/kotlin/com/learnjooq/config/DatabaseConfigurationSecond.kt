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
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource


@Configuration
class DatabaseConfigurationSecond {

    @Value("\${app.db-first.driverClassName}")
    private lateinit var databaseSecondDriver: String

    @Value("\${app.db-second.url}")
    private lateinit var databaseSecondUrl: String

    @Value("\${app.db-first.username}")
    private lateinit var databaseSecondUser: String

    @Value("\${app.db-first.password}")
    private lateinit var databaseSecondPassword: String

    @Bean("datasourceSecond")
    fun datasourceSecond(): DataSource {
        val datasoruce = HikariDataSource()
        datasoruce.driverClassName = databaseSecondDriver
        datasoruce.jdbcUrl = databaseSecondUrl
        datasoruce.username = databaseSecondUser
        datasoruce.password = databaseSecondPassword
        datasoruce.schema= "jooqtest"
        return datasoruce
    }

    @Bean("txManagerSecond")
    fun transactionManagerSecond(): DataSourceTransactionManager {
        return DataSourceTransactionManager(datasourceSecond())
    }

    @Bean("connectionProviderSecond")
    fun connectionProviderSecond(): ConnectionProvider {
        return DataSourceConnectionProvider(TransactionAwareDataSourceProxy(datasourceSecond()))
    }

    @Bean("txProviderSecond")
    fun transactionProviderSecond(): TransactionProvider {
        return SpringTransactionProvider(transactionManagerSecond())
    }

    @Bean("jooqSecond")
    fun dslContextSecond(): DSLContext {
        val defaultConfiguration = DefaultConfiguration()
            .derive(connectionProviderSecond())
            .derive(transactionProviderSecond())
            .derive(SQLDialect.POSTGRES)
        return DefaultDSLContext(defaultConfiguration)

    }
}