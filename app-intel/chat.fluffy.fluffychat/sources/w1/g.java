package w1;

import E0.E;
import E0.M;

/* loaded from: classes.dex */
public final class g extends AbstractC1728b {

    /* renamed from: a, reason: collision with root package name */
    public final long f23291a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23292b;

    public g(long j7, long j8) {
        this.f23291a = j7;
        this.f23292b = j8;
    }

    public static g d(E e7, long j7, M m7) {
        long jE = e(e7, j7);
        return new g(jE, m7.b(jE));
    }

    public static long e(E e7, long j7) {
        long jQ = e7.Q();
        if ((128 & jQ) != 0) {
            return 8589934591L & ((((jQ & 1) << 32) | e7.S()) + j7);
        }
        return -9223372036854775807L;
    }

    @Override // w1.AbstractC1728b
    public String toString() {
        return "SCTE-35 TimeSignalCommand { ptsTime=" + this.f23291a + ", playbackPositionUs= " + this.f23292b + " }";
    }
}
