package com.cloudwebrtc.webrtc.utils;

import android.os.Handler;
import android.os.Looper;
import h5.j;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AnyThreadResult implements j.d {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final j.d result;

    public AnyThreadResult(j.d dVar) {
        this.result = dVar;
    }

    private void post(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.handler.post(runnable);
        }
    }

    @Override // h5.j.d
    public void error(final String str, final String str2, final Object obj) {
        post(new Runnable() { // from class: com.cloudwebrtc.webrtc.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f14139l.result.error(str, str2, obj);
            }
        });
    }

    @Override // h5.j.d
    public void notImplemented() {
        j.d dVar = this.result;
        Objects.requireNonNull(dVar);
        post(new a(dVar));
    }

    @Override // h5.j.d
    public void success(final Object obj) {
        post(new Runnable() { // from class: com.cloudwebrtc.webrtc.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f14137l.result.success(obj);
            }
        });
    }
}
