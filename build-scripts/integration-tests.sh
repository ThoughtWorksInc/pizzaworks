#!/usr/bin/env bash

source /var/go/.bashrc
nvm use 5.1.0
mvn clean test -Pintegration-tests
