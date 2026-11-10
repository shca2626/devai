package androidx.appcompat.app;

/* loaded from: classes6.dex */
class h0 {

    /* renamed from: d, reason: collision with root package name */
    private static h0 f2052d;

    /* renamed from: a, reason: collision with root package name */
    public long f2053a;

    /* renamed from: b, reason: collision with root package name */
    public long f2054b;

    /* renamed from: c, reason: collision with root package name */
    public int f2055c;

    h0() {
    }

    static h0 b() {
        if (f2052d == null) {
            f2052d = new h0();
        }
        return f2052d;
    }

    public void a(long j12, double d12, double d13) {
        double d14 = (0.01720197f * ((j12 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d14) * 0.03341960161924362d) + d14 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = Math.round((r3 - 9.0E-4f) - r7) + 9.0E-4f + ((-d13) / 360.0d) + (Math.sin(d14) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d15 = 0.01745329238474369d * d12;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d15) * Math.sin(dAsin))) / (Math.cos(d15) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f2055c = 1;
            this.f2053a = -1L;
            this.f2054b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f2055c = 0;
                this.f2053a = -1L;
                this.f2054b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f2053a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.f2054b = jRound;
            if (jRound >= j12 || this.f2053a <= j12) {
                this.f2055c = 1;
            } else {
                this.f2055c = 0;
            }
        }
    }
}
