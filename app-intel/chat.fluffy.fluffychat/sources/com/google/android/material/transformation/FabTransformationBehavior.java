package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: b, reason: collision with root package name */
    public final Rect f14800b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f14801c;

    /* renamed from: d, reason: collision with root package name */
    public final RectF f14802d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f14803e;

    public FabTransformationBehavior() {
        this.f14800b = new Rect();
        this.f14801c = new RectF();
        this.f14802d = new RectF();
        this.f14803e = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void g(CoordinatorLayout.e eVar) {
        if (eVar.f11875h == 0) {
            eVar.f11875h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14800b = new Rect();
        this.f14801c = new RectF();
        this.f14802d = new RectF();
        this.f14803e = new int[2];
    }
}
