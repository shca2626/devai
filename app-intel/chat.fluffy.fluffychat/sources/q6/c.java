package q6;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final v6.h f21478d = v6.h.i(":");

    /* renamed from: e, reason: collision with root package name */
    public static final v6.h f21479e = v6.h.i(":status");

    /* renamed from: f, reason: collision with root package name */
    public static final v6.h f21480f = v6.h.i(":method");

    /* renamed from: g, reason: collision with root package name */
    public static final v6.h f21481g = v6.h.i(":path");

    /* renamed from: h, reason: collision with root package name */
    public static final v6.h f21482h = v6.h.i(":scheme");

    /* renamed from: i, reason: collision with root package name */
    public static final v6.h f21483i = v6.h.i(":authority");

    /* renamed from: a, reason: collision with root package name */
    public final v6.h f21484a;

    /* renamed from: b, reason: collision with root package name */
    public final v6.h f21485b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21486c;

    public interface a {
    }

    public c(String str, String str2) {
        this(v6.h.i(str), v6.h.i(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f21484a.equals(cVar.f21484a) && this.f21485b.equals(cVar.f21485b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f21484a.hashCode()) * 31) + this.f21485b.hashCode();
    }

    public String toString() {
        return l6.c.p("%s: %s", this.f21484a.C(), this.f21485b.C());
    }

    public c(v6.h hVar, String str) {
        this(hVar, v6.h.i(str));
    }

    public c(v6.h hVar, v6.h hVar2) {
        this.f21484a = hVar;
        this.f21485b = hVar2;
        this.f21486c = hVar.y() + 32 + hVar2.y();
    }
}
