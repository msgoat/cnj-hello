# cnj-hello

> Deprecated: This repository has been deprecated and may be deleted in the near future. Please refer to the new dedicated repositories
> cnj-hello-backend-jakartaee, cnj-hello-backend-micro, cnj-hello-backend-quarkus and cnj-hello-backend-spring.

Showcase of a "Hello-World" style cloud native Java using Spring Boot, Jakarta EE, Eclipse MicroProfile and Quarkus 
as Java backend technologies:

* Jakarta EE (see: [cnj-hello-backend-jakartaee](cnj-hello-backend-jakartaee/README.md))
* Eclipse MicroProfile (see: [cnj-hello-backend-micro](cnj-hello-backend-micro/README.md))
* Spring Boot (see: [cnj-hello-backend-spring](cnj-hello-backend-spring/README.md))
* Quarkus (see: [cnj-hello-backend-quarkus](cnj-hello-backend-quarkus/README.md))

## Status

![Build status](https://drone.cloudtrain.aws.msgoat.eu/api/badges/msgoat/cnj-hello/status.svg)

## Release Information

A changelog can be found in [changelog.md](changelog.md).

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
