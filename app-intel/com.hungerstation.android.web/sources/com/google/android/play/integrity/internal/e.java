package com.google.android.play.integrity.internal;

import android.content.Context;

/* loaded from: classes8.dex */
public final class e {
    public static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }
}
