package S;

import V.g;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final WeakHashMap f8095a = new WeakHashMap();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Class f8096a;

        /* renamed from: b, reason: collision with root package name */
        public static Method f8097b;

        public static boolean a(LocationManager locationManager, String str, d dVar, S.a aVar, Looper looper) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            try {
                if (f8096a == null) {
                    f8096a = Class.forName("android.location.LocationRequest");
                }
                if (f8097b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f8096a, LocationListener.class, Looper.class);
                    f8097b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequestI = dVar.i(str);
                if (locationRequestI == null) {
                    return false;
                }
                f8097b.invoke(locationManager, locationRequestI, aVar, looper);
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                return false;
            }
        }
    }

    /* renamed from: S.b$b, reason: collision with other inner class name */
    public static class C0064b {
        public static void a(LocationManager locationManager, String str, LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    public static void a(LocationManager locationManager, String str, d dVar, S.a aVar, Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            C0064b.a(locationManager, str, dVar.h(), g.a(new Handler(looper)), aVar);
        } else {
            if (a.a(locationManager, str, dVar, aVar, looper)) {
                return;
            }
            locationManager.requestLocationUpdates(str, dVar.b(), dVar.e(), aVar, looper);
        }
    }
}
