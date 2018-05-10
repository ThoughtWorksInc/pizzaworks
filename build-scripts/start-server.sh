#!/bin/bash

set -e

echo "---- killing old process ----"

# if there is a running process then kill it...
if [ -f save_pid.txt ]; then
   kill -9 `cat save_pid.txt`
   rm save_pid.txt
fi

echo "---- start new process ----"
nohup java -jar pizzaworks.jar > pizzalogs.log 2>&1 &  # start process detached from session and background it
echo $! > save_pid.txt  # write pid file
