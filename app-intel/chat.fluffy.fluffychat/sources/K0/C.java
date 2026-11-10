package K0;

import K0.d0;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public final a f5027a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5028b;

    /* renamed from: c, reason: collision with root package name */
    public final d0.a f5029c;

    /* renamed from: d, reason: collision with root package name */
    public int f5030d;

    /* renamed from: e, reason: collision with root package name */
    public long f5031e;

    /* renamed from: f, reason: collision with root package name */
    public long f5032f;

    /* renamed from: g, reason: collision with root package name */
    public long f5033g;

    /* renamed from: h, reason: collision with root package name */
    public long f5034h;

    /* renamed from: i, reason: collision with root package name */
    public long f5035i;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final AudioTrack f5036a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f5037b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        public long f5038c;

        /* renamed from: d, reason: collision with root package name */
        public long f5039d;

        /* renamed from: e, reason: collision with root package name */
        public long f5040e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f5041f;

        /* renamed from: g, reason: collision with root package name */
        public long f5042g;

        public a(AudioTrack audioTrack) {
            this.f5036a = audioTrack;
        }

        public void a() {
            this.f5041f = true;
        }

        public long b() {
            return this.f5040e;
        }

        public long c() {
            return this.f5037b.nanoTime / 1000;
        }

        public boolean d() {
            boolean timestamp = this.f5036a.getTimestamp(this.f5037b);
            if (timestamp) {
                long j7 = this.f5037b.framePosition;
                long j8 = this.f5039d;
                if (j8 > j7) {
                    if (this.f5041f) {
                        this.f5042g += j8;
                        this.f5041f = false;
                    } else {
                        this.f5038c++;
                    }
                }
                this.f5039d = j7;
                this.f5040e = j7 + this.f5042g + (this.f5038c << 32);
            }
            return timestamp;
        }
    }

    public C(AudioTrack audioTrack, d0.a aVar) {
        this.f5027a = new a(audioTrack);
        this.f5028b = audioTrack.getSampleRate();
        this.f5029c = aVar;
        j();
    }

    public final void a(long j7, float f7, long j8) {
        long jC = this.f5027a.c();
        long jB = b(j7, f7);
        if (Math.abs(jC - j7) > 5000000) {
            this.f5029c.d(this.f5027a.b(), jC, j7, j8);
            k(4);
        } else if (Math.abs(jB - j8) > 5000000) {
            this.f5029c.c(this.f5027a.b(), jC, j7, j8);
            k(4);
        } else if (this.f5030d == 4) {
            j();
        }
    }

    public final long b(long j7, float f7) {
        return c(this.f5027a.b(), this.f5027a.c(), j7, f7);
    }

    public final long c(long j7, long j8, long j9, float f7) {
        return E0.U.c1(j7, this.f5028b) + E0.U.g0(j9 - j8, f7);
    }

    public void d() {
        this.f5027a.a();
    }

    public long e(long j7, float f7) {
        return b(j7, f7);
    }

    public boolean f() {
        return this.f5030d == 2;
    }

    public final boolean g(long j7, float f7) {
        long jB = this.f5027a.b();
        long j8 = this.f5034h;
        if (jB <= j8) {
            return false;
        }
        return Math.abs(b(j7, f7) - c(j8, this.f5035i, j7, f7)) < 1000;
    }

    public boolean h() {
        int i7 = this.f5030d;
        return i7 == 0 || i7 == 1;
    }

    public void i(long j7, float f7, long j8, boolean z7) {
        if (z7 || j7 - this.f5033g >= this.f5032f) {
            this.f5033g = j7;
            boolean zD = this.f5027a.d();
            if (zD) {
                a(j7, f7, j8);
            }
            int i7 = this.f5030d;
            if (i7 == 0) {
                if (!zD) {
                    if (j7 - this.f5031e > 500000) {
                        k(3);
                        return;
                    }
                    return;
                } else {
                    if (this.f5027a.c() >= this.f5031e) {
                        this.f5034h = this.f5027a.b();
                        this.f5035i = this.f5027a.c();
                        k(1);
                        return;
                    }
                    return;
                }
            }
            if (i7 == 1) {
                if (!zD) {
                    j();
                    return;
                }
                if (g(j7, f7)) {
                    k(2);
                    return;
                } else if (j7 - this.f5031e > 2000000) {
                    k(3);
                    return;
                } else {
                    this.f5034h = this.f5027a.b();
                    this.f5035i = this.f5027a.c();
                    return;
                }
            }
            if (i7 == 2) {
                if (zD) {
                    return;
                }
                j();
            } else if (i7 != 3) {
                if (i7 != 4) {
                    throw new IllegalStateException();
                }
            } else if (zD) {
                j();
            }
        }
    }

    public void j() {
        k(0);
    }

    public final void k(int i7) {
        this.f5030d = i7;
        if (i7 == 0) {
            this.f5033g = 0L;
            this.f5034h = -1L;
            this.f5035i = -9223372036854775807L;
            this.f5031e = System.nanoTime() / 1000;
            this.f5032f = 10000L;
            return;
        }
        if (i7 == 1) {
            this.f5032f = 10000L;
            return;
        }
        if (i7 == 2 || i7 == 3) {
            this.f5032f = 10000000L;
        } else {
            if (i7 != 4) {
                throw new IllegalStateException();
            }
            this.f5032f = 500000L;
        }
    }
}
