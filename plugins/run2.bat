@echo off
javac -encoding utf-8 @cFile2
jar -cvfm math.jar "math\MANIFEST.MF" math