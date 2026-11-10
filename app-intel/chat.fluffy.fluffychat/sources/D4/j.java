package D4;

import M5.m;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: m, reason: collision with root package name */
    public static final a f1807m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f1808a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1809b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1810c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1811d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1812e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1813f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1814g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1815h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1816i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1817j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f1818k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1819l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        }

        public final j b(Context context) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0);
            int i7 = sharedPreferences.getInt("serviceId", sharedPreferences.getInt("notificationId", 1000));
            String string = sharedPreferences.getString("notificationChannelId", null);
            if (string == null) {
                string = "foreground_service";
            }
            String str = string;
            String string2 = sharedPreferences.getString("notificationChannelName", null);
            if (string2 == null) {
                string2 = "Foreground Service";
            }
            return new j(i7, str, string2, sharedPreferences.getString("notificationChannelDescription", null), sharedPreferences.getInt("notificationChannelImportance", 2), sharedPreferences.getInt("notificationPriority", -1), sharedPreferences.getBoolean("enableVibration", false), sharedPreferences.getBoolean("playSound", false), sharedPreferences.getBoolean("showWhen", false), sharedPreferences.getBoolean("showBadge", false), sharedPreferences.getBoolean("onlyAlertOnce", false), sharedPreferences.getInt("visibility", 1));
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[PHI: r5
          0x0024: PHI (r5v13 java.lang.Integer) = (r5v3 java.lang.Integer), (r5v7 java.lang.Integer) binds: [B:10:0x0022, B:19:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(android.content.Context r27, java.util.Map r28) {
            /*
                Method dump skipped, instructions count: 441
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: D4.j.a.c(android.content.Context, java.util.Map):void");
        }

        public a() {
        }
    }

    public j(int i7, String str, String str2, String str3, int i8, int i9, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i10) {
        m.e(str, "channelId");
        m.e(str2, "channelName");
        this.f1808a = i7;
        this.f1809b = str;
        this.f1810c = str2;
        this.f1811d = str3;
        this.f1812e = i8;
        this.f1813f = i9;
        this.f1814g = z7;
        this.f1815h = z8;
        this.f1816i = z9;
        this.f1817j = z10;
        this.f1818k = z11;
        this.f1819l = i10;
    }

    public final String a() {
        return this.f1811d;
    }

    public final String b() {
        return this.f1809b;
    }

    public final int c() {
        return this.f1812e;
    }

    public final String d() {
        return this.f1810c;
    }

    public final boolean e() {
        return this.f1814g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f1808a == jVar.f1808a && m.a(this.f1809b, jVar.f1809b) && m.a(this.f1810c, jVar.f1810c) && m.a(this.f1811d, jVar.f1811d) && this.f1812e == jVar.f1812e && this.f1813f == jVar.f1813f && this.f1814g == jVar.f1814g && this.f1815h == jVar.f1815h && this.f1816i == jVar.f1816i && this.f1817j == jVar.f1817j && this.f1818k == jVar.f1818k && this.f1819l == jVar.f1819l;
    }

    public final boolean f() {
        return this.f1818k;
    }

    public final boolean g() {
        return this.f1815h;
    }

    public final int h() {
        return this.f1813f;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.f1808a) * 31) + this.f1809b.hashCode()) * 31) + this.f1810c.hashCode()) * 31;
        String str = this.f1811d;
        return ((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.f1812e)) * 31) + Integer.hashCode(this.f1813f)) * 31) + Boolean.hashCode(this.f1814g)) * 31) + Boolean.hashCode(this.f1815h)) * 31) + Boolean.hashCode(this.f1816i)) * 31) + Boolean.hashCode(this.f1817j)) * 31) + Boolean.hashCode(this.f1818k)) * 31) + Integer.hashCode(this.f1819l);
    }

    public final int i() {
        return this.f1808a;
    }

    public final boolean j() {
        return this.f1817j;
    }

    public final boolean k() {
        return this.f1816i;
    }

    public final int l() {
        return this.f1819l;
    }

    public String toString() {
        return "NotificationOptions(serviceId=" + this.f1808a + ", channelId=" + this.f1809b + ", channelName=" + this.f1810c + ", channelDescription=" + this.f1811d + ", channelImportance=" + this.f1812e + ", priority=" + this.f1813f + ", enableVibration=" + this.f1814g + ", playSound=" + this.f1815h + ", showWhen=" + this.f1816i + ", showBadge=" + this.f1817j + ", onlyAlertOnce=" + this.f1818k + ", visibility=" + this.f1819l + ")";
    }
}
