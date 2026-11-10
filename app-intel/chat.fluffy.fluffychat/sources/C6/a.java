package C6;

import M5.m;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1393a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1394b;

    public a(String str, String str2) {
        m.e(str, "distributor");
        m.e(str2, "instance");
        this.f1393a = str;
        this.f1394b = str2;
    }

    public final String a() {
        return this.f1393a;
    }

    public final String b() {
        return this.f1394b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.f1393a, aVar.f1393a) && m.a(this.f1394b, aVar.f1394b);
    }

    public int hashCode() {
        return (this.f1393a.hashCode() * 31) + this.f1394b.hashCode();
    }

    public String toString() {
        return "Instance(distributor=" + this.f1393a + ", instance=" + this.f1394b + ')';
    }
}
