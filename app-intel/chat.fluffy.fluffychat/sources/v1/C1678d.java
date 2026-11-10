package v1;

import B0.y;

/* renamed from: v1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1678d implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f22909a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22910b;

    public C1678d(float f7, int i7) {
        this.f22909a = f7;
        this.f22910b = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1678d.class == obj.getClass()) {
            C1678d c1678d = (C1678d) obj;
            if (this.f22909a == c1678d.f22909a && this.f22910b == c1678d.f22910b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + o3.d.a(this.f22909a)) * 31) + this.f22910b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f22909a + ", svcTemporalLayerCount=" + this.f22910b;
    }
}
