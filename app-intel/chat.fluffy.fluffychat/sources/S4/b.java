package S4;

import M5.m;
import java.util.List;
import z5.C1883n;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f8193b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f8194a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final b a(List list) {
            m.e(list, "pigeonVar_list");
            return new b((Boolean) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Boolean a() {
        return this.f8194a;
    }

    public final List b() {
        return C1883n.d(this.f8194a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !m.a(obj.getClass(), b.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return i.f8202a.a(this.f8194a, ((b) obj).f8194a);
    }

    public int hashCode() {
        return (b.class.hashCode() * 31) + i.f8202a.b(this.f8194a);
    }

    public String toString() {
        return "ToggleMessage(enable=" + this.f8194a + ")";
    }

    public b(Boolean bool) {
        this.f8194a = bool;
    }

    public /* synthetic */ b(Boolean bool, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : bool);
    }
}
