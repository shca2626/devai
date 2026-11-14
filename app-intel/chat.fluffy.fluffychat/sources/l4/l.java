package l4;

import android.graphics.Rect;
import android.util.Log;
import k4.s;

/* loaded from: classes.dex */
public class l extends q {

    /* renamed from: b, reason: collision with root package name */
    public static final String f19654b = "l";

    @Override // l4.q
    public float c(s sVar, s sVar2) {
        if (sVar.f19099l <= 0 || sVar.f19100m <= 0) {
            return 0.0f;
        }
        s sVarE = sVar.e(sVar2);
        float fPow = (sVarE.f19099l * 1.0f) / sVar.f19099l;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f7 = ((sVarE.f19099l * 1.0f) / sVar2.f19099l) + ((sVarE.f19100m * 1.0f) / sVar2.f19100m);
        return fPow * ((1.0f / f7) / f7);
    }

    @Override // l4.q
    public Rect d(s sVar, s sVar2) {
        s sVarE = sVar.e(sVar2);
        Log.i(f19654b, "Preview: " + sVar + "; Scaled: " + sVarE + "; Want: " + sVar2);
        int i7 = (sVarE.f19099l - sVar2.f19099l) / 2;
        int i8 = (sVarE.f19100m - sVar2.f19100m) / 2;
        return new Rect(-i7, -i8, sVarE.f19099l - i7, sVarE.f19100m - i8);
    }
}
