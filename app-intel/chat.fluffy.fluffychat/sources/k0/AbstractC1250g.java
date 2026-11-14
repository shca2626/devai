package k0;

import M5.m;
import java.util.Arrays;
import k0.AbstractC1249f;

/* renamed from: k0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1250g {
    public static final AbstractC1249f a() {
        return new C1246c(null, true, 1, null);
    }

    public static final C1246c b(AbstractC1249f.b... bVarArr) {
        m.e(bVarArr, "pairs");
        C1246c c1246c = new C1246c(null, false, 1, null);
        c1246c.h((AbstractC1249f.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        return c1246c;
    }
}
