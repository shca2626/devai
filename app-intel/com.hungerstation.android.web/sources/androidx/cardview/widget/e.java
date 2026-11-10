package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f3122a = Math.cos(Math.toRadians(45.0d));

    static float a(float f12, float f13, boolean z12) {
        return z12 ? (float) (f12 + ((1.0d - f3122a) * f13)) : f12;
    }

    static float b(float f12, float f13, boolean z12) {
        return z12 ? (float) ((f12 * 1.5f) + ((1.0d - f3122a) * f13)) : f12 * 1.5f;
    }
}
