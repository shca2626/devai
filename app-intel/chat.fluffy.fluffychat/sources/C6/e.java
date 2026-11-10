package C6;

import M5.m;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f1402a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1403b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1404c;

    public e(String str, String str2, String str3) {
        m.e(str, "instance");
        this.f1402a = str;
        this.f1403b = str2;
        this.f1404c = str3;
    }

    public final String a() {
        return this.f1402a;
    }

    public final String b() {
        return this.f1403b;
    }

    public final String c() {
        return this.f1404c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return m.a(this.f1402a, eVar.f1402a) && m.a(this.f1403b, eVar.f1403b) && m.a(this.f1404c, eVar.f1404c);
    }

    public int hashCode() {
        int iHashCode = this.f1402a.hashCode() * 31;
        String str = this.f1403b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f1404c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RegistrationData(instance=" + this.f1402a + ", messageForDistributor=" + this.f1403b + ", vapid=" + this.f1404c + ')';
    }
}
