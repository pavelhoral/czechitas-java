echo %~dp0
@echo off
setlocal
set JAVA_HOME=%~dp0jdk-12.0.1
set MAVEN_CONFIG=-Dmaven.repo.local=%~dp0maven
start "Visual Studio Code" "%~dp0vscode-1.33.1\Code.exe" --extensions-dir extensions workspace
endlocal