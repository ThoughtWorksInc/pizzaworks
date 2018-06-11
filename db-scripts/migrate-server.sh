#!/usr/bin/env bash

echo "---- Copying Migrate Script to Server ----"
scp  ./db-scripts/migrate.sh  ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/
scp  -r migrations ec2-user@$PIZZA_WORKS_SERVER:/home/ec2-user/


echo "---- Starting Migration on Remote box ----"
ssh ec2-user@$PIZZA_WORKS_SERVER -o SendEnv="PGHOST PGPORT PGUSER PGDATABASE PGPW ENV" "chmod +x migrate.sh && MIGRATE_TO=$MIGRATE_TO ./migrate.sh"


