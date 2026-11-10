package B0;

import E0.U;

/* loaded from: classes.dex */
public final class P {

    /* renamed from: e, reason: collision with root package name */
    public static final P f568e = new P(0, 0);

    /* renamed from: f, reason: collision with root package name */
    public static final String f569f = U.A0(0);

    /* renamed from: g, reason: collision with root package name */
    public static final String f570g = U.A0(1);

    /* renamed from: h, reason: collision with root package name */
    public static final String f571h = U.A0(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f572a;

    /* renamed from: b, reason: collision with root package name */
    public final int f573b;

    /* renamed from: c, reason: collision with root package name */
    public final int f574c;

    /* renamed from: d, reason: collision with root package name */
    public final float f575d;

    public P(int i7, int i8) {
        this(i7, i8, 1.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof P) {
            P p7 = (P) obj;
            if (this.f572a == p7.f572a && this.f573b == p7.f573b && this.f575d == p7.f575d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((217 + this.f572a) * 31) + this.f573b) * 31) + Float.floatToRawIntBits(this.f575d);
    }

    public P(int i7, int i8, float f7) {
        this.f572a = i7;
        this.f573b = i8;
        this.f574c = 0;
        this.f575d = f7;
    }
}
