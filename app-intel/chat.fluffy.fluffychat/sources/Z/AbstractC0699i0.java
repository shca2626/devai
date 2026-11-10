package Z;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* renamed from: Z.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0699i0 {

    /* renamed from: Z.i0$a */
    public static class a {
        public static void a(Window window, boolean z7) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z7 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* renamed from: Z.i0$b */
    public static class b {
        public static void a(Window window, boolean z7) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z7 ? systemUiVisibility & (-257) : systemUiVisibility | 256);
            window.setDecorFitsSystemWindows(z7);
        }
    }

    /* renamed from: Z.i0$c */
    public static class c {
        public static void a(Window window, boolean z7) {
            window.setDecorFitsSystemWindows(z7);
        }
    }

    public static N0 a(Window window, View view) {
        return new N0(window, view);
    }

    public static void b(Window window, boolean z7) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 35) {
            c.a(window, z7);
        } else if (i7 >= 30) {
            b.a(window, z7);
        } else {
            a.a(window, z7);
        }
    }
}
