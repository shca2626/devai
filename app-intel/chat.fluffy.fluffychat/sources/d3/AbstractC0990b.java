package d3;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

/* renamed from: d3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0990b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f15163a = true;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f15164b = {R.attr.state_pressed};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f15165c = {R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f15166d = {R.attr.state_focused};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f15167e = {R.attr.state_hovered};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f15168f = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f15169g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f15170h = {R.attr.state_selected, R.attr.state_focused};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f15171i = {R.attr.state_selected, R.attr.state_hovered};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f15172j = {R.attr.state_selected};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f15173k = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: l, reason: collision with root package name */
    public static final String f15174l = AbstractC0990b.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f15173k, 0)) != 0) {
            Log.w(f15174l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean b(int[] iArr) {
        boolean z7 = false;
        boolean z8 = false;
        for (int i7 : iArr) {
            if (i7 == 16842910) {
                z7 = true;
            } else if (i7 == 16842908 || i7 == 16842919 || i7 == 16843623) {
                z8 = true;
            }
        }
        return z7 && z8;
    }
}
