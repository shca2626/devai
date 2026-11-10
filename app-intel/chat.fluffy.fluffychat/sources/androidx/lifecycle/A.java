package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0804j;

/* loaded from: classes.dex */
public class A extends Fragment {

    /* renamed from: m, reason: collision with root package name */
    public static final b f12350m = new b(null);

    /* renamed from: l, reason: collision with root package name */
    public a f12351l;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC0804j.a aVar) {
            M5.m.e(activity, "activity");
            M5.m.e(aVar, "event");
            if (activity instanceof InterfaceC0808n) {
                AbstractC0804j abstractC0804jA = ((InterfaceC0808n) activity).a();
                if (abstractC0804jA instanceof C0809o) {
                    ((C0809o) abstractC0804jA).h(aVar);
                }
            }
        }

        public final A b(Activity activity) {
            M5.m.e(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            M5.m.c(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (A) fragmentFindFragmentByTag;
        }

        public final void c(Activity activity) {
            M5.m.e(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new A(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        public b() {
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(M5.g gVar) {
                this();
            }

            public final void a(Activity activity) {
                M5.m.e(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            public a() {
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            M5.m.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            M5.m.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            M5.m.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            M5.m.e(activity, "activity");
            A.f12350m.a(activity, AbstractC0804j.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            M5.m.e(activity, "activity");
            A.f12350m.a(activity, AbstractC0804j.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            M5.m.e(activity, "activity");
            A.f12350m.a(activity, AbstractC0804j.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            M5.m.e(activity, "activity");
            A.f12350m.a(activity, AbstractC0804j.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            M5.m.e(activity, "activity");
            A.f12350m.a(activity, AbstractC0804j.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            M5.m.e(activity, "activity");
            A.f12350m.a(activity, AbstractC0804j.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            M5.m.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            M5.m.e(activity, "activity");
            M5.m.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            M5.m.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            M5.m.e(activity, "activity");
        }
    }

    public final void a(AbstractC0804j.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f12350m;
            Activity activity = getActivity();
            M5.m.d(activity, "getActivity(...)");
            bVar.a(activity, aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void e(a aVar) {
        this.f12351l = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f12351l);
        a(AbstractC0804j.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC0804j.a.ON_DESTROY);
        this.f12351l = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC0804j.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f12351l);
        a(AbstractC0804j.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f12351l);
        a(AbstractC0804j.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC0804j.a.ON_STOP);
    }
}
