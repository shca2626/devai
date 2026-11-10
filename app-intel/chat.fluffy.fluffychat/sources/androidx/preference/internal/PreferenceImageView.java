package androidx.preference.internal;

import R1.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class PreferenceImageView extends ImageView {

    /* renamed from: l, reason: collision with root package name */
    public int f12965l;

    /* renamed from: m, reason: collision with root package name */
    public int f12966m;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f12966m;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f12965l;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i7);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i7);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i7 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i8);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i8);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i8 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i7, i8);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i7) {
        this.f12966m = i7;
        super.setMaxHeight(i7);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i7) {
        this.f12965l = i7;
        super.setMaxWidth(i7);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f12965l = Integer.MAX_VALUE;
        this.f12966m = Integer.MAX_VALUE;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7993y0, i7, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(g.f7888A0, Integer.MAX_VALUE));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(g.f7995z0, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
    }
}
