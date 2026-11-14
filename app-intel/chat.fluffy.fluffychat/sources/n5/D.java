package n5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class D {
    public static int a(C1369g c1369g) {
        Long lB = c1369g.b();
        int iB = b();
        return (lB == null || lB.longValue() >= ((long) iB)) ? iB : Math.toIntExact(lB.longValue());
    }

    public static int b() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33 || (i7 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2)) {
            return MediaStore.getPickImagesMaxLimit();
        }
        return Integer.MAX_VALUE;
    }

    public static PackageInfo c(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 4096);
    }

    public static boolean d(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return Arrays.asList((Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)) : c(packageManager, context.getPackageName())).requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e7) {
            e7.printStackTrace();
            return false;
        }
    }

    public static boolean e(Context context) {
        return d(context, "android.permission.CAMERA");
    }
}
