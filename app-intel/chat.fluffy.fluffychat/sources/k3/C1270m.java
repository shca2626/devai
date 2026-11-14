package k3;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: k3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1270m extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final Comparator f19005l;

    public C1270m(Comparator comparator) {
        this.f19005l = (Comparator) j3.o.q(comparator);
    }

    @Override // k3.U, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f19005l.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1270m) {
            return this.f19005l.equals(((C1270m) obj).f19005l);
        }
        return false;
    }

    public int hashCode() {
        return this.f19005l.hashCode();
    }

    public String toString() {
        return this.f19005l.toString();
    }
}
