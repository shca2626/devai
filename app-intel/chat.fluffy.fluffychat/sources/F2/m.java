package F2;

import S.d;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class m implements l, S.a {

    /* renamed from: a, reason: collision with root package name */
    public final LocationManager f2697a;

    /* renamed from: b, reason: collision with root package name */
    public final D f2698b;

    /* renamed from: c, reason: collision with root package name */
    public final z f2699c;

    /* renamed from: d, reason: collision with root package name */
    public Context f2700d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2701e = false;

    /* renamed from: f, reason: collision with root package name */
    public Location f2702f;

    /* renamed from: g, reason: collision with root package name */
    public String f2703g;

    /* renamed from: h, reason: collision with root package name */
    public E f2704h;

    /* renamed from: i, reason: collision with root package name */
    public E2.a f2705i;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2706a;

        static {
            int[] iArr = new int[i.values().length];
            f2706a = iArr;
            try {
                iArr[i.lowest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2706a[i.low.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2706a[i.high.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2706a[i.best.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2706a[i.bestForNavigation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2706a[i.medium.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public m(Context context, z zVar) {
        this.f2697a = (LocationManager) context.getSystemService("location");
        this.f2699c = zVar;
        this.f2700d = context;
        this.f2698b = new D(context, zVar);
    }

    public static int g(i iVar) {
        int i7 = a.f2706a[iVar.ordinal()];
        if (i7 == 1 || i7 == 2) {
            return 104;
        }
        return (i7 == 3 || i7 == 4 || i7 == 5) ? 100 : 102;
    }

    public static String h(LocationManager locationManager, i iVar) {
        List<String> providers = locationManager.getProviders(true);
        if (iVar == i.lowest) {
            return "passive";
        }
        if (providers.contains("fused") && Build.VERSION.SDK_INT >= 31) {
            return "fused";
        }
        if (providers.contains("gps")) {
            return "gps";
        }
        if (providers.contains("network")) {
            return "network";
        }
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    public static boolean i(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z7 = time > 120000;
        boolean z8 = time < -120000;
        boolean z9 = time > 0;
        if (z7) {
            return true;
        }
        if (z8) {
            return false;
        }
        float accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z10 = accuracy > 0.0f;
        boolean z11 = accuracy < 0.0f;
        boolean z12 = accuracy > 200.0f;
        boolean zEquals = location.getProvider() != null ? location.getProvider().equals(location2.getProvider()) : false;
        if (z11) {
            return true;
        }
        if (!z9 || z10) {
            return z9 && !z12 && zEquals;
        }
        return true;
    }

    @Override // F2.l
    public void b(Activity activity, E e7, E2.a aVar) {
        long jC;
        float f7;
        int iG;
        if (!a(this.f2700d)) {
            aVar.a(E2.b.locationServicesDisabled);
            return;
        }
        this.f2704h = e7;
        this.f2705i = aVar;
        i iVar = i.best;
        z zVar = this.f2699c;
        if (zVar != null) {
            float fB = zVar.b();
            i iVarA = this.f2699c.a();
            jC = iVarA == i.lowest ? Long.MAX_VALUE : this.f2699c.c();
            iG = g(iVarA);
            f7 = fB;
            iVar = iVarA;
        } else {
            jC = 0;
            f7 = 0.0f;
            iG = 102;
        }
        String strH = h(this.f2697a, iVar);
        this.f2703g = strH;
        if (strH == null) {
            aVar.a(E2.b.locationServicesDisabled);
            return;
        }
        S.d dVarA = new d.c(jC).c(f7).d(jC).e(iG).a();
        this.f2701e = true;
        this.f2698b.g();
        S.b.a(this.f2697a, this.f2703g, dVarA, this, Looper.getMainLooper());
    }

    @Override // F2.l
    public void c(A a7) {
        if (this.f2697a == null) {
            a7.a(false);
        } else {
            a7.a(a(this.f2700d));
        }
    }

    @Override // F2.l
    public boolean d(int i7, int i8) {
        return false;
    }

    @Override // F2.l
    public void e(E e7, E2.a aVar) {
        Iterator<String> it = this.f2697a.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = this.f2697a.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && i(lastKnownLocation, location)) {
                location = lastKnownLocation;
            }
        }
        e7.a(location);
    }

    @Override // F2.l
    public void f() {
        this.f2701e = false;
        this.f2698b.h();
        this.f2697a.removeUpdates(this);
    }

    @Override // android.location.LocationListener
    public synchronized void onLocationChanged(Location location) {
        if (i(location, this.f2702f)) {
            this.f2702f = location;
            if (this.f2704h != null) {
                this.f2698b.f(location);
                this.f2704h.a(this.f2702f);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if (str.equals(this.f2703g)) {
            if (this.f2701e) {
                this.f2697a.removeUpdates(this);
            }
            E2.a aVar = this.f2705i;
            if (aVar != null) {
                aVar.a(E2.b.locationServicesDisabled);
            }
            this.f2703g = null;
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i7, Bundle bundle) {
        if (i7 == 2) {
            onProviderEnabled(str);
        } else if (i7 == 0) {
            onProviderDisabled(str);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }
}
