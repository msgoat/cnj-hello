set DRONE_BRANCH=local
set DRONE_COMMIT_SHA=12345678

echo step:spring-commit-stage
call mvn clean install -B -ff -e -V -U -P commit-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA% -Dsonar.login=%SONARQUBE_TOKEN%
echo step:spring-integration-test-stage
call mvn clean verify -B -ff -e -V -U -P integration-test-stage -Dchangelist=.%DRONE_BRANCH% -Dsha1=.%DRONE_COMMIT_SHA%
