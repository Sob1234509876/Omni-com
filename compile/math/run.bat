@echo off

echo ________________
echo [COMPILING MATH]

cd %~dp0

set HOME="../../"

"%JAVA_HOME%/bin/javac" "-encoding" "utf-8" "-cp" "%HOME%plugins/;" "@cFile"

echo Compiling finish

"%JAVA_HOME%/bin/jar" "-cvfm" "%HOME%plugins/math.jar" "MANIFEST.MF"  "%HOME%plugins/math/"


"../vanilla/run"