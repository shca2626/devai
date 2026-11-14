package r2;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f22129a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f22130b;

    public f(Drawable drawable, boolean z7) {
        M5.m.e(drawable, "drawable");
        this.f22129a = drawable;
        this.f22130b = z7;
    }

    public final Drawable a() {
        return this.f22129a;
    }

    public final boolean b() {
        return this.f22130b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return M5.m.a(this.f22129a, fVar.f22129a) && this.f22130b == fVar.f22130b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.f22129a.hashCode() * 31;
        boolean z7 = this.f22130b;
        int i7 = z7;
        if (z7 != 0) {
            i7 = 1;
        }
        return iHashCode + i7;
    }

    public String toString() {
        return "DecodeResult(drawable=" + this.f22129a + ", isSampled=" + this.f22130b + ')';
    }
}
