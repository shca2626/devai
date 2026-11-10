package o;

import Z.C0691e0;
import Z.C0695g0;
import Z.InterfaceC0693f0;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: o.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1385h {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f20305c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0693f0 f20306d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20307e;

    /* renamed from: b, reason: collision with root package name */
    public long f20304b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final C0695g0 f20308f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20303a = new ArrayList();

    /* renamed from: o.h$a */
    public class a extends C0695g0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20309a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f20310b = 0;

        public a() {
        }

        @Override // Z.C0695g0, Z.InterfaceC0693f0
        public void b(View view) {
            int i7 = this.f20310b + 1;
            this.f20310b = i7;
            if (i7 == C1385h.this.f20303a.size()) {
                InterfaceC0693f0 interfaceC0693f0 = C1385h.this.f20306d;
                if (interfaceC0693f0 != null) {
                    interfaceC0693f0.b(null);
                }
                d();
            }
        }

        @Override // Z.C0695g0, Z.InterfaceC0693f0
        public void c(View view) {
            if (this.f20309a) {
                return;
            }
            this.f20309a = true;
            InterfaceC0693f0 interfaceC0693f0 = C1385h.this.f20306d;
            if (interfaceC0693f0 != null) {
                interfaceC0693f0.c(null);
            }
        }

        public void d() {
            this.f20310b = 0;
            this.f20309a = false;
            C1385h.this.b();
        }
    }

    public void a() {
        if (this.f20307e) {
            ArrayList arrayList = this.f20303a;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                ((C0691e0) obj).c();
            }
            this.f20307e = false;
        }
    }

    public void b() {
        this.f20307e = false;
    }

    public C1385h c(C0691e0 c0691e0) {
        if (!this.f20307e) {
            this.f20303a.add(c0691e0);
        }
        return this;
    }

    public C1385h d(C0691e0 c0691e0, C0691e0 c0691e02) {
        this.f20303a.add(c0691e0);
        c0691e02.i(c0691e0.d());
        this.f20303a.add(c0691e02);
        return this;
    }

    public C1385h e(long j7) {
        if (!this.f20307e) {
            this.f20304b = j7;
        }
        return this;
    }

    public C1385h f(Interpolator interpolator) {
        if (!this.f20307e) {
            this.f20305c = interpolator;
        }
        return this;
    }

    public C1385h g(InterfaceC0693f0 interfaceC0693f0) {
        if (!this.f20307e) {
            this.f20306d = interfaceC0693f0;
        }
        return this;
    }

    public void h() {
        if (this.f20307e) {
            return;
        }
        ArrayList arrayList = this.f20303a;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            C0691e0 c0691e0 = (C0691e0) obj;
            long j7 = this.f20304b;
            if (j7 >= 0) {
                c0691e0.e(j7);
            }
            Interpolator interpolator = this.f20305c;
            if (interpolator != null) {
                c0691e0.f(interpolator);
            }
            if (this.f20306d != null) {
                c0691e0.g(this.f20308f);
            }
            c0691e0.k();
        }
        this.f20307e = true;
    }
}
