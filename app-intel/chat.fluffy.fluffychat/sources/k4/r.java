package k4;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public int f19095a;

    /* renamed from: b, reason: collision with root package name */
    public WindowManager f19096b;

    /* renamed from: c, reason: collision with root package name */
    public OrientationEventListener f19097c;

    /* renamed from: d, reason: collision with root package name */
    public q f19098d;

    public class a extends OrientationEventListener {
        public a(Context context, int i7) {
            super(context, i7);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i7) {
            int rotation;
            WindowManager windowManager = r.this.f19096b;
            q qVar = r.this.f19098d;
            if (r.this.f19096b == null || qVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == r.this.f19095a) {
                return;
            }
            r.this.f19095a = rotation;
            qVar.a(rotation);
        }
    }

    public void e(Context context, q qVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f19098d = qVar;
        this.f19096b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f19097c = aVar;
        aVar.enable();
        this.f19095a = this.f19096b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f19097c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f19097c = null;
        this.f19096b = null;
        this.f19098d = null;
    }
}
