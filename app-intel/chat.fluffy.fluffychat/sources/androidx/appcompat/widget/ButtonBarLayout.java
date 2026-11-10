package androidx.appcompat.widget;

import Z.W;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import i.f;
import i.j;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: l, reason: collision with root package name */
    public boolean f11352l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11353m;

    /* renamed from: n, reason: collision with root package name */
    public int f11354n;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11354n = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f17169N0);
        W.j0(this, context, j.f17169N0, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f11352l = typedArrayObtainStyledAttributes.getBoolean(j.f17174O0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f11352l);
        }
    }

    private void setStacked(boolean z7) {
        if (this.f11353m != z7) {
            if (!z7 || this.f11352l) {
                this.f11353m = z7;
                setOrientation(z7 ? 1 : 0);
                setGravity(z7 ? 8388613 : 80);
                View viewFindViewById = findViewById(f.f17029G);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z7 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    public final int a(int i7) {
        int childCount = getChildCount();
        while (i7 < childCount) {
            if (getChildAt(i7).getVisibility() == 0) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public final boolean b() {
        return this.f11353m;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        int iMakeMeasureSpec;
        boolean z7;
        int size = View.MeasureSpec.getSize(i7);
        int paddingBottom = 0;
        if (this.f11352l) {
            if (size > this.f11354n && b()) {
                setStacked(false);
            }
            this.f11354n = size;
        }
        if (b() || View.MeasureSpec.getMode(i7) != 1073741824) {
            iMakeMeasureSpec = i7;
            z7 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z7 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i8);
        if (this.f11352l && !b() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z7 = true;
        }
        if (z7) {
            super.onMeasure(i7, i8);
        }
        int iA = a(0);
        if (iA >= 0) {
            View childAt = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (W.B(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i8 == 0) {
                super.onMeasure(i7, i8);
            }
        }
    }

    public void setAllowStacking(boolean z7) {
        if (this.f11352l != z7) {
            this.f11352l = z7;
            if (!z7 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
