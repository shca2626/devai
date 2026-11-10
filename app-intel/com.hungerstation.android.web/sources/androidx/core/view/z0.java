package androidx.core.view;

import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes7.dex */
class z0 {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f6820a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f6821b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    private float f6822c = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: d, reason: collision with root package name */
    private int f6823d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f6824e = 0;

    z0() {
    }

    private void b() {
        this.f6823d = 0;
        this.f6822c = BitmapDescriptorFactory.HUE_RED;
    }

    private float e() {
        long[] jArr;
        long j12;
        int i12 = this.f6823d;
        if (i12 < 2) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i13 = this.f6824e;
        int i14 = ((i13 + 20) - (i12 - 1)) % 20;
        long j13 = this.f6821b[i13];
        while (true) {
            jArr = this.f6821b;
            j12 = jArr[i14];
            if (j13 - j12 <= 100) {
                break;
            }
            this.f6823d--;
            i14 = (i14 + 1) % 20;
        }
        int i15 = this.f6823d;
        if (i15 < 2) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (i15 == 2) {
            int i16 = (i14 + 1) % 20;
            return j12 == jArr[i16] ? BitmapDescriptorFactory.HUE_RED : this.f6820a[i16] / (r2 - j12);
        }
        int i17 = 0;
        float fAbs = BitmapDescriptorFactory.HUE_RED;
        for (int i18 = 0; i18 < this.f6823d - 1; i18++) {
            int i19 = i18 + i14;
            long[] jArr2 = this.f6821b;
            long j14 = jArr2[i19 % 20];
            int i22 = (i19 + 1) % 20;
            if (jArr2[i22] != j14) {
                i17++;
                float f12 = f(fAbs);
                float f13 = this.f6820a[i22] / (this.f6821b[i22] - j14);
                fAbs += (f13 - f12) * Math.abs(f13);
                if (i17 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }

    private static float f(float f12) {
        return (f12 < BitmapDescriptorFactory.HUE_RED ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f12) * 2.0f));
    }

    void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f6823d != 0 && eventTime - this.f6821b[this.f6824e] > 40) {
            b();
        }
        int i12 = (this.f6824e + 1) % 20;
        this.f6824e = i12;
        int i13 = this.f6823d;
        if (i13 != 20) {
            this.f6823d = i13 + 1;
        }
        this.f6820a[i12] = motionEvent.getAxisValue(26);
        this.f6821b[this.f6824e] = eventTime;
    }

    void c(int i12, float f12) {
        float fE = e() * i12;
        this.f6822c = fE;
        if (fE < (-Math.abs(f12))) {
            this.f6822c = -Math.abs(f12);
        } else if (this.f6822c > Math.abs(f12)) {
            this.f6822c = Math.abs(f12);
        }
    }

    float d(int i12) {
        return i12 != 26 ? BitmapDescriptorFactory.HUE_RED : this.f6822c;
    }
}
