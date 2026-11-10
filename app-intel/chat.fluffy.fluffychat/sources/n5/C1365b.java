package n5;

import java.util.List;
import z5.C1881o;

/* renamed from: n5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1365b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20141d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final EnumC1366c f20142a;

    /* renamed from: b, reason: collision with root package name */
    public final C1364a f20143b;

    /* renamed from: c, reason: collision with root package name */
    public final List f20144c;

    /* renamed from: n5.b$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1365b a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.CacheRetrievalType");
            C1364a c1364a = (C1364a) list.get(1);
            Object obj2 = list.get(2);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            return new C1365b((EnumC1366c) obj, c1364a, (List) obj2);
        }

        public a() {
        }
    }

    public C1365b(EnumC1366c enumC1366c, C1364a c1364a, List list) {
        M5.m.e(enumC1366c, "type");
        M5.m.e(list, "paths");
        this.f20142a = enumC1366c;
        this.f20143b = c1364a;
        this.f20144c = list;
    }

    public final List a() {
        return C1881o.l(this.f20142a, this.f20143b, this.f20144c);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1365b.class)) {
            if (this == obj) {
                return true;
            }
            C1365b c1365b = (C1365b) obj;
            I i7 = I.f20120a;
            if (i7.a(this.f20142a, c1365b.f20142a) && i7.a(this.f20143b, c1365b.f20143b) && i7.a(this.f20144c, c1365b.f20144c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1365b.class.hashCode() * 31;
        I i7 = I.f20120a;
        return ((((iHashCode + i7.b(this.f20142a)) * 31) + i7.b(this.f20143b)) * 31) + i7.b(this.f20144c);
    }

    public String toString() {
        return "CacheRetrievalResult(type=" + this.f20142a + ", error=" + this.f20143b + ", paths=" + this.f20144c + ")";
    }
}
