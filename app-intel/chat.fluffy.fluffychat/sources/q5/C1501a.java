package q5;

import java.util.List;
import z5.C1883n;

/* renamed from: q5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1501a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0258a f21448b = new C0258a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21449a;

    /* renamed from: q5.a$a, reason: collision with other inner class name */
    public static final class C0258a {
        public /* synthetic */ C0258a(M5.g gVar) {
            this();
        }

        public final C1501a a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return new C1501a(((Boolean) obj).booleanValue());
        }

        public C0258a() {
        }
    }

    public C1501a(boolean z7) {
        this.f21449a = z7;
    }

    public final boolean a() {
        return this.f21449a;
    }

    public final List b() {
        return C1883n.d(Boolean.valueOf(this.f21449a));
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), C1501a.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1504d.f21453a.a(Boolean.valueOf(this.f21449a), Boolean.valueOf(((C1501a) obj).f21449a));
    }

    public int hashCode() {
        return (C1501a.class.hashCode() * 31) + C1504d.f21453a.b(Boolean.valueOf(this.f21449a));
    }

    public String toString() {
        return "BrowserOptions(showTitle=" + this.f21449a + ")";
    }
}
