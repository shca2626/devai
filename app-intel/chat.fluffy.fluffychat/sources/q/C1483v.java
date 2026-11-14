package q;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import i.AbstractC1146a;

/* renamed from: q.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1483v extends RatingBar {

    /* renamed from: l, reason: collision with root package name */
    public final C1481t f21355l;

    public C1483v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1146a.f16922E);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        Bitmap bitmapB = this.f21355l.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i7, 0), getMeasuredHeight());
        }
    }

    public C1483v(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        Z.a(this, getContext());
        C1481t c1481t = new C1481t(this);
        this.f21355l = c1481t;
        c1481t.c(attributeSet, i7);
    }
}
