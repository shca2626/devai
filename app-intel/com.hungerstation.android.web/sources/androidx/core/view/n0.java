package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

/* loaded from: classes7.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    private final PointerIcon f6758a;

    static class a {
        static PointerIcon a(Bitmap bitmap, float f12, float f13) {
            return PointerIcon.create(bitmap, f12, f13);
        }

        static PointerIcon b(Context context, int i12) {
            return PointerIcon.getSystemIcon(context, i12);
        }

        static PointerIcon c(Resources resources, int i12) {
            return PointerIcon.load(resources, i12);
        }
    }

    private n0(PointerIcon pointerIcon) {
        this.f6758a = pointerIcon;
    }

    public static n0 b(Context context, int i12) {
        return Build.VERSION.SDK_INT >= 24 ? new n0(a.b(context, i12)) : new n0(null);
    }

    public Object a() {
        return this.f6758a;
    }
}
