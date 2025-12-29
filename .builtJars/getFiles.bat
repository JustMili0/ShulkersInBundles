@echo off
if not exist .\fabric\ mkdir fabric
if not exist .\quilt\ mkdir quilt
if not exist .\forge\ mkdir forge
if not exist .\neoforge\ mkdir neoforge

echo Moving files...
move ..\fabric\build\libs\*.jar . >nul
move ..\quilt\build\libs\*.jar . >nul
move ..\forge\build\libs\*.jar . >nul
move ..\neoforge\build\libs\*.jar . >nul

timeout /t 3 /nobreak >nul
echo Deleting files...
del /q *dev-shadow.jar >nul

timeout /t 1 /nobreak >nul
echo Sorting files...
move .\*Fabric.jar .\fabric\
move .\*Quilt.jar .\quilt\
move .\*NeoForge.jar .\neoforge\
move .\*Forge.jar .\forge\