@echo off

echo ___________________
echo [COMPILING VANILLA]

cd %~dp0

rem Compiling
"%JAVA_HOME%/bin/javac" "@cFile" "-encoding" "utf-8" "-cp" "%HOME%/plugins;%HOME%/src;%HOME%;"

echo Compiling finish

cd %PLUG_HOME%

rem Packing
"%JAVA_HOME%/bin/jar" "-cfm" "vanilla.jar" "../compile/vanilla/MANIFEST.MF" "vanilla"

rem Run src compile
"../compile/src/run"