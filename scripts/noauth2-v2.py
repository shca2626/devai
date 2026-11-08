#!/usr/bin/env python3
"""NoAuth2 v2: try (A) no-auth browsing with device id, (B) anonymous c2dm register3 token."""
import os, sys
os.environ['PROTOCOL_BUFFERS_PYTHON_IMPLEMENTATION'] = 'python'
import requests
from gpapi.googleplay import GooglePlayAPI
from gpapi import googleplay_pb2

PKG = sys.argv[1] if len(sys.argv) > 1 else "com.arkanprotailor.arkan_tailor"

api = GooglePlayAPI(locale="en_US", timezone="UTC")
BASE = api.deviceBuilder.getBaseHeaders()
print("[base headers]", {k: (v[:50] + '...' if len(v) > 50 else v) for k, v in BASE.items()})

# anonymous checkin
h = dict(BASE); h["Content-Type"] = "application/x-protobuf"
req = api.deviceBuilder.getAndroidCheckinRequest()
r = requests.post("https://android.clients.google.com/checkin", data=req.SerializeToString(), headers=h, timeout=30)
resp = googleplay_pb2.AndroidCheckinResponse(); resp.ParseFromString(r.content)
aid = resp.androidId
print(f"[checkin] androidId={aid} hex={aid:x}")

# ---- Variant A: fdfe details with NO Authorization, device id only ----
hA = dict(BASE)
hA["X-DFE-Device-Id"] = f"{aid:x}"
hA.pop("Authorization", None)
for host in ["https://play.googleapis.com/fdfe/details", "https://android.clients.google.com/fdfe/details"]:
    try:
        rA = requests.get(host, params={"doc": PKG}, headers=hA, timeout=30)
        body_head = rA.content[:200]
        print(f"[A:{host.split('/')[2]}] http={rA.status_code} bytes={len(rA.content)} head={body_head[:80]!r}")
        if rA.status_code == 200 and len(rA.content) > 500:
            print("  >>> VARIANT A WORKS FOR BROWSING")
    except Exception as e:
        print(f"[A:{host}] EXC {e}")

# ---- Variant B: anonymous c2dm register3 -> token ----
CERTS = ["38918A453D6818ABF852E2C3FBD54F57"]
for cert in CERTS:
    data = {
        "app": "com.android.vending",
        "cert": cert,
        "app_ver": "83212000",
        "app_ver_name": "32.1.20-21",
        "device": f"{aid:x}",
        "sdk_version": "19",
        "target_ver": "28",
    }
    try:
        rB = requests.post(
            "https://android.clients.google.com/c2dm/register3",
            data=data,
            headers={"User-Agent": BASE.get("User-Agent", "Android-Finsky/32.1.20 (API 28)"), "Content-Type": "application/x-www-form-urlencoded"},
            timeout=30,
        )
        txt = rB.text[:200]
        print(f"[B cert={cert[:12]}…] http={rB.status_code} body={txt!r}")
        if "token=" in rB.text:
            token = rB.text.split("token=")[1].strip()
            print(f"  >>> GOT ANONYMOUS TOKEN: {token[:30]}...")
            # try details with it
            hC = dict(BASE); hC["X-DFE-Device-Id"] = f"{aid:x}"; hC["Authorization"] = f"GoogleLogin auth={token}"
            rC = requests.get("https://play.googleapis.com/fdfe/details", params={"doc": PKG}, headers=hC, timeout=30)
            print(f"[B-details] http={rC.status_code} bytes={len(rC.content)}")
            if rC.status_code == 200 and len(rC.content) > 1000:
                print("  >>> VARIANT B WORKS FOR BROWING")
    except Exception as e:
        print(f"[B cert={cert[:12]}…] EXC {e}")
