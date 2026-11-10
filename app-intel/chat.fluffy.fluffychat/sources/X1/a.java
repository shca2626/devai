package X1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f9281d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f9282e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f9285c;

    /* renamed from: b, reason: collision with root package name */
    public final Set f9284b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final Map f9283a = new HashMap();

    public a(Context context) {
        this.f9285c = context.getApplicationContext();
    }

    public static a e(Context context) {
        if (f9281d == null) {
            synchronized (f9282e) {
                try {
                    if (f9281d == null) {
                        f9281d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f9281d;
    }

    public void a() {
        try {
            try {
                Y1.a.c("Startup");
                b(this.f9285c.getPackageManager().getProviderInfo(new ComponentName(this.f9285c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e7) {
                throw new d(e7);
            }
        } finally {
            Y1.a.f();
        }
    }

    public void b(Bundle bundle) throws ClassNotFoundException {
        String string = this.f9285c.getString(c.f9286a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f9284b.add(cls);
                        }
                    }
                }
                Iterator it = this.f9284b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e7) {
                throw new d(e7);
            }
        }
    }

    public Object c(Class cls) {
        Object objD;
        synchronized (f9282e) {
            try {
                objD = this.f9283a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public final Object d(Class cls, Set set) {
        Object objB;
        if (Y1.a.h()) {
            try {
                Y1.a.c(cls.getSimpleName());
            } catch (Throwable th) {
                Y1.a.f();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f9283a.containsKey(cls)) {
            objB = this.f9283a.get(cls);
        } else {
            set.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f9283a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objB = bVar.b(this.f9285c);
                set.remove(cls);
                this.f9283a.put(cls, objB);
            } catch (Throwable th2) {
                throw new d(th2);
            }
        }
        Y1.a.f();
        return objB;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f9284b.contains(cls);
    }
}
