FROM docker.cloudtrain.aws.msgoat.eu/cloudtrain/at41-docker-jre11:4.0.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="CloudTrain" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ARG ARG_JAVA_APPLICATION=${project.build.finalName}-runner.jar
ARG ARG_JAVA_APPLICATION_HOME=/home/quarkus

ENV JAVA_APPLICATION=${ARG_JAVA_APPLICATION} \
    JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME} \
    JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="" \
    QUARKUS_JAVA_OPTS="" \
    QUARKUS_ARGUMENTS=""

# create non-root user to run application
RUN echo "adding run user quarkus to system" && \
    addgroup --gid 1000 --system quarkus && \
    adduser --system --disabled-login --disabled-password --ingroup quarkus --uid 1000 quarkus

# copy entrypoint script
COPY docker-entrypoint.sh /

# copy build artifacts into application home folder (here: quarkus deployment folder)
COPY *.jar ${ARG_JAVA_APPLICATION_HOME}/

# allow non-root user to access and execute all copied files
RUN chown quarkus:quarkus /docker-entrypoint.sh \
    && chmod u+x /docker-entrypoint.sh \
    && chown -R quarkus:quarkus ${ARG_JAVA_APPLICATION_HOME}

# use user ID instead of user name to allow kubernetes to check non-root users
USER 1000

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["start"]