package i4;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class t {

    /* renamed from: q, reason: collision with root package name */
    public static final Boolean f17507q;

    /* renamed from: r, reason: collision with root package name */
    public static final Boolean f17508r;

    /* renamed from: s, reason: collision with root package name */
    public static final Boolean f17509s;

    /* renamed from: t, reason: collision with root package name */
    public static final Boolean f17510t;

    /* renamed from: u, reason: collision with root package name */
    public static final Boolean f17511u;

    /* renamed from: v, reason: collision with root package name */
    public static final Boolean f17512v;

    /* renamed from: a, reason: collision with root package name */
    public final String f17513a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17514b;

    /* renamed from: c, reason: collision with root package name */
    public final String f17515c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f17516d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f17517e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f17518f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f17519g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f17520h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f17521i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f17522j;

    /* renamed from: k, reason: collision with root package name */
    public final String f17523k;

    /* renamed from: l, reason: collision with root package name */
    public final String f17524l;

    /* renamed from: m, reason: collision with root package name */
    public final String f17525m;

    /* renamed from: n, reason: collision with root package name */
    public final String f17526n;

    /* renamed from: o, reason: collision with root package name */
    public final String f17527o;

    /* renamed from: p, reason: collision with root package name */
    public final Map f17528p;

    static {
        Boolean bool = Boolean.FALSE;
        f17507q = bool;
        Boolean bool2 = Boolean.TRUE;
        f17508r = bool2;
        f17509s = bool;
        f17510t = bool;
        f17511u = bool;
        f17512v = bool2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t(java.util.Map r7) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.t.<init>(java.util.Map):void");
    }

    public String a() {
        return this.f17525m;
    }

    public String b() {
        return this.f17523k;
    }

    public final boolean c(Map map, String str, boolean z7) {
        Object obj = map.get(str);
        return obj instanceof String ? Boolean.parseBoolean((String) obj) : z7;
    }

    public String d() {
        String str = this.f17514b;
        return str != null ? str : this.f17513a;
    }

    public String e() {
        if (this.f17514b == null) {
            return "FlutterSecureKeyStorage";
        }
        return "FlutterSecureKeyStorage:" + this.f17514b;
    }

    public boolean f() {
        return this.f17519g;
    }

    public String g() {
        if (this.f17514b == null) {
            return "";
        }
        return "." + this.f17514b;
    }

    public final String h(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.isEmpty()) {
                return str2;
            }
        }
        return null;
    }

    public String i() {
        return this.f17524l;
    }

    public String j() {
        return this.f17526n;
    }

    public String k() {
        return this.f17527o;
    }

    public boolean l() {
        return this.f17520h;
    }

    public String m() {
        return this.f17515c;
    }

    public String n() {
        return this.f17513a;
    }

    public String o() {
        return this.f17514b;
    }

    public final String p(Map map, String str, String str2) {
        String strH = h(map, str);
        return strH != null ? strH : str2;
    }

    public final String q(Map map, String str, String str2, String str3) {
        String strH = h(map, str);
        if (strH != null) {
            return strH;
        }
        String strH2 = h(map, str2);
        return strH2 != null ? strH2 : str3;
    }

    public boolean r() {
        return this.f17514b != null;
    }

    public boolean s() {
        return this.f17522j;
    }

    public boolean t() {
        return this.f17521i;
    }

    public String toString() {
        return "FlutterSecureStorageConfig{sharedPreferencesName='" + this.f17513a + "', sharedPreferencesKeyPrefix='" + this.f17515c + "', deleteOnFailure=" + this.f17516d + ", migrateOnAlgorithmChange=" + this.f17517e + ", migrateWithBackup=" + this.f17518f + ", enforceBiometrics=" + this.f17519g + ", requireBiometricsPerOperation=" + this.f17520h + ", storageNamespace='" + this.f17514b + "'}";
    }

    public boolean u() {
        return this.f17516d;
    }

    public boolean v() {
        return this.f17517e;
    }

    public boolean w() {
        return this.f17518f;
    }

    public t x(String str) {
        HashMap map = new HashMap(this.f17528p);
        map.put("storageNamespace", str);
        return new t(map);
    }

    public t y() {
        HashMap map = new HashMap(this.f17528p);
        map.remove("storageNamespace");
        return new t(map);
    }
}
