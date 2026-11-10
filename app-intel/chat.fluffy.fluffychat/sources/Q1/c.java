package Q1;

import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: i, reason: collision with root package name */
    public static final a f7602i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public c f7603a;

    /* renamed from: b, reason: collision with root package name */
    public final q f7604b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7605c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7606d;

    /* renamed from: e, reason: collision with root package name */
    public final i f7607e;

    /* renamed from: f, reason: collision with root package name */
    public final Set f7608f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f7609g;

    /* renamed from: h, reason: collision with root package name */
    public final Set f7610h;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public c(c cVar, q qVar) {
        i iVar;
        this.f7603a = cVar;
        this.f7604b = qVar;
        this.f7606d = true;
        this.f7607e = (cVar == null || (iVar = cVar.f7607e) == null) ? new i() : iVar;
        this.f7608f = new LinkedHashSet();
        this.f7609g = new LinkedHashSet();
        this.f7610h = new LinkedHashSet();
        c cVar2 = this.f7603a;
        if (cVar2 != null) {
            cVar2.f7608f.add(this);
        }
    }

    public static /* synthetic */ void b(c cVar, e eVar, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        cVar.a(eVar, i7);
    }

    public final void a(e eVar, int i7) {
        M5.m.e(eVar, "handler");
        e();
        if (this.f7609g.add(eVar)) {
            this.f7607e.a(this, eVar, i7);
        }
    }

    public final void c(h hVar) {
        M5.m.e(hVar, "input");
        e();
        if (this.f7610h.add(hVar)) {
            this.f7607e.b(this, hVar, -1);
        }
    }

    public final void d(h hVar, int i7) {
        M5.m.e(hVar, "input");
        e();
        if (i7 == 1 || i7 == 0) {
            if (this.f7610h.add(hVar)) {
                this.f7607e.b(this, hVar, i7);
            }
        } else {
            throw new IllegalArgumentException(("Unsupported priority value: " + i7).toString());
        }
    }

    public final void e() {
        if (k()) {
            throw new IllegalStateException("This NavigationEventDispatcher has already been disposed and cannot be used.");
        }
    }

    public final void f(h hVar, int i7) {
        M5.m.e(hVar, "input");
        e();
        if (l()) {
            this.f7607e.c(hVar, i7);
        }
    }

    public final void g(h hVar, int i7) {
        M5.m.e(hVar, "input");
        e();
        if (l()) {
            this.f7607e.d(hVar, i7, this.f7604b);
        }
    }

    public final void h(h hVar, int i7, b bVar) {
        M5.m.e(hVar, "input");
        M5.m.e(bVar, "event");
        e();
        if (l()) {
            this.f7607e.e(hVar, i7, bVar);
        }
    }

    public final void i(h hVar, int i7, b bVar) {
        M5.m.e(hVar, "input");
        e();
        if (l()) {
            this.f7607e.f(hVar, i7, bVar);
        }
    }

    public final i j() {
        return this.f7607e;
    }

    public final boolean k() {
        c cVar = this.f7603a;
        if (cVar == null || !cVar.k()) {
            return this.f7605c;
        }
        return true;
    }

    public final boolean l() {
        c cVar = this.f7603a;
        if (cVar == null || cVar.l()) {
            return this.f7606d;
        }
        return false;
    }

    public final void m(e eVar) {
        M5.m.e(eVar, "handler");
        if (this.f7609g.remove(eVar)) {
            this.f7607e.h(eVar);
        }
    }

    public c() {
        this(null, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(q qVar) {
        this(null, qVar);
        M5.m.e(qVar, "onBackCompletedFallback");
    }
}
