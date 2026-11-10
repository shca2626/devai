package V5;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f8874a;

    /* renamed from: b, reason: collision with root package name */
    public final S5.c f8875b;

    public f(String str, S5.c cVar) {
        M5.m.e(str, "value");
        M5.m.e(cVar, "range");
        this.f8874a = str;
        this.f8875b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return M5.m.a(this.f8874a, fVar.f8874a) && M5.m.a(this.f8875b, fVar.f8875b);
    }

    public int hashCode() {
        return (this.f8874a.hashCode() * 31) + this.f8875b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f8874a + ", range=" + this.f8875b + ')';
    }
}
