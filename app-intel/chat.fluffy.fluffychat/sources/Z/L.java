package Z;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class L implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: l, reason: collision with root package name */
    public final View f9943l;

    /* renamed from: m, reason: collision with root package name */
    public ViewTreeObserver f9944m;

    /* renamed from: n, reason: collision with root package name */
    public final Runnable f9945n;

    public L(View view, Runnable runnable) {
        this.f9943l = view;
        this.f9944m = view.getViewTreeObserver();
        this.f9945n = runnable;
    }

    public static L a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        L l7 = new L(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(l7);
        view.addOnAttachStateChangeListener(l7);
        return l7;
    }

    public void b() {
        if (this.f9944m.isAlive()) {
            this.f9944m.removeOnPreDrawListener(this);
        } else {
            this.f9943l.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f9943l.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f9945n.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f9944m = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
