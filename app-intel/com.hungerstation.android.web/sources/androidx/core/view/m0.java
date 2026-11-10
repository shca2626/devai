package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes7.dex */
public final class m0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    private final View f6751b;

    /* renamed from: c, reason: collision with root package name */
    private ViewTreeObserver f6752c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f6753d;

    private m0(View view, Runnable runnable) {
        this.f6751b = view;
        this.f6752c = view.getViewTreeObserver();
        this.f6753d = runnable;
    }

    public static m0 a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        m0 m0Var = new m0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(m0Var);
        view.addOnAttachStateChangeListener(m0Var);
        return m0Var;
    }

    public void b() {
        if (this.f6752c.isAlive()) {
            this.f6752c.removeOnPreDrawListener(this);
        } else {
            this.f6751b.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f6751b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f6753d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f6752c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
