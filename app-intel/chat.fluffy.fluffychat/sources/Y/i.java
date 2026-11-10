package Y;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final float f9357a;

    /* renamed from: b, reason: collision with root package name */
    public final float f9358b;

    public i(float f7, float f8) {
        this.f9357a = h.c(f7, "width");
        this.f9358b = h.c(f8, "height");
    }

    public float a() {
        return this.f9358b;
    }

    public float b() {
        return this.f9357a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return iVar.f9357a == this.f9357a && iVar.f9358b == this.f9358b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f9357a) ^ Float.floatToIntBits(this.f9358b);
    }

    public String toString() {
        return this.f9357a + "x" + this.f9358b;
    }
}
