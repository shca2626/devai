package com.google.android.gms.internal.gtm;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class zzjo implements ThreadFactory {
    zzjo() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "google-tag-manager-scheduler-thread");
    }
}
