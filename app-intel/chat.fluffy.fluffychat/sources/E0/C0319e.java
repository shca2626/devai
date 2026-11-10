package E0;

import android.os.Looper;
import j3.InterfaceC1232f;

/* renamed from: E0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0319e {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0329o f2146a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0329o f2147b;

    /* renamed from: c, reason: collision with root package name */
    public final a f2148c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2149d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2150e;

    /* renamed from: f, reason: collision with root package name */
    public int f2151f;

    /* renamed from: E0.e$a */
    public interface a {
        void a(Object obj, Object obj2);
    }

    public C0319e(Object obj, Looper looper, Looper looper2, InterfaceC0321g interfaceC0321g, a aVar) {
        this.f2146a = interfaceC0321g.c(looper, null);
        this.f2147b = interfaceC0321g.c(looper2, null);
        this.f2149d = obj;
        this.f2150e = obj;
        this.f2148c = aVar;
    }

    public static /* synthetic */ void a(final C0319e c0319e, InterfaceC1232f interfaceC1232f) {
        final Object objApply = interfaceC1232f.apply(c0319e.f2150e);
        c0319e.f2150e = objApply;
        c0319e.f(new Runnable() { // from class: E0.d
            @Override // java.lang.Runnable
            public final void run() {
                C0319e.c(this.f2142l, objApply);
            }
        });
    }

    public static /* synthetic */ void b(C0319e c0319e, Object obj) {
        if (c0319e.f2151f == 0) {
            c0319e.i(obj);
        }
    }

    public static /* synthetic */ void c(C0319e c0319e, Object obj) {
        int i7 = c0319e.f2151f - 1;
        c0319e.f2151f = i7;
        if (i7 == 0) {
            c0319e.i(obj);
        }
    }

    public Object d() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == this.f2147b.n()) {
            return this.f2149d;
        }
        j3.o.v(looperMyLooper == this.f2146a.n());
        return this.f2150e;
    }

    public void e(Runnable runnable) {
        if (this.f2146a.n().getThread().isAlive()) {
            this.f2146a.c(runnable);
        }
    }

    public final void f(Runnable runnable) {
        if (this.f2147b.n().getThread().isAlive()) {
            this.f2147b.c(runnable);
        }
    }

    public void g(final Object obj) {
        this.f2150e = obj;
        f(new Runnable() { // from class: E0.b
            @Override // java.lang.Runnable
            public final void run() {
                C0319e.b(this.f2132l, obj);
            }
        });
    }

    public void h(InterfaceC1232f interfaceC1232f, final InterfaceC1232f interfaceC1232f2) {
        j3.o.v(Looper.myLooper() == this.f2147b.n());
        this.f2151f++;
        e(new Runnable() { // from class: E0.c
            @Override // java.lang.Runnable
            public final void run() {
                C0319e.a(this.f2136l, interfaceC1232f2);
            }
        });
        i(interfaceC1232f.apply(this.f2149d));
    }

    public final void i(Object obj) {
        Object obj2 = this.f2149d;
        this.f2149d = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.f2148c.a(obj2, obj);
    }
}
