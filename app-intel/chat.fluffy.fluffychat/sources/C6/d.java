package C6;

import M5.m;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1400a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1401b;

    public d(String str, boolean z7) {
        m.e(str, "packageName");
        this.f1400a = str;
        this.f1401b = z7;
    }

    public final boolean a() {
        return this.f1401b;
    }

    public final String b() {
        return this.f1400a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return m.a(this.f1400a, dVar.f1400a) && this.f1401b == dVar.f1401b;
    }

    public int hashCode() {
        return (this.f1400a.hashCode() * 31) + Boolean.hashCode(this.f1401b);
    }

    public String toString() {
        return "Distributor(packageName=" + this.f1400a + ", ack=" + this.f1401b + ')';
    }
}
