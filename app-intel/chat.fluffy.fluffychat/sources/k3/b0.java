package k3;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class b0 extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final U f18929l;

    public b0(U u7) {
        this.f18929l = (U) j3.o.q(u7);
    }

    @Override // k3.U, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f18929l.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            return this.f18929l.equals(((b0) obj).f18929l);
        }
        return false;
    }

    @Override // k3.U
    public U g() {
        return this.f18929l;
    }

    public int hashCode() {
        return -this.f18929l.hashCode();
    }

    public String toString() {
        return this.f18929l + ".reverse()";
    }
}
