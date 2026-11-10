package androidx.constraintlayout.widget;

import E.e;
import E.h;
import G.d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: l, reason: collision with root package name */
    public int[] f11732l;

    /* renamed from: m, reason: collision with root package name */
    public int f11733m;

    /* renamed from: n, reason: collision with root package name */
    public Context f11734n;

    /* renamed from: o, reason: collision with root package name */
    public h f11735o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11736p;

    /* renamed from: q, reason: collision with root package name */
    public String f11737q;

    /* renamed from: r, reason: collision with root package name */
    public View[] f11738r;

    /* renamed from: s, reason: collision with root package name */
    public HashMap f11739s;

    public b(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.f11732l = new int[32];
        this.f11736p = false;
        this.f11738r = null;
        this.f11739s = new HashMap();
        this.f11734n = context;
        e(null);
    }

    public final void a(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (str == null || str.length() == 0 || this.f11734n == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iD = d(strTrim);
        if (iD != 0) {
            this.f11739s.put(Integer.valueOf(iD), strTrim);
            b(iD);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    public final void b(int i7) {
        if (i7 == getId()) {
            return;
        }
        int i8 = this.f11733m + 1;
        int[] iArr = this.f11732l;
        if (i8 > iArr.length) {
            this.f11732l = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f11732l;
        int i9 = this.f11733m;
        iArr2[i9] = i7;
        this.f11733m = i9 + 1;
    }

    public final int c(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f11734n.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int d(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iC = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objF = constraintLayout.f(0, str);
            if (objF instanceof Integer) {
                iC = ((Integer) objF).intValue();
            }
        }
        if (iC == 0 && constraintLayout != null) {
            iC = c(constraintLayout, str);
        }
        if (iC == 0) {
            try {
                iC = G.c.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iC == 0 ? this.f11734n.getResources().getIdentifier(str, "id", this.f11734n.getPackageName()) : iC;
    }

    public void e(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f2963a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == d.f3023k1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f11737q = string;
                    setIds(string);
                }
            }
        }
    }

    public abstract void f(e eVar, boolean z7);

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f11732l, this.f11733m);
    }

    public void h(ConstraintLayout constraintLayout) {
    }

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String str;
        int iC;
        if (isInEditMode()) {
            setIds(this.f11737q);
        }
        h hVar = this.f11735o;
        if (hVar == null) {
            return;
        }
        hVar.c();
        for (int i7 = 0; i7 < this.f11733m; i7++) {
            int i8 = this.f11732l[i7];
            View viewH = constraintLayout.h(i8);
            if (viewH == null && (iC = c(constraintLayout, (str = (String) this.f11739s.get(Integer.valueOf(i8))))) != 0) {
                this.f11732l[i7] = iC;
                this.f11739s.put(Integer.valueOf(iC), str);
                viewH = constraintLayout.h(iC);
            }
            if (viewH != null) {
                this.f11735o.b(constraintLayout.i(viewH));
            }
        }
        this.f11735o.a(constraintLayout.f11626n);
    }

    public void k() {
        if (this.f11735o == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f11693n0 = (e) this.f11735o;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f11737q;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        if (this.f11736p) {
            super.onMeasure(i7, i8);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f11737q = str;
        if (str == null) {
            return;
        }
        int i7 = 0;
        this.f11733m = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i7);
            if (iIndexOf == -1) {
                a(str.substring(i7));
                return;
            } else {
                a(str.substring(i7, iIndexOf));
                i7 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f11737q = null;
        this.f11733m = 0;
        for (int i7 : iArr) {
            b(i7);
        }
    }

    public b(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f11732l = new int[32];
        this.f11736p = false;
        this.f11738r = null;
        this.f11739s = new HashMap();
        this.f11734n = context;
        e(attributeSet);
    }
}
