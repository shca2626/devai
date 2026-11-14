package r5;

import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class J {

    /* renamed from: c, reason: collision with root package name */
    public static final a f22205c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22206a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22207b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final J a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Long");
            return new J(jLongValue, ((Long) obj2).longValue());
        }

        public a() {
        }
    }

    public J(long j7, long j8) {
        this.f22206a = j7;
        this.f22207b = j8;
    }

    public final List a() {
        return C1884o.l(Long.valueOf(this.f22206a), Long.valueOf(this.f22207b));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), J.class)) {
            if (this == obj) {
                return true;
            }
            J j7 = (J) obj;
            C1592x c1592x = C1592x.f22337a;
            if (c1592x.a(Long.valueOf(this.f22206a), Long.valueOf(j7.f22206a)) && c1592x.a(Long.valueOf(this.f22207b), Long.valueOf(j7.f22207b))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = J.class.hashCode() * 31;
        C1592x c1592x = C1592x.f22337a;
        return ((iHashCode + c1592x.b(Long.valueOf(this.f22206a))) * 31) + c1592x.b(Long.valueOf(this.f22207b));
    }

    public String toString() {
        return "TexturePlayerIds(playerId=" + this.f22206a + ", textureId=" + this.f22207b + ")";
    }
}
