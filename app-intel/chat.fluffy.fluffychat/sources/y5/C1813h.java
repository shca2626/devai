package y5;

import java.io.Serializable;

/* renamed from: y5.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1813h implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final Object f24002l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f24003m;

    public C1813h(Object obj, Object obj2) {
        this.f24002l = obj;
        this.f24003m = obj2;
    }

    public final Object a() {
        return this.f24002l;
    }

    public final Object b() {
        return this.f24003m;
    }

    public final Object c() {
        return this.f24002l;
    }

    public final Object d() {
        return this.f24003m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1813h)) {
            return false;
        }
        C1813h c1813h = (C1813h) obj;
        return M5.m.a(this.f24002l, c1813h.f24002l) && M5.m.a(this.f24003m, c1813h.f24003m);
    }

    public int hashCode() {
        Object obj = this.f24002l;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f24003m;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f24002l + ", " + this.f24003m + ')';
    }
}
