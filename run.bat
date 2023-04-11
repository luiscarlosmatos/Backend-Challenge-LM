@echo off

call mvn clean install -T5C

call docker build -t challenge-1.0.0.jar .

call docker-compose up