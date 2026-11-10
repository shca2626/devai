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
    public static k0 f21298v;

    /* renamed from: w, reason: collision with root package name */
    public static k0 f21299w;

    /* renamed from: l, reason: collision with root package name */
    public final View f21300l;

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence f21301m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21302n;

    /* renamed from: o, reason: collision with root package name */
    public final Runnable f21303o = new Runnable() { // from class: q.i0
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            this.f21280l.h(false);
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public final Runnable f21304p = new Runnable() { // from class: q.j0
        @Override // java.lang.Runnable
        public final void run() {
            this.f21290l.d();
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public int f21305q;

    /* renamed from: r, reason: collision with root package name */
    public int f21306r;

    /* renamed from: s, reason: collision with root package name */
    public l0 f21307s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21308t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f21309u;

    public k0(View view, CharSequence charSequence) {
        this.f21300l = view;
        this.f21301m = charSequence;
        this.f21302n = Z.Z.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void f(k0 k0Var) {
        k0 k0Var2 = f21298v;
        if (k0Var2 != null) {
            k0Var2.b();
        }
        f21298v = k0Var;
        if (k0Var != null) {
            k0Var.e();
        }
    }

    public static void g(View view, CharSequence charSequence) {
        k0 k0Var = f21298v;
        if (k0Var != null && k0Var.f21300l == view) {
            f(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new k0(view, charSequence);
            return;
        }
        k0 k0Var2 = f21299w;
        if (k0Var2 != null && k0Var2.f21300l == view) {
            k0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f21300l.removeCallbacks(this.f21303o);
    }

    public final void c() {
        this.f21309u = true;
    }

    public void d() {
        if (f21299w == this) {
            f21299w = null;
            l0 l0Var = this.f21307s;
            if (l0Var != null) {
                l0Var.c();
                this.f21307s = null;
                c();
                this.f21300l.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f21298v == this) {
            f(null);
        }
        this.f21300l.removeCallbacks(this.f21304p);
    }

    public final void e() {
        this.f21300l.postDelayed(this.f21303o, ViewConfiguration.getLongPressTimeout());
    }

    public void h(boolean z7) throws Resources.NotFoundException {
        long longPressTimeout;
        long j7;
        long j8;
        if (Z.W.P(this.f21300l)) {
            f(null);
            k0 k0Var = f21299w;
            if (k0Var != null) {
                k0Var.d();
            }
            f21299w = this;
            this.f21308t = z7;
            l0 l0Var = new l0(this.f21300l.getContext());
            this.f21307s = l0Var;
            l0Var.e(this.f21300l, this.f21305q, this.f21306r, this.f21308t, this.f21301m);
            this.f21300l.addOnAttachStateChangeListener(this);
            if (this.f21308t) {
                j8 = 2500;
            } else {
                if ((Z.W.J(this.f21300l) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = 15000;
                }
                j8 = j7 - longPressTimeout;
            }
            this.f21300l.removeCallbacks(this.f21304p);
            this.f21300l.postDelayed(this.f21304p, j8);
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        int x7 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        if (!this.f21309u && Math.abs(x7 - this.f21305q) <= this.f21302n && Math.abs(y7 - this.f21306r) <= this.f21302n) {
            return false;
        }
        this.f21305q = x7;
        this.f21306r = y7;
        this.f21309u = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f21307s != null && this.f21308t) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f21300l.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f21300l.isEnabled() && this.f21307s == null && i(motionEvent)) {
            f(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f21305q = view.getWidth() / 2;
        this.f21306r = view.getHeight() / 2;
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
