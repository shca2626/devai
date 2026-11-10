package q;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import c0.AbstractC0891c;
import k.AbstractC1244a;

/* renamed from: q.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1472i {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f21274a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f21275b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f21276c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21277d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21278e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21279f;

    public C1472i(CompoundButton compoundButton) {
        this.f21274a = compoundButton;
    }

    public void a() {
        Drawable drawableA = AbstractC0891c.a(this.f21274a);
        if (drawableA != null) {
            if (this.f21277d || this.f21278e) {
                Drawable drawableMutate = P.a.r(drawableA).mutate();
                if (this.f21277d) {
                    P.a.o(drawableMutate, this.f21275b);
                }
                if (this.f21278e) {
                    P.a.p(drawableMutate, this.f21276c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f21274a.getDrawableState());
                }
                this.f21274a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList c() {
        return this.f21275b;
    }

    public PorterDuff.Mode d() {
        return this.f21276c;
    }

    public void e(AttributeSet attributeSet, int i7) {
        int iN;
        int iN2;
        d0 d0VarV = d0.v(this.f21274a.getContext(), attributeSet, i.j.f17202U0, i7, 0);
        CompoundButton compoundButton = this.f21274a;
        Z.W.j0(compoundButton, compoundButton.getContext(), i.j.f17202U0, attributeSet, d0VarV.r(), i7, 0);
        try {
            if (d0VarV.s(i.j.f17210W0) && (iN2 = d0VarV.n(i.j.f17210W0, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f21274a;
                    compoundButton2.setButtonDrawable(AbstractC1244a.b(compoundButton2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (d0VarV.s(i.j.f17206V0) && (iN = d0VarV.n(i.j.f17206V0, 0)) != 0) {
                CompoundButton compoundButton3 = this.f21274a;
                compoundButton3.setButtonDrawable(AbstractC1244a.b(compoundButton3.getContext(), iN));
            }
            if (d0VarV.s(i.j.f17214X0)) {
                AbstractC0891c.d(this.f21274a, d0VarV.c(i.j.f17214X0));
            }
            if (d0VarV.s(i.j.f17218Y0)) {
                AbstractC0891c.e(this.f21274a, N.e(d0VarV.k(i.j.f17218Y0, -1), null));
            }
            d0VarV.w();
        } catch (Throwable th) {
            d0VarV.w();
            throw th;
        }
    }

    public void f() {
        if (this.f21279f) {
            this.f21279f = false;
        } else {
            this.f21279f = true;
            a();
        }
    }

    public void g(ColorStateList colorStateList) {
        this.f21275b = colorStateList;
        this.f21277d = true;
        a();
    }

    public void h(PorterDuff.Mode mode) {
        this.f21276c = mode;
        this.f21278e = true;
        a();
    }

    public int b(int i7) {
        return i7;
    }
}
