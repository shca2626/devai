package C2;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.StatFs;
import java.io.File;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f1343a = new n();

    public final int a(int i7, int i8, Bitmap.Config config) {
        return i7 * i8 * a.b(config);
    }

    public final long b(Context context, double d7) {
        int largeMemoryClass;
        Object objH;
        M5.m.e(context, "context");
        try {
            objH = L.b.h(context, ActivityManager.class);
        } catch (Exception unused) {
            largeMemoryClass = 256;
        }
        if (objH != null) {
            ActivityManager activityManager = (ActivityManager) objH;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
            double d8 = 1024;
            return (long) (d7 * largeMemoryClass * d8 * d8);
        }
        throw new IllegalStateException(("System service of type " + ActivityManager.class + " was not found.").toString());
    }

    public final long c(File file) {
        M5.m.e(file, "cacheDirectory");
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return S5.e.k((long) (0.02d * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), 10485760L, 262144000L);
        } catch (Exception unused) {
            return 10485760L;
        }
    }

    public final Bitmap.Config d() {
        return Build.VERSION.SDK_INT >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public final double e(Context context) {
        M5.m.e(context, "context");
        try {
            Object objH = L.b.h(context, ActivityManager.class);
            if (objH != null) {
                return ((ActivityManager) objH).isLowRamDevice() ? 0.15d : 0.2d;
            }
            throw new IllegalStateException(("System service of type " + ActivityManager.class + " was not found.").toString());
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    public final double f() {
        return 0.0d;
    }

    public final File g(Context context) {
        M5.m.e(context, "context");
        File file = new File(context.getCacheDir(), "image_cache");
        file.mkdirs();
        return file;
    }
}
