set DRONE_BRANCH=local
set DRONE_COMMIT_SHA=12345678

echo "step: jakartaee-commit-stage"
call mvn clean install -f cnj-hello-backend-jakartaee/pom.xml -B -ff -e -V -U -P commit-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA% -Dsonar.login=%SONARQUBE_TOKEN%
echo step:jakartaee-integration-test-stage
call mvn clean verify -f cnj-hello-backend-jakartaee/pom.xml -B -ff -e -V -U -P integration-test-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA%
echo step:micro-commit-stage
call mvn clean install -f cnj-hello-backend-micro/pom.xml -B -ff -e -V -U -P commit-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA% -Dsonar.login=%SONARQUBE_TOKEN%
echo step:micro-integration-test-stage
call mvn clean verify -f cnj-hello-backend-micro/pom.xml -B -ff -e -V -U -P integration-test-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA%
echo step:spring-commit-stage
call mvn clean install -f cnj-hello-backend-spring/pom.xml -B -ff -e -V -U -P commit-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA% -Dsonar.login=%SONARQUBE_TOKEN%
echo step:spring-integration-test-stage
call mvn clean verify -f cnj-hello-backend-spring/pom.xml -B -ff -e -V -U -P integration-test-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA%
echo step:quarkus-commit-stage
call mvn clean install -f cnj-hello-backend-quarkus/pom.xml -B -ff -e -V -U -P commit-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA% -Dsonar.login=%SONARQUBE_TOKEN%
echo step:quarkus-integration-test-stage
call mvn clean verify -f cnj-hello-backend-quarkus/pom.xml -B -ff -e -V -U -P integration-test-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA%
