FROM docker.cloudtrain.aws.msgoat.eu/cloudtrain/at41-docker-jre11:3.0.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="CloudTrain" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ARG ARG_JAVA_APPLICATION=${project.build.finalName}-microbundle.jar
ARG ARG_JAVA_APPLICATION_HOME=/home/payara

ENV JAVA_APPLICATION=${ARG_JAVA_APPLICATION} \
    JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME} \
    JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="" \
    PAYARA_JAVA_OPTS="" \
    PAYARA_ARGUMENTS="--disablephonehome --enablehealthcheck true --nocluster --nohostaware"

EXPOSE 8080

# create non-root user to run application
RUN echo "adding run user payara to system" \
    && addgroup -S payara -g 1000 \
    && adduser -S payara -u 1000 -G payara

# copy entrypoint script
COPY docker-entrypoint.sh /

# copy all build artifacts into application home folder
COPY *.jar ${ARG_JAVA_APPLICATION_HOME}/

# allow non-root user to access and execute all copied files
RUN chown payara:payara /docker-entrypoint.sh \
    && chmod u+x /docker-entrypoint.sh \
    && chown -R payara:payara ${ARG_JAVA_APPLICATION_HOME}

# use user ID instead of user name to allow kubernetes to check non-root users
USER 1000

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["start"]