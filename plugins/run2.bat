@echo off

"../../JAVA/JDK17/bin/javac" -encoding utf-8 @cFile2

pause

"../../JAVA/JDK17/bin/jar" -cvfm math.jar "math\MANIFEST.MF" math

pause