package q;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: q.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1466d {

    /* renamed from: a, reason: collision with root package name */
    public final View f21251a;

    /* renamed from: d, reason: collision with root package name */
    public b0 f21254d;

    /* renamed from: e, reason: collision with root package name */
    public b0 f21255e;

    /* renamed from: f, reason: collision with root package name */
    public b0 f21256f;

    /* renamed from: c, reason: collision with root package name */
    public int f21253c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final C1472j f21252b = C1472j.b();

    public C1466d(View view) {
        this.f21251a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21256f == null) {
            this.f21256f = new b0();
        }
        b0 b0Var = this.f21256f;
        b0Var.a();
        ColorStateList colorStateListR = Z.W.r(this.f21251a);
        if (colorStateListR != null) {
            b0Var.f21245d = true;
            b0Var.f21242a = colorStateListR;
        }
        PorterDuff.Mode modeS = Z.W.s(this.f21251a);
        if (modeS != null) {
            b0Var.f21244c = true;
            b0Var.f21243b = modeS;
        }
        if (!b0Var.f21245d && !b0Var.f21244c) {
            return false;
        }
        C1472j.i(drawable, b0Var, this.f21251a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f21251a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            b0 b0Var = this.f21255e;
            if (b0Var != null) {
                C1472j.i(background, b0Var, this.f21251a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.f21254d;
            if (b0Var2 != null) {
                C1472j.i(background, b0Var2, this.f21251a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        b0 b0Var = this.f21255e;
        if (b0Var != null) {
            return b0Var.f21242a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        b0 b0Var = this.f21255e;
        if (b0Var != null) {
            return b0Var.f21243b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i7) {
        d0 d0VarV = d0.v(this.f21251a.getContext(), attributeSet, i.j.f17157K3, i7, 0);
        View view = this.f21251a;
        Z.W.j0(view, view.getContext(), i.j.f17157K3, attributeSet, d0VarV.r(), i7, 0);
        try {
            if (d0VarV.s(i.j.f17162L3)) {
                this.f21253c = d0VarV.n(i.j.f17162L3, -1);
                ColorStateList colorStateListF = this.f21252b.f(this.f21251a.getContext(), this.f21253c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (d0VarV.s(i.j.f17167M3)) {
                Z.W.q0(this.f21251a, d0VarV.c(i.j.f17167M3));
            }
            if (d0VarV.s(i.j.f17172N3)) {
                Z.W.r0(this.f21251a, N.e(d0VarV.k(i.j.f17172N3, -1), null));
            }
            d0VarV.w();
        } catch (Throwable th) {
            d0VarV.w();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f21253c = -1;
        h(null);
        b();
    }

    public void g(int i7) {
        this.f21253c = i7;
        C1472j c1472j = this.f21252b;
        h(c1472j != null ? c1472j.f(this.f21251a.getContext(), i7) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f21254d == null) {
                this.f21254d = new b0();
            }
            b0 b0Var = this.f21254d;
            b0Var.f21242a = colorStateList;
            b0Var.f21245d = true;
        } else {
            this.f21254d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f21255e == null) {
            this.f21255e = new b0();
        }
        b0 b0Var = this.f21255e;
        b0Var.f21242a = colorStateList;
        b0Var.f21245d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f21255e == null) {
            this.f21255e = new b0();
        }
        b0 b0Var = this.f21255e;
        b0Var.f21243b = mode;
        b0Var.f21244c = true;
        b();
    }

    public final boolean k() {
        return this.f21254d != null;
    }
}
