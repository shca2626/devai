package k4;

import android.os.Looper;

/* loaded from: classes.dex */
public class u {
    public static void a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
