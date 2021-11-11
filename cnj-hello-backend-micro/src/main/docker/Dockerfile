FROM eclipse-temurin:11-jre

LABEL maintainer="michael.theis@msg.group"
LABEL ${project.groupId}.${project.artifactId}.project="CloudTrain"
LABEL ${project.groupId}.${project.artifactId}.version="${project.version}"
LABEL ${project.groupId}.${project.artifactId}.description="${project.description}"

ARG ARG_JAVA_APPLICATION=${project.build.finalName}-microbundle.jar
ARG ARG_JAVA_APPLICATION_HOME=/home/payara

ENV JAVA_APPLICATION=${ARG_JAVA_APPLICATION} \
    JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME} \
    JAVA_OPTS="-XshowSettings:vm -XX:+UseG1GC -XX:MetaspaceSize=256m -XX:+DisableExplicitGC -XX:+UseStringDeduplication -XX:+ParallelRefProcEnabled" \
    EXT_JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="-XX:+UseContainerSupport -XX:InitialRAMPercentage=75.0 -XX:MaxRAMPercentage=75.0" \
    PAYARA_JAVA_OPTS="" \
    PAYARA_ARGUMENTS="--disablephonehome --enablehealthcheck true --nocluster --nohostaware"

EXPOSE 8080

RUN echo "adding run user payara to system" && \
    addgroup --gid 1000 --system payara && \
    adduser --system --disabled-login --disabled-password --ingroup payara --uid 1000 payara

# copy entrypoint script
COPY docker-entrypoint.sh /

# copy all build artifacts into application home folder
COPY *.jar ${ARG_JAVA_APPLICATION_HOME}/

RUN echo "allow non-root user to access and execute all copied files" && \
    chown payara:payara /docker-entrypoint.sh && \
    chmod u+x /docker-entrypoint.sh && \
    chown -R payara:payara ${ARG_JAVA_APPLICATION_HOME}

# use user ID instead of user name to allow kubernetes to check non-root users
USER 1000

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["start"]