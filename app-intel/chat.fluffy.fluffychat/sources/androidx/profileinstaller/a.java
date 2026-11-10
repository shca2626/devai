package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    public static class C0119a {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    public static class b {
        public static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    public static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z7 = true;
        for (File file2 : fileArrListFiles) {
            z7 = a(file2) && z7;
        }
        return z7;
    }

    public static void b(Context context, ProfileInstallReceiver.a aVar) {
        if (a(Build.VERSION.SDK_INT >= 34 ? b.a(context).getCacheDir() : C0119a.a(b.a(context)))) {
            aVar.b(14, null);
        } else {
            aVar.b(15, null);
        }
    }
}
