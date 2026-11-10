package g1;

import g1.N;

/* renamed from: g1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1080j implements N {

    /* renamed from: a, reason: collision with root package name */
    public final long f16092a;

    /* renamed from: b, reason: collision with root package name */
    public final long f16093b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16094c;

    /* renamed from: d, reason: collision with root package name */
    public final long f16095d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16096e;

    /* renamed from: f, reason: collision with root package name */
    public final long f16097f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f16098g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16099h;

    public C1080j(long j7, long j8, int i7, int i8, boolean z7) {
        this(j7, j8, i7, i8, z7, true);
    }

    public static long k(long j7, long j8, int i7) {
        return (Math.max(0L, j7 - j8) * 8000000) / i7;
    }

    public final long b(long j7) {
        int i7 = this.f16094c;
        long jMin = (((j7 * this.f16096e) / 8000000) / i7) * i7;
        long j8 = this.f16095d;
        if (j8 != -1) {
            jMin = Math.min(jMin, j8 - i7);
        }
        return this.f16093b + Math.max(jMin, 0L);
    }

    @Override // g1.N
    public boolean e() {
        return this.f16095d != -1 || this.f16098g;
    }

    @Override // g1.N
    public boolean f() {
        return this.f16099h;
    }

    @Override // g1.N
    public N.a g(long j7) {
        if (this.f16095d == -1 && !this.f16098g) {
            return new N.a(new O(0L, this.f16093b));
        }
        long jB = b(j7);
        long j8 = j(jB);
        O o7 = new O(j8, jB);
        if (this.f16095d != -1 && j8 < j7) {
            int i7 = this.f16094c;
            if (i7 + jB < this.f16092a) {
                long j9 = jB + i7;
                return new N.a(o7, new O(j(j9), j9));
            }
        }
        return new N.a(o7);
    }

    @Override // g1.N
    public long i() {
        return this.f16097f;
    }

    public long j(long j7) {
        return k(j7, this.f16093b, this.f16096e);
    }

    public C1080j(long j7, long j8, int i7, int i8, boolean z7, boolean z8) {
        this.f16092a = j7;
        this.f16093b = j8;
        this.f16094c = i8 == -1 ? 1 : i8;
        this.f16096e = i7;
        this.f16098g = z7;
        this.f16099h = z8;
        if (j7 == -1) {
            this.f16095d = -1L;
            this.f16097f = -9223372036854775807L;
        } else {
            this.f16095d = j7 - j8;
            this.f16097f = k(j7, j8, i7);
        }
    }
}
