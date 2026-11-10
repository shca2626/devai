package androidx.legacy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: classes7.dex */
public class Space extends View {
    @Deprecated
    public Space(Context context, AttributeSet attributeSet, int i12) {
        super(context, attributeSet, i12);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int a(int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i13);
        int size = View.MeasureSpec.getSize(i13);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i12 : size : Math.min(i12, size);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    @Deprecated
    protected void onMeasure(int i12, int i13) {
        setMeasuredDimension(a(getSuggestedMinimumWidth(), i12), a(getSuggestedMinimumHeight(), i13));
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
