package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class e0 {

    /* renamed from: a, reason: collision with root package name */
    final b f11020a;

    /* renamed from: b, reason: collision with root package name */
    a f11021b = new a();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f11022a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f11023b;

        /* renamed from: c, reason: collision with root package name */
        int f11024c;

        /* renamed from: d, reason: collision with root package name */
        int f11025d;

        /* renamed from: e, reason: collision with root package name */
        int f11026e;

        a() {
        }

        void a(int i12) {
            this.f11022a = i12 | this.f11022a;
        }

        boolean b() {
            int i12 = this.f11022a;
            if ((i12 & 7) != 0 && (i12 & c(this.f11025d, this.f11023b)) == 0) {
                return false;
            }
            int i13 = this.f11022a;
            if ((i13 & 112) != 0 && (i13 & (c(this.f11025d, this.f11024c) << 4)) == 0) {
                return false;
            }
            int i14 = this.f11022a;
            if ((i14 & 1792) != 0 && (i14 & (c(this.f11026e, this.f11023b) << 8)) == 0) {
                return false;
            }
            int i15 = this.f11022a;
            return (i15 & 28672) == 0 || (i15 & (c(this.f11026e, this.f11024c) << 12)) != 0;
        }

        int c(int i12, int i13) {
            if (i12 > i13) {
                return 1;
            }
            return i12 == i13 ? 2 : 4;
        }

        void d() {
            this.f11022a = 0;
        }

        void e(int i12, int i13, int i14, int i15) {
            this.f11023b = i12;
            this.f11024c = i13;
            this.f11025d = i14;
            this.f11026e = i15;
        }
    }

    interface b {
        View a(int i12);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    e0(b bVar) {
        this.f11020a = bVar;
    }

    View a(int i12, int i13, int i14, int i15) {
        int iC = this.f11020a.c();
        int iD = this.f11020a.d();
        int i16 = i13 > i12 ? 1 : -1;
        View view = null;
        while (i12 != i13) {
            View viewA = this.f11020a.a(i12);
            this.f11021b.e(iC, iD, this.f11020a.b(viewA), this.f11020a.e(viewA));
            if (i14 != 0) {
                this.f11021b.d();
                this.f11021b.a(i14);
                if (this.f11021b.b()) {
                    return viewA;
                }
            }
            if (i15 != 0) {
                this.f11021b.d();
                this.f11021b.a(i15);
                if (this.f11021b.b()) {
                    view = viewA;
                }
            }
            i12 += i16;
        }
        return view;
    }

    boolean b(View view, int i12) {
        this.f11021b.e(this.f11020a.c(), this.f11020a.d(), this.f11020a.b(view), this.f11020a.e(view));
        if (i12 == 0) {
            return false;
        }
        this.f11021b.d();
        this.f11021b.a(i12);
        return this.f11021b.b();
    }
}
