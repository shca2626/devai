package o;

import android.content.Context;
import android.content.res.Configuration;
import i.AbstractC1146b;

/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1378a {

    /* renamed from: a, reason: collision with root package name */
    public Context f20240a;

    public C1378a(Context context) {
        this.f20240a = context;
    }

    public static C1378a b(Context context) {
        return new C1378a(context);
    }

    public boolean a() {
        return this.f20240a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f20240a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f20240a.getResources().getConfiguration();
        int i7 = configuration.screenWidthDp;
        int i8 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i7 > 600) {
            return 5;
        }
        if (i7 > 960 && i8 > 720) {
            return 5;
        }
        if (i7 > 720 && i8 > 960) {
            return 5;
        }
        if (i7 >= 500) {
            return 4;
        }
        if (i7 > 640 && i8 > 480) {
            return 4;
        }
        if (i7 <= 480 || i8 <= 640) {
            return i7 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean e() {
        return this.f20240a.getResources().getBoolean(AbstractC1146b.f16956a);
    }

    public boolean f() {
        return true;
    }
}
