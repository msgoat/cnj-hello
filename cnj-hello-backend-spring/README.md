# cnj-hello-backend-spring

Simplest possible cloud native java application based on Spring Boot.

## Docker Pull Command
`docker pull hmfwpcnj/cnj-hello-backend-spring`

## Run this application 

``` 
docker run --name cnj-hello-backend-spring -p 8080:8080 hmfwpcnj/cnj-hello-backend-spring
```

## Build this application 

See [cnj-hello](../README.md) for build instructions.

## Exposed REST endpoints

### /api/v1/hello

Returns a simple welcome message user in JSON format

Method
: GET

URI
: /v1/hello

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
| 8080 | HTTP | HTTP endpoint of this Spring Boot application | 
 
## Version / Tags

| Tag(s) | Remarks |
| --- | --- |
| latest, 1.0.0 | first release |
