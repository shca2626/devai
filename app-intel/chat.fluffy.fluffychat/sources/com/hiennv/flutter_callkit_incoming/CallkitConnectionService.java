package com.hiennv.flutter_callkit_incoming;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.DisconnectCause;
import android.telecom.PhoneAccountHandle;
import android.util.Log;

/* loaded from: classes.dex */
public final class CallkitConnectionService extends ConnectionService {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CallkitConnectionSvc";

    public static final class Companion {
        public /* synthetic */ Companion(M5.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    private final Bundle extractCallBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(CallkitConnection.EXTRA_CALL_BUNDLE);
        if (bundle2 != null) {
            return bundle2;
        }
        Bundle bundle3 = bundle.getBundle("android.telecom.extra.INCOMING_CALL_EXTRAS");
        if (bundle3 != null) {
            Bundle bundle4 = bundle3.getBundle(CallkitConnection.EXTRA_CALL_BUNDLE);
            if (bundle4 != null) {
                return bundle4;
            }
            if (bundle3.containsKey("id")) {
                return bundle3;
            }
        }
        if (bundle.containsKey("id")) {
            return bundle;
        }
        return null;
    }

    private final Connection failed(String str) {
        Connection connectionCreateFailedConnection = Connection.createFailedConnection(new DisconnectCause(1, str));
        M5.m.d(connectionCreateFailedConnection, "createFailedConnection(...)");
        return connectionCreateFailedConnection;
    }

    @Override // android.telecom.ConnectionService
    public Connection onCreateIncomingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        Bundle bundleExtractCallBundle = extractCallBundle(connectionRequest != null ? connectionRequest.getExtras() : null);
        if (bundleExtractCallBundle == null) {
            Log.w(TAG, "onCreateIncomingConnection: missing call bundle");
            return failed("Missing call data");
        }
        Data dataFromBundle = Data.Companion.fromBundle(bundleExtractCallBundle);
        String id = dataFromBundle.getId();
        if (id.length() == 0) {
            Log.w(TAG, "onCreateIncomingConnection: empty call id");
            return failed("Empty call id");
        }
        Log.d(TAG, "onCreateIncomingConnection id=" + id + " caller=" + dataFromBundle.getNameCaller());
        Context applicationContext = getApplicationContext();
        M5.m.d(applicationContext, "getApplicationContext(...)");
        CallkitConnection callkitConnection = new CallkitConnection(applicationContext, id, bundleExtractCallBundle);
        if (dataFromBundle.getNameCaller().length() > 0) {
            callkitConnection.setCallerDisplayName(dataFromBundle.getNameCaller(), 1);
        }
        String handle = dataFromBundle.getHandle();
        if (handle.length() != 0) {
            id = handle;
        }
        callkitConnection.setAddress(Uri.fromParts("tel", id, null), 1);
        callkitConnection.setRinging();
        return callkitConnection;
    }

    @Override // android.telecom.ConnectionService
    public void onCreateIncomingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        super.onCreateIncomingConnectionFailed(phoneAccountHandle, connectionRequest);
        Log.w(TAG, "onCreateIncomingConnectionFailed");
    }

    @Override // android.telecom.ConnectionService
    public Connection onCreateOutgoingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        Bundle bundleExtractCallBundle = extractCallBundle(connectionRequest != null ? connectionRequest.getExtras() : null);
        if (bundleExtractCallBundle == null) {
            Log.w(TAG, "onCreateOutgoingConnection: missing call bundle");
            return failed("Missing call data");
        }
        Data dataFromBundle = Data.Companion.fromBundle(bundleExtractCallBundle);
        String id = dataFromBundle.getId();
        if (id.length() == 0) {
            Log.w(TAG, "onCreateOutgoingConnection: empty call id");
            return failed("Empty call id");
        }
        Log.d(TAG, "onCreateOutgoingConnection id=" + id + " callee=" + dataFromBundle.getNameCaller());
        Context applicationContext = getApplicationContext();
        M5.m.d(applicationContext, "getApplicationContext(...)");
        CallkitConnection callkitConnection = new CallkitConnection(applicationContext, id, bundleExtractCallBundle);
        if (dataFromBundle.getNameCaller().length() > 0) {
            callkitConnection.setCallerDisplayName(dataFromBundle.getNameCaller(), 1);
        }
        String handle = dataFromBundle.getHandle();
        if (handle.length() != 0) {
            id = handle;
        }
        callkitConnection.setAddress(Uri.fromParts("tel", id, null), 1);
        callkitConnection.setDialing();
        return callkitConnection;
    }

    @Override // android.telecom.ConnectionService
    public void onCreateOutgoingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        super.onCreateOutgoingConnectionFailed(phoneAccountHandle, connectionRequest);
        Log.w(TAG, "onCreateOutgoingConnectionFailed");
    }
}
