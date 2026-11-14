package q;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: q.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1486y extends C1481t {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f21357d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f21358e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f21359f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f21360g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21361h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21362i;

    public C1486y(SeekBar seekBar) {
        super(seekBar);
        this.f21359f = null;
        this.f21360g = null;
        this.f21361h = false;
        this.f21362i = false;
        this.f21357d = seekBar;
    }

    @Override // q.C1481t
    public void c(AttributeSet attributeSet, int i7) {
        super.c(attributeSet, i7);
        d0 d0VarV = d0.v(this.f21357d.getContext(), attributeSet, i.j.f17197T, i7, 0);
        SeekBar seekBar = this.f21357d;
        Z.W.j0(seekBar, seekBar.getContext(), i.j.f17197T, attributeSet, d0VarV.r(), i7, 0);
        Drawable drawableH = d0VarV.h(i.j.f17201U);
        if (drawableH != null) {
            this.f21357d.setThumb(drawableH);
        }
        j(d0VarV.g(i.j.f17205V));
        if (d0VarV.s(i.j.f17213X)) {
            this.f21360g = N.e(d0VarV.k(i.j.f17213X, -1), this.f21360g);
            this.f21362i = true;
        }
        if (d0VarV.s(i.j.f17209W)) {
            this.f21359f = d0VarV.c(i.j.f17209W);
            this.f21361h = true;
        }
        d0VarV.w();
        f();
    }

    public final void f() {
        Drawable drawable = this.f21358e;
        if (drawable != null) {
            if (this.f21361h || this.f21362i) {
                Drawable drawableR = P.a.r(drawable.mutate());
                this.f21358e = drawableR;
                if (this.f21361h) {
                    P.a.o(drawableR, this.f21359f);
                }
                if (this.f21362i) {
                    P.a.p(this.f21358e, this.f21360g);
                }
                if (this.f21358e.isStateful()) {
                    this.f21358e.setState(this.f21357d.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f21358e != null) {
            int max = this.f21357d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f21358e.getIntrinsicWidth();
                int intrinsicHeight = this.f21358e.getIntrinsicHeight();
                int i7 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i8 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f21358e.setBounds(-i7, -i8, i7, i8);
                float width = ((this.f21357d.getWidth() - this.f21357d.getPaddingLeft()) - this.f21357d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f21357d.getPaddingLeft(), this.f21357d.getHeight() / 2);
                for (int i9 = 0; i9 <= max; i9++) {
                    this.f21358e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f21358e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f21357d.getDrawableState())) {
            this.f21357d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f21358e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f21358e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f21358e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f21357d);
            P.a.m(drawable, Z.W.A(this.f21357d));
            if (drawable.isStateful()) {
                drawable.setState(this.f21357d.getDrawableState());
            }
            f();
        }
        this.f21357d.invalidate();
    }
}
