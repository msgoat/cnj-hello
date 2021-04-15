call mvn clean install -P commit-stage
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%

call mvn clean install -P dockerize-stage -Dtest.target.route=http://localhost:8080
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%

call mvn clean verify -P integration-test-stage
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%
