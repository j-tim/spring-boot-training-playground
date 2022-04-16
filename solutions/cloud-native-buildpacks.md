# Solution Cloud Native buildpacks

First build an OCI container for your Spring Boot Application.
Make sure your tests are passing. 

```
./mvnw spring-boot:build-image
```

Check if the image has been created:

```
docker images | grep spring-boot-training-playground
```

Now add your Spring Boot application to the [docker-compose.yml](docker-compose.yml) file.

* Expose the application on port 8080
* Since your application is now running in Docker it will not find MySQL on `localhost`!
* Configure the MySQL host by setting the environment variable `MYSQL_HOST`
* Another option is to introduce a profile for running the application in a container (you can name the profile something like: `container`)
  * In this case you need to set the active profile using an environment variable: `SPRING_PROFILES_ACTIVE=container`

```yml
version: '3.8'

services:

  # https://registry.hub.docker.com/_/mysql/?tab=tags
  mysql:
    image: mysql:8.0.28
    container_name: mysql
    ports:
      - 3306:3306
    environment:
      MYSQL_ROOT_PASSWORD: topSecret
      MYSQL_USER: myuser
      MYSQL_PASSWORD: secret
      MYSQL_DATABASE: mydb
      TZ: $TZ

  # First run: ./mvnw spring-boot:build-image
  application:
    image: docker.io/library/spring-boot-training-playground:0.0.1-SNAPSHOT
    ports:
      - 8080:8080
    environment:
      TZ: $TZ
      MYSQL_HOST: mysql
```