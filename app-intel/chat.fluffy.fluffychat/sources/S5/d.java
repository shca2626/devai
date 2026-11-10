package S5;

import M5.m;

/* loaded from: classes.dex */
public class d {
    public static final void a(boolean z7, Number number) {
        m.e(number, "step");
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
