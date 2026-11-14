package p5;

import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20806c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f20807a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20808b;

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
        this.f20807a = str;
        this.f20808b = z7;
    }

    public final String a() {
        return this.f20807a;
    }

    public final List b() {
        return C1884o.l(this.f20807a, Boolean.valueOf(this.f20808b));
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), K.class)) {
            if (this == obj) {
                return true;
            }
            K k7 = (K) obj;
            C1449d c1449d = C1449d.f20995a;
            if (c1449d.a(this.f20807a, k7.f20807a) && c1449d.a(Boolean.valueOf(this.f20808b), Boolean.valueOf(k7.f20808b))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = K.class.hashCode() * 31;
        C1449d c1449d = C1449d.f20995a;
        return ((iHashCode + c1449d.b(this.f20807a)) * 31) + c1449d.b(Boolean.valueOf(this.f20808b));
    }

    public String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.f20807a + ", useDataStore=" + this.f20808b + ")";
    }
}
