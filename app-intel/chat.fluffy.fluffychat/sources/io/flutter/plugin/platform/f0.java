package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;

/* loaded from: classes.dex */
public class f0 {

    /* renamed from: i, reason: collision with root package name */
    public static VirtualDisplay.Callback f17821i = new a();

    /* renamed from: a, reason: collision with root package name */
    public SingleViewPresentation f17822a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f17823b;

    /* renamed from: c, reason: collision with root package name */
    public final C1170a f17824c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17825d;

    /* renamed from: e, reason: collision with root package name */
    public final int f17826e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC1184o f17827f;

    /* renamed from: g, reason: collision with root package name */
    public final View.OnFocusChangeListener f17828g;

    /* renamed from: h, reason: collision with root package name */
    public VirtualDisplay f17829h;

    public class a extends VirtualDisplay.Callback {
        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onPaused() {
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onResumed() {
        }
    }

    public class b implements View.OnAttachStateChangeListener {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ View f17830l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Runnable f17831m;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f17830l.postDelayed(bVar.f17831m, 128L);
            }
        }

        public b(View view, Runnable runnable) {
            this.f17830l = view;
            this.f17831m = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c.a(this.f17830l, new a());
            this.f17830l.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static class c implements ViewTreeObserver.OnDrawListener {

        /* renamed from: l, reason: collision with root package name */
        public final View f17834l;

        /* renamed from: m, reason: collision with root package name */
        public Runnable f17835m;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f17834l.getViewTreeObserver().removeOnDrawListener(c.this);
            }
        }

        public c(View view, Runnable runnable) {
            this.f17834l = view;
            this.f17835m = runnable;
        }

        public static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new c(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f17835m;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f17835m = null;
            this.f17834l.post(new a());
        }
    }

    public f0(Context context, C1170a c1170a, VirtualDisplay virtualDisplay, InterfaceC1180k interfaceC1180k, InterfaceC1184o interfaceC1184o, View.OnFocusChangeListener onFocusChangeListener, int i7, Object obj) {
        this.f17823b = context;
        this.f17824c = c1170a;
        this.f17827f = interfaceC1184o;
        this.f17828g = onFocusChangeListener;
        this.f17826e = i7;
        this.f17829h = virtualDisplay;
        this.f17825d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f17829h.getDisplay(), interfaceC1180k, c1170a, i7, onFocusChangeListener);
        this.f17822a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static f0 b(Context context, C1170a c1170a, InterfaceC1180k interfaceC1180k, InterfaceC1184o interfaceC1184o, int i7, int i8, int i9, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        if (i7 == 0 || i8 == 0) {
            return null;
        }
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        interfaceC1184o.a(i7, i8);
        VirtualDisplay virtualDisplayCreateVirtualDisplay = displayManager.createVirtualDisplay("flutter-vd#" + i9, i7, i8, displayMetrics.densityDpi, interfaceC1184o.getSurface(), 0, f17821i, null);
        if (virtualDisplayCreateVirtualDisplay == null) {
            return null;
        }
        return new f0(context, c1170a, virtualDisplayCreateVirtualDisplay, interfaceC1180k, interfaceC1184o, onFocusChangeListener, i9, obj);
    }

    public void a() {
        this.f17829h.setSurface(null);
    }

    public void c(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f17822a;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public void d() {
        this.f17822a.cancel();
        this.f17822a.detachState();
        this.f17829h.release();
        this.f17827f.release();
    }

    public int e() {
        InterfaceC1184o interfaceC1184o = this.f17827f;
        if (interfaceC1184o != null) {
            return interfaceC1184o.getHeight();
        }
        return 0;
    }

    public int f() {
        InterfaceC1184o interfaceC1184o = this.f17827f;
        if (interfaceC1184o != null) {
            return interfaceC1184o.getWidth();
        }
        return 0;
    }

    public View g() {
        SingleViewPresentation singleViewPresentation = this.f17822a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().a();
    }

    public void h() {
        SingleViewPresentation singleViewPresentation = this.f17822a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f17822a.getView().c();
    }

    public void i() {
        SingleViewPresentation singleViewPresentation = this.f17822a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f17822a.getView().d();
    }

    public void j() {
        int iF = f();
        int iE = e();
        boolean zIsFocused = g().isFocused();
        SingleViewPresentation.d dVarDetachState = this.f17822a.detachState();
        this.f17829h.setSurface(null);
        this.f17829h.release();
        this.f17829h = ((DisplayManager) this.f17823b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.f17826e, iF, iE, this.f17825d, this.f17827f.getSurface(), 0, f17821i, null);
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f17823b, this.f17829h.getDisplay(), this.f17824c, dVarDetachState, this.f17828g, zIsFocused);
        singleViewPresentation.show();
        this.f17822a.cancel();
        this.f17822a = singleViewPresentation;
    }

    public void k(int i7, int i8, Runnable runnable) {
        if (i7 == f() && i8 == e()) {
            g().postDelayed(runnable, 0L);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            l(g(), i7, i8, runnable);
            return;
        }
        boolean zIsFocused = g().isFocused();
        SingleViewPresentation.d dVarDetachState = this.f17822a.detachState();
        this.f17829h.setSurface(null);
        this.f17829h.release();
        DisplayManager displayManager = (DisplayManager) this.f17823b.getSystemService("display");
        this.f17827f.a(i7, i8);
        this.f17829h = displayManager.createVirtualDisplay("flutter-vd#" + this.f17826e, i7, i8, this.f17825d, this.f17827f.getSurface(), 0, f17821i, null);
        View viewG = g();
        viewG.addOnAttachStateChangeListener(new b(viewG, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f17823b, this.f17829h.getDisplay(), this.f17824c, dVarDetachState, this.f17828g, zIsFocused);
        singleViewPresentation.show();
        this.f17822a.cancel();
        this.f17822a = singleViewPresentation;
    }

    public final void l(View view, int i7, int i8, Runnable runnable) {
        this.f17827f.a(i7, i8);
        this.f17829h.resize(i7, i8, this.f17825d);
        this.f17829h.setSurface(this.f17827f.getSurface());
        view.postDelayed(runnable, 0L);
    }
}
