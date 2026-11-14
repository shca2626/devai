package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import h.InterfaceC1117a;

@InterfaceC1117a
/* loaded from: classes.dex */
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final C1170a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private final d state;
    private int viewId;

    public static class a extends FrameLayout {

        /* renamed from: l, reason: collision with root package name */
        public final C1170a f17763l;

        /* renamed from: m, reason: collision with root package name */
        public final View f17764m;

        public a(Context context, C1170a c1170a, View view) {
            super(context);
            this.f17763l = c1170a;
            this.f17764m = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f17763l.b(this.f17764m, view, accessibilityEvent);
        }
    }

    public static class b extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final InputMethodManager f17765a;

        public b(Context context) {
            this(context, null);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new b(super.createDisplayContext(display), this.f17765a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f17765a : super.getSystemService(str);
        }

        public b(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f17765a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }
    }

    public static class c extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final g0 f17766a;

        /* renamed from: b, reason: collision with root package name */
        public WindowManager f17767b;

        /* renamed from: c, reason: collision with root package name */
        public final Context f17768c;

        public c(Context context, g0 g0Var, Context context2) {
            super(context);
            this.f17766a = g0Var;
            this.f17768c = context2;
        }

        public final WindowManager a() {
            if (this.f17767b == null) {
                this.f17767b = this.f17766a;
            }
            return this.f17767b;
        }

        public final boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i7 = 0; i7 < stackTrace.length && i7 < 11; i7++) {
                if (stackTrace[i7].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i7].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f17768c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC1180k f17769a;

        /* renamed from: b, reason: collision with root package name */
        public g0 f17770b;

        /* renamed from: c, reason: collision with root package name */
        public W f17771c;
    }

    public SingleViewPresentation(Context context, Display display, InterfaceC1180k interfaceC1180k, C1170a c1170a, int i7, View.OnFocusChangeListener onFocusChangeListener) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c1170a;
        this.viewId = i7;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        d dVar = new d();
        this.state = dVar;
        dVar.f17769a = interfaceC1180k;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public d detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        a aVar = this.rootView;
        if (aVar != null) {
            aVar.removeAllViews();
        }
        return this.state;
    }

    public InterfaceC1180k getView() {
        return this.state.f17769a;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f17771c == null) {
            this.state.f17771c = new W(getContext());
        }
        if (this.state.f17770b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            d dVar = this.state;
            dVar.f17770b = new g0(windowManager, dVar.f17771c);
        }
        this.container = new FrameLayout(getContext());
        c cVar = new c(getContext(), this.state.f17770b, this.outerContext);
        View viewA = this.state.f17769a.a();
        if (viewA.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) viewA.getContext()).setBaseContext(cVar);
        } else {
            U4.b.g(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(viewA);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, viewA);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f17771c);
        viewA.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            viewA.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public SingleViewPresentation(Context context, Display display, C1170a c1170a, d dVar, View.OnFocusChangeListener onFocusChangeListener, boolean z7) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c1170a;
        this.state = dVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z7;
    }
}
