package P2;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import t0.C1621a;
import t0.C1622b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f7542a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f7543b = new C1622b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f7544c = new C1621a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f7545d = new t0.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f7546e = new DecelerateInterpolator();

    public static float a(float f7, float f8, float f9) {
        return f7 + (f9 * (f8 - f7));
    }

    public static float b(float f7, float f8, float f9, float f10, float f11) {
        return f11 < f9 ? f7 : f11 > f10 ? f8 : a(f7, f8, (f11 - f9) / (f10 - f9));
    }

    public static int c(int i7, int i8, float f7) {
        return i7 + Math.round(f7 * (i8 - i7));
    }
}
