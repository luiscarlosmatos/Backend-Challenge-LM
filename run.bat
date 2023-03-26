@echo off

call mvn clean install -Dmaven.test.skip=true

call docker build -t challenge-1.0.0.jar .

call docker-compose up