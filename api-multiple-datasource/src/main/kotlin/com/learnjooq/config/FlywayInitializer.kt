package com.learnjooq.config

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct
import javax.sql.DataSource


@Configuration
class FlywayInitializer(
    @Qualifier("datasourceFirst")
    val dataSource: DataSource
) {

    @PostConstruct
    fun migrateFlyway(): Flyway? {
        return Flyway.configure()
            .dataSource(dataSource)
            .load()
        //if default config is not sufficient, call setters here
    }

}