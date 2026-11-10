package o3;

import j3.o;

/* loaded from: classes.dex */
public abstract class c {
    public static char a(long j7) {
        char c7 = (char) j7;
        o.i(((long) c7) == j7, "Out of range: %s", j7);
        return c7;
    }

    public static boolean b(char[] cArr, char c7) {
        for (char c8 : cArr) {
            if (c8 == c7) {
                return true;
            }
        }
        return false;
    }

    public static char c(byte b7, byte b8) {
        return (char) ((b7 << 8) | (b8 & 255));
    }
}
