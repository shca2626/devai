package com.google.android.gms.analytics;

import android.os.Process;

/* loaded from: classes.dex */
final class zzq extends Thread {
    zzq(Runnable runnable, String str) {
        super(runnable, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        super.run();
    }
}
