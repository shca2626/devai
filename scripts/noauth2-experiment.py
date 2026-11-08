#!/usr/bin/env python3
"""NoAuth2 experiment: anonymous Android device checkin -> browse -> purchase free app -> download APK.
No Google account involved anywhere."""
import os, sys, traceback
os.environ['PROTOCOL_BUFFERS_PYTHON_IMPLEMENTATION'] = 'python'

import requests
from gpapi.googleplay import GooglePlayAPI
from gpapi import googleplay_pb2

PKG = sys.argv[1] if len(sys.argv) > 1 else "com.arkanprotailor.arkan_tailor"

api = GooglePlayAPI(locale="en_US", timezone="UTC")
BASE_HEADERS = api.deviceBuilder.getBaseHeaders()

# ---- Step 1: ANONYMOUS checkin (no account) ----
req = api.deviceBuilder.getAndroidCheckinRequest()
h = dict(BASE_HEADERS)
h["Content-Type"] = "application/x-protobuf"
r = requests.post("https://android.clients.google.com/checkin", data=req.SerializeToString(), headers=h, timeout=30)
print(f"[checkin] http={r.status_code} bytes={len(r.content)}")
resp = googleplay_pb2.AndroidCheckinResponse()
resp.ParseFromString(r.content)
print(f"[checkin] androidId={resp.androidId} securityToken={resp.securityToken} consistency={resp.deviceCheckinConsistencyToken}")
if not resp.androidId:
    print("FATAL: no androidId"); sys.exit(1)

api.gsfId = resp.androidId
api.authSubToken = "anonymous-bypass-guard"  # client-side guard only

# ---- Step 2: details (browse) with device-only identity ----
try:
    d = api.details(PKG)
    print(f"[details] title={d.get('title')!r} versionCode={d.get('versionCode')} offerType={d.get('offerType')}")
    vc = d.get("versionCode"); ot = d.get("offerType", 1)
except Exception as e:
    print(f"[details] FAILED: {type(e).__name__}: {e}")
    traceback.print_exc(limit=2)
    sys.exit(2)

# ---- Step 3: purchase (free app, anonymous) ----
try:
    headers = api.getHeaders()
    params = {"doc": PKG, "ot": ot}
    pr = requests.post("https://android.clients.google.com/fdfe/purchase", headers=headers, params=params, timeout=30)
    print(f"[purchase] http={pr.status_code} bytes={len(pr.content)} ct={pr.headers.get('content-type','')[:40]}")
    # parse purchase response protobuf: payload.buyResponse.purchaseInfoToken
    try:
        import google.protobuf.text_format  # noqa
        resp2 = googleplay_pb2.ResponseWrapper()
        resp2.ParseFromString(pr.content)
        blob = resp2.payload.buyResponse
        pt = blob.purchaseInfoToken
        print(f"[purchase] docId={pt.docid.docid} hasDownloadToken={bool(pt.downloadToken)} token_len={len(pt.downloadToken or '')}")
        dl_token = pt.downloadToken
    except Exception as pe:
        print(f"[purchase] protobuf parse issue: {pe}")
        dl_token = None
except Exception as e:
    print(f"[purchase] FAILED: {e}"); dl_token = None

# ---- Step 4: delivery ----
try:
    result = api.delivery(PKG, vc, ot, dl_token)
    url, cookie = result["downloadUrl"], result["cookie"]
    print(f"[delivery] url={url[:80]}... cookie={cookie[:40]}...")
    # ---- Step 5: fetch the APK ----
    r3 = requests.get(url, headers={"User-Agent": "AndroidDownloadManager/11 (Linux; U; Android 11)", "Cookie": cookie}, timeout=300)
    print(f"[download] http={r3.status_code} bytes={len(r3.content)} magic={r3.content[:2]}")
    if r3.content[:2] == b"PK":
        open(f"/tmp/{PKG}.apk", "wb").write(r3.content)
        print(f"SUCCESS: saved /tmp/{PKG}.apk ({len(r3.content)/1e6:.1f} MB)")
except Exception as e:
    print(f"[delivery/download] FAILED: {type(e).__name__}: {e}")
    traceback.print_exc(limit=3)
