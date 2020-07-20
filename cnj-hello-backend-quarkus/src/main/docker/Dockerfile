FROM docker.at41tools.k8s.aws.msgoat.eu/cloudtrain/at41-docker-jre11:2.1.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="CloudTrain" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ENV JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="" \
    QUARKUS_JAVA_OPTS="" \
    QUARKUS_ARGUMENTS=""

RUN echo "adding run user quarkus to system" \
    && addgroup -S quarkus -g 1000 \
    && adduser -S quarkus -u 1000 -G quarkus

# copy build artifact into quarkus deployment folder
COPY *.jar /home/quarkus/
COPY docker-entrypoint.sh /home/quarkus/

RUN chown -R quarkus:quarkus /home/quarkus \
    && chmod u+x /home/quarkus/docker-entrypoint.sh

USER quarkus

ENTRYPOINT ["/home/quarkus/docker-entrypoint.sh"]
CMD ["start"]