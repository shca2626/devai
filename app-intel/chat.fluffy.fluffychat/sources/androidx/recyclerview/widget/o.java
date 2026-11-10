package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final b f13459a;

    /* renamed from: b, reason: collision with root package name */
    public a f13460b = new a();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f13461a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f13462b;

        /* renamed from: c, reason: collision with root package name */
        public int f13463c;

        /* renamed from: d, reason: collision with root package name */
        public int f13464d;

        /* renamed from: e, reason: collision with root package name */
        public int f13465e;

        public void a(int i7) {
            this.f13461a = i7 | this.f13461a;
        }

        public boolean b() {
            int i7 = this.f13461a;
            if ((i7 & 7) != 0 && (i7 & c(this.f13464d, this.f13462b)) == 0) {
                return false;
            }
            int i8 = this.f13461a;
            if ((i8 & 112) != 0 && (i8 & (c(this.f13464d, this.f13463c) << 4)) == 0) {
                return false;
            }
            int i9 = this.f13461a;
            if ((i9 & 1792) != 0 && (i9 & (c(this.f13465e, this.f13462b) << 8)) == 0) {
                return false;
            }
            int i10 = this.f13461a;
            return (i10 & 28672) == 0 || (i10 & (c(this.f13465e, this.f13463c) << 12)) != 0;
        }

        public int c(int i7, int i8) {
            if (i7 > i8) {
                return 1;
            }
            return i7 == i8 ? 2 : 4;
        }

        public void d() {
            this.f13461a = 0;
        }

        public void e(int i7, int i8, int i9, int i10) {
            this.f13462b = i7;
            this.f13463c = i8;
            this.f13464d = i9;
            this.f13465e = i10;
        }
    }

    public interface b {
        View a(int i7);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public o(b bVar) {
        this.f13459a = bVar;
    }

    public View a(int i7, int i8, int i9, int i10) {
        int iC = this.f13459a.c();
        int iD = this.f13459a.d();
        int i11 = i8 > i7 ? 1 : -1;
        View view = null;
        while (i7 != i8) {
            View viewA = this.f13459a.a(i7);
            this.f13460b.e(iC, iD, this.f13459a.b(viewA), this.f13459a.e(viewA));
            if (i9 != 0) {
                this.f13460b.d();
                this.f13460b.a(i9);
                if (this.f13460b.b()) {
                    return viewA;
                }
            }
            if (i10 != 0) {
                this.f13460b.d();
                this.f13460b.a(i10);
                if (this.f13460b.b()) {
                    view = viewA;
                }
            }
            i7 += i11;
        }
        return view;
    }

    public boolean b(View view, int i7) {
        this.f13460b.e(this.f13459a.c(), this.f13459a.d(), this.f13459a.b(view), this.f13459a.e(view));
        if (i7 == 0) {
            return false;
        }
        this.f13460b.d();
        this.f13460b.a(i7);
        return this.f13460b.b();
    }
}
