package V;

import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8482a;

    /* renamed from: b, reason: collision with root package name */
    public a f8483b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8484c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8485d;

    public interface a {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f8482a) {
                    return;
                }
                this.f8482a = true;
                this.f8485d = true;
                a aVar = this.f8483b;
                Object obj = this.f8484c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f8485d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f8485d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f8483b == aVar) {
                    return;
                }
                this.f8483b = aVar;
                if (this.f8482a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }

    public final void c() throws InterruptedException {
        while (this.f8485d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
