@echo off

echo ________________
echo [COMPILING MATH]

cd %~dp0

rem Compiling
"%JAVA_HOME%/bin/javac" "@cFile" "-encoding" "utf-8" "-cp" "%PLUG_HOME%/;"

echo Compiling finish

cd %PLUG_HOME%

rem Packing
"%JAVA_HOME%/bin/jar" "-cfm" "math.jar" "../compile/math/MANIFEST.MF" "math/"

rem Run vanilla compile
"../compile/vanilla/run"