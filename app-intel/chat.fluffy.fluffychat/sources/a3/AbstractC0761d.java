package a3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

/* renamed from: a3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0761d extends androidx.appcompat.widget.b {

    /* renamed from: A, reason: collision with root package name */
    public Drawable f10741A;

    /* renamed from: B, reason: collision with root package name */
    public final Rect f10742B;

    /* renamed from: C, reason: collision with root package name */
    public final Rect f10743C;

    /* renamed from: D, reason: collision with root package name */
    public int f10744D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f10745E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f10746F;

    public AbstractC0761d(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f10742B = new Rect();
        this.f10743C = new Rect();
        this.f10744D = 119;
        this.f10745E = true;
        this.f10746F = false;
        TypedArray typedArrayI = k.i(context, attributeSet, O2.j.f7242s1, i7, 0, new int[0]);
        this.f10744D = typedArrayI.getInt(O2.j.f7257u1, this.f10744D);
        Drawable drawable = typedArrayI.getDrawable(O2.j.f7250t1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f10745E = typedArrayI.getBoolean(O2.j.f7264v1, true);
        typedArrayI.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f10741A;
        if (drawable != null) {
            if (this.f10746F) {
                this.f10746F = false;
                Rect rect = this.f10742B;
                Rect rect2 = this.f10743C;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f10745E) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f10744D, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f7, float f8) {
        super.drawableHotspotChanged(f7, f8);
        Drawable drawable = this.f10741A;
        if (drawable != null) {
            drawable.setHotspot(f7, f8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f10741A;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f10741A.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f10741A;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f10744D;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f10741A;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        this.f10746F = z7 | this.f10746F;
    }

    @Override // android.view.View
    public void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        this.f10746F = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f10741A;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f10741A);
            }
            this.f10741A = drawable;
            this.f10746F = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f10744D == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i7) {
        if (this.f10744D != i7) {
            if ((8388615 & i7) == 0) {
                i7 |= 8388611;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            this.f10744D = i7;
            if (i7 == 119 && this.f10741A != null) {
                this.f10741A.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10741A;
    }
}
