rem Remember to run the same script under the plugins/vanilla folder!

@echo off
javac -encoding utf-8 @cFile
jar -cvfm test.jar src\MANIFEST.MF src

echo FLAG@1

java -jar test.jar

echo FLAG@2