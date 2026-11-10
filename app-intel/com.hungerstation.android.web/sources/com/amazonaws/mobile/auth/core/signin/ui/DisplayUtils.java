package com.amazonaws.mobile.auth.core.signin.ui;

import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.DisplayMetrics;

/* loaded from: classes7.dex */
public class DisplayUtils {
    private static int dpMultiplier;
    private static final DisplayMetrics metrics;

    static {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        metrics = displayMetrics;
        dpMultiplier = displayMetrics.densityDpi / 160;
    }

    public static int dp(int i12) {
        return i12 * dpMultiplier;
    }

    public static ShapeDrawable getRoundedRectangleBackground(int i12, int i13) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(getRoundedRectangleShape(i12));
        shapeDrawable.getPaint().setColor(i13);
        return shapeDrawable;
    }

    public static Shape getRoundedRectangleShape(int i12) {
        float f12 = i12;
        return new RoundRectShape(new float[]{f12, f12, f12, f12, f12, f12, f12, f12}, null, null);
    }
}
