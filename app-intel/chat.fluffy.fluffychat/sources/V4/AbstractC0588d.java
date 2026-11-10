package V4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: V4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0588d {
    public static boolean a(Context context) {
        Bundle bundle;
        Context applicationContext = context.getApplicationContext();
        try {
            bundle = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e7) {
            U4.b.c("ContentSizingFlag", "Could not get metadata", e7);
            bundle = null;
        }
        if (bundle != null) {
            return bundle.getBoolean("io.flutter.embedding.android.EnableContentSizing", false);
        }
        return false;
    }
}
