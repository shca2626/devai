package q;

import O.AbstractC0563a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public abstract class Z {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f21216a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f21217b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f21218c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f21219d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f21220e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f21221f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f21222g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f21223h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f21224i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f21225j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i.j.f17346y0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(i.j.f17119D0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i7) {
        ColorStateList colorStateListE = e(context, i7);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f21217b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i7, typedValueF.getFloat());
    }

    public static int c(Context context, int i7) {
        int[] iArr = f21225j;
        iArr[0] = i7;
        d0 d0VarU = d0.u(context, null, iArr);
        try {
            return d0VarU.b(0, 0);
        } finally {
            d0VarU.w();
        }
    }

    public static int d(Context context, int i7, float f7) {
        return AbstractC0563a.j(c(context, i7), Math.round(Color.alpha(r0) * f7));
    }

    public static ColorStateList e(Context context, int i7) {
        int[] iArr = f21225j;
        iArr[0] = i7;
        d0 d0VarU = d0.u(context, null, iArr);
        try {
            return d0VarU.c(0);
        } finally {
            d0VarU.w();
        }
    }

    public static TypedValue f() {
        ThreadLocal threadLocal = f21216a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
