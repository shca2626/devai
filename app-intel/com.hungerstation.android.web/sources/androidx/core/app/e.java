package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes7.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class<?> f6224a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f6225b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f6226c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f6227d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f6228e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f6229f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f6230g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f6231b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f6232c;

        a(d dVar, Object obj) {
            this.f6231b = dVar;
            this.f6232c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6231b.f6237b = this.f6232c;
        }
    }

    class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Application f6233b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f6234c;

        b(Application application, d dVar) {
            this.f6233b = application;
            this.f6234c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6233b.unregisterActivityLifecycleCallbacks(this.f6234c);
        }
    }

    class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f6235b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f6236c;

        c(Object obj, Object obj2) {
            this.f6235b = obj;
            this.f6236c = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = e.f6227d;
                if (method != null) {
                    method.invoke(this.f6235b, this.f6236c, Boolean.FALSE, "AppCompat recreation");
                } else {
                    e.f6228e.invoke(this.f6235b, this.f6236c, Boolean.FALSE);
                }
            } catch (RuntimeException e12) {
                if (e12.getClass() == RuntimeException.class && e12.getMessage() != null && e12.getMessage().startsWith("Unable to stop")) {
                    throw e12;
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b, reason: collision with root package name */
        Object f6237b;

        /* renamed from: c, reason: collision with root package name */
        private Activity f6238c;

        /* renamed from: d, reason: collision with root package name */
        private final int f6239d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6240e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f6241f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f6242g = false;

        d(Activity activity) {
            this.f6238c = activity;
            this.f6239d = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f6238c == activity) {
                this.f6238c = null;
                this.f6241f = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f6241f || this.f6242g || this.f6240e || !e.h(this.f6237b, this.f6239d, activity)) {
                return;
            }
            this.f6242g = true;
            this.f6237b = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f6238c == activity) {
                this.f6240e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        f6224a = clsA;
        f6225b = b();
        f6226c = f();
        f6227d = d(clsA);
        f6228e = c(clsA);
        f6229f = e(clsA);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i12 = Build.VERSION.SDK_INT;
        return i12 == 26 || i12 == 27;
    }

    protected static boolean h(Object obj, int i12, Activity activity) {
        try {
            Object obj2 = f6226c.get(activity);
            if (obj2 == obj && activity.hashCode() == i12) {
                f6230g.postAtFrontOfQueue(new c(f6225b.get(activity), obj2));
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f6229f == null) {
            return false;
        }
        if (f6228e == null && f6227d == null) {
            return false;
        }
        try {
            Object obj2 = f6226c.get(activity);
            if (obj2 == null || (obj = f6225b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            Handler handler = f6230g;
            handler.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f6229f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable th2) {
                f6230g.post(new b(application, dVar));
                throw th2;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
