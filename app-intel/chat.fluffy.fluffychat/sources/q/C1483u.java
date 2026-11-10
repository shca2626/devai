package q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import c0.InterfaceC0898j;
import i.AbstractC1145a;
import k.AbstractC1244a;

/* renamed from: q.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1483u extends RadioButton implements InterfaceC0898j {

    /* renamed from: l, reason: collision with root package name */
    public final C1472i f21345l;

    /* renamed from: m, reason: collision with root package name */
    public final C1467d f21346m;

    /* renamed from: n, reason: collision with root package name */
    public final B f21347n;

    /* renamed from: o, reason: collision with root package name */
    public C1476m f21348o;

    public C1483u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16921D);
    }

    private C1476m getEmojiTextViewHelper() {
        if (this.f21348o == null) {
            this.f21348o = new C1476m(this);
        }
        return this.f21348o;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1467d c1467d = this.f21346m;
        if (c1467d != null) {
            c1467d.b();
        }
        B b7 = this.f21347n;
        if (b7 != null) {
            b7.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C1472i c1472i = this.f21345l;
        return c1472i != null ? c1472i.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1467d c1467d = this.f21346m;
        if (c1467d != null) {
            return c1467d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1467d c1467d = this.f21346m;
        if (c1467d != null) {
            return c1467d.d();
        }
        return null;
    }

    @Override // c0.InterfaceC0898j
    public ColorStateList getSupportButtonTintList() {
        C1472i c1472i = this.f21345l;
        if (c1472i != null) {
            return c1472i.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C1472i c1472i = this.f21345l;
        if (c1472i != null) {
            return c1472i.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21347n.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21347n.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1467d c1467d = this.f21346m;
        if (c1467d != null) {
            c1467d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C1467d c1467d = this.f21346m;
        if (c1467d != null) {
            c1467d.g(i7);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C1472i c1472i = this.f21345l;
        if (c1472i != null) {
            c1472i.f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21347n;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21347n;
        if (b7 != null) {
            b7.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1467d c1467d = this.f21346m;
        if (c1467d != null) {
            c1467d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1467d c1467d = this.f21346m;
        if (c1467d != null) {
            c1467d.j(mode);
        }
    }

    @Override // c0.InterfaceC0898j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C1472i c1472i = this.f21345l;
        if (c1472i != null) {
            c1472i.g(colorStateList);
        }
    }

    @Override // c0.InterfaceC0898j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C1472i c1472i = this.f21345l;
        if (c1472i != null) {
            c1472i.h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21347n.w(colorStateList);
        this.f21347n.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21347n.x(mode);
        this.f21347n.b();
    }

    public C1483u(Context context, AttributeSet attributeSet, int i7) {
        super(a0.b(context), attributeSet, i7);
        Z.a(this, getContext());
        C1472i c1472i = new C1472i(this);
        this.f21345l = c1472i;
        c1472i.e(attributeSet, i7);
        C1467d c1467d = new C1467d(this);
        this.f21346m = c1467d;
        c1467d.e(attributeSet, i7);
        B b7 = new B(this);
        this.f21347n = b7;
        b7.m(attributeSet, i7);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i7) {
        setButtonDrawable(AbstractC1244a.b(getContext(), i7));
    }
}
