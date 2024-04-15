@echo off

echo ___________________
echo [COMPILING VANILLA]

rem Compiling
"%JAVA_HOME%/bin/javac" "@%COMP_PATH%/vanilla/cFile" "-encoding" "utf-8" "-cp" "plugins;src;.;"

echo Compiling finish

rem Packing
"%JAVA_HOME%/bin/jar" "-cfm" "%PLUG_HOME%/vanilla.jar" "%PLUG_HOME%/vanilla/MANIFEST.MF" "-C" "%PLUG_HOME%" "vanilla"

rem Run src compile
"compile/src/run"