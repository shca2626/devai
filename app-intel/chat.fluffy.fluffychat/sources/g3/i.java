package g3;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* loaded from: classes.dex */
public class i extends f3.g {

    /* renamed from: K, reason: collision with root package name */
    public final RectF f16229K;

    public i(f3.k kVar) {
        super(kVar == null ? new f3.k() : kVar);
        this.f16229K = new RectF();
    }

    public boolean f0() {
        return !this.f16229K.isEmpty();
    }

    public void g0() {
        h0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void h0(float f7, float f8, float f9, float f10) {
        RectF rectF = this.f16229K;
        if (f7 == rectF.left && f8 == rectF.top && f9 == rectF.right && f10 == rectF.bottom) {
            return;
        }
        rectF.set(f7, f8, f9, f10);
        invalidateSelf();
    }

    public void i0(RectF rectF) {
        h0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // f3.g
    public void r(Canvas canvas) {
        if (this.f16229K.isEmpty()) {
            super.r(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.f16229K);
        } else {
            canvas.clipRect(this.f16229K, Region.Op.DIFFERENCE);
        }
        super.r(canvas);
        canvas.restore();
    }
}
