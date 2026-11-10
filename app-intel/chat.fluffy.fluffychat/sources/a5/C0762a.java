package a5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: a5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0762a {
    public static ApplicationInfo a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static String b(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str, null);
    }

    public static String c(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(str, null);
        return string == null ? bundle.getString(str2) : string;
    }

    public static C0763b d(Context context) {
        ApplicationInfo applicationInfoA = a(context);
        return new C0763b(c(applicationInfoA.metaData, W4.c.f9044a.f9071b, W4.c.f9045b.f9071b), b(applicationInfoA.metaData, W4.c.f9055l.f9071b), b(applicationInfoA.metaData, W4.c.f9056m.f9071b), c(applicationInfoA.metaData, W4.c.f9046c.f9071b, W4.c.f9047d.f9071b), applicationInfoA.nativeLibraryDir);
    }
}
