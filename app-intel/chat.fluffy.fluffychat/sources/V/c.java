package V;

import M5.m;
import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f8476a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final int f8477b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f8478c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f8479d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f8480e;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8481a = new a();

        public final int a(int i7) {
            return SdkExtensions.getExtensionVersion(i7);
        }
    }

    static {
        int i7 = Build.VERSION.SDK_INT;
        f8477b = i7 >= 30 ? a.f8481a.a(30) : 0;
        f8478c = i7 >= 30 ? a.f8481a.a(31) : 0;
        f8479d = i7 >= 30 ? a.f8481a.a(33) : 0;
        f8480e = i7 >= 30 ? a.f8481a.a(1000000) : 0;
    }

    public static final boolean a() {
        return Build.VERSION.SDK_INT >= 36 && b.a() >= 3600001;
    }

    public static final boolean b(String str, String str2) {
        m.e(str, "codename");
        m.e(str2, "buildCodename");
        if (m.a("REL", str2)) {
            return false;
        }
        Integer numC = c(str2);
        Integer numC2 = c(str);
        if (numC != null && numC2 != null) {
            return numC.intValue() >= numC2.intValue();
        }
        if (numC != null || numC2 != null) {
            return numC != null;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        m.d(upperCase, "toUpperCase(...)");
        String upperCase2 = str.toUpperCase(locale);
        m.d(upperCase2, "toUpperCase(...)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final Integer c(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        m.d(upperCase, "toUpperCase(...)");
        return m.a(upperCase, "BAKLAVA") ? 0 : null;
    }

    public static final boolean d() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33) {
            return true;
        }
        if (i7 < 32) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        m.d(str, "CODENAME");
        return b("Tiramisu", str);
    }
}
