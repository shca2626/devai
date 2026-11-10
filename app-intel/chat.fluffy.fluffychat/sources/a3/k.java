package a3;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import c3.C0902b;
import q.d0;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10768a = {O2.a.f6746i};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f10769b = {O2.a.f6747j};

    public static void a(Context context) {
        e(context, f10768a, "Theme.AppCompat");
    }

    public static void b(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O2.j.f7151g6, i7, i8);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(O2.j.f7167i6, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z7) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(O2.a.f6755r, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f10769b, "Theme.MaterialComponents");
    }

    public static void d(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8, int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O2.j.f7151g6, i7, i8);
        if (!typedArrayObtainStyledAttributes.getBoolean(O2.j.f7175j6, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(O2.j.f7159h6, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i7, i8, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void e(Context context, int[] iArr, String str) {
        if (h(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i7, i8);
        for (int i9 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i9, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static boolean g(Context context) {
        return C0902b.b(context, O2.a.f6754q, false);
    }

    public static boolean h(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i7 = 0; i7 < iArr.length; i7++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i7)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray i(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8, int... iArr2) {
        b(context, attributeSet, i7, i8);
        d(context, attributeSet, iArr, i7, i8, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i7, i8);
    }

    public static d0 j(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8, int... iArr2) {
        b(context, attributeSet, i7, i8);
        d(context, attributeSet, iArr, i7, i8, iArr2);
        return d0.v(context, attributeSet, iArr, i7, i8);
    }
}
