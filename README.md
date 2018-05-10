# Pizzaworks! Where you can eat code and learn about pizza

## Postgres installation

- `brew install postgres`
- Check that version is 10.x
- Set PGDATA environment variable to whatever directory you want your data to live (we used /usr/local/var/postgres) i.e.: `export PGDATA="/usr/local/var/postgres"`
- Run db-scripts/init-db.sh to set up local instance of postgres

### Postgres migration tool installation:

`npm install -g pg-migrator`

### Migrate the db locally:

- `pg-migrator postgres://superpizza:password@localhost/pizzaworks`
- Where superpizza is the postgres role that owns the database, pizzaworks is the db name, and password is, obviously, the correct password

## Running application
- First set the following environment variables for the app to find your postgres instance:

export PGHOST="127.0.0.1"
export PGPORT="5432"
export PGUSER="superpizza"
export PGDATABASE="pizzaworks"
export PGPW="enter_real_pw_here"
