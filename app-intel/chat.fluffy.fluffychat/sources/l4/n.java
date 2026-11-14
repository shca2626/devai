package l4;

import android.graphics.Rect;
import android.util.Log;
import k4.s;

/* loaded from: classes.dex */
public class n extends q {

    /* renamed from: b, reason: collision with root package name */
    public static final String f19659b = "n";

    @Override // l4.q
    public float c(s sVar, s sVar2) {
        if (sVar.f19099l <= 0 || sVar.f19100m <= 0) {
            return 0.0f;
        }
        s sVarF = sVar.f(sVar2);
        float fPow = (sVarF.f19099l * 1.0f) / sVar.f19099l;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f7 = ((sVar2.f19099l * 1.0f) / sVarF.f19099l) * ((sVar2.f19100m * 1.0f) / sVarF.f19100m);
        return fPow * (((1.0f / f7) / f7) / f7);
    }

    @Override // l4.q
    public Rect d(s sVar, s sVar2) {
        s sVarF = sVar.f(sVar2);
        Log.i(f19659b, "Preview: " + sVar + "; Scaled: " + sVarF + "; Want: " + sVar2);
        int i7 = (sVarF.f19099l - sVar2.f19099l) / 2;
        int i8 = (sVarF.f19100m - sVar2.f19100m) / 2;
        return new Rect(-i7, -i8, sVarF.f19099l - i7, sVarF.f19100m - i8);
    }
}
