call mvn clean install -P commit-stage
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%

call mvn clean install -P dockerize-stage -Dtest.target.route=http://192.168.99.100:8080
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%

call mvn verify -P integration-test-stage
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%
