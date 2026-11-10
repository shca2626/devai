package j1;

import E0.E;
import g1.InterfaceC1087q;
import g1.InterfaceC1088s;
import g1.M;
import g1.P;
import g1.r;

/* renamed from: j1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1225a implements InterfaceC1087q {

    /* renamed from: a, reason: collision with root package name */
    public final E f18683a = new E(4);

    /* renamed from: b, reason: collision with root package name */
    public final P f18684b = new P(-1, -1, "image/avif");

    @Override // g1.InterfaceC1087q
    public void a(long j7, long j8) {
        this.f18684b.a(j7, j8);
    }

    @Override // g1.InterfaceC1087q
    public void b(InterfaceC1088s interfaceC1088s) {
        this.f18684b.b(interfaceC1088s);
    }

    @Override // g1.InterfaceC1087q
    public boolean d(r rVar) {
        rVar.k(4);
        return g(rVar, 1718909296) && g(rVar, 1635150182);
    }

    @Override // g1.InterfaceC1087q
    public int f(r rVar, M m7) {
        return this.f18684b.f(rVar, m7);
    }

    public final boolean g(r rVar, int i7) {
        this.f18683a.b0(4);
        rVar.t(this.f18683a.f(), 0, 4);
        return this.f18683a.S() == ((long) i7);
    }

    @Override // g1.InterfaceC1087q
    public void release() {
    }
}
