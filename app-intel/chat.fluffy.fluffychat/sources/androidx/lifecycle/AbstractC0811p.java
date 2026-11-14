package androidx.lifecycle;

import androidx.lifecycle.AbstractC0805j;

/* renamed from: androidx.lifecycle.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0811p {
    public static final void a(InterfaceC0809n interfaceC0809n, AbstractC0805j.b bVar, AbstractC0805j.b bVar2) {
        M5.m.e(bVar, "current");
        M5.m.e(bVar2, "next");
        if (bVar == AbstractC0805j.b.f12408m && bVar2 == AbstractC0805j.b.f12407l) {
            throw new IllegalStateException(("State must be at least '" + AbstractC0805j.b.f12409n + "' to be moved to '" + bVar2 + "' in component " + interfaceC0809n).toString());
        }
        AbstractC0805j.b bVar3 = AbstractC0805j.b.f12407l;
        if (bVar != bVar3 || bVar == bVar2) {
            return;
        }
        throw new IllegalStateException(("State is '" + bVar3 + "' and cannot be moved to `" + bVar2 + "` in component " + interfaceC0809n).toString());
    }
}
