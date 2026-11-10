package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    private int f6743a;

    /* renamed from: b, reason: collision with root package name */
    private int f6744b;

    public i0(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f6743a | this.f6744b;
    }

    public void b(View view, View view2, int i12) {
        c(view, view2, i12, 0);
    }

    public void c(View view, View view2, int i12, int i13) {
        if (i13 == 1) {
            this.f6744b = i12;
        } else {
            this.f6743a = i12;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i12) {
        if (i12 == 1) {
            this.f6744b = 0;
        } else {
            this.f6743a = 0;
        }
    }
}
