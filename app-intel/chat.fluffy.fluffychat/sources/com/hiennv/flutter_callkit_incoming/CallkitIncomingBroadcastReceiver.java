package com.hiennv.flutter_callkit_incoming;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.util.Log;
import com.hiennv.flutter_callkit_incoming.CallkitEventCallback;
import com.hiennv.flutter_callkit_incoming.FlutterCallkitIncomingPlugin;
import java.util.Map;
import y5.AbstractC1816l;
import z5.C1866G;

/* loaded from: classes.dex */
public final class CallkitIncomingBroadcastReceiver extends BroadcastReceiver {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CallkitIncomingReceiver";
    private static boolean silenceEvents;

    public static final class Companion {
        public /* synthetic */ Companion(M5.g gVar) {
            this();
        }

        public final Intent getIntent(Context context, String str, Bundle bundle) {
            M5.m.e(context, "context");
            M5.m.e(str, "action");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + '.' + str);
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentAccept(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_ACCEPT");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentCallback(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_CALLBACK");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentConnected(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_CONNECTED");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentDecline(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_DECLINE");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentEnded(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_ENDED");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentHeldByCell(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_HELD");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentIncoming(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_INCOMING");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentStart(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_START");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentTimeout(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_TIMEOUT");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final Intent getIntentUnHeldByCell(Context context, Bundle bundle) {
            M5.m.e(context, "context");
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.hiennv.flutter_callkit_incoming.CallkitIncomingBroadcastReceiver");
            intent.setAction(context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_UNHELD");
            intent.putExtra(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA, bundle);
            intent.setPackage(context.getPackageName());
            return intent;
        }

        public final boolean getSilenceEvents() {
            return CallkitIncomingBroadcastReceiver.silenceEvents;
        }

        public final void setSilenceEvents(boolean z7) {
            CallkitIncomingBroadcastReceiver.silenceEvents = z7;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final void driveTelecomConnection(Context context, Bundle bundle, String str) {
        Data dataFromBundle;
        CallkitConnection callkitConnectionFind;
        try {
            dataFromBundle = Data.Companion.fromBundle(bundle);
        } catch (Exception unused) {
            dataFromBundle = null;
        }
        if (dataFromBundle == null || (callkitConnectionFind = CallkitConnection.Companion.find(dataFromBundle.getId())) == null) {
            return;
        }
        switch (str.hashCode()) {
            case -16145758:
                if (str.equals(CallkitConstants.ACTION_CALL_CONNECTED)) {
                    callkitConnectionFind.markAccepted();
                    break;
                }
                break;
            case 282601679:
                if (str.equals(CallkitConstants.ACTION_CALL_DECLINE)) {
                    callkitConnectionFind.markDeclined(context);
                    break;
                }
                break;
            case 1029753839:
                if (str.equals(CallkitConstants.ACTION_CALL_ACCEPT)) {
                    callkitConnectionFind.markAccepted();
                    break;
                }
                break;
            case 1721307962:
                if (str.equals(CallkitConstants.ACTION_CALL_TIMEOUT)) {
                    callkitConnectionFind.markMissed();
                    break;
                }
                break;
            case 2115450579:
                if (str.equals(CallkitConstants.ACTION_CALL_ENDED)) {
                    callkitConnectionFind.markEnded();
                    break;
                }
                break;
        }
    }

    private final CallkitNotificationManager getCallkitNotificationManager() {
        FlutterCallkitIncomingPlugin companion = FlutterCallkitIncomingPlugin.Companion.getInstance();
        if (companion != null) {
            return companion.getCallkitNotificationManager();
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private final void registerTelecomIncomingCall(Context context, Bundle bundle) {
        Data dataFromBundle;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            dataFromBundle = Data.Companion.fromBundle(bundle);
        } catch (Exception unused) {
            dataFromBundle = null;
        }
        if (dataFromBundle == null || dataFromBundle.getId().length() == 0) {
            return;
        }
        if (CallkitConnection.Companion.find(dataFromBundle.getId()) != null) {
            Log.d(TAG, "Telecom call already registered id=" + dataFromBundle.getId() + " — skip");
            return;
        }
        if (L.b.a(context, "android.permission.MANAGE_OWN_CALLS") != 0) {
            Log.w(TAG, "MANAGE_OWN_CALLS not granted — Telecom incoming skipped");
            return;
        }
        Object systemService = context.getSystemService("telecom");
        TelecomManager telecomManager = systemService instanceof TelecomManager ? (TelecomManager) systemService : null;
        if (telecomManager == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        M5.m.d(applicationContext, "getApplicationContext(...)");
        PhoneAccountHandle phoneAccountHandle = new InAppCallManager(applicationContext).getPhoneAccountHandle();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CallkitConnection.EXTRA_CALL_BUNDLE, bundle);
        bundle2.putInt("android.telecom.extra.INCOMING_VIDEO_STATE", 0);
        try {
            telecomManager.addNewIncomingCall(phoneAccountHandle, bundle2);
            Log.d(TAG, "Telecom addNewIncomingCall id=" + dataFromBundle.getId());
        } catch (SecurityException e7) {
            Log.w(TAG, "Telecom addNewIncomingCall rejected: " + e7.getMessage());
        } catch (Exception e8) {
            Log.w(TAG, "Telecom addNewIncomingCall error: " + e8.getMessage());
        }
    }

    @SuppressLint({"MissingPermission"})
    private final void registerTelecomOutgoingCall(Context context, Bundle bundle) {
        Data dataFromBundle;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            dataFromBundle = Data.Companion.fromBundle(bundle);
        } catch (Exception unused) {
            dataFromBundle = null;
        }
        if (dataFromBundle == null || dataFromBundle.getId().length() == 0) {
            return;
        }
        if (CallkitConnection.Companion.find(dataFromBundle.getId()) != null) {
            Log.d(TAG, "Telecom call already registered id=" + dataFromBundle.getId() + " — skip");
            return;
        }
        if (L.b.a(context, "android.permission.MANAGE_OWN_CALLS") != 0) {
            Log.w(TAG, "MANAGE_OWN_CALLS not granted — Telecom outgoing skipped");
            return;
        }
        Object systemService = context.getSystemService("telecom");
        TelecomManager telecomManager = systemService instanceof TelecomManager ? (TelecomManager) systemService : null;
        if (telecomManager == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        M5.m.d(applicationContext, "getApplicationContext(...)");
        PhoneAccountHandle phoneAccountHandle = new InAppCallManager(applicationContext).getPhoneAccountHandle();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CallkitConnection.EXTRA_CALL_BUNDLE, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putParcelable("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        bundle3.putBundle("android.telecom.extra.OUTGOING_CALL_EXTRAS", bundle2);
        String handle = dataFromBundle.getHandle();
        if (handle.length() == 0) {
            handle = dataFromBundle.getId();
        }
        try {
            telecomManager.placeCall(Uri.fromParts("tel", handle, null), bundle3);
            Log.d(TAG, "Telecom placeCall id=" + dataFromBundle.getId());
        } catch (SecurityException e7) {
            Log.w(TAG, "Telecom placeCall rejected: " + e7.getMessage());
        } catch (Exception e8) {
            Log.w(TAG, "Telecom placeCall error: " + e8.getMessage());
        }
    }

    private final void sendEventFlutter(String str, Bundle bundle) {
        if (silenceEvents) {
            return;
        }
        Map mapK = C1866G.k(AbstractC1816l.a("isCustomNotification", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_CUSTOM_NOTIFICATION, false))), AbstractC1816l.a("isCustomSmallExNotification", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_CUSTOM_SMALL_EX_NOTIFICATION, false))), AbstractC1816l.a("ringtonePath", bundle.getString(CallkitConstants.EXTRA_CALLKIT_RINGTONE_PATH, "")), AbstractC1816l.a("backgroundColor", bundle.getString(CallkitConstants.EXTRA_CALLKIT_BACKGROUND_COLOR, "")), AbstractC1816l.a("backgroundUrl", bundle.getString(CallkitConstants.EXTRA_CALLKIT_BACKGROUND_URL, "")), AbstractC1816l.a("actionColor", bundle.getString(CallkitConstants.EXTRA_CALLKIT_ACTION_COLOR, "")), AbstractC1816l.a("textColor", bundle.getString(CallkitConstants.EXTRA_CALLKIT_TEXT_COLOR, "")), AbstractC1816l.a("incomingCallNotificationChannelName", bundle.getString(CallkitConstants.EXTRA_CALLKIT_INCOMING_CALL_NOTIFICATION_CHANNEL_NAME, "")), AbstractC1816l.a("missedCallNotificationChannelName", bundle.getString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_NOTIFICATION_CHANNEL_NAME, "")), AbstractC1816l.a("isImportant", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_IMPORTANT, true))), AbstractC1816l.a("isBot", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_BOT, false))));
        FlutterCallkitIncomingPlugin.Companion.sendEvent(str, C1866G.k(AbstractC1816l.a("id", bundle.getString(CallkitConstants.EXTRA_CALLKIT_ID, "")), AbstractC1816l.a("nameCaller", bundle.getString(CallkitConstants.EXTRA_CALLKIT_NAME_CALLER, "")), AbstractC1816l.a("avatar", bundle.getString(CallkitConstants.EXTRA_CALLKIT_AVATAR, "")), AbstractC1816l.a("number", bundle.getString(CallkitConstants.EXTRA_CALLKIT_HANDLE, "")), AbstractC1816l.a("type", Integer.valueOf(bundle.getInt(CallkitConstants.EXTRA_CALLKIT_TYPE, 0))), AbstractC1816l.a("duration", Long.valueOf(bundle.getLong(CallkitConstants.EXTRA_CALLKIT_DURATION, 0L))), AbstractC1816l.a("textAccept", bundle.getString(CallkitConstants.EXTRA_CALLKIT_TEXT_ACCEPT, "")), AbstractC1816l.a("textDecline", bundle.getString(CallkitConstants.EXTRA_CALLKIT_TEXT_DECLINE, "")), AbstractC1816l.a("acceptColor", bundle.getString(CallkitConstants.EXTRA_CALLKIT_ACCEPT_COLOR, "")), AbstractC1816l.a("declineColor", bundle.getString(CallkitConstants.EXTRA_CALLKIT_DECLINE_COLOR, "")), AbstractC1816l.a("extra", bundle.getSerializable(CallkitConstants.EXTRA_CALLKIT_EXTRA)), AbstractC1816l.a("missedCallNotification", C1866G.k(AbstractC1816l.a("id", Integer.valueOf(bundle.getInt(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_ID))), AbstractC1816l.a("showNotification", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_SHOW))), AbstractC1816l.a("count", Integer.valueOf(bundle.getInt(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_COUNT))), AbstractC1816l.a("subtitle", bundle.getString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_SUBTITLE)), AbstractC1816l.a("callbackText", bundle.getString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_CALLBACK_TEXT)), AbstractC1816l.a("isShowCallback", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_CALLBACK_SHOW))))), AbstractC1816l.a("callingNotification", C1866G.k(AbstractC1816l.a("id", bundle.getString(CallkitConstants.EXTRA_CALLKIT_CALLING_ID)), AbstractC1816l.a("showNotification", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_CALLING_SHOW))), AbstractC1816l.a("subtitle", bundle.getString(CallkitConstants.EXTRA_CALLKIT_CALLING_SUBTITLE)), AbstractC1816l.a("callbackText", bundle.getString(CallkitConstants.EXTRA_CALLKIT_CALLING_HANG_UP_TEXT)), AbstractC1816l.a("isShowCallback", Boolean.valueOf(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_CALLING_HANG_UP_SHOW))))), AbstractC1816l.a("android", mapK)));
    }

    @Override // android.content.BroadcastReceiver
    @SuppressLint({"MissingPermission"})
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        Bundle bundle;
        M5.m.e(context, "context");
        M5.m.e(intent, "intent");
        String action = intent.getAction();
        if (action == null || (extras = intent.getExtras()) == null || (bundle = extras.getBundle(CallkitConstants.EXTRA_CALLKIT_INCOMING_DATA)) == null) {
            return;
        }
        Log.d(TAG, action);
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_INCOMING")) {
            try {
                registerTelecomIncomingCall(context, bundle);
                Data dataFromBundle = Data.Companion.fromBundle(bundle);
                if (dataFromBundle.isFullScreen()) {
                    context.startActivity(CallkitIncomingActivity.Companion.getIntent(context, bundle));
                    return;
                }
                CallkitNotificationManager callkitNotificationManager = getCallkitNotificationManager();
                if (callkitNotificationManager != null) {
                    callkitNotificationManager.showIncomingNotification(bundle);
                }
                sendEventFlutter(CallkitConstants.ACTION_CALL_INCOMING, bundle);
                SharedPreferencesUtilsKt.addCall$default(context, dataFromBundle, false, 4, null);
                return;
            } catch (Exception e7) {
                Log.e(TAG, null, e7);
                return;
            }
        }
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_START")) {
            try {
                registerTelecomOutgoingCall(context, bundle);
                CallkitNotificationService.Companion.startServiceWithAction(context, CallkitConstants.ACTION_CALL_START, bundle);
                sendEventFlutter(CallkitConstants.ACTION_CALL_START, bundle);
                SharedPreferencesUtilsKt.addCall(context, Data.Companion.fromBundle(bundle), true);
                return;
            } catch (Exception e8) {
                Log.e(TAG, null, e8);
                return;
            }
        }
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_ACCEPT")) {
            try {
                driveTelecomConnection(context, bundle, CallkitConstants.ACTION_CALL_ACCEPT);
                FlutterCallkitIncomingPlugin.Companion companion = FlutterCallkitIncomingPlugin.Companion;
                companion.notifyEventCallbacks$flutter_callkit_incoming_release(CallkitEventCallback.CallEvent.ACCEPT, bundle);
                CallkitNotificationService.Companion.startServiceWithAction(context, CallkitConstants.ACTION_CALL_ACCEPT, bundle);
                sendEventFlutter(CallkitConstants.ACTION_CALL_ACCEPT, bundle);
                SharedPreferencesUtilsKt.addCall(context, Data.Companion.fromBundle(bundle), true);
                companion.acceptCallHandleCallback(bundle);
                return;
            } catch (Exception e9) {
                Log.e(TAG, null, e9);
                return;
            }
        }
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_DECLINE")) {
            try {
                driveTelecomConnection(context, bundle, CallkitConstants.ACTION_CALL_DECLINE);
                FlutterCallkitIncomingPlugin.Companion.notifyEventCallbacks$flutter_callkit_incoming_release(CallkitEventCallback.CallEvent.DECLINE, bundle);
                CallkitNotificationManager callkitNotificationManager2 = getCallkitNotificationManager();
                if (callkitNotificationManager2 != null) {
                    callkitNotificationManager2.clearIncomingNotification(bundle, false);
                }
                sendEventFlutter(CallkitConstants.ACTION_CALL_DECLINE, bundle);
                SharedPreferencesUtilsKt.removeCall(context, Data.Companion.fromBundle(bundle));
                return;
            } catch (Exception e10) {
                Log.e(TAG, null, e10);
                return;
            }
        }
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_ENDED")) {
            try {
                driveTelecomConnection(context, bundle, CallkitConstants.ACTION_CALL_ENDED);
                FlutterCallkitIncomingPlugin.Companion.notifyEventCallbacks$flutter_callkit_incoming_release(CallkitEventCallback.CallEvent.END, bundle);
                CallkitNotificationManager callkitNotificationManager3 = getCallkitNotificationManager();
                if (callkitNotificationManager3 != null) {
                    callkitNotificationManager3.clearIncomingNotification(bundle, false);
                }
                CallkitNotificationService.Companion.stopService(context);
                sendEventFlutter(CallkitConstants.ACTION_CALL_ENDED, bundle);
                SharedPreferencesUtilsKt.removeCall(context, Data.Companion.fromBundle(bundle));
                return;
            } catch (Exception e11) {
                Log.e(TAG, null, e11);
                return;
            }
        }
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_TIMEOUT")) {
            try {
                driveTelecomConnection(context, bundle, CallkitConstants.ACTION_CALL_TIMEOUT);
                CallkitNotificationManager callkitNotificationManager4 = getCallkitNotificationManager();
                if (callkitNotificationManager4 != null) {
                    callkitNotificationManager4.clearIncomingNotification(bundle, false);
                }
                if (callkitNotificationManager4 != null) {
                    callkitNotificationManager4.showMissCallNotification(bundle);
                }
                sendEventFlutter(CallkitConstants.ACTION_CALL_TIMEOUT, bundle);
                SharedPreferencesUtilsKt.removeCall(context, Data.Companion.fromBundle(bundle));
                return;
            } catch (Exception e12) {
                Log.e(TAG, null, e12);
                return;
            }
        }
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_CONNECTED")) {
            try {
                driveTelecomConnection(context, bundle, CallkitConstants.ACTION_CALL_CONNECTED);
                CallkitNotificationManager callkitNotificationManager5 = getCallkitNotificationManager();
                if (callkitNotificationManager5 != null) {
                    callkitNotificationManager5.showOngoingCallNotification(bundle, Boolean.TRUE);
                }
                sendEventFlutter(CallkitConstants.ACTION_CALL_CONNECTED, bundle);
                return;
            } catch (Exception e13) {
                Log.e(TAG, null, e13);
                return;
            }
        }
        if (M5.m.a(action, context.getPackageName() + ".com.hiennv.flutter_callkit_incoming.ACTION_CALL_CALLBACK")) {
            try {
                CallkitNotificationManager callkitNotificationManager6 = getCallkitNotificationManager();
                if (callkitNotificationManager6 != null) {
                    callkitNotificationManager6.clearMissCallNotification(bundle);
                }
                sendEventFlutter(CallkitConstants.ACTION_CALL_CALLBACK, bundle);
                if (Build.VERSION.SDK_INT < 31) {
                    context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                }
            } catch (Exception e14) {
                Log.e(TAG, null, e14);
            }
        }
    }
}
