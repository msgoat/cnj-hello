FROM docker.at41tools.k8s.aws.msgoat.eu/cloudtrain/at41-docker-jre11:2.1.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="CloudTrain" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ENV JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="" \
    SPRING_JAVA_OPTS="" \
    SPRING_PROFILES_ACTIVE="default" \
    CNAP_CLOUD="local"

RUN echo "adding run user spring to system" \
    && addgroup -S spring -g 1000 \
    && adduser -S spring -u 1000 -G spring

COPY *.jar /home/spring/
COPY docker-entrypoint.sh /home/spring/

RUN chown -R spring:spring /home/spring \
    && chmod u+x /home/spring/docker-entrypoint.sh

USER spring

EXPOSE 8080

ENTRYPOINT ["/home/spring/docker-entrypoint.sh"]
CMD ["java"]



