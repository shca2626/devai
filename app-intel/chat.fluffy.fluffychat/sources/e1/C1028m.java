package e1;

import E0.AbstractC0329n;
import E0.AbstractC0333s;
import E0.RunnableC0328m;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;

/* renamed from: e1.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1028m extends Surface {

    /* renamed from: o, reason: collision with root package name */
    public static int f15475o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f15476p;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f15477l;

    /* renamed from: m, reason: collision with root package name */
    public final b f15478m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15479n;

    /* renamed from: e1.m$b */
    public static class b extends HandlerThread implements Handler.Callback {

        /* renamed from: l, reason: collision with root package name */
        public RunnableC0328m f15480l;

        /* renamed from: m, reason: collision with root package name */
        public Handler f15481m;

        /* renamed from: n, reason: collision with root package name */
        public Error f15482n;

        /* renamed from: o, reason: collision with root package name */
        public RuntimeException f15483o;

        /* renamed from: p, reason: collision with root package name */
        public C1028m f15484p;

        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }

        public C1028m a(int i7) {
            boolean z7;
            start();
            this.f15481m = new Handler(getLooper(), this);
            this.f15480l = new RunnableC0328m(this.f15481m);
            synchronized (this) {
                z7 = false;
                this.f15481m.obtainMessage(1, i7, 0).sendToTarget();
                while (this.f15484p == null && this.f15483o == null && this.f15482n == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z7 = true;
                    }
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f15483o;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f15482n;
            if (error == null) {
                return (C1028m) j3.o.q(this.f15484p);
            }
            throw error;
        }

        public final void b(int i7) throws AbstractC0329n.a {
            j3.o.q(this.f15480l);
            this.f15480l.h(i7);
            this.f15484p = new C1028m(this, this.f15480l.g(), i7 != 0);
        }

        public void c() {
            j3.o.q(this.f15481m);
            this.f15481m.sendEmptyMessage(2);
        }

        public final void d() {
            j3.o.q(this.f15480l);
            this.f15480l.i();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            try {
                if (i7 != 1) {
                    if (i7 != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (AbstractC0329n.a e7) {
                    AbstractC0333s.d("PlaceholderSurface", "Failed to initialize placeholder surface", e7);
                    this.f15483o = new IllegalStateException(e7);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e8) {
                    AbstractC0333s.d("PlaceholderSurface", "Failed to initialize placeholder surface", e8);
                    this.f15482n = e8;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e9) {
                    AbstractC0333s.d("PlaceholderSurface", "Failed to initialize placeholder surface", e9);
                    this.f15483o = e9;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    public static int b(Context context) {
        try {
            if (AbstractC0329n.h(context)) {
                return AbstractC0329n.i() ? 1 : 2;
            }
            return 0;
        } catch (AbstractC0329n.a e7) {
            AbstractC0333s.c("PlaceholderSurface", "Failed to determine secure mode due to GL error: " + e7.getMessage());
            return 0;
        }
    }

    public static synchronized boolean c(Context context) {
        try {
            if (!f15476p) {
                f15475o = b(context);
                f15476p = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15475o != 0;
    }

    public static C1028m e(Context context, boolean z7) {
        j3.o.v(!z7 || c(context));
        return new b().a(z7 ? f15475o : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f15478m) {
            try {
                if (!this.f15479n) {
                    this.f15478m.c();
                    this.f15479n = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C1028m(b bVar, SurfaceTexture surfaceTexture, boolean z7) {
        super(surfaceTexture);
        this.f15478m = bVar;
        this.f15477l = z7;
    }
}
