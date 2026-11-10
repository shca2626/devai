package k3;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: k3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1271m extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final Comparator f19006l;

    public C1271m(Comparator comparator) {
        this.f19006l = (Comparator) j3.o.q(comparator);
    }

    @Override // k3.U, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f19006l.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1271m) {
            return this.f19006l.equals(((C1271m) obj).f19006l);
        }
        return false;
    }

    public int hashCode() {
        return this.f19006l.hashCode();
    }

    public String toString() {
        return this.f19006l.toString();
    }
}
