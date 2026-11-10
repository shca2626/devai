package androidx.lifecycle;

import androidx.lifecycle.AbstractC0804j;

/* renamed from: androidx.lifecycle.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0810p {
    public static final void a(InterfaceC0808n interfaceC0808n, AbstractC0804j.b bVar, AbstractC0804j.b bVar2) {
        M5.m.e(bVar, "current");
        M5.m.e(bVar2, "next");
        if (bVar == AbstractC0804j.b.f12408m && bVar2 == AbstractC0804j.b.f12407l) {
            throw new IllegalStateException(("State must be at least '" + AbstractC0804j.b.f12409n + "' to be moved to '" + bVar2 + "' in component " + interfaceC0808n).toString());
        }
        AbstractC0804j.b bVar3 = AbstractC0804j.b.f12407l;
        if (bVar != bVar3 || bVar == bVar2) {
            return;
        }
        throw new IllegalStateException(("State is '" + bVar3 + "' and cannot be moved to `" + bVar2 + "` in component " + interfaceC0808n).toString());
    }
}
