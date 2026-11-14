package p5;

import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class P {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20989c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20990a;

    /* renamed from: b, reason: collision with root package name */
    public final N f20991b;

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
        this.f20990a = str;
        this.f20991b = n7;
    }

    public final List a() {
        return C1884o.l(this.f20990a, this.f20991b);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), P.class)) {
            if (this == obj) {
                return true;
            }
            P p7 = (P) obj;
            C1449d c1449d = C1449d.f20995a;
            if (c1449d.a(this.f20990a, p7.f20990a) && c1449d.a(this.f20991b, p7.f20991b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = P.class.hashCode() * 31;
        C1449d c1449d = C1449d.f20995a;
        return ((iHashCode + c1449d.b(this.f20990a)) * 31) + c1449d.b(this.f20991b);
    }

    public String toString() {
        return "StringListResult(jsonEncodedValue=" + this.f20990a + ", type=" + this.f20991b + ")";
    }
}
