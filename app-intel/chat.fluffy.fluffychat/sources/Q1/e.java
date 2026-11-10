package Q1;

import Q1.j;
import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public g f7611a;

    /* renamed from: b, reason: collision with root package name */
    public List f7612b;

    /* renamed from: c, reason: collision with root package name */
    public List f7613c;

    /* renamed from: d, reason: collision with root package name */
    public j f7614d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7615e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7616f;

    /* renamed from: g, reason: collision with root package name */
    public c f7617g;

    public e(g gVar, boolean z7, boolean z8) {
        M5.m.e(gVar, "initialInfo");
        this.f7611a = gVar;
        this.f7612b = C1881o.i();
        this.f7613c = C1881o.i();
        this.f7614d = j.b.f7638b;
        this.f7615e = z7;
        this.f7616f = z8;
    }

    public final void a() {
        this.f7614d = j.b.f7638b;
        o();
    }

    public final void b() {
        this.f7614d = j.b.f7638b;
        p();
    }

    public final void c(b bVar) {
        M5.m.e(bVar, "event");
        this.f7614d = new j.c(bVar, -1);
        q(bVar);
    }

    public final void d(b bVar) {
        M5.m.e(bVar, "event");
        this.f7614d = new j.c(bVar, -1);
        r(bVar);
    }

    public final void e() {
        this.f7614d = j.b.f7638b;
        s();
    }

    public final void f() {
        this.f7614d = j.b.f7638b;
        t();
    }

    public final void g(b bVar) {
        M5.m.e(bVar, "event");
        this.f7614d = new j.c(bVar, 1);
        u(bVar);
    }

    public final void h(b bVar) {
        M5.m.e(bVar, "event");
        this.f7614d = new j.c(bVar, 1);
        v(bVar);
    }

    public final List i() {
        return this.f7612b;
    }

    public final g j() {
        return this.f7611a;
    }

    public final c k() {
        return this.f7617g;
    }

    public final List l() {
        return this.f7613c;
    }

    public final boolean m() {
        c cVar = this.f7617g;
        if (cVar == null || cVar.l()) {
            return this.f7615e;
        }
        return false;
    }

    public final boolean n() {
        c cVar = this.f7617g;
        if (cVar == null || cVar.l()) {
            return this.f7616f;
        }
        return false;
    }

    public abstract void o();

    public abstract void p();

    public abstract void q(b bVar);

    public abstract void r(b bVar);

    public void t() {
        throw new UnsupportedOperationException("A handler that receives a 'forwardCompleted' event must override 'onForwardCompleted()' to handle the callback.");
    }

    public void u(b bVar) {
        M5.m.e(bVar, "event");
    }

    public void v(b bVar) {
        M5.m.e(bVar, "event");
    }

    public final void w() {
        c cVar = this.f7617g;
        if (cVar != null) {
            cVar.m(this);
        }
    }

    public final void x(boolean z7) {
        i iVarJ;
        if (this.f7615e == z7) {
            return;
        }
        this.f7615e = z7;
        c cVar = this.f7617g;
        if (cVar == null || (iVarJ = cVar.j()) == null) {
            return;
        }
        iVarJ.g();
    }

    public final void y(c cVar) {
        this.f7617g = cVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(g gVar, boolean z7) {
        this(gVar, z7, false);
        M5.m.e(gVar, "initialInfo");
    }

    public void s() {
    }
}
