FROM eclipse-temurin:11-jre

LABEL maintainer="michael.theis@msg.group"
LABEL ${project.groupId}.${project.artifactId}.project="CloudTrain"
LABEL ${project.groupId}.${project.artifactId}.version="${project.version}"
LABEL ${project.groupId}.${project.artifactId}.description="${project.description}"

ARG ARG_JAVA_APPLICATION=${project.build.finalName}.jar
ARG ARG_JAVA_APPLICATION_HOME=/home/spring

ENV JAVA_APPLICATION=${ARG_JAVA_APPLICATION} \
    JAVA_APPLICATION_HOME=${ARG_JAVA_APPLICATION_HOME} \
    JAVA_OPTS="-XshowSettings:vm -XX:+UseG1GC -XX:MetaspaceSize=256m -XX:+DisableExplicitGC -XX:+UseStringDeduplication -XX:+ParallelRefProcEnabled" \
    EXT_JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="-XX:+UseContainerSupport -XX:InitialRAMPercentage=75.0 -XX:MaxRAMPercentage=75.0" \
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



