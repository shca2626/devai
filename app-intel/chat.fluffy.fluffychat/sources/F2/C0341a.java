package F2;

import java.util.Map;

/* renamed from: F2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0341a {

    /* renamed from: a, reason: collision with root package name */
    public final String f2669a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2670b;

    public C0341a(String str, String str2) {
        this.f2669a = str;
        this.f2670b = str2;
    }

    public static C0341a c(Map map) {
        if (map == null) {
            return null;
        }
        return new C0341a((String) map.get("name"), (String) map.get("defType"));
    }

    public String a() {
        return this.f2670b;
    }

    public String b() {
        return this.f2669a;
    }
}
