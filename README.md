# JOOQ

## JOOQ CodeGen

Complete the below steps before running the integration tests. 

##### Install postgres
 
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