#!/bin/bash

echo "---- Copying Jar to Server ----"
scp  ./jars/*.jar  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/pizzaworks.jar
scp  build-scripts/start-server.sh  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/

echo "---- Starting Server on Remote box ----"
ssh ec2-user@$PIZZA_WORKS_SERVER "bash start-server.sh"
