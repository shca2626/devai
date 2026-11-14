package y5;

import java.io.Serializable;

/* renamed from: y5.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1812h implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final Object f24008l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f24009m;

    public C1812h(Object obj, Object obj2) {
        this.f24008l = obj;
        this.f24009m = obj2;
    }

    public final Object a() {
        return this.f24008l;
    }

    public final Object b() {
        return this.f24009m;
    }

    public final Object c() {
        return this.f24008l;
    }

    public final Object d() {
        return this.f24009m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1812h)) {
            return false;
        }
        C1812h c1812h = (C1812h) obj;
        return M5.m.a(this.f24008l, c1812h.f24008l) && M5.m.a(this.f24009m, c1812h.f24009m);
    }

    public int hashCode() {
        Object obj = this.f24008l;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f24009m;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f24008l + ", " + this.f24009m + ')';
    }
}
