package q;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: q.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1487y extends C1482t {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f21351d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f21352e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f21353f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f21354g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21355h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21356i;

    public C1487y(SeekBar seekBar) {
        super(seekBar);
        this.f21353f = null;
        this.f21354g = null;
        this.f21355h = false;
        this.f21356i = false;
        this.f21351d = seekBar;
    }

    @Override // q.C1482t
    public void c(AttributeSet attributeSet, int i7) {
        super.c(attributeSet, i7);
        d0 d0VarV = d0.v(this.f21351d.getContext(), attributeSet, i.j.f17197T, i7, 0);
        SeekBar seekBar = this.f21351d;
        Z.W.j0(seekBar, seekBar.getContext(), i.j.f17197T, attributeSet, d0VarV.r(), i7, 0);
        Drawable drawableH = d0VarV.h(i.j.f17201U);
        if (drawableH != null) {
            this.f21351d.setThumb(drawableH);
        }
        j(d0VarV.g(i.j.f17205V));
        if (d0VarV.s(i.j.f17213X)) {
            this.f21354g = N.e(d0VarV.k(i.j.f17213X, -1), this.f21354g);
            this.f21356i = true;
        }
        if (d0VarV.s(i.j.f17209W)) {
            this.f21353f = d0VarV.c(i.j.f17209W);
            this.f21355h = true;
        }
        d0VarV.w();
        f();
    }

    public final void f() {
        Drawable drawable = this.f21352e;
        if (drawable != null) {
            if (this.f21355h || this.f21356i) {
                Drawable drawableR = P.a.r(drawable.mutate());
                this.f21352e = drawableR;
                if (this.f21355h) {
                    P.a.o(drawableR, this.f21353f);
                }
                if (this.f21356i) {
                    P.a.p(this.f21352e, this.f21354g);
                }
                if (this.f21352e.isStateful()) {
                    this.f21352e.setState(this.f21351d.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f21352e != null) {
            int max = this.f21351d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f21352e.getIntrinsicWidth();
                int intrinsicHeight = this.f21352e.getIntrinsicHeight();
                int i7 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i8 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f21352e.setBounds(-i7, -i8, i7, i8);
                float width = ((this.f21351d.getWidth() - this.f21351d.getPaddingLeft()) - this.f21351d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f21351d.getPaddingLeft(), this.f21351d.getHeight() / 2);
                for (int i9 = 0; i9 <= max; i9++) {
                    this.f21352e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f21352e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f21351d.getDrawableState())) {
            this.f21351d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f21352e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f21352e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f21352e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f21351d);
            P.a.m(drawable, Z.W.A(this.f21351d));
            if (drawable.isStateful()) {
                drawable.setState(this.f21351d.getDrawableState());
            }
            f();
        }
        this.f21351d.invalidate();
    }
}
