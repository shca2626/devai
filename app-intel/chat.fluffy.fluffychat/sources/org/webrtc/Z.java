package org.webrtc;

import android.view.Choreographer;

/* loaded from: classes3.dex */
public final /* synthetic */ class Z implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RenderSynchronizer f20556a;

    public /* synthetic */ Z(RenderSynchronizer renderSynchronizer) {
        this.f20556a = renderSynchronizer;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j7) {
        this.f20556a.onDisplayRefreshCycleBegin(j7);
    }
}
