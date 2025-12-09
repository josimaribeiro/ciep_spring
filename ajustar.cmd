set JAVA_HOME=C:\Program Files\Java\jdk-18
set JAVA_HOME=C:\Program Files\Java\jdk-17
call mvn clean
call mvn clean install

call mvn compile
call mvn package
pause
