package W5;

import W5.AbstractC0623h0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class S extends AbstractC0623h0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: t, reason: collision with root package name */
    public static final S f9122t;

    /* renamed from: u, reason: collision with root package name */
    public static final long f9123u;

    static {
        Long l7;
        S s7 = new S();
        f9122t = s7;
        AbstractC0621g0.e0(s7, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l7 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l7 = 1000L;
        }
        f9123u = timeUnit.toNanos(l7.longValue());
    }

    public final synchronized void C0() {
        if (F0()) {
            debugStatus = 3;
            x0();
            M5.m.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread D0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(f9122t.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean E0() {
        return debugStatus == 4;
    }

    public final boolean F0() {
        int i7 = debugStatus;
        return i7 == 2 || i7 == 3;
    }

    public final synchronized boolean G0() {
        if (F0()) {
            return false;
        }
        debugStatus = 1;
        M5.m.c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void H0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // W5.AbstractC0625i0
    public Thread j0() {
        Thread thread = _thread;
        return thread == null ? D0() : thread;
    }

    @Override // W5.AbstractC0625i0
    public void k0(long j7, AbstractC0623h0.b bVar) {
        H0();
    }

    @Override // W5.AbstractC0623h0
    public void p0(Runnable runnable) {
        if (E0()) {
            H0();
        }
        super.p0(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        S0.f9124a.d(this);
        AbstractC0610b abstractC0610b = AbstractC0612c.f9137a;
        if (abstractC0610b != null) {
            abstractC0610b.c();
        }
        try {
            if (!G0()) {
                _thread = null;
                C0();
                AbstractC0610b abstractC0610b2 = AbstractC0612c.f9137a;
                if (abstractC0610b2 != null) {
                    abstractC0610b2.g();
                }
                if (v0()) {
                    return;
                }
                j0();
                return;
            }
            long j7 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jH0 = h0();
                if (jH0 == Long.MAX_VALUE) {
                    AbstractC0610b abstractC0610b3 = AbstractC0612c.f9137a;
                    long jA = abstractC0610b3 != null ? abstractC0610b3.a() : System.nanoTime();
                    if (j7 == Long.MAX_VALUE) {
                        j7 = f9123u + jA;
                    }
                    long j8 = j7 - jA;
                    if (j8 <= 0) {
                        _thread = null;
                        C0();
                        AbstractC0610b abstractC0610b4 = AbstractC0612c.f9137a;
                        if (abstractC0610b4 != null) {
                            abstractC0610b4.g();
                        }
                        if (v0()) {
                            return;
                        }
                        j0();
                        return;
                    }
                    jH0 = S5.e.g(jH0, j8);
                } else {
                    j7 = Long.MAX_VALUE;
                }
                if (jH0 > 0) {
                    if (F0()) {
                        _thread = null;
                        C0();
                        AbstractC0610b abstractC0610b5 = AbstractC0612c.f9137a;
                        if (abstractC0610b5 != null) {
                            abstractC0610b5.g();
                        }
                        if (v0()) {
                            return;
                        }
                        j0();
                        return;
                    }
                    AbstractC0610b abstractC0610b6 = AbstractC0612c.f9137a;
                    if (abstractC0610b6 != null) {
                        abstractC0610b6.b(this, jH0);
                    } else {
                        LockSupport.parkNanos(this, jH0);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            C0();
            AbstractC0610b abstractC0610b7 = AbstractC0612c.f9137a;
            if (abstractC0610b7 != null) {
                abstractC0610b7.g();
            }
            if (!v0()) {
                j0();
            }
            throw th;
        }
    }

    @Override // W5.AbstractC0623h0, W5.AbstractC0621g0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // W5.J
    public String toString() {
        return "DefaultExecutor";
    }
}
