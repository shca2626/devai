package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.media.session.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f14215a;

    /* renamed from: b, reason: collision with root package name */
    public int f14216b;

    /* renamed from: c, reason: collision with root package name */
    public int f14217c;

    /* renamed from: d, reason: collision with root package name */
    public int f14218d;

    /* renamed from: e, reason: collision with root package name */
    public ViewPropertyAnimator f14219e;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f14219e = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f14215a = new LinkedHashSet();
        this.f14216b = 0;
        this.f14217c = 2;
        this.f14218d = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
        return i7 == 2;
    }

    public final void F(View view, int i7, long j7, TimeInterpolator timeInterpolator) {
        this.f14219e = view.animate().translationY(i7).setInterpolator(timeInterpolator).setDuration(j7).setListener(new a());
    }

    public boolean G() {
        return this.f14217c == 1;
    }

    public boolean H() {
        return this.f14217c == 2;
    }

    public void I(View view) {
        J(view, true);
    }

    public void J(View view, boolean z7) {
        if (G()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f14219e;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        M(view, 1);
        int i7 = this.f14216b + this.f14218d;
        if (z7) {
            F(view, i7, 175L, P2.a.f7544c);
        } else {
            view.setTranslationY(i7);
        }
    }

    public void K(View view) {
        L(view, true);
    }

    public void L(View view, boolean z7) {
        if (H()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f14219e;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        M(view, 2);
        if (z7) {
            F(view, 0, 225L, P2.a.f7545d);
        } else {
            view.setTranslationY(0);
        }
    }

    public final void M(View view, int i7) {
        this.f14217c = i7;
        Iterator it = this.f14215a.iterator();
        if (it.hasNext()) {
            b.a(it.next());
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
        this.f14216b = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, view, i7);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        if (i8 > 0) {
            I(view);
        } else if (i8 < 0) {
            K(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14215a = new LinkedHashSet();
        this.f14216b = 0;
        this.f14217c = 2;
        this.f14218d = 0;
    }
}
