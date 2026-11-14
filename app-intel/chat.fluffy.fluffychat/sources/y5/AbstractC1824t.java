package y5;

import V5.C0608a;

/* renamed from: y5.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1824t {
    public static final String a(long j7, int i7) {
        if (j7 >= 0) {
            String string = Long.toString(j7, C0608a.a(i7));
            M5.m.d(string, "toString(...)");
            return string;
        }
        long j8 = i7;
        long j9 = ((j7 >>> 1) / j8) << 1;
        long j10 = j7 - (j9 * j8);
        if (j10 >= j8) {
            j10 -= j8;
            j9++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j9, C0608a.a(i7));
        M5.m.d(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j10, C0608a.a(i7));
        M5.m.d(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
