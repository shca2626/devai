package j;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
public class y {

    /* renamed from: d, reason: collision with root package name */
    public static y f18616d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f18617a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationManager f18618b;

    /* renamed from: c, reason: collision with root package name */
    public final a f18619c = new a();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f18620a;

        /* renamed from: b, reason: collision with root package name */
        public long f18621b;
    }

    public y(Context context, LocationManager locationManager) {
        this.f18617a = context;
        this.f18618b = locationManager;
    }

    public static y a(Context context) {
        if (f18616d == null) {
            Context applicationContext = context.getApplicationContext();
            f18616d = new y(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f18616d;
    }

    public final Location b() {
        Location locationC = L.g.b(this.f18617a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = L.g.b(this.f18617a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    public final Location c(String str) {
        try {
            if (this.f18618b.isProviderEnabled(str)) {
                return this.f18618b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e7) {
            Log.d("TwilightManager", "Failed to get last known location", e7);
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f18619c;
        if (e()) {
            return aVar.f18620a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f18620a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i7 = Calendar.getInstance().get(11);
        return i7 < 6 || i7 >= 22;
    }

    public final boolean e() {
        return this.f18619c.f18621b > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long j7;
        a aVar = this.f18619c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        x xVarB = x.b();
        xVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        xVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z7 = xVarB.f18615c == 1;
        long j8 = xVarB.f18614b;
        long j9 = xVarB.f18613a;
        xVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j10 = xVarB.f18614b;
        if (j8 == -1 || j9 == -1) {
            j7 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis > j9) {
                j8 = j10;
            } else if (jCurrentTimeMillis > j8) {
                j8 = j9;
            }
            j7 = j8 + 60000;
        }
        aVar.f18620a = z7;
        aVar.f18621b = j7;
    }
}
