package u;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public abstract class n {

    public static class a {
        public static boolean a(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.hardware.fingerprint");
        }
    }

    public static boolean a(Context context) {
        return (context == null || context.getPackageManager() == null || !a.a(context.getPackageManager())) ? false : true;
    }
}
