package c1;

import E0.AbstractC0333s;
import E0.InterfaceC0326k;
import E0.N;
import E0.U;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import d1.InterfaceExecutorC0976a;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class m implements n {

    /* renamed from: d, reason: collision with root package name */
    public static final c f13922d = h(false, -9223372036854775807L);

    /* renamed from: e, reason: collision with root package name */
    public static final c f13923e = h(true, -9223372036854775807L);

    /* renamed from: f, reason: collision with root package name */
    public static final c f13924f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f13925g;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceExecutorC0976a f13926a;

    /* renamed from: b, reason: collision with root package name */
    public d f13927b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f13928c;

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f13929a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13930b;

        public boolean c() {
            int i7 = this.f13929a;
            return i7 == 0 || i7 == 1;
        }

        public c(int i7, long j7) {
            this.f13929a = i7;
            this.f13930b = j7;
        }
    }

    public final class d extends Handler implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final int f13931l;

        /* renamed from: m, reason: collision with root package name */
        public final e f13932m;

        /* renamed from: n, reason: collision with root package name */
        public final long f13933n;

        /* renamed from: o, reason: collision with root package name */
        public b f13934o;

        /* renamed from: p, reason: collision with root package name */
        public IOException f13935p;

        /* renamed from: q, reason: collision with root package name */
        public int f13936q;

        /* renamed from: r, reason: collision with root package name */
        public Thread f13937r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f13938s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13939t;

        public d(Looper looper, e eVar, b bVar, int i7, long j7) {
            super(looper);
            this.f13932m = eVar;
            this.f13934o = bVar;
            this.f13931l = i7;
            this.f13933n = j7;
        }

        public void a(boolean z7) {
            this.f13939t = z7;
            this.f13935p = null;
            if (hasMessages(1)) {
                this.f13938s = true;
                removeMessages(1);
                if (!z7) {
                    sendEmptyMessage(2);
                }
            } else {
                synchronized (this) {
                    try {
                        this.f13938s = true;
                        this.f13932m.c();
                        Thread thread = this.f13937r;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z7) {
                c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) j3.o.q(this.f13934o)).i(this.f13932m, jElapsedRealtime, jElapsedRealtime - this.f13933n, true);
                this.f13934o = null;
            }
        }

        public final void b() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ((b) j3.o.q(this.f13934o)).r(this.f13932m, jElapsedRealtime, jElapsedRealtime - this.f13933n, this.f13936q);
            this.f13935p = null;
            m.this.f13926a.execute((Runnable) j3.o.q(m.this.f13927b));
        }

        public final void c() {
            m.this.f13927b = null;
        }

        public final long d() {
            return Math.min((this.f13936q - 1) * 1000, 5000);
        }

        public void e(int i7) throws IOException {
            IOException iOException = this.f13935p;
            if (iOException != null && this.f13936q > i7) {
                throw iOException;
            }
        }

        public void f(long j7) {
            j3.o.v(m.this.f13927b == null);
            m.this.f13927b = this;
            if (j7 > 0) {
                sendEmptyMessageDelayed(1, j7);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f13939t) {
                return;
            }
            int i7 = message.what;
            if (i7 == 1) {
                b();
                return;
            }
            if (i7 == 4) {
                throw ((Error) message.obj);
            }
            c();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j7 = jElapsedRealtime - this.f13933n;
            b bVar = (b) j3.o.q(this.f13934o);
            if (this.f13938s) {
                bVar.i(this.f13932m, jElapsedRealtime, j7, false);
                return;
            }
            int i8 = message.what;
            if (i8 == 2) {
                try {
                    bVar.t(this.f13932m, jElapsedRealtime, j7);
                    return;
                } catch (RuntimeException e7) {
                    AbstractC0333s.d("LoadTask", "Unexpected exception handling load completed", e7);
                    m.this.f13928c = new h(e7);
                    return;
                }
            }
            if (i8 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f13935p = iOException;
            int i9 = this.f13936q + 1;
            this.f13936q = i9;
            c cVarQ = bVar.q(this.f13932m, jElapsedRealtime, j7, iOException, i9);
            if (cVarQ.f13929a == 3) {
                m.this.f13928c = this.f13935p;
            } else if (cVarQ.f13929a != 2) {
                if (cVarQ.f13929a == 1) {
                    this.f13936q = 1;
                }
                f(cVarQ.f13930b != -9223372036854775807L ? cVarQ.f13930b : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            try {
                synchronized (this) {
                    z7 = this.f13938s;
                    this.f13937r = Thread.currentThread();
                }
                if (!z7) {
                    N.a("load:" + this.f13932m.getClass().getSimpleName());
                    try {
                        this.f13932m.a();
                        N.b();
                    } catch (Throwable th) {
                        N.b();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f13937r = null;
                    Thread.interrupted();
                }
                if (this.f13939t) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e7) {
                if (this.f13939t) {
                    return;
                }
                obtainMessage(3, e7).sendToTarget();
            } catch (Error e8) {
                if (!this.f13939t) {
                    AbstractC0333s.d("LoadTask", "Unexpected error loading stream", e8);
                    obtainMessage(4, e8).sendToTarget();
                }
                throw e8;
            } catch (Exception e9) {
                if (this.f13939t) {
                    return;
                }
                AbstractC0333s.d("LoadTask", "Unexpected exception loading stream", e9);
                obtainMessage(3, new h(e9)).sendToTarget();
            } catch (OutOfMemoryError e10) {
                if (this.f13939t) {
                    return;
                }
                AbstractC0333s.d("LoadTask", "OutOfMemory error loading stream", e10);
                obtainMessage(3, new h(e10)).sendToTarget();
            }
        }
    }

    public interface e {
        void a();

        void c();
    }

    public interface f {
        void j();
    }

    public static final class g implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final f f13941l;

        public g(f fVar) {
            this.f13941l = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13941l.j();
        }
    }

    public static final class h extends IOException {
        public h(Throwable th) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected ");
            sb.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                str = ": " + th.getMessage();
            } else {
                str = "";
            }
            sb.append(str);
            super(sb.toString(), th);
        }
    }

    static {
        long j7 = -9223372036854775807L;
        f13924f = new c(2, j7);
        f13925g = new c(3, j7);
    }

    public m(String str) {
        this(InterfaceExecutorC0976a.y(U.Q0("ExoPlayer:Loader:" + str), new InterfaceC0326k() { // from class: c1.l
            @Override // E0.InterfaceC0326k
            public final void accept(Object obj) {
                ((ExecutorService) obj).shutdown();
            }
        }));
    }

    public static c h(boolean z7, long j7) {
        return new c(z7 ? 1 : 0, j7);
    }

    @Override // c1.n
    public void a() throws IOException {
        k(Integer.MIN_VALUE);
    }

    public void f() {
        ((d) j3.o.q(this.f13927b)).a(false);
    }

    public void g() {
        this.f13928c = null;
    }

    public boolean i() {
        return this.f13928c != null;
    }

    public boolean j() {
        return this.f13927b != null;
    }

    public void k(int i7) throws IOException {
        IOException iOException = this.f13928c;
        if (iOException != null) {
            throw iOException;
        }
        d dVar = this.f13927b;
        if (dVar != null) {
            if (i7 == Integer.MIN_VALUE) {
                i7 = dVar.f13931l;
            }
            dVar.e(i7);
        }
    }

    public void l() {
        m(null);
    }

    public void m(f fVar) {
        d dVar = this.f13927b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f13926a.execute(new g(fVar));
        }
        this.f13926a.release();
    }

    public long n(e eVar, b bVar, int i7) {
        Looper looper = (Looper) j3.o.q(Looper.myLooper());
        this.f13928c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, eVar, bVar, i7, jElapsedRealtime).f(0L);
        return jElapsedRealtime;
    }

    public m(InterfaceExecutorC0976a interfaceExecutorC0976a) {
        this.f13926a = interfaceExecutorC0976a;
    }

    public interface b {
        void i(e eVar, long j7, long j8, boolean z7);

        c q(e eVar, long j7, long j8, IOException iOException, int i7);

        void t(e eVar, long j7, long j8);

        default void r(e eVar, long j7, long j8, int i7) {
        }
    }
}
