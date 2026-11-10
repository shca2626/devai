package com.google.android.material.snackbar;

import O2.c;
import O2.e;
import Z.W;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: l, reason: collision with root package name */
    public TextView f14617l;

    /* renamed from: m, reason: collision with root package name */
    public Button f14618m;

    /* renamed from: n, reason: collision with root package name */
    public int f14619n;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void a(View view, int i7, int i8) {
        if (W.S(view)) {
            W.A0(view, W.F(view), i7, W.E(view), i8);
        } else {
            view.setPadding(view.getPaddingLeft(), i7, view.getPaddingRight(), i8);
        }
    }

    public final boolean b(int i7, int i8, int i9) {
        boolean z7;
        if (i7 != getOrientation()) {
            setOrientation(i7);
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f14617l.getPaddingTop() == i8 && this.f14617l.getPaddingBottom() == i9) {
            return z7;
        }
        a(this.f14617l, i8, i9);
        return true;
    }

    public Button getActionView() {
        return this.f14618m;
    }

    public TextView getMessageView() {
        return this.f14617l;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f14617l = (TextView) findViewById(e.f6827G);
        this.f14618m = (Button) findViewById(e.f6826F);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i7, int i8) throws Resources.NotFoundException {
        super.onMeasure(i7, i8);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.f6788d);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.f6787c);
        Layout layout = this.f14617l.getLayout();
        boolean z7 = layout != null && layout.getLineCount() > 1;
        if (!z7 || this.f14619n <= 0 || this.f14618m.getMeasuredWidth() <= this.f14619n) {
            if (!z7) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!b(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i7, i8);
    }

    public void setMaxInlineActionWidth(int i7) {
        this.f14619n = i7;
    }
}
