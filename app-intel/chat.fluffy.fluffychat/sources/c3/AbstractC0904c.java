package c3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import k.AbstractC1243a;
import q.d0;

/* renamed from: c3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0904c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (colorStateListA = AbstractC1243a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i7) : colorStateListA;
    }

    public static ColorStateList b(Context context, d0 d0Var, int i7) {
        int iN;
        ColorStateList colorStateListA;
        return (!d0Var.s(i7) || (iN = d0Var.n(i7, 0)) == 0 || (colorStateListA = AbstractC1243a.a(context, iN)) == null) ? d0Var.c(i7) : colorStateListA;
    }

    public static int c(Context context, TypedArray typedArray, int i7, int i8) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i7, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i7, i8);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i8);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (drawableB = AbstractC1243a.b(context, resourceId)) == null) ? typedArray.getDrawable(i7) : drawableB;
    }

    public static int e(TypedArray typedArray, int i7, int i8) {
        return typedArray.hasValue(i7) ? i7 : i8;
    }

    public static C0905d f(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        if (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return new C0905d(context, resourceId);
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
