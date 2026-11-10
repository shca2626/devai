package androidx.lifecycle;

import androidx.lifecycle.AbstractC0804j;

/* loaded from: classes.dex */
public final class E implements InterfaceC0806l, AutoCloseable {

    /* renamed from: l, reason: collision with root package name */
    public final String f12356l;

    /* renamed from: m, reason: collision with root package name */
    public final C f12357m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12358n;

    public E(String str, C c7) {
        M5.m.e(str, "key");
        M5.m.e(c7, "handle");
        this.f12356l = str;
        this.f12357m = c7;
    }

    public final void a(V1.f fVar, AbstractC0804j abstractC0804j) {
        M5.m.e(fVar, "registry");
        M5.m.e(abstractC0804j, "lifecycle");
        if (this.f12358n) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f12358n = true;
        abstractC0804j.a(this);
        fVar.c(this.f12356l, this.f12357m.a());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    @Override // androidx.lifecycle.InterfaceC0806l
    public void d(InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar) {
        M5.m.e(interfaceC0808n, "source");
        M5.m.e(aVar, "event");
        if (aVar == AbstractC0804j.a.ON_DESTROY) {
            this.f12358n = false;
            interfaceC0808n.a().c(this);
        }
    }

    public final C e() {
        return this.f12357m;
    }

    public final boolean f() {
        return this.f12358n;
    }
}
