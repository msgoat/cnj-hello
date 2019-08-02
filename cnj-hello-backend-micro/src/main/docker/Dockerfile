FROM docker.at.automotive.msg.team/msgoat/at41-docker-jre11:1.0.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="AT41" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ENV JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="" \
    PAYARA_JAVA_OPTS="-Djava.util.logging.ConsoleHandler.formatter=fish.payara.enterprise.server.logging.JSONLogFormatter" \
    PAYARA_ARGUMENTS="--disablephonehome --enablehealthcheck true --nocluster --nohostaware"

RUN echo "adding run user payara to system" \
    && addgroup -S payara -g 1000 \
    && adduser -S payara -u 1000 -G payara

# copy build artifact into payara deployment folder
COPY *.jar /home/payara/
COPY docker-entrypoint.sh /home/payara/

RUN chown -R payara:payara /home/payara \
    && chmod u+x /home/payara/docker-entrypoint.sh

USER payara

ENTRYPOINT ["/home/payara/docker-entrypoint.sh"]
CMD ["start"]