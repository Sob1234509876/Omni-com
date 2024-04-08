@echo off

cd %~dp0

rem Run game
echo ______________
echo [RUNNING GAME]
echo ______________

"%JAVA_HOME%/bin/java" "-jar" "%HOME%/test.jar"

echo ____________
echo [END OF RUN]
echo ____________
