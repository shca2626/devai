package S4;

import M5.m;
import java.util.List;
import z5.C1880n;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0066a f8191b = new C0066a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f8192a;

    /* renamed from: S4.a$a, reason: collision with other inner class name */
    public static final class C0066a {
        public /* synthetic */ C0066a(M5.g gVar) {
            this();
        }

        public final a a(List list) {
            m.e(list, "pigeonVar_list");
            return new a((Boolean) list.get(0));
        }

        public C0066a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1880n.d(this.f8192a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !m.a(obj.getClass(), a.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return i.f8202a.a(this.f8192a, ((a) obj).f8192a);
    }

    public int hashCode() {
        return (a.class.hashCode() * 31) + i.f8202a.b(this.f8192a);
    }

    public String toString() {
        return "IsEnabledMessage(enabled=" + this.f8192a + ")";
    }

    public a(Boolean bool) {
        this.f8192a = bool;
    }

    public /* synthetic */ a(Boolean bool, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : bool);
    }
}
