package I0;

import Y0.F;
import java.util.Objects;

/* renamed from: I0.g1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0370g1 {

    /* renamed from: a, reason: collision with root package name */
    public final F.b f4019a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4020b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4021c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4022d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4023e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4024f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4025g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4026h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4027i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4028j;

    public C0370g1(F.b bVar, long j7, long j8, long j9, long j10, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        boolean z12 = true;
        j3.o.d(!z11 || z9);
        j3.o.d(!z10 || z9);
        if (z8 && (z9 || z10 || z11)) {
            z12 = false;
        }
        j3.o.d(z12);
        this.f4019a = bVar;
        this.f4020b = j7;
        this.f4021c = j8;
        this.f4022d = j9;
        this.f4023e = j10;
        this.f4024f = z7;
        this.f4025g = z8;
        this.f4026h = z9;
        this.f4027i = z10;
        this.f4028j = z11;
    }

    public C0370g1 a(long j7) {
        return j7 == this.f4021c ? this : new C0370g1(this.f4019a, this.f4020b, j7, this.f4022d, this.f4023e, this.f4024f, this.f4025g, this.f4026h, this.f4027i, this.f4028j);
    }

    public C0370g1 b(long j7) {
        return j7 == this.f4020b ? this : new C0370g1(this.f4019a, j7, this.f4021c, this.f4022d, this.f4023e, this.f4024f, this.f4025g, this.f4026h, this.f4027i, this.f4028j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0370g1.class == obj.getClass()) {
            C0370g1 c0370g1 = (C0370g1) obj;
            if (this.f4020b == c0370g1.f4020b && this.f4021c == c0370g1.f4021c && this.f4022d == c0370g1.f4022d && this.f4023e == c0370g1.f4023e && this.f4024f == c0370g1.f4024f && this.f4025g == c0370g1.f4025g && this.f4026h == c0370g1.f4026h && this.f4027i == c0370g1.f4027i && this.f4028j == c0370g1.f4028j && Objects.equals(this.f4019a, c0370g1.f4019a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f4019a.hashCode()) * 31) + ((int) this.f4020b)) * 31) + ((int) this.f4021c)) * 31) + ((int) this.f4022d)) * 31) + ((int) this.f4023e)) * 31) + (this.f4024f ? 1 : 0)) * 31) + (this.f4025g ? 1 : 0)) * 31) + (this.f4026h ? 1 : 0)) * 31) + (this.f4027i ? 1 : 0)) * 31) + (this.f4028j ? 1 : 0);
    }
}
