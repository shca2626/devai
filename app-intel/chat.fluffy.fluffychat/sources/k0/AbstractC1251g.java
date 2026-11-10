package k0;

import M5.m;
import java.util.Arrays;
import k0.AbstractC1250f;

/* renamed from: k0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1251g {
    public static final AbstractC1250f a() {
        return new C1247c(null, true, 1, null);
    }

    public static final C1247c b(AbstractC1250f.b... bVarArr) {
        m.e(bVarArr, "pairs");
        C1247c c1247c = new C1247c(null, false, 1, null);
        c1247c.h((AbstractC1250f.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        return c1247c;
    }
}
