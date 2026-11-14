package k3;

import j3.InterfaceC1231f;
import java.util.Comparator;

/* loaded from: classes.dex */
public abstract class U implements Comparator {
    public static U b(Comparator comparator) {
        return comparator instanceof U ? (U) comparator : new C1270m(comparator);
    }

    public static U d() {
        return P.f18877l;
    }

    public U a(Comparator comparator) {
        return new C1272o(this, (Comparator) j3.o.q(comparator));
    }

    public AbstractC1278v c(Iterable iterable) {
        return AbstractC1278v.C(this, iterable);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public U e() {
        return f(H.i());
    }

    public U f(InterfaceC1231f interfaceC1231f) {
        return new C1265h(interfaceC1231f, this);
    }

    public U g() {
        return new b0(this);
    }
}
