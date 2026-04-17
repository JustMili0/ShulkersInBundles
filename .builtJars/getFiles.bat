@echo off
echo Moving files...
move ..\fabric\build\libs\*.jar . >nul
move ..\forge\build\libs\*.jar . >nul
move ..\neoforge\build\libs\*.jar . >nul

echo Deleting files...
del /q *slim.jar >nul
del /q *sources.jar >nul
del /q *fat.jar >nul