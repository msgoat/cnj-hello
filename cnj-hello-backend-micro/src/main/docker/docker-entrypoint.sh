#!/bin/sh

if [ "$1" = "start" ]
then
	echo "Running Payara Microprofile application ..."
	java ${JAVA_OPTS} ${DOCKER_JAVA_OPTS} ${PAYARA_JAVA_OPTS} -jar /home/payara/*.jar
else 
	exec "$@"	
fi
