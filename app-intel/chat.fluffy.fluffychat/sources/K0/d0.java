package K0;

import E0.InterfaceC0321g;
import android.media.AudioTrack;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: A, reason: collision with root package name */
    public boolean f5103A;

    /* renamed from: B, reason: collision with root package name */
    public long f5104B;

    /* renamed from: a, reason: collision with root package name */
    public final a f5105a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0321g f5106b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f5107c;

    /* renamed from: d, reason: collision with root package name */
    public final AudioTrack f5108d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5109e;

    /* renamed from: f, reason: collision with root package name */
    public final long f5110f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5111g;

    /* renamed from: h, reason: collision with root package name */
    public C f5112h;

    /* renamed from: i, reason: collision with root package name */
    public float f5113i;

    /* renamed from: j, reason: collision with root package name */
    public long f5114j;

    /* renamed from: k, reason: collision with root package name */
    public long f5115k;

    /* renamed from: l, reason: collision with root package name */
    public long f5116l;

    /* renamed from: m, reason: collision with root package name */
    public Method f5117m;

    /* renamed from: n, reason: collision with root package name */
    public long f5118n;

    /* renamed from: o, reason: collision with root package name */
    public long f5119o;

    /* renamed from: p, reason: collision with root package name */
    public long f5120p;

    /* renamed from: q, reason: collision with root package name */
    public long f5121q;

    /* renamed from: r, reason: collision with root package name */
    public long f5122r;

    /* renamed from: s, reason: collision with root package name */
    public int f5123s;

    /* renamed from: t, reason: collision with root package name */
    public int f5124t;

    /* renamed from: u, reason: collision with root package name */
    public long f5125u;

    /* renamed from: v, reason: collision with root package name */
    public long f5126v;

    /* renamed from: w, reason: collision with root package name */
    public long f5127w;

    /* renamed from: x, reason: collision with root package name */
    public long f5128x;

    /* renamed from: y, reason: collision with root package name */
    public long f5129y;

    /* renamed from: z, reason: collision with root package name */
    public long f5130z;

    public interface a {
        void a(long j7);

        void b(long j7);

        void c(long j7, long j8, long j9, long j10);

        void d(long j7, long j8, long j9, long j10);
    }

    public d0(a aVar, InterfaceC0321g interfaceC0321g, AudioTrack audioTrack, int i7, int i8, int i9) {
        this.f5105a = (a) j3.o.q(aVar);
        this.f5106b = interfaceC0321g;
        this.f5108d = audioTrack;
        try {
            this.f5117m = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f5107c = new long[10];
        this.f5130z = -9223372036854775807L;
        this.f5129y = -9223372036854775807L;
        this.f5112h = new C(audioTrack, aVar);
        int sampleRate = audioTrack.getSampleRate();
        this.f5109e = sampleRate;
        boolean zE0 = E0.U.E0(i7);
        this.f5111g = zE0;
        this.f5110f = zE0 ? E0.U.c1(i9 / i8, sampleRate) : -9223372036854775807L;
        this.f5121q = 0L;
        this.f5122r = 0L;
        this.f5103A = false;
        this.f5104B = 0L;
        this.f5125u = -9223372036854775807L;
        this.f5126v = -9223372036854775807L;
        this.f5119o = 0L;
        this.f5118n = 0L;
        this.f5113i = 1.0f;
        this.f5114j = -9223372036854775807L;
    }

    public void a() {
        this.f5103A = true;
        this.f5112h.d();
    }

    public long b() {
        AudioTrack audioTrack = (AudioTrack) j3.o.q(this.f5108d);
        if (audioTrack.getPlayState() == 3) {
            j();
        }
        long jF = this.f5106b.f() / 1000;
        boolean zF = this.f5112h.f();
        long jE = zF ? this.f5112h.e(jF, this.f5113i) : d(jF);
        int playState = audioTrack.getPlayState();
        if (playState != 3) {
            if (playState == 1) {
                k(jE);
            }
            return jE;
        }
        if (zF || !this.f5112h.h()) {
            k(jE);
        }
        long j7 = this.f5130z;
        if (j7 != -9223372036854775807L) {
            long j8 = jE - this.f5129y;
            long jG0 = E0.U.g0(jF - j7, this.f5113i);
            long j9 = this.f5129y + jG0;
            long jAbs = Math.abs(j9 - jE);
            if (j8 != 0 && jAbs < 1000000) {
                long j10 = (jG0 * 10) / 100;
                jE = E0.U.p(jE, j9 - j10, j9 + j10);
            }
        }
        this.f5130z = jF;
        this.f5129y = jE;
        return jE;
    }

    public final long c() {
        if (this.f5125u != -9223372036854775807L) {
            return Math.min(this.f5128x, f());
        }
        long jE = this.f5106b.e();
        if (jE - this.f5120p >= 5) {
            q(jE);
            this.f5120p = jE;
        }
        return this.f5121q + this.f5104B + (this.f5122r << 32);
    }

    public final long d(long j7) {
        long jMax = Math.max(0L, (this.f5124t == 0 ? this.f5125u != -9223372036854775807L ? E0.U.c1(f(), this.f5109e) : e() : E0.U.g0(j7 + this.f5115k, this.f5113i)) - this.f5118n);
        return this.f5125u != -9223372036854775807L ? Math.min(E0.U.c1(this.f5128x, this.f5109e), jMax) : jMax;
    }

    public final long e() {
        return E0.U.c1(c(), this.f5109e);
    }

    public final long f() {
        if (((AudioTrack) j3.o.q(this.f5108d)).getPlayState() == 2) {
            return this.f5127w;
        }
        return this.f5127w + E0.U.E(E0.U.g0(E0.U.P0(this.f5106b.e()) - this.f5125u, this.f5113i), this.f5109e);
    }

    public void g(long j7) {
        this.f5127w = c();
        this.f5125u = E0.U.P0(this.f5106b.e());
        this.f5128x = j7;
    }

    public boolean h() {
        return ((AudioTrack) j3.o.q(this.f5108d)).getPlayState() == 3;
    }

    public boolean i(long j7) {
        return this.f5126v != -9223372036854775807L && j7 > 0 && this.f5106b.e() - this.f5126v >= 200;
    }

    public final void j() {
        long jF = this.f5106b.f() / 1000;
        if (jF - this.f5116l >= 30000) {
            long jE = e();
            if (jE != 0) {
                this.f5107c[this.f5123s] = E0.U.m0(jE, this.f5113i) - jF;
                this.f5123s = (this.f5123s + 1) % 10;
                int i7 = this.f5124t;
                if (i7 < 10) {
                    this.f5124t = i7 + 1;
                }
                this.f5116l = jF;
                this.f5115k = 0L;
                int i8 = 0;
                while (true) {
                    int i9 = this.f5124t;
                    if (i8 >= i9) {
                        break;
                    }
                    this.f5115k += this.f5107c[i8] / i9;
                    i8++;
                }
            } else {
                return;
            }
        }
        this.f5112h.i(jF, this.f5113i, d(jF), l(jF));
    }

    public final void k(long j7) {
        long j8 = this.f5114j;
        if (j8 == -9223372036854775807L || j7 < j8) {
            return;
        }
        long jA = this.f5106b.a() - E0.U.s1(E0.U.m0(j7 - j8, this.f5113i));
        this.f5114j = -9223372036854775807L;
        this.f5105a.a(jA);
    }

    public final boolean l(long j7) {
        Method method;
        long j8 = this.f5118n;
        if (this.f5111g && (method = this.f5117m) != null && j7 - this.f5119o >= 500000) {
            try {
                long jIntValue = (((Integer) E0.U.i((Integer) method.invoke(j3.o.q(this.f5108d), null))).intValue() * 1000) - this.f5110f;
                this.f5118n = jIntValue;
                long jMax = Math.max(jIntValue, 0L);
                this.f5118n = jMax;
                if (jMax > 10000000) {
                    this.f5105a.b(jMax);
                    this.f5118n = 0L;
                }
            } catch (Exception unused) {
                this.f5117m = null;
            }
            this.f5119o = j7;
        }
        return j8 != this.f5118n;
    }

    public void m() {
        n();
        if (this.f5125u == -9223372036854775807L) {
            this.f5112h.j();
        }
        this.f5127w = c();
    }

    public final void n() {
        this.f5115k = 0L;
        this.f5124t = 0;
        this.f5123s = 0;
        this.f5116l = 0L;
        this.f5129y = -9223372036854775807L;
        this.f5130z = -9223372036854775807L;
    }

    public void o(float f7) {
        this.f5113i = f7;
        this.f5112h.j();
        n();
    }

    public void p() {
        if (this.f5125u != -9223372036854775807L) {
            this.f5125u = E0.U.P0(this.f5106b.e());
        }
        this.f5114j = e();
        this.f5112h.j();
    }

    public final void q(long j7) {
        int playState = ((AudioTrack) j3.o.q(this.f5108d)).getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = r0.getPlaybackHeadPosition() & 4294967295L;
        if (Build.VERSION.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.f5121q > 0 && playState == 3) {
                if (this.f5126v == -9223372036854775807L) {
                    this.f5126v = j7;
                    return;
                }
                return;
            }
            this.f5126v = -9223372036854775807L;
        }
        long j8 = this.f5121q;
        if (j8 > playbackHeadPosition) {
            if (this.f5103A) {
                this.f5104B += j8;
                this.f5103A = false;
            } else {
                this.f5122r++;
            }
        }
        this.f5121q = playbackHeadPosition;
    }
}
