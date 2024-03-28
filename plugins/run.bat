@echo off

rem 1. Compile

"javac" "@cFile" "-encoding" "utf-8" "-cp" "../../;../src;../;"
echo Compiling finish

rem 2. Packaging
rem   [option] [pack_name]  [Manifest directory]  [pack file]
"jar" "-cvfm" "vanilla.jar" "vanilla\MANIFEST.MF" "vanilla"