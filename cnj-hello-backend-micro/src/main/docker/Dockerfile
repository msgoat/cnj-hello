FROM openjdk:8-jre-alpine

LABEL maintainer="michael.theis@hm.edu" \
        ${project.groupId}.${project.artifactId}.project="HMFWPCNJ" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ENV JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap" \
    PAYARA_JAVA_OPTS=""

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