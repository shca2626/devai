package V;

import android.os.Build;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ int a() {
        int i7 = Build.VERSION.SDK_INT;
        return i7 < 36 ? i7 * 100000 : Build.VERSION.SDK_INT_FULL;
    }
}
