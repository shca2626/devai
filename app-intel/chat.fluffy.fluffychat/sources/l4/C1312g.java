package l4;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import k4.s;
import k4.u;

/* renamed from: l4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1312g {

    /* renamed from: n, reason: collision with root package name */
    public static final String f19599n = "g";

    /* renamed from: a, reason: collision with root package name */
    public k f19600a;

    /* renamed from: b, reason: collision with root package name */
    public j f19601b;

    /* renamed from: c, reason: collision with root package name */
    public C1313h f19602c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f19603d;

    /* renamed from: e, reason: collision with root package name */
    public m f19604e;

    /* renamed from: h, reason: collision with root package name */
    public Handler f19607h;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19605f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19606g = true;

    /* renamed from: i, reason: collision with root package name */
    public i f19608i = new i();

    /* renamed from: j, reason: collision with root package name */
    public Runnable f19609j = new a();

    /* renamed from: k, reason: collision with root package name */
    public Runnable f19610k = new b();

    /* renamed from: l, reason: collision with root package name */
    public Runnable f19611l = new c();

    /* renamed from: m, reason: collision with root package name */
    public Runnable f19612m = new d();

    /* renamed from: l4.g$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C1312g.f19599n, "Opening camera");
                C1312g.this.f19602c.l();
            } catch (Exception e7) {
                C1312g.this.q(e7);
                Log.e(C1312g.f19599n, "Failed to open camera", e7);
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
                Log.d(C1312g.f19599n, "Configuring camera");
                C1312g.this.f19602c.e();
                if (C1312g.this.f19603d != null) {
                    C1312g.this.f19603d.obtainMessage(H3.k.f3440j, C1312g.this.o()).sendToTarget();
                }
            } catch (Exception e7) {
                C1312g.this.q(e7);
                Log.e(C1312g.f19599n, "Failed to configure camera", e7);
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
                Log.d(C1312g.f19599n, "Starting preview");
                C1312g.this.f19602c.s(C1312g.this.f19601b);
                C1312g.this.f19602c.u();
            } catch (Exception e7) {
                C1312g.this.q(e7);
                Log.e(C1312g.f19599n, "Failed to start preview", e7);
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
                Log.d(C1312g.f19599n, "Closing camera");
                C1312g.this.f19602c.v();
                C1312g.this.f19602c.d();
            } catch (Exception e7) {
                Log.e(C1312g.f19599n, "Failed to close camera", e7);
            }
            C1312g.this.f19606g = true;
            C1312g.this.f19603d.sendEmptyMessage(H3.k.f3433c);
            C1312g.this.f19600a.b();
        }
    }

    public C1312g(Context context) {
        u.a();
        this.f19600a = k.d();
        C1313h c1313h = new C1313h(context);
        this.f19602c = c1313h;
        c1313h.o(this.f19608i);
        this.f19607h = new Handler();
    }

    public static /* synthetic */ void c(final C1312g c1312g, final p pVar) {
        if (c1312g.f19605f) {
            c1312g.f19600a.c(new Runnable() { // from class: l4.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19597l.f19602c.m(pVar);
                }
            });
        } else {
            Log.d(f19599n, "Camera is closed, not requesting preview");
        }
    }

    public void l() {
        u.a();
        if (this.f19605f) {
            this.f19600a.c(this.f19612m);
        } else {
            this.f19606g = true;
        }
        this.f19605f = false;
    }

    public void m() {
        u.a();
        z();
        this.f19600a.c(this.f19610k);
    }

    public m n() {
        return this.f19604e;
    }

    public final s o() {
        return this.f19602c.h();
    }

    public boolean p() {
        return this.f19606g;
    }

    public final void q(Exception exc) {
        Handler handler = this.f19603d;
        if (handler != null) {
            handler.obtainMessage(H3.k.f3434d, exc).sendToTarget();
        }
    }

    public void r() {
        u.a();
        this.f19605f = true;
        this.f19606g = false;
        this.f19600a.e(this.f19609j);
    }

    public void s(final p pVar) {
        this.f19607h.post(new Runnable() { // from class: l4.d
            @Override // java.lang.Runnable
            public final void run() {
                C1312g.c(this.f19593l, pVar);
            }
        });
    }

    public void t(i iVar) {
        if (this.f19605f) {
            return;
        }
        this.f19608i = iVar;
        this.f19602c.o(iVar);
    }

    public void u(m mVar) {
        this.f19604e = mVar;
        this.f19602c.q(mVar);
    }

    public void v(Handler handler) {
        this.f19603d = handler;
    }

    public void w(j jVar) {
        this.f19601b = jVar;
    }

    public void x(final boolean z7) {
        u.a();
        if (this.f19605f) {
            this.f19600a.c(new Runnable() { // from class: l4.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19595l.f19602c.t(z7);
                }
            });
        }
    }

    public void y() {
        u.a();
        z();
        this.f19600a.c(this.f19611l);
    }

    public final void z() {
        if (!this.f19605f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }
}
