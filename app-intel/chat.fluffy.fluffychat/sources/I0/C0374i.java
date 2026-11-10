package I0;

import E0.InterfaceC0321g;

/* renamed from: I0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0374i implements InterfaceC0364e1 {

    /* renamed from: l, reason: collision with root package name */
    public final K1 f4077l;

    /* renamed from: m, reason: collision with root package name */
    public final a f4078m;

    /* renamed from: n, reason: collision with root package name */
    public D1 f4079n;

    /* renamed from: o, reason: collision with root package name */
    public InterfaceC0364e1 f4080o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4081p = true;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4082q;

    /* renamed from: I0.i$a */
    public interface a {
        void z(B0.C c7);
    }

    public C0374i(a aVar, InterfaceC0321g interfaceC0321g) {
        this.f4078m = aVar;
        this.f4077l = new K1(interfaceC0321g);
    }

    @Override // I0.InterfaceC0364e1
    public boolean F() {
        return this.f4081p ? this.f4077l.F() : ((InterfaceC0364e1) j3.o.q(this.f4080o)).F();
    }

    public void a(D1 d12) {
        if (d12 == this.f4079n) {
            this.f4080o = null;
            this.f4079n = null;
            this.f4081p = true;
        }
    }

    public void b(D1 d12) throws K {
        InterfaceC0364e1 interfaceC0364e1;
        InterfaceC0364e1 interfaceC0364e1R = d12.R();
        if (interfaceC0364e1R == null || interfaceC0364e1R == (interfaceC0364e1 = this.f4080o)) {
            return;
        }
        if (interfaceC0364e1 != null) {
            throw K.d(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.f4080o = interfaceC0364e1R;
        this.f4079n = d12;
        interfaceC0364e1R.c(this.f4077l.f());
    }

    @Override // I0.InterfaceC0364e1
    public void c(B0.C c7) {
        InterfaceC0364e1 interfaceC0364e1 = this.f4080o;
        if (interfaceC0364e1 != null) {
            interfaceC0364e1.c(c7);
            c7 = this.f4080o.f();
        }
        this.f4077l.c(c7);
    }

    public void d(long j7) {
        this.f4077l.a(j7);
    }

    public final boolean e(boolean z7) {
        D1 d12 = this.f4079n;
        if (d12 == null || d12.d()) {
            return true;
        }
        if (z7 && this.f4079n.getState() != 2) {
            return true;
        }
        if (this.f4079n.e()) {
            return false;
        }
        return z7 || this.f4079n.m();
    }

    @Override // I0.InterfaceC0364e1
    public B0.C f() {
        InterfaceC0364e1 interfaceC0364e1 = this.f4080o;
        return interfaceC0364e1 != null ? interfaceC0364e1.f() : this.f4077l.f();
    }

    public void g() {
        this.f4082q = true;
        this.f4077l.b();
    }

    public void h() {
        this.f4082q = false;
        this.f4077l.d();
    }

    @Override // I0.InterfaceC0364e1
    public long i() {
        return this.f4081p ? this.f4077l.i() : ((InterfaceC0364e1) j3.o.q(this.f4080o)).i();
    }

    public long j(boolean z7) {
        k(z7);
        return i();
    }

    public final void k(boolean z7) {
        if (e(z7)) {
            this.f4081p = true;
            if (this.f4082q) {
                this.f4077l.b();
                return;
            }
            return;
        }
        InterfaceC0364e1 interfaceC0364e1 = (InterfaceC0364e1) j3.o.q(this.f4080o);
        long jI = interfaceC0364e1.i();
        if (this.f4081p) {
            if (jI < this.f4077l.i()) {
                this.f4077l.d();
                return;
            } else {
                this.f4081p = false;
                if (this.f4082q) {
                    this.f4077l.b();
                }
            }
        }
        this.f4077l.a(jI);
        B0.C cF = interfaceC0364e1.f();
        if (cF.equals(this.f4077l.f())) {
            return;
        }
        this.f4077l.c(cF);
        this.f4078m.z(cF);
    }
}
