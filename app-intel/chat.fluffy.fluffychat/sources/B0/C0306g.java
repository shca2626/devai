package B0;

/* renamed from: B0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0306g {

    /* renamed from: a, reason: collision with root package name */
    public final int f635a;

    /* renamed from: b, reason: collision with root package name */
    public final float f636b;

    public C0306g(int i7, float f7) {
        this.f635a = i7;
        this.f636b = f7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0306g.class == obj.getClass()) {
            C0306g c0306g = (C0306g) obj;
            if (this.f635a == c0306g.f635a && Float.compare(c0306g.f636b, this.f636b) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f635a) * 31) + Float.floatToIntBits(this.f636b);
    }
}
