@echo off

echo _______________
echo [COMPILING SRC]

cd %~dp0

set HOME="../../"

"%JAVA_HOME%/bin/javac" "-encoding" "utf-8" "-cp" "%HOME%;" "@cFile"
"%JAVA_HOME%/bin/jar" "-cvfm" "%HOME%test.jar" "MANIFEST.MF" "%HOME%src"

echo ______________
echo [RUNNING GAME]
echo ______________

"%JAVA_HOME%/bin/java" "-jar" "%HOME%test.jar"

echo [END OF RUN]
echo ____________
