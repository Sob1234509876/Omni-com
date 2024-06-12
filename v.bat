@echo off

if %1=="run" (
    "compile/math/run"
) else if %1=="qrun" (
    "compile/src/run"
) else if %1=="qqrun" (
    "compile/src/qrun"
)

echo Invalid parameter
pause
exit