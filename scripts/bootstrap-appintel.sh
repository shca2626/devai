#!/usr/bin/env bash
# ============================================================
# App Intelligence toolchain bootstrap — idempotent, self-healing.
#
# Installs everything the acquire/decompile/deep-analyze stages
# need, on any Linux host with python3 + curl:
#   1. Python venv + camoufox[geoip] + curl_cffi
#   2. Camoufox browser (locked v158.0.1-beta.41, direct download)
#   3. jadx 1.5.2
#
# Safe to run repeatedly; concurrent runs serialize on a lock.
# Exit 0 = ready. Exit 3 = missing system prerequisite (python3/curl).
# ============================================================
set -uo pipefail

HOME_DIR="${APPINTEL_HOME:-${HOME:-/home/z}}"
VENV="$HOME_DIR/.venv"
JADX_DIR="$HOME_DIR/tools/jadx"
BROWSER_GLOB="$HOME_DIR/.cache/camoufox/browsers/official/*"
LOCK="/tmp/.appintel-bootstrap.lock"
LOG="${APPINTEL_BOOTSTRAP_LOG:-/tmp/.appintel-bootstrap.log}"

log() { echo "[appintel-bootstrap $(date +%H:%M:%S)] $*" >> "$LOG"; }

# --- prerequisites -------------------------------------------------------
if ! command -v python3 >/dev/null 2>&1; then
  log "FATAL: python3 not found on this host"
  exit 3
fi
if ! command -v curl >/dev/null 2>&1; then
  log "FATAL: curl not found on this host"
  exit 3
fi

# --- serialize concurrent runs -------------------------------------------
exec 9>"$LOCK"
if ! flock -n 9; then
  log "another bootstrap holds the lock — waiting"
  flock 9
fi

# --- 1. venv + python deps ----------------------------------------------
need_pip=0
if [ ! -x "$VENV/bin/python3" ]; then
  log "creating venv at $VENV"
  python3 -m venv "$VENV" >> "$LOG" 2>&1 || { log "venv creation failed"; exit 1; }
  need_pip=1
fi
if [ "$need_pip" -eq 0 ] && ! "$VENV/bin/python3" -c "import camoufox, curl_cffi" >/dev/null 2>&1; then
  need_pip=1
fi
if [ "$need_pip" -eq 1 ]; then
  log "installing camoufox[geoip] + curl_cffi into venv"
  "$VENV/bin/pip" install --quiet --disable-pip-version-check 'camoufox[geoip]' curl_cffi >> "$LOG" 2>&1
  "$VENV/bin/python3" -c "import camoufox, curl_cffi" >/dev/null 2>&1 || { log "pip install failed"; exit 1; }
fi

# --- 2. camoufox browser -------------------------------------------------
if ! ls $BROWSER_GLOB/camoufox >/dev/null 2>&1; then
  log "fetching camoufox browser"
  SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
  if [ -f "$SCRIPT_DIR/fetch-camoufox-direct.py" ]; then
    "$VENV/bin/python3" "$SCRIPT_DIR/fetch-camoufox-direct.py" >> "$LOG" 2>&1 || log "direct fetch failed (will fall back)"
  fi
  if ! ls $BROWSER_GLOB/camoufox >/dev/null 2>&1; then
    "$VENV/bin/python3" -m camoufox fetch >> "$LOG" 2>&1 || log "camoufox fetch failed"
  fi
  ls $BROWSER_GLOB/camoufox >/dev/null 2>&1 || { log "browser fetch failed"; exit 2; }
fi

# --- 3. jadx --------------------------------------------------------------
if [ ! -x "$JADX_DIR/bin/jadx" ]; then
  log "installing jadx 1.5.2"
  mkdir -p "$HOME_DIR/tools"
  if curl -sL --max-time 180 -o /tmp/jadx-appintel.zip https://github.com/skylot/jadx/releases/download/v1.5.2/jadx-1.5.2.zip >> "$LOG" 2>&1; then
    unzip -q -o /tmp/jadx-appintel.zip -d "$JADX_DIR" >> "$LOG" 2>&1 && chmod +x "$JADX_DIR/bin/jadx"
    rm -f /tmp/jadx-appintel.zip
  fi
  [ -x "$JADX_DIR/bin/jadx" ] || { log "jadx install failed"; exit 2; }
fi

log "toolchain ready"
exit 0
