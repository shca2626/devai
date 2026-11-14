package h3;

import O2.j;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import c3.AbstractC0904c;
import c3.C0903b;
import i3.AbstractC1153a;
import q.C;

/* renamed from: h3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1140a extends C {
    public C1140a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public static boolean s(Context context) {
        return C0903b.b(context, O2.a.f6735E, true);
    }

    public static int t(Resources.Theme theme, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, j.f7204n3, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(j.f7212o3, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int v(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i7 = 0; i7 < iArr.length && iC < 0; i7++) {
            iC = AbstractC0904c.c(context, typedArray, iArr[i7], -1);
        }
        return iC;
    }

    public static boolean w(Context context, Resources.Theme theme, AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, j.f7204n3, i7, i8);
        int iV = v(context, typedArrayObtainStyledAttributes, j.f7220p3, j.f7228q3);
        typedArrayObtainStyledAttributes.recycle();
        return iV != -1;
    }

    public final void r(Resources.Theme theme, int i7) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i7, j.f7172j3);
        int iV = v(getContext(), typedArrayObtainStyledAttributes, j.f7188l3, j.f7196m3);
        typedArrayObtainStyledAttributes.recycle();
        if (iV >= 0) {
            setLineHeight(iV);
        }
    }

    @Override // q.C, android.widget.TextView
    public void setTextAppearance(Context context, int i7) throws Resources.NotFoundException {
        super.setTextAppearance(context, i7);
        if (s(context)) {
            r(context.getTheme(), i7);
        }
    }

    public final void u(AttributeSet attributeSet, int i7, int i8) throws Resources.NotFoundException {
        int iT;
        Context context = getContext();
        if (s(context)) {
            Resources.Theme theme = context.getTheme();
            if (w(context, theme, attributeSet, i7, i8) || (iT = t(theme, attributeSet, i7, i8)) == -1) {
                return;
            }
            r(theme, iT);
        }
    }

    public C1140a(Context context, AttributeSet attributeSet, int i7) throws Resources.NotFoundException {
        super(AbstractC1153a.c(context, attributeSet, i7, 0), attributeSet, i7);
        u(attributeSet, i7, 0);
    }
}
