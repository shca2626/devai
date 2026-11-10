package M5;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class n implements i, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final int f5717l;

    public n(int i7) {
        this.f5717l = i7;
    }

    @Override // M5.i
    public int e() {
        return this.f5717l;
    }

    public String toString() {
        String strG = x.g(this);
        m.d(strG, "renderLambdaToString(...)");
        return strG;
    }
}
