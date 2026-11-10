package o5;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f20446e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20447a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20448b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20449c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20450d;

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
        this.f20447a = str;
        this.f20448b = str2;
        this.f20449c = str3;
        this.f20450d = str4;
    }

    public final String a() {
        return this.f20449c;
    }

    public final String b() {
        return this.f20447a;
    }

    public final String c() {
        return this.f20448b;
    }

    public final String d() {
        return this.f20450d;
    }

    public final List e() {
        return C1881o.l(this.f20447a, this.f20448b, this.f20449c, this.f20450d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return s.f20479a.a(e(), ((e) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return "AuthStrings(reason=" + this.f20447a + ", signInHint=" + this.f20448b + ", cancelButton=" + this.f20449c + ", signInTitle=" + this.f20450d + ")";
    }
}
