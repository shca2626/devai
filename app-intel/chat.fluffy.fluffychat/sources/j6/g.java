package j6;

import M5.m;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes3.dex */
public abstract class g {

    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Activity f18803l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ L5.a f18804m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ L5.a f18805n;

        public a(Activity activity, L5.a aVar, L5.a aVar2) {
            this.f18803l = activity;
            this.f18804m = aVar;
            this.f18805n = aVar2;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            m.e(activity, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            m.e(activity, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            L5.a aVar;
            m.e(activity, "p0");
            if (!m.a(activity, this.f18803l) || (aVar = this.f18804m) == null) {
                return;
            }
            aVar.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            L5.a aVar;
            m.e(activity, "p0");
            if (!m.a(activity, this.f18803l) || (aVar = this.f18805n) == null) {
                return;
            }
            aVar.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            m.e(activity, "p0");
            m.e(bundle, "p1");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            m.e(activity, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            m.e(activity, "p0");
        }
    }

    public static final i a(Activity activity, L5.a aVar, L5.a aVar2) {
        m.e(activity, "<this>");
        a aVar3 = new a(activity, aVar, aVar2);
        activity.getApplication().registerActivityLifecycleCallbacks(aVar3);
        Application application = activity.getApplication();
        m.d(application, "getApplication(...)");
        return new i(application, aVar3);
    }
}
