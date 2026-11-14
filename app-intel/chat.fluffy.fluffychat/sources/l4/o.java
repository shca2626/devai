package l4;

import android.graphics.Rect;
import k4.s;

/* loaded from: classes.dex */
public class o extends q {
    public static float e(float f7) {
        return f7 < 1.0f ? 1.0f / f7 : f7;
    }

    @Override // l4.q
    public float c(s sVar, s sVar2) {
        int i7 = sVar.f19099l;
        if (i7 <= 0 || sVar.f19100m <= 0) {
            return 0.0f;
        }
        float fE = (1.0f / e((i7 * 1.0f) / sVar2.f19099l)) / e((sVar.f19100m * 1.0f) / sVar2.f19100m);
        float fE2 = e(((sVar.f19099l * 1.0f) / sVar.f19100m) / ((sVar2.f19099l * 1.0f) / sVar2.f19100m));
        return fE * (((1.0f / fE2) / fE2) / fE2);
    }

    @Override // l4.q
    public Rect d(s sVar, s sVar2) {
        return new Rect(0, 0, sVar2.f19099l, sVar2.f19100m);
    }
}
