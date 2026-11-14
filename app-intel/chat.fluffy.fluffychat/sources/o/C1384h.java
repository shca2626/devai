package o;

import Z.C0692e0;
import Z.C0696g0;
import Z.InterfaceC0694f0;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: o.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1384h {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f20304c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0694f0 f20305d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20306e;

    /* renamed from: b, reason: collision with root package name */
    public long f20303b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final C0696g0 f20307f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20302a = new ArrayList();

    /* renamed from: o.h$a */
    public class a extends C0696g0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20308a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f20309b = 0;

        public a() {
        }

        @Override // Z.C0696g0, Z.InterfaceC0694f0
        public void b(View view) {
            int i7 = this.f20309b + 1;
            this.f20309b = i7;
            if (i7 == C1384h.this.f20302a.size()) {
                InterfaceC0694f0 interfaceC0694f0 = C1384h.this.f20305d;
                if (interfaceC0694f0 != null) {
                    interfaceC0694f0.b(null);
                }
                d();
            }
        }

        @Override // Z.C0696g0, Z.InterfaceC0694f0
        public void c(View view) {
            if (this.f20308a) {
                return;
            }
            this.f20308a = true;
            InterfaceC0694f0 interfaceC0694f0 = C1384h.this.f20305d;
            if (interfaceC0694f0 != null) {
                interfaceC0694f0.c(null);
            }
        }

        public void d() {
            this.f20309b = 0;
            this.f20308a = false;
            C1384h.this.b();
        }
    }

    public void a() {
        if (this.f20306e) {
            ArrayList arrayList = this.f20302a;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                ((C0692e0) obj).c();
            }
            this.f20306e = false;
        }
    }

    public void b() {
        this.f20306e = false;
    }

    public C1384h c(C0692e0 c0692e0) {
        if (!this.f20306e) {
            this.f20302a.add(c0692e0);
        }
        return this;
    }

    public C1384h d(C0692e0 c0692e0, C0692e0 c0692e02) {
        this.f20302a.add(c0692e0);
        c0692e02.i(c0692e0.d());
        this.f20302a.add(c0692e02);
        return this;
    }

    public C1384h e(long j7) {
        if (!this.f20306e) {
            this.f20303b = j7;
        }
        return this;
    }

    public C1384h f(Interpolator interpolator) {
        if (!this.f20306e) {
            this.f20304c = interpolator;
        }
        return this;
    }

    public C1384h g(InterfaceC0694f0 interfaceC0694f0) {
        if (!this.f20306e) {
            this.f20305d = interfaceC0694f0;
        }
        return this;
    }

    public void h() {
        if (this.f20306e) {
            return;
        }
        ArrayList arrayList = this.f20302a;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            C0692e0 c0692e0 = (C0692e0) obj;
            long j7 = this.f20303b;
            if (j7 >= 0) {
                c0692e0.e(j7);
            }
            Interpolator interpolator = this.f20304c;
            if (interpolator != null) {
                c0692e0.f(interpolator);
            }
            if (this.f20305d != null) {
                c0692e0.g(this.f20307f);
            }
            c0692e0.k();
        }
        this.f20306e = true;
    }
}
