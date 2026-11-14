package q;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import c0.AbstractC0894e;
import k.AbstractC1243a;

/* renamed from: q.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1478p {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f21334a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f21335b;

    /* renamed from: c, reason: collision with root package name */
    public b0 f21336c;

    /* renamed from: d, reason: collision with root package name */
    public b0 f21337d;

    /* renamed from: e, reason: collision with root package name */
    public int f21338e = 0;

    public C1478p(ImageView imageView) {
        this.f21334a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21337d == null) {
            this.f21337d = new b0();
        }
        b0 b0Var = this.f21337d;
        b0Var.a();
        ColorStateList colorStateListA = AbstractC0894e.a(this.f21334a);
        if (colorStateListA != null) {
            b0Var.f21245d = true;
            b0Var.f21242a = colorStateListA;
        }
        PorterDuff.Mode modeB = AbstractC0894e.b(this.f21334a);
        if (modeB != null) {
            b0Var.f21244c = true;
            b0Var.f21243b = modeB;
        }
        if (!b0Var.f21245d && !b0Var.f21244c) {
            return false;
        }
        C1472j.i(drawable, b0Var, this.f21334a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f21334a.getDrawable() != null) {
            this.f21334a.getDrawable().setLevel(this.f21338e);
        }
    }

    public void c() {
        Drawable drawable = this.f21334a.getDrawable();
        if (drawable != null) {
            N.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            b0 b0Var = this.f21336c;
            if (b0Var != null) {
                C1472j.i(drawable, b0Var, this.f21334a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.f21335b;
            if (b0Var2 != null) {
                C1472j.i(drawable, b0Var2, this.f21334a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        b0 b0Var = this.f21336c;
        if (b0Var != null) {
            return b0Var.f21242a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        b0 b0Var = this.f21336c;
        if (b0Var != null) {
            return b0Var.f21243b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f21334a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i7) {
        int iN;
        d0 d0VarV = d0.v(this.f21334a.getContext(), attributeSet, i.j.f17178P, i7, 0);
        ImageView imageView = this.f21334a;
        Z.W.j0(imageView, imageView.getContext(), i.j.f17178P, attributeSet, d0VarV.r(), i7, 0);
        try {
            Drawable drawable = this.f21334a.getDrawable();
            if (drawable == null && (iN = d0VarV.n(i.j.f17183Q, -1)) != -1 && (drawable = AbstractC1243a.b(this.f21334a.getContext(), iN)) != null) {
                this.f21334a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                N.b(drawable);
            }
            if (d0VarV.s(i.j.f17188R)) {
                AbstractC0894e.c(this.f21334a, d0VarV.c(i.j.f17188R));
            }
            if (d0VarV.s(i.j.f17193S)) {
                AbstractC0894e.d(this.f21334a, N.e(d0VarV.k(i.j.f17193S, -1), null));
            }
            d0VarV.w();
        } catch (Throwable th) {
            d0VarV.w();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.f21338e = drawable.getLevel();
    }

    public void i(int i7) {
        if (i7 != 0) {
            Drawable drawableB = AbstractC1243a.b(this.f21334a.getContext(), i7);
            if (drawableB != null) {
                N.b(drawableB);
            }
            this.f21334a.setImageDrawable(drawableB);
        } else {
            this.f21334a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f21336c == null) {
            this.f21336c = new b0();
        }
        b0 b0Var = this.f21336c;
        b0Var.f21242a = colorStateList;
        b0Var.f21245d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f21336c == null) {
            this.f21336c = new b0();
        }
        b0 b0Var = this.f21336c;
        b0Var.f21243b = mode;
        b0Var.f21244c = true;
        c();
    }

    public final boolean l() {
        return this.f21335b != null;
    }
}
