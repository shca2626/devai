package F0;

import B0.y;
import j3.o;

/* loaded from: classes.dex */
public final class f implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f2474a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2475b;

    public f(float f7, float f8) {
        o.e(f7 >= -90.0f && f7 <= 90.0f && f8 >= -180.0f && f8 <= 180.0f, "Invalid latitude or longitude");
        this.f2474a = f7;
        this.f2475b = f8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f2474a == fVar.f2474a && this.f2475b == fVar.f2475b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + o3.d.a(this.f2474a)) * 31) + o3.d.a(this.f2475b);
    }

    public String toString() {
        return "xyz: latitude=" + this.f2474a + ", longitude=" + this.f2475b;
    }
}
