package r5;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: c, reason: collision with root package name */
    public static final a f22188c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22189a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22190b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final F a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Long");
            return new F(jLongValue, ((Long) obj2).longValue());
        }

        public a() {
        }
    }

    public F(long j7, long j8) {
        this.f22189a = j7;
        this.f22190b = j8;
    }

    public final List a() {
        return C1881o.l(Long.valueOf(this.f22189a), Long.valueOf(this.f22190b));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), F.class)) {
            if (this == obj) {
                return true;
            }
            F f7 = (F) obj;
            C1593x c1593x = C1593x.f22331a;
            if (c1593x.a(Long.valueOf(this.f22189a), Long.valueOf(f7.f22189a)) && c1593x.a(Long.valueOf(this.f22190b), Long.valueOf(f7.f22190b))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = F.class.hashCode() * 31;
        C1593x c1593x = C1593x.f22331a;
        return ((iHashCode + c1593x.b(Long.valueOf(this.f22189a))) * 31) + c1593x.b(Long.valueOf(this.f22190b));
    }

    public String toString() {
        return "PlaybackState(playPosition=" + this.f22189a + ", bufferPosition=" + this.f22190b + ")";
    }
}
