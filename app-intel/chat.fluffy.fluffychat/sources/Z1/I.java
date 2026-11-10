package Z1;

import android.view.View;

/* loaded from: classes.dex */
public abstract class I extends G {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f10185f = true;

    @Override // Z1.M
    public void d(View view, int i7, int i8, int i9, int i10) {
        if (f10185f) {
            try {
                view.setLeftTopRightBottom(i7, i8, i9, i10);
            } catch (NoSuchMethodError unused) {
                f10185f = false;
            }
        }
    }
}
