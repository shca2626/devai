package v1;

import B0.y;

/* renamed from: v1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1677d implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f22915a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22916b;

    public C1677d(float f7, int i7) {
        this.f22915a = f7;
        this.f22916b = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1677d.class == obj.getClass()) {
            C1677d c1677d = (C1677d) obj;
            if (this.f22915a == c1677d.f22915a && this.f22916b == c1677d.f22916b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + o3.d.a(this.f22915a)) * 31) + this.f22916b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f22915a + ", svcTemporalLayerCount=" + this.f22916b;
    }
}
