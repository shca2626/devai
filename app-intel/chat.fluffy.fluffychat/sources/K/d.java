package K;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f4806a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f4807b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f4808c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f4809d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f4810e;

    /* renamed from: f, reason: collision with root package name */
    public static final Method f4811f;

    /* renamed from: g, reason: collision with root package name */
    public static final Handler f4812g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ C0045d f4813l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Object f4814m;

        public a(C0045d c0045d, Object obj) {
            this.f4813l = c0045d;
            this.f4814m = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4813l.f4819l = this.f4814m;
        }
    }

    public class b implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Application f4815l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ C0045d f4816m;

        public b(Application application, C0045d c0045d) {
            this.f4815l = application;
            this.f4816m = c0045d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4815l.unregisterActivityLifecycleCallbacks(this.f4816m);
        }
    }

    public class c implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Object f4817l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Object f4818m;

        public c(Object obj, Object obj2) {
            this.f4817l = obj;
            this.f4818m = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = d.f4809d;
                if (method != null) {
                    method.invoke(this.f4817l, this.f4818m, Boolean.FALSE, "AppCompat recreation");
                } else {
                    d.f4810e.invoke(this.f4817l, this.f4818m, Boolean.FALSE);
                }
            } catch (RuntimeException e7) {
                if (e7.getClass() == RuntimeException.class && e7.getMessage() != null && e7.getMessage().startsWith("Unable to stop")) {
                    throw e7;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    static {
        Class clsA = a();
        f4806a = clsA;
        f4807b = b();
        f4808c = f();
        f4809d = d(clsA);
        f4810e = c(clsA);
        f4811f = e(clsA);
    }

    public static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class cls) {
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

    public static Method d(Class cls) {
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

    public static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class cls2 = Integer.TYPE;
                Class cls3 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, cls2, cls3, Configuration.class, Configuration.class, cls3, cls3);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i7 = Build.VERSION.SDK_INT;
        return i7 == 26 || i7 == 27;
    }

    public static boolean h(Object obj, int i7, Activity activity) {
        try {
            Object obj2 = f4808c.get(activity);
            if (obj2 == obj && activity.hashCode() == i7) {
                f4812g.postAtFrontOfQueue(new c(f4807b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f4811f == null) {
            return false;
        }
        if (f4810e == null && f4809d == null) {
            return false;
        }
        try {
            Object obj2 = f4808c.get(activity);
            if (obj2 == null || (obj = f4807b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            C0045d c0045d = new C0045d(activity);
            application.registerActivityLifecycleCallbacks(c0045d);
            Handler handler = f4812g;
            handler.post(new a(c0045d, obj2));
            try {
                if (g()) {
                    Method method = f4811f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, c0045d));
                return true;
            } catch (Throwable th) {
                f4812g.post(new b(application, c0045d));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: K.d$d, reason: collision with other inner class name */
    public static final class C0045d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: l, reason: collision with root package name */
        public Object f4819l;

        /* renamed from: m, reason: collision with root package name */
        public Activity f4820m;

        /* renamed from: n, reason: collision with root package name */
        public final int f4821n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f4822o = false;

        /* renamed from: p, reason: collision with root package name */
        public boolean f4823p = false;

        /* renamed from: q, reason: collision with root package name */
        public boolean f4824q = false;

        public C0045d(Activity activity) {
            this.f4820m = activity;
            this.f4821n = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f4820m == activity) {
                this.f4820m = null;
                this.f4823p = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f4823p || this.f4824q || this.f4822o || !d.h(this.f4819l, this.f4821n, activity)) {
                return;
            }
            this.f4824q = true;
            this.f4819l = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f4820m == activity) {
                this.f4822o = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
