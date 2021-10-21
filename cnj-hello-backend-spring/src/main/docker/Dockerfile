FROM docker.cloudtrain.aws.msgoat.eu/cloudtrain/at41-docker-jre11:4.0.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="CloudTrain" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ARG ARG_JAVA_APPLICATION=${project.build.finalName}.jar
ARG ARG_JAVA_APPLICATION_HOME=/home/spring

ENV JAVA_APPLICATION=${ARG_JAVA_APPLICATION} \
    JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME} \
    JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="" \
    SPRING_JAVA_OPTS="" \
    SPRING_ARGUMENTS="" \
    SPRING_PROFILES_ACTIVE="default" \
    JAVA_APPLICATION=${ARG_JAVA_APPLICATION} \
    JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME}

RUN echo "adding run user spring to system" && \
    addgroup --gid 1000 --system spring && \
    adduser --system --disabled-login --disabled-password --ingroup spring --uid 1000 spring

COPY docker-entrypoint.sh /
COPY *.jar ${ARG_JAVA_APPLICATION_HOME}/

RUN chown spring:spring /docker-entrypoint.sh \
    && chmod u+x /docker-entrypoint.sh \
    && chown -R spring:spring ${ARG_JAVA_APPLICATION_HOME}

# use user ID instead of user name to allow kubernetes to check non-root users
USER 1000

EXPOSE 8080

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["java"]



