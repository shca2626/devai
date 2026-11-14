package s2;

/* loaded from: classes.dex */
public final class m extends f {

    /* renamed from: a, reason: collision with root package name */
    public final v6.g f22412a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22413b;

    /* renamed from: c, reason: collision with root package name */
    public final r2.e f22414c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(v6.g gVar, String str, r2.e eVar) {
        super(null);
        M5.m.e(gVar, "source");
        M5.m.e(eVar, "dataSource");
        this.f22412a = gVar;
        this.f22413b = str;
        this.f22414c = eVar;
    }

    public final r2.e a() {
        return this.f22414c;
    }

    public final String b() {
        return this.f22413b;
    }

    public final v6.g c() {
        return this.f22412a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return M5.m.a(this.f22412a, mVar.f22412a) && M5.m.a(this.f22413b, mVar.f22413b) && this.f22414c == mVar.f22414c;
    }

    public int hashCode() {
        int iHashCode = this.f22412a.hashCode() * 31;
        String str = this.f22413b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22414c.hashCode();
    }

    public String toString() {
        return "SourceResult(source=" + this.f22412a + ", mimeType=" + ((Object) this.f22413b) + ", dataSource=" + this.f22414c + ')';
    }
}
