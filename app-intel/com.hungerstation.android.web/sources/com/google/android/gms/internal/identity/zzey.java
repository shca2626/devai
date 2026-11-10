package com.google.android.gms.internal.identity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public final class zzey {
    public static boolean zza(CountDownLatch countDownLatch, long j12, TimeUnit timeUnit) {
        boolean z12 = false;
        try {
            long nanos = timeUnit.toNanos(30L);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z12 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z12) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
