package com.google.android.material.snackbar;

import O2.j;
import Z.W;
import a3.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c3.AbstractC0904c;
import com.google.android.material.behavior.SwipeDismissBehavior;
import f3.g;
import f3.k;
import i3.AbstractC1153a;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f14602b = false;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f14603c = {O2.a.f6732B};

    /* renamed from: d, reason: collision with root package name */
    public static final String f14604d = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f14601a = new Handler(Looper.getMainLooper(), new a());

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: j, reason: collision with root package name */
        public final b f14605j = new b(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.f14605j.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f14605j.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            }
            if (i7 != 1) {
                return false;
            }
            android.support.v4.media.session.b.a(message.obj);
            throw null;
        }
    }

    public static class b {
        public b(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.K(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.L(0);
        }

        public boolean a(View view) {
            return view instanceof c;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.b().e(null);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.b().f(null);
            }
        }
    }

    public static class c extends FrameLayout {

        /* renamed from: v, reason: collision with root package name */
        public static final View.OnTouchListener f14606v = new a();

        /* renamed from: l, reason: collision with root package name */
        public k f14607l;

        /* renamed from: m, reason: collision with root package name */
        public int f14608m;

        /* renamed from: n, reason: collision with root package name */
        public final float f14609n;

        /* renamed from: o, reason: collision with root package name */
        public final float f14610o;

        /* renamed from: p, reason: collision with root package name */
        public final int f14611p;

        /* renamed from: q, reason: collision with root package name */
        public final int f14612q;

        /* renamed from: r, reason: collision with root package name */
        public ColorStateList f14613r;

        /* renamed from: s, reason: collision with root package name */
        public PorterDuff.Mode f14614s;

        /* renamed from: t, reason: collision with root package name */
        public Rect f14615t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f14616u;

        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public c(Context context, AttributeSet attributeSet) {
            super(AbstractC1153a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, j.f7165i4);
            if (typedArrayObtainStyledAttributes.hasValue(j.f7221p4)) {
                W.t0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f7221p4, 0));
            }
            this.f14608m = typedArrayObtainStyledAttributes.getInt(j.f7189l4, 0);
            if (typedArrayObtainStyledAttributes.hasValue(j.f7237r4) || typedArrayObtainStyledAttributes.hasValue(j.f7245s4)) {
                this.f14607l = k.e(context2, attributeSet, 0, 0).m();
            }
            this.f14609n = typedArrayObtainStyledAttributes.getFloat(j.f7197m4, 1.0f);
            setBackgroundTintList(AbstractC0904c.a(context2, typedArrayObtainStyledAttributes, j.f7205n4));
            setBackgroundTintMode(l.f(typedArrayObtainStyledAttributes.getInt(j.f7213o4, -1), PorterDuff.Mode.SRC_IN));
            this.f14610o = typedArrayObtainStyledAttributes.getFloat(j.f7181k4, 1.0f);
            this.f14611p = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f7173j4, -1);
            this.f14612q = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f7229q4, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f14606v);
            setFocusable(true);
            if (getBackground() == null) {
                W.p0(this, a());
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
        }

        public final Drawable a() {
            int i7 = V2.b.i(this, O2.a.f6748k, O2.a.f6745h, getBackgroundOverlayColorAlpha());
            k kVar = this.f14607l;
            Drawable drawableD = kVar != null ? BaseTransientBottomBar.d(i7, kVar) : BaseTransientBottomBar.c(i7, getResources());
            if (this.f14613r == null) {
                return P.a.r(drawableD);
            }
            Drawable drawableR = P.a.r(drawableD);
            P.a.o(drawableR, this.f14613r);
            return drawableR;
        }

        public final void b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f14615t = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.f14610o;
        }

        public int getAnimationMode() {
            return this.f14608m;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f14609n;
        }

        public int getMaxInlineActionWidth() {
            return this.f14612q;
        }

        public int getMaxWidth() {
            return this.f14611p;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            W.i0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
            super.onLayout(z7, i7, i8, i9, i10);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i7, int i8) {
            super.onMeasure(i7, i8);
            if (this.f14611p > 0) {
                int measuredWidth = getMeasuredWidth();
                int i9 = this.f14611p;
                if (measuredWidth > i9) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), i8);
                }
            }
        }

        public void setAnimationMode(int i7) {
            this.f14608m = i7;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f14613r != null) {
                drawable = P.a.r(drawable.mutate());
                P.a.o(drawable, this.f14613r);
                P.a.p(drawable, this.f14614s);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f14613r = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = P.a.r(getBackground().mutate());
                P.a.o(drawableR, colorStateList);
                P.a.p(drawableR, this.f14614s);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f14614s = mode;
            if (getBackground() != null) {
                Drawable drawableR = P.a.r(getBackground().mutate());
                P.a.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f14616u || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            b((ViewGroup.MarginLayoutParams) layoutParams);
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f14606v);
            super.setOnClickListener(onClickListener);
        }
    }

    public static GradientDrawable c(int i7, Resources resources) throws Resources.NotFoundException {
        float dimension = resources.getDimension(O2.c.f6780K);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i7);
        return gradientDrawable;
    }

    public static g d(int i7, k kVar) {
        g gVar = new g(kVar);
        gVar.U(ColorStateList.valueOf(i7));
        return gVar;
    }
}
