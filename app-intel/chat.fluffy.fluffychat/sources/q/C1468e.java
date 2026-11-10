package q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import c0.AbstractC0896h;
import i.AbstractC1145a;

/* renamed from: q.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1468e extends Button {

    /* renamed from: l, reason: collision with root package name */
    public final C1467d f21254l;

    /* renamed from: m, reason: collision with root package name */
    public final B f21255m;

    /* renamed from: n, reason: collision with root package name */
    public C1476m f21256n;

    public C1468e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16943n);
    }

    private C1476m getEmojiTextViewHelper() {
        if (this.f21256n == null) {
            this.f21256n = new C1476m(this);
        }
        return this.f21256n;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1467d c1467d = this.f21254l;
        if (c1467d != null) {
            c1467d.b();
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (n0.f21324b) {
            return super.getAutoSizeMaxTextSize();
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            return b7.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (n0.f21324b) {
            return super.getAutoSizeMinTextSize();
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            return b7.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (n0.f21324b) {
            return super.getAutoSizeStepGranularity();
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            return b7.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (n0.f21324b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        B b7 = this.f21255m;
        return b7 != null ? b7.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (n0.f21324b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            return b7.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0896h.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1467d c1467d = this.f21254l;
        if (c1467d != null) {
            return c1467d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1467d c1467d = this.f21254l;
        if (c1467d != null) {
            return c1467d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21255m.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21255m.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.o(z7, i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        B b7 = this.f21255m;
        if (b7 == null || n0.f21324b || !b7.l()) {
            return;
        }
        this.f21255m.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i7, int i8, int i9, int i10) {
        if (n0.f21324b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
            return;
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.t(i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i7) {
        if (n0.f21324b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
            return;
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.u(iArr, i7);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i7) {
        if (n0.f21324b) {
            super.setAutoSizeTextTypeWithDefaults(i7);
            return;
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.v(i7);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1467d c1467d = this.f21254l;
        if (c1467d != null) {
            c1467d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C1467d c1467d = this.f21254l;
        if (c1467d != null) {
            c1467d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0896h.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z7) {
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.s(z7);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1467d c1467d = this.f21254l;
        if (c1467d != null) {
            c1467d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1467d c1467d = this.f21254l;
        if (c1467d != null) {
            c1467d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21255m.w(colorStateList);
        this.f21255m.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21255m.x(mode);
        this.f21255m.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i7, float f7) {
        if (n0.f21324b) {
            super.setTextSize(i7, f7);
            return;
        }
        B b7 = this.f21255m;
        if (b7 != null) {
            b7.A(i7, f7);
        }
    }

    public C1468e(Context context, AttributeSet attributeSet, int i7) {
        super(a0.b(context), attributeSet, i7);
        Z.a(this, getContext());
        C1467d c1467d = new C1467d(this);
        this.f21254l = c1467d;
        c1467d.e(attributeSet, i7);
        B b7 = new B(this);
        this.f21255m = b7;
        b7.m(attributeSet, i7);
        b7.b();
        getEmojiTextViewHelper().c(attributeSet, i7);
    }
}
