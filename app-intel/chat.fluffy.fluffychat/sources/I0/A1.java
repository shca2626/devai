package I0;

import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes.dex */
public final class A1 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3536a;

    /* renamed from: b, reason: collision with root package name */
    public Looper f3537b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f3538c;

    /* renamed from: d, reason: collision with root package name */
    public int f3539d;

    public A1() {
        this(null);
    }

    public Looper a() {
        Looper looper;
        synchronized (this.f3536a) {
            try {
                if (this.f3537b == null) {
                    j3.o.v(this.f3539d == 0 && this.f3538c == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.f3538c = handlerThread;
                    handlerThread.start();
                    this.f3537b = this.f3538c.getLooper();
                }
                this.f3539d++;
                looper = this.f3537b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public void b() {
        HandlerThread handlerThread;
        synchronized (this.f3536a) {
            try {
                j3.o.v(this.f3539d > 0);
                int i7 = this.f3539d - 1;
                this.f3539d = i7;
                if (i7 == 0 && (handlerThread = this.f3538c) != null) {
                    handlerThread.quit();
                    this.f3538c = null;
                    this.f3537b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public A1(Looper looper) {
        this.f3536a = new Object();
        this.f3537b = looper;
        this.f3538c = null;
        this.f3539d = 0;
    }
}
