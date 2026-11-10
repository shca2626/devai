package D1;

import java.util.List;

/* loaded from: classes.dex */
public abstract class q extends H0.g implements k {

    /* renamed from: p, reason: collision with root package name */
    public k f1635p;

    /* renamed from: q, reason: collision with root package name */
    public long f1636q;

    @Override // D1.k
    public int a(long j7) {
        return ((k) j3.o.q(this.f1635p)).a(j7 - this.f1636q);
    }

    @Override // D1.k
    public long d(int i7) {
        return ((k) j3.o.q(this.f1635p)).d(i7) + this.f1636q;
    }

    @Override // D1.k
    public List e(long j7) {
        return ((k) j3.o.q(this.f1635p)).e(j7 - this.f1636q);
    }

    @Override // D1.k
    public int f() {
        return ((k) j3.o.q(this.f1635p)).f();
    }

    @Override // H0.g, H0.a
    public void i() {
        super.i();
        this.f1635p = null;
    }

    public void s(long j7, k kVar, long j8) {
        this.f3338m = j7;
        this.f1635p = kVar;
        if (j8 != Long.MAX_VALUE) {
            j7 = j8;
        }
        this.f1636q = j7;
    }
}
