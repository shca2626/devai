package j6;

import M5.m;
import android.app.Application;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Application f18808a;

    /* renamed from: b, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f18809b;

    public i(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        m.e(application, "application");
        m.e(activityLifecycleCallbacks, "callback");
        this.f18808a = application;
        this.f18809b = activityLifecycleCallbacks;
    }

    public final void a() {
        this.f18808a.unregisterActivityLifecycleCallbacks(this.f18809b);
    }
}
