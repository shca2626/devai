package androidx.constraintlayout.widget;

import E.e;
import E.f;
import E.g;
import F.b;
import G.d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import org.webrtc.PeerConnectionFactory;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    public int f11615A;

    /* renamed from: B, reason: collision with root package name */
    public int f11616B;

    /* renamed from: C, reason: collision with root package name */
    public int f11617C;

    /* renamed from: D, reason: collision with root package name */
    public int f11618D;

    /* renamed from: E, reason: collision with root package name */
    public SparseArray f11619E;

    /* renamed from: F, reason: collision with root package name */
    public G.b f11620F;

    /* renamed from: G, reason: collision with root package name */
    public c f11621G;

    /* renamed from: H, reason: collision with root package name */
    public int f11622H;

    /* renamed from: I, reason: collision with root package name */
    public int f11623I;

    /* renamed from: l, reason: collision with root package name */
    public SparseArray f11624l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f11625m;

    /* renamed from: n, reason: collision with root package name */
    public f f11626n;

    /* renamed from: o, reason: collision with root package name */
    public int f11627o;

    /* renamed from: p, reason: collision with root package name */
    public int f11628p;

    /* renamed from: q, reason: collision with root package name */
    public int f11629q;

    /* renamed from: r, reason: collision with root package name */
    public int f11630r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11631s;

    /* renamed from: t, reason: collision with root package name */
    public int f11632t;

    /* renamed from: u, reason: collision with root package name */
    public androidx.constraintlayout.widget.c f11633u;

    /* renamed from: v, reason: collision with root package name */
    public G.a f11634v;

    /* renamed from: w, reason: collision with root package name */
    public int f11635w;

    /* renamed from: x, reason: collision with root package name */
    public HashMap f11636x;

    /* renamed from: y, reason: collision with root package name */
    public int f11637y;

    /* renamed from: z, reason: collision with root package name */
    public int f11638z;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11639a;

        static {
            int[] iArr = new int[e.b.values().length];
            f11639a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11639a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11639a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11639a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class c implements b.InterfaceC0022b {

        /* renamed from: a, reason: collision with root package name */
        public ConstraintLayout f11708a;

        /* renamed from: b, reason: collision with root package name */
        public int f11709b;

        /* renamed from: c, reason: collision with root package name */
        public int f11710c;

        /* renamed from: d, reason: collision with root package name */
        public int f11711d;

        /* renamed from: e, reason: collision with root package name */
        public int f11712e;

        /* renamed from: f, reason: collision with root package name */
        public int f11713f;

        /* renamed from: g, reason: collision with root package name */
        public int f11714g;

        public c(ConstraintLayout constraintLayout) {
            this.f11708a = constraintLayout;
        }

        @Override // F.b.InterfaceC0022b
        public final void a() {
            int childCount = this.f11708a.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                this.f11708a.getChildAt(i7);
            }
            int size = this.f11708a.f11625m.size();
            if (size > 0) {
                for (int i8 = 0; i8 < size; i8++) {
                    ((androidx.constraintlayout.widget.b) this.f11708a.f11625m.get(i8)).h(this.f11708a);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0182 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x01a7  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01c7  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01d9  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x01de  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x01f4  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x0223  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x0226  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x022c  */
        /* JADX WARN: Removed duplicated region for block: B:155:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:160:0x0240  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0166  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0170  */
        @Override // F.b.InterfaceC0022b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(E.e r21, F.b.a r22) {
            /*
                Method dump skipped, instructions count: 598
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c.b(E.e, F.b$a):void");
        }

        public void c(int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f11709b = i9;
            this.f11710c = i10;
            this.f11711d = i11;
            this.f11712e = i12;
            this.f11713f = i7;
            this.f11714g = i8;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        super(context, attributeSet);
        this.f11624l = new SparseArray();
        this.f11625m = new ArrayList(4);
        this.f11626n = new f();
        this.f11627o = 0;
        this.f11628p = 0;
        this.f11629q = Integer.MAX_VALUE;
        this.f11630r = Integer.MAX_VALUE;
        this.f11631s = true;
        this.f11632t = 263;
        this.f11633u = null;
        this.f11634v = null;
        this.f11635w = -1;
        this.f11636x = new HashMap();
        this.f11637y = -1;
        this.f11638z = -1;
        this.f11615A = -1;
        this.f11616B = -1;
        this.f11617C = 0;
        this.f11618D = 0;
        this.f11619E = new SparseArray();
        this.f11621G = new c(this);
        this.f11622H = 0;
        this.f11623I = 0;
        j(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(boolean r17, android.view.View r18, E.e r19, androidx.constraintlayout.widget.ConstraintLayout.b r20, android.util.SparseArray r21) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c(boolean, android.view.View, E.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList arrayList = this.f11625m;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                ((androidx.constraintlayout.widget.b) this.f11625m.get(i7)).i(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i9 = Integer.parseInt(strArrSplit[0]);
                        int i10 = Integer.parseInt(strArrSplit[1]);
                        int i11 = Integer.parseInt(strArrSplit[2]);
                        int i12 = (int) ((i9 / 1080.0f) * width);
                        int i13 = (int) ((i10 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f7 = i12;
                        float f8 = i13;
                        float f9 = i12 + ((int) ((i11 / 1080.0f) * width));
                        canvas.drawLine(f7, f8, f9, f8, paint);
                        float f10 = i13 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f9, f8, f9, f10, paint);
                        canvas.drawLine(f9, f10, f7, f10, paint);
                        canvas.drawLine(f7, f10, f7, f8, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f7, f8, f9, f10, paint);
                        canvas.drawLine(f7, f10, f9, f8, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object f(int i7, Object obj) {
        if (i7 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.f11636x;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f11636x.get(str);
    }

    @Override // android.view.View
    public void forceLayout() {
        l();
        super.forceLayout();
    }

    public final e g(int i7) {
        if (i7 == 0) {
            return this.f11626n;
        }
        View viewFindViewById = (View) this.f11624l.get(i7);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i7)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f11626n;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f11693n0;
    }

    public int getMaxHeight() {
        return this.f11630r;
    }

    public int getMaxWidth() {
        return this.f11629q;
    }

    public int getMinHeight() {
        return this.f11628p;
    }

    public int getMinWidth() {
        return this.f11627o;
    }

    public int getOptimizationLevel() {
        return this.f11626n.S0();
    }

    public View h(int i7) {
        return (View) this.f11624l.get(i7);
    }

    public final e i(View view) {
        if (view == this) {
            return this.f11626n;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f11693n0;
    }

    public final void j(AttributeSet attributeSet, int i7, int i8) throws XmlPullParserException, IOException {
        this.f11626n.Z(this);
        this.f11626n.b1(this.f11621G);
        this.f11624l.put(getId(), this);
        this.f11633u = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f2963a1, i7, i8);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == d.f2987e1) {
                    this.f11627o = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11627o);
                } else if (index == d.f2993f1) {
                    this.f11628p = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11628p);
                } else if (index == d.f2975c1) {
                    this.f11629q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11629q);
                } else if (index == d.f2981d1) {
                    this.f11630r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11630r);
                } else if (index == d.f3024k2) {
                    this.f11632t = typedArrayObtainStyledAttributes.getInt(index, this.f11632t);
                } else if (index == d.f3029l1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f11634v = null;
                        }
                    }
                } else if (index == d.f3017j1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f11633u = cVar;
                        cVar.l(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f11633u = null;
                    }
                    this.f11635w = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f11626n.c1(this.f11632t);
    }

    public boolean k() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public final void l() {
        this.f11631s = true;
        this.f11637y = -1;
        this.f11638z = -1;
        this.f11615A = -1;
        this.f11616B = -1;
        this.f11617C = 0;
        this.f11618D = 0;
    }

    public void m(int i7) {
        this.f11634v = new G.a(getContext(), this, i7);
    }

    public void n(int i7, int i8, int i9, int i10, boolean z7, boolean z8) {
        c cVar = this.f11621G;
        int i11 = cVar.f11712e;
        int iResolveSizeAndState = View.resolveSizeAndState(i9 + cVar.f11711d, i7, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i10 + i11, i8, 0) & 16777215;
        int iMin = Math.min(this.f11629q, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f11630r, iResolveSizeAndState2);
        if (z7) {
            iMin |= 16777216;
        }
        if (z8) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f11637y = iMin;
        this.f11638z = iMin2;
    }

    public void o(f fVar, int i7, int i8, int i9) {
        int i10;
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i9);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i11 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.f11621G.c(i8, i9, iMax, iMax2, paddingWidth, i11);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        if (iMax3 > 0 || iMax4 > 0) {
            if (k()) {
                i10 = iMax4;
            }
            int i12 = size - paddingWidth;
            int i13 = size2 - i11;
            r(fVar, mode, i12, mode2, i13);
            fVar.Y0(i7, mode, i12, mode2, i13, this.f11637y, this.f11638z, i10, iMax);
        }
        iMax3 = Math.max(0, getPaddingLeft());
        i10 = iMax3;
        int i122 = size - paddingWidth;
        int i132 = size2 - i11;
        r(fVar, mode, i122, mode2, i132);
        fVar.Y0(i7, mode, i122, mode2, i132, this.f11637y, this.f11638z, i10, iMax);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            b bVar = (b) childAt.getLayoutParams();
            e eVar = bVar.f11693n0;
            if ((childAt.getVisibility() != 8 || bVar.f11665Z || bVar.f11667a0 || bVar.f11671c0 || zIsInEditMode) && !bVar.f11669b0) {
                int iO = eVar.O();
                int iP = eVar.P();
                childAt.layout(iO, iP, eVar.N() + iO, eVar.t() + iP);
            }
        }
        int size = this.f11625m.size();
        if (size > 0) {
            for (int i12 = 0; i12 < size; i12++) {
                ((androidx.constraintlayout.widget.b) this.f11625m.get(i12)).g(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        this.f11622H = i7;
        this.f11623I = i8;
        this.f11626n.d1(k());
        if (this.f11631s) {
            this.f11631s = false;
            if (s()) {
                this.f11626n.f1();
            }
        }
        o(this.f11626n, this.f11632t, i7, i8);
        n(i7, i8, this.f11626n.N(), this.f11626n.t(), this.f11626n.X0(), this.f11626n.V0());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        e eVarI = i(view);
        if ((view instanceof Guideline) && !(eVarI instanceof g)) {
            b bVar = (b) view.getLayoutParams();
            g gVar = new g();
            bVar.f11693n0 = gVar;
            bVar.f11665Z = true;
            gVar.O0(bVar.f11658S);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.k();
            ((b) view.getLayoutParams()).f11667a0 = true;
            if (!this.f11625m.contains(bVar2)) {
                this.f11625m.add(bVar2);
            }
        }
        this.f11624l.put(view.getId(), view);
        this.f11631s = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f11624l.remove(view.getId());
        this.f11626n.I0(i(view));
        this.f11625m.remove(view);
        this.f11631s = true;
    }

    public final void p() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            e eVarI = i(getChildAt(i7));
            if (eVarI != null) {
                eVarI.W();
            }
        }
        if (zIsInEditMode) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    q(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    g(childAt.getId()).a0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f11635w != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                getChildAt(i9).getId();
            }
        }
        androidx.constraintlayout.widget.c cVar = this.f11633u;
        if (cVar != null) {
            cVar.d(this, true);
        }
        this.f11626n.J0();
        int size = this.f11625m.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.constraintlayout.widget.b) this.f11625m.get(i10)).j(this);
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            getChildAt(i11);
        }
        this.f11619E.clear();
        this.f11619E.put(0, this.f11626n);
        this.f11619E.put(getId(), this.f11626n);
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            this.f11619E.put(childAt2.getId(), i(childAt2));
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt3 = getChildAt(i13);
            e eVarI2 = i(childAt3);
            if (eVarI2 != null) {
                b bVar = (b) childAt3.getLayoutParams();
                this.f11626n.b(eVarI2);
                c(zIsInEditMode, childAt3, eVarI2, bVar, this.f11619E);
            }
        }
    }

    public void q(int i7, Object obj, Object obj2) {
        if (i7 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f11636x == null) {
                this.f11636x = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f11636x.put(strSubstring, num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 E.e$b) = (r2v3 E.e$b), (r2v0 E.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(E.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.f11621G
            int r1 = r0.f11712e
            int r0 = r0.f11711d
            E.e$b r2 = E.e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == r6) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r5
            goto L38
        L1a:
            int r9 = r7.f11629q
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            E.e$b r9 = E.e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.f11627o
            int r10 = java.lang.Math.max(r5, r10)
            goto L38
        L2e:
            E.e$b r9 = E.e.b.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.f11627o
            int r10 = java.lang.Math.max(r5, r10)
        L38:
            if (r11 == r6) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r5
            goto L5d
        L40:
            int r11 = r7.f11630r
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            E.e$b r2 = E.e.b.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.f11628p
            int r12 = java.lang.Math.max(r5, r11)
            goto L5d
        L53:
            E.e$b r2 = E.e.b.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.f11628p
            int r12 = java.lang.Math.max(r5, r11)
        L5d:
            int r11 = r8.N()
            if (r10 != r11) goto L69
            int r11 = r8.t()
            if (r12 == r11) goto L6c
        L69:
            r8.U0()
        L6c:
            r8.C0(r5)
            r8.D0(r5)
            int r11 = r7.f11629q
            int r11 = r11 - r0
            r8.p0(r11)
            int r11 = r7.f11630r
            int r11 = r11 - r1
            r8.o0(r11)
            r8.r0(r5)
            r8.q0(r5)
            r8.i0(r9)
            r8.B0(r10)
            r8.x0(r2)
            r8.e0(r12)
            int r9 = r7.f11627o
            int r9 = r9 - r0
            r8.r0(r9)
            int r9 = r7.f11628p
            int r9 = r9 - r1
            r8.q0(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.r(E.f, int, int, int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        l();
        super.requestLayout();
    }

    public final boolean s() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int childCount = getChildCount();
        boolean z7 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= childCount) {
                break;
            }
            if (getChildAt(i7).isLayoutRequested()) {
                z7 = true;
                break;
            }
            i7++;
        }
        if (z7) {
            p();
        }
        return z7;
    }

    public void setConstraintSet(androidx.constraintlayout.widget.c cVar) {
        this.f11633u = cVar;
    }

    @Override // android.view.View
    public void setId(int i7) {
        this.f11624l.remove(getId());
        super.setId(i7);
        this.f11624l.put(getId(), this);
    }

    public void setMaxHeight(int i7) {
        if (i7 == this.f11630r) {
            return;
        }
        this.f11630r = i7;
        requestLayout();
    }

    public void setMaxWidth(int i7) {
        if (i7 == this.f11629q) {
            return;
        }
        this.f11629q = i7;
        requestLayout();
    }

    public void setMinHeight(int i7) {
        if (i7 == this.f11628p) {
            return;
        }
        this.f11628p = i7;
        requestLayout();
    }

    public void setMinWidth(int i7) {
        if (i7 == this.f11627o) {
            return;
        }
        this.f11627o = i7;
        requestLayout();
    }

    public void setOnConstraintsChanged(G.b bVar) {
        this.f11620F = bVar;
        G.a aVar = this.f11634v;
        if (aVar != null) {
            aVar.c(bVar);
        }
    }

    public void setOptimizationLevel(int i7) {
        this.f11632t = i7;
        this.f11626n.c1(i7);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i7) throws XmlPullParserException, IOException {
        super(context, attributeSet, i7);
        this.f11624l = new SparseArray();
        this.f11625m = new ArrayList(4);
        this.f11626n = new f();
        this.f11627o = 0;
        this.f11628p = 0;
        this.f11629q = Integer.MAX_VALUE;
        this.f11630r = Integer.MAX_VALUE;
        this.f11631s = true;
        this.f11632t = 263;
        this.f11633u = null;
        this.f11634v = null;
        this.f11635w = -1;
        this.f11636x = new HashMap();
        this.f11637y = -1;
        this.f11638z = -1;
        this.f11615A = -1;
        this.f11616B = -1;
        this.f11617C = 0;
        this.f11618D = 0;
        this.f11619E = new SparseArray();
        this.f11621G = new c(this);
        this.f11622H = 0;
        this.f11623I = 0;
        j(attributeSet, i7, 0);
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* renamed from: A, reason: collision with root package name */
        public float f11640A;

        /* renamed from: B, reason: collision with root package name */
        public String f11641B;

        /* renamed from: C, reason: collision with root package name */
        public float f11642C;

        /* renamed from: D, reason: collision with root package name */
        public int f11643D;

        /* renamed from: E, reason: collision with root package name */
        public float f11644E;

        /* renamed from: F, reason: collision with root package name */
        public float f11645F;

        /* renamed from: G, reason: collision with root package name */
        public int f11646G;

        /* renamed from: H, reason: collision with root package name */
        public int f11647H;

        /* renamed from: I, reason: collision with root package name */
        public int f11648I;

        /* renamed from: J, reason: collision with root package name */
        public int f11649J;

        /* renamed from: K, reason: collision with root package name */
        public int f11650K;

        /* renamed from: L, reason: collision with root package name */
        public int f11651L;

        /* renamed from: M, reason: collision with root package name */
        public int f11652M;

        /* renamed from: N, reason: collision with root package name */
        public int f11653N;

        /* renamed from: O, reason: collision with root package name */
        public float f11654O;

        /* renamed from: P, reason: collision with root package name */
        public float f11655P;

        /* renamed from: Q, reason: collision with root package name */
        public int f11656Q;

        /* renamed from: R, reason: collision with root package name */
        public int f11657R;

        /* renamed from: S, reason: collision with root package name */
        public int f11658S;

        /* renamed from: T, reason: collision with root package name */
        public boolean f11659T;

        /* renamed from: U, reason: collision with root package name */
        public boolean f11660U;

        /* renamed from: V, reason: collision with root package name */
        public String f11661V;

        /* renamed from: W, reason: collision with root package name */
        public boolean f11662W;

        /* renamed from: X, reason: collision with root package name */
        public boolean f11663X;

        /* renamed from: Y, reason: collision with root package name */
        public boolean f11664Y;

        /* renamed from: Z, reason: collision with root package name */
        public boolean f11665Z;

        /* renamed from: a, reason: collision with root package name */
        public int f11666a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f11667a0;

        /* renamed from: b, reason: collision with root package name */
        public int f11668b;

        /* renamed from: b0, reason: collision with root package name */
        public boolean f11669b0;

        /* renamed from: c, reason: collision with root package name */
        public float f11670c;

        /* renamed from: c0, reason: collision with root package name */
        public boolean f11671c0;

        /* renamed from: d, reason: collision with root package name */
        public int f11672d;

        /* renamed from: d0, reason: collision with root package name */
        public int f11673d0;

        /* renamed from: e, reason: collision with root package name */
        public int f11674e;

        /* renamed from: e0, reason: collision with root package name */
        public int f11675e0;

        /* renamed from: f, reason: collision with root package name */
        public int f11676f;

        /* renamed from: f0, reason: collision with root package name */
        public int f11677f0;

        /* renamed from: g, reason: collision with root package name */
        public int f11678g;

        /* renamed from: g0, reason: collision with root package name */
        public int f11679g0;

        /* renamed from: h, reason: collision with root package name */
        public int f11680h;

        /* renamed from: h0, reason: collision with root package name */
        public int f11681h0;

        /* renamed from: i, reason: collision with root package name */
        public int f11682i;

        /* renamed from: i0, reason: collision with root package name */
        public int f11683i0;

        /* renamed from: j, reason: collision with root package name */
        public int f11684j;

        /* renamed from: j0, reason: collision with root package name */
        public float f11685j0;

        /* renamed from: k, reason: collision with root package name */
        public int f11686k;

        /* renamed from: k0, reason: collision with root package name */
        public int f11687k0;

        /* renamed from: l, reason: collision with root package name */
        public int f11688l;

        /* renamed from: l0, reason: collision with root package name */
        public int f11689l0;

        /* renamed from: m, reason: collision with root package name */
        public int f11690m;

        /* renamed from: m0, reason: collision with root package name */
        public float f11691m0;

        /* renamed from: n, reason: collision with root package name */
        public int f11692n;

        /* renamed from: n0, reason: collision with root package name */
        public e f11693n0;

        /* renamed from: o, reason: collision with root package name */
        public float f11694o;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f11695o0;

        /* renamed from: p, reason: collision with root package name */
        public int f11696p;

        /* renamed from: q, reason: collision with root package name */
        public int f11697q;

        /* renamed from: r, reason: collision with root package name */
        public int f11698r;

        /* renamed from: s, reason: collision with root package name */
        public int f11699s;

        /* renamed from: t, reason: collision with root package name */
        public int f11700t;

        /* renamed from: u, reason: collision with root package name */
        public int f11701u;

        /* renamed from: v, reason: collision with root package name */
        public int f11702v;

        /* renamed from: w, reason: collision with root package name */
        public int f11703w;

        /* renamed from: x, reason: collision with root package name */
        public int f11704x;

        /* renamed from: y, reason: collision with root package name */
        public int f11705y;

        /* renamed from: z, reason: collision with root package name */
        public float f11706z;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f11707a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f11707a = sparseIntArray;
                sparseIntArray.append(d.f2872K1, 8);
                sparseIntArray.append(d.f2878L1, 9);
                sparseIntArray.append(d.f2890N1, 10);
                sparseIntArray.append(d.f2896O1, 11);
                sparseIntArray.append(d.f2932U1, 12);
                sparseIntArray.append(d.f2926T1, 13);
                sparseIntArray.append(d.f3071s1, 14);
                sparseIntArray.append(d.f3065r1, 15);
                sparseIntArray.append(d.f3053p1, 16);
                sparseIntArray.append(d.f3077t1, 2);
                sparseIntArray.append(d.f3089v1, 3);
                sparseIntArray.append(d.f3083u1, 4);
                sparseIntArray.append(d.f2976c2, 49);
                sparseIntArray.append(d.f2982d2, 50);
                sparseIntArray.append(d.f3113z1, 5);
                sparseIntArray.append(d.f2812A1, 6);
                sparseIntArray.append(d.f2818B1, 7);
                sparseIntArray.append(d.f2969b1, 1);
                sparseIntArray.append(d.f2902P1, 17);
                sparseIntArray.append(d.f2908Q1, 18);
                sparseIntArray.append(d.f3107y1, 19);
                sparseIntArray.append(d.f3101x1, 20);
                sparseIntArray.append(d.f3000g2, 21);
                sparseIntArray.append(d.f3018j2, 22);
                sparseIntArray.append(d.f3006h2, 23);
                sparseIntArray.append(d.f2988e2, 24);
                sparseIntArray.append(d.f3012i2, 25);
                sparseIntArray.append(d.f2994f2, 26);
                sparseIntArray.append(d.f2848G1, 29);
                sparseIntArray.append(d.f2938V1, 30);
                sparseIntArray.append(d.f3095w1, 44);
                sparseIntArray.append(d.f2860I1, 45);
                sparseIntArray.append(d.f2948X1, 46);
                sparseIntArray.append(d.f2854H1, 47);
                sparseIntArray.append(d.f2943W1, 48);
                sparseIntArray.append(d.f3041n1, 27);
                sparseIntArray.append(d.f3035m1, 28);
                sparseIntArray.append(d.f2953Y1, 31);
                sparseIntArray.append(d.f2824C1, 32);
                sparseIntArray.append(d.f2964a2, 33);
                sparseIntArray.append(d.f2958Z1, 34);
                sparseIntArray.append(d.f2970b2, 35);
                sparseIntArray.append(d.f2836E1, 36);
                sparseIntArray.append(d.f2830D1, 37);
                sparseIntArray.append(d.f2842F1, 38);
                sparseIntArray.append(d.f2866J1, 39);
                sparseIntArray.append(d.f2920S1, 40);
                sparseIntArray.append(d.f2884M1, 41);
                sparseIntArray.append(d.f3059q1, 42);
                sparseIntArray.append(d.f3047o1, 43);
                sparseIntArray.append(d.f2914R1, 51);
            }
        }

        public b(Context context, AttributeSet attributeSet) throws NumberFormatException {
            int i7;
            super(context, attributeSet);
            this.f11666a = -1;
            this.f11668b = -1;
            this.f11670c = -1.0f;
            this.f11672d = -1;
            this.f11674e = -1;
            this.f11676f = -1;
            this.f11678g = -1;
            this.f11680h = -1;
            this.f11682i = -1;
            this.f11684j = -1;
            this.f11686k = -1;
            this.f11688l = -1;
            this.f11690m = -1;
            this.f11692n = 0;
            this.f11694o = 0.0f;
            this.f11696p = -1;
            this.f11697q = -1;
            this.f11698r = -1;
            this.f11699s = -1;
            this.f11700t = -1;
            this.f11701u = -1;
            this.f11702v = -1;
            this.f11703w = -1;
            this.f11704x = -1;
            this.f11705y = -1;
            this.f11706z = 0.5f;
            this.f11640A = 0.5f;
            this.f11641B = null;
            this.f11642C = 0.0f;
            this.f11643D = 1;
            this.f11644E = -1.0f;
            this.f11645F = -1.0f;
            this.f11646G = 0;
            this.f11647H = 0;
            this.f11648I = 0;
            this.f11649J = 0;
            this.f11650K = 0;
            this.f11651L = 0;
            this.f11652M = 0;
            this.f11653N = 0;
            this.f11654O = 1.0f;
            this.f11655P = 1.0f;
            this.f11656Q = -1;
            this.f11657R = -1;
            this.f11658S = -1;
            this.f11659T = false;
            this.f11660U = false;
            this.f11661V = null;
            this.f11662W = true;
            this.f11663X = true;
            this.f11664Y = false;
            this.f11665Z = false;
            this.f11667a0 = false;
            this.f11669b0 = false;
            this.f11671c0 = false;
            this.f11673d0 = -1;
            this.f11675e0 = -1;
            this.f11677f0 = -1;
            this.f11679g0 = -1;
            this.f11681h0 = -1;
            this.f11683i0 = -1;
            this.f11685j0 = 0.5f;
            this.f11693n0 = new e();
            this.f11695o0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f2963a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                int i9 = a.f11707a.get(index);
                switch (i9) {
                    case 1:
                        this.f11658S = typedArrayObtainStyledAttributes.getInt(index, this.f11658S);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f11690m);
                        this.f11690m = resourceId;
                        if (resourceId == -1) {
                            this.f11690m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f11692n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11692n);
                        break;
                    case 4:
                        float f7 = typedArrayObtainStyledAttributes.getFloat(index, this.f11694o) % 360.0f;
                        this.f11694o = f7;
                        if (f7 < 0.0f) {
                            this.f11694o = (360.0f - f7) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f11666a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11666a);
                        break;
                    case 6:
                        this.f11668b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11668b);
                        break;
                    case 7:
                        this.f11670c = typedArrayObtainStyledAttributes.getFloat(index, this.f11670c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11672d);
                        this.f11672d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f11672d = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11674e);
                        this.f11674e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f11674e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11676f);
                        this.f11676f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f11676f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11678g);
                        this.f11678g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f11678g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11680h);
                        this.f11680h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f11680h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11682i);
                        this.f11682i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f11682i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case StdKeyDeserializer.TYPE_URL /* 14 */:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11684j);
                        this.f11684j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f11684j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11686k);
                        this.f11686k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f11686k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11688l);
                        this.f11688l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f11688l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11696p);
                        this.f11696p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f11696p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11697q);
                        this.f11697q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f11697q = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11698r);
                        this.f11698r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f11698r = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f11699s);
                        this.f11699s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f11699s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f11700t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11700t);
                        break;
                    case 22:
                        this.f11701u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11701u);
                        break;
                    case 23:
                        this.f11702v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11702v);
                        break;
                    case 24:
                        this.f11703w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11703w);
                        break;
                    case 25:
                        this.f11704x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11704x);
                        break;
                    case 26:
                        this.f11705y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11705y);
                        break;
                    case 27:
                        this.f11659T = typedArrayObtainStyledAttributes.getBoolean(index, this.f11659T);
                        break;
                    case 28:
                        this.f11660U = typedArrayObtainStyledAttributes.getBoolean(index, this.f11660U);
                        break;
                    case 29:
                        this.f11706z = typedArrayObtainStyledAttributes.getFloat(index, this.f11706z);
                        break;
                    case 30:
                        this.f11640A = typedArrayObtainStyledAttributes.getFloat(index, this.f11640A);
                        break;
                    case 31:
                        int i10 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f11648I = i10;
                        if (i10 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                        int i11 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f11649J = i11;
                        if (i11 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case CharsToNameCanonicalizer.HASH_MULT /* 33 */:
                        try {
                            this.f11650K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11650K);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f11650K) == -2) {
                                this.f11650K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f11652M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11652M);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f11652M) == -2) {
                                this.f11652M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f11654O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f11654O));
                        this.f11648I = 2;
                        break;
                    case 36:
                        try {
                            this.f11651L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11651L);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f11651L) == -2) {
                                this.f11651L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f11653N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11653N);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f11653N) == -2) {
                                this.f11653N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f11655P = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f11655P));
                        this.f11649J = 2;
                        break;
                    default:
                        switch (i9) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f11641B = string;
                                this.f11642C = Float.NaN;
                                this.f11643D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f11641B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i7 = 0;
                                    } else {
                                        String strSubstring = this.f11641B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.f11643D = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.f11643D = 1;
                                        }
                                        i7 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f11641B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f11641B.substring(i7);
                                        if (strSubstring2.length() > 0) {
                                            this.f11642C = Float.parseFloat(strSubstring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String strSubstring3 = this.f11641B.substring(i7, iIndexOf2);
                                        String strSubstring4 = this.f11641B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                                            break;
                                        } else {
                                            try {
                                                float f8 = Float.parseFloat(strSubstring3);
                                                float f9 = Float.parseFloat(strSubstring4);
                                                if (f8 <= 0.0f || f9 <= 0.0f) {
                                                    break;
                                                } else if (this.f11643D == 1) {
                                                    this.f11642C = Math.abs(f9 / f8);
                                                    break;
                                                } else {
                                                    this.f11642C = Math.abs(f8 / f9);
                                                    break;
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 45:
                                this.f11644E = typedArrayObtainStyledAttributes.getFloat(index, this.f11644E);
                                break;
                            case 46:
                                this.f11645F = typedArrayObtainStyledAttributes.getFloat(index, this.f11645F);
                                break;
                            case 47:
                                this.f11646G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f11647H = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f11656Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11656Q);
                                break;
                            case 50:
                                this.f11657R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11657R);
                                break;
                            case 51:
                                this.f11661V = typedArrayObtainStyledAttributes.getString(index);
                                break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f11665Z = false;
            this.f11662W = true;
            this.f11663X = true;
            int i7 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i7 == -2 && this.f11659T) {
                this.f11662W = false;
                if (this.f11648I == 0) {
                    this.f11648I = 1;
                }
            }
            int i8 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i8 == -2 && this.f11660U) {
                this.f11663X = false;
                if (this.f11649J == 0) {
                    this.f11649J = 1;
                }
            }
            if (i7 == 0 || i7 == -1) {
                this.f11662W = false;
                if (i7 == 0 && this.f11648I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f11659T = true;
                }
            }
            if (i8 == 0 || i8 == -1) {
                this.f11663X = false;
                if (i8 == 0 && this.f11649J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f11660U = true;
                }
            }
            if (this.f11670c == -1.0f && this.f11666a == -1 && this.f11668b == -1) {
                return;
            }
            this.f11665Z = true;
            this.f11662W = true;
            this.f11663X = true;
            if (!(this.f11693n0 instanceof g)) {
                this.f11693n0 = new g();
            }
            ((g) this.f11693n0).O0(this.f11658S);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r10) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(int i7, int i8) {
            super(i7, i8);
            this.f11666a = -1;
            this.f11668b = -1;
            this.f11670c = -1.0f;
            this.f11672d = -1;
            this.f11674e = -1;
            this.f11676f = -1;
            this.f11678g = -1;
            this.f11680h = -1;
            this.f11682i = -1;
            this.f11684j = -1;
            this.f11686k = -1;
            this.f11688l = -1;
            this.f11690m = -1;
            this.f11692n = 0;
            this.f11694o = 0.0f;
            this.f11696p = -1;
            this.f11697q = -1;
            this.f11698r = -1;
            this.f11699s = -1;
            this.f11700t = -1;
            this.f11701u = -1;
            this.f11702v = -1;
            this.f11703w = -1;
            this.f11704x = -1;
            this.f11705y = -1;
            this.f11706z = 0.5f;
            this.f11640A = 0.5f;
            this.f11641B = null;
            this.f11642C = 0.0f;
            this.f11643D = 1;
            this.f11644E = -1.0f;
            this.f11645F = -1.0f;
            this.f11646G = 0;
            this.f11647H = 0;
            this.f11648I = 0;
            this.f11649J = 0;
            this.f11650K = 0;
            this.f11651L = 0;
            this.f11652M = 0;
            this.f11653N = 0;
            this.f11654O = 1.0f;
            this.f11655P = 1.0f;
            this.f11656Q = -1;
            this.f11657R = -1;
            this.f11658S = -1;
            this.f11659T = false;
            this.f11660U = false;
            this.f11661V = null;
            this.f11662W = true;
            this.f11663X = true;
            this.f11664Y = false;
            this.f11665Z = false;
            this.f11667a0 = false;
            this.f11669b0 = false;
            this.f11671c0 = false;
            this.f11673d0 = -1;
            this.f11675e0 = -1;
            this.f11677f0 = -1;
            this.f11679g0 = -1;
            this.f11681h0 = -1;
            this.f11683i0 = -1;
            this.f11685j0 = 0.5f;
            this.f11693n0 = new e();
            this.f11695o0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f11666a = -1;
            this.f11668b = -1;
            this.f11670c = -1.0f;
            this.f11672d = -1;
            this.f11674e = -1;
            this.f11676f = -1;
            this.f11678g = -1;
            this.f11680h = -1;
            this.f11682i = -1;
            this.f11684j = -1;
            this.f11686k = -1;
            this.f11688l = -1;
            this.f11690m = -1;
            this.f11692n = 0;
            this.f11694o = 0.0f;
            this.f11696p = -1;
            this.f11697q = -1;
            this.f11698r = -1;
            this.f11699s = -1;
            this.f11700t = -1;
            this.f11701u = -1;
            this.f11702v = -1;
            this.f11703w = -1;
            this.f11704x = -1;
            this.f11705y = -1;
            this.f11706z = 0.5f;
            this.f11640A = 0.5f;
            this.f11641B = null;
            this.f11642C = 0.0f;
            this.f11643D = 1;
            this.f11644E = -1.0f;
            this.f11645F = -1.0f;
            this.f11646G = 0;
            this.f11647H = 0;
            this.f11648I = 0;
            this.f11649J = 0;
            this.f11650K = 0;
            this.f11651L = 0;
            this.f11652M = 0;
            this.f11653N = 0;
            this.f11654O = 1.0f;
            this.f11655P = 1.0f;
            this.f11656Q = -1;
            this.f11657R = -1;
            this.f11658S = -1;
            this.f11659T = false;
            this.f11660U = false;
            this.f11661V = null;
            this.f11662W = true;
            this.f11663X = true;
            this.f11664Y = false;
            this.f11665Z = false;
            this.f11667a0 = false;
            this.f11669b0 = false;
            this.f11671c0 = false;
            this.f11673d0 = -1;
            this.f11675e0 = -1;
            this.f11677f0 = -1;
            this.f11679g0 = -1;
            this.f11681h0 = -1;
            this.f11683i0 = -1;
            this.f11685j0 = 0.5f;
            this.f11693n0 = new e();
            this.f11695o0 = false;
        }
    }
}
