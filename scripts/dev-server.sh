#!/usr/bin/env bash
# Detached dev server (survives the calling shell) — usage:
#   scripts/dev-server.sh start | stop | status
cd "$(dirname "$0")/.."
PIDFILE=/tmp/devai-dev.pid

start() {
  if [ -f "$PIDFILE" ] && kill -0 "$(cat "$PIDFILE")" 2>/dev/null; then
    echo "already running pid=$(cat "$PIDFILE")"
    return 0
  fi
  setsid nohup bun run dev >> dev.log 2>&1 < /dev/null &
  echo $! > "$PIDFILE"
  echo "started pid=$(cat "$PIDFILE")"
}

stop() {
  if [ -f "$PIDFILE" ]; then
    kill -TERM -"$(cat "$PIDFILE")" 2>/dev/null
    kill -TERM "$(cat "$PIDFILE")" 2>/dev/null
    rm -f "$PIDFILE"
  fi
  pkill -f "next dev" 2>/dev/null
  pkill -f "next-server" 2>/dev/null
  sleep 1
  echo "stopped"
}

status() {
  if [ -f "$PIDFILE" ] && kill -0 "$(cat "$PIDFILE")" 2>/dev/null; then
    echo "running pid=$(cat "$PIDFILE") http=$(curl -s -o /dev/null -w '%{http_code}' -m 5 http://localhost:3000)"
  else
    echo "not running http=$(curl -s -o /dev/null -w '%{http_code}' -m 5 http://localhost:3000)"
  fi
}

case "${1:-status}" in
  start) start ;;
  stop) stop ;;
  status) status ;;
  *) echo "usage: $0 start|stop|status" ;;
esac
