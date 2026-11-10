package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: androidx.core.view.animation.a$a, reason: collision with other inner class name */
    static class C0124a {
        static Interpolator a(float f12, float f13) {
            return new PathInterpolator(f12, f13);
        }

        static Interpolator b(float f12, float f13, float f14, float f15) {
            return new PathInterpolator(f12, f13, f14, f15);
        }

        static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f12, float f13, float f14, float f15) {
        return C0124a.b(f12, f13, f14, f15);
    }

    public static Interpolator b(Path path) {
        return C0124a.c(path);
    }
}
