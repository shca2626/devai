package i3;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import o.C1380d;

/* renamed from: i3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1153a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f17422a = {R.attr.theme, O2.a.f6737G};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f17423b = {O2.a.f6760w};

    public static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f17422a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    public static int b(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f17423b, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i7, int i8) {
        int iB = b(context, attributeSet, i7, i8);
        boolean z7 = (context instanceof C1380d) && ((C1380d) context).c() == iB;
        if (iB == 0 || z7) {
            return context;
        }
        C1380d c1380d = new C1380d(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            c1380d.getTheme().applyStyle(iA, true);
        }
        return c1380d;
    }
}
