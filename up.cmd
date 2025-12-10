chcp 65001 >nul
@echo off
title Gerador de README - Projeto Java Spring 2025

REM === Configurações ===
set "project_name=Projeto Java 2025"
set "author=Josimar Ribeiro"
set "save_path=%CD%"
set "date_time=%DATE% %TIME%"

set "logo_url2=https://github.com/josimaribeiro/ciep_spring/blob/main/src/main/resources/static/IMG-INF/spring.png"

set "filename=README.md"

REM === Cria o README.md ===
echo # %project_name% > "%filename%"
echo. >> "%filename%"
echo ## Informações do sistema >> "%filename%"
echo - Data e hora: %date_time% >> "%filename%"
echo - Usuário: %USERNAME% >> "%filename%"
echo - Computador: %COMPUTERNAME% >> "%filename%"
echo - Diretório atual: %CD% >> "%filename%"
for /f "tokens=* delims=" %%g in ('git --version') do echo - %%g >> "%filename%"
echo. >> "%filename%"

echo ^<img src="%logo_url2%" width="300"^> >> "%filename%"

echo. >> "%filename%"
echo ## Autor >> "%filename%"
echo %author% >> "%filename%"
echo. >> "%filename%"
echo OBS : atalho para out.println(""); >> "%filename%"
echo. >> "%filename%"

REM === Verifica e configura o Git ===
if not exist ".git" (
    echo Criando repositório Git local...
    git init
)

REM === Verifica se origin existe ===
git remote -v | find "origin" >nul
if %errorlevel% neq 0 (
    echo Adicionando remote origin da conta pessoal...
    git remote add origin git@github.com-pessoal:josimaribeiro/ciep_spring.git
)

REM === Git ===
git branch -M main
git add . -v
git commit -m "Atualizado em %date% %time%"
git push -u origin main

:fim

start https://github.com/josimaribeiro/ciep_spring
