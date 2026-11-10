package Q5;

import java.util.Random;

/* loaded from: classes.dex */
public abstract class a extends c {
    @Override // Q5.c
    public int b(int i7) {
        return d.e(f().nextInt(), i7);
    }

    @Override // Q5.c
    public int c() {
        return f().nextInt();
    }

    @Override // Q5.c
    public int d(int i7) {
        return f().nextInt(i7);
    }

    public abstract Random f();
}
