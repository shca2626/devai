package s2;

/* loaded from: classes.dex */
public final class m extends f {

    /* renamed from: a, reason: collision with root package name */
    public final v6.g f22406a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22407b;

    /* renamed from: c, reason: collision with root package name */
    public final r2.e f22408c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(v6.g gVar, String str, r2.e eVar) {
        super(null);
        M5.m.e(gVar, "source");
        M5.m.e(eVar, "dataSource");
        this.f22406a = gVar;
        this.f22407b = str;
        this.f22408c = eVar;
    }

    public final r2.e a() {
        return this.f22408c;
    }

    public final String b() {
        return this.f22407b;
    }

    public final v6.g c() {
        return this.f22406a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return M5.m.a(this.f22406a, mVar.f22406a) && M5.m.a(this.f22407b, mVar.f22407b) && this.f22408c == mVar.f22408c;
    }

    public int hashCode() {
        int iHashCode = this.f22406a.hashCode() * 31;
        String str = this.f22407b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22408c.hashCode();
    }

    public String toString() {
        return "SourceResult(source=" + this.f22406a + ", mimeType=" + ((Object) this.f22407b) + ", dataSource=" + this.f22408c + ')';
    }
}
