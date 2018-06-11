#!/usr/bin/env bash

set -e

echo "---- killing old process ----"

# if there is a running process then kill it...
if [ -f save_pid.txt ]; then
   kill -9 `cat save_pid.txt`
   rm save_pid.txt
fi

logger pghost: $PGHOST

. $NVM_DIR/nvm.sh && nvm use

# migrate the database
(cd migrations && pg-migrator postgres://$PGUSER:$PGPW@$PGHOST:$PGPORT/$PGDATABASE)

echo "---- start new process ----"
nohup java -Denv="$ENV" -jar pizzaworks.jar > pizzalogs.log 2>&1 &  # start process detached from session and background it
echo $! > save_pid.txt  # write pid file

