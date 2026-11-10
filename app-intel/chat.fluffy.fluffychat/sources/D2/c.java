package D2;

import F2.B;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import h5.c;

/* loaded from: classes.dex */
public class c implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public h5.c f1661l;

    /* renamed from: m, reason: collision with root package name */
    public Context f1662m;

    /* renamed from: n, reason: collision with root package name */
    public B f1663n;

    public final void a() {
        B b7;
        Context context = this.f1662m;
        if (context == null || (b7 = this.f1663n) == null) {
            return;
        }
        context.unregisterReceiver(b7);
    }

    public void b(Context context) {
        this.f1662m = context;
    }

    public void c(Context context, h5.b bVar) {
        if (this.f1661l != null) {
            Log.w("LocationServiceHandler", "Setting a event call handler before the last was disposed.");
            d();
        }
        h5.c cVar = new h5.c(bVar, "flutter.baseflow.com/geolocator_service_updates_android");
        this.f1661l = cVar;
        cVar.d(this);
        this.f1662m = context;
    }

    public void d() {
        if (this.f1661l == null) {
            return;
        }
        a();
        this.f1661l.d(null);
        this.f1661l = null;
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        a();
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        if (this.f1662m == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.location.PROVIDERS_CHANGED");
        intentFilter.addAction("android.intent.action.PROVIDER_CHANGED");
        B b7 = new B(bVar);
        this.f1663n = b7;
        L.b.j(this.f1662m, b7, intentFilter, 2);
    }
}
