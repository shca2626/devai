package g1;

import g1.N;

/* loaded from: classes.dex */
public final class Q implements N {

    /* renamed from: a, reason: collision with root package name */
    public final long f15980a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15981b;

    public Q(long j7) {
        this(j7, 0L);
    }

    @Override // g1.N
    public boolean e() {
        return true;
    }

    @Override // g1.N
    public N.a g(long j7) {
        return new N.a(new O(j7, this.f15981b));
    }

    @Override // g1.N
    public long i() {
        return this.f15980a;
    }

    public Q(long j7, long j8) {
        this.f15980a = j7;
        this.f15981b = j8;
    }
}
