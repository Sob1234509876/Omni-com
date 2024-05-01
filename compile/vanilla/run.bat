@echo off

echo ___________________
echo [COMPILING VANILLA]

rem Compiling
"%JAVA_HOME%/bin/javac" "@compile/vanilla/cFile" "-encoding" "utf-8" "-cp" "plugins;src;.;" "-d" "plugins/vanilla-comp"

echo Compiling finish

rem Packing
"%JAVA_HOME%/bin/jar" "-cfm" "plugins/vanilla.jar" "plugins/vanilla/MANIFEST.MF" "-C" "plugins/vanilla-comp" "vanilla"

rem Run src compile
"compile/src/run"