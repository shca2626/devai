package n5;

import java.util.List;
import z5.C1880n;

/* loaded from: classes.dex */
public final class N {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20136b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f20137a;

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
        return this.f20137a;
    }

    public final List b() {
        return C1880n.d(this.f20137a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), N.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return I.f20120a.a(this.f20137a, ((N) obj).f20137a);
    }

    public int hashCode() {
        return (N.class.hashCode() * 31) + I.f20120a.b(this.f20137a);
    }

    public String toString() {
        return "VideoSelectionOptions(maxDurationSeconds=" + this.f20137a + ")";
    }

    public N(Long l7) {
        this.f20137a = l7;
    }

    public /* synthetic */ N(Long l7, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : l7);
    }
}
