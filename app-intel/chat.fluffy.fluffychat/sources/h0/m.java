package h0;

import android.os.Build;
import java.io.File;

/* loaded from: classes.dex */
public abstract class m {
    public static final boolean a(File file, File file2) {
        M5.m.e(file, "<this>");
        M5.m.e(file2, "toFile");
        return Build.VERSION.SDK_INT >= 26 ? C1126a.f16576a.a(file, file2) : file.renameTo(file2);
    }
}
