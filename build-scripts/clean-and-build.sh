#!/bin/bash
set -e

echo "---- BUILDING ----"
mvn clean compile assembly:single
