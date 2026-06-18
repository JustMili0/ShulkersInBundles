@echo off

cd /D %~dp0
del /q *.jar >nul

echo Building...
cd /D ../
powershell -c "./gradlew :fabric:build"
powershell -c "./gradlew :forge:build"
powershell -c "./gradlew :neoforge:build"

cd /D %~dp0
echo Moving files...
move ..\fabric\build\libs\*.jar . >nul
move ..\forge\build\libs\*.jar . >nul
move ..\neoforge\build\libs\*.jar . >nul

echo Deleting files...
del /q *slim.jar >nul
del /q *sources.jar >nul
del /q *fat.jar >nul

echo Done.
pause >nul