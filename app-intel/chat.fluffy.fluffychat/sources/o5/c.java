package o5;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20422c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d f20423a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20424b;

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
        this.f20423a = dVar;
        this.f20424b = str;
    }

    public final List a() {
        return C1881o.l(this.f20423a, this.f20424b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return s.f20479a.a(a(), ((c) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "AuthResult(code=" + this.f20423a + ", errorMessage=" + this.f20424b + ")";
    }
}
