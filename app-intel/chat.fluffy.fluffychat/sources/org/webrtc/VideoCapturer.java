package org.webrtc;

import android.content.Context;

/* loaded from: classes3.dex */
public interface VideoCapturer {
    void changeCaptureFormat(int i7, int i8, int i9);

    void dispose();

    void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver);

    boolean isScreencast();

    void startCapture(int i7, int i8, int i9);

    void stopCapture();
}
