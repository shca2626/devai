package M5;

/* loaded from: classes.dex */
public final class o implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5718a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5719b;

    public o(Class cls, String str) {
        m.e(cls, "jClass");
        m.e(str, "moduleName");
        this.f5718a = cls;
        this.f5719b = str;
    }

    @Override // M5.d
    public Class d() {
        return this.f5718a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof o) && m.a(d(), ((o) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
