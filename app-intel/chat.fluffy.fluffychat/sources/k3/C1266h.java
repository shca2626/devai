package k3;

import j3.AbstractC1237k;
import j3.InterfaceC1232f;
import java.io.Serializable;

/* renamed from: k3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1266h extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC1232f f18977l;

    /* renamed from: m, reason: collision with root package name */
    public final U f18978m;

    public C1266h(InterfaceC1232f interfaceC1232f, U u7) {
        this.f18977l = (InterfaceC1232f) j3.o.q(interfaceC1232f);
        this.f18978m = (U) j3.o.q(u7);
    }

    @Override // k3.U, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f18978m.compare(this.f18977l.apply(obj), this.f18977l.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1266h) {
            C1266h c1266h = (C1266h) obj;
            if (this.f18977l.equals(c1266h.f18977l) && this.f18978m.equals(c1266h.f18978m)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1237k.b(this.f18977l, this.f18978m);
    }

    public String toString() {
        return this.f18978m + ".onResultOf(" + this.f18977l + ")";
    }
}
