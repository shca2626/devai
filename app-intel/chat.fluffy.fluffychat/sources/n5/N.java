package n5;

import java.util.List;
import z5.C1883n;

/* loaded from: classes.dex */
public final class N {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20135b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f20136a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final N a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new N((Long) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public N() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Long a() {
        return this.f20136a;
    }

    public final List b() {
        return C1883n.d(this.f20136a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), N.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return I.f20119a.a(this.f20136a, ((N) obj).f20136a);
    }

    public int hashCode() {
        return (N.class.hashCode() * 31) + I.f20119a.b(this.f20136a);
    }

    public String toString() {
        return "VideoSelectionOptions(maxDurationSeconds=" + this.f20136a + ")";
    }

    public N(Long l7) {
        this.f20136a = l7;
    }

    public /* synthetic */ N(Long l7, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : l7);
    }
}
