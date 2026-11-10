package F4;

import M5.m;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class f implements Application.ActivityLifecycleCallbacks {

    /* renamed from: m, reason: collision with root package name */
    public static boolean f2734m;

    /* renamed from: o, reason: collision with root package name */
    public static L5.a f2736o;

    /* renamed from: l, reason: collision with root package name */
    public static final f f2733l = new f();

    /* renamed from: n, reason: collision with root package name */
    public static final HashSet f2735n = new HashSet();

    public final void a(Application application, L5.a aVar) {
        m.e(application, "application");
        m.e(aVar, "callback");
        f2736o = aVar;
        if (f2734m) {
            return;
        }
        f2734m = true;
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.e(activity, "a");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m.e(activity, "a");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        L5.a aVar;
        m.e(activity, "activity");
        HashSet hashSet = f2735n;
        hashSet.remove(Integer.valueOf(System.identityHashCode(activity)));
        if (!hashSet.isEmpty() || (aVar = f2736o) == null) {
            return;
        }
        aVar.d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        m.e(activity, "activity");
        f2735n.add(Integer.valueOf(System.identityHashCode(activity)));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m.e(activity, "a");
        m.e(bundle, "b");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        m.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        m.e(activity, "activity");
    }
}
