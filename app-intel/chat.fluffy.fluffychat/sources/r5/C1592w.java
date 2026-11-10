package r5;

import h5.c;

/* renamed from: r5.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1592w implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC1591v f22329l;

    /* renamed from: m, reason: collision with root package name */
    public C1570A f22330m;

    public C1592w(InterfaceC1591v interfaceC1591v) {
        M5.m.e(interfaceC1591v, "wrapper");
        this.f22329l = interfaceC1591v;
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        this.f22330m = null;
        this.f22329l.onCancel(obj);
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        M5.m.e(bVar, "sink");
        C1570A c1570a = new C1570A(bVar);
        this.f22330m = c1570a;
        InterfaceC1591v interfaceC1591v = this.f22329l;
        M5.m.b(c1570a);
        interfaceC1591v.a(obj, c1570a);
    }
}
