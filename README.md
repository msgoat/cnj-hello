# cnj-hello

Showcase of a "Hello-World" style cloud native Java using Spring Boot, Java EE and Eclipse MicroProfile as Java backend technologies

## Status
![Build status](https://drone.at.automotive.msg.team/api/badges/cloudtrain/cnj-hello/status.svg)

## Release information

Latest version is: `3.0.0`.

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