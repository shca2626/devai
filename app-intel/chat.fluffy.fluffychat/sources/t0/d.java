package t0;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f22498a;

    /* renamed from: b, reason: collision with root package name */
    public final float f22499b;

    public d(float[] fArr) {
        this.f22498a = fArr;
        this.f22499b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f7) {
        if (f7 >= 1.0f) {
            return 1.0f;
        }
        if (f7 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f22498a;
        int iMin = Math.min((int) ((fArr.length - 1) * f7), fArr.length - 2);
        float f8 = this.f22499b;
        float f9 = (f7 - (iMin * f8)) / f8;
        float[] fArr2 = this.f22498a;
        float f10 = fArr2[iMin];
        return f10 + (f9 * (fArr2[iMin + 1] - f10));
    }
}
