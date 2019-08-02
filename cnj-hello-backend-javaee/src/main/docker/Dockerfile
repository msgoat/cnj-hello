FROM docker.at.automotive.msg.team/cloudtrain/cnj-docker-payara-full:3.0.2

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="AT41" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

# copy build artifact into payara deployment folder
COPY *.war ${DEPLOY_DIR}/
