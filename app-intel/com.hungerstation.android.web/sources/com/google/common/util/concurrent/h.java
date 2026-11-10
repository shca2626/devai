package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public final class h {
    public static <V> V a(Future<V> future) throws ExecutionException {
        V v12;
        boolean z12 = false;
        while (true) {
            try {
                v12 = future.get();
                break;
            } catch (InterruptedException unused) {
                z12 = true;
            } catch (Throwable th2) {
                if (z12) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z12) {
            Thread.currentThread().interrupt();
        }
        return v12;
    }
}
