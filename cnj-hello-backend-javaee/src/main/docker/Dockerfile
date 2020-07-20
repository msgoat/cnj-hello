FROM docker.at41tools.k8s.aws.msgoat.eu/cloudtrain/cnj-docker-payara-full:4.2.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="CloudTrain" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

# copy build artifact into payara deployment folder
COPY *.war ${DEPLOY_DIR}/
