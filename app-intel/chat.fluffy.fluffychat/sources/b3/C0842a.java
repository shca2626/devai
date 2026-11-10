package b3;

import O2.i;
import O2.j;
import V2.b;
import a3.k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import c0.AbstractC0891c;
import c3.AbstractC0903c;
import i3.AbstractC1152a;
import q.C1483u;

/* renamed from: b3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0842a extends C1483u {

    /* renamed from: r, reason: collision with root package name */
    public static final int f13719r = i.f6910j;

    /* renamed from: s, reason: collision with root package name */
    public static final int[][] f13720s = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f13721p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13722q;

    public C0842a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, O2.a.f6731A);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f13721p == null) {
            int iD = b.d(this, O2.a.f6742e);
            int iD2 = b.d(this, O2.a.f6745h);
            int iD3 = b.d(this, O2.a.f6748k);
            int[][] iArr = f13720s;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.h(iD3, iD, 1.0f);
            iArr2[1] = b.h(iD3, iD2, 0.54f);
            iArr2[2] = b.h(iD3, iD2, 0.38f);
            iArr2[3] = b.h(iD3, iD2, 0.38f);
            this.f13721p = new ColorStateList(iArr, iArr2);
        }
        return this.f13721p;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13722q && AbstractC0891c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f13722q = z7;
        if (z7) {
            AbstractC0891c.d(this, getMaterialThemeColorsTintList());
        } else {
            AbstractC0891c.d(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0842a(Context context, AttributeSet attributeSet, int i7) {
        int i8 = f13719r;
        super(AbstractC1152a.c(context, attributeSet, i7, i8), attributeSet, i7);
        Context context2 = getContext();
        TypedArray typedArrayI = k.i(context2, attributeSet, j.f7116c3, i7, i8, new int[0]);
        if (typedArrayI.hasValue(j.f7124d3)) {
            AbstractC0891c.d(this, AbstractC0903c.a(context2, typedArrayI, j.f7124d3));
        }
        this.f13722q = typedArrayI.getBoolean(j.f7132e3, false);
        typedArrayI.recycle();
    }
}
