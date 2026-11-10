package Q1;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public c f7620a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7621b;

    public final void a() {
        c cVar = this.f7620a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.f7621b) {
            cVar.i(this, -1, null);
        }
        cVar.f(this, -1);
        this.f7621b = false;
    }

    public final void b() {
        c cVar = this.f7620a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.f7621b) {
            cVar.i(this, -1, null);
        }
        cVar.g(this, -1);
        this.f7621b = false;
    }

    public final void c(b bVar) {
        M5.m.e(bVar, "event");
        c cVar = this.f7620a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (this.f7621b) {
            cVar.h(this, -1, bVar);
        }
    }

    public final void d(b bVar) {
        M5.m.e(bVar, "event");
        c cVar = this.f7620a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (this.f7621b) {
            return;
        }
        cVar.i(this, -1, bVar);
        this.f7621b = true;
    }

    public final void e(c cVar) {
        M5.m.e(cVar, "dispatcher");
        i(cVar);
    }

    public final void f(boolean z7) {
        j(z7);
    }

    public final void g(f fVar) {
        M5.m.e(fVar, "history");
        k(fVar);
    }

    public final c h() {
        return this.f7620a;
    }

    public void i(c cVar) {
        M5.m.e(cVar, "dispatcher");
    }

    public void k(f fVar) {
        M5.m.e(fVar, "history");
    }

    public final void l(c cVar) {
        this.f7620a = cVar;
    }

    public void j(boolean z7) {
    }
}
