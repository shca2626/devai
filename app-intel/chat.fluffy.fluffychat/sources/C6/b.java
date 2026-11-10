package C6;

import M5.m;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1395a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1396b;

    /* renamed from: c, reason: collision with root package name */
    public final e f1397c;

    public b(String str, String str2, e eVar) {
        m.e(str, "distributor");
        m.e(str2, "token");
        m.e(eVar, "registration");
        this.f1395a = str;
        this.f1396b = str2;
        this.f1397c = eVar;
    }

    public final c a() {
        return new c(this.f1395a, this.f1396b);
    }

    public final String b() {
        return this.f1395a;
    }

    public final e c() {
        return this.f1397c;
    }

    public final String d() {
        return this.f1396b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return m.a(this.f1395a, bVar.f1395a) && m.a(this.f1396b, bVar.f1396b) && m.a(this.f1397c, bVar.f1397c);
    }

    public int hashCode() {
        return (((this.f1395a.hashCode() * 31) + this.f1396b.hashCode()) * 31) + this.f1397c.hashCode();
    }

    public String toString() {
        return "Registration(distributor=" + this.f1395a + ", token=" + this.f1396b + ", registration=" + this.f1397c + ')';
    }
}
