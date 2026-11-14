package k3;

import j3.AbstractC1236k;
import j3.InterfaceC1231f;
import java.io.Serializable;

/* renamed from: k3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1265h extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC1231f f18976l;

    /* renamed from: m, reason: collision with root package name */
    public final U f18977m;

    public C1265h(InterfaceC1231f interfaceC1231f, U u7) {
        this.f18976l = (InterfaceC1231f) j3.o.q(interfaceC1231f);
        this.f18977m = (U) j3.o.q(u7);
    }

    @Override // k3.U, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f18977m.compare(this.f18976l.apply(obj), this.f18976l.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1265h) {
            C1265h c1265h = (C1265h) obj;
            if (this.f18976l.equals(c1265h.f18976l) && this.f18977m.equals(c1265h.f18977m)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1236k.b(this.f18976l, this.f18977m);
    }

    public String toString() {
        return this.f18977m + ".onResultOf(" + this.f18976l + ")";
    }
}
