package R5;

import M5.m;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public final class a extends Q5.a {
    @Override // Q5.c
    public int e(int i7, int i8) {
        return ThreadLocalRandom.current().nextInt(i7, i8);
    }

    @Override // Q5.a
    public Random f() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        m.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
