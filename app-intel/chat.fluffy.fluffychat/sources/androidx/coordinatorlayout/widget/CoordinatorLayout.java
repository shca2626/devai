package androidx.coordinatorlayout.widget;

import Z.AbstractC0719v;
import Z.C0702j0;
import Z.F;
import Z.G;
import Z.H;
import Z.I;
import Z.W;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import e0.AbstractC1009a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements F, G {

    /* renamed from: F, reason: collision with root package name */
    public static final String f11841F;

    /* renamed from: G, reason: collision with root package name */
    public static final Class[] f11842G;

    /* renamed from: H, reason: collision with root package name */
    public static final ThreadLocal f11843H;

    /* renamed from: I, reason: collision with root package name */
    public static final Comparator f11844I;

    /* renamed from: J, reason: collision with root package name */
    public static final Y.e f11845J;

    /* renamed from: A, reason: collision with root package name */
    public boolean f11846A;

    /* renamed from: B, reason: collision with root package name */
    public Drawable f11847B;

    /* renamed from: C, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f11848C;

    /* renamed from: D, reason: collision with root package name */
    public I f11849D;

    /* renamed from: E, reason: collision with root package name */
    public final H f11850E;

    /* renamed from: l, reason: collision with root package name */
    public final List f11851l;

    /* renamed from: m, reason: collision with root package name */
    public final I.b f11852m;

    /* renamed from: n, reason: collision with root package name */
    public final List f11853n;

    /* renamed from: o, reason: collision with root package name */
    public final List f11854o;

    /* renamed from: p, reason: collision with root package name */
    public Paint f11855p;

    /* renamed from: q, reason: collision with root package name */
    public final int[] f11856q;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f11857r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11858s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f11859t;

    /* renamed from: u, reason: collision with root package name */
    public int[] f11860u;

    /* renamed from: v, reason: collision with root package name */
    public View f11861v;

    /* renamed from: w, reason: collision with root package name */
    public View f11862w;

    /* renamed from: x, reason: collision with root package name */
    public f f11863x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f11864y;

    /* renamed from: z, reason: collision with root package name */
    public C0702j0 f11865z;

    public class a implements I {
        public a() {
        }

        @Override // Z.I
        public C0702j0 a(View view, C0702j0 c0702j0) {
            return CoordinatorLayout.this.U(c0702j0);
        }
    }

    public static abstract class b {
        public b() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
            if (i8 == 0) {
                return z(coordinatorLayout, view, view2, view3, i7);
            }
            return false;
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i7) {
            if (i7 == 0) {
                B(coordinatorLayout, view, view2);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            return d(coordinatorLayout, view) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void g(e eVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9, int i10) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2, float f7, float f8, boolean z7) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f7, float f8) {
            return false;
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int[] iArr, int i9) {
            if (i9 == 0) {
                p(coordinatorLayout, view, view2, i7, i8, iArr);
            }
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10) {
        }

        public void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10, int i11) {
            if (i11 == 0) {
                r(coordinatorLayout, view, view2, i7, i8, i9, i10);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
            iArr[0] = iArr[0] + i9;
            iArr[1] = iArr[1] + i10;
            s(coordinatorLayout, view, view2, i7, i8, i9, i10, i11);
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7) {
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
            if (i8 == 0) {
                u(coordinatorLayout, view, view2, view3, i7);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z7) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7) {
            return false;
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public C0702j0 f(CoordinatorLayout coordinatorLayout, View view, C0702j0 c0702j0) {
            return c0702j0;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class value();
    }

    public class d implements ViewGroup.OnHierarchyChangeListener {
        public d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f11848C;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.F(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f11848C;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class f implements ViewTreeObserver.OnPreDrawListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.F(0);
            return true;
        }
    }

    public static class h implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fK = W.K(view);
            float fK2 = W.K(view2);
            if (fK > fK2) {
                return -1;
            }
            return fK < fK2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f11841F = r02 != null ? r02.getName() : null;
        f11844I = new h();
        f11842G = new Class[]{Context.class, AttributeSet.class};
        f11843H = new ThreadLocal();
        f11845J = new Y.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H.a.f3297a);
    }

    public static b I(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f11841F;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f11843H;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f11842G);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(context, attributeSet);
        } catch (Exception e7) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e7);
        }
    }

    public static void M(Rect rect) {
        rect.setEmpty();
        f11845J.a(rect);
    }

    public static int P(int i7) {
        if (i7 == 0) {
            return 17;
        }
        return i7;
    }

    public static int Q(int i7) {
        if ((i7 & 7) == 0) {
            i7 |= 8388611;
        }
        return (i7 & 112) == 0 ? i7 | 48 : i7;
    }

    public static int R(int i7) {
        if (i7 == 0) {
            return 8388661;
        }
        return i7;
    }

    public static Rect a() {
        Rect rect = (Rect) f11845J.b();
        return rect == null ? new Rect() : rect;
    }

    private static int c(int i7, int i8, int i9) {
        return i7 < i8 ? i8 : i7 > i9 ? i9 : i7;
    }

    public final void A(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        Rect rectA = a();
        rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.f11865z != null && W.x(this) && !W.x(view)) {
            rectA.left += this.f11865z.j();
            rectA.top += this.f11865z.l();
            rectA.right -= this.f11865z.k();
            rectA.bottom -= this.f11865z.i();
        }
        Rect rectA2 = a();
        AbstractC0719v.a(Q(eVar.f11870c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i7);
        view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        M(rectA);
        M(rectA2);
    }

    public final void B(View view, View view2, int i7) {
        Rect rectA = a();
        Rect rectA2 = a();
        try {
            r(view2, rectA);
            s(view, i7, rectA, rectA2);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        } finally {
            M(rectA);
            M(rectA2);
        }
    }

    public final void C(View view, int i7, int i8) {
        e eVar = (e) view.getLayoutParams();
        int iB = AbstractC0719v.b(R(eVar.f11870c), i8);
        int i9 = iB & 7;
        int i10 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i8 == 1) {
            i7 = width - i7;
        }
        int iU = u(i7) - measuredWidth;
        if (i9 == 1) {
            iU += measuredWidth / 2;
        } else if (i9 == 5) {
            iU += measuredWidth;
        }
        int i11 = i10 != 16 ? i10 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(iU, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i11, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    public final void D(View view, Rect rect, int i7) {
        boolean z7;
        boolean z8;
        int width;
        int i8;
        int i9;
        int i10;
        int height;
        int i11;
        int i12;
        int i13;
        if (W.Q(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b bVarE = eVar.e();
            Rect rectA = a();
            Rect rectA2 = a();
            rectA2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (bVarE == null || !bVarE.b(this, view, rectA)) {
                rectA.set(rectA2);
            } else if (!rectA2.contains(rectA)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA.toShortString() + " | Bounds:" + rectA2.toShortString());
            }
            M(rectA2);
            if (rectA.isEmpty()) {
                M(rectA);
                return;
            }
            int iB = AbstractC0719v.b(eVar.f11875h, i7);
            boolean z9 = true;
            if ((iB & 48) != 48 || (i12 = (rectA.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.f11877j) >= (i13 = rect.top)) {
                z7 = false;
            } else {
                T(view, i13 - i12);
                z7 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectA.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.f11877j) < (i11 = rect.bottom)) {
                T(view, height - i11);
                z7 = true;
            }
            if (!z7) {
                T(view, 0);
            }
            if ((iB & 3) != 3 || (i9 = (rectA.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.f11876i) >= (i10 = rect.left)) {
                z8 = false;
            } else {
                S(view, i10 - i9);
                z8 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectA.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.f11876i) >= (i8 = rect.right)) {
                z9 = z8;
            } else {
                S(view, width - i8);
            }
            if (!z9) {
                S(view, 0);
            }
            M(rectA);
        }
    }

    public void E(View view, int i7) {
        b bVarE;
        e eVar = (e) view.getLayoutParams();
        if (eVar.f11878k != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            Rect rectA3 = a();
            r(eVar.f11878k, rectA);
            p(view, false, rectA2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            t(view, i7, rectA, rectA3, eVar, measuredWidth, measuredHeight);
            boolean z7 = (rectA3.left == rectA2.left && rectA3.top == rectA2.top) ? false : true;
            d(eVar, rectA3, measuredWidth, measuredHeight);
            int i8 = rectA3.left - rectA2.left;
            int i9 = rectA3.top - rectA2.top;
            if (i8 != 0) {
                W.V(view, i8);
            }
            if (i9 != 0) {
                W.W(view, i9);
            }
            if (z7 && (bVarE = eVar.e()) != null) {
                bVarE.h(this, view, eVar.f11878k);
            }
            M(rectA);
            M(rectA2);
            M(rectA3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.F(int):void");
    }

    public void G(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = eVar.f11878k;
        if (view2 != null) {
            B(view, view2, i7);
            return;
        }
        int i8 = eVar.f11872e;
        if (i8 >= 0) {
            C(view, i8, i7);
        } else {
            A(view, i7);
        }
    }

    public void H(View view, int i7, int i8, int i9, int i10) {
        measureChildWithMargins(view, i7, i8, i9, i10);
    }

    public final boolean J(MotionEvent motionEvent, int i7) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f11853n;
        x(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            View view = (View) list.get(i8);
            e eVar = (e) view.getLayoutParams();
            b bVarE = eVar.e();
            if (!(zK || z7) || actionMasked == 0) {
                if (!zK && bVarE != null) {
                    if (i7 == 0) {
                        zK = bVarE.k(this, view, motionEvent);
                    } else if (i7 == 1) {
                        zK = bVarE.D(this, view, motionEvent);
                    }
                    if (zK) {
                        this.f11861v = view;
                    }
                }
                boolean zC = eVar.c();
                boolean zH = eVar.h(this, view);
                z7 = zH && !zC;
                if (zH && !z7) {
                    break;
                }
            } else if (bVarE != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i7 == 0) {
                    bVarE.k(this, view, motionEventObtain);
                } else if (i7 == 1) {
                    bVarE.D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    public final void K() {
        this.f11851l.clear();
        this.f11852m.c();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            e eVarW = w(childAt);
            eVarW.d(this, childAt);
            this.f11852m.b(childAt);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (i8 != i7) {
                    View childAt2 = getChildAt(i8);
                    if (eVarW.b(this, childAt, childAt2)) {
                        if (!this.f11852m.d(childAt2)) {
                            this.f11852m.b(childAt2);
                        }
                        this.f11852m.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f11851l.addAll(this.f11852m.h());
        Collections.reverse(this.f11851l);
    }

    public void L(View view, Rect rect) {
        ((e) view.getLayoutParams()).p(rect);
    }

    public void N() {
        if (this.f11859t && this.f11863x != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f11863x);
        }
        this.f11864y = false;
    }

    public final void O(boolean z7) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            b bVarE = ((e) childAt.getLayoutParams()).e();
            if (bVarE != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z7) {
                    bVarE.k(this, childAt, motionEventObtain);
                } else {
                    bVarE.D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            ((e) getChildAt(i8).getLayoutParams()).l();
        }
        this.f11861v = null;
        this.f11858s = false;
    }

    public final void S(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        int i8 = eVar.f11876i;
        if (i8 != i7) {
            W.V(view, i7 - i8);
            eVar.f11876i = i7;
        }
    }

    public final void T(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        int i8 = eVar.f11877j;
        if (i8 != i7) {
            W.W(view, i7 - i8);
            eVar.f11877j = i7;
        }
    }

    public final C0702j0 U(C0702j0 c0702j0) {
        if (Y.c.a(this.f11865z, c0702j0)) {
            return c0702j0;
        }
        this.f11865z = c0702j0;
        boolean z7 = false;
        boolean z8 = c0702j0 != null && c0702j0.l() > 0;
        this.f11846A = z8;
        if (!z8 && getBackground() == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        C0702j0 c0702j0E = e(c0702j0);
        requestLayout();
        return c0702j0E;
    }

    public final void V() {
        if (!W.x(this)) {
            W.z0(this, null);
            return;
        }
        if (this.f11849D == null) {
            this.f11849D = new a();
        }
        W.z0(this, this.f11849D);
        setSystemUiVisibility(1280);
    }

    public void b() {
        if (this.f11859t) {
            if (this.f11863x == null) {
                this.f11863x = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f11863x);
        }
        this.f11864y = true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    public final void d(e eVar, Rect rect, int i7, int i8) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i7) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i8) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(iMax, iMax2, i7 + iMax, i8 + iMax2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean drawChild(android.graphics.Canvas r17, android.view.View r18, long r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r2 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r2
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r3 = r2.f11868a
            if (r3 == 0) goto L8f
            float r3 = r3.d(r0, r1)
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L8f
            android.graphics.Paint r4 = r0.f11855p
            if (r4 != 0) goto L22
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r0.f11855p = r4
        L22:
            android.graphics.Paint r4 = r0.f11855p
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r2 = r2.f11868a
            int r2 = r2.c(r0, r1)
            r4.setColor(r2)
            android.graphics.Paint r2 = r0.f11855p
            r4 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            r4 = 0
            r5 = 255(0xff, float:3.57E-43)
            int r3 = c(r3, r4, r5)
            r2.setAlpha(r3)
            int r2 = r17.save()
            boolean r3 = r1.isOpaque()
            if (r3 == 0) goto L65
            int r3 = r1.getLeft()
            float r5 = (float) r3
            int r3 = r1.getTop()
            float r6 = (float) r3
            int r3 = r1.getRight()
            float r7 = (float) r3
            int r3 = r1.getBottom()
            float r8 = (float) r3
            android.graphics.Region$Op r9 = android.graphics.Region.Op.DIFFERENCE
            r4 = r17
            r4.clipRect(r5, r6, r7, r8, r9)
        L65:
            int r3 = r0.getPaddingLeft()
            float r11 = (float) r3
            int r3 = r0.getPaddingTop()
            float r12 = (float) r3
            int r3 = r0.getWidth()
            int r4 = r0.getPaddingRight()
            int r3 = r3 - r4
            float r13 = (float) r3
            int r3 = r0.getHeight()
            int r4 = r0.getPaddingBottom()
            int r3 = r3 - r4
            float r14 = (float) r3
            android.graphics.Paint r15 = r0.f11855p
            r10 = r17
            r10.drawRect(r11, r12, r13, r14, r15)
            r4 = r10
            r4.restoreToCount(r2)
            goto L91
        L8f:
            r4 = r17
        L91:
            boolean r1 = super.drawChild(r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f11847B;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final C0702j0 e(C0702j0 c0702j0) {
        b bVarE;
        if (c0702j0.p()) {
            return c0702j0;
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (W.x(childAt) && (bVarE = ((e) childAt.getLayoutParams()).e()) != null) {
                c0702j0 = bVarE.f(this, childAt, c0702j0);
                if (c0702j0.p()) {
                    return c0702j0;
                }
            }
        }
        return c0702j0;
    }

    public void f() {
        int childCount = getChildCount();
        boolean z7 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= childCount) {
                break;
            }
            if (y(getChildAt(i7))) {
                z7 = true;
                break;
            }
            i7++;
        }
        if (z7 != this.f11864y) {
            if (z7) {
                b();
            } else {
                N();
            }
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    public final List<View> getDependencySortedChildren() {
        K();
        return Collections.unmodifiableList(this.f11851l);
    }

    public final C0702j0 getLastWindowInsets() {
        return this.f11865z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f11850E.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f11847B;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // Z.G
    public void j(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        b bVarE;
        int childCount = getChildCount();
        boolean z7 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i11) && (bVarE = eVar.e()) != null) {
                    int[] iArr2 = this.f11856q;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVarE.t(this, childAt, view, i7, i8, i9, i10, i11, iArr2);
                    int[] iArr3 = this.f11856q;
                    iMax = i9 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f11856q;
                    iMax2 = i10 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z7 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z7) {
            F(1);
        }
    }

    @Override // Z.F
    public void k(View view, int i7, int i8, int i9, int i10, int i11) {
        j(view, i7, i8, i9, i10, 0, this.f11857r);
    }

    @Override // Z.F
    public boolean l(View view, View view2, int i7, int i8) {
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b bVarE = eVar.e();
                if (bVarE != null) {
                    boolean zA = bVarE.A(this, childAt, view, view2, i7, i8);
                    z7 |= zA;
                    eVar.q(i8, zA);
                } else {
                    eVar.q(i8, false);
                }
            }
        }
        return z7;
    }

    @Override // Z.F
    public void m(View view, View view2, int i7, int i8) {
        b bVarE;
        View view3;
        View view4;
        int i9;
        int i10;
        this.f11850E.c(view, view2, i7, i8);
        this.f11862w = view2;
        int childCount = getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i8) && (bVarE = eVar.e()) != null) {
                view3 = view;
                view4 = view2;
                i9 = i7;
                i10 = i8;
                bVarE.v(this, childAt, view3, view4, i9, i10);
            } else {
                view3 = view;
                view4 = view2;
                i9 = i7;
                i10 = i8;
            }
            i11++;
            view = view3;
            view2 = view4;
            i7 = i9;
            i8 = i10;
        }
    }

    @Override // Z.F
    public void n(View view, int i7) {
        this.f11850E.d(view, i7);
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i7)) {
                b bVarE = eVar.e();
                if (bVarE != null) {
                    bVarE.C(this, childAt, view, i7);
                }
                eVar.k(i7);
                eVar.j();
            }
        }
        this.f11862w = null;
    }

    @Override // Z.F
    public void o(View view, int i7, int i8, int[] iArr, int i9) {
        b bVarE;
        int childCount = getChildCount();
        boolean z7 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i9) && (bVarE = eVar.e()) != null) {
                    int[] iArr2 = this.f11856q;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVarE.q(this, childAt, view, i7, i8, iArr2, i9);
                    int[] iArr3 = this.f11856q;
                    iMax = i7 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f11856q;
                    iMax2 = i8 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z7 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z7) {
            F(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O(false);
        if (this.f11864y) {
            if (this.f11863x == null) {
                this.f11863x = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f11863x);
        }
        if (this.f11865z == null && W.x(this)) {
            W.i0(this);
        }
        this.f11859t = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O(false);
        if (this.f11864y && this.f11863x != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f11863x);
        }
        View view = this.f11862w;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f11859t = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f11846A || this.f11847B == null) {
            return;
        }
        C0702j0 c0702j0 = this.f11865z;
        int iL = c0702j0 != null ? c0702j0.l() : 0;
        if (iL > 0) {
            this.f11847B.setBounds(0, 0, getWidth(), iL);
            this.f11847B.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            O(true);
        }
        boolean zJ = J(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zJ;
        }
        O(true);
        return zJ;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        b bVarE;
        int iA = W.A(this);
        int size = this.f11851l.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f11851l.get(i11);
            if (view.getVisibility() != 8 && ((bVarE = ((e) view.getLayoutParams()).e()) == null || !bVarE.l(this, view, iA))) {
                G(view, iA);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onNestedFling(android.view.View r12, float r13, float r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3f
            android.view.View r6 = r11.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1b
        L15:
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            goto L38
        L1b:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r4
            boolean r5 = r4.i(r1)
            if (r5 != 0) goto L28
            goto L15
        L28:
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r4 = r4.e()
            if (r4 == 0) goto L15
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            boolean r12 = r4.n(r5, r6, r7, r8, r9, r10)
            r3 = r3 | r12
        L38:
            int r2 = r2 + 1
            r12 = r7
            r13 = r8
            r14 = r9
            r15 = r10
            goto L7
        L3f:
            r5 = r11
            if (r3 == 0) goto L46
            r12 = 1
            r11.F(r12)
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onNestedFling(android.view.View, float, float, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onNestedPreFling(android.view.View r11, float r12, float r13) {
        /*
            r10 = this;
            int r0 = r10.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3b
            android.view.View r6 = r10.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L19
        L15:
            r7 = r11
            r8 = r12
            r9 = r13
            goto L35
        L19:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r4
            boolean r5 = r4.i(r1)
            if (r5 != 0) goto L26
            goto L15
        L26:
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r4 = r4.e()
            if (r4 == 0) goto L15
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            boolean r11 = r4.o(r5, r6, r7, r8, r9)
            r3 = r3 | r11
        L35:
            int r2 = r2 + 1
            r11 = r7
            r12 = r8
            r13 = r9
            goto L7
        L3b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onNestedPreFling(android.view.View, float, float):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
        o(view, i7, i8, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        k(view, i7, i8, i9, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i7) {
        m(view, view2, i7, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.b());
        SparseArray sparseArray = gVar.f11887n;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            b bVarE = w(childAt).e();
            if (id != -1 && bVarE != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                bVarE.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableY;
        g gVar = new g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            b bVarE = ((e) childAt.getLayoutParams()).e();
            if (id != -1 && bVarE != null && (parcelableY = bVarE.y(this, childAt)) != null) {
                sparseArray.append(id, parcelableY);
            }
        }
        gVar.f11887n = sparseArray;
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i7) {
        return l(view, view2, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        n(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f11861v
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.J(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f11861v
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r6 = r6.e()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f11861v
            boolean r6 = r6.D(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f11861v
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L56
            r1 = 3
            if (r2 != r1) goto L55
            goto L56
        L55:
            return r6
        L56:
            r0.O(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(View view, boolean z7, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z7) {
            r(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List q(View view) {
        List listG = this.f11852m.g(view);
        this.f11854o.clear();
        if (listG != null) {
            this.f11854o.addAll(listG);
        }
        return this.f11854o;
    }

    public void r(View view, Rect rect) {
        I.c.a(this, view, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        b bVarE = ((e) view.getLayoutParams()).e();
        if (bVarE == null || !bVarE.w(this, view, rect, z7)) {
            return super.requestChildRectangleOnScreen(view, rect, z7);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (!z7 || this.f11858s) {
            return;
        }
        O(false);
        this.f11858s = true;
    }

    public void s(View view, int i7, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        t(view, i7, rect, rect2, eVar, measuredWidth, measuredHeight);
        d(eVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z7) {
        super.setFitsSystemWindows(z7);
        V();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f11848C = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f11847B;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f11847B = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f11847B.setState(getDrawableState());
                }
                P.a.m(this.f11847B, W.A(this));
                this.f11847B.setVisible(getVisibility() == 0, false);
                this.f11847B.setCallback(this);
            }
            W.c0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i7) {
        setStatusBarBackground(new ColorDrawable(i7));
    }

    public void setStatusBarBackgroundResource(int i7) {
        setStatusBarBackground(i7 != 0 ? L.b.d(getContext(), i7) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f11847B;
        if (drawable == null || drawable.isVisible() == z7) {
            return;
        }
        this.f11847B.setVisible(z7, false);
    }

    public final void t(View view, int i7, Rect rect, Rect rect2, e eVar, int i8, int i9) {
        int iB = AbstractC0719v.b(P(eVar.f11870c), i7);
        int iB2 = AbstractC0719v.b(Q(eVar.f11871d), i7);
        int i10 = iB & 7;
        int i11 = iB & 112;
        int i12 = iB2 & 7;
        int i13 = iB2 & 112;
        int iWidth = i12 != 1 ? i12 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i13 != 16 ? i13 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i10 == 1) {
            iWidth -= i8 / 2;
        } else if (i10 != 5) {
            iWidth -= i8;
        }
        if (i11 == 16) {
            iHeight -= i9 / 2;
        } else if (i11 != 80) {
            iHeight -= i9;
        }
        rect2.set(iWidth, iHeight, i8 + iWidth, i9 + iHeight);
    }

    public final int u(int i7) {
        int[] iArr = this.f11860u;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i7);
            return 0;
        }
        if (i7 >= 0 && i7 < iArr.length) {
            return iArr[i7];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i7 + " out of range for " + this);
        return 0;
    }

    public void v(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).g());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11847B;
    }

    public e w(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f11869b) {
            c cVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                cVar = (c) superclass.getAnnotation(c.class);
                if (cVar != null) {
                    break;
                }
            }
            if (cVar != null) {
                try {
                    eVar.n((b) cVar.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e7) {
                    Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e7);
                }
            }
            eVar.f11869b = true;
        }
        return eVar;
    }

    public final void x(List list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i7) : i7));
        }
        Comparator comparator = f11844I;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean y(View view) {
        return this.f11852m.i(view);
    }

    public boolean z(View view, int i7, int i8) {
        Rect rectA = a();
        r(view, rectA);
        try {
            return rectA.contains(i7, i8);
        } finally {
            M(rectA);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i7) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        super(context, attributeSet, i7);
        this.f11851l = new ArrayList();
        this.f11852m = new I.b();
        this.f11853n = new ArrayList();
        this.f11854o = new ArrayList();
        this.f11856q = new int[2];
        this.f11857r = new int[2];
        this.f11850E = new H(this);
        TypedArray typedArrayObtainStyledAttributes = i7 == 0 ? context.obtainStyledAttributes(attributeSet, H.c.f3300b, 0, H.b.f3298a) : context.obtainStyledAttributes(attributeSet, H.c.f3300b, i7, 0);
        if (Build.VERSION.SDK_INT < 29) {
            coordinatorLayout = this;
            context2 = context;
        } else if (i7 == 0) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, H.c.f3300b, attributeSet, typedArrayObtainStyledAttributes, 0, H.b.f3298a);
        } else {
            context2 = context;
            coordinatorLayout = this;
            coordinatorLayout.saveAttributeDataForStyleable(context2, H.c.f3300b, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(H.c.f3301c, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            coordinatorLayout.f11860u = resources.getIntArray(resourceId);
            float f7 = resources.getDisplayMetrics().density;
            int length = coordinatorLayout.f11860u.length;
            for (int i8 = 0; i8 < length; i8++) {
                coordinatorLayout.f11860u[i8] = (int) (r12[i8] * f7);
            }
        }
        coordinatorLayout.f11847B = typedArrayObtainStyledAttributes.getDrawable(H.c.f3302d);
        typedArrayObtainStyledAttributes.recycle();
        V();
        super.setOnHierarchyChangeListener(new d());
        if (W.y(this) == 0) {
            W.v0(this, 1);
        }
    }

    public static class g extends AbstractC1009a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public SparseArray f11887n;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i7) {
                return new g[i7];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i7 = parcel.readInt();
            int[] iArr = new int[i7];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f11887n = new SparseArray(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                this.f11887n.append(iArr[i8], parcelableArray[i8]);
            }
        }

        @Override // e0.AbstractC1009a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            SparseArray sparseArray = this.f11887n;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr[i8] = this.f11887n.keyAt(i8);
                parcelableArr[i8] = (Parcelable) this.f11887n.valueAt(i8);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i7);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public b f11868a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11869b;

        /* renamed from: c, reason: collision with root package name */
        public int f11870c;

        /* renamed from: d, reason: collision with root package name */
        public int f11871d;

        /* renamed from: e, reason: collision with root package name */
        public int f11872e;

        /* renamed from: f, reason: collision with root package name */
        public int f11873f;

        /* renamed from: g, reason: collision with root package name */
        public int f11874g;

        /* renamed from: h, reason: collision with root package name */
        public int f11875h;

        /* renamed from: i, reason: collision with root package name */
        public int f11876i;

        /* renamed from: j, reason: collision with root package name */
        public int f11877j;

        /* renamed from: k, reason: collision with root package name */
        public View f11878k;

        /* renamed from: l, reason: collision with root package name */
        public View f11879l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f11880m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f11881n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f11882o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f11883p;

        /* renamed from: q, reason: collision with root package name */
        public final Rect f11884q;

        /* renamed from: r, reason: collision with root package name */
        public Object f11885r;

        public e(int i7, int i8) {
            super(i7, i8);
            this.f11869b = false;
            this.f11870c = 0;
            this.f11871d = 0;
            this.f11872e = -1;
            this.f11873f = -1;
            this.f11874g = 0;
            this.f11875h = 0;
            this.f11884q = new Rect();
        }

        public boolean a() {
            return this.f11878k == null && this.f11873f != -1;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 == this.f11879l || r(view2, W.A(coordinatorLayout))) {
                return true;
            }
            b bVar = this.f11868a;
            return bVar != null && bVar.e(coordinatorLayout, view, view2);
        }

        public boolean c() {
            if (this.f11868a == null) {
                this.f11880m = false;
            }
            return this.f11880m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f11873f == -1) {
                this.f11879l = null;
                this.f11878k = null;
                return null;
            }
            if (this.f11878k == null || !s(view, coordinatorLayout)) {
                m(view, coordinatorLayout);
            }
            return this.f11878k;
        }

        public b e() {
            return this.f11868a;
        }

        public boolean f() {
            return this.f11883p;
        }

        public Rect g() {
            return this.f11884q;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view) {
            boolean z7 = this.f11880m;
            if (z7) {
                return true;
            }
            b bVar = this.f11868a;
            boolean zA = (bVar != null ? bVar.a(coordinatorLayout, view) : false) | z7;
            this.f11880m = zA;
            return zA;
        }

        public boolean i(int i7) {
            if (i7 == 0) {
                return this.f11881n;
            }
            if (i7 != 1) {
                return false;
            }
            return this.f11882o;
        }

        public void j() {
            this.f11883p = false;
        }

        public void k(int i7) {
            q(i7, false);
        }

        public void l() {
            this.f11880m = false;
        }

        public final void m(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f11873f);
            this.f11878k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f11879l = null;
                    this.f11878k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f11873f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f11879l = null;
                this.f11878k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f11879l = null;
                    this.f11878k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f11879l = viewFindViewById;
        }

        public void n(b bVar) {
            b bVar2 = this.f11868a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.j();
                }
                this.f11868a = bVar;
                this.f11885r = null;
                this.f11869b = true;
                if (bVar != null) {
                    bVar.g(this);
                }
            }
        }

        public void o(boolean z7) {
            this.f11883p = z7;
        }

        public void p(Rect rect) {
            this.f11884q.set(rect);
        }

        public void q(int i7, boolean z7) {
            if (i7 == 0) {
                this.f11881n = z7;
            } else {
                if (i7 != 1) {
                    return;
                }
                this.f11882o = z7;
            }
        }

        public final boolean r(View view, int i7) {
            int iB = AbstractC0719v.b(((e) view.getLayoutParams()).f11874g, i7);
            return iB != 0 && (AbstractC0719v.b(this.f11875h, i7) & iB) == iB;
        }

        public final boolean s(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f11878k.getId() != this.f11873f) {
                return false;
            }
            View view2 = this.f11878k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f11879l = null;
                    this.f11878k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f11879l = view2;
            return true;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11869b = false;
            this.f11870c = 0;
            this.f11871d = 0;
            this.f11872e = -1;
            this.f11873f = -1;
            this.f11874g = 0;
            this.f11875h = 0;
            this.f11884q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H.c.f3303e);
            this.f11870c = typedArrayObtainStyledAttributes.getInteger(H.c.f3304f, 0);
            this.f11873f = typedArrayObtainStyledAttributes.getResourceId(H.c.f3305g, -1);
            this.f11871d = typedArrayObtainStyledAttributes.getInteger(H.c.f3306h, 0);
            this.f11872e = typedArrayObtainStyledAttributes.getInteger(H.c.f3310l, -1);
            this.f11874g = typedArrayObtainStyledAttributes.getInt(H.c.f3309k, 0);
            this.f11875h = typedArrayObtainStyledAttributes.getInt(H.c.f3308j, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(H.c.f3307i);
            this.f11869b = zHasValue;
            if (zHasValue) {
                this.f11868a = CoordinatorLayout.I(context, attributeSet, typedArrayObtainStyledAttributes.getString(H.c.f3307i));
            }
            typedArrayObtainStyledAttributes.recycle();
            b bVar = this.f11868a;
            if (bVar != null) {
                bVar.g(this);
            }
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f11869b = false;
            this.f11870c = 0;
            this.f11871d = 0;
            this.f11872e = -1;
            this.f11873f = -1;
            this.f11874g = 0;
            this.f11875h = 0;
            this.f11884q = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f11869b = false;
            this.f11870c = 0;
            this.f11871d = 0;
            this.f11872e = -1;
            this.f11873f = -1;
            this.f11874g = 0;
            this.f11875h = 0;
            this.f11884q = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f11869b = false;
            this.f11870c = 0;
            this.f11871d = 0;
            this.f11872e = -1;
            this.f11873f = -1;
            this.f11874g = 0;
            this.f11875h = 0;
            this.f11884q = new Rect();
        }
    }
}
