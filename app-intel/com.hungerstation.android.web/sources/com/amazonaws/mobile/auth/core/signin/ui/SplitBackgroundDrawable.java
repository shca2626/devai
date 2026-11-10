package com.amazonaws.mobile.auth.core.signin.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes7.dex */
public class SplitBackgroundDrawable extends Drawable {
    private static final int DEFAULT_BACKGROUND_COLOR = -1;
    private int distanceFromTopToSplitPoint;
    private Paint paint;
    private int topBackgroundColor;

    public SplitBackgroundDrawable(int i12) {
        this.distanceFromTopToSplitPoint = -1;
        this.paint = new Paint();
        this.topBackgroundColor = -1;
        setSplitPointDistanceFromTop(i12);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.paint.setColor(this.topBackgroundColor);
        float fHeight = this.distanceFromTopToSplitPoint < bounds.height() ? this.distanceFromTopToSplitPoint : bounds.height();
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, bounds.width(), fHeight, this.paint);
        this.paint.setColor(-1);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, fHeight, bounds.width(), bounds.height(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i12) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setSplitPointDistanceFromTop(int i12) {
        this.distanceFromTopToSplitPoint = i12;
        invalidateSelf();
    }

    public SplitBackgroundDrawable(int i12, int i13) {
        this.distanceFromTopToSplitPoint = -1;
        this.paint = new Paint();
        this.topBackgroundColor = i13;
        setSplitPointDistanceFromTop(i12);
    }
}
