#!/usr/bin/env bash

initdb -U superpizza /usr/local/var/postgres

bash db-scripts/start_db.sh;

#createuser -s superpizza;
createdb -U superpizza -O superpizza pizzaworks;

psql -U superpizza pizzaworks -f db-scripts/init-superpizza.sql

bash db-scripts/migrate.sh;
