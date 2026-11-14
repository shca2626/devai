package c0;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* renamed from: c0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0893d {

    /* renamed from: c0.d$a */
    public static class a {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f7, float f8) {
            try {
                return edgeEffect.onPullDistance(f7, f8);
            } catch (Throwable unused) {
                edgeEffect.onPull(f7, f8);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? a.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float b(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return a.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void c(EdgeEffect edgeEffect, float f7, float f8) {
        edgeEffect.onPull(f7, f8);
    }

    public static float d(EdgeEffect edgeEffect, float f7, float f8) {
        if (Build.VERSION.SDK_INT >= 31) {
            return a.c(edgeEffect, f7, f8);
        }
        c(edgeEffect, f7, f8);
        return f7;
    }
}
