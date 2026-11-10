package v6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import y5.C1824s;

/* renamed from: v6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1721c extends B {

    /* renamed from: i, reason: collision with root package name */
    public static final a f23165i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f23166j;

    /* renamed from: k, reason: collision with root package name */
    public static final Condition f23167k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f23168l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f23169m;

    /* renamed from: n, reason: collision with root package name */
    public static C1721c f23170n;

    /* renamed from: f, reason: collision with root package name */
    public boolean f23171f;

    /* renamed from: g, reason: collision with root package name */
    public C1721c f23172g;

    /* renamed from: h, reason: collision with root package name */
    public long f23173h;

    /* renamed from: v6.c$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1721c c() throws InterruptedException {
            C1721c c1721c = C1721c.f23170n;
            M5.m.b(c1721c);
            C1721c c1721c2 = c1721c.f23172g;
            if (c1721c2 == null) {
                long jNanoTime = System.nanoTime();
                e().await(C1721c.f23168l, TimeUnit.MILLISECONDS);
                C1721c c1721c3 = C1721c.f23170n;
                M5.m.b(c1721c3);
                if (c1721c3.f23172g != null || System.nanoTime() - jNanoTime < C1721c.f23169m) {
                    return null;
                }
                return C1721c.f23170n;
            }
            long jY = c1721c2.y(System.nanoTime());
            if (jY > 0) {
                e().await(jY, TimeUnit.NANOSECONDS);
                return null;
            }
            C1721c c1721c4 = C1721c.f23170n;
            M5.m.b(c1721c4);
            c1721c4.f23172g = c1721c2.f23172g;
            c1721c2.f23172g = null;
            return c1721c2;
        }

        public final boolean d(C1721c c1721c) {
            ReentrantLock reentrantLockF = C1721c.f23165i.f();
            reentrantLockF.lock();
            try {
                if (!c1721c.f23171f) {
                    return false;
                }
                c1721c.f23171f = false;
                for (C1721c c1721c2 = C1721c.f23170n; c1721c2 != null; c1721c2 = c1721c2.f23172g) {
                    if (c1721c2.f23172g == c1721c) {
                        c1721c2.f23172g = c1721c.f23172g;
                        c1721c.f23172g = null;
                        return false;
                    }
                }
                reentrantLockF.unlock();
                return true;
            } finally {
                reentrantLockF.unlock();
            }
        }

        public final Condition e() {
            return C1721c.f23167k;
        }

        public final ReentrantLock f() {
            return C1721c.f23166j;
        }

        public final void g(C1721c c1721c, long j7, boolean z7) {
            ReentrantLock reentrantLockF = C1721c.f23165i.f();
            reentrantLockF.lock();
            try {
                if (c1721c.f23171f) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                c1721c.f23171f = true;
                if (C1721c.f23170n == null) {
                    C1721c.f23170n = new C1721c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j7 != 0 && z7) {
                    c1721c.f23173h = Math.min(j7, c1721c.c() - jNanoTime) + jNanoTime;
                } else if (j7 != 0) {
                    c1721c.f23173h = j7 + jNanoTime;
                } else {
                    if (!z7) {
                        throw new AssertionError();
                    }
                    c1721c.f23173h = c1721c.c();
                }
                long jY = c1721c.y(jNanoTime);
                C1721c c1721c2 = C1721c.f23170n;
                M5.m.b(c1721c2);
                while (c1721c2.f23172g != null) {
                    C1721c c1721c3 = c1721c2.f23172g;
                    M5.m.b(c1721c3);
                    if (jY < c1721c3.y(jNanoTime)) {
                        break;
                    }
                    c1721c2 = c1721c2.f23172g;
                    M5.m.b(c1721c2);
                }
                c1721c.f23172g = c1721c2.f23172g;
                c1721c2.f23172g = c1721c;
                if (c1721c2 == C1721c.f23170n) {
                    C1721c.f23165i.e().signal();
                }
                C1824s c1824s = C1824s.f24014a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public a() {
        }
    }

    /* renamed from: v6.c$b */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockF;
            C1721c c1721cC;
            while (true) {
                try {
                    a aVar = C1721c.f23165i;
                    reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        c1721cC = aVar.c();
                    } finally {
                        reentrantLockF.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (c1721cC == C1721c.f23170n) {
                    C1721c.f23170n = null;
                    return;
                }
                C1824s c1824s = C1824s.f24014a;
                reentrantLockF.unlock();
                if (c1721cC != null) {
                    c1721cC.B();
                }
            }
        }
    }

    /* renamed from: v6.c$c, reason: collision with other inner class name */
    public static final class C0280c implements y {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ y f23175m;

        public C0280c(y yVar) {
            this.f23175m = yVar;
        }

        @Override // v6.y
        public void A(e eVar, long j7) throws IOException {
            M5.m.e(eVar, "source");
            AbstractC1720b.b(eVar.size(), 0L, j7);
            while (true) {
                long j8 = 0;
                if (j7 <= 0) {
                    return;
                }
                v vVar = eVar.f23178l;
                M5.m.b(vVar);
                while (true) {
                    if (j8 >= 65536) {
                        break;
                    }
                    j8 += vVar.f23225c - vVar.f23224b;
                    if (j8 >= j7) {
                        j8 = j7;
                        break;
                    } else {
                        vVar = vVar.f23228f;
                        M5.m.b(vVar);
                    }
                }
                C1721c c1721c = C1721c.this;
                y yVar = this.f23175m;
                c1721c.v();
                try {
                    try {
                        yVar.A(eVar, j8);
                        C1824s c1824s = C1824s.f24014a;
                        if (c1721c.w()) {
                            throw c1721c.p(null);
                        }
                        j7 -= j8;
                    } catch (IOException e7) {
                        if (!c1721c.w()) {
                            throw e7;
                        }
                        throw c1721c.p(e7);
                    }
                } catch (Throwable th) {
                    c1721c.w();
                    throw th;
                }
            }
        }

        @Override // v6.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1721c c() {
            return C1721c.this;
        }

        @Override // v6.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C1721c c1721c = C1721c.this;
            y yVar = this.f23175m;
            c1721c.v();
            try {
                yVar.close();
                C1824s c1824s = C1824s.f24014a;
                if (c1721c.w()) {
                    throw c1721c.p(null);
                }
            } catch (IOException e7) {
                if (!c1721c.w()) {
                    throw e7;
                }
                throw c1721c.p(e7);
            } finally {
                c1721c.w();
            }
        }

        @Override // v6.y, java.io.Flushable
        public void flush() throws IOException {
            C1721c c1721c = C1721c.this;
            y yVar = this.f23175m;
            c1721c.v();
            try {
                yVar.flush();
                C1824s c1824s = C1824s.f24014a;
                if (c1721c.w()) {
                    throw c1721c.p(null);
                }
            } catch (IOException e7) {
                if (!c1721c.w()) {
                    throw e7;
                }
                throw c1721c.p(e7);
            } finally {
                c1721c.w();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f23175m + ')';
        }
    }

    /* renamed from: v6.c$d */
    public static final class d implements A {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ A f23177m;

        public d(A a7) {
            this.f23177m = a7;
        }

        @Override // v6.A
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1721c c() {
            return C1721c.this;
        }

        @Override // v6.A, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C1721c c1721c = C1721c.this;
            A a7 = this.f23177m;
            c1721c.v();
            try {
                a7.close();
                C1824s c1824s = C1824s.f24014a;
                if (c1721c.w()) {
                    throw c1721c.p(null);
                }
            } catch (IOException e7) {
                if (!c1721c.w()) {
                    throw e7;
                }
                throw c1721c.p(e7);
            } finally {
                c1721c.w();
            }
        }

        @Override // v6.A
        public long k(e eVar, long j7) throws IOException {
            M5.m.e(eVar, "sink");
            C1721c c1721c = C1721c.this;
            A a7 = this.f23177m;
            c1721c.v();
            try {
                long jK = a7.k(eVar, j7);
                if (c1721c.w()) {
                    throw c1721c.p(null);
                }
                return jK;
            } catch (IOException e7) {
                if (c1721c.w()) {
                    throw c1721c.p(e7);
                }
                throw e7;
            } finally {
                c1721c.w();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f23177m + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f23166j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        M5.m.d(conditionNewCondition, "lock.newCondition()");
        f23167k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f23168l = millis;
        f23169m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final A A(A a7) {
        M5.m.e(a7, "source");
        return new d(a7);
    }

    public final IOException p(IOException iOException) {
        return x(iOException);
    }

    public final void v() {
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            f23165i.g(this, jH, zE);
        }
    }

    public final boolean w() {
        return f23165i.d(this);
    }

    public IOException x(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long y(long j7) {
        return this.f23173h - j7;
    }

    public final y z(y yVar) {
        M5.m.e(yVar, "sink");
        return new C0280c(yVar);
    }

    public void B() {
    }
}
