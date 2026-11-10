package q;

import N.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import k.AbstractC1244a;

/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21251a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f21252b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f21253c;

    public d0(Context context, TypedArray typedArray) {
        this.f21251a = context;
        this.f21252b = typedArray;
    }

    public static d0 t(Context context, int i7, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(i7, iArr));
    }

    public static d0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static d0 v(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr, i7, i8));
    }

    public boolean a(int i7, boolean z7) {
        return this.f21252b.getBoolean(i7, z7);
    }

    public int b(int i7, int i8) {
        return this.f21252b.getColor(i7, i8);
    }

    public ColorStateList c(int i7) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f21252b.hasValue(i7) || (resourceId = this.f21252b.getResourceId(i7, 0)) == 0 || (colorStateListA = AbstractC1244a.a(this.f21251a, resourceId)) == null) ? this.f21252b.getColorStateList(i7) : colorStateListA;
    }

    public float d(int i7, float f7) {
        return this.f21252b.getDimension(i7, f7);
    }

    public int e(int i7, int i8) {
        return this.f21252b.getDimensionPixelOffset(i7, i8);
    }

    public int f(int i7, int i8) {
        return this.f21252b.getDimensionPixelSize(i7, i8);
    }

    public Drawable g(int i7) {
        int resourceId;
        return (!this.f21252b.hasValue(i7) || (resourceId = this.f21252b.getResourceId(i7, 0)) == 0) ? this.f21252b.getDrawable(i7) : AbstractC1244a.b(this.f21251a, resourceId);
    }

    public Drawable h(int i7) {
        int resourceId;
        if (!this.f21252b.hasValue(i7) || (resourceId = this.f21252b.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return C1473j.b().d(this.f21251a, resourceId, true);
    }

    public float i(int i7, float f7) {
        return this.f21252b.getFloat(i7, f7);
    }

    public Typeface j(int i7, int i8, h.c cVar) {
        int resourceId = this.f21252b.getResourceId(i7, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f21253c == null) {
            this.f21253c = new TypedValue();
        }
        return N.h.h(this.f21251a, resourceId, this.f21253c, i8, cVar);
    }

    public int k(int i7, int i8) {
        return this.f21252b.getInt(i7, i8);
    }

    public int l(int i7, int i8) {
        return this.f21252b.getInteger(i7, i8);
    }

    public int m(int i7, int i8) {
        return this.f21252b.getLayoutDimension(i7, i8);
    }

    public int n(int i7, int i8) {
        return this.f21252b.getResourceId(i7, i8);
    }

    public String o(int i7) {
        return this.f21252b.getString(i7);
    }

    public CharSequence p(int i7) {
        return this.f21252b.getText(i7);
    }

    public CharSequence[] q(int i7) {
        return this.f21252b.getTextArray(i7);
    }

    public TypedArray r() {
        return this.f21252b;
    }

    public boolean s(int i7) {
        return this.f21252b.hasValue(i7);
    }

    public void w() {
        this.f21252b.recycle();
    }
}
