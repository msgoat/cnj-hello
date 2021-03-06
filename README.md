# cnj-hello

Showcase of a "Hello-World" style cloud native Java using Spring Boot, Jakarta EE, Eclipse MicroProfile and Quarkus 
as Java backend technologies:

* Jakarta EE (see: [cnj-hello-backend-jakartaee](cnj-hello-backend-jakartaee/README.md))
* Eclipse MicroProfile (see: [cnj-hello-backend-micro](cnj-hello-backend-micro/README.md))
* Spring Boot (see: [cnj-hello-backend-spring](cnj-hello-backend-spring/README.md))
* Quarkus (see: [cnj-hello-backend-quarkus](cnj-hello-backend-quarkus/README.md))

## Status
![Build status](https://drone.at.automotive.msg.team/api/badges/msgoat/cnj-hello/status.svg)

## Build this showcase 

### Prerequisites

In order to run the build, you have to install the following tools locally:
* Docker
* Docker Compose 
* Maven
* Java JDK 11   

### Run Maven

You can build all showcase applications by running Maven:
```
mvn clean install -P pre-commit-stage
```

The Maven build will create Docker images for all showcase applications and run system tests on them.