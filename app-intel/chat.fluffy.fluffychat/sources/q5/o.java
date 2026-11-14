package q5;

import java.util.List;
import java.util.Map;
import z5.C1884o;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: d, reason: collision with root package name */
    public static final a f21467d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21468a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f21469b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f21470c;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final o a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
            Object obj3 = list.get(2);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            return new o(zBooleanValue, zBooleanValue2, (Map) obj3);
        }

        public a() {
        }
    }

    public o(boolean z7, boolean z8, Map map) {
        M5.m.e(map, "headers");
        this.f21468a = z7;
        this.f21469b = z8;
        this.f21470c = map;
    }

    public final boolean a() {
        return this.f21469b;
    }

    public final boolean b() {
        return this.f21468a;
    }

    public final Map c() {
        return this.f21470c;
    }

    public final List d() {
        return C1884o.l(Boolean.valueOf(this.f21468a), Boolean.valueOf(this.f21469b), this.f21470c);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), o.class)) {
            if (this == obj) {
                return true;
            }
            o oVar = (o) obj;
            C1504d c1504d = C1504d.f21453a;
            if (c1504d.a(Boolean.valueOf(this.f21468a), Boolean.valueOf(oVar.f21468a)) && c1504d.a(Boolean.valueOf(this.f21469b), Boolean.valueOf(oVar.f21469b)) && c1504d.a(this.f21470c, oVar.f21470c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = o.class.hashCode() * 31;
        C1504d c1504d = C1504d.f21453a;
        return ((((iHashCode + c1504d.b(Boolean.valueOf(this.f21468a))) * 31) + c1504d.b(Boolean.valueOf(this.f21469b))) * 31) + c1504d.b(this.f21470c);
    }

    public String toString() {
        return "WebViewOptions(enableJavaScript=" + this.f21468a + ", enableDomStorage=" + this.f21469b + ", headers=" + this.f21470c + ")";
    }
}
