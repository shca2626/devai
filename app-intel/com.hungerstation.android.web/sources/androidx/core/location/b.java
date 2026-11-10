package androidx.core.location;

import android.location.LocationManager;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final WeakHashMap<Object, WeakReference<Object>> f6575a = new WeakHashMap<>();

    private static class a {
        static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    public static boolean a(LocationManager locationManager) {
        return Build.VERSION.SDK_INT >= 28 ? a.c(locationManager) : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }
}
