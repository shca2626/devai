package o5;

import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20421c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d f20422a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20423b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final c a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type io.flutter.plugins.localauth.AuthResultCode");
            return new c((d) obj, (String) list.get(1));
        }

        public a() {
        }
    }

    public c(d dVar, String str) {
        M5.m.e(dVar, "code");
        this.f20422a = dVar;
        this.f20423b = str;
    }

    public final List a() {
        return C1884o.l(this.f20422a, this.f20423b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return s.f20478a.a(a(), ((c) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "AuthResult(code=" + this.f20422a + ", errorMessage=" + this.f20423b + ")";
    }
}
