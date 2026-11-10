package Z1;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public abstract class G extends D {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f10183d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f10184e = true;

    @Override // Z1.M
    public void g(View view, Matrix matrix) {
        if (f10183d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f10183d = false;
            }
        }
    }

    @Override // Z1.M
    public void h(View view, Matrix matrix) {
        if (f10184e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f10184e = false;
            }
        }
    }
}
