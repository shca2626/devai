package F2;

import android.content.Context;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.os.Handler;
import java.util.Calendar;

/* loaded from: classes.dex */
public class D {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2655a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationManager f2656b;

    /* renamed from: c, reason: collision with root package name */
    public final z f2657c;

    /* renamed from: f, reason: collision with root package name */
    public String f2660f;

    /* renamed from: g, reason: collision with root package name */
    public double f2661g;

    /* renamed from: h, reason: collision with root package name */
    public double f2662h;

    /* renamed from: i, reason: collision with root package name */
    public Calendar f2663i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2664j = false;

    /* renamed from: d, reason: collision with root package name */
    public OnNmeaMessageListener f2658d = new OnNmeaMessageListener() { // from class: F2.C
        @Override // android.location.OnNmeaMessageListener
        public final void onNmeaMessage(String str, long j7) {
            D.a(this.f2654a, str, j7);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public GnssStatus.Callback f2659e = new a();

    public class a extends GnssStatus.Callback {
        public a() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            D.this.f2661g = gnssStatus.getSatelliteCount();
            D.this.f2662h = 0.0d;
            for (int i7 = 0; i7 < D.this.f2661g; i7++) {
                if (gnssStatus.usedInFix(i7)) {
                    D.e(D.this);
                }
            }
        }
    }

    public D(Context context, z zVar) {
        this.f2655a = context;
        this.f2657c = zVar;
        this.f2656b = (LocationManager) context.getSystemService("location");
    }

    public static /* synthetic */ void a(D d7, String str, long j7) {
        d7.getClass();
        if (str.trim().matches("^\\$..GGA.*$")) {
            d7.f2660f = str;
            d7.f2663i = Calendar.getInstance();
        }
    }

    public static /* synthetic */ double e(D d7) {
        double d8 = d7.f2662h + 1.0d;
        d7.f2662h = d8;
        return d8;
    }

    public void f(Location location) throws NumberFormatException {
        if (location == null) {
            return;
        }
        if (location.getExtras() == null) {
            location.setExtras(Bundle.EMPTY);
        }
        location.getExtras().putDouble("geolocator_mslSatelliteCount", this.f2661g);
        location.getExtras().putDouble("geolocator_mslSatellitesUsedInFix", this.f2662h);
        if (this.f2660f == null || this.f2657c == null || !this.f2664j) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, -5);
        Calendar calendar2 = this.f2663i;
        if ((calendar2 == null || !calendar2.before(calendar)) && this.f2657c.d()) {
            String[] strArrSplit = this.f2660f.split(",");
            String str = strArrSplit[0];
            if (!this.f2660f.trim().matches("^\\$..GGA.*$") || strArrSplit.length <= 9 || strArrSplit[9].isEmpty()) {
                return;
            }
            double d7 = Double.parseDouble(strArrSplit[9]);
            if (location.getExtras() == null) {
                location.setExtras(Bundle.EMPTY);
            }
            location.getExtras().putDouble("geolocator_mslAltitude", d7);
        }
    }

    public void g() {
        if (this.f2664j || this.f2657c == null || this.f2656b == null || this.f2655a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        this.f2656b.addNmeaListener(this.f2658d, (Handler) null);
        this.f2656b.registerGnssStatusCallback(this.f2659e, (Handler) null);
        this.f2664j = true;
    }

    public void h() {
        LocationManager locationManager;
        if (this.f2657c == null || (locationManager = this.f2656b) == null) {
            return;
        }
        locationManager.removeNmeaListener(this.f2658d);
        this.f2656b.unregisterGnssStatusCallback(this.f2659e);
        this.f2664j = false;
    }
}
