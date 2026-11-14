package j;

/* loaded from: classes.dex */
public class x {

    /* renamed from: d, reason: collision with root package name */
    public static x f18611d;

    /* renamed from: a, reason: collision with root package name */
    public long f18612a;

    /* renamed from: b, reason: collision with root package name */
    public long f18613b;

    /* renamed from: c, reason: collision with root package name */
    public int f18614c;

    public static x b() {
        if (f18611d == null) {
            f18611d = new x();
        }
        return f18611d;
    }

    public void a(long j7, double d7, double d8) {
        double d9 = (0.01720197f * ((j7 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d9) * 0.03341960161924362d) + d9 + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = Math.round((r2 - 9.0E-4f) - r6) + 9.0E-4f + ((-d8) / 360.0d) + (Math.sin(d9) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d10 = 0.01745329238474369d * d7;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d10) * Math.sin(dAsin))) / (Math.cos(d10) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f18614c = 1;
            this.f18612a = -1L;
            this.f18613b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f18614c = 0;
                this.f18612a = -1L;
                this.f18613b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f18612a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.f18613b = jRound;
            if (jRound >= j7 || this.f18612a <= j7) {
                this.f18614c = 1;
            } else {
                this.f18614c = 0;
            }
        }
    }
}
