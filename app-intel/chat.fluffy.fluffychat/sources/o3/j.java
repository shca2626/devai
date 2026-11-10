package o3;

import j3.o;

/* loaded from: classes.dex */
public abstract class j {
    public static byte a(long j7) {
        o.i((j7 >> 8) == 0, "out of range: %s", j7);
        return (byte) j7;
    }

    public static int b(byte b7) {
        return b7 & 255;
    }
}
