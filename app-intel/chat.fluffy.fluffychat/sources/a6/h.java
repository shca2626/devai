package a6;

import y5.C1824s;

/* loaded from: classes.dex */
public final class h extends g {
    public h(Z5.d dVar, C5.i iVar, int i7, Y5.a aVar) {
        super(dVar, iVar, i7, aVar);
    }

    @Override // a6.e
    public e i(C5.i iVar, int i7, Y5.a aVar) {
        return new h(this.f10879o, iVar, i7, aVar);
    }

    @Override // a6.g
    public Object q(Z5.e eVar, C5.e eVar2) {
        Object objA = this.f10879o.a(eVar, eVar2);
        return objA == D5.c.e() ? objA : C1824s.f24014a;
    }

    public /* synthetic */ h(Z5.d dVar, C5.i iVar, int i7, Y5.a aVar, int i8, M5.g gVar) {
        this(dVar, (i8 & 2) != 0 ? C5.j.f1392l : iVar, (i8 & 4) != 0 ? -3 : i7, (i8 & 8) != 0 ? Y5.a.f9870l : aVar);
    }
}
