package Z;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    public int f9941a;

    /* renamed from: b, reason: collision with root package name */
    public int f9942b;

    public H(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f9941a | this.f9942b;
    }

    public void b(View view, View view2, int i7) {
        c(view, view2, i7, 0);
    }

    public void c(View view, View view2, int i7, int i8) {
        if (i8 == 1) {
            this.f9942b = i7;
        } else {
            this.f9941a = i7;
        }
    }

    public void d(View view, int i7) {
        if (i7 == 1) {
            this.f9942b = 0;
        } else {
            this.f9941a = 0;
        }
    }
}
