package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes8.dex */
public final class zzct {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    public static PendingIntent zza(Context context, int i12, Intent intent, int i13) {
        return PendingIntent.getBroadcast(context, 0, intent, i13);
    }
}
