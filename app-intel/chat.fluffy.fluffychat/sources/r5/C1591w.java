package r5;

import h5.c;

/* renamed from: r5.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1591w implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC1590v f22335l;

    /* renamed from: m, reason: collision with root package name */
    public C1569A f22336m;

    public C1591w(InterfaceC1590v interfaceC1590v) {
        M5.m.e(interfaceC1590v, "wrapper");
        this.f22335l = interfaceC1590v;
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        this.f22336m = null;
        this.f22335l.onCancel(obj);
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        M5.m.e(bVar, "sink");
        C1569A c1569a = new C1569A(bVar);
        this.f22336m = c1569a;
        InterfaceC1590v interfaceC1590v = this.f22335l;
        M5.m.b(c1569a);
        interfaceC1590v.a(obj, c1569a);
    }
}
