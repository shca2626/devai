package L0;

import g1.C1078g;

/* loaded from: classes.dex */
public final class i implements g {

    /* renamed from: a, reason: collision with root package name */
    public final C1078g f5432a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5433b;

    public i(C1078g c1078g, long j7) {
        this.f5432a = c1078g;
        this.f5433b = j7;
    }

    @Override // L0.g
    public long a(long j7) {
        return this.f5432a.f16089e[(int) j7] - this.f5433b;
    }

    @Override // L0.g
    public long b(long j7, long j8) {
        return this.f5432a.f16088d[(int) j7];
    }

    @Override // L0.g
    public long c(long j7, long j8) {
        return 0L;
    }

    @Override // L0.g
    public long d(long j7, long j8) {
        return -9223372036854775807L;
    }

    @Override // L0.g
    public M0.i e(long j7) {
        return new M0.i(null, this.f5432a.f16087c[(int) j7], r1.f16086b[r7]);
    }

    @Override // L0.g
    public long f(long j7, long j8) {
        return this.f5432a.b(j7 + this.f5433b);
    }

    @Override // L0.g
    public boolean g() {
        return true;
    }

    @Override // L0.g
    public long h() {
        return 0L;
    }

    @Override // L0.g
    public long i(long j7) {
        return this.f5432a.f16085a;
    }

    @Override // L0.g
    public long j(long j7, long j8) {
        return this.f5432a.f16085a;
    }
}
