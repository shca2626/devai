package androidx.core.os;

import android.os.CancellationSignal;

@Deprecated
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6583a;

    /* renamed from: b, reason: collision with root package name */
    private a f6584b;

    /* renamed from: c, reason: collision with root package name */
    private Object f6585c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6586d;

    public interface a {
        void onCancel();
    }

    private void c() throws InterruptedException {
        while (this.f6586d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f6583a) {
                    return;
                }
                this.f6583a = true;
                this.f6586d = true;
                a aVar = this.f6584b;
                Object obj = this.f6585c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th2) {
                        synchronized (this) {
                            this.f6586d = false;
                            notifyAll();
                            throw th2;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f6586d = false;
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
                if (this.f6584b == aVar) {
                    return;
                }
                this.f6584b = aVar;
                if (this.f6583a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }
}
