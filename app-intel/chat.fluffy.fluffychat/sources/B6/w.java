package B6;

import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final PowerManager.WakeLock f1209a;

    public w(Context context) {
        M5.m.e(context, "context");
        Object systemService = context.getSystemService("power");
        M5.m.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, "android-connector:lock");
        wakeLockNewWakeLock.acquire(10000L);
        this.f1209a = wakeLockNewWakeLock;
    }

    public final void a() {
        PowerManager.WakeLock wakeLock = this.f1209a;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        wakeLock.release();
    }
}
