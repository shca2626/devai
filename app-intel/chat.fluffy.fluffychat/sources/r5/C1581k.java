package r5;

import java.util.List;
import java.util.Map;
import z5.C1881o;

/* renamed from: r5.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1581k {

    /* renamed from: f, reason: collision with root package name */
    public static final a f22264f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f22265a;

    /* renamed from: b, reason: collision with root package name */
    public final D f22266b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f22267c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22268d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f22269e;

    /* renamed from: r5.k$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1581k a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            D d7 = (D) list.get(1);
            Object obj2 = list.get(2);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            return new C1581k(str, d7, (Map) obj2, (String) list.get(3), (Long) list.get(4));
        }

        public a() {
        }
    }

    public C1581k(String str, D d7, Map map, String str2, Long l7) {
        M5.m.e(str, "uri");
        M5.m.e(map, "httpHeaders");
        this.f22265a = str;
        this.f22266b = d7;
        this.f22267c = map;
        this.f22268d = str2;
        this.f22269e = l7;
    }

    public final Long a() {
        return this.f22269e;
    }

    public final D b() {
        return this.f22266b;
    }

    public final Map c() {
        return this.f22267c;
    }

    public final String d() {
        return this.f22265a;
    }

    public final String e() {
        return this.f22268d;
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1581k.class)) {
            if (this == obj) {
                return true;
            }
            C1581k c1581k = (C1581k) obj;
            C1593x c1593x = C1593x.f22331a;
            if (c1593x.a(this.f22265a, c1581k.f22265a) && c1593x.a(this.f22266b, c1581k.f22266b) && c1593x.a(this.f22267c, c1581k.f22267c) && c1593x.a(this.f22268d, c1581k.f22268d) && c1593x.a(this.f22269e, c1581k.f22269e)) {
                return true;
            }
        }
        return false;
    }

    public final List f() {
        return C1881o.l(this.f22265a, this.f22266b, this.f22267c, this.f22268d, this.f22269e);
    }

    public int hashCode() {
        int iHashCode = C1581k.class.hashCode() * 31;
        C1593x c1593x = C1593x.f22331a;
        return ((((((((iHashCode + c1593x.b(this.f22265a)) * 31) + c1593x.b(this.f22266b)) * 31) + c1593x.b(this.f22267c)) * 31) + c1593x.b(this.f22268d)) * 31) + c1593x.b(this.f22269e);
    }

    public String toString() {
        return "CreationOptions(uri=" + this.f22265a + ", formatHint=" + this.f22266b + ", httpHeaders=" + this.f22267c + ", userAgent=" + this.f22268d + ", backBufferDurationMs=" + this.f22269e + ")";
    }
}
