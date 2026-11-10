package E5;

import M5.m;
import M5.x;

/* loaded from: classes.dex */
public abstract class l extends d implements M5.i {

    /* renamed from: o, reason: collision with root package name */
    public final int f2383o;

    public l(int i7, C5.e eVar) {
        super(eVar);
        this.f2383o = i7;
    }

    @Override // M5.i
    public int e() {
        return this.f2383o;
    }

    @Override // E5.a
    public String toString() {
        if (m() != null) {
            return super.toString();
        }
        String strF = x.f(this);
        m.d(strF, "renderLambdaToString(...)");
        return strF;
    }
}
