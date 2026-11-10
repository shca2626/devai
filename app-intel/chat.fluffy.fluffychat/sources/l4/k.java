package l4;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    public static k f19650e;

    /* renamed from: a, reason: collision with root package name */
    public Handler f19651a;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f19652b;

    /* renamed from: c, reason: collision with root package name */
    public int f19653c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f19654d = new Object();

    public static k d() {
        if (f19650e == null) {
            f19650e = new k();
        }
        return f19650e;
    }

    public final void a() {
        synchronized (this.f19654d) {
            try {
                if (this.f19651a == null) {
                    if (this.f19653c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f19652b = handlerThread;
                    handlerThread.start();
                    this.f19651a = new Handler(this.f19652b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f19654d) {
            try {
                int i7 = this.f19653c - 1;
                this.f19653c = i7;
                if (i7 == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Runnable runnable) {
        synchronized (this.f19654d) {
            a();
            this.f19651a.post(runnable);
        }
    }

    public void e(Runnable runnable) {
        synchronized (this.f19654d) {
            this.f19653c++;
            c(runnable);
        }
    }

    public final void f() {
        synchronized (this.f19654d) {
            this.f19652b.quit();
            this.f19652b = null;
            this.f19651a = null;
        }
    }
}
