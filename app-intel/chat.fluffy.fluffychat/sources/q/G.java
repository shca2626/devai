package q;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class G extends ToggleButton {

    /* renamed from: l, reason: collision with root package name */
    public final C1466d f21088l;

    /* renamed from: m, reason: collision with root package name */
    public final B f21089m;

    /* renamed from: n, reason: collision with root package name */
    public C1475m f21090n;

    public G(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    private C1475m getEmojiTextViewHelper() {
        if (this.f21090n == null) {
            this.f21090n = new C1475m(this);
        }
        return this.f21090n;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1466d c1466d = this.f21088l;
        if (c1466d != null) {
            c1466d.b();
        }
        B b7 = this.f21089m;
        if (b7 != null) {
            b7.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1466d c1466d = this.f21088l;
        if (c1466d != null) {
            return c1466d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1466d c1466d = this.f21088l;
        if (c1466d != null) {
            return c1466d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21089m.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21089m.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1466d c1466d = this.f21088l;
        if (c1466d != null) {
            c1466d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C1466d c1466d = this.f21088l;
        if (c1466d != null) {
            c1466d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21089m;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21089m;
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
        C1466d c1466d = this.f21088l;
        if (c1466d != null) {
            c1466d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1466d c1466d = this.f21088l;
        if (c1466d != null) {
            c1466d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21089m.w(colorStateList);
        this.f21089m.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21089m.x(mode);
        this.f21089m.b();
    }

    public G(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        Z.a(this, getContext());
        C1466d c1466d = new C1466d(this);
        this.f21088l = c1466d;
        c1466d.e(attributeSet, i7);
        B b7 = new B(this);
        this.f21089m = b7;
        b7.m(attributeSet, i7);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }
}
