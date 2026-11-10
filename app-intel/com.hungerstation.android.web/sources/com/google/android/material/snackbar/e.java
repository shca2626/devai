package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
class e {

    /* renamed from: e, reason: collision with root package name */
    private static e f23260e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f23261a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f23262b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    private c f23263c;

    /* renamed from: d, reason: collision with root package name */
    private c f23264d;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e.this.d((c) message.obj);
            return true;
        }
    }

    interface b {
        void a();

        void b(int i12);
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<b> f23266a;

        /* renamed from: b, reason: collision with root package name */
        int f23267b;

        /* renamed from: c, reason: collision with root package name */
        boolean f23268c;

        c(int i12, b bVar) {
            this.f23266a = new WeakReference<>(bVar);
            this.f23267b = i12;
        }

        boolean a(b bVar) {
            return bVar != null && this.f23266a.get() == bVar;
        }
    }

    private e() {
    }

    private boolean a(c cVar, int i12) {
        b bVar = cVar.f23266a.get();
        if (bVar == null) {
            return false;
        }
        this.f23262b.removeCallbacksAndMessages(cVar);
        bVar.b(i12);
        return true;
    }

    static e c() {
        if (f23260e == null) {
            f23260e = new e();
        }
        return f23260e;
    }

    private boolean f(b bVar) {
        c cVar = this.f23263c;
        return cVar != null && cVar.a(bVar);
    }

    private boolean g(b bVar) {
        c cVar = this.f23264d;
        return cVar != null && cVar.a(bVar);
    }

    private void l(c cVar) {
        int i12 = cVar.f23267b;
        if (i12 == -2) {
            return;
        }
        if (i12 <= 0) {
            i12 = i12 == -1 ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 2750;
        }
        this.f23262b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f23262b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i12);
    }

    private void n() {
        c cVar = this.f23264d;
        if (cVar != null) {
            this.f23263c = cVar;
            this.f23264d = null;
            b bVar = cVar.f23266a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.f23263c = null;
            }
        }
    }

    public void b(b bVar, int i12) {
        synchronized (this.f23261a) {
            try {
                if (f(bVar)) {
                    a(this.f23263c, i12);
                } else if (g(bVar)) {
                    a(this.f23264d, i12);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    void d(c cVar) {
        synchronized (this.f23261a) {
            try {
                if (this.f23263c == cVar || this.f23264d == cVar) {
                    a(cVar, 2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean e(b bVar) {
        boolean z12;
        synchronized (this.f23261a) {
            try {
                z12 = f(bVar) || g(bVar);
            } finally {
            }
        }
        return z12;
    }

    public void h(b bVar) {
        synchronized (this.f23261a) {
            try {
                if (f(bVar)) {
                    this.f23263c = null;
                    if (this.f23264d != null) {
                        n();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void i(b bVar) {
        synchronized (this.f23261a) {
            try {
                if (f(bVar)) {
                    l(this.f23263c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f23261a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f23263c;
                    if (!cVar.f23268c) {
                        cVar.f23268c = true;
                        this.f23262b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f23261a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f23263c;
                    if (cVar.f23268c) {
                        cVar.f23268c = false;
                        l(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void m(int i12, b bVar) {
        synchronized (this.f23261a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f23263c;
                    cVar.f23267b = i12;
                    this.f23262b.removeCallbacksAndMessages(cVar);
                    l(this.f23263c);
                    return;
                }
                if (g(bVar)) {
                    this.f23264d.f23267b = i12;
                } else {
                    this.f23264d = new c(i12, bVar);
                }
                c cVar2 = this.f23263c;
                if (cVar2 == null || !a(cVar2, 4)) {
                    this.f23263c = null;
                    n();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
