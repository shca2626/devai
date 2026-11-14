package n5;

import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20113d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Double f20114a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f20115b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20116c;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final F a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Double d7 = (Double) list.get(0);
            Double d8 = (Double) list.get(1);
            Object obj = list.get(2);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Long");
            return new F(d7, d8, ((Long) obj).longValue());
        }

        public a() {
        }
    }

    public F(Double d7, Double d8, long j7) {
        this.f20114a = d7;
        this.f20115b = d8;
        this.f20116c = j7;
    }

    public final Double a() {
        return this.f20115b;
    }

    public final Double b() {
        return this.f20114a;
    }

    public final long c() {
        return this.f20116c;
    }

    public final List d() {
        return C1884o.l(this.f20114a, this.f20115b, Long.valueOf(this.f20116c));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), F.class)) {
            if (this == obj) {
                return true;
            }
            F f7 = (F) obj;
            I i7 = I.f20119a;
            if (i7.a(this.f20114a, f7.f20114a) && i7.a(this.f20115b, f7.f20115b) && i7.a(Long.valueOf(this.f20116c), Long.valueOf(f7.f20116c))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = F.class.hashCode() * 31;
        I i7 = I.f20119a;
        return ((((iHashCode + i7.b(this.f20114a)) * 31) + i7.b(this.f20115b)) * 31) + i7.b(Long.valueOf(this.f20116c));
    }

    public String toString() {
        return "ImageSelectionOptions(maxWidth=" + this.f20114a + ", maxHeight=" + this.f20115b + ", quality=" + this.f20116c + ")";
    }
}
