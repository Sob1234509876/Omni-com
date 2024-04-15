@echo off

echo ________________
echo [COMPILING MATH]

rem Compiling
"%JAVA_HOME%/bin/javac" "@%COMP_PATH%/math/cFile" "-encoding" "utf-8" "-cp" "%PLUG_HOME%/;"

echo Compiling finish

rem Packing

"%JAVA_HOME%/bin/jar" "-cfm" "plugins/math.jar" "plugins/math/MANIFEST.MF" "-C" "plugins/" "math/"

rem Run vanilla compile
"compile/vanilla/run"