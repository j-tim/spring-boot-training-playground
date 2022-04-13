# Spring Boot Training Playground

Playground for the Spring Boot training.

Super simple 3 tier layer architecture Spring Boot application.

Including:

* Repository layer
  * Spring Data JPA
  * MySQL 
  * Flyway (database migration)
* Service layer
  * Mapstruct to map object from the repository layer into a service layer object to not leak repository concerns into the other parts of the application.
* Rest API layer
  * Spring Web MVC

## Build and run the project

```
./mvnw clean package
```

Start MySQL in a Docker container:

```
docker-compose up -d
```

Run the Spring Boot application using the Spring Boot Maven plugin.

```
./mvmvn spring-boot:run
```

## Exercises

* Play around with Spring Profiles
  * Introduce a profile like `acceptance`, `production`
  * Experience how property inheritance works
  * Configure the application differently for different profiles (like running Tomcat on a different port)
* Add Spring Boot test slices for every layer
  * Hints:
    * `@DataJpaTest`
    * `@WebMvcTest`
  * Make sure to fail the test first before you fix it ;)
* Testcontainers
  * Introduce more advanced repository layer integration tests 
  * Replace H2 
  * introduce test containers to run repository integration tests against a real MySQL instance running in Docker
* Introduce tests for the service layer
  * What to choose? Unit tests (Mockito) or integration tests?
  * If you choose to do integration tests make sure tests are not leaving traces behind in the database!
* Introduce AssertJ
  * Use this great library
  * Rewrite your assertions
  * Experiment with the fluent API try out to do assertions on collections
* Cloud native buildpacks 
  * Build an OCI image for your Spring Boot application
  * Without using a Docker file
* Archunit
  * Enforce your architecture rules
  * By creating some Archunit tests
  * Examples: 
    * Service layer should be called only by the Rest layer
    * Repository layer should only be called by the service layer
  * Try to use some default archunit rules to enforce things like: 
    * We don't use Jodatime in the project
    * We don't use the old Java data classes

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
