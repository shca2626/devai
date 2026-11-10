package C6;

import M5.m;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f1405a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1406b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1407c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1408d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1409e;

    public f(String str, String str2, String str3, String str4, String str5) {
        m.e(str, "instance");
        m.e(str2, "auth");
        m.e(str3, "pubKey");
        m.e(str4, "privKey");
        this.f1405a = str;
        this.f1406b = str2;
        this.f1407c = str3;
        this.f1408d = str4;
        this.f1409e = str5;
    }

    public final String a() {
        return this.f1406b;
    }

    public final String b() {
        return this.f1405a;
    }

    public final String c() {
        return this.f1409e;
    }

    public final String d() {
        return this.f1408d;
    }

    public final String e() {
        return this.f1407c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return m.a(this.f1405a, fVar.f1405a) && m.a(this.f1406b, fVar.f1406b) && m.a(this.f1407c, fVar.f1407c) && m.a(this.f1408d, fVar.f1408d) && m.a(this.f1409e, fVar.f1409e);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f1405a.hashCode() * 31) + this.f1406b.hashCode()) * 31) + this.f1407c.hashCode()) * 31) + this.f1408d.hashCode()) * 31;
        String str = this.f1409e;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "WebPushKeysRecord(instance=" + this.f1405a + ", auth=" + this.f1406b + ", pubKey=" + this.f1407c + ", privKey=" + this.f1408d + ", iv=" + this.f1409e + ')';
    }
}
