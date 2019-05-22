# cnj-hello

Showcase of a "Hello-World" style cloud native Java using Spring Boot, Java EE and Eclipse MicroProfile as Java backend technologies

## Build this showcase 

### Prerequisites

In order to run the build, you have to install the following tools locally:
* Docker
* Docker Compose 
* Maven
* Java JDK 8

### Run Maven

You can build all showcase applications by running Maven:
```
mvn clean install -P pre-commit-stage
```

The Maven build will create Docker images for all showcase applications and run system tests on them.