package q;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import c0.AbstractC0893e;
import k.AbstractC1244a;

/* renamed from: q.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1479p {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f21328a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f21329b;

    /* renamed from: c, reason: collision with root package name */
    public b0 f21330c;

    /* renamed from: d, reason: collision with root package name */
    public b0 f21331d;

    /* renamed from: e, reason: collision with root package name */
    public int f21332e = 0;

    public C1479p(ImageView imageView) {
        this.f21328a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21331d == null) {
            this.f21331d = new b0();
        }
        b0 b0Var = this.f21331d;
        b0Var.a();
        ColorStateList colorStateListA = AbstractC0893e.a(this.f21328a);
        if (colorStateListA != null) {
            b0Var.f21239d = true;
            b0Var.f21236a = colorStateListA;
        }
        PorterDuff.Mode modeB = AbstractC0893e.b(this.f21328a);
        if (modeB != null) {
            b0Var.f21238c = true;
            b0Var.f21237b = modeB;
        }
        if (!b0Var.f21239d && !b0Var.f21238c) {
            return false;
        }
        C1473j.i(drawable, b0Var, this.f21328a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f21328a.getDrawable() != null) {
            this.f21328a.getDrawable().setLevel(this.f21332e);
        }
    }

    public void c() {
        Drawable drawable = this.f21328a.getDrawable();
        if (drawable != null) {
            N.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            b0 b0Var = this.f21330c;
            if (b0Var != null) {
                C1473j.i(drawable, b0Var, this.f21328a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.f21329b;
            if (b0Var2 != null) {
                C1473j.i(drawable, b0Var2, this.f21328a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        b0 b0Var = this.f21330c;
        if (b0Var != null) {
            return b0Var.f21236a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        b0 b0Var = this.f21330c;
        if (b0Var != null) {
            return b0Var.f21237b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f21328a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i7) {
        int iN;
        d0 d0VarV = d0.v(this.f21328a.getContext(), attributeSet, i.j.f17178P, i7, 0);
        ImageView imageView = this.f21328a;
        Z.W.j0(imageView, imageView.getContext(), i.j.f17178P, attributeSet, d0VarV.r(), i7, 0);
        try {
            Drawable drawable = this.f21328a.getDrawable();
            if (drawable == null && (iN = d0VarV.n(i.j.f17183Q, -1)) != -1 && (drawable = AbstractC1244a.b(this.f21328a.getContext(), iN)) != null) {
                this.f21328a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                N.b(drawable);
            }
            if (d0VarV.s(i.j.f17188R)) {
                AbstractC0893e.c(this.f21328a, d0VarV.c(i.j.f17188R));
            }
            if (d0VarV.s(i.j.f17193S)) {
                AbstractC0893e.d(this.f21328a, N.e(d0VarV.k(i.j.f17193S, -1), null));
            }
            d0VarV.w();
        } catch (Throwable th) {
            d0VarV.w();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.f21332e = drawable.getLevel();
    }

    public void i(int i7) {
        if (i7 != 0) {
            Drawable drawableB = AbstractC1244a.b(this.f21328a.getContext(), i7);
            if (drawableB != null) {
                N.b(drawableB);
            }
            this.f21328a.setImageDrawable(drawableB);
        } else {
            this.f21328a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f21330c == null) {
            this.f21330c = new b0();
        }
        b0 b0Var = this.f21330c;
        b0Var.f21236a = colorStateList;
        b0Var.f21239d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f21330c == null) {
            this.f21330c = new b0();
        }
        b0 b0Var = this.f21330c;
        b0Var.f21237b = mode;
        b0Var.f21238c = true;
        c();
    }

    public final boolean l() {
        return this.f21329b != null;
    }
}
