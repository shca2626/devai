package n5;

import java.util.List;
import z5.C1881o;

/* renamed from: n5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1364a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0230a f20138c = new C0230a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20139a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20140b;

    /* renamed from: n5.a$a, reason: collision with other inner class name */
    public static final class C0230a {
        public /* synthetic */ C0230a(M5.g gVar) {
            this();
        }

        public final C1364a a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.String");
            return new C1364a((String) obj, (String) list.get(1));
        }

        public C0230a() {
        }
    }

    public C1364a(String str, String str2) {
        M5.m.e(str, "code");
        this.f20139a = str;
        this.f20140b = str2;
    }

    public final List a() {
        return C1881o.l(this.f20139a, this.f20140b);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1364a.class)) {
            if (this == obj) {
                return true;
            }
            C1364a c1364a = (C1364a) obj;
            I i7 = I.f20120a;
            if (i7.a(this.f20139a, c1364a.f20139a) && i7.a(this.f20140b, c1364a.f20140b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1364a.class.hashCode() * 31;
        I i7 = I.f20120a;
        return ((iHashCode + i7.b(this.f20139a)) * 31) + i7.b(this.f20140b);
    }

    public String toString() {
        return "CacheRetrievalError(code=" + this.f20139a + ", message=" + this.f20140b + ")";
    }
}
