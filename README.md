## Author: Cus (NG XI ZHUEN)

## Content
✅ Simple REST service perform CRUD operations

✅ Request & Response logging

✅ MSSQL data source

✅ RestTemplate to call 3rd party endpoint

✅ Pagination

## Pre-requisites

1. Java version 17
2. Maven version 3.9
3. MSSQL server 2022


## Configuration
Before running the application, configure the database connection in the application.properties file:
```properties
spring.datasource.url=jdbc:sqlserver://;serverName=localhost;databaseName=placesdb;encrypt=true;trustServerCertificate=true;
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.username=sa
spring.datasource.password=cuscuscus
spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
Make sure to replace cuscuscus with your database password.

## Running the Application
```bash
mvn spring-boot:run
```
