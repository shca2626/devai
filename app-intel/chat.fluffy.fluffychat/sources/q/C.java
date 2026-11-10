package q;

import X.l;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import c0.AbstractC0896h;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import k.AbstractC1244a;

/* loaded from: classes.dex */
public class C extends TextView {

    /* renamed from: l, reason: collision with root package name */
    public final C1467d f21059l;

    /* renamed from: m, reason: collision with root package name */
    public final B f21060m;

    /* renamed from: n, reason: collision with root package name */
    public final C1463A f21061n;

    /* renamed from: o, reason: collision with root package name */
    public C1476m f21062o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f21063p;

    /* renamed from: q, reason: collision with root package name */
    public a f21064q;

    /* renamed from: r, reason: collision with root package name */
    public Future f21065r;

    public interface a {
        void a(int[] iArr, int i7);

        int[] b();

        TextClassifier c();

        int d();

        void e(TextClassifier textClassifier);

        void f(int i7);

        void g(int i7, int i8, int i9, int i10);

        int h();

        int i();

        void j(int i7);

        int k();

        void l(int i7);
    }

    public class c extends b {
        public c() {
            super();
        }

        @Override // q.C.b, q.C.a
        public void f(int i7) {
            C.super.setLastBaselineToBottomHeight(i7);
        }

        @Override // q.C.b, q.C.a
        public void j(int i7) {
            C.super.setFirstBaselineToTopHeight(i7);
        }
    }

    public C(Context context) {
        this(context, null);
    }

    private C1476m getEmojiTextViewHelper() {
        if (this.f21062o == null) {
            this.f21062o = new C1476m(this);
        }
        return this.f21062o;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1467d c1467d = this.f21059l;
        if (c1467d != null) {
            c1467d.b();
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (n0.f21324b) {
            return getSuperCaller().d();
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            return b7.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (n0.f21324b) {
            return getSuperCaller().i();
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            return b7.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (n0.f21324b) {
            return getSuperCaller().k();
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            return b7.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (n0.f21324b) {
            return getSuperCaller().b();
        }
        B b7 = this.f21060m;
        return b7 != null ? b7.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (n0.f21324b) {
            return getSuperCaller().h() == 1 ? 1 : 0;
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            return b7.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0896h.p(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return AbstractC0896h.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return AbstractC0896h.c(this);
    }

    public a getSuperCaller() {
        if (this.f21064q == null) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 28) {
                this.f21064q = new c();
            } else if (i7 >= 26) {
                this.f21064q = new b();
            }
        }
        return this.f21064q;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1467d c1467d = this.f21059l;
        if (c1467d != null) {
            return c1467d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1467d c1467d = this.f21059l;
        if (c1467d != null) {
            return c1467d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21060m.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21060m.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        q();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C1463A c1463a;
        return (Build.VERSION.SDK_INT >= 28 || (c1463a = this.f21061n) == null) ? getSuperCaller().c() : c1463a.a();
    }

    public l.a getTextMetricsParamsCompat() {
        return AbstractC0896h.f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f21060m.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return AbstractC1477n.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.o(z7, i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i7, int i8) {
        q();
        super.onMeasure(i7, i8);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        B b7 = this.f21060m;
        if (b7 == null || n0.f21324b || !b7.l()) {
            return;
        }
        this.f21060m.c();
    }

    public final void q() {
        Future future = this.f21065r;
        if (future != null) {
            try {
                this.f21065r = null;
                android.support.v4.media.session.b.a(future.get());
                AbstractC0896h.m(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i7, int i8, int i9, int i10) {
        if (n0.f21324b) {
            getSuperCaller().g(i7, i8, i9, i10);
            return;
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.t(i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i7) {
        if (n0.f21324b) {
            getSuperCaller().a(iArr, i7);
            return;
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.u(iArr, i7);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i7) {
        if (n0.f21324b) {
            getSuperCaller().l(i7);
            return;
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.v(i7);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1467d c1467d = this.f21059l;
        if (c1467d != null) {
            c1467d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C1467d c1467d = this.f21059l;
        if (c1467d != null) {
            c1467d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.p();
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i7);
        } else {
            AbstractC0896h.j(this, i7);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i7);
        } else {
            AbstractC0896h.k(this, i7);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i7) {
        AbstractC0896h.l(this, i7);
    }

    public void setPrecomputedText(X.l lVar) {
        AbstractC0896h.m(this, lVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1467d c1467d = this.f21059l;
        if (c1467d != null) {
            c1467d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1467d c1467d = this.f21059l;
        if (c1467d != null) {
            c1467d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21060m.w(colorStateList);
        this.f21060m.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21060m.x(mode);
        this.f21060m.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C1463A c1463a;
        if (Build.VERSION.SDK_INT >= 28 || (c1463a = this.f21061n) == null) {
            getSuperCaller().e(textClassifier);
        } else {
            c1463a.b(textClassifier);
        }
    }

    public void setTextFuture(Future<X.l> future) {
        this.f21065r = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(l.a aVar) {
        AbstractC0896h.o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i7, float f7) {
        if (n0.f21324b) {
            super.setTextSize(i7, f7);
            return;
        }
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.A(i7, f7);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i7) {
        if (this.f21063p) {
            return;
        }
        Typeface typefaceA = (typeface == null || i7 <= 0) ? null : O.s.a(getContext(), typeface, i7);
        this.f21063p = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i7);
        } finally {
            this.f21063p = false;
        }
    }

    public C(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public C(Context context, AttributeSet attributeSet, int i7) {
        super(a0.b(context), attributeSet, i7);
        this.f21063p = false;
        this.f21064q = null;
        Z.a(this, getContext());
        C1467d c1467d = new C1467d(this);
        this.f21059l = c1467d;
        c1467d.e(attributeSet, i7);
        B b7 = new B(this);
        this.f21060m = b7;
        b7.m(attributeSet, i7);
        b7.b();
        this.f21061n = new C1463A(this);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i7 != 0 ? AbstractC1244a.b(context, i7) : null, i8 != 0 ? AbstractC1244a.b(context, i8) : null, i9 != 0 ? AbstractC1244a.b(context, i9) : null, i10 != 0 ? AbstractC1244a.b(context, i10) : null);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i7 != 0 ? AbstractC1244a.b(context, i7) : null, i8 != 0 ? AbstractC1244a.b(context, i8) : null, i9 != 0 ? AbstractC1244a.b(context, i9) : null, i10 != 0 ? AbstractC1244a.b(context, i10) : null);
        B b7 = this.f21060m;
        if (b7 != null) {
            b7.p();
        }
    }

    public class b implements a {
        public b() {
        }

        @Override // q.C.a
        public void a(int[] iArr, int i7) {
            C.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }

        @Override // q.C.a
        public int[] b() {
            return C.super.getAutoSizeTextAvailableSizes();
        }

        @Override // q.C.a
        public TextClassifier c() {
            return C.super.getTextClassifier();
        }

        @Override // q.C.a
        public int d() {
            return C.super.getAutoSizeMaxTextSize();
        }

        @Override // q.C.a
        public void e(TextClassifier textClassifier) {
            C.super.setTextClassifier(textClassifier);
        }

        @Override // q.C.a
        public void g(int i7, int i8, int i9, int i10) {
            C.super.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }

        @Override // q.C.a
        public int h() {
            return C.super.getAutoSizeTextType();
        }

        @Override // q.C.a
        public int i() {
            return C.super.getAutoSizeMinTextSize();
        }

        @Override // q.C.a
        public int k() {
            return C.super.getAutoSizeStepGranularity();
        }

        @Override // q.C.a
        public void l(int i7) {
            C.super.setAutoSizeTextTypeWithDefaults(i7);
        }

        @Override // q.C.a
        public void f(int i7) {
        }

        @Override // q.C.a
        public void j(int i7) {
        }
    }
}
