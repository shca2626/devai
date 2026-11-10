package H3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import l4.C1313h;

/* loaded from: classes.dex */
public final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public C1313h f3398a;

    /* renamed from: b, reason: collision with root package name */
    public l4.i f3399b;

    /* renamed from: c, reason: collision with root package name */
    public Sensor f3400c;

    /* renamed from: d, reason: collision with root package name */
    public Context f3401d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f3402e = new Handler();

    public b(Context context, C1313h c1313h, l4.i iVar) {
        this.f3401d = context;
        this.f3398a = c1313h;
        this.f3399b = iVar;
    }

    public final void b(final boolean z7) {
        this.f3402e.post(new Runnable() { // from class: H3.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f3396l.f3398a.t(z7);
            }
        });
    }

    public void c() {
        if (this.f3399b.d()) {
            SensorManager sensorManager = (SensorManager) this.f3401d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f3400c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void d() {
        if (this.f3400c != null) {
            ((SensorManager) this.f3401d.getSystemService("sensor")).unregisterListener(this);
            this.f3400c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f7 = sensorEvent.values[0];
        if (this.f3398a != null) {
            if (f7 <= 45.0f) {
                b(true);
            } else if (f7 >= 450.0f) {
                b(false);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i7) {
    }
}
