package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public interface f<V> extends Future<V> {
    void k(Runnable runnable, Executor executor);
}
