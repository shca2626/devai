package Z;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: Z.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0710o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10061a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0712p f10062b;

    /* renamed from: c, reason: collision with root package name */
    public final b f10063c;

    /* renamed from: d, reason: collision with root package name */
    public final a f10064d;

    /* renamed from: e, reason: collision with root package name */
    public VelocityTracker f10065e;

    /* renamed from: f, reason: collision with root package name */
    public float f10066f;

    /* renamed from: g, reason: collision with root package name */
    public int f10067g;

    /* renamed from: h, reason: collision with root package name */
    public int f10068h;

    /* renamed from: i, reason: collision with root package name */
    public int f10069i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f10070j;

    /* renamed from: Z.o$a */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i7);
    }

    /* renamed from: Z.o$b */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i7);
    }

    public C0710o(Context context, InterfaceC0712p interfaceC0712p) {
        this(context, interfaceC0712p, new b() { // from class: Z.m
            @Override // Z.C0710o.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i7) {
                C0710o.c(context2, iArr, motionEvent, i7);
            }
        }, new a() { // from class: Z.n
            @Override // Z.C0710o.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i7) {
                return C0710o.f(velocityTracker, motionEvent, i7);
            }
        });
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i7) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = Z.i(context, viewConfiguration, motionEvent.getDeviceId(), i7, motionEvent.getSource());
        iArr[1] = Z.h(context, viewConfiguration, motionEvent.getDeviceId(), i7, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i7) {
        T.a(velocityTracker, motionEvent);
        T.b(velocityTracker, 1000);
        return T.d(velocityTracker, i7);
    }

    public final boolean d(MotionEvent motionEvent, int i7) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f10068h == source && this.f10069i == deviceId && this.f10067g == i7) {
            return false;
        }
        this.f10063c.a(this.f10061a, this.f10070j, motionEvent, i7);
        this.f10068h = source;
        this.f10069i = deviceId;
        this.f10067g = i7;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i7) {
        if (this.f10065e == null) {
            this.f10065e = VelocityTracker.obtain();
        }
        return this.f10064d.a(this.f10065e, motionEvent, i7);
    }

    public void g(MotionEvent motionEvent, int i7) {
        boolean zD = d(motionEvent, i7);
        if (this.f10070j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f10065e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10065e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i7) * this.f10062b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f10066f) && fSignum != 0.0f)) {
            this.f10062b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f10070j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f10066f = this.f10062b.a(fMax) ? fMax : 0.0f;
    }

    public C0710o(Context context, InterfaceC0712p interfaceC0712p, b bVar, a aVar) {
        this.f10067g = -1;
        this.f10068h = -1;
        this.f10069i = -1;
        this.f10070j = new int[]{Integer.MAX_VALUE, 0};
        this.f10061a = context;
        this.f10062b = interfaceC0712p;
        this.f10063c = bVar;
        this.f10064d = aVar;
    }
}
