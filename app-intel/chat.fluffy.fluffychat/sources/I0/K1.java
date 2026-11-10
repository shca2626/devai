package I0;

import E0.InterfaceC0321g;

/* loaded from: classes.dex */
public final class K1 implements InterfaceC0364e1 {

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC0321g f3717l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3718m;

    /* renamed from: n, reason: collision with root package name */
    public long f3719n;

    /* renamed from: o, reason: collision with root package name */
    public long f3720o;

    /* renamed from: p, reason: collision with root package name */
    public B0.C f3721p = B0.C.f337d;

    public K1(InterfaceC0321g interfaceC0321g) {
        this.f3717l = interfaceC0321g;
    }

    public void a(long j7) {
        this.f3719n = j7;
        if (this.f3718m) {
            this.f3720o = this.f3717l.e();
        }
    }

    public void b() {
        if (this.f3718m) {
            return;
        }
        this.f3720o = this.f3717l.e();
        this.f3718m = true;
    }

    @Override // I0.InterfaceC0364e1
    public void c(B0.C c7) {
        if (this.f3718m) {
            a(i());
        }
        this.f3721p = c7;
    }

    public void d() {
        if (this.f3718m) {
            a(i());
            this.f3718m = false;
        }
    }

    @Override // I0.InterfaceC0364e1
    public B0.C f() {
        return this.f3721p;
    }

    @Override // I0.InterfaceC0364e1
    public long i() {
        long j7 = this.f3719n;
        if (!this.f3718m) {
            return j7;
        }
        long jE = this.f3717l.e() - this.f3720o;
        B0.C c7 = this.f3721p;
        return j7 + (c7.f340a == 1.0f ? E0.U.P0(jE) : c7.a(jE));
    }
}
