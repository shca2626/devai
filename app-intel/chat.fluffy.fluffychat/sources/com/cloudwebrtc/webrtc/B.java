package com.cloudwebrtc.webrtc;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final /* synthetic */ class B implements Runnable {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f14071l;

    @Override // java.lang.Runnable
    public final void run() {
        this.f14071l.countDown();
    }
}
