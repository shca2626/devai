package E0;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class J implements InterfaceC0322g {
    @Override // E0.InterfaceC0322g
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // E0.InterfaceC0322g
    public long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // E0.InterfaceC0322g
    public InterfaceC0330o c(Looper looper, Handler.Callback callback) {
        return new K(new Handler(looper, callback));
    }

    @Override // E0.InterfaceC0322g
    public long e() {
        return SystemClock.elapsedRealtime();
    }

    @Override // E0.InterfaceC0322g
    public long f() {
        return System.nanoTime();
    }

    @Override // E0.InterfaceC0322g
    public void d() {
    }
}
