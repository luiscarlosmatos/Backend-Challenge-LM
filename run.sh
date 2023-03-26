#!/usr/bin/env bash

mvn clean install -Dmaven.test.skip=true

docker build -t challenge-1.0.0.jar .

docker-compose up

