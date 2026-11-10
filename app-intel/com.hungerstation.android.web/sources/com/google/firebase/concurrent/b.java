package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
class b implements ThreadFactory {

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f24186f = Executors.defaultThreadFactory();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f24187b = new AtomicLong();

    /* renamed from: c, reason: collision with root package name */
    private final String f24188c;

    /* renamed from: d, reason: collision with root package name */
    private final int f24189d;

    /* renamed from: e, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f24190e;

    b(String str, int i12, StrictMode.ThreadPolicy threadPolicy) {
        this.f24188c = str;
        this.f24189d = i12;
        this.f24190e = threadPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(this.f24189d);
        StrictMode.ThreadPolicy threadPolicy = this.f24190e;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f24186f.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                this.f24184b.b(runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f24188c, Long.valueOf(this.f24187b.getAndIncrement())));
        return threadNewThread;
    }
}
