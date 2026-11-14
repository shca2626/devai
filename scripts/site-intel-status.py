#!/usr/bin/env python3
"""Print one line status for a site-intel analysis row: status stageDone score error"""
import json
import sys
import urllib.request

BASE = "http://localhost:3000/api/site-intel"
analysis_id = sys.argv[1]
with urllib.request.urlopen(f"{BASE}?analysisId={analysis_id}", timeout=60) as r:
    d = json.load(r)["analysis"]
print(f"{d['status']} {d['stageDone']} score={d['score']} err={d.get('error')}")
