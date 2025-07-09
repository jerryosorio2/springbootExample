# Spring Boot API-Only Demo

This is a minimal Spring Boot application exposing a REST API endpoint to return a greeting message.

## Requirements
- Java 17+
- Maven

## Run the application

### Using Maven
```
mvn spring-boot:run
```

### Using CLI
```
mvn "-Dspring-boot.run.arguments=goodbye,Jerry" spring-boot:run
```



### Using IntelliJ
- Open the project
- Run the `SpringbootApiApplication.java` class

## Test the API
```
curl http://localhost:8080/api/greet?name=Jerry
```
