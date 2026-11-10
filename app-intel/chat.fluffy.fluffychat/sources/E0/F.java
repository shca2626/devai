package E0;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: c, reason: collision with root package name */
    public static final F f2030c = new F(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    public static final F f2031d = new F(0, 0);

    /* renamed from: e, reason: collision with root package name */
    public static final String f2032e = U.A0(0);

    /* renamed from: f, reason: collision with root package name */
    public static final String f2033f = U.A0(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f2034a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2035b;

    public F(int i7, int i8) {
        j3.o.d((i7 == -1 || i7 >= 0) && (i8 == -1 || i8 >= 0));
        this.f2034a = i7;
        this.f2035b = i8;
    }

    public int a() {
        return this.f2035b;
    }

    public int b() {
        return this.f2034a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof F) {
            F f7 = (F) obj;
            if (this.f2034a == f7.f2034a && this.f2035b == f7.f2035b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = this.f2035b;
        int i8 = this.f2034a;
        return i7 ^ ((i8 >>> 16) | (i8 << 16));
    }

    public String toString() {
        return this.f2034a + "x" + this.f2035b;
    }
}
