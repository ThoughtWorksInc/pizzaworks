#!/usr/bin/env bash

if [ "$IS_GO_AGENT" = "true" ]; then
    echo "Go agent detected - setting npm"
    source /var/go/.bashrc
else
    source ~/.bashrc
    echo "Go agent NOT detected - continuing using local environment"
fi

nvm use

if [ -z "$MIGRATE_TO" ]; then
    echo "Migrating back to version: $MIGRATE_TO"
fi

(cd migrations && pg-migrator postgres://$PGUSER:$PGPW@$PGHOST:$PGPORT/$PGDATABASE $MIGRATE_TO)