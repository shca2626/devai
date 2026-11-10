package Q2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class c extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    public d f7662a;

    /* renamed from: b, reason: collision with root package name */
    public int f7663b;

    /* renamed from: c, reason: collision with root package name */
    public int f7664c;

    public c() {
        this.f7663b = 0;
        this.f7664c = 0;
    }

    public int E() {
        d dVar = this.f7662a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    public void F(CoordinatorLayout coordinatorLayout, View view, int i7) {
        coordinatorLayout.G(view, i7);
    }

    public boolean G(int i7) {
        d dVar = this.f7662a;
        if (dVar != null) {
            return dVar.e(i7);
        }
        this.f7663b = i7;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
        F(coordinatorLayout, view, i7);
        if (this.f7662a == null) {
            this.f7662a = new d(view);
        }
        this.f7662a.c();
        this.f7662a.a();
        int i8 = this.f7663b;
        if (i8 != 0) {
            this.f7662a.e(i8);
            this.f7663b = 0;
        }
        int i9 = this.f7664c;
        if (i9 == 0) {
            return true;
        }
        this.f7662a.d(i9);
        this.f7664c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7663b = 0;
        this.f7664c = 0;
    }
}
