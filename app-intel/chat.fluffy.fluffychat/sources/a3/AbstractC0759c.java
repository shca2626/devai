package a3;

import O.AbstractC0562a;
import Z.AbstractC0699i0;
import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/* renamed from: a3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0759c {
    public static void a(Window window, boolean z7, Integer num, Integer num2) {
        boolean z8 = num == null || num.intValue() == 0;
        boolean z9 = num2 == null || num2.intValue() == 0;
        if (z8 || z9) {
            int iB = V2.b.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z8) {
                num = Integer.valueOf(iB);
            }
            if (z9) {
                num2 = Integer.valueOf(iB);
            }
        }
        AbstractC0699i0.b(window, !z7);
        int iC = c(window.getContext(), z7);
        int iB2 = b(window.getContext(), z7);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, V2.b.f(num.intValue())));
        e(window, d(iB2, V2.b.f(num2.intValue())));
    }

    public static int b(Context context, boolean z7) {
        if (z7 && Build.VERSION.SDK_INT < 27) {
            return AbstractC0562a.j(V2.b.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z7) {
            return 0;
        }
        return V2.b.b(context, R.attr.navigationBarColor, -16777216);
    }

    public static int c(Context context, boolean z7) {
        if (z7) {
            return 0;
        }
        return V2.b.b(context, R.attr.statusBarColor, -16777216);
    }

    public static boolean d(int i7, boolean z7) {
        if (V2.b.f(i7)) {
            return true;
        }
        return i7 == 0 && z7;
    }

    public static void e(Window window, boolean z7) {
        AbstractC0699i0.a(window, window.getDecorView()).a(z7);
    }

    public static void f(Window window, boolean z7) {
        AbstractC0699i0.a(window, window.getDecorView()).b(z7);
    }
}
