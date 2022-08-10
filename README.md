# JOOQ

## JOOQ CodeGen

Complete the below steps before running the integration tests. 

### Install postgres

- Follow the below steps to install postgres and db.
 
```androiddatabinding
brew install jooqtest
```

##### Create the user postgres by running the below command.

```androiddatabinding
createuser postgres -s

```

##### Create the Database by running the below command.

```androiddatabinding
createdb -p 5432 -h localhost -e jooqtest
```

##### Install gist if you haven't before

```androiddatabinding
psql  -h localhost jooqtest -U postgres

```

##### Create Schema

Run all the commands in src/test/resources/CreateSchema.sql on psql prompt to create the schema

```androiddatabinding

CREATE SCHEMA IF NOT EXISTS deliverydb;
GRANT USAGE on schema deliverydb to postgres;
GRANT CREATE on schema deliverydb to postgres;
ALTER USER postgres SET search_path to deliverydb;

```

## Configuring Multiple DataSource

- For this to work , we need to disable the JOOQ Autoconfiguration:
  - We need to configure two different DataSources
  - We need to configure two different DSLContext
- Check the [api-multiple-datasource](api-multiple-datasource) module to learn about its done

### application.yml
- Define the db details in the application

```yaml
app:
  db-first:
    driverClassName: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/jooqtest?currentSchema=jooqtest
    username: postgres
    password: postgres

  db-second:
    driverClassName: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/loadtrackdb?currentSchema=jooqtest
    username: postgres
    password: postgres
```

### Create the custom DSL Context

- We need to create two different classes referencing to the appropriate DB's

```kotlin

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
```
### Referencing the appropriate DSLContext in the DAO

- We can use the qualifier to reference the appropriate dslContext

```kotlin
class DeliveryDAO(
    @Qualifier("jooqFirst")
    val dslContextFirst: DSLContext,
    @Qualifier("jooqSecond")
    val dslContextSecond: DSLContext
) {
```