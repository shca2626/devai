package F2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import h5.c;

/* loaded from: classes.dex */
public class B extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final c.b f2652a;

    /* renamed from: b, reason: collision with root package name */
    public F f2653b;

    public B(c.b bVar) {
        this.f2652a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction())) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
            if (zIsProviderEnabled || zIsProviderEnabled2) {
                F f7 = this.f2653b;
                if (f7 == null || f7 == F.disabled) {
                    F f8 = F.enabled;
                    this.f2653b = f8;
                    this.f2652a.success(Integer.valueOf(f8.ordinal()));
                    return;
                }
                return;
            }
            F f9 = this.f2653b;
            if (f9 == null || f9 == F.enabled) {
                F f10 = F.disabled;
                this.f2653b = f10;
                this.f2652a.success(Integer.valueOf(f10.ordinal()));
            }
        }
    }
}
