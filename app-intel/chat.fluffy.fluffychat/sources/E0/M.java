package E0;

import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name */
    public long f2087a;

    /* renamed from: b, reason: collision with root package name */
    public long f2088b;

    /* renamed from: c, reason: collision with root package name */
    public long f2089c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal f2090d = new ThreadLocal();

    public M(long j7) {
        i(j7);
    }

    public static long h(long j7) {
        return U.d1(j7, 1000000L, 90000L);
    }

    public static long k(long j7) {
        return U.d1(j7, 90000L, 1000000L);
    }

    public static long l(long j7) {
        return k(j7) % 8589934592L;
    }

    public synchronized long a(long j7) {
        if (j7 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!g()) {
                long jLongValue = this.f2087a;
                if (jLongValue == 9223372036854775806L) {
                    jLongValue = ((Long) j3.o.q((Long) this.f2090d.get())).longValue();
                }
                this.f2088b = jLongValue - j7;
                notifyAll();
            }
            this.f2089c = j7;
            return j7 + this.f2088b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long b(long j7) {
        if (j7 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j8 = this.f2089c;
            if (j8 != -9223372036854775807L) {
                long jK = k(j8);
                long j9 = (4294967296L + jK) / 8589934592L;
                long j10 = ((j9 - 1) * 8589934592L) + j7;
                j7 += j9 * 8589934592L;
                if (Math.abs(j10 - jK) < Math.abs(j7 - jK)) {
                    j7 = j10;
                }
            }
            return a(h(j7));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long c(long j7) {
        if (j7 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j8 = this.f2089c;
            if (j8 != -9223372036854775807L) {
                long jK = k(j8);
                long j9 = jK / 8589934592L;
                long j10 = (j9 * 8589934592L) + j7;
                j7 += (j9 + 1) * 8589934592L;
                if (j10 >= jK) {
                    j7 = j10;
                }
            }
            return a(h(j7));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long d() {
        long j7;
        j7 = this.f2087a;
        if (j7 == Long.MAX_VALUE || j7 == 9223372036854775806L) {
            j7 = -9223372036854775807L;
        }
        return j7;
    }

    public synchronized long e() {
        long j7;
        try {
            j7 = this.f2089c;
        } catch (Throwable th) {
            throw th;
        }
        return j7 != -9223372036854775807L ? j7 + this.f2088b : d();
    }

    public synchronized long f() {
        return this.f2088b;
    }

    public synchronized boolean g() {
        return this.f2088b != -9223372036854775807L;
    }

    public synchronized void i(long j7) {
        this.f2087a = j7;
        this.f2088b = j7 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f2089c = -9223372036854775807L;
    }

    public synchronized void j(boolean z7, long j7, long j8) {
        try {
            j3.o.v(this.f2087a == 9223372036854775806L);
            if (g()) {
                return;
            }
            if (z7) {
                this.f2090d.set(Long.valueOf(j7));
            } else {
                long jElapsedRealtime = 0;
                long j9 = j8;
                while (!g()) {
                    if (j8 == 0) {
                        wait();
                    } else {
                        j3.o.v(j9 > 0);
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        wait(j9);
                        jElapsedRealtime += SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        if (jElapsedRealtime >= j8 && !g()) {
                            throw new TimeoutException("TimestampAdjuster failed to initialize in " + j8 + " milliseconds");
                        }
                        j9 = j8 - jElapsedRealtime;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
