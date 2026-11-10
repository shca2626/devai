package org.webrtc;

/* loaded from: classes3.dex */
interface BitrateAdjuster {
    int getAdjustedBitrateBps();

    double getAdjustedFramerateFps();

    void reportEncodedFrame(int i7);

    void setTargets(int i7, double d7);
}
