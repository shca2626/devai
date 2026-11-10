package n5;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20114d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Double f20115a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f20116b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20117c;

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
        this.f20115a = d7;
        this.f20116b = d8;
        this.f20117c = j7;
    }

    public final Double a() {
        return this.f20116b;
    }

    public final Double b() {
        return this.f20115a;
    }

    public final long c() {
        return this.f20117c;
    }

    public final List d() {
        return C1881o.l(this.f20115a, this.f20116b, Long.valueOf(this.f20117c));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), F.class)) {
            if (this == obj) {
                return true;
            }
            F f7 = (F) obj;
            I i7 = I.f20120a;
            if (i7.a(this.f20115a, f7.f20115a) && i7.a(this.f20116b, f7.f20116b) && i7.a(Long.valueOf(this.f20117c), Long.valueOf(f7.f20117c))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = F.class.hashCode() * 31;
        I i7 = I.f20120a;
        return ((((iHashCode + i7.b(this.f20115a)) * 31) + i7.b(this.f20116b)) * 31) + i7.b(Long.valueOf(this.f20117c));
    }

    public String toString() {
        return "ImageSelectionOptions(maxWidth=" + this.f20115a + ", maxHeight=" + this.f20116b + ", quality=" + this.f20117c + ")";
    }
}
