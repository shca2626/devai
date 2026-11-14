package I0;

import E0.InterfaceC0322g;
import android.os.Looper;

/* loaded from: classes.dex */
public final class B1 {

    /* renamed from: a, reason: collision with root package name */
    public final b f3541a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3542b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0322g f3543c;

    /* renamed from: d, reason: collision with root package name */
    public final B0.H f3544d;

    /* renamed from: e, reason: collision with root package name */
    public int f3545e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3546f;

    /* renamed from: g, reason: collision with root package name */
    public Looper f3547g;

    /* renamed from: h, reason: collision with root package name */
    public int f3548h;

    /* renamed from: i, reason: collision with root package name */
    public long f3549i = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3550j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3551k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3552l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3553m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3554n;

    public interface a {
        void h(B1 b12);
    }

    public interface b {
        void I(int i7, Object obj);
    }

    public B1(a aVar, b bVar, B0.H h7, int i7, InterfaceC0322g interfaceC0322g, Looper looper) {
        this.f3542b = aVar;
        this.f3541a = bVar;
        this.f3544d = h7;
        this.f3547g = looper;
        this.f3543c = interfaceC0322g;
        this.f3548h = i7;
    }

    public boolean a() {
        return this.f3550j;
    }

    public Looper b() {
        return this.f3547g;
    }

    public int c() {
        return this.f3548h;
    }

    public Object d() {
        return this.f3546f;
    }

    public long e() {
        return this.f3549i;
    }

    public b f() {
        return this.f3541a;
    }

    public B0.H g() {
        return this.f3544d;
    }

    public int h() {
        return this.f3545e;
    }

    public synchronized boolean i() {
        return this.f3554n;
    }

    public synchronized void j(boolean z7) {
        this.f3552l = z7 | this.f3552l;
        this.f3553m = true;
        notifyAll();
    }

    public B1 k() {
        j3.o.v(!this.f3551k);
        if (this.f3549i == -9223372036854775807L) {
            j3.o.d(this.f3550j);
        }
        this.f3551k = true;
        this.f3542b.h(this);
        return this;
    }

    public B1 l(Object obj) {
        j3.o.v(!this.f3551k);
        this.f3546f = obj;
        return this;
    }

    public B1 m(int i7) {
        j3.o.v(!this.f3551k);
        this.f3545e = i7;
        return this;
    }
}
