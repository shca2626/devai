package p5;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20800c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20801a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20802b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final K a(List list) {
            M5.m.e(list, "pigeonVar_list");
            String str = (String) list.get(0);
            Object obj = list.get(1);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return new K(str, ((Boolean) obj).booleanValue());
        }

        public a() {
        }
    }

    public K(String str, boolean z7) {
        this.f20801a = str;
        this.f20802b = z7;
    }

    public final String a() {
        return this.f20801a;
    }

    public final List b() {
        return C1881o.l(this.f20801a, Boolean.valueOf(this.f20802b));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), K.class)) {
            if (this == obj) {
                return true;
            }
            K k7 = (K) obj;
            C1450d c1450d = C1450d.f20989a;
            if (c1450d.a(this.f20801a, k7.f20801a) && c1450d.a(Boolean.valueOf(this.f20802b), Boolean.valueOf(k7.f20802b))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = K.class.hashCode() * 31;
        C1450d c1450d = C1450d.f20989a;
        return ((iHashCode + c1450d.b(this.f20801a)) * 31) + c1450d.b(Boolean.valueOf(this.f20802b));
    }

    public String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.f20801a + ", useDataStore=" + this.f20802b + ")";
    }
}
