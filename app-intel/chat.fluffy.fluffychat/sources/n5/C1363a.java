package n5;

import java.util.List;
import z5.C1884o;

/* renamed from: n5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1363a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0230a f20137c = new C0230a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20138a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20139b;

    /* renamed from: n5.a$a, reason: collision with other inner class name */
    public static final class C0230a {
        public /* synthetic */ C0230a(M5.g gVar) {
            this();
        }

        public final C1363a a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.String");
            return new C1363a((String) obj, (String) list.get(1));
        }

        public C0230a() {
        }
    }

    public C1363a(String str, String str2) {
        M5.m.e(str, "code");
        this.f20138a = str;
        this.f20139b = str2;
    }

    public final List a() {
        return C1884o.l(this.f20138a, this.f20139b);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1363a.class)) {
            if (this == obj) {
                return true;
            }
            C1363a c1363a = (C1363a) obj;
            I i7 = I.f20119a;
            if (i7.a(this.f20138a, c1363a.f20138a) && i7.a(this.f20139b, c1363a.f20139b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1363a.class.hashCode() * 31;
        I i7 = I.f20119a;
        return ((iHashCode + i7.b(this.f20138a)) * 31) + i7.b(this.f20139b);
    }

    public String toString() {
        return "CacheRetrievalError(code=" + this.f20138a + ", message=" + this.f20139b + ")";
    }
}
