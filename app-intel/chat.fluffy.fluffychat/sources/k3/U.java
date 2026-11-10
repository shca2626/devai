package k3;

import j3.InterfaceC1232f;
import java.util.Comparator;

/* loaded from: classes.dex */
public abstract class U implements Comparator {
    public static U b(Comparator comparator) {
        return comparator instanceof U ? (U) comparator : new C1271m(comparator);
    }

    public static U d() {
        return P.f18878l;
    }

    public U a(Comparator comparator) {
        return new C1273o(this, (Comparator) j3.o.q(comparator));
    }

    public AbstractC1279v c(Iterable iterable) {
        return AbstractC1279v.C(this, iterable);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public U e() {
        return f(H.i());
    }

    public U f(InterfaceC1232f interfaceC1232f) {
        return new C1266h(interfaceC1232f, this);
    }

    public U g() {
        return new b0(this);
    }
}
