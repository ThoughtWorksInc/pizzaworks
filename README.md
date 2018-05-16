# Pizzaworks! Where you can eat code and learn about pizza

## Requirements

#### Nvm and node

- Install nvm: https://github.com/creationix/nvm#install-script
- Use nvm to install version 5.1.0 of node (this is the version we used, so we know it 
  works): `nvm install 5.1.0`
- Make sure `nvm use 5.1.0` works and has selected the right version of node

#### Homebrew

- https://brew.sh/

#### Maven

- https://maven.apache.org/index.html

## Database setup

#### Postgres migration tool installation:

- `npm install -g pg-migrator`

#### Postgres installation
- Make sure homebrew is installed: https://brew.sh/
- `brew install postgres`
- Check that version is 10.x
- Set PGDATA environment variable to whatever directory you want your data to live 
  (we used /usr/local/var/postgres) i.e.: `export PGDATA="/usr/local/var/postgres"`
- Run `./db-scripts/init-db.sh` to set up local instance of postgres


## Running application
- First set the following environment variables for the app to find your postgres 
  instance:

```
export PGHOST="127.0.0.1"
export PGPORT="5432"
export PGUSER="superpizza"
export PGDATABASE="pizzaworks"
export PGPW="enter_real_pw_here"
```

Where superpizza is the postgres role that owns the database, pizzaworks is the db name,
and password is, obviously, the correct password

> Note - if you want to load this automatically, add these lines to either your 
  ~/.bashrc, ~/.bash_profile, ~/.zsh_profile or whatever you use

- From main project directory run `./build-scripts/local-server-start.sh`

#### Migrate the db locally:

> Note - not part of initial setup - the following migration instructions is just for 
  migrating the database to new versions

- From the main project directory, run `./db-scripts/migrate.sh`
