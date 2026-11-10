package r5;

import java.util.List;
import z5.C1880n;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22186b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22187a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final E a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Long");
            return new E(((Long) obj).longValue());
        }

        public a() {
        }
    }

    public E(long j7) {
        this.f22187a = j7;
    }

    public final long a() {
        return this.f22187a;
    }

    public final List b() {
        return C1880n.d(Long.valueOf(this.f22187a));
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), E.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1593x.f22331a.a(Long.valueOf(this.f22187a), Long.valueOf(((E) obj).f22187a));
    }

    public int hashCode() {
        return (E.class.hashCode() * 31) + C1593x.f22331a.b(Long.valueOf(this.f22187a));
    }

    public String toString() {
        return "PlatformVideoViewCreationParams(playerId=" + this.f22187a + ")";
    }
}
