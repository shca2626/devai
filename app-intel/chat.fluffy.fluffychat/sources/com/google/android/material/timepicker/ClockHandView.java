package com.google.android.material.timepicker;

import O2.i;
import O2.j;
import Z.W;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: A, reason: collision with root package name */
    public int f14758A;

    /* renamed from: l, reason: collision with root package name */
    public ValueAnimator f14759l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14760m;

    /* renamed from: n, reason: collision with root package name */
    public float f14761n;

    /* renamed from: o, reason: collision with root package name */
    public float f14762o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14763p;

    /* renamed from: q, reason: collision with root package name */
    public int f14764q;

    /* renamed from: r, reason: collision with root package name */
    public final List f14765r;

    /* renamed from: s, reason: collision with root package name */
    public final int f14766s;

    /* renamed from: t, reason: collision with root package name */
    public final float f14767t;

    /* renamed from: u, reason: collision with root package name */
    public final Paint f14768u;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f14769v;

    /* renamed from: w, reason: collision with root package name */
    public final int f14770w;

    /* renamed from: x, reason: collision with root package name */
    public float f14771x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14772y;

    /* renamed from: z, reason: collision with root package name */
    public double f14773z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f7, boolean z7);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, O2.a.f6759v);
    }

    public void b(c cVar) {
        this.f14765r.add(cVar);
    }

    public final void c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.f14758A * ((float) Math.cos(this.f14773z))) + width;
        float f7 = height;
        float fSin = (this.f14758A * ((float) Math.sin(this.f14773z))) + f7;
        this.f14768u.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f14766s, this.f14768u);
        double dSin = Math.sin(this.f14773z);
        double dCos = Math.cos(this.f14773z);
        this.f14768u.setStrokeWidth(this.f14770w);
        canvas.drawLine(width, f7, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f14768u);
        canvas.drawCircle(width, f7, this.f14767t, this.f14768u);
    }

    public RectF d() {
        return this.f14769v;
    }

    public final int e(float f7, float f8) {
        int degrees = (int) Math.toDegrees(Math.atan2(f8 - (getHeight() / 2), f7 - (getWidth() / 2)));
        int i7 = degrees + 90;
        return i7 < 0 ? degrees + 450 : i7;
    }

    public float f() {
        return this.f14771x;
    }

    public int g() {
        return this.f14766s;
    }

    public final Pair h(float f7) {
        float f8 = f();
        if (Math.abs(f8 - f7) > 180.0f) {
            if (f8 > 180.0f && f7 < 180.0f) {
                f7 += 360.0f;
            }
            if (f8 < 180.0f && f7 > 180.0f) {
                f8 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(f8), Float.valueOf(f7));
    }

    public final boolean i(float f7, float f8, boolean z7, boolean z8, boolean z9) {
        float fE = e(f7, f8);
        boolean z10 = false;
        boolean z11 = f() != fE;
        if (z8 && z11) {
            return true;
        }
        if (!z11 && !z7) {
            return false;
        }
        if (z9 && this.f14760m) {
            z10 = true;
        }
        l(fE, z10);
        return true;
    }

    public void j(int i7) {
        this.f14758A = i7;
        invalidate();
    }

    public void k(float f7) {
        l(f7, false);
    }

    public void l(float f7, boolean z7) {
        ValueAnimator valueAnimator = this.f14759l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z7) {
            m(f7, false);
            return;
        }
        Pair pairH = h(f7);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pairH.first).floatValue(), ((Float) pairH.second).floatValue());
        this.f14759l = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f14759l.addUpdateListener(new a());
        this.f14759l.addListener(new b());
        this.f14759l.start();
    }

    public final void m(float f7, boolean z7) {
        float f8 = f7 % 360.0f;
        this.f14771x = f8;
        this.f14773z = Math.toRadians(f8 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.f14758A * ((float) Math.cos(this.f14773z)));
        float fSin = height + (this.f14758A * ((float) Math.sin(this.f14773z)));
        RectF rectF = this.f14769v;
        int i7 = this.f14766s;
        rectF.set(width - i7, fSin - i7, width + i7, fSin + i7);
        Iterator it = this.f14765r.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(f8, z7);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        k(f());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        boolean z8;
        boolean z9;
        int actionMasked = motionEvent.getActionMasked();
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f14761n = x7;
            this.f14762o = y7;
            this.f14763p = true;
            this.f14772y = false;
            z7 = true;
            z8 = false;
            z9 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i7 = (int) (x7 - this.f14761n);
            int i8 = (int) (y7 - this.f14762o);
            this.f14763p = (i7 * i7) + (i8 * i8) > this.f14764q;
            z8 = this.f14772y;
            z9 = actionMasked == 1;
            z7 = false;
        } else {
            z8 = false;
            z7 = false;
            z9 = false;
        }
        this.f14772y |= i(x7, y7, z8, z7, z9);
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f14765r = new ArrayList();
        Paint paint = new Paint();
        this.f14768u = paint;
        this.f14769v = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f7034R0, i7, i.f6913m);
        this.f14758A = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f7048T0, 0);
        this.f14766s = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f7055U0, 0);
        this.f14770w = getResources().getDimensionPixelSize(O2.c.f6792h);
        this.f14767t = r6.getDimensionPixelSize(O2.c.f6790f);
        int color = typedArrayObtainStyledAttributes.getColor(j.f7041S0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        k(0.0f);
        this.f14764q = ViewConfiguration.get(context).getScaledTouchSlop();
        W.v0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
