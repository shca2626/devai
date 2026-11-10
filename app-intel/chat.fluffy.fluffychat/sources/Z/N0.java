package Z;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import y.C1797k;

/* loaded from: classes.dex */
public final class N0 {

    /* renamed from: a, reason: collision with root package name */
    public final g f9946a;

    public static class a extends g {

        /* renamed from: a, reason: collision with root package name */
        public final Window f9947a;

        /* renamed from: b, reason: collision with root package name */
        public final S f9948b;

        public a(Window window, S s7) {
            this.f9947a = window;
            this.f9948b = s7;
        }

        public void c(int i7) {
            View decorView = this.f9947a.getDecorView();
            decorView.setSystemUiVisibility(i7 | decorView.getSystemUiVisibility());
        }

        public void d(int i7) {
            this.f9947a.addFlags(i7);
        }

        public void e(int i7) {
            View decorView = this.f9947a.getDecorView();
            decorView.setSystemUiVisibility((~i7) & decorView.getSystemUiVisibility());
        }

        public void f(int i7) {
            this.f9947a.clearFlags(i7);
        }
    }

    public static class b extends a {
        public b(Window window, S s7) {
            super(window, s7);
        }

        @Override // Z.N0.g
        public void b(boolean z7) {
            if (!z7) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    public static class c extends b {
        public c(Window window, S s7) {
            super(window, s7);
        }

        @Override // Z.N0.g
        public void a(boolean z7) {
            if (!z7) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    public static class e extends d {
        public e(Window window, N0 n02, S s7) {
            super(window, n02, s7);
        }
    }

    public static class f extends e {
        public f(Window window, N0 n02, S s7) {
            super(window, n02, s7);
        }

        @Override // Z.N0.d, Z.N0.g
        public void a(boolean z7) {
            this.f9950b.setSystemBarsAppearance(z7 ? 16 : 0, 16);
        }

        @Override // Z.N0.d, Z.N0.g
        public void b(boolean z7) {
            this.f9950b.setSystemBarsAppearance(z7 ? 8 : 0, 8);
        }
    }

    public N0(Window window, View view) {
        S s7 = new S(view);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 35) {
            this.f9946a = new f(window, this, s7);
            return;
        }
        if (i7 >= 30) {
            this.f9946a = new d(window, this, s7);
        } else if (i7 >= 26) {
            this.f9946a = new c(window, s7);
        } else {
            this.f9946a = new b(window, s7);
        }
    }

    public void a(boolean z7) {
        this.f9946a.a(z7);
    }

    public void b(boolean z7) {
        this.f9946a.b(z7);
    }

    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        public final N0 f9949a;

        /* renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f9950b;

        /* renamed from: c, reason: collision with root package name */
        public final S f9951c;

        /* renamed from: d, reason: collision with root package name */
        public final C1797k f9952d;

        /* renamed from: e, reason: collision with root package name */
        public Window f9953e;

        public d(Window window, N0 n02, S s7) {
            this(window.getInsetsController(), n02, s7);
            this.f9953e = window;
        }

        @Override // Z.N0.g
        public void a(boolean z7) {
            c(z7, 16, 16);
        }

        @Override // Z.N0.g
        public void b(boolean z7) {
            c(z7, 8192, 8);
        }

        public final void c(boolean z7, int i7, int i8) {
            if (this.f9953e != null) {
                if (z7) {
                    d(i7);
                    return;
                } else {
                    e(i7);
                    return;
                }
            }
            if (z7) {
                this.f9950b.setSystemBarsAppearance(i8, i8);
            } else {
                this.f9950b.setSystemBarsAppearance(0, i8);
            }
        }

        public void d(int i7) {
            View decorView = this.f9953e.getDecorView();
            decorView.setSystemUiVisibility(i7 | decorView.getSystemUiVisibility());
        }

        public void e(int i7) {
            View decorView = this.f9953e.getDecorView();
            decorView.setSystemUiVisibility((~i7) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, N0 n02, S s7) {
            this.f9952d = new C1797k();
            this.f9950b = windowInsetsController;
            this.f9949a = n02;
            this.f9951c = s7;
        }
    }

    public static class g {
        public abstract void b(boolean z7);

        public void a(boolean z7) {
        }
    }
}
