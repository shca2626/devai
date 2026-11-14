package k3;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class a0 extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final a0 f18920l = new a0();

    @Override // k3.U
    public U g() {
        return U.d();
    }

    @Override // k3.U, java.util.Comparator
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        j3.o.q(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
