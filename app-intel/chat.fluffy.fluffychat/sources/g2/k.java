package g2;

import Z.C0701j0;
import android.graphics.Rect;
import d2.C0978b;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final C0978b f16208a;

    /* renamed from: b, reason: collision with root package name */
    public final C0701j0 f16209b;

    public k(C0978b c0978b, C0701j0 c0701j0) {
        M5.m.e(c0978b, "_bounds");
        M5.m.e(c0701j0, "_windowInsetsCompat");
        this.f16208a = c0978b;
        this.f16209b = c0701j0;
    }

    public final Rect a() {
        return this.f16208a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!M5.m.a(k.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        M5.m.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        k kVar = (k) obj;
        return M5.m.a(this.f16208a, kVar.f16208a) && M5.m.a(this.f16209b, kVar.f16209b);
    }

    public int hashCode() {
        return (this.f16208a.hashCode() * 31) + this.f16209b.hashCode();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this.f16208a + ", windowInsetsCompat=" + this.f16209b + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k(Rect rect, C0701j0 c0701j0, int i7, M5.g gVar) {
        if ((i7 & 2) != 0) {
            c0701j0 = new C0701j0.a().a();
            M5.m.d(c0701j0, "Builder().build()");
        }
        this(rect, c0701j0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Rect rect, C0701j0 c0701j0) {
        this(new C0978b(rect), c0701j0);
        M5.m.e(rect, "bounds");
        M5.m.e(c0701j0, "insets");
    }
}
