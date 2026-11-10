package N4;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6446c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List f6447a;

    /* renamed from: b, reason: collision with root package name */
    public final List f6448b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final p a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            return new p((List) obj, (List) obj2);
        }

        public a() {
        }
    }

    public p(List list, List list2) {
        M5.m.e(list, "mimeTypes");
        M5.m.e(list2, "extensions");
        this.f6447a = list;
        this.f6448b = list2;
    }

    public final List a() {
        return this.f6448b;
    }

    public final List b() {
        return this.f6447a;
    }

    public final List c() {
        return C1881o.l(this.f6447a, this.f6448b);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), p.class)) {
            if (this == obj) {
                return true;
            }
            p pVar = (p) obj;
            s sVar = s.f6449a;
            if (sVar.a(this.f6447a, pVar.f6447a) && sVar.a(this.f6448b, pVar.f6448b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = p.class.hashCode() * 31;
        s sVar = s.f6449a;
        return ((iHashCode + sVar.b(this.f6447a)) * 31) + sVar.b(this.f6448b);
    }

    public String toString() {
        return "FileTypes(mimeTypes=" + this.f6447a + ", extensions=" + this.f6448b + ")";
    }
}
