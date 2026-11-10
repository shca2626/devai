package com.amazonaws.mobile.auth.core.signin.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes7.dex */
public class BackgroundDrawable extends Drawable {
    private static final int DEFAULT_BACKGROUND_COLOR = -1;
    private int backgroundColor;
    private Paint paint;

    public BackgroundDrawable() {
        this.paint = new Paint();
        this.backgroundColor = -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.paint.setColor(this.backgroundColor);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, bounds.width(), bounds.height(), this.paint);
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

    public BackgroundDrawable(int i12) {
        this.paint = new Paint();
        this.backgroundColor = i12;
    }
}
