package l4;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    public static k f19649e;

    /* renamed from: a, reason: collision with root package name */
    public Handler f19650a;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f19651b;

    /* renamed from: c, reason: collision with root package name */
    public int f19652c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f19653d = new Object();

    public static k d() {
        if (f19649e == null) {
            f19649e = new k();
        }
        return f19649e;
    }

    public final void a() {
        synchronized (this.f19653d) {
            try {
                if (this.f19650a == null) {
                    if (this.f19652c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f19651b = handlerThread;
                    handlerThread.start();
                    this.f19650a = new Handler(this.f19651b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f19653d) {
            try {
                int i7 = this.f19652c - 1;
                this.f19652c = i7;
                if (i7 == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Runnable runnable) {
        synchronized (this.f19653d) {
            a();
            this.f19650a.post(runnable);
        }
    }

    public void e(Runnable runnable) {
        synchronized (this.f19653d) {
            this.f19652c++;
            c(runnable);
        }
    }

    public final void f() {
        synchronized (this.f19653d) {
            this.f19651b.quit();
            this.f19651b = null;
            this.f19650a = null;
        }
    }
}
