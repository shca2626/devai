package androidx.constraintlayout.widget;

import E.e;
import G.d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: t, reason: collision with root package name */
    public int f11612t;

    /* renamed from: u, reason: collision with root package name */
    public int f11613u;

    /* renamed from: v, reason: collision with root package name */
    public E.a f11614v;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.b
    public void e(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.e(attributeSet);
        this.f11614v = new E.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f2963a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == d.f3005h1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == d.f2999g1) {
                    this.f11614v.L0(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == d.f3011i1) {
                    this.f11614v.N0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
        }
        this.f11735o = this.f11614v;
        k();
    }

    @Override // androidx.constraintlayout.widget.b
    public void f(e eVar, boolean z7) {
        m(eVar, this.f11612t, z7);
    }

    public int getMargin() {
        return this.f11614v.J0();
    }

    public int getType() {
        return this.f11612t;
    }

    public boolean l() {
        return this.f11614v.H0();
    }

    public final void m(e eVar, int i7, boolean z7) {
        this.f11613u = i7;
        if (z7) {
            int i8 = this.f11612t;
            if (i8 == 5) {
                this.f11613u = 1;
            } else if (i8 == 6) {
                this.f11613u = 0;
            }
        } else {
            int i9 = this.f11612t;
            if (i9 == 5) {
                this.f11613u = 0;
            } else if (i9 == 6) {
                this.f11613u = 1;
            }
        }
        if (eVar instanceof E.a) {
            ((E.a) eVar).M0(this.f11613u);
        }
    }

    public void setAllowsGoneWidget(boolean z7) {
        this.f11614v.L0(z7);
    }

    public void setDpMargin(int i7) {
        this.f11614v.N0((int) ((i7 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i7) {
        this.f11614v.N0(i7);
    }

    public void setType(int i7) {
        this.f11612t = i7;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
