@echo off

echo ___________________
echo [COMPILING VANILLA]

cd %~dp0

set HOME="../../"

rem 1. Compile

"%JAVA_HOME%/bin/javac" "@cFile" "-encoding" "utf-8" "-cp" "%HOME%plugins;%HOME%src;%HOME%;"
echo Compiling finish

rem 2. Packaging
rem   [option] [pack_name]  [Manifest directory]  [pack file]
"%JAVA_HOME%/bin/jar" "-cvfm" "%HOME%plugins/vanilla.jar" "MANIFEST.MF" "%HOME%plugins/vanilla"


"../src/run"