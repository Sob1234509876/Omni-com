@echo off

rem 1. Compile

"../../JAVA/JDK17/bin/javac" "@cFile" "-encoding" "utf-8" "-cp" "../../;../src;../;"
echo Compiling finish

pause

rem 2. Packaging
rem   [option] [pack_name]  [Manifest directory]  [pack file]
"../../JAVA/JDK17/bin/jar" "-cvfm" "vanilla.jar" "vanilla\MANIFEST.MF" "vanilla"

pause