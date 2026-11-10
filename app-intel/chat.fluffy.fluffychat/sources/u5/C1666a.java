package u5;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* renamed from: u5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1666a {
    public static Handler a(Looper looper) {
        return Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(looper) : new Handler(looper);
    }
}
