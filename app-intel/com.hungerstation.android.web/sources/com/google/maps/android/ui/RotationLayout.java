package com.google.maps.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes8.dex */
public class RotationLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    private int f25231b;

    public RotationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i12 = this.f25231b;
        if (i12 == 0) {
            super.dispatchDraw(canvas);
            return;
        }
        if (i12 == 1) {
            canvas.translate(getWidth(), BitmapDescriptorFactory.HUE_RED);
            canvas.rotate(90.0f, getWidth() / 2, BitmapDescriptorFactory.HUE_RED);
            canvas.translate(getHeight() / 2, getWidth() / 2);
        } else if (i12 == 2) {
            canvas.rotate(180.0f, getWidth() / 2, getHeight() / 2);
        } else {
            canvas.translate(BitmapDescriptorFactory.HUE_RED, getHeight());
            canvas.rotate(270.0f, getWidth() / 2, BitmapDescriptorFactory.HUE_RED);
            canvas.translate(getHeight() / 2, (-getWidth()) / 2);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i12, int i13) {
        int i14 = this.f25231b;
        if (i14 != 1 && i14 != 3) {
            super.onMeasure(i12, i13);
        } else {
            super.onMeasure(i12, i13);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void setViewRotation(int i12) {
        this.f25231b = ((i12 + 360) % 360) / 90;
    }
}
