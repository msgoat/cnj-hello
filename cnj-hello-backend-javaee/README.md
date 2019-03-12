# cnj-hello-backend-javaee

Simplest possible cloud native java application based on Java EE 8.

## Docker Pull Command
`docker pull docker.at.automotive.msg.team/cloudtrain/cnj-hello-backend-javaee`

## Run this application 

``` 
docker run --name cnj-hello-backend-javaee -p 8080:8080 docker.at.automotive.msg.team/cloudtrain/cnj-hello-backend-javaee
```

## Build this application 

1. Clone the git repo to your local machine.
1. Change to the repos root folder
1. Run Maven with activated profile __pre-commit-stage__: 

``` 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing an Payara Full Profile application server plus the deploy application.

## Exposed REST endpoints

### /api/v1/hello

Returns a simple welcome message to the currently authenticated user.

Method
: GET

URI
: /api/v1/hello

Parameter(s)
: none

Response
: welcome message as JSON document

Authentication type
: none

Role(s) required
: none


## Exposed environment variables

## Exposed Ports

| Port | Protocol | Description |
| --- | --- | --- |
| 8080 | HTTP | HTTP endpoint of this spring boot application | 
 
## Version / Tags

| Tag(s) | Remarks |
| --- | --- |
| latest, 1.0.0 | first release |
