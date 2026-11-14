package l4;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import k4.s;
import k4.u;

/* renamed from: l4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1311g {

    /* renamed from: n, reason: collision with root package name */
    public static final String f19598n = "g";

    /* renamed from: a, reason: collision with root package name */
    public k f19599a;

    /* renamed from: b, reason: collision with root package name */
    public j f19600b;

    /* renamed from: c, reason: collision with root package name */
    public C1312h f19601c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f19602d;

    /* renamed from: e, reason: collision with root package name */
    public m f19603e;

    /* renamed from: h, reason: collision with root package name */
    public Handler f19606h;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19604f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19605g = true;

    /* renamed from: i, reason: collision with root package name */
    public i f19607i = new i();

    /* renamed from: j, reason: collision with root package name */
    public Runnable f19608j = new a();

    /* renamed from: k, reason: collision with root package name */
    public Runnable f19609k = new b();

    /* renamed from: l, reason: collision with root package name */
    public Runnable f19610l = new c();

    /* renamed from: m, reason: collision with root package name */
    public Runnable f19611m = new d();

    /* renamed from: l4.g$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C1311g.f19598n, "Opening camera");
                C1311g.this.f19601c.l();
            } catch (Exception e7) {
                C1311g.this.q(e7);
                Log.e(C1311g.f19598n, "Failed to open camera", e7);
            }
        }
    }

    /* renamed from: l4.g$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C1311g.f19598n, "Configuring camera");
                C1311g.this.f19601c.e();
                if (C1311g.this.f19602d != null) {
                    C1311g.this.f19602d.obtainMessage(H3.k.f3440j, C1311g.this.o()).sendToTarget();
                }
            } catch (Exception e7) {
                C1311g.this.q(e7);
                Log.e(C1311g.f19598n, "Failed to configure camera", e7);
            }
        }
    }

    /* renamed from: l4.g$c */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C1311g.f19598n, "Starting preview");
                C1311g.this.f19601c.s(C1311g.this.f19600b);
                C1311g.this.f19601c.u();
            } catch (Exception e7) {
                C1311g.this.q(e7);
                Log.e(C1311g.f19598n, "Failed to start preview", e7);
            }
        }
    }

    /* renamed from: l4.g$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C1311g.f19598n, "Closing camera");
                C1311g.this.f19601c.v();
                C1311g.this.f19601c.d();
            } catch (Exception e7) {
                Log.e(C1311g.f19598n, "Failed to close camera", e7);
            }
            C1311g.this.f19605g = true;
            C1311g.this.f19602d.sendEmptyMessage(H3.k.f3433c);
            C1311g.this.f19599a.b();
        }
    }

    public C1311g(Context context) {
        u.a();
        this.f19599a = k.d();
        C1312h c1312h = new C1312h(context);
        this.f19601c = c1312h;
        c1312h.o(this.f19607i);
        this.f19606h = new Handler();
    }

    public static /* synthetic */ void c(final C1311g c1311g, final p pVar) {
        if (c1311g.f19604f) {
            c1311g.f19599a.c(new Runnable() { // from class: l4.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19596l.f19601c.m(pVar);
                }
            });
        } else {
            Log.d(f19598n, "Camera is closed, not requesting preview");
        }
    }

    public void l() {
        u.a();
        if (this.f19604f) {
            this.f19599a.c(this.f19611m);
        } else {
            this.f19605g = true;
        }
        this.f19604f = false;
    }

    public void m() {
        u.a();
        z();
        this.f19599a.c(this.f19609k);
    }

    public m n() {
        return this.f19603e;
    }

    public final s o() {
        return this.f19601c.h();
    }

    public boolean p() {
        return this.f19605g;
    }

    public final void q(Exception exc) {
        Handler handler = this.f19602d;
        if (handler != null) {
            handler.obtainMessage(H3.k.f3434d, exc).sendToTarget();
        }
    }

    public void r() {
        u.a();
        this.f19604f = true;
        this.f19605g = false;
        this.f19599a.e(this.f19608j);
    }

    public void s(final p pVar) {
        this.f19606h.post(new Runnable() { // from class: l4.d
            @Override // java.lang.Runnable
            public final void run() {
                C1311g.c(this.f19592l, pVar);
            }
        });
    }

    public void t(i iVar) {
        if (this.f19604f) {
            return;
        }
        this.f19607i = iVar;
        this.f19601c.o(iVar);
    }

    public void u(m mVar) {
        this.f19603e = mVar;
        this.f19601c.q(mVar);
    }

    public void v(Handler handler) {
        this.f19602d = handler;
    }

    public void w(j jVar) {
        this.f19600b = jVar;
    }

    public void x(final boolean z7) {
        u.a();
        if (this.f19604f) {
            this.f19599a.c(new Runnable() { // from class: l4.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19594l.f19601c.t(z7);
                }
            });
        }
    }

    public void y() {
        u.a();
        z();
        this.f19599a.c(this.f19610l);
    }

    public final void z() {
        if (!this.f19604f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }
}
