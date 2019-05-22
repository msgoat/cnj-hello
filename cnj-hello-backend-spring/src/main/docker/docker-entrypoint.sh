#!/bin/sh

if [ "$1" = 'java' ]; then
	echo "Running Spring Boot application at /opt/springboot/lib..."
	java ${JAVA_OPTS} ${DOCKER_JAVA_OPTS} ${SPRING_JAVA_OPTS} -jar /opt/springboot/lib/*.jar
else 
	exec "$@"	
fi
