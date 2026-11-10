package androidx.lifecycle;

import androidx.lifecycle.AbstractC0804j;
import java.util.Map;
import s.C1597b;

/* renamed from: androidx.lifecycle.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0812s {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f12431k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f12432a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public C1597b f12433b = new C1597b();

    /* renamed from: c, reason: collision with root package name */
    public int f12434c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12435d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f12436e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f12437f;

    /* renamed from: g, reason: collision with root package name */
    public int f12438g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12439h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12440i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f12441j;

    /* renamed from: androidx.lifecycle.s$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (AbstractC0812s.this.f12432a) {
                obj = AbstractC0812s.this.f12437f;
                AbstractC0812s.this.f12437f = AbstractC0812s.f12431k;
            }
            AbstractC0812s.this.k(obj);
        }
    }

    /* renamed from: androidx.lifecycle.s$b */
    public class b extends d {
        public b(v vVar) {
            super(vVar);
        }

        @Override // androidx.lifecycle.AbstractC0812s.d
        public boolean e() {
            return true;
        }
    }

    /* renamed from: androidx.lifecycle.s$c */
    public class c extends d implements InterfaceC0806l {

        /* renamed from: p, reason: collision with root package name */
        public final InterfaceC0808n f12444p;

        public c(InterfaceC0808n interfaceC0808n, v vVar) {
            super(vVar);
            this.f12444p = interfaceC0808n;
        }

        @Override // androidx.lifecycle.AbstractC0812s.d
        public void b() {
            this.f12444p.a().c(this);
        }

        @Override // androidx.lifecycle.AbstractC0812s.d
        public boolean c(InterfaceC0808n interfaceC0808n) {
            return this.f12444p == interfaceC0808n;
        }

        @Override // androidx.lifecycle.InterfaceC0806l
        public void d(InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar) {
            AbstractC0804j.b bVarB = this.f12444p.a().b();
            if (bVarB == AbstractC0804j.b.f12407l) {
                AbstractC0812s.this.j(this.f12446l);
                return;
            }
            AbstractC0804j.b bVar = null;
            while (bVar != bVarB) {
                a(e());
                bVar = bVarB;
                bVarB = this.f12444p.a().b();
            }
        }

        @Override // androidx.lifecycle.AbstractC0812s.d
        public boolean e() {
            return this.f12444p.a().b().d(AbstractC0804j.b.f12410o);
        }
    }

    /* renamed from: androidx.lifecycle.s$d */
    public abstract class d {

        /* renamed from: l, reason: collision with root package name */
        public final v f12446l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f12447m;

        /* renamed from: n, reason: collision with root package name */
        public int f12448n = -1;

        public d(v vVar) {
            this.f12446l = vVar;
        }

        public void a(boolean z7) {
            if (z7 == this.f12447m) {
                return;
            }
            this.f12447m = z7;
            AbstractC0812s.this.b(z7 ? 1 : -1);
            if (this.f12447m) {
                AbstractC0812s.this.d(this);
            }
        }

        public void b() {
        }

        public boolean c(InterfaceC0808n interfaceC0808n) {
            return false;
        }

        public abstract boolean e();
    }

    public AbstractC0812s() {
        Object obj = f12431k;
        this.f12437f = obj;
        this.f12441j = new a();
        this.f12436e = obj;
        this.f12438g = -1;
    }

    public static void a(String str) {
        if (r.c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void b(int i7) {
        int i8 = this.f12434c;
        this.f12434c = i7 + i8;
        if (this.f12435d) {
            return;
        }
        this.f12435d = true;
        while (true) {
            try {
                int i9 = this.f12434c;
                if (i8 == i9) {
                    this.f12435d = false;
                    return;
                }
                boolean z7 = i8 == 0 && i9 > 0;
                boolean z8 = i8 > 0 && i9 == 0;
                if (z7) {
                    g();
                } else if (z8) {
                    h();
                }
                i8 = i9;
            } catch (Throwable th) {
                this.f12435d = false;
                throw th;
            }
        }
    }

    public final void c(d dVar) {
        if (dVar.f12447m) {
            if (!dVar.e()) {
                dVar.a(false);
                return;
            }
            int i7 = dVar.f12448n;
            int i8 = this.f12438g;
            if (i7 >= i8) {
                return;
            }
            dVar.f12448n = i8;
            dVar.f12446l.a(this.f12436e);
        }
    }

    public void d(d dVar) {
        if (this.f12439h) {
            this.f12440i = true;
            return;
        }
        this.f12439h = true;
        do {
            this.f12440i = false;
            if (dVar != null) {
                c(dVar);
                dVar = null;
            } else {
                C1597b.d dVarH = this.f12433b.h();
                while (dVarH.hasNext()) {
                    c((d) ((Map.Entry) dVarH.next()).getValue());
                    if (this.f12440i) {
                        break;
                    }
                }
            }
        } while (this.f12440i);
        this.f12439h = false;
    }

    public void e(InterfaceC0808n interfaceC0808n, v vVar) {
        a("observe");
        if (interfaceC0808n.a().b() == AbstractC0804j.b.f12407l) {
            return;
        }
        c cVar = new c(interfaceC0808n, vVar);
        d dVar = (d) this.f12433b.k(vVar, cVar);
        if (dVar != null && !dVar.c(interfaceC0808n)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        interfaceC0808n.a().a(cVar);
    }

    public void f(v vVar) {
        a("observeForever");
        b bVar = new b(vVar);
        d dVar = (d) this.f12433b.k(vVar, bVar);
        if (dVar instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        bVar.a(true);
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Object obj) {
        boolean z7;
        synchronized (this.f12432a) {
            z7 = this.f12437f == f12431k;
            this.f12437f = obj;
        }
        if (z7) {
            r.c.f().c(this.f12441j);
        }
    }

    public void j(v vVar) {
        a("removeObserver");
        d dVar = (d) this.f12433b.l(vVar);
        if (dVar == null) {
            return;
        }
        dVar.b();
        dVar.a(false);
    }

    public void k(Object obj) {
        a("setValue");
        this.f12438g++;
        this.f12436e = obj;
        d(null);
    }
}
