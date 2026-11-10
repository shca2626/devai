package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.A;
import androidx.lifecycle.AbstractC0804j;

/* loaded from: classes.dex */
public final class y implements InterfaceC0808n {

    /* renamed from: t, reason: collision with root package name */
    public static final b f12452t = new b(null);

    /* renamed from: u, reason: collision with root package name */
    public static final y f12453u = new y();

    /* renamed from: l, reason: collision with root package name */
    public int f12454l;

    /* renamed from: m, reason: collision with root package name */
    public int f12455m;

    /* renamed from: p, reason: collision with root package name */
    public Handler f12458p;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12456n = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12457o = true;

    /* renamed from: q, reason: collision with root package name */
    public final C0809o f12459q = new C0809o(this);

    /* renamed from: r, reason: collision with root package name */
    public final Runnable f12460r = new Runnable() { // from class: androidx.lifecycle.x
        @Override // java.lang.Runnable
        public final void run() {
            y.j(this.f12451l);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public final A.a f12461s = new d();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12462a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            M5.m.e(activity, "activity");
            M5.m.e(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public final InterfaceC0808n a() {
            return y.f12453u;
        }

        public final void b(Context context) {
            M5.m.e(context, "context");
            y.f12453u.i(context);
        }

        public b() {
        }
    }

    public static final class c extends C0800f {

        public static final class a extends C0800f {
            final /* synthetic */ y this$0;

            public a(y yVar) {
                this.this$0 = yVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                M5.m.e(activity, "activity");
                this.this$0.f();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                M5.m.e(activity, "activity");
                this.this$0.g();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.C0800f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            M5.m.e(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                A.f12350m.b(activity).e(y.this.f12461s);
            }
        }

        @Override // androidx.lifecycle.C0800f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            M5.m.e(activity, "activity");
            y.this.e();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            M5.m.e(activity, "activity");
            a.a(activity, new a(y.this));
        }

        @Override // androidx.lifecycle.C0800f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            M5.m.e(activity, "activity");
            y.this.h();
        }
    }

    public static final class d implements A.a {
        public d() {
        }

        @Override // androidx.lifecycle.A.a
        public void a() {
            y.this.f();
        }

        @Override // androidx.lifecycle.A.a
        public void b() {
        }

        @Override // androidx.lifecycle.A.a
        public void c() {
            y.this.g();
        }
    }

    public static final void j(y yVar) {
        yVar.l();
        yVar.m();
    }

    @Override // androidx.lifecycle.InterfaceC0808n
    public AbstractC0804j a() {
        return this.f12459q;
    }

    public final void e() {
        int i7 = this.f12455m - 1;
        this.f12455m = i7;
        if (i7 == 0) {
            Handler handler = this.f12458p;
            M5.m.b(handler);
            handler.postDelayed(this.f12460r, 700L);
        }
    }

    public final void f() {
        int i7 = this.f12455m + 1;
        this.f12455m = i7;
        if (i7 == 1) {
            if (this.f12456n) {
                this.f12459q.h(AbstractC0804j.a.ON_RESUME);
                this.f12456n = false;
            } else {
                Handler handler = this.f12458p;
                M5.m.b(handler);
                handler.removeCallbacks(this.f12460r);
            }
        }
    }

    public final void g() {
        int i7 = this.f12454l + 1;
        this.f12454l = i7;
        if (i7 == 1 && this.f12457o) {
            this.f12459q.h(AbstractC0804j.a.ON_START);
            this.f12457o = false;
        }
    }

    public final void h() {
        this.f12454l--;
        m();
    }

    public final void i(Context context) {
        M5.m.e(context, "context");
        this.f12458p = new Handler();
        this.f12459q.h(AbstractC0804j.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        M5.m.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void l() {
        if (this.f12455m == 0) {
            this.f12456n = true;
            this.f12459q.h(AbstractC0804j.a.ON_PAUSE);
        }
    }

    public final void m() {
        if (this.f12454l == 0 && this.f12456n) {
            this.f12459q.h(AbstractC0804j.a.ON_STOP);
            this.f12457o = true;
        }
    }
}
