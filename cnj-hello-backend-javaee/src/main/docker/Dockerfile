FROM docker.at.automotive.msg.team/cloudtrain/cnj-docker-payara-full:latest

LABEL maintainer="michael.theis@hm.edu" \
        ${project.groupId}.${project.artifactId}.project="HMFWPCNJ" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ENV \
  PAYARA_AS_ADMIN_CMD="${PAYARA_PATH}/bin/asadmin --user ${ADMIN_USER} --passwordfile=${PAYARA_PASSWORD_FILE} --echo"

# Init JDBC Resources / Connection Pools
RUN \
    echo "starting Payara domain ${PAYARA_DOMAIN} to configure application resources" \
    && ${PAYARA_AS_ADMIN_CMD} start-domain ${PAYARA_DOMAIN} \
    && echo "applying application server configuration..." \
    && echo "... application server configuration applied" \
    && echo "stopping Payara domain ${PAYARA_DOMAIN} after configuring application resources" \
    && ${PAYARA_AS_ADMIN_CMD} stop-domain ${PAYARA_DOMAIN} \
    && cat ${PAYARA_PATH}/glassfish/domains/${PAYARA_DOMAIN}/logs/server.log \
    && echo "cleanup after initial payara setup" \
    && rm -rf ${PAYARA_PATH}/glassfish/domains/${PAYARA_DOMAIN}/osgi-cache \
    && rm -rf ${PAYARA_PATH}/glassfish/domains/${PAYARA_DOMAIN}/logs

# copy build artifact into payara deployment folder
COPY *.war ${DEPLOY_DIR}/
