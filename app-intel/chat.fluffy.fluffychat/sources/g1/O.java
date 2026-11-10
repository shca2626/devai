package g1;

/* loaded from: classes.dex */
public final class O {

    /* renamed from: c, reason: collision with root package name */
    public static final O f15970c = new O(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f15971a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15972b;

    public O(long j7, long j8) {
        this.f15971a = j7;
        this.f15972b = j8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && O.class == obj.getClass()) {
            O o7 = (O) obj;
            if (this.f15971a == o7.f15971a && this.f15972b == o7.f15972b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f15971a) * 31) + ((int) this.f15972b);
    }

    public String toString() {
        return "[timeUs=" + this.f15971a + ", position=" + this.f15972b + "]";
    }
}
