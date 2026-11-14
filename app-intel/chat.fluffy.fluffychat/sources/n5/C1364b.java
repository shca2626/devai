package n5;

import java.util.List;
import z5.C1884o;

/* renamed from: n5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1364b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20140d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final EnumC1365c f20141a;

    /* renamed from: b, reason: collision with root package name */
    public final C1363a f20142b;

    /* renamed from: c, reason: collision with root package name */
    public final List f20143c;

    /* renamed from: n5.b$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1364b a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.CacheRetrievalType");
            C1363a c1363a = (C1363a) list.get(1);
            Object obj2 = list.get(2);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            return new C1364b((EnumC1365c) obj, c1363a, (List) obj2);
        }

        public a() {
        }
    }

    public C1364b(EnumC1365c enumC1365c, C1363a c1363a, List list) {
        M5.m.e(enumC1365c, "type");
        M5.m.e(list, "paths");
        this.f20141a = enumC1365c;
        this.f20142b = c1363a;
        this.f20143c = list;
    }

    public final List a() {
        return C1884o.l(this.f20141a, this.f20142b, this.f20143c);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1364b.class)) {
            if (this == obj) {
                return true;
            }
            C1364b c1364b = (C1364b) obj;
            I i7 = I.f20119a;
            if (i7.a(this.f20141a, c1364b.f20141a) && i7.a(this.f20142b, c1364b.f20142b) && i7.a(this.f20143c, c1364b.f20143c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1364b.class.hashCode() * 31;
        I i7 = I.f20119a;
        return ((((iHashCode + i7.b(this.f20141a)) * 31) + i7.b(this.f20142b)) * 31) + i7.b(this.f20143c);
    }

    public String toString() {
        return "CacheRetrievalResult(type=" + this.f20141a + ", error=" + this.f20142b + ", paths=" + this.f20143c + ")";
    }
}
