#!/usr/bin/env bash
# wait-for-it.sh - Wait for a service to be ready

set -e

host="$1"
shift
port="$1"
shift

while ! nc -z "$host" "$port"; do
  echo "Waiting for $host:$port to be available..."
  sleep 2
done

exec "$@"
