#!/usr/bin/env bash

set -e

echo "---- Copying Jar to Server ----"
scp  ./jars/*.jar  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/pizzaworks.jar
scp  ./.nvmrc  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/
scp  build-scripts/start-server.sh  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/
scp  -r properties  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/
scp  -r migrations  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/


logger environment: $ENV
logger pghost: $PGHOST
echo "---- Starting Server on Remote box ----"
ssh ec2-user@$PIZZA_WORKS_SERVER -o SendEnv="PGHOST PGPORT PGUSER PGDATABASE PGPW ENV" "chmod +x ./start-server.sh && ./start-server.sh"
