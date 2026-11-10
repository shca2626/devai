package Z1;

import android.view.View;

/* loaded from: classes.dex */
public abstract class D extends M {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f10182c = true;

    @Override // Z1.M
    public float b(View view) {
        if (f10182c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f10182c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // Z1.M
    public void e(View view, float f7) {
        if (f10182c) {
            try {
                view.setTransitionAlpha(f7);
                return;
            } catch (NoSuchMethodError unused) {
                f10182c = false;
            }
        }
        view.setAlpha(f7);
    }

    @Override // Z1.M
    public void a(View view) {
    }

    @Override // Z1.M
    public void c(View view) {
    }
}
