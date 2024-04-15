@echo off

echo _______________
echo [COMPILING SRC]


rem Compiling
"%JAVA_HOME%/bin/javac" "-encoding" "utf-8" "-cp" "src; src/game/" "@%COMP_PATH%/src/cFile"

echo Compiling finish

rem Packing
"%JAVA_HOME%/bin/jar" "-cfm" "game.jar" "src/MANIFEST.MF" "-C" "src/" "game"

rem Run game
echo ______________
echo [RUNNING GAME]
echo ______________

"%JAVA_HOME%/bin/java" "-jar" "game.jar"

echo ____________
echo [END OF RUN]
echo ____________

pause
