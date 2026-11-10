package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* loaded from: classes.dex */
public final class t {
    public static void a(int i12, int i13, int i14, Rect rect, Rect rect2, int i15) {
        Gravity.apply(i12, i13, i14, rect, rect2, i15);
    }

    public static int b(int i12, int i13) {
        return Gravity.getAbsoluteGravity(i12, i13);
    }
}
