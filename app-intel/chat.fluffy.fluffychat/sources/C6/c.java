package C6;

import M5.m;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f1398a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1399b;

    public c(String str, String str2) {
        m.e(str, "distributor");
        m.e(str2, "token");
        this.f1398a = str;
        this.f1399b = str2;
    }

    public final String a() {
        return this.f1398a;
    }

    public final String b() {
        return this.f1399b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return m.a(this.f1398a, cVar.f1398a) && m.a(this.f1399b, cVar.f1399b);
    }

    public int hashCode() {
        return (this.f1398a.hashCode() * 31) + this.f1399b.hashCode();
    }

    public String toString() {
        return "Token(distributor=" + this.f1398a + ", token=" + this.f1399b + ')';
    }
}
