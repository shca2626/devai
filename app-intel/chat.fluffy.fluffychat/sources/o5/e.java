package o5;

import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f20445e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20446a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20447b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20448c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20449d;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final e a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(2);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = list.get(3);
            M5.m.c(obj4, "null cannot be cast to non-null type kotlin.String");
            return new e((String) obj, (String) obj2, (String) obj3, (String) obj4);
        }

        public a() {
        }
    }

    public e(String str, String str2, String str3, String str4) {
        M5.m.e(str, "reason");
        M5.m.e(str2, "signInHint");
        M5.m.e(str3, "cancelButton");
        M5.m.e(str4, "signInTitle");
        this.f20446a = str;
        this.f20447b = str2;
        this.f20448c = str3;
        this.f20449d = str4;
    }

    public final String a() {
        return this.f20448c;
    }

    public final String b() {
        return this.f20446a;
    }

    public final String c() {
        return this.f20447b;
    }

    public final String d() {
        return this.f20449d;
    }

    public final List e() {
        return C1884o.l(this.f20446a, this.f20447b, this.f20448c, this.f20449d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return s.f20478a.a(e(), ((e) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return "AuthStrings(reason=" + this.f20446a + ", signInHint=" + this.f20447b + ", cancelButton=" + this.f20448c + ", signInTitle=" + this.f20449d + ")";
    }
}
