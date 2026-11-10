package androidx.appcompat.widget;

import Z.W;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.c;
import c0.AbstractC0896h;
import i.AbstractC1145a;
import i.h;
import i.j;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import k.AbstractC1244a;
import n.C1334a;
import q.B;
import q.C1476m;
import q.N;
import q.Z;
import q.d0;
import q.n0;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: g0, reason: collision with root package name */
    public static final Property f11438g0 = new a(Float.class, "thumbPos");

    /* renamed from: h0, reason: collision with root package name */
    public static final int[] f11439h0 = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f11440A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f11441B;

    /* renamed from: C, reason: collision with root package name */
    public CharSequence f11442C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f11443D;

    /* renamed from: E, reason: collision with root package name */
    public int f11444E;

    /* renamed from: F, reason: collision with root package name */
    public int f11445F;

    /* renamed from: G, reason: collision with root package name */
    public float f11446G;

    /* renamed from: H, reason: collision with root package name */
    public float f11447H;

    /* renamed from: I, reason: collision with root package name */
    public VelocityTracker f11448I;

    /* renamed from: J, reason: collision with root package name */
    public int f11449J;

    /* renamed from: K, reason: collision with root package name */
    public float f11450K;

    /* renamed from: L, reason: collision with root package name */
    public int f11451L;

    /* renamed from: M, reason: collision with root package name */
    public int f11452M;

    /* renamed from: N, reason: collision with root package name */
    public int f11453N;

    /* renamed from: O, reason: collision with root package name */
    public int f11454O;

    /* renamed from: P, reason: collision with root package name */
    public int f11455P;

    /* renamed from: Q, reason: collision with root package name */
    public int f11456Q;

    /* renamed from: R, reason: collision with root package name */
    public int f11457R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f11458S;

    /* renamed from: T, reason: collision with root package name */
    public final TextPaint f11459T;

    /* renamed from: U, reason: collision with root package name */
    public ColorStateList f11460U;

    /* renamed from: V, reason: collision with root package name */
    public Layout f11461V;

    /* renamed from: W, reason: collision with root package name */
    public Layout f11462W;

    /* renamed from: a0, reason: collision with root package name */
    public TransformationMethod f11463a0;

    /* renamed from: b0, reason: collision with root package name */
    public ObjectAnimator f11464b0;

    /* renamed from: c0, reason: collision with root package name */
    public final B f11465c0;

    /* renamed from: d0, reason: collision with root package name */
    public C1476m f11466d0;

    /* renamed from: e0, reason: collision with root package name */
    public c f11467e0;

    /* renamed from: f0, reason: collision with root package name */
    public final Rect f11468f0;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f11469l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f11470m;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuff.Mode f11471n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11472o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11473p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f11474q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f11475r;

    /* renamed from: s, reason: collision with root package name */
    public PorterDuff.Mode f11476s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f11477t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11478u;

    /* renamed from: v, reason: collision with root package name */
    public int f11479v;

    /* renamed from: w, reason: collision with root package name */
    public int f11480w;

    /* renamed from: x, reason: collision with root package name */
    public int f11481x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f11482y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f11483z;

    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f11450K);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f7) {
            switchCompat.setThumbPosition(f7.floatValue());
        }
    }

    public static class b {
        public static void a(ObjectAnimator objectAnimator, boolean z7) {
            objectAnimator.setAutoCancel(z7);
        }
    }

    public static class c extends c.e {

        /* renamed from: a, reason: collision with root package name */
        public final Reference f11484a;

        public c(SwitchCompat switchCompat) {
            this.f11484a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.c.e
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f11484a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f11484a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16926I);
    }

    public static float f(float f7, float f8, float f9) {
        return f7 < f8 ? f8 : f7 > f9 ? f9 : f7;
    }

    private C1476m getEmojiTextViewHelper() {
        if (this.f11466d0 == null) {
            this.f11466d0 = new C1476m(this);
        }
        return this.f11466d0;
    }

    private boolean getTargetCheckedState() {
        return this.f11450K > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((n0.b(this) ? 1.0f - this.f11450K : this.f11450K) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f11474q;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f11468f0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f11469l;
        Rect rectD = drawable2 != null ? N.d(drawable2) : N.f21087c;
        return ((((this.f11451L - this.f11453N) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f11441B = charSequence;
        this.f11442C = g(charSequence);
        this.f11462W = null;
        if (this.f11443D) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f11483z = charSequence;
        this.f11440A = g(charSequence);
        this.f11461V = null;
        if (this.f11443D) {
            p();
        }
    }

    public final void a(boolean z7) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) f11438g0, z7 ? 1.0f : 0.0f);
        this.f11464b0 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        b.a(this.f11464b0, true);
        this.f11464b0.start();
    }

    public final void b() {
        Drawable drawable = this.f11469l;
        if (drawable != null) {
            if (this.f11472o || this.f11473p) {
                Drawable drawableMutate = P.a.r(drawable).mutate();
                this.f11469l = drawableMutate;
                if (this.f11472o) {
                    P.a.o(drawableMutate, this.f11470m);
                }
                if (this.f11473p) {
                    P.a.p(this.f11469l, this.f11471n);
                }
                if (this.f11469l.isStateful()) {
                    this.f11469l.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.f11474q;
        if (drawable != null) {
            if (this.f11477t || this.f11478u) {
                Drawable drawableMutate = P.a.r(drawable).mutate();
                this.f11474q = drawableMutate;
                if (this.f11477t) {
                    P.a.o(drawableMutate, this.f11475r);
                }
                if (this.f11478u) {
                    P.a.p(this.f11474q, this.f11476s);
                }
                if (this.f11474q.isStateful()) {
                    this.f11474q.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.f11464b0;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i7;
        int i8;
        Rect rect = this.f11468f0;
        int i9 = this.f11454O;
        int i10 = this.f11455P;
        int i11 = this.f11456Q;
        int i12 = this.f11457R;
        int thumbOffset = getThumbOffset() + i9;
        Drawable drawable = this.f11469l;
        Rect rectD = drawable != null ? N.d(drawable) : N.f21087c;
        Drawable drawable2 = this.f11474q;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i13 = rect.left;
            thumbOffset += i13;
            if (rectD != null) {
                int i14 = rectD.left;
                if (i14 > i13) {
                    i9 += i14 - i13;
                }
                int i15 = rectD.top;
                int i16 = rect.top;
                i7 = i15 > i16 ? (i15 - i16) + i10 : i10;
                int i17 = rectD.right;
                int i18 = rect.right;
                if (i17 > i18) {
                    i11 -= i17 - i18;
                }
                int i19 = rectD.bottom;
                int i20 = rect.bottom;
                if (i19 > i20) {
                    i8 = i12 - (i19 - i20);
                }
                this.f11474q.setBounds(i9, i7, i11, i8);
            } else {
                i7 = i10;
            }
            i8 = i12;
            this.f11474q.setBounds(i9, i7, i11, i8);
        }
        Drawable drawable3 = this.f11469l;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i21 = thumbOffset - rect.left;
            int i22 = thumbOffset + this.f11453N + rect.right;
            this.f11469l.setBounds(i21, i10, i22, i12);
            Drawable background = getBackground();
            if (background != null) {
                P.a.l(background, i21, i10, i22, i12);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f7, float f8) {
        super.drawableHotspotChanged(f7, f8);
        Drawable drawable = this.f11469l;
        if (drawable != null) {
            P.a.k(drawable, f7, f8);
        }
        Drawable drawable2 = this.f11474q;
        if (drawable2 != null) {
            P.a.k(drawable2, f7, f8);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f11469l;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f11474q;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final CharSequence g(CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.f11463a0);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!n0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f11451L;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f11481x : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (n0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f11451L;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f11481x : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0896h.p(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f11443D;
    }

    public boolean getSplitTrack() {
        return this.f11482y;
    }

    public int getSwitchMinWidth() {
        return this.f11480w;
    }

    public int getSwitchPadding() {
        return this.f11481x;
    }

    public CharSequence getTextOff() {
        return this.f11441B;
    }

    public CharSequence getTextOn() {
        return this.f11483z;
    }

    public Drawable getThumbDrawable() {
        return this.f11469l;
    }

    public final float getThumbPosition() {
        return this.f11450K;
    }

    public int getThumbTextPadding() {
        return this.f11479v;
    }

    public ColorStateList getThumbTintList() {
        return this.f11470m;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f11471n;
    }

    public Drawable getTrackDrawable() {
        return this.f11474q;
    }

    public ColorStateList getTrackTintList() {
        return this.f11475r;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f11476s;
    }

    public final boolean h(float f7, float f8) {
        if (this.f11469l == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f11469l.getPadding(this.f11468f0);
        int i7 = this.f11455P;
        int i8 = this.f11445F;
        int i9 = i7 - i8;
        int i10 = (this.f11454O + thumbOffset) - i8;
        int i11 = this.f11453N + i10;
        Rect rect = this.f11468f0;
        return f7 > ((float) i10) && f7 < ((float) (((i11 + rect.left) + rect.right) + i8)) && f8 > ((float) i9) && f8 < ((float) (this.f11457R + i8));
    }

    public final Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f11459T, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void j() {
        setTextOnInternal(this.f11483z);
        setTextOffInternal(this.f11441B);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f11469l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f11474q;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f11464b0;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f11464b0.end();
        this.f11464b0 = null;
    }

    public final void k() throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f11441B;
            if (string == null) {
                string = getResources().getString(h.f17086b);
            }
            W.D0(this, string);
        }
    }

    public final void l() throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f11483z;
            if (string == null) {
                string = getResources().getString(h.f17087c);
            }
            W.D0(this, string);
        }
    }

    public void m(Context context, int i7) {
        d0 d0VarT = d0.t(context, i7, j.f17196S2);
        ColorStateList colorStateListC = d0VarT.c(j.f17212W2);
        if (colorStateListC != null) {
            this.f11460U = colorStateListC;
        } else {
            this.f11460U = getTextColors();
        }
        int iF = d0VarT.f(j.f17200T2, 0);
        if (iF != 0) {
            float f7 = iF;
            if (f7 != this.f11459T.getTextSize()) {
                this.f11459T.setTextSize(f7);
                requestLayout();
            }
        }
        o(d0VarT.k(j.f17204U2, -1), d0VarT.k(j.f17208V2, -1));
        if (d0VarT.a(j.f17234b3, false)) {
            this.f11463a0 = new C1334a(getContext());
        } else {
            this.f11463a0 = null;
        }
        setTextOnInternal(this.f11483z);
        setTextOffInternal(this.f11441B);
        d0VarT.w();
    }

    public void n(Typeface typeface, int i7) {
        if (i7 <= 0) {
            this.f11459T.setFakeBoldText(false);
            this.f11459T.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i7) : Typeface.create(typeface, i7);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i8 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i7;
            this.f11459T.setFakeBoldText((i8 & 1) != 0);
            this.f11459T.setTextSkewX((i8 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final void o(int i7, int i8) {
        n(i7 != 1 ? i7 != 2 ? i7 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i8);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f11439h0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f11468f0;
        Drawable drawable = this.f11474q;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i7 = this.f11455P;
        int i8 = this.f11457R;
        int i9 = i7 + rect.top;
        int i10 = i8 - rect.bottom;
        Drawable drawable2 = this.f11469l;
        if (drawable != null) {
            if (!this.f11482y || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = N.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f11461V : this.f11462W;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f11460U;
            if (colorStateList != null) {
                this.f11459T.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f11459T.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i9 + i10) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f11483z : this.f11441B;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int iMax;
        int width;
        int paddingLeft;
        int i11;
        int paddingTop;
        int height;
        super.onLayout(z7, i7, i8, i9, i10);
        int iMax2 = 0;
        if (this.f11469l != null) {
            Rect rect = this.f11468f0;
            Drawable drawable = this.f11474q;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = N.d(this.f11469l);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (n0.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f11451L + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f11451L) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i11 = this.f11452M;
            paddingTop = paddingTop2 - (i11 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f11452M;
                this.f11454O = paddingLeft;
                this.f11455P = paddingTop;
                this.f11457R = height;
                this.f11456Q = width;
            }
            paddingTop = getPaddingTop();
            i11 = this.f11452M;
        }
        height = i11 + paddingTop;
        this.f11454O = paddingLeft;
        this.f11455P = paddingTop;
        this.f11457R = height;
        this.f11456Q = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i7, int i8) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f11443D) {
            if (this.f11461V == null) {
                this.f11461V = i(this.f11440A);
            }
            if (this.f11462W == null) {
                this.f11462W = i(this.f11442C);
            }
        }
        Rect rect = this.f11468f0;
        Drawable drawable = this.f11469l;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f11469l.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f11469l.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f11453N = Math.max(this.f11443D ? Math.max(this.f11461V.getWidth(), this.f11462W.getWidth()) + (this.f11479v * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f11474q;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f11474q.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f11469l;
        if (drawable3 != null) {
            Rect rectD = N.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = this.f11458S ? Math.max(this.f11480w, (this.f11453N * 2) + iMax + iMax2) : this.f11480w;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f11451L = iMax3;
        this.f11452M = iMax4;
        super.onMeasure(i7, i8);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f11483z : this.f11441B;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f11448I
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f11444E
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f11446G
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = q.n0.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f11450K
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f11450K
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f11446G = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f11446G
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f11445F
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f11447H
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f11445F
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f11444E = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f11446G = r0
            r6.f11447H = r3
            return r1
        L89:
            int r0 = r6.f11444E
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f11444E = r0
            android.view.VelocityTracker r0 = r6.f11448I
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f11444E = r1
            r6.f11446G = r0
            r6.f11447H = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (this.f11467e0 == null && this.f11466d0.b() && androidx.emoji2.text.c.h()) {
            androidx.emoji2.text.c cVarB = androidx.emoji2.text.c.b();
            int iD = cVarB.d();
            if (iD == 3 || iD == 0) {
                c cVar = new c(this);
                this.f11467e0 = cVar;
                cVarB.s(cVar);
            }
        }
    }

    public final void q(MotionEvent motionEvent) throws Resources.NotFoundException {
        this.f11444E = 0;
        boolean targetCheckedState = true;
        boolean z7 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z7) {
            this.f11448I.computeCurrentVelocity(1000);
            float xVelocity = this.f11448I.getXVelocity();
            if (Math.abs(xVelocity) <= this.f11449J) {
                targetCheckedState = getTargetCheckedState();
            } else if (!n0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z7) throws Resources.NotFoundException {
        super.setChecked(z7);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && W.Q(this)) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0896h.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
        setTextOnInternal(this.f11483z);
        setTextOffInternal(this.f11441B);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z7) {
        this.f11458S = z7;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z7) {
        if (this.f11443D != z7) {
            this.f11443D = z7;
            requestLayout();
            if (z7) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z7) {
        this.f11482y = z7;
        invalidate();
    }

    public void setSwitchMinWidth(int i7) {
        this.f11480w = i7;
        requestLayout();
    }

    public void setSwitchPadding(int i7) {
        this.f11481x = i7;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f11459T.getTypeface() == null || this.f11459T.getTypeface().equals(typeface)) && (this.f11459T.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f11459T.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f11469l;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f11469l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f7) {
        this.f11450K = f7;
        invalidate();
    }

    public void setThumbResource(int i7) {
        setThumbDrawable(AbstractC1244a.b(getContext(), i7));
    }

    public void setThumbTextPadding(int i7) {
        this.f11479v = i7;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f11470m = colorStateList;
        this.f11472o = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f11471n = mode;
        this.f11473p = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f11474q;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f11474q = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i7) {
        setTrackDrawable(AbstractC1244a.b(getContext(), i7));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f11475r = colorStateList;
        this.f11477t = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f11476s = mode;
        this.f11478u = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11469l || drawable == this.f11474q;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i7) throws Resources.NotFoundException {
        super(context, attributeSet, i7);
        this.f11470m = null;
        this.f11471n = null;
        this.f11472o = false;
        this.f11473p = false;
        this.f11475r = null;
        this.f11476s = null;
        this.f11477t = false;
        this.f11478u = false;
        this.f11448I = VelocityTracker.obtain();
        this.f11458S = true;
        this.f11468f0 = new Rect();
        Z.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f11459T = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        d0 d0VarV = d0.v(context, attributeSet, j.f17121D2, i7, 0);
        W.j0(this, context, j.f17121D2, attributeSet, d0VarV.r(), i7, 0);
        Drawable drawableG = d0VarV.g(j.f17136G2);
        this.f11469l = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = d0VarV.g(j.f17181P2);
        this.f11474q = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        setTextOnInternal(d0VarV.p(j.f17126E2));
        setTextOffInternal(d0VarV.p(j.f17131F2));
        this.f11443D = d0VarV.a(j.f17141H2, true);
        this.f11479v = d0VarV.f(j.f17166M2, 0);
        this.f11480w = d0VarV.f(j.f17151J2, 0);
        this.f11481x = d0VarV.f(j.f17156K2, 0);
        this.f11482y = d0VarV.a(j.f17146I2, false);
        ColorStateList colorStateListC = d0VarV.c(j.f17171N2);
        if (colorStateListC != null) {
            this.f11470m = colorStateListC;
            this.f11472o = true;
        }
        PorterDuff.Mode modeE = N.e(d0VarV.k(j.f17176O2, -1), null);
        if (this.f11471n != modeE) {
            this.f11471n = modeE;
            this.f11473p = true;
        }
        if (this.f11472o || this.f11473p) {
            b();
        }
        ColorStateList colorStateListC2 = d0VarV.c(j.f17186Q2);
        if (colorStateListC2 != null) {
            this.f11475r = colorStateListC2;
            this.f11477t = true;
        }
        PorterDuff.Mode modeE2 = N.e(d0VarV.k(j.f17191R2, -1), null);
        if (this.f11476s != modeE2) {
            this.f11476s = modeE2;
            this.f11478u = true;
        }
        if (this.f11477t || this.f11478u) {
            c();
        }
        int iN = d0VarV.n(j.f17161L2, 0);
        if (iN != 0) {
            m(context, iN);
        }
        B b7 = new B(this);
        this.f11465c0 = b7;
        b7.m(attributeSet, i7);
        d0VarV.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11445F = viewConfiguration.getScaledTouchSlop();
        this.f11449J = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i7);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
