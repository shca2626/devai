package H0;

import j3.o;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public abstract class h implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Thread f3341a;

    /* renamed from: e, reason: collision with root package name */
    public final f[] f3345e;

    /* renamed from: f, reason: collision with root package name */
    public final g[] f3346f;

    /* renamed from: g, reason: collision with root package name */
    public int f3347g;

    /* renamed from: h, reason: collision with root package name */
    public int f3348h;

    /* renamed from: i, reason: collision with root package name */
    public f f3349i;

    /* renamed from: j, reason: collision with root package name */
    public e f3350j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3351k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3352l;

    /* renamed from: m, reason: collision with root package name */
    public int f3353m;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3342b = new Object();

    /* renamed from: n, reason: collision with root package name */
    public long f3354n = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f3343c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f3344d = new ArrayDeque();

    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            h.this.v();
        }
    }

    public h(f[] fVarArr, g[] gVarArr) {
        this.f3345e = fVarArr;
        this.f3347g = fVarArr.length;
        for (int i7 = 0; i7 < this.f3347g; i7++) {
            this.f3345e[i7] = i();
        }
        this.f3346f = gVarArr;
        this.f3348h = gVarArr.length;
        for (int i8 = 0; i8 < this.f3348h; i8++) {
            this.f3346f[i8] = j();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f3341a = aVar;
        aVar.start();
    }

    @Override // H0.d
    public final void b(long j7) {
        synchronized (this.f3342b) {
            try {
                o.v(this.f3347g == this.f3345e.length || this.f3351k);
                this.f3354n = j7;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // H0.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void f(f fVar) {
        synchronized (this.f3342b) {
            r();
            o.d(fVar == this.f3349i);
            this.f3343c.addLast(fVar);
            q();
            this.f3349i = null;
        }
    }

    @Override // H0.d
    public final void flush() {
        synchronized (this.f3342b) {
            try {
                this.f3351k = true;
                this.f3353m = 0;
                f fVar = this.f3349i;
                if (fVar != null) {
                    s(fVar);
                    this.f3349i = null;
                }
                while (!this.f3343c.isEmpty()) {
                    s((f) this.f3343c.removeFirst());
                }
                while (!this.f3344d.isEmpty()) {
                    ((g) this.f3344d.removeFirst()).r();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean h() {
        return !this.f3343c.isEmpty() && this.f3348h > 0;
    }

    public abstract f i();

    public abstract g j();

    public abstract e k(Throwable th);

    public abstract e l(f fVar, g gVar, boolean z7);

    public final boolean m() {
        e eVarK;
        synchronized (this.f3342b) {
            while (!this.f3352l && !h()) {
                try {
                    this.f3342b.wait();
                } finally {
                }
            }
            if (this.f3352l) {
                return false;
            }
            f fVar = (f) this.f3343c.removeFirst();
            g[] gVarArr = this.f3346f;
            int i7 = this.f3348h - 1;
            this.f3348h = i7;
            g gVar = gVarArr[i7];
            boolean z7 = this.f3351k;
            this.f3351k = false;
            if (fVar.l()) {
                gVar.h(4);
            } else {
                gVar.f3338m = fVar.f3332q;
                if (fVar.m()) {
                    gVar.h(134217728);
                }
                if (!p(fVar.f3332q)) {
                    gVar.f3340o = true;
                }
                try {
                    eVarK = l(fVar, gVar, z7);
                } catch (OutOfMemoryError e7) {
                    eVarK = k(e7);
                } catch (RuntimeException e8) {
                    eVarK = k(e8);
                }
                if (eVarK != null) {
                    synchronized (this.f3342b) {
                        this.f3350j = eVarK;
                    }
                    return false;
                }
            }
            synchronized (this.f3342b) {
                try {
                    if (this.f3351k) {
                        gVar.r();
                    } else if (gVar.f3340o) {
                        this.f3353m++;
                        gVar.r();
                    } else {
                        gVar.f3339n = this.f3353m;
                        this.f3353m = 0;
                        this.f3344d.addLast(gVar);
                    }
                    s(fVar);
                } finally {
                }
            }
            return true;
        }
    }

    @Override // H0.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final f e() {
        f fVar;
        synchronized (this.f3342b) {
            r();
            o.v(this.f3349i == null);
            int i7 = this.f3347g;
            if (i7 == 0) {
                fVar = null;
            } else {
                f[] fVarArr = this.f3345e;
                int i8 = i7 - 1;
                this.f3347g = i8;
                fVar = fVarArr[i8];
            }
            this.f3349i = fVar;
        }
        return fVar;
    }

    @Override // H0.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final g a() {
        synchronized (this.f3342b) {
            try {
                r();
                if (this.f3344d.isEmpty()) {
                    return null;
                }
                return (g) this.f3344d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean p(long j7) {
        boolean z7;
        synchronized (this.f3342b) {
            long j8 = this.f3354n;
            z7 = j8 == -9223372036854775807L || j7 >= j8;
        }
        return z7;
    }

    public final void q() {
        if (h()) {
            this.f3342b.notify();
        }
    }

    public final void r() throws e {
        e eVar = this.f3350j;
        if (eVar != null) {
            throw eVar;
        }
    }

    @Override // H0.d
    public void release() throws InterruptedException {
        synchronized (this.f3342b) {
            this.f3352l = true;
            this.f3342b.notify();
        }
        try {
            this.f3341a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void s(f fVar) {
        fVar.i();
        f[] fVarArr = this.f3345e;
        int i7 = this.f3347g;
        this.f3347g = i7 + 1;
        fVarArr[i7] = fVar;
    }

    public void t(g gVar) {
        synchronized (this.f3342b) {
            u(gVar);
            q();
        }
    }

    public final void u(g gVar) {
        gVar.i();
        g[] gVarArr = this.f3346f;
        int i7 = this.f3348h;
        this.f3348h = i7 + 1;
        gVarArr[i7] = gVar;
    }

    public final void v() {
        do {
            try {
            } catch (InterruptedException e7) {
                throw new IllegalStateException(e7);
            }
        } while (m());
    }

    public final void w(int i7) {
        o.v(this.f3347g == this.f3345e.length);
        for (f fVar : this.f3345e) {
            fVar.s(i7);
        }
    }
}
