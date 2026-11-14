package k4;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public int f19094a;

    /* renamed from: b, reason: collision with root package name */
    public WindowManager f19095b;

    /* renamed from: c, reason: collision with root package name */
    public OrientationEventListener f19096c;

    /* renamed from: d, reason: collision with root package name */
    public q f19097d;

    public class a extends OrientationEventListener {
        public a(Context context, int i7) {
            super(context, i7);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i7) {
            int rotation;
            WindowManager windowManager = r.this.f19095b;
            q qVar = r.this.f19097d;
            if (r.this.f19095b == null || qVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == r.this.f19094a) {
                return;
            }
            r.this.f19094a = rotation;
            qVar.a(rotation);
        }
    }

    public void e(Context context, q qVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f19097d = qVar;
        this.f19095b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f19096c = aVar;
        aVar.enable();
        this.f19094a = this.f19095b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f19096c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f19096c = null;
        this.f19095b = null;
        this.f19097d = null;
    }
}
