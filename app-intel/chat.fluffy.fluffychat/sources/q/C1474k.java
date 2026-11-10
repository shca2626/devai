package q;

import Z.C0688d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import b0.C0819c;
import b0.C0821e;
import c0.AbstractC0896h;
import c0.C0897i;
import i.AbstractC1145a;

/* renamed from: q.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1474k extends EditText implements Z.K {

    /* renamed from: l, reason: collision with root package name */
    public final C1467d f21291l;

    /* renamed from: m, reason: collision with root package name */
    public final B f21292m;

    /* renamed from: n, reason: collision with root package name */
    public final C1463A f21293n;

    /* renamed from: o, reason: collision with root package name */
    public final C0897i f21294o;

    /* renamed from: p, reason: collision with root package name */
    public final C1475l f21295p;

    /* renamed from: q, reason: collision with root package name */
    public a f21296q;

    /* renamed from: q.k$a */
    public class a {
        public a() {
        }

        public TextClassifier a() {
            return C1474k.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            C1474k.super.setTextClassifier(textClassifier);
        }
    }

    public C1474k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16954y);
    }

    private a getSuperCaller() {
        if (this.f21296q == null) {
            this.f21296q = new a();
        }
        return this.f21296q;
    }

    @Override // Z.K
    public C0688d a(C0688d c0688d) {
        return this.f21294o.a(this, c0688d);
    }

    public void d(C1475l c1475l) {
        KeyListener keyListener = getKeyListener();
        if (c1475l.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c1475l.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1467d c1467d = this.f21291l;
        if (c1467d != null) {
            c1467d.b();
        }
        B b7 = this.f21292m;
        if (b7 != null) {
            b7.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0896h.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1467d c1467d = this.f21291l;
        if (c1467d != null) {
            return c1467d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1467d c1467d = this.f21291l;
        if (c1467d != null) {
            return c1467d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21292m.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21292m.k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C1463A c1463a;
        return (Build.VERSION.SDK_INT >= 28 || (c1463a = this.f21293n) == null) ? getSuperCaller().a() : c1463a.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrD;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f21292m.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = AbstractC1477n.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrD = Z.W.D(this)) != null) {
            C0819c.d(editorInfo, strArrD);
            inputConnectionA = C0821e.c(this, inputConnectionA, editorInfo);
        }
        return this.f21295p.d(inputConnectionA, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AbstractC1485w.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i7) {
        if (AbstractC1485w.b(this, i7)) {
            return true;
        }
        return super.onTextContextMenuItem(i7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1467d c1467d = this.f21291l;
        if (c1467d != null) {
            c1467d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C1467d c1467d = this.f21291l;
        if (c1467d != null) {
            c1467d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21292m;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        B b7 = this.f21292m;
        if (b7 != null) {
            b7.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0896h.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        this.f21295p.e(z7);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f21295p.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1467d c1467d = this.f21291l;
        if (c1467d != null) {
            c1467d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1467d c1467d = this.f21291l;
        if (c1467d != null) {
            c1467d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21292m.w(colorStateList);
        this.f21292m.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21292m.x(mode);
        this.f21292m.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        B b7 = this.f21292m;
        if (b7 != null) {
            b7.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C1463A c1463a;
        if (Build.VERSION.SDK_INT >= 28 || (c1463a = this.f21293n) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            c1463a.b(textClassifier);
        }
    }

    public C1474k(Context context, AttributeSet attributeSet, int i7) {
        super(a0.b(context), attributeSet, i7);
        Z.a(this, getContext());
        C1467d c1467d = new C1467d(this);
        this.f21291l = c1467d;
        c1467d.e(attributeSet, i7);
        B b7 = new B(this);
        this.f21292m = b7;
        b7.m(attributeSet, i7);
        b7.b();
        this.f21293n = new C1463A(this);
        this.f21294o = new C0897i();
        C1475l c1475l = new C1475l(this);
        this.f21295p = c1475l;
        c1475l.c(attributeSet, i7);
        d(c1475l);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
