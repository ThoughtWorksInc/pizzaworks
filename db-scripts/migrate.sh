#!/usr/bin/env bash

if [ "$IS_GO_AGENT" = "true" ]; then
    echo "Go agent detected - setting npm"
    source /var/go/.bashrc
    nvm use 5.1.0
else
    echo "Go agent NOT detected - continuing using local environment"
fi

if [ -z "$MIGRATE_TO" ]; then
    echo "Migrating back to version: $MIGRATE_TO"
fi

(cd migrations && pg-migrator postgres://$PGUSER:$PGPW@$PGHOST:$PGPORT/$PGDATABASE $MIGRATE_TO)


