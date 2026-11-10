package androidx.lifecycle;

import androidx.lifecycle.AbstractC0804j;

/* loaded from: classes.dex */
public final class D implements InterfaceC0806l {

    /* renamed from: l, reason: collision with root package name */
    public final H f12355l;

    public D(H h7) {
        M5.m.e(h7, "provider");
        this.f12355l = h7;
    }

    @Override // androidx.lifecycle.InterfaceC0806l
    public void d(InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar) {
        M5.m.e(interfaceC0808n, "source");
        M5.m.e(aVar, "event");
        if (aVar == AbstractC0804j.a.ON_CREATE) {
            interfaceC0808n.a().c(this);
            this.f12355l.e();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}
