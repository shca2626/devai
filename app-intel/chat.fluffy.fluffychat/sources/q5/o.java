package q5;

import java.util.List;
import java.util.Map;
import z5.C1881o;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: d, reason: collision with root package name */
    public static final a f21461d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21462a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f21463b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f21464c;

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
        this.f21462a = z7;
        this.f21463b = z8;
        this.f21464c = map;
    }

    public final boolean a() {
        return this.f21463b;
    }

    public final boolean b() {
        return this.f21462a;
    }

    public final Map c() {
        return this.f21464c;
    }

    public final List d() {
        return C1881o.l(Boolean.valueOf(this.f21462a), Boolean.valueOf(this.f21463b), this.f21464c);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), o.class)) {
            if (this == obj) {
                return true;
            }
            o oVar = (o) obj;
            C1505d c1505d = C1505d.f21447a;
            if (c1505d.a(Boolean.valueOf(this.f21462a), Boolean.valueOf(oVar.f21462a)) && c1505d.a(Boolean.valueOf(this.f21463b), Boolean.valueOf(oVar.f21463b)) && c1505d.a(this.f21464c, oVar.f21464c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = o.class.hashCode() * 31;
        C1505d c1505d = C1505d.f21447a;
        return ((((iHashCode + c1505d.b(Boolean.valueOf(this.f21462a))) * 31) + c1505d.b(Boolean.valueOf(this.f21463b))) * 31) + c1505d.b(this.f21464c);
    }

    public String toString() {
        return "WebViewOptions(enableJavaScript=" + this.f21462a + ", enableDomStorage=" + this.f21463b + ", headers=" + this.f21464c + ")";
    }
}
