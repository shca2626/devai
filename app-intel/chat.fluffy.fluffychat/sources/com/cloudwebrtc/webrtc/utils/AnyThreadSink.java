package com.cloudwebrtc.webrtc.utils;

import android.os.Handler;
import android.os.Looper;
import h5.c;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AnyThreadSink implements c.b {
    private final c.b eventSink;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public AnyThreadSink(c.b bVar) {
        this.eventSink = bVar;
    }

    private void post(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.handler.post(runnable);
        }
    }

    @Override // h5.c.b
    public void endOfStream() {
        final c.b bVar = this.eventSink;
        Objects.requireNonNull(bVar);
        post(new Runnable() { // from class: com.cloudwebrtc.webrtc.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                bVar.endOfStream();
            }
        });
    }

    @Override // h5.c.b
    public void error(final String str, final String str2, final Object obj) {
        post(new Runnable() { // from class: com.cloudwebrtc.webrtc.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f14146l.eventSink.error(str, str2, obj);
            }
        });
    }

    @Override // h5.c.b
    public void success(final Object obj) {
        post(new Runnable() { // from class: com.cloudwebrtc.webrtc.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f14144l.eventSink.success(obj);
            }
        });
    }
}
