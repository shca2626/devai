package o5;

import java.util.List;
import z5.C1884o;

/* renamed from: o5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1407b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20417d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20418a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20419b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20420c;

    /* renamed from: o5.b$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1407b a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
            Object obj3 = list.get(2);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new C1407b(zBooleanValue, zBooleanValue2, ((Boolean) obj3).booleanValue());
        }

        public a() {
        }
    }

    public C1407b(boolean z7, boolean z8, boolean z9) {
        this.f20418a = z7;
        this.f20419b = z8;
        this.f20420c = z9;
    }

    public final boolean a() {
        return this.f20418a;
    }

    public final boolean b() {
        return this.f20419b;
    }

    public final boolean c() {
        return this.f20420c;
    }

    public final List d() {
        return C1884o.l(Boolean.valueOf(this.f20418a), Boolean.valueOf(this.f20419b), Boolean.valueOf(this.f20420c));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1407b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return s.f20478a.a(d(), ((C1407b) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return "AuthOptions(biometricOnly=" + this.f20418a + ", sensitiveTransaction=" + this.f20419b + ", sticky=" + this.f20420c + ")";
    }
}
