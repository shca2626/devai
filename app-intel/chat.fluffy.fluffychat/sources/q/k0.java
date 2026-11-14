package q;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public class k0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: v, reason: collision with root package name */
    public static k0 f21304v;

    /* renamed from: w, reason: collision with root package name */
    public static k0 f21305w;

    /* renamed from: l, reason: collision with root package name */
    public final View f21306l;

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence f21307m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21308n;

    /* renamed from: o, reason: collision with root package name */
    public final Runnable f21309o = new Runnable() { // from class: q.i0
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            this.f21286l.h(false);
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public final Runnable f21310p = new Runnable() { // from class: q.j0
        @Override // java.lang.Runnable
        public final void run() {
            this.f21296l.d();
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public int f21311q;

    /* renamed from: r, reason: collision with root package name */
    public int f21312r;

    /* renamed from: s, reason: collision with root package name */
    public l0 f21313s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21314t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f21315u;

    public k0(View view, CharSequence charSequence) {
        this.f21306l = view;
        this.f21307m = charSequence;
        this.f21308n = Z.Z.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void f(k0 k0Var) {
        k0 k0Var2 = f21304v;
        if (k0Var2 != null) {
            k0Var2.b();
        }
        f21304v = k0Var;
        if (k0Var != null) {
            k0Var.e();
        }
    }

    public static void g(View view, CharSequence charSequence) {
        k0 k0Var = f21304v;
        if (k0Var != null && k0Var.f21306l == view) {
            f(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new k0(view, charSequence);
            return;
        }
        k0 k0Var2 = f21305w;
        if (k0Var2 != null && k0Var2.f21306l == view) {
            k0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f21306l.removeCallbacks(this.f21309o);
    }

    public final void c() {
        this.f21315u = true;
    }

    public void d() {
        if (f21305w == this) {
            f21305w = null;
            l0 l0Var = this.f21313s;
            if (l0Var != null) {
                l0Var.c();
                this.f21313s = null;
                c();
                this.f21306l.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f21304v == this) {
            f(null);
        }
        this.f21306l.removeCallbacks(this.f21310p);
    }

    public final void e() {
        this.f21306l.postDelayed(this.f21309o, ViewConfiguration.getLongPressTimeout());
    }

    public void h(boolean z7) throws Resources.NotFoundException {
        long longPressTimeout;
        long j7;
        long j8;
        if (Z.W.P(this.f21306l)) {
            f(null);
            k0 k0Var = f21305w;
            if (k0Var != null) {
                k0Var.d();
            }
            f21305w = this;
            this.f21314t = z7;
            l0 l0Var = new l0(this.f21306l.getContext());
            this.f21313s = l0Var;
            l0Var.e(this.f21306l, this.f21311q, this.f21312r, this.f21314t, this.f21307m);
            this.f21306l.addOnAttachStateChangeListener(this);
            if (this.f21314t) {
                j8 = 2500;
            } else {
                if ((Z.W.J(this.f21306l) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = 15000;
                }
                j8 = j7 - longPressTimeout;
            }
            this.f21306l.removeCallbacks(this.f21310p);
            this.f21306l.postDelayed(this.f21310p, j8);
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        int x7 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        if (!this.f21315u && Math.abs(x7 - this.f21311q) <= this.f21308n && Math.abs(y7 - this.f21312r) <= this.f21308n) {
            return false;
        }
        this.f21311q = x7;
        this.f21312r = y7;
        this.f21315u = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f21313s != null && this.f21314t) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f21306l.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f21306l.isEnabled() && this.f21313s == null && i(motionEvent)) {
            f(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f21311q = view.getWidth() / 2;
        this.f21312r = view.getHeight() / 2;
        h(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
