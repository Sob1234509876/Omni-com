rem Remember to run the same script under the plugins/vanilla folder!

@echo off
"../JAVA/JDK17/bin/javac" -encoding utf-8 @cFile
"../JAVA/JDK17/bin/jar" -cvfm test.jar src\MANIFEST.MF src

echo FLAG@1

"../JAVA/JDK17/bin/java" -jar test.jar

echo FLAG@2

pause