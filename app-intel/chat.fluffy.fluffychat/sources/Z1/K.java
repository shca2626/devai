package Z1;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class K extends I {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f10186g = true;

    @Override // Z1.M
    public void f(View view, int i7) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i7);
        } else if (f10186g) {
            try {
                view.setTransitionVisibility(i7);
            } catch (NoSuchMethodError unused) {
                f10186g = false;
            }
        }
    }
}
