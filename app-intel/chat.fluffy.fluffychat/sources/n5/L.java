package n5;

import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20126c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final M f20127a;

    /* renamed from: b, reason: collision with root package name */
    public final K f20128b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final L a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.SourceType");
            return new L((M) obj, (K) list.get(1));
        }

        public a() {
        }
    }

    public L(M m7, K k7) {
        M5.m.e(m7, "type");
        this.f20127a = m7;
        this.f20128b = k7;
    }

    public final K a() {
        return this.f20128b;
    }

    public final M b() {
        return this.f20127a;
    }

    public final List c() {
        return C1884o.l(this.f20127a, this.f20128b);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), L.class)) {
            if (this == obj) {
                return true;
            }
            L l7 = (L) obj;
            I i7 = I.f20119a;
            if (i7.a(this.f20127a, l7.f20127a) && i7.a(this.f20128b, l7.f20128b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = L.class.hashCode() * 31;
        I i7 = I.f20119a;
        return ((iHashCode + i7.b(this.f20127a)) * 31) + i7.b(this.f20128b);
    }

    public String toString() {
        return "SourceSpecification(type=" + this.f20127a + ", camera=" + this.f20128b + ")";
    }
}
