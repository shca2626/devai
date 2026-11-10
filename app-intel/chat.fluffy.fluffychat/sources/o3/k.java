package o3;

import j3.o;

/* loaded from: classes.dex */
public abstract class k {
    public static int a(long j7) {
        o.i((j7 >> 32) == 0, "out of range: %s", j7);
        return (int) j7;
    }
}
