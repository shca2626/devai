package com.hiennv.flutter_callkit_incoming;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.util.Log;

/* loaded from: classes.dex */
public final class InAppCallManager {
    private static final String ACCOUNT_ID = "flutter_callkit_incoming_in_app_call_account";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "InAppCallManager";
    private final Context context;

    public static final class Companion {
        public /* synthetic */ Companion(M5.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public InAppCallManager(Context context) {
        M5.m.e(context, "context");
        this.context = context;
    }

    public final PhoneAccountHandle getPhoneAccountHandle() {
        return new PhoneAccountHandle(new ComponentName(this.context, (Class<?>) CallkitConnectionService.class), ACCOUNT_ID);
    }

    public final void registerPhoneAccount() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            Object systemService = this.context.getSystemService("telecom");
            TelecomManager telecomManager = systemService instanceof TelecomManager ? (TelecomManager) systemService : null;
            if (telecomManager == null) {
                return;
            }
            telecomManager.registerPhoneAccount(PhoneAccount.builder(new PhoneAccountHandle(new ComponentName(this.context, (Class<?>) CallkitConnectionService.class), ACCOUNT_ID), "Callkit Incoming In-App Call").setCapabilities(2048).build());
            Log.d(TAG, "PhoneAccount registered.");
        } catch (Exception e7) {
            Log.e(TAG, "registerPhoneAccount failed — self-managed Telecom unavailable", e7);
        }
    }

    public final void unregisterPhoneAccount() {
        try {
            Object systemService = this.context.getSystemService("telecom");
            TelecomManager telecomManager = systemService instanceof TelecomManager ? (TelecomManager) systemService : null;
            if (telecomManager == null) {
                return;
            }
            telecomManager.unregisterPhoneAccount(new PhoneAccountHandle(new ComponentName(this.context, (Class<?>) CallkitConnectionService.class), ACCOUNT_ID));
            Log.d(TAG, "PhoneAccount unregistered.");
        } catch (Exception e7) {
            Log.e(TAG, "unregisterPhoneAccount failed", e7);
        }
    }
}
