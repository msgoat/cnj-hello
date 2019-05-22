FROM openjdk:8-jre-slim

LABEL maintainer="michael.theis@hm.edu" \
        ${project.groupId}.${project.artifactId}.project="HMFWPCNJ" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ENV JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap" \
    SPRING_JAVA_OPTS="" \
    SPRING_PROFILES_ACTIVE="default" \
    CNAP_CLOUD="local"

COPY *.jar /opt/springboot/lib/
COPY docker-entrypoint.sh /opt/springboot/bin/
RUN chmod a+x /opt/springboot/bin/docker-entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["/opt/springboot/bin/docker-entrypoint.sh"]
CMD ["java"]



