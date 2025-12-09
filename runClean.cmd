@echo off
echo ========================================
echo Etapa 1: mvn clean install
echo ========================================
choice /m "Deseja executar 'mvn clean install'?"
if errorlevel 2 goto PULAR_MVN

call mvn clean install

start java -jar target\aula-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --logging.level.root=DEBUG

start brave --incognito http://127.0.0.1:8080