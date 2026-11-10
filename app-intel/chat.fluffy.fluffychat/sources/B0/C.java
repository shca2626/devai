package B0;

import E0.U;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: d, reason: collision with root package name */
    public static final C f337d = new C(1.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final String f338e = U.A0(0);

    /* renamed from: f, reason: collision with root package name */
    public static final String f339f = U.A0(1);

    /* renamed from: a, reason: collision with root package name */
    public final float f340a;

    /* renamed from: b, reason: collision with root package name */
    public final float f341b;

    /* renamed from: c, reason: collision with root package name */
    public final int f342c;

    public C(float f7) {
        this(f7, 1.0f);
    }

    public long a(long j7) {
        return j7 * this.f342c;
    }

    public C b(float f7) {
        return new C(f7, this.f341b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C.class == obj.getClass()) {
            C c7 = (C) obj;
            if (this.f340a == c7.f340a && this.f341b == c7.f341b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f340a)) * 31) + Float.floatToRawIntBits(this.f341b);
    }

    public String toString() {
        return U.G("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f340a), Float.valueOf(this.f341b));
    }

    public C(float f7, float f8) {
        j3.o.d(f7 > 0.0f);
        j3.o.d(f8 > 0.0f);
        this.f340a = f7;
        this.f341b = f8;
        this.f342c = Math.round(f7 * 1000.0f);
    }
}
