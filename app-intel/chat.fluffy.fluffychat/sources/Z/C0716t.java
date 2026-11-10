package Z;

import android.os.Build;
import android.view.DisplayCutout;

/* renamed from: Z.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0716t {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f10071a;

    /* renamed from: Z.t$a */
    public static class a {
        public static int a(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        public static int b(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    public C0716t(DisplayCutout displayCutout) {
        this.f10071a = displayCutout;
    }

    public static C0716t e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C0716t(displayCutout);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.a(this.f10071a);
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.b(this.f10071a);
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.c(this.f10071a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.d(this.f10071a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0716t.class != obj.getClass()) {
            return false;
        }
        return Y.c.a(this.f10071a, ((C0716t) obj).f10071a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f10071a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f10071a + "}";
    }
}
