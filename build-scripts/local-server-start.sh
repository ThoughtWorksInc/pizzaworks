#!/bin/bash

set -e

echo "---- starting new server ----"
mvn clean compile assembly:single && java -jar target/*.jar

