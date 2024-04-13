@echo off

echo _______________
echo [COMPILING SRC]

cd %~dp0

rem Compiling
"%JAVA_HOME%/bin/javac" "-encoding" "utf-8" "-cp" "%HOME%/src; %HOME%/src/game/" "@cFile"

echo Compiling finish

rem Packing
"%JAVA_HOME%/bin/jar" "-cfm" "%HOME%/game.jar" "%HOME%/src/MANIFEST.MF" "-C" "%HOME%/src/" "game"

rem Run game
echo ______________
echo [RUNNING GAME]
echo ______________

"%JAVA_HOME%/bin/java" "-jar" "%HOME%/game.jar" "-XX:+ShowCodeDetailsInExceptionMessages"

echo ____________
echo [END OF RUN]
echo ____________

pause
