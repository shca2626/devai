package q;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import i.AbstractC1146a;

/* renamed from: q.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1485x extends SeekBar {

    /* renamed from: l, reason: collision with root package name */
    public final C1486y f21356l;

    public C1485x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1146a.f16924G);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f21356l.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f21356l.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f21356l.g(canvas);
    }

    public C1485x(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        Z.a(this, getContext());
        C1486y c1486y = new C1486y(this);
        this.f21356l = c1486y;
        c1486y.c(attributeSet, i7);
    }
}
