package P1;

import E0.E;
import g1.InterfaceC1087q;
import g1.InterfaceC1088s;
import g1.M;
import g1.P;
import g1.r;

/* loaded from: classes.dex */
public final class a implements InterfaceC1087q {

    /* renamed from: a, reason: collision with root package name */
    public final E f7540a = new E(4);

    /* renamed from: b, reason: collision with root package name */
    public final P f7541b = new P(-1, -1, "image/webp");

    @Override // g1.InterfaceC1087q
    public void a(long j7, long j8) {
        this.f7541b.a(j7, j8);
    }

    @Override // g1.InterfaceC1087q
    public void b(InterfaceC1088s interfaceC1088s) {
        this.f7541b.b(interfaceC1088s);
    }

    @Override // g1.InterfaceC1087q
    public boolean d(r rVar) {
        this.f7540a.b0(4);
        rVar.t(this.f7540a.f(), 0, 4);
        if (this.f7540a.S() != 1380533830) {
            return false;
        }
        rVar.k(4);
        this.f7540a.b0(4);
        rVar.t(this.f7540a.f(), 0, 4);
        return this.f7540a.S() == 1464156752;
    }

    @Override // g1.InterfaceC1087q
    public int f(r rVar, M m7) {
        return this.f7541b.f(rVar, m7);
    }

    @Override // g1.InterfaceC1087q
    public void release() {
    }
}
