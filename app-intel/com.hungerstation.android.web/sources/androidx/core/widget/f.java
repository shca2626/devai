package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes7.dex */
    static class a {
        static void a(EdgeEffect edgeEffect, float f12, float f13) {
            edgeEffect.onPull(f12, f13);
        }
    }

    private static class b {
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
                return BitmapDescriptorFactory.HUE_RED;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f12, float f13) {
            try {
                return edgeEffect.onPullDistance(f12, f13);
            } catch (Throwable unused) {
                edgeEffect.onPull(f12, f13);
                return BitmapDescriptorFactory.HUE_RED;
            }
        }
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? b.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float b(EdgeEffect edgeEffect) {
        return Build.VERSION.SDK_INT >= 31 ? b.b(edgeEffect) : BitmapDescriptorFactory.HUE_RED;
    }

    public static void c(EdgeEffect edgeEffect, float f12, float f13) {
        a.a(edgeEffect, f12, f13);
    }

    public static float d(EdgeEffect edgeEffect, float f12, float f13) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.c(edgeEffect, f12, f13);
        }
        c(edgeEffect, f12, f13);
        return f12;
    }
}
