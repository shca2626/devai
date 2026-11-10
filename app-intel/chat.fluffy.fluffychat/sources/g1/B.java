package g1;

import g1.N;

/* loaded from: classes.dex */
public abstract class B implements N {

    /* renamed from: a, reason: collision with root package name */
    public final N f15925a;

    public B(N n7) {
        this.f15925a = n7;
    }

    @Override // g1.N
    public boolean e() {
        return this.f15925a.e();
    }

    @Override // g1.N
    public boolean f() {
        return this.f15925a.f();
    }

    @Override // g1.N
    public N.a g(long j7) {
        return this.f15925a.g(j7);
    }

    @Override // g1.N
    public long i() {
        return this.f15925a.i();
    }
}
