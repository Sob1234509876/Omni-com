@echo off

echo ________________
echo [COMPILING MATH]

rem Compiling
"%JAVA_HOME%/bin/javac" "@compile/math/cFile" "-encoding" "utf-8" "-cp" "plugins;" "-d" "plugins/math-comp"

echo Compiling finish

rem Packing

"%JAVA_HOME%/bin/jar" "-cfe" "plugins/math.jar" "math.main.Main" "-C" "plugins/math-comp" "math/"

rem Run vanilla compile
"compile/vanilla/run"