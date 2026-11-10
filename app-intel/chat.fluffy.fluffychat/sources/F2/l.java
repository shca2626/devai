package F2;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;

/* loaded from: classes.dex */
public interface l {
    default boolean a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    void b(Activity activity, E e7, E2.a aVar);

    void c(A a7);

    boolean d(int i7, int i8);

    void e(E e7, E2.a aVar);

    void f();
}
