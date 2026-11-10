package r5;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class J {

    /* renamed from: c, reason: collision with root package name */
    public static final a f22199c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22200a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22201b;

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
        this.f22200a = j7;
        this.f22201b = j8;
    }

    public final List a() {
        return C1881o.l(Long.valueOf(this.f22200a), Long.valueOf(this.f22201b));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), J.class)) {
            if (this == obj) {
                return true;
            }
            J j7 = (J) obj;
            C1593x c1593x = C1593x.f22331a;
            if (c1593x.a(Long.valueOf(this.f22200a), Long.valueOf(j7.f22200a)) && c1593x.a(Long.valueOf(this.f22201b), Long.valueOf(j7.f22201b))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = J.class.hashCode() * 31;
        C1593x c1593x = C1593x.f22331a;
        return ((iHashCode + c1593x.b(Long.valueOf(this.f22200a))) * 31) + c1593x.b(Long.valueOf(this.f22201b));
    }

    public String toString() {
        return "TexturePlayerIds(playerId=" + this.f22200a + ", textureId=" + this.f22201b + ")";
    }
}
