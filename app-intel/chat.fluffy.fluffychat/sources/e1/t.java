package e1;

import android.util.Range;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public long f15561a;

    /* renamed from: b, reason: collision with root package name */
    public long f15562b;

    /* renamed from: c, reason: collision with root package name */
    public double f15563c;

    /* renamed from: d, reason: collision with root package name */
    public Range f15564d;

    public t(float f7) {
        j3.o.d(f7 > 0.0f);
        Range range = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / f7));
        this.f15564d = range;
        this.f15563c = ((Double) range.getUpper()).doubleValue();
        this.f15561a = -9223372036854775807L;
        this.f15562b = -9223372036854775807L;
    }

    public final double a(long j7, long j8) {
        long j9 = this.f15561a;
        if (j9 != -9223372036854775807L) {
            if (this.f15562b != -9223372036854775807L && j7 != j9) {
                return (j8 - r4) / (j7 - j9);
            }
        }
        return ((Double) this.f15564d.getUpper()).doubleValue();
    }

    public void b(long j7, long j8) {
        j3.o.d(j7 != -9223372036854775807L);
        j3.o.d(j8 != -9223372036854775807L);
        f(((Double) this.f15564d.clamp(Double.valueOf(a(j7, j8)))).doubleValue());
        this.f15561a = j7;
        this.f15562b = j8;
    }

    public long c(long j7) {
        if (this.f15561a == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (long) (this.f15562b + ((j7 - r0) * this.f15563c));
    }

    public void d() {
        this.f15563c = ((Double) this.f15564d.getUpper()).doubleValue();
        this.f15561a = -9223372036854775807L;
        this.f15562b = -9223372036854775807L;
    }

    public void e(float f7) {
        j3.o.d(f7 > 0.0f);
        this.f15564d = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / f7));
        d();
    }

    public final void f(double d7) {
        this.f15563c = (this.f15563c * 0.800000011920929d) + (d7 * 0.20000000298023224d);
    }
}
