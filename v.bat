@echo off

set COMP_PATH=compile
set HOME=../..
set PLUG_HOME=%HOME%/plugins

if %1=="run" (
    "%COMP_PATH%/math/run"
) else if %1=="qrun" (
    "%COMP_PATH%/src/run"
) else if %1=="qqrun" (
    "%COMP_PATH%/src/qrun"
)

echo Invalid parameter
pause
exit