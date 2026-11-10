package O1;

import E0.U;
import g1.N;
import g1.O;

/* loaded from: classes.dex */
public final class e implements N {

    /* renamed from: a, reason: collision with root package name */
    public final c f6726a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6727b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6728c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6729d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6730e;

    public e(c cVar, int i7, long j7, long j8) {
        this.f6726a = cVar;
        this.f6727b = i7;
        this.f6728c = j7;
        long j9 = (j8 - j7) / cVar.f6719e;
        this.f6729d = j9;
        this.f6730e = b(j9);
    }

    public final long b(long j7) {
        return U.d1(j7 * this.f6727b, 1000000L, this.f6726a.f6717c);
    }

    @Override // g1.N
    public boolean e() {
        return true;
    }

    @Override // g1.N
    public N.a g(long j7) {
        long jP = U.p((this.f6726a.f6717c * j7) / (this.f6727b * 1000000), 0L, this.f6729d - 1);
        long j8 = this.f6728c + (this.f6726a.f6719e * jP);
        long jB = b(jP);
        O o7 = new O(jB, j8);
        if (jB >= j7 || jP == this.f6729d - 1) {
            return new N.a(o7);
        }
        long j9 = jP + 1;
        return new N.a(o7, new O(b(j9), this.f6728c + (this.f6726a.f6719e * j9)));
    }

    @Override // g1.N
    public long i() {
        return this.f6730e;
    }
}
