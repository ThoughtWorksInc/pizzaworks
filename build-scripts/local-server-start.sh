#!/usr/bin/env bash

set -e

echo "---- starting new server ----"
mvn clean compile assembly:single && java -Denv="local" -jar target/*.jar

