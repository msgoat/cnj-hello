#!/bin/sh

if [ "$1" = "start" ]
then
	echo "Running Quarkus application ..."
	java ${JAVA_OPTS} ${DOCKER_JAVA_OPTS} ${QUARKUS_JAVA_OPTS} -jar /home/quarkus/*.jar ${QUARKUS_ARGUMENTS}
else 
	exec "$@"	
fi
