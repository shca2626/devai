package com.github.dart_lang.jni;

import C5.e;
import C5.i;
import W5.C0613c0;

/* loaded from: classes.dex */
public class PortContinuation<T> implements e {
    private final long port;

    static {
        System.loadLibrary("dartjni");
    }

    public PortContinuation(long j7) {
        this.port = j7;
    }

    private native void _resumeWith(long j7, Object obj);

    @Override // C5.e
    public i getContext() {
        return C0613c0.b();
    }

    @Override // C5.e
    public void resumeWith(Object obj) {
        _resumeWith(this.port, obj);
    }
}
