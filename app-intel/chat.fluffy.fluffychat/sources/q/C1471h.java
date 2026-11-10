package q;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import c0.AbstractC0890b;
import k.AbstractC1244a;

/* renamed from: q.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1471h {

    /* renamed from: a, reason: collision with root package name */
    public final CheckedTextView f21268a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f21269b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f21270c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21271d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21272e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21273f;

    public C1471h(CheckedTextView checkedTextView) {
        this.f21268a = checkedTextView;
    }

    public void a() {
        Drawable drawableA = AbstractC0890b.a(this.f21268a);
        if (drawableA != null) {
            if (this.f21271d || this.f21272e) {
                Drawable drawableMutate = P.a.r(drawableA).mutate();
                if (this.f21271d) {
                    P.a.o(drawableMutate, this.f21269b);
                }
                if (this.f21272e) {
                    P.a.p(drawableMutate, this.f21270c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f21268a.getDrawableState());
                }
                this.f21268a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList b() {
        return this.f21269b;
    }

    public PorterDuff.Mode c() {
        return this.f21270c;
    }

    public void d(AttributeSet attributeSet, int i7) {
        int iN;
        int iN2;
        d0 d0VarV = d0.v(this.f21268a.getContext(), attributeSet, i.j.f17179P0, i7, 0);
        CheckedTextView checkedTextView = this.f21268a;
        Z.W.j0(checkedTextView, checkedTextView.getContext(), i.j.f17179P0, attributeSet, d0VarV.r(), i7, 0);
        try {
            if (d0VarV.s(i.j.f17189R0) && (iN2 = d0VarV.n(i.j.f17189R0, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.f21268a;
                    checkedTextView2.setCheckMarkDrawable(AbstractC1244a.b(checkedTextView2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (d0VarV.s(i.j.f17184Q0) && (iN = d0VarV.n(i.j.f17184Q0, 0)) != 0) {
                CheckedTextView checkedTextView3 = this.f21268a;
                checkedTextView3.setCheckMarkDrawable(AbstractC1244a.b(checkedTextView3.getContext(), iN));
            }
            if (d0VarV.s(i.j.f17194S0)) {
                AbstractC0890b.b(this.f21268a, d0VarV.c(i.j.f17194S0));
            }
            if (d0VarV.s(i.j.f17198T0)) {
                AbstractC0890b.c(this.f21268a, N.e(d0VarV.k(i.j.f17198T0, -1), null));
            }
            d0VarV.w();
        } catch (Throwable th) {
            d0VarV.w();
            throw th;
        }
    }

    public void e() {
        if (this.f21273f) {
            this.f21273f = false;
        } else {
            this.f21273f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.f21269b = colorStateList;
        this.f21271d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.f21270c = mode;
        this.f21272e = true;
        a();
    }
}
