package j6;

import M5.m;
import android.app.Application;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Application f18809a;

    /* renamed from: b, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f18810b;

    public i(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        m.e(application, "application");
        m.e(activityLifecycleCallbacks, "callback");
        this.f18809a = application;
        this.f18810b = activityLifecycleCallbacks;
    }

    public final void a() {
        this.f18809a.unregisterActivityLifecycleCallbacks(this.f18810b);
    }
}
