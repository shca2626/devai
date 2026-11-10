package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.lifecycle.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0805k {

    /* renamed from: a, reason: collision with root package name */
    public static final C0805k f12414a = new C0805k();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f12415b = new AtomicBoolean(false);

    /* renamed from: androidx.lifecycle.k$a */
    public static final class a extends C0800f {
        @Override // androidx.lifecycle.C0800f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            M5.m.e(activity, "activity");
            A.f12350m.c(activity);
        }
    }

    public static final void a(Context context) {
        M5.m.e(context, "context");
        if (f12415b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        M5.m.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
