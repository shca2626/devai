package com.google.android.material.transformation;

import Z.W;
import Z2.a;
import android.content.Context;
import android.support.v4.media.session.b;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    public int f14799a;

    public ExpandableBehavior() {
        this.f14799a = 0;
    }

    public a E(CoordinatorLayout coordinatorLayout, View view) {
        List listQ = coordinatorLayout.q(view);
        int size = listQ.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) listQ.get(i7);
            if (e(coordinatorLayout, view, view2)) {
                b.a(view2);
                return null;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b.a(view2);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
        if (W.Q(view)) {
            return false;
        }
        E(coordinatorLayout, view);
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14799a = 0;
    }
}
