package q;

import Z.C0691e0;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import c0.C0894f;
import i.AbstractC1145a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import l.AbstractC1291a;

/* loaded from: classes.dex */
public class O extends ListView {

    /* renamed from: l, reason: collision with root package name */
    public final Rect f21094l;

    /* renamed from: m, reason: collision with root package name */
    public int f21095m;

    /* renamed from: n, reason: collision with root package name */
    public int f21096n;

    /* renamed from: o, reason: collision with root package name */
    public int f21097o;

    /* renamed from: p, reason: collision with root package name */
    public int f21098p;

    /* renamed from: q, reason: collision with root package name */
    public int f21099q;

    /* renamed from: r, reason: collision with root package name */
    public d f21100r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f21101s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21102t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f21103u;

    /* renamed from: v, reason: collision with root package name */
    public C0691e0 f21104v;

    /* renamed from: w, reason: collision with root package name */
    public C0894f f21105w;

    /* renamed from: x, reason: collision with root package name */
    public f f21106x;

    public static class a {
        public static void a(View view, float f7, float f8) {
            view.drawableHotspotChanged(f7, f8);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static Method f21107a;

        /* renamed from: b, reason: collision with root package name */
        public static Method f21108b;

        /* renamed from: c, reason: collision with root package name */
        public static Method f21109c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f21110d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f21107a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f21108b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f21109c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f21110d = true;
            } catch (NoSuchMethodException e7) {
                e7.printStackTrace();
            }
        }

        public static boolean a() {
            return f21110d;
        }

        public static void b(O o7, int i7, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                f21107a.invoke(o7, Integer.valueOf(i7), view, Boolean.FALSE, -1, -1);
                f21108b.invoke(o7, Integer.valueOf(i7));
                f21109c.invoke(o7, Integer.valueOf(i7));
            } catch (IllegalAccessException e7) {
                e7.printStackTrace();
            } catch (InvocationTargetException e8) {
                e8.printStackTrace();
            }
        }
    }

    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z7) {
            absListView.setSelectedChildViewEnabled(z7);
        }
    }

    public static class d extends AbstractC1291a {

        /* renamed from: m, reason: collision with root package name */
        public boolean f21111m;

        public d(Drawable drawable) {
            super(drawable);
            this.f21111m = true;
        }

        public void b(boolean z7) {
            this.f21111m = z7;
        }

        @Override // l.AbstractC1291a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f21111m) {
                super.draw(canvas);
            }
        }

        @Override // l.AbstractC1291a, android.graphics.drawable.Drawable
        public void setHotspot(float f7, float f8) {
            if (this.f21111m) {
                super.setHotspot(f7, f8);
            }
        }

        @Override // l.AbstractC1291a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i7, int i8, int i9, int i10) {
            if (this.f21111m) {
                super.setHotspotBounds(i7, i8, i9, i10);
            }
        }

        @Override // l.AbstractC1291a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f21111m) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // l.AbstractC1291a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z7, boolean z8) {
            if (this.f21111m) {
                return super.setVisible(z7, z8);
            }
            return false;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final Field f21112a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e7) {
                e7.printStackTrace();
            }
            f21112a = declaredField;
        }

        public static boolean a(AbsListView absListView) {
            Field field = f21112a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e7) {
                e7.printStackTrace();
                return false;
            }
        }

        public static void b(AbsListView absListView, boolean z7) throws IllegalAccessException, IllegalArgumentException {
            Field field = f21112a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z7));
                } catch (IllegalAccessException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void a() {
            O o7 = O.this;
            o7.f21106x = null;
            o7.removeCallbacks(this);
        }

        public void b() {
            O.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            O o7 = O.this;
            o7.f21106x = null;
            o7.drawableStateChanged();
        }
    }

    public O(Context context, boolean z7) {
        super(context, null, AbstractC1145a.f16953x);
        this.f21094l = new Rect();
        this.f21095m = 0;
        this.f21096n = 0;
        this.f21097o = 0;
        this.f21098p = 0;
        this.f21102t = z7;
        setCacheColorHint(0);
    }

    public final void a() {
        this.f21103u = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f21099q - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        C0691e0 c0691e0 = this.f21104v;
        if (c0691e0 != null) {
            c0691e0.c();
            this.f21104v = null;
        }
    }

    public final void b(View view, int i7) {
        performItemClick(view, i7, getItemIdAtPosition(i7));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f21094l.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f21094l);
        selector.draw(canvas);
    }

    public int d(int i7, int i8, int i9, int i10, int i11) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        View view = null;
        while (i12 < count) {
            int itemViewType = adapter.getItemViewType(i12);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            view = adapter.getView(i12, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i15 = layoutParams.height;
            view.measure(i7, i15 > 0 ? View.MeasureSpec.makeMeasureSpec(i15, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i12 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i10) {
                return (i11 < 0 || i12 <= i11 || i14 <= 0 || measuredHeight == i10) ? i10 : i14;
            }
            if (i11 >= 0 && i12 >= i11) {
                i14 = measuredHeight;
            }
            i12++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f21106x != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            c0.f r9 = r7.f21105w
            if (r9 != 0) goto L5a
            c0.f r9 = new c0.f
            r9.<init>(r7)
            r7.f21105w = r9
        L5a:
            c0.f r9 = r7.f21105w
            r9.m(r1)
            c0.f r9 = r7.f21105w
            r9.onTouch(r7, r8)
            return r3
        L65:
            c0.f r8 = r7.f21105w
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q.O.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i7, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f21094l;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f21095m;
        rect.top -= this.f21096n;
        rect.right += this.f21097o;
        rect.bottom += this.f21098p;
        boolean zK = k();
        if (view.isEnabled() != zK) {
            l(!zK);
            if (i7 != -1) {
                refreshDrawableState();
            }
        }
    }

    public final void g(int i7, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z7 = (selector == null || i7 == -1) ? false : true;
        if (z7) {
            selector.setVisible(false, false);
        }
        f(i7, view);
        if (z7) {
            Rect rect = this.f21094l;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            P.a.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    public final void h(int i7, View view, float f7, float f8) throws IllegalAccessException, IllegalArgumentException {
        g(i7, view);
        Drawable selector = getSelector();
        if (selector == null || i7 == -1) {
            return;
        }
        P.a.k(selector, f7, f8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f21102t || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f21102t || super.hasWindowFocus();
    }

    public final void i(View view, int i7, float f7, float f8) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.f21103u = true;
        a.a(this, f7, f8);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i8 = this.f21099q;
        if (i8 != -1 && (childAt = getChildAt(i8 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f21099q = i7;
        a.a(view, f7 - view.getLeft(), f8 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i7, view, f7, f8);
        j(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f21102t || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f21102t && this.f21101s) || super.isInTouchMode();
    }

    public final void j(boolean z7) {
        d dVar = this.f21100r;
        if (dVar != null) {
            dVar.b(z7);
        }
    }

    public final boolean k() {
        return V.c.d() ? c.a(this) : e.a(this);
    }

    public final void l(boolean z7) throws IllegalAccessException, IllegalArgumentException {
        if (V.c.d()) {
            c.b(this, z7);
        } else {
            e.b(this, z7);
        }
    }

    public final boolean m() {
        return this.f21103u;
    }

    public final void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f21106x = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f21106x == null) {
            f fVar = new f();
            this.f21106x = fVar;
            fVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return zOnHoverEvent;
        }
        int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i7 < 30 || !b.a()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                } else {
                    b.b(this, iPointToPosition, childAt);
                }
            }
            n();
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f21099q = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f21106x;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z7) {
        this.f21101s = z7;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f21100r = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f21095m = rect.left;
        this.f21096n = rect.top;
        this.f21097o = rect.right;
        this.f21098p = rect.bottom;
    }
}
