package k2;

import android.view.DisplayCutout;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f18831a = new m();

    public final int a(DisplayCutout displayCutout) {
        M5.m.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        M5.m.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        M5.m.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        M5.m.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
