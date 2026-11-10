package r5;

import java.util.List;
import z5.C1881o;

/* renamed from: r5.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1587q extends C {

    /* renamed from: e, reason: collision with root package name */
    public static final a f22321e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22322a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22323b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22324c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22325d;

    /* renamed from: r5.q$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1587q a(List list) {
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
            return new C1587q(jLongValue, jLongValue2, jLongValue3, ((Long) obj4).longValue());
        }

        public a() {
        }
    }

    public C1587q(long j7, long j8, long j9, long j10) {
        super(null);
        this.f22322a = j7;
        this.f22323b = j8;
        this.f22324c = j9;
        this.f22325d = j10;
    }

    public final List a() {
        return C1881o.l(Long.valueOf(this.f22322a), Long.valueOf(this.f22323b), Long.valueOf(this.f22324c), Long.valueOf(this.f22325d));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1587q.class)) {
            if (this == obj) {
                return true;
            }
            C1587q c1587q = (C1587q) obj;
            C1593x c1593x = C1593x.f22331a;
            if (c1593x.a(Long.valueOf(this.f22322a), Long.valueOf(c1587q.f22322a)) && c1593x.a(Long.valueOf(this.f22323b), Long.valueOf(c1587q.f22323b)) && c1593x.a(Long.valueOf(this.f22324c), Long.valueOf(c1587q.f22324c)) && c1593x.a(Long.valueOf(this.f22325d), Long.valueOf(c1587q.f22325d))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1587q.class.hashCode() * 31;
        C1593x c1593x = C1593x.f22331a;
        return ((((((iHashCode + c1593x.b(Long.valueOf(this.f22322a))) * 31) + c1593x.b(Long.valueOf(this.f22323b))) * 31) + c1593x.b(Long.valueOf(this.f22324c))) * 31) + c1593x.b(Long.valueOf(this.f22325d));
    }

    public String toString() {
        return "InitializationEvent(duration=" + this.f22322a + ", width=" + this.f22323b + ", height=" + this.f22324c + ", rotationCorrection=" + this.f22325d + ")";
    }
}
