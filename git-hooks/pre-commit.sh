FORBIDDEN="API_KEY"
ERROR_MSG="You're trying to check in secret keys! Commit aborted - please remove them and try again."
git diff --cached | grep -E $FORBIDDEN && echo $ERROR_MSG && exit 1
