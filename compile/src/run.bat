@echo off

echo _______________
echo [COMPILING SRC]

cd %~dp0

rem Compiling
"%JAVA_HOME%/bin/javac" "-encoding" "utf-8" "-cp" "%HOME%;" "@cFile"

echo Compiling finish

rem Packing
"%JAVA_HOME%/bin/jar" "-cfm" "%HOME%/test.jar" "MANIFEST.MF" "%HOME%/src"

rem Run game
echo ______________
echo [RUNNING GAME]
echo ______________

"%JAVA_HOME%/bin/java" "-jar" "%HOME%/test.jar"

echo ____________
echo [END OF RUN]
echo ____________
