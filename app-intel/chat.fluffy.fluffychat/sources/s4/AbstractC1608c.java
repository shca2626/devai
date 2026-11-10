package s4;

/* renamed from: s4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1608c {
    public static /* synthetic */ long a(long j7, long j8) {
        if (j8 < 0) {
            return (j7 ^ Long.MIN_VALUE) < (j8 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j7 >= 0) {
            return j7 / j8;
        }
        long j9 = ((j7 >>> 1) / j8) << 1;
        return j9 + (((j7 - (j9 * j8)) ^ Long.MIN_VALUE) < (j8 ^ Long.MIN_VALUE) ? 0 : 1);
    }
}
