package F6;

import M5.m;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f2738a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f2739b;

    public a(String str, Map map) {
        m.e(str, "method");
        m.e(map, "data");
        this.f2738a = str;
        this.f2739b = map;
    }

    public final Map a() {
        return this.f2739b;
    }

    public final String b() {
        return this.f2738a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.f2738a, aVar.f2738a) && m.a(this.f2739b, aVar.f2739b);
    }

    public int hashCode() {
        return (this.f2738a.hashCode() * 31) + this.f2739b.hashCode();
    }

    public String toString() {
        return "Call(method=" + this.f2738a + ", data=" + this.f2739b + ')';
    }
}
