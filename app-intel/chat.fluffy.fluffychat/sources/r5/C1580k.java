package r5;

import java.util.List;
import java.util.Map;
import z5.C1884o;

/* renamed from: r5.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1580k {

    /* renamed from: f, reason: collision with root package name */
    public static final a f22270f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f22271a;

    /* renamed from: b, reason: collision with root package name */
    public final D f22272b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f22273c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22274d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f22275e;

    /* renamed from: r5.k$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1580k a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            D d7 = (D) list.get(1);
            Object obj2 = list.get(2);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            return new C1580k(str, d7, (Map) obj2, (String) list.get(3), (Long) list.get(4));
        }

        public a() {
        }
    }

    public C1580k(String str, D d7, Map map, String str2, Long l7) {
        M5.m.e(str, "uri");
        M5.m.e(map, "httpHeaders");
        this.f22271a = str;
        this.f22272b = d7;
        this.f22273c = map;
        this.f22274d = str2;
        this.f22275e = l7;
    }

    public final Long a() {
        return this.f22275e;
    }

    public final D b() {
        return this.f22272b;
    }

    public final Map c() {
        return this.f22273c;
    }

    public final String d() {
        return this.f22271a;
    }

    public final String e() {
        return this.f22274d;
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1580k.class)) {
            if (this == obj) {
                return true;
            }
            C1580k c1580k = (C1580k) obj;
            C1592x c1592x = C1592x.f22337a;
            if (c1592x.a(this.f22271a, c1580k.f22271a) && c1592x.a(this.f22272b, c1580k.f22272b) && c1592x.a(this.f22273c, c1580k.f22273c) && c1592x.a(this.f22274d, c1580k.f22274d) && c1592x.a(this.f22275e, c1580k.f22275e)) {
                return true;
            }
        }
        return false;
    }

    public final List f() {
        return C1884o.l(this.f22271a, this.f22272b, this.f22273c, this.f22274d, this.f22275e);
    }

    public int hashCode() {
        int iHashCode = C1580k.class.hashCode() * 31;
        C1592x c1592x = C1592x.f22337a;
        return ((((((((iHashCode + c1592x.b(this.f22271a)) * 31) + c1592x.b(this.f22272b)) * 31) + c1592x.b(this.f22273c)) * 31) + c1592x.b(this.f22274d)) * 31) + c1592x.b(this.f22275e);
    }

    public String toString() {
        return "CreationOptions(uri=" + this.f22271a + ", formatHint=" + this.f22272b + ", httpHeaders=" + this.f22273c + ", userAgent=" + this.f22274d + ", backBufferDurationMs=" + this.f22275e + ")";
    }
}
