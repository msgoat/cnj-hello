#!/bin/sh

if [ "$1" = 'java' ]; then
	echo "Running Spring Boot application ..."
	java ${JAVA_OPTS} ${DOCKER_JAVA_OPTS} ${SPRING_JAVA_OPTS} -jar /home/spring/*.jar
else 
	exec "$@"	
fi
