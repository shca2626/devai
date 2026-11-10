package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0123b f13317a;

    /* renamed from: b, reason: collision with root package name */
    public final a f13318b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final List f13319c = new ArrayList();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f13320a = 0;

        /* renamed from: b, reason: collision with root package name */
        public a f13321b;

        public void a(int i7) {
            if (i7 < 64) {
                this.f13320a &= ~(1 << i7);
                return;
            }
            a aVar = this.f13321b;
            if (aVar != null) {
                aVar.a(i7 - 64);
            }
        }

        public int b(int i7) {
            a aVar = this.f13321b;
            return aVar == null ? i7 >= 64 ? Long.bitCount(this.f13320a) : Long.bitCount(this.f13320a & ((1 << i7) - 1)) : i7 < 64 ? Long.bitCount(this.f13320a & ((1 << i7) - 1)) : aVar.b(i7 - 64) + Long.bitCount(this.f13320a);
        }

        public final void c() {
            if (this.f13321b == null) {
                this.f13321b = new a();
            }
        }

        public boolean d(int i7) {
            if (i7 < 64) {
                return (this.f13320a & (1 << i7)) != 0;
            }
            c();
            return this.f13321b.d(i7 - 64);
        }

        public void e(int i7, boolean z7) {
            if (i7 >= 64) {
                c();
                this.f13321b.e(i7 - 64, z7);
                return;
            }
            long j7 = this.f13320a;
            boolean z8 = (Long.MIN_VALUE & j7) != 0;
            long j8 = (1 << i7) - 1;
            this.f13320a = ((j7 & (~j8)) << 1) | (j7 & j8);
            if (z7) {
                h(i7);
            } else {
                a(i7);
            }
            if (z8 || this.f13321b != null) {
                c();
                this.f13321b.e(0, z8);
            }
        }

        public boolean f(int i7) {
            if (i7 >= 64) {
                c();
                return this.f13321b.f(i7 - 64);
            }
            long j7 = 1 << i7;
            long j8 = this.f13320a;
            boolean z7 = (j8 & j7) != 0;
            long j9 = j8 & (~j7);
            this.f13320a = j9;
            long j10 = j7 - 1;
            this.f13320a = (j9 & j10) | Long.rotateRight((~j10) & j9, 1);
            a aVar = this.f13321b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f13321b.f(0);
            }
            return z7;
        }

        public void g() {
            this.f13320a = 0L;
            a aVar = this.f13321b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i7) {
            if (i7 < 64) {
                this.f13320a |= 1 << i7;
            } else {
                c();
                this.f13321b.h(i7 - 64);
            }
        }

        public String toString() {
            if (this.f13321b == null) {
                return Long.toBinaryString(this.f13320a);
            }
            return this.f13321b.toString() + "xx" + Long.toBinaryString(this.f13320a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0123b {
        View a(int i7);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.C f(View view);

        void g(int i7);

        void h(View view);

        void i(View view, int i7);

        void j(int i7);

        void k(View view, int i7, ViewGroup.LayoutParams layoutParams);
    }

    public b(InterfaceC0123b interfaceC0123b) {
        this.f13317a = interfaceC0123b;
    }

    public void a(View view, int i7, boolean z7) {
        int iC = i7 < 0 ? this.f13317a.c() : h(i7);
        this.f13318b.e(iC, z7);
        if (z7) {
            l(view);
        }
        this.f13317a.i(view, iC);
    }

    public void b(View view, boolean z7) {
        a(view, -1, z7);
    }

    public void c(View view, int i7, ViewGroup.LayoutParams layoutParams, boolean z7) {
        int iC = i7 < 0 ? this.f13317a.c() : h(i7);
        this.f13318b.e(iC, z7);
        if (z7) {
            l(view);
        }
        this.f13317a.k(view, iC, layoutParams);
    }

    public void d(int i7) {
        int iH = h(i7);
        this.f13318b.f(iH);
        this.f13317a.g(iH);
    }

    public View e(int i7) {
        int size = this.f13319c.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view = (View) this.f13319c.get(i8);
            RecyclerView.C cF = this.f13317a.f(view);
            if (cF.m() == i7 && !cF.t() && !cF.v()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i7) {
        return this.f13317a.a(h(i7));
    }

    public int g() {
        return this.f13317a.c() - this.f13319c.size();
    }

    public final int h(int i7) {
        if (i7 < 0) {
            return -1;
        }
        int iC = this.f13317a.c();
        int i8 = i7;
        while (i8 < iC) {
            int iB = i7 - (i8 - this.f13318b.b(i8));
            if (iB == 0) {
                while (this.f13318b.d(i8)) {
                    i8++;
                }
                return i8;
            }
            i8 += iB;
        }
        return -1;
    }

    public View i(int i7) {
        return this.f13317a.a(i7);
    }

    public int j() {
        return this.f13317a.c();
    }

    public void k(View view) {
        int iE = this.f13317a.e(view);
        if (iE >= 0) {
            this.f13318b.h(iE);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f13319c.add(view);
        this.f13317a.b(view);
    }

    public int m(View view) {
        int iE = this.f13317a.e(view);
        if (iE == -1 || this.f13318b.d(iE)) {
            return -1;
        }
        return iE - this.f13318b.b(iE);
    }

    public boolean n(View view) {
        return this.f13319c.contains(view);
    }

    public void o() {
        this.f13318b.g();
        for (int size = this.f13319c.size() - 1; size >= 0; size--) {
            this.f13317a.h((View) this.f13319c.get(size));
            this.f13319c.remove(size);
        }
        this.f13317a.d();
    }

    public void p(View view) {
        int iE = this.f13317a.e(view);
        if (iE < 0) {
            return;
        }
        if (this.f13318b.f(iE)) {
            t(view);
        }
        this.f13317a.j(iE);
    }

    public void q(int i7) {
        int iH = h(i7);
        View viewA = this.f13317a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f13318b.f(iH)) {
            t(viewA);
        }
        this.f13317a.j(iH);
    }

    public boolean r(View view) {
        int iE = this.f13317a.e(view);
        if (iE == -1) {
            t(view);
            return true;
        }
        if (!this.f13318b.d(iE)) {
            return false;
        }
        this.f13318b.f(iE);
        t(view);
        this.f13317a.j(iE);
        return true;
    }

    public void s(View view) {
        int iE = this.f13317a.e(view);
        if (iE < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f13318b.d(iE)) {
            this.f13318b.a(iE);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f13319c.remove(view)) {
            return false;
        }
        this.f13317a.h(view);
        return true;
    }

    public String toString() {
        return this.f13318b.toString() + ", hidden list:" + this.f13319c.size();
    }
}
