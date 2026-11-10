package q;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: q.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1467d {

    /* renamed from: a, reason: collision with root package name */
    public final View f21245a;

    /* renamed from: d, reason: collision with root package name */
    public b0 f21248d;

    /* renamed from: e, reason: collision with root package name */
    public b0 f21249e;

    /* renamed from: f, reason: collision with root package name */
    public b0 f21250f;

    /* renamed from: c, reason: collision with root package name */
    public int f21247c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final C1473j f21246b = C1473j.b();

    public C1467d(View view) {
        this.f21245a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21250f == null) {
            this.f21250f = new b0();
        }
        b0 b0Var = this.f21250f;
        b0Var.a();
        ColorStateList colorStateListR = Z.W.r(this.f21245a);
        if (colorStateListR != null) {
            b0Var.f21239d = true;
            b0Var.f21236a = colorStateListR;
        }
        PorterDuff.Mode modeS = Z.W.s(this.f21245a);
        if (modeS != null) {
            b0Var.f21238c = true;
            b0Var.f21237b = modeS;
        }
        if (!b0Var.f21239d && !b0Var.f21238c) {
            return false;
        }
        C1473j.i(drawable, b0Var, this.f21245a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f21245a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            b0 b0Var = this.f21249e;
            if (b0Var != null) {
                C1473j.i(background, b0Var, this.f21245a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.f21248d;
            if (b0Var2 != null) {
                C1473j.i(background, b0Var2, this.f21245a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        b0 b0Var = this.f21249e;
        if (b0Var != null) {
            return b0Var.f21236a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        b0 b0Var = this.f21249e;
        if (b0Var != null) {
            return b0Var.f21237b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i7) {
        d0 d0VarV = d0.v(this.f21245a.getContext(), attributeSet, i.j.f17157K3, i7, 0);
        View view = this.f21245a;
        Z.W.j0(view, view.getContext(), i.j.f17157K3, attributeSet, d0VarV.r(), i7, 0);
        try {
            if (d0VarV.s(i.j.f17162L3)) {
                this.f21247c = d0VarV.n(i.j.f17162L3, -1);
                ColorStateList colorStateListF = this.f21246b.f(this.f21245a.getContext(), this.f21247c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (d0VarV.s(i.j.f17167M3)) {
                Z.W.q0(this.f21245a, d0VarV.c(i.j.f17167M3));
            }
            if (d0VarV.s(i.j.f17172N3)) {
                Z.W.r0(this.f21245a, N.e(d0VarV.k(i.j.f17172N3, -1), null));
            }
            d0VarV.w();
        } catch (Throwable th) {
            d0VarV.w();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f21247c = -1;
        h(null);
        b();
    }

    public void g(int i7) {
        this.f21247c = i7;
        C1473j c1473j = this.f21246b;
        h(c1473j != null ? c1473j.f(this.f21245a.getContext(), i7) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f21248d == null) {
                this.f21248d = new b0();
            }
            b0 b0Var = this.f21248d;
            b0Var.f21236a = colorStateList;
            b0Var.f21239d = true;
        } else {
            this.f21248d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f21249e == null) {
            this.f21249e = new b0();
        }
        b0 b0Var = this.f21249e;
        b0Var.f21236a = colorStateList;
        b0Var.f21239d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f21249e == null) {
            this.f21249e = new b0();
        }
        b0 b0Var = this.f21249e;
        b0Var.f21237b = mode;
        b0Var.f21238c = true;
        b();
    }

    public final boolean k() {
        return this.f21248d != null;
    }
}
