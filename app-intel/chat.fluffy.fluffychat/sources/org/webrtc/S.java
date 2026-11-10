package org.webrtc;

import android.view.Choreographer;

/* loaded from: classes3.dex */
public final /* synthetic */ class S implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RenderSynchronizer f20549a;

    public /* synthetic */ S(RenderSynchronizer renderSynchronizer) {
        this.f20549a = renderSynchronizer;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j7) {
        this.f20549a.onDisplayRefreshCycleBegin(j7);
    }
}
