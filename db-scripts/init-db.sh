#!/usr/bin/env bash

initdb -U superpizza

bash db-scripts/start_db.sh;

createuser -s superpizza;
createdb -U superpizza -O superpizza pizzaworks;

psql -U superpizza pizzaworks -f db-scripts/init-superpizza.sql

bash db-scripts/migrate.sh;
