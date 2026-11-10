package a4;

import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f482a;

    /* renamed from: b, reason: collision with root package name */
    private final float f483b;

    protected d(float[] fArr) {
        this.f482a = fArr;
        this.f483b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f12) {
        if (f12 >= 1.0f) {
            return 1.0f;
        }
        if (f12 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float[] fArr = this.f482a;
        int iMin = Math.min((int) ((fArr.length - 1) * f12), fArr.length - 2);
        float f13 = this.f483b;
        float f14 = (f12 - (iMin * f13)) / f13;
        float[] fArr2 = this.f482a;
        float f15 = fArr2[iMin];
        return f15 + (f14 * (fArr2[iMin + 1] - f15));
    }
}
