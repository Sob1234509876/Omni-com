@echo off

cd %~dp0

rem Run game
echo ______________
echo [RUNNING GAME]
echo ______________

"%JAVA_HOME%/bin/java" "-jar" "%HOME%/game.jar" "-XX:+ShowCodeDetailsInExceptionMessages"

echo ____________
echo [END OF RUN]
echo ____________

pause