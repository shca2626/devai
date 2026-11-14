package F2;

import java.util.Map;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f2676a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2677b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2678c;

    /* renamed from: d, reason: collision with root package name */
    public final C0341a f2679d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2680e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2681f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2682g;

    /* renamed from: h, reason: collision with root package name */
    public final Integer f2683h;

    public g(String str, String str2, String str3, C0341a c0341a, boolean z7, boolean z8, boolean z9, Integer num) {
        this.f2676a = str;
        this.f2677b = str2;
        this.f2678c = str3;
        this.f2679d = c0341a;
        this.f2680e = z7;
        this.f2681f = z8;
        this.f2682g = z9;
        this.f2683h = num;
    }

    public static g i(Map map) {
        if (map == null) {
            return null;
        }
        C0341a c0341aC = C0341a.c((Map) map.get("notificationIcon"));
        String str = (String) map.get("notificationTitle");
        String str2 = (String) map.get("notificationChannelName");
        String str3 = (String) map.get("notificationText");
        Boolean bool = (Boolean) map.get("enableWifiLock");
        Boolean bool2 = (Boolean) map.get("enableWakeLock");
        Boolean bool3 = (Boolean) map.get("setOngoing");
        Object obj = map.get("color");
        return new g(str, str3, str2, c0341aC, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue(), obj != null ? Integer.valueOf(((Number) obj).intValue()) : null);
    }

    public Integer a() {
        return this.f2683h;
    }

    public String b() {
        return this.f2678c;
    }

    public C0341a c() {
        return this.f2679d;
    }

    public String d() {
        return this.f2677b;
    }

    public String e() {
        return this.f2676a;
    }

    public boolean f() {
        return this.f2681f;
    }

    public boolean g() {
        return this.f2680e;
    }

    public boolean h() {
        return this.f2682g;
    }
}
