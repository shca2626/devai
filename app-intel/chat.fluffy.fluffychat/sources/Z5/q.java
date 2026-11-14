package Z5;

import W5.InterfaceC0653w0;

/* loaded from: classes.dex */
public final class q implements w, d, a6.k {
    private final InterfaceC0653w0 job;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ w f10438l;

    public q(w wVar, InterfaceC0653w0 interfaceC0653w0) {
        this.f10438l = wVar;
        this.job = interfaceC0653w0;
    }

    @Override // Z5.s, Z5.d
    public Object a(e eVar, C5.e eVar2) {
        return this.f10438l.a(eVar, eVar2);
    }

    @Override // a6.k
    public d d(C5.i iVar, int i7, Y5.a aVar) {
        return y.d(this, iVar, i7, aVar);
    }

    @Override // Z5.w
    public Object getValue() {
        return this.f10438l.getValue();
    }
}
