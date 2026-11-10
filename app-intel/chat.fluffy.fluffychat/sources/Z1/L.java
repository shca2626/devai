package Z1;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public class L extends K {
    @Override // Z1.D, Z1.M
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // Z1.I, Z1.M
    public void d(View view, int i7, int i8, int i9, int i10) {
        view.setLeftTopRightBottom(i7, i8, i9, i10);
    }

    @Override // Z1.D, Z1.M
    public void e(View view, float f7) {
        view.setTransitionAlpha(f7);
    }

    @Override // Z1.K, Z1.M
    public void f(View view, int i7) {
        view.setTransitionVisibility(i7);
    }

    @Override // Z1.G, Z1.M
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // Z1.G, Z1.M
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
