package k3;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class P extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final P f18878l = new P();

    @Override // k3.U
    public U g() {
        return a0.f18921l;
    }

    @Override // k3.U, java.util.Comparator
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        j3.o.q(comparable);
        j3.o.q(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
