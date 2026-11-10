package r2;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f22123a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f22124b;

    public f(Drawable drawable, boolean z7) {
        M5.m.e(drawable, "drawable");
        this.f22123a = drawable;
        this.f22124b = z7;
    }

    public final Drawable a() {
        return this.f22123a;
    }

    public final boolean b() {
        return this.f22124b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return M5.m.a(this.f22123a, fVar.f22123a) && this.f22124b == fVar.f22124b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.f22123a.hashCode() * 31;
        boolean z7 = this.f22124b;
        int i7 = z7;
        if (z7 != 0) {
            i7 = 1;
        }
        return iHashCode + i7;
    }

    public String toString() {
        return "DecodeResult(drawable=" + this.f22123a + ", isSampled=" + this.f22124b + ')';
    }
}
