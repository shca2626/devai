package com.google.android.material.internal;

/* loaded from: classes8.dex */
final class g {
    static void a(float f12, float[] fArr) {
        if (f12 <= 0.5f) {
            fArr[0] = 1.0f - (f12 * 2.0f);
            fArr[1] = 0.0f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = (f12 * 2.0f) - 1.0f;
        }
    }
}
