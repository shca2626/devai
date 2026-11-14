package r5;

import java.util.List;
import z5.C1884o;

/* renamed from: r5.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1586q extends C {

    /* renamed from: e, reason: collision with root package name */
    public static final a f22327e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22328a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22329b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22330c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22331d;

    /* renamed from: r5.q$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1586q a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue2 = ((Long) obj2).longValue();
            Object obj3 = list.get(2);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue3 = ((Long) obj3).longValue();
            Object obj4 = list.get(3);
            M5.m.c(obj4, "null cannot be cast to non-null type kotlin.Long");
            return new C1586q(jLongValue, jLongValue2, jLongValue3, ((Long) obj4).longValue());
        }

        public a() {
        }
    }

    public C1586q(long j7, long j8, long j9, long j10) {
        super(null);
        this.f22328a = j7;
        this.f22329b = j8;
        this.f22330c = j9;
        this.f22331d = j10;
    }

    public final List a() {
        return C1884o.l(Long.valueOf(this.f22328a), Long.valueOf(this.f22329b), Long.valueOf(this.f22330c), Long.valueOf(this.f22331d));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1586q.class)) {
            if (this == obj) {
                return true;
            }
            C1586q c1586q = (C1586q) obj;
            C1592x c1592x = C1592x.f22337a;
            if (c1592x.a(Long.valueOf(this.f22328a), Long.valueOf(c1586q.f22328a)) && c1592x.a(Long.valueOf(this.f22329b), Long.valueOf(c1586q.f22329b)) && c1592x.a(Long.valueOf(this.f22330c), Long.valueOf(c1586q.f22330c)) && c1592x.a(Long.valueOf(this.f22331d), Long.valueOf(c1586q.f22331d))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1586q.class.hashCode() * 31;
        C1592x c1592x = C1592x.f22337a;
        return ((((((iHashCode + c1592x.b(Long.valueOf(this.f22328a))) * 31) + c1592x.b(Long.valueOf(this.f22329b))) * 31) + c1592x.b(Long.valueOf(this.f22330c))) * 31) + c1592x.b(Long.valueOf(this.f22331d));
    }

    public String toString() {
        return "InitializationEvent(duration=" + this.f22328a + ", width=" + this.f22329b + ", height=" + this.f22330c + ", rotationCorrection=" + this.f22331d + ")";
    }
}
