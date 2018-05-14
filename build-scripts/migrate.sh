#!/usr/bin/env bash

(cd migrations && pg-migrator postgres://$PGUSER:$PGPW@$PGHOST:$PGPORT/$PGDATABASE)
