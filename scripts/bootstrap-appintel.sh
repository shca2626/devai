#!/usr/bin/env bash
# ============================================================
# App Intelligence toolchain bootstrap — idempotent, self-healing.
#
# All tool state lives under <repo>/.tools-home by default so it
# survives host restarts and sandbox recycles (relocate with
# APPINTEL_HOME). Installs on any Linux host with python3 + curl:
#   1. Python venv + first-party Play client (vendored gpapi) +
#      pyaxmlparser + protobuf<5 (runtime matched to the vendored
#      old-style gencode)
#   2. jadx 1.5.2
#   3. legacy mirror deps (camoufox + curl_cffi + browser) ONLY when
#      the opt-in mirror chain is enabled (APP_INTEL_ALLOW_MIRROR=1)
#
# Safe to run repeatedly; concurrent runs serialize on a lock.
# Exit 0 = ready. Exit 2 = install failed. Exit 3 = missing system
# prerequisite (python3/curl).
# ============================================================
set -uo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"
HOME_DIR="${APPINTEL_HOME:-$REPO_DIR/.tools-home}"
VENV="$HOME_DIR/.venv"
JADX_DIR="$HOME_DIR/tools/jadx"
BROWSER_GLOB="$HOME_DIR/.cache/camoufox/browsers/official/*"
LOCK="/tmp/.appintel-bootstrap.lock"
LOG="${APPINTEL_BOOTSTRAP_LOG:-/tmp/.appintel-bootstrap.log}"

log() { echo "[appintel-bootstrap $(date +%H:%M:%S)] $*" >> "$LOG"; }

mkdir -p "$HOME_DIR"

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
  python3 -m venv "$VENV" >> "$LOG" 2>&1 || { log "venv creation failed"; exit 2; }
  need_pip=1
fi
if [ "$need_pip" -eq 0 ] && ! "$VENV/bin/python3" -c "import gpapi.googleplay, pyaxmlparser" >/dev/null 2>&1; then
  need_pip=1
fi

# gpapi/googleplay_pb2.py is generated, not shipped: build it with the
# grpcio-tools 1.62.x protoc (25.x old-style gencode) so it matches the
# protobuf<5 runtime pin. Idempotent — skipped once it exists.
if [ ! -f "$SCRIPT_DIR/vendor/googleplay-api/gpapi/googleplay_pb2.py" ]; then
  log "generating gpapi/googleplay_pb2.py (grpcio-tools protoc)"
  "$VENV/bin/pip" install --quiet --disable-pip-version-check --no-cache-dir 'grpcio-tools==1.62.3' >> "$LOG" 2>&1 || log "grpcio-tools install failed"
  (cd "$SCRIPT_DIR/vendor/googleplay-api" && "$VENV/bin/python3" -m grpc_tools.protoc --proto_path=. --python_out=gpapi/ googleplay.proto) >> "$LOG" 2>&1 || log "pb2 generation failed"
  [ -f "$SCRIPT_DIR/vendor/googleplay-api/gpapi/googleplay_pb2.py" ] || { log "googleplay_pb2.py generation failed"; exit 2; }
fi

if [ "$need_pip" -eq 1 ]; then
  log "installing venv deps: first-party Play client (vendored gpapi) + pyaxmlparser + protobuf<5"
  # force-reinstall the vendored package: a previously-installed wheel without
  # googleplay_pb2.py must be replaced (pip would otherwise say "satisfied")
  "$VENV/bin/pip" install --quiet --disable-pip-version-check --no-cache-dir --force-reinstall --no-deps \
    "$SCRIPT_DIR/vendor/googleplay-api" >> "$LOG" 2>&1
  "$VENV/bin/pip" install --quiet --disable-pip-version-check --no-cache-dir pyaxmlparser 'protobuf<5' >> "$LOG" 2>&1
  "$VENV/bin/python3" -c "import gpapi.googleplay, pyaxmlparser" >/dev/null 2>&1 \
    || { log "pip install failed (gpapi/pyaxmlparser)"; exit 2; }
fi

# mirror-chain deps are opt-in — the default chain never needs them
if [ "${APP_INTEL_ALLOW_MIRROR:-0}" = "1" ]; then
  if ! "$VENV/bin/python3" -c "import camoufox, curl_cffi" >/dev/null 2>&1; then
    log "installing legacy mirror deps (APP_INTEL_ALLOW_MIRROR=1)"
    "$VENV/bin/pip" install --quiet --disable-pip-version-check 'camoufox[geoip]' curl_cffi >> "$LOG" 2>&1 \
      || log "mirror deps not ready (mirror path disabled; Play-direct unaffected)"
  fi
  if ! ls $BROWSER_GLOB/camoufox >/dev/null 2>&1; then
    log "fetching camoufox browser"
    if [ -f "$SCRIPT_DIR/fetch-camoufox-direct.py" ]; then
      "$VENV/bin/python3" "$SCRIPT_DIR/fetch-camoufox-direct.py" >> "$LOG" 2>&1 || log "direct fetch failed (will fall back)"
    fi
    if ! ls $BROWSER_GLOB/camoufox >/dev/null 2>&1; then
      "$VENV/bin/python3" -m camoufox fetch >> "$LOG" 2>&1 || log "camoufox fetch failed"
    fi
    ls $BROWSER_GLOB/camoufox >/dev/null 2>&1 || log "browser fetch failed (mirror path only)"
  fi
fi

# --- 2. jadx --------------------------------------------------------------
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
