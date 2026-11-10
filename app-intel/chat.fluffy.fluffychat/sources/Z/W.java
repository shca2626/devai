package Z;

import Z.C0682a;
import a0.InterfaceC0743A;
import a0.x;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class W {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f9968a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Field f9969b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9970c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f9971d = {J.e.f4323b, J.e.f4324c, J.e.f4335n, J.e.f4346y, J.e.f4303B, J.e.f4304C, J.e.f4305D, J.e.f4306E, J.e.f4307F, J.e.f4308G, J.e.f4325d, J.e.f4326e, J.e.f4327f, J.e.f4328g, J.e.f4329h, J.e.f4330i, J.e.f4331j, J.e.f4332k, J.e.f4333l, J.e.f4334m, J.e.f4336o, J.e.f4337p, J.e.f4338q, J.e.f4339r, J.e.f4340s, J.e.f4341t, J.e.f4342u, J.e.f4343v, J.e.f4344w, J.e.f4345x, J.e.f4347z, J.e.f4302A};

    /* renamed from: e, reason: collision with root package name */
    public static final K f9972e = new K() { // from class: Z.V
        @Override // Z.K
        public final C0688d a(C0688d c0688d) {
            return W.a(c0688d);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public static final e f9973f = new e();

    public class a extends f {
        public a(int i7, Class cls, int i8) {
            super(i7, cls, i8);
        }

        @Override // Z.W.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.c(view));
        }

        @Override // Z.W.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.f(view, bool.booleanValue());
        }

        @Override // Z.W.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public class b extends f {
        public b(int i7, Class cls, int i8, int i9) {
            super(i7, cls, i8, i9);
        }

        @Override // Z.W.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return k.a(view);
        }

        @Override // Z.W.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            k.e(view, charSequence);
        }

        @Override // Z.W.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class c extends f {
        public c(int i7, Class cls, int i8, int i9) {
            super(i7, cls, i8, i9);
        }

        @Override // Z.W.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return m.b(view);
        }

        @Override // Z.W.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            m.c(view, charSequence);
        }

        @Override // Z.W.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class d extends f {
        public d(int i7, Class cls, int i8) {
            super(i7, cls, i8);
        }

        @Override // Z.W.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.b(view));
        }

        @Override // Z.W.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.d(view, bool.booleanValue());
        }

        @Override // Z.W.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f9975a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f9976b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9977c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9978d;

        public f(int i7, Class cls, int i8) {
            this(i7, cls, 0, i8);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.f9977c;
        }

        public abstract Object c(View view);

        public abstract void d(View view, Object obj);

        public Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f9975a);
            if (this.f9976b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                W.j(view);
                view.setTag(this.f9975a, obj);
                W.U(view, this.f9978d);
            }
        }

        public abstract boolean g(Object obj, Object obj2);

        public f(int i7, Class cls, int i8, int i9) {
            this.f9975a = i7;
            this.f9976b = cls;
            this.f9978d = i8;
            this.f9977c = i9;
        }
    }

    public static class g {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return AbstractC0685b0.f9999b ? AbstractC0685b0.b(view, windowInsets) : view.dispatchApplyWindowInsets(windowInsets);
        }
    }

    public static class h {

        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public C0701j0 f9979a = null;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f9980b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ I f9981c;

            public a(View view, I i7) {
                this.f9980b = view;
                this.f9981c = i7;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                C0701j0 c0701j0D = C0701j0.D(windowInsets, view);
                int i7 = Build.VERSION.SDK_INT;
                if (i7 < 30) {
                    h.a(windowInsets, this.f9980b);
                    if (c0701j0D.equals(this.f9979a)) {
                        return this.f9981c.a(view, c0701j0D).B();
                    }
                }
                this.f9979a = c0701j0D;
                C0701j0 c0701j0A = this.f9981c.a(view, c0701j0D);
                if (i7 >= 30) {
                    return c0701j0A.B();
                }
                W.i0(view);
                return c0701j0A.B();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(J.e.f4321T);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static C0701j0 b(View view, C0701j0 c0701j0, Rect rect) {
            WindowInsets windowInsetsB = c0701j0.B();
            if (windowInsetsB != null) {
                return C0701j0.D(view.computeSystemWindowInsets(windowInsetsB, rect), view);
            }
            rect.setEmpty();
            return c0701j0;
        }

        public static void c(View view, I i7) {
            a aVar = i7 != null ? new a(view, i7) : null;
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(J.e.f4314M, aVar);
            }
            if (view.getTag(J.e.f4313L) != null) {
                return;
            }
            if (aVar != null) {
                view.setOnApplyWindowInsetsListener(aVar);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(J.e.f4321T));
            }
        }
    }

    public static class i {
        public static C0701j0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C0701j0 c0701j0C = C0701j0.C(rootWindowInsets);
            c0701j0C.w(c0701j0C);
            c0701j0C.m(view.getRootView());
            return c0701j0C;
        }
    }

    public static class j {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i7) {
            view.setImportantForAutofill(i7);
        }
    }

    public static class k {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z7) {
            view.setAccessibilityHeading(z7);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void f(View view, boolean z7) {
            view.setScreenReaderFocusable(z7);
        }
    }

    public static class l {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i7, int i8) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i7, i8);
        }
    }

    public static class m {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public static final class n {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static C0688d b(View view, C0688d c0688d) {
            ContentInfo contentInfoF = c0688d.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? c0688d : C0688d.g(contentInfoPerformReceiveContent);
        }
    }

    public static class o {

        /* renamed from: d, reason: collision with root package name */
        public static final ArrayList f9982d = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        public WeakHashMap f9983a = null;

        /* renamed from: b, reason: collision with root package name */
        public SparseArray f9984b = null;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference f9985c = null;

        public static o a(View view) {
            o oVar = (o) view.getTag(J.e.f4319R);
            if (oVar != null) {
                return oVar;
            }
            o oVar2 = new o();
            view.setTag(J.e.f4319R, oVar2);
            return oVar2;
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f9983a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray d() {
            if (this.f9984b == null) {
                this.f9984b = new SparseArray();
            }
            return this.f9984b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(J.e.f4320S);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            android.support.v4.media.session.b.a(arrayList.get(size));
            throw null;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f9985c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f9985c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }

        public final void g() {
            WeakHashMap weakHashMap = this.f9983a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f9982d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f9983a == null) {
                        this.f9983a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f9982d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f9983a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f9983a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static int A(View view) {
        return view.getLayoutDirection();
    }

    public static void A0(View view, int i7, int i8, int i9, int i10) {
        view.setPaddingRelative(i7, i8, i9, i10);
    }

    public static int B(View view) {
        return view.getMinimumHeight();
    }

    public static void B0(View view, boolean z7) {
        k0().f(view, Boolean.valueOf(z7));
    }

    public static int C(View view) {
        return view.getMinimumWidth();
    }

    public static void C0(View view, int i7, int i8) {
        view.setScrollIndicators(i7, i8);
    }

    public static String[] D(View view) {
        return Build.VERSION.SDK_INT >= 31 ? n.a(view) : (String[]) view.getTag(J.e.f4316O);
    }

    public static void D0(View view, CharSequence charSequence) {
        F0().f(view, charSequence);
    }

    public static int E(View view) {
        return view.getPaddingEnd();
    }

    public static void E0(View view, String str) {
        view.setTransitionName(str);
    }

    public static int F(View view) {
        return view.getPaddingStart();
    }

    public static f F0() {
        return new c(J.e.f4318Q, CharSequence.class, 64, 30);
    }

    public static C0701j0 G(View view) {
        return i.a(view);
    }

    public static void G0(View view) {
        view.stopNestedScroll();
    }

    public static CharSequence H(View view) {
        return (CharSequence) F0().e(view);
    }

    public static String I(View view) {
        return view.getTransitionName();
    }

    public static int J(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float K(View view) {
        return view.getZ();
    }

    public static boolean L(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean M(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean N(View view) {
        return view.hasTransientState();
    }

    public static boolean O(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean P(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean Q(View view) {
        return view.isLaidOut();
    }

    public static boolean R(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean S(View view) {
        return view.isPaddingRelative();
    }

    public static boolean T(View view) {
        Boolean bool = (Boolean) k0().e(view);
        return bool != null && bool.booleanValue();
    }

    public static void U(View view, int i7) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z7 = o(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z7) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z7 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i7);
                if (z7) {
                    accessibilityEventObtain.getText().add(o(view));
                    w0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i7 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i7);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(o(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i7);
                } catch (AbstractMethodError e7) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e7);
                }
            }
        }
    }

    public static void V(View view, int i7) {
        view.offsetLeftAndRight(i7);
    }

    public static void W(View view, int i7) {
        view.offsetTopAndBottom(i7);
    }

    public static C0701j0 X(View view, C0701j0 c0701j0) {
        WindowInsets windowInsetsB = c0701j0.B();
        if (windowInsetsB != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsB);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsB)) {
                return C0701j0.D(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return c0701j0;
    }

    public static void Y(View view, a0.x xVar) {
        view.onInitializeAccessibilityNodeInfo(xVar.O0());
    }

    public static f Z() {
        return new b(J.e.f4312K, CharSequence.class, 8, 28);
    }

    public static /* synthetic */ C0688d a(C0688d c0688d) {
        return c0688d;
    }

    public static boolean a0(View view, int i7, Bundle bundle) {
        return view.performAccessibilityAction(i7, bundle);
    }

    public static f b() {
        return new d(J.e.f4311J, Boolean.class, 28);
    }

    public static C0688d b0(View view, C0688d c0688d) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0688d + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return n.b(view, c0688d);
        }
        J j7 = (J) view.getTag(J.e.f4315N);
        if (j7 == null) {
            return w(view).a(c0688d);
        }
        C0688d c0688dA = j7.a(view, c0688d);
        if (c0688dA == null) {
            return null;
        }
        return w(view).a(c0688dA);
    }

    public static int c(View view, CharSequence charSequence, InterfaceC0743A interfaceC0743A) {
        int iQ = q(view, charSequence);
        if (iQ != -1) {
            d(view, new x.a(iQ, charSequence, interfaceC0743A));
        }
        return iQ;
    }

    public static void c0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void d(View view, x.a aVar) {
        j(view);
        g0(aVar.b(), view);
        p(view).add(aVar);
        U(view, 0);
    }

    public static void d0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static C0691e0 e(View view) {
        if (f9968a == null) {
            f9968a = new WeakHashMap();
        }
        C0691e0 c0691e0 = (C0691e0) f9968a.get(view);
        if (c0691e0 != null) {
            return c0691e0;
        }
        C0691e0 c0691e02 = new C0691e0(view);
        f9968a.put(view, c0691e02);
        return c0691e02;
    }

    public static void e0(View view, Runnable runnable, long j7) {
        view.postOnAnimationDelayed(runnable, j7);
    }

    public static C0701j0 f(View view, C0701j0 c0701j0, Rect rect) {
        return h.b(view, c0701j0, rect);
    }

    public static void f0(View view, int i7) {
        g0(i7, view);
        U(view, 0);
    }

    public static C0701j0 g(View view, C0701j0 c0701j0) {
        WindowInsets windowInsetsB = c0701j0.B();
        if (windowInsetsB != null) {
            WindowInsets windowInsetsA = Build.VERSION.SDK_INT >= 30 ? m.a(view, windowInsetsB) : g.a(view, windowInsetsB);
            if (!windowInsetsA.equals(windowInsetsB)) {
                return C0701j0.D(windowInsetsA, view);
            }
        }
        return c0701j0;
    }

    public static void g0(int i7, View view) {
        List listP = p(view);
        for (int i8 = 0; i8 < listP.size(); i8++) {
            if (((x.a) listP.get(i8)).b() == i7) {
                listP.remove(i8);
                return;
            }
        }
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return o.a(view).b(view, keyEvent);
    }

    public static void h0(View view, x.a aVar, CharSequence charSequence, InterfaceC0743A interfaceC0743A) {
        if (interfaceC0743A == null && charSequence == null) {
            f0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, interfaceC0743A));
        }
    }

    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return o.a(view).f(keyEvent);
    }

    public static void i0(View view) {
        view.requestApplyInsets();
    }

    public static void j(View view) {
        C0682a c0682aL = l(view);
        if (c0682aL == null) {
            c0682aL = new C0682a();
        }
        l0(view, c0682aL);
    }

    public static void j0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i7, int i8) {
        if (Build.VERSION.SDK_INT >= 29) {
            l.b(view, context, iArr, attributeSet, typedArray, i7, i8);
        }
    }

    public static int k() {
        return View.generateViewId();
    }

    public static f k0() {
        return new a(J.e.f4317P, Boolean.class, 28);
    }

    public static C0682a l(View view) {
        View.AccessibilityDelegate accessibilityDelegateM = m(view);
        if (accessibilityDelegateM == null) {
            return null;
        }
        return accessibilityDelegateM instanceof C0682a.C0083a ? ((C0682a.C0083a) accessibilityDelegateM).f9992a : new C0682a(accessibilityDelegateM);
    }

    public static void l0(View view, C0682a c0682a) {
        if (c0682a == null && (m(view) instanceof C0682a.C0083a)) {
            c0682a = new C0682a();
        }
        w0(view);
        view.setAccessibilityDelegate(c0682a == null ? null : c0682a.d());
    }

    public static View.AccessibilityDelegate m(View view) {
        return Build.VERSION.SDK_INT >= 29 ? l.a(view) : n(view);
    }

    public static void m0(View view, boolean z7) {
        b().f(view, Boolean.valueOf(z7));
    }

    public static View.AccessibilityDelegate n(View view) {
        if (f9970c) {
            return null;
        }
        if (f9969b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f9969b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f9970c = true;
                return null;
            }
        }
        try {
            Object obj = f9969b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f9970c = true;
            return null;
        }
    }

    public static void n0(View view, int i7) {
        view.setAccessibilityLiveRegion(i7);
    }

    public static CharSequence o(View view) {
        return (CharSequence) Z().e(view);
    }

    public static void o0(View view, CharSequence charSequence) {
        Z().f(view, charSequence);
        if (charSequence != null) {
            f9973f.a(view);
        } else {
            f9973f.d(view);
        }
    }

    public static List p(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(J.e.f4309H);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(J.e.f4309H, arrayList2);
        return arrayList2;
    }

    public static void p0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static int q(View view, CharSequence charSequence) {
        List listP = p(view);
        for (int i7 = 0; i7 < listP.size(); i7++) {
            if (TextUtils.equals(charSequence, ((x.a) listP.get(i7)).c())) {
                return ((x.a) listP.get(i7)).b();
            }
        }
        int i8 = -1;
        int i9 = 0;
        while (true) {
            int[] iArr = f9971d;
            if (i9 >= iArr.length || i8 != -1) {
                break;
            }
            int i10 = iArr[i9];
            boolean z7 = true;
            for (int i11 = 0; i11 < listP.size(); i11++) {
                z7 &= ((x.a) listP.get(i11)).b() != i10;
            }
            if (z7) {
                i8 = i10;
            }
            i9++;
        }
        return i8;
    }

    public static void q0(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static ColorStateList r(View view) {
        return view.getBackgroundTintList();
    }

    public static void r0(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static PorterDuff.Mode s(View view) {
        return view.getBackgroundTintMode();
    }

    public static void s0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static Rect t(View view) {
        return view.getClipBounds();
    }

    public static void t0(View view, float f7) {
        view.setElevation(f7);
    }

    public static Display u(View view) {
        return view.getDisplay();
    }

    public static void u0(View view, boolean z7) {
        view.setHasTransientState(z7);
    }

    public static float v(View view) {
        return view.getElevation();
    }

    public static void v0(View view, int i7) {
        view.setImportantForAccessibility(i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static K w(View view) {
        return view instanceof K ? (K) view : f9972e;
    }

    public static void w0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static boolean x(View view) {
        return view.getFitsSystemWindows();
    }

    public static void x0(View view, int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.b(view, i7);
        }
    }

    public static int y(View view) {
        return view.getImportantForAccessibility();
    }

    public static void y0(View view, int i7) {
        view.setLabelFor(i7);
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return j.a(view);
        }
        return 0;
    }

    public static void z0(View view, I i7) {
        h.c(view, i7);
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: l, reason: collision with root package name */
        public final WeakHashMap f9974l = new WeakHashMap();

        public void a(View view) {
            this.f9974l.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        public final void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z7 = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z7) {
                W.U(view, z7 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z7));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f9974l.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f9974l.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
