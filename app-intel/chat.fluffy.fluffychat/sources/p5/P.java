package p5;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class P {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20983c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20984a;

    /* renamed from: b, reason: collision with root package name */
    public final N f20985b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final P a(List list) {
            M5.m.e(list, "pigeonVar_list");
            String str = (String) list.get(0);
            Object obj = list.get(1);
            M5.m.c(obj, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
            return new P(str, (N) obj);
        }

        public a() {
        }
    }

    public P(String str, N n7) {
        M5.m.e(n7, "type");
        this.f20984a = str;
        this.f20985b = n7;
    }

    public final List a() {
        return C1881o.l(this.f20984a, this.f20985b);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), P.class)) {
            if (this == obj) {
                return true;
            }
            P p7 = (P) obj;
            C1450d c1450d = C1450d.f20989a;
            if (c1450d.a(this.f20984a, p7.f20984a) && c1450d.a(this.f20985b, p7.f20985b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = P.class.hashCode() * 31;
        C1450d c1450d = C1450d.f20989a;
        return ((iHashCode + c1450d.b(this.f20984a)) * 31) + c1450d.b(this.f20985b);
    }

    public String toString() {
        return "StringListResult(jsonEncodedValue=" + this.f20984a + ", type=" + this.f20985b + ")";
    }
}
