package q;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import i.AbstractC1145a;

/* renamed from: q.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1486x extends SeekBar {

    /* renamed from: l, reason: collision with root package name */
    public final C1487y f21350l;

    public C1486x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16924G);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f21350l.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f21350l.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f21350l.g(canvas);
    }

    public C1486x(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        Z.a(this, getContext());
        C1487y c1487y = new C1487y(this);
        this.f21350l = c1487y;
        c1487y.c(attributeSet, i7);
    }
}
