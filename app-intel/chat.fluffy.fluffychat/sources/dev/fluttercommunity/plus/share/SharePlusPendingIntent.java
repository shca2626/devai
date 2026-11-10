package dev.fluttercommunity.plus.share;

import M5.g;
import M5.m;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public final class SharePlusPendingIntent extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15312a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static String f15313b = "";

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return SharePlusPendingIntent.f15313b;
        }

        public final void b(String str) {
            m.e(str, "<set-?>");
            SharePlusPendingIntent.f15313b = str;
        }

        public a() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m.e(context, "context");
        m.e(intent, "intent");
        ComponentName componentName = Build.VERSION.SDK_INT >= 33 ? (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", ComponentName.class) : (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
        if (componentName != null) {
            String strFlattenToString = componentName.flattenToString();
            m.d(strFlattenToString, "flattenToString(...)");
            f15313b = strFlattenToString;
        }
    }
}
