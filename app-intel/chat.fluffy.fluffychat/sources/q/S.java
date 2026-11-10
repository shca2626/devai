package q;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import c0.AbstractC0895g;
import i.AbstractC1145a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class S implements p.f {

    /* renamed from: R, reason: collision with root package name */
    public static Method f21125R;

    /* renamed from: S, reason: collision with root package name */
    public static Method f21126S;

    /* renamed from: A, reason: collision with root package name */
    public View f21127A;

    /* renamed from: B, reason: collision with root package name */
    public int f21128B;

    /* renamed from: C, reason: collision with root package name */
    public DataSetObserver f21129C;

    /* renamed from: D, reason: collision with root package name */
    public View f21130D;

    /* renamed from: E, reason: collision with root package name */
    public Drawable f21131E;

    /* renamed from: F, reason: collision with root package name */
    public AdapterView.OnItemClickListener f21132F;

    /* renamed from: G, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f21133G;

    /* renamed from: H, reason: collision with root package name */
    public final i f21134H;

    /* renamed from: I, reason: collision with root package name */
    public final h f21135I;

    /* renamed from: J, reason: collision with root package name */
    public final g f21136J;

    /* renamed from: K, reason: collision with root package name */
    public final e f21137K;

    /* renamed from: L, reason: collision with root package name */
    public Runnable f21138L;

    /* renamed from: M, reason: collision with root package name */
    public final Handler f21139M;

    /* renamed from: N, reason: collision with root package name */
    public final Rect f21140N;

    /* renamed from: O, reason: collision with root package name */
    public Rect f21141O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f21142P;

    /* renamed from: Q, reason: collision with root package name */
    public PopupWindow f21143Q;

    /* renamed from: l, reason: collision with root package name */
    public Context f21144l;

    /* renamed from: m, reason: collision with root package name */
    public ListAdapter f21145m;

    /* renamed from: n, reason: collision with root package name */
    public O f21146n;

    /* renamed from: o, reason: collision with root package name */
    public int f21147o;

    /* renamed from: p, reason: collision with root package name */
    public int f21148p;

    /* renamed from: q, reason: collision with root package name */
    public int f21149q;

    /* renamed from: r, reason: collision with root package name */
    public int f21150r;

    /* renamed from: s, reason: collision with root package name */
    public int f21151s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21152t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f21153u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f21154v;

    /* renamed from: w, reason: collision with root package name */
    public int f21155w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f21156x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f21157y;

    /* renamed from: z, reason: collision with root package name */
    public int f21158z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            View viewT = S.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            S.this.b();
        }
    }

    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i7, boolean z7) {
            return popupWindow.getMaxAvailableHeight(view, i7, z7);
        }
    }

    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z7) {
            popupWindow.setIsClippedToScreen(z7);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            S.this.r();
        }
    }

    public class f extends DataSetObserver {
        public f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (S.this.a()) {
                S.this.b();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            S.this.dismiss();
        }
    }

    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = S.this.f21143Q) != null && popupWindow.isShowing() && x7 >= 0 && x7 < S.this.f21143Q.getWidth() && y7 >= 0 && y7 < S.this.f21143Q.getHeight()) {
                S s7 = S.this;
                s7.f21139M.postDelayed(s7.f21134H, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            S s8 = S.this;
            s8.f21139M.removeCallbacks(s8.f21134H);
            return false;
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            O o7 = S.this.f21146n;
            if (o7 == null || !Z.W.P(o7) || S.this.f21146n.getCount() <= S.this.f21146n.getChildCount()) {
                return;
            }
            int childCount = S.this.f21146n.getChildCount();
            S s7 = S.this;
            if (childCount <= s7.f21158z) {
                s7.f21143Q.setInputMethodMode(2);
                S.this.b();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f21125R = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f21126S = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public S(Context context) {
        this(context, null, AbstractC1145a.f16919B);
    }

    public boolean A() {
        return this.f21143Q.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.f21142P;
    }

    public final void C() {
        View view = this.f21127A;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f21127A);
            }
        }
    }

    public void D(View view) {
        this.f21130D = view;
    }

    public void E(int i7) {
        this.f21143Q.setAnimationStyle(i7);
    }

    public void F(int i7) {
        Drawable background = this.f21143Q.getBackground();
        if (background == null) {
            R(i7);
            return;
        }
        background.getPadding(this.f21140N);
        Rect rect = this.f21140N;
        this.f21148p = rect.left + rect.right + i7;
    }

    public void G(int i7) {
        this.f21155w = i7;
    }

    public void H(Rect rect) {
        this.f21141O = rect != null ? new Rect(rect) : null;
    }

    public void I(int i7) {
        this.f21143Q.setInputMethodMode(i7);
    }

    public void J(boolean z7) {
        this.f21142P = z7;
        this.f21143Q.setFocusable(z7);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.f21143Q.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f21132F = onItemClickListener;
    }

    public void M(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f21133G = onItemSelectedListener;
    }

    public void N(boolean z7) {
        this.f21154v = true;
        this.f21153u = z7;
    }

    public final void O(boolean z7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.f21143Q, z7);
            return;
        }
        Method method = f21125R;
        if (method != null) {
            try {
                method.invoke(this.f21143Q, Boolean.valueOf(z7));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void P(int i7) {
        this.f21128B = i7;
    }

    public void Q(int i7) {
        O o7 = this.f21146n;
        if (!a() || o7 == null) {
            return;
        }
        o7.setListSelectionHidden(false);
        o7.setSelection(i7);
        if (o7.getChoiceMode() != 0) {
            o7.setItemChecked(i7, true);
        }
    }

    public void R(int i7) {
        this.f21148p = i7;
    }

    @Override // p.f
    public boolean a() {
        return this.f21143Q.isShowing();
    }

    @Override // p.f
    public void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iQ = q();
        boolean zA = A();
        AbstractC0895g.b(this.f21143Q, this.f21151s);
        if (this.f21143Q.isShowing()) {
            if (Z.W.P(t())) {
                int width = this.f21148p;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i7 = this.f21147o;
                if (i7 == -1) {
                    if (!zA) {
                        iQ = -1;
                    }
                    if (zA) {
                        this.f21143Q.setWidth(this.f21148p == -1 ? -1 : 0);
                        this.f21143Q.setHeight(0);
                    } else {
                        this.f21143Q.setWidth(this.f21148p == -1 ? -1 : 0);
                        this.f21143Q.setHeight(-1);
                    }
                } else if (i7 != -2) {
                    iQ = i7;
                }
                this.f21143Q.setOutsideTouchable((this.f21157y || this.f21156x) ? false : true);
                this.f21143Q.update(t(), this.f21149q, this.f21150r, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.f21148p;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i8 = this.f21147o;
        if (i8 == -1) {
            iQ = -1;
        } else if (i8 != -2) {
            iQ = i8;
        }
        this.f21143Q.setWidth(width2);
        this.f21143Q.setHeight(iQ);
        O(true);
        this.f21143Q.setOutsideTouchable((this.f21157y || this.f21156x) ? false : true);
        this.f21143Q.setTouchInterceptor(this.f21135I);
        if (this.f21154v) {
            AbstractC0895g.a(this.f21143Q, this.f21153u);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f21126S;
            if (method != null) {
                try {
                    method.invoke(this.f21143Q, this.f21141O);
                } catch (Exception e7) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e7);
                }
            }
        } else {
            d.a(this.f21143Q, this.f21141O);
        }
        AbstractC0895g.c(this.f21143Q, t(), this.f21149q, this.f21150r, this.f21155w);
        this.f21146n.setSelection(-1);
        if (!this.f21142P || this.f21146n.isInTouchMode()) {
            r();
        }
        if (this.f21142P) {
            return;
        }
        this.f21139M.post(this.f21137K);
    }

    public int c() {
        return this.f21149q;
    }

    @Override // p.f
    public void dismiss() {
        this.f21143Q.dismiss();
        C();
        this.f21143Q.setContentView(null);
        this.f21146n = null;
        this.f21139M.removeCallbacks(this.f21134H);
    }

    public void e(int i7) {
        this.f21149q = i7;
    }

    public Drawable h() {
        return this.f21143Q.getBackground();
    }

    @Override // p.f
    public ListView j() {
        return this.f21146n;
    }

    public void k(Drawable drawable) {
        this.f21143Q.setBackgroundDrawable(drawable);
    }

    public void l(int i7) {
        this.f21150r = i7;
        this.f21152t = true;
    }

    public int o() {
        if (this.f21152t) {
            return this.f21150r;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f21129C;
        if (dataSetObserver == null) {
            this.f21129C = new f();
        } else {
            ListAdapter listAdapter2 = this.f21145m;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f21145m = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f21129C);
        }
        O o7 = this.f21146n;
        if (o7 != null) {
            o7.setAdapter(this.f21145m);
        }
    }

    public final int q() {
        int measuredHeight;
        int i7;
        int iMakeMeasureSpec;
        int i8;
        if (this.f21146n == null) {
            Context context = this.f21144l;
            this.f21138L = new a();
            O oS = s(context, !this.f21142P);
            this.f21146n = oS;
            Drawable drawable = this.f21131E;
            if (drawable != null) {
                oS.setSelector(drawable);
            }
            this.f21146n.setAdapter(this.f21145m);
            this.f21146n.setOnItemClickListener(this.f21132F);
            this.f21146n.setFocusable(true);
            this.f21146n.setFocusableInTouchMode(true);
            this.f21146n.setOnItemSelectedListener(new b());
            this.f21146n.setOnScrollListener(this.f21136J);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f21133G;
            if (onItemSelectedListener != null) {
                this.f21146n.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f21146n;
            View view2 = this.f21127A;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i9 = this.f21128B;
                if (i9 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i9 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f21128B);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i10 = this.f21148p;
                if (i10 >= 0) {
                    i8 = Integer.MIN_VALUE;
                } else {
                    i10 = 0;
                    i8 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i10, i8), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f21143Q.setContentView(view);
        } else {
            View view3 = this.f21127A;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f21143Q.getBackground();
        if (background != null) {
            background.getPadding(this.f21140N);
            Rect rect = this.f21140N;
            int i11 = rect.top;
            i7 = rect.bottom + i11;
            if (!this.f21152t) {
                this.f21150r = -i11;
            }
        } else {
            this.f21140N.setEmpty();
            i7 = 0;
        }
        int iU = u(t(), this.f21150r, this.f21143Q.getInputMethodMode() == 2);
        if (this.f21156x || this.f21147o == -1) {
            return iU + i7;
        }
        int i12 = this.f21148p;
        if (i12 == -2) {
            int i13 = this.f21144l.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f21140N;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i12 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else {
            int i14 = this.f21144l.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f21140N;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f21146n.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i7 + this.f21146n.getPaddingTop() + this.f21146n.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    public void r() {
        O o7 = this.f21146n;
        if (o7 != null) {
            o7.setListSelectionHidden(true);
            o7.requestLayout();
        }
    }

    public O s(Context context, boolean z7) {
        return new O(context, z7);
    }

    public View t() {
        return this.f21130D;
    }

    public final int u(View view, int i7, boolean z7) {
        return c.a(this.f21143Q, view, i7, z7);
    }

    public Object v() {
        if (a()) {
            return this.f21146n.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (a()) {
            return this.f21146n.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (a()) {
            return this.f21146n.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (a()) {
            return this.f21146n.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.f21148p;
    }

    public S(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public S(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f21147o = -2;
        this.f21148p = -2;
        this.f21151s = 1002;
        this.f21155w = 0;
        this.f21156x = false;
        this.f21157y = false;
        this.f21158z = Integer.MAX_VALUE;
        this.f21128B = 0;
        this.f21134H = new i();
        this.f21135I = new h();
        this.f21136J = new g();
        this.f21137K = new e();
        this.f21140N = new Rect();
        this.f21144l = context;
        this.f21139M = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.f17282l1, i7, i8);
        this.f21149q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.j.f17287m1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i.j.f17292n1, 0);
        this.f21150r = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f21152t = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C1481s c1481s = new C1481s(context, attributeSet, i7, i8);
        this.f21143Q = c1481s;
        c1481s.setInputMethodMode(1);
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i7, long j7) {
            O o7;
            if (i7 == -1 || (o7 = S.this.f21146n) == null) {
                return;
            }
            o7.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (i7 != 1 || S.this.A() || S.this.f21143Q.getContentView() == null) {
                return;
            }
            S s7 = S.this;
            s7.f21139M.removeCallbacks(s7.f21134H);
            S.this.f21134H.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
        }
    }
}
