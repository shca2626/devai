package Q1;

import Q1.j;
import Z5.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import z5.C1874h;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Z5.p f7622a;

    /* renamed from: b, reason: collision with root package name */
    public final Z5.w f7623b;

    /* renamed from: c, reason: collision with root package name */
    public final Z5.p f7624c;

    /* renamed from: d, reason: collision with root package name */
    public final Z5.w f7625d;

    /* renamed from: e, reason: collision with root package name */
    public final C1874h f7626e;

    /* renamed from: f, reason: collision with root package name */
    public final C1874h f7627f;

    /* renamed from: g, reason: collision with root package name */
    public e f7628g;

    /* renamed from: h, reason: collision with root package name */
    public int f7629h;

    /* renamed from: i, reason: collision with root package name */
    public h f7630i;

    /* renamed from: j, reason: collision with root package name */
    public final Set f7631j;

    /* renamed from: k, reason: collision with root package name */
    public final Set f7632k;

    /* renamed from: l, reason: collision with root package name */
    public final Set f7633l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7634m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7635n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7636o;

    public i() {
        Z5.p pVarA = y.a(j.b.f7638b);
        this.f7622a = pVarA;
        this.f7623b = Z5.f.a(pVarA);
        Z5.p pVarA2 = y.a(new f());
        this.f7624c = pVarA2;
        this.f7625d = Z5.f.a(pVarA2);
        this.f7626e = new C1874h();
        this.f7627f = new C1874h();
        this.f7631j = new LinkedHashSet();
        this.f7632k = new LinkedHashSet();
        this.f7633l = new LinkedHashSet();
    }

    public static /* synthetic */ e k(i iVar, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        return iVar.j(i7);
    }

    public final void a(c cVar, e eVar, int i7) {
        M5.m.e(cVar, "dispatcher");
        M5.m.e(eVar, "handler");
        if (eVar.k() != null) {
            throw new IllegalArgumentException(("Handler '" + eVar + "' is already registered with a dispatcher").toString());
        }
        if (i7 == 0) {
            this.f7626e.addFirst(eVar);
        } else {
            if (i7 != 1) {
                throw new IllegalArgumentException("Unsupported priority value: " + i7);
            }
            this.f7627f.addFirst(eVar);
        }
        eVar.y(cVar);
        g();
    }

    public final void b(c cVar, h hVar, int i7) {
        M5.m.e(cVar, "dispatcher");
        M5.m.e(hVar, "input");
        if (hVar.h() == null) {
            (i7 != 0 ? i7 != 1 ? this.f7631j : this.f7632k : this.f7633l).add(hVar);
            hVar.l(cVar);
            hVar.e(cVar);
            hVar.g((f) this.f7625d.getValue());
            hVar.f(i7 != 0 ? i7 != 1 ? this.f7636o : this.f7634m : this.f7635n);
            return;
        }
        throw new IllegalArgumentException(("Input '" + hVar + "' is already added to dispatcher " + hVar.h() + '.').toString());
    }

    public final void c(h hVar, int i7) {
        M5.m.e(hVar, "input");
        if (M5.m.a(hVar, this.f7630i) && i7 == this.f7629h) {
            e eVarJ = this.f7628g;
            if (eVarJ == null) {
                eVarJ = j(i7);
            }
            this.f7628g = null;
            this.f7629h = 0;
            this.f7630i = null;
            if (i7 != -1) {
                if (i7 == 1 && eVarJ != null) {
                    eVarJ.e();
                }
            } else if (eVarJ != null) {
                eVarJ.a();
            }
            this.f7622a.setValue(j.b.f7638b);
        }
    }

    public final void d(h hVar, int i7, q qVar) {
        M5.m.e(hVar, "input");
        if (M5.m.a(hVar, this.f7630i) && i7 == this.f7629h) {
            e eVarJ = this.f7628g;
            if (eVarJ == null) {
                eVarJ = j(i7);
            }
            this.f7628g = null;
            this.f7629h = 0;
            this.f7630i = null;
            if (i7 != -1) {
                if (i7 == 1 && eVarJ != null) {
                    eVarJ.f();
                }
            } else if (eVarJ != null) {
                eVarJ.b();
            } else if (qVar != null) {
                qVar.a();
            }
            this.f7622a.setValue(j.b.f7638b);
        }
    }

    public final void e(h hVar, int i7, b bVar) {
        M5.m.e(hVar, "input");
        M5.m.e(bVar, "event");
        if (M5.m.a(hVar, this.f7630i) && i7 == this.f7629h) {
            e eVarJ = this.f7628g;
            if (eVarJ == null) {
                eVarJ = j(i7);
            }
            if (i7 != -1) {
                if (i7 == 1 && eVarJ != null) {
                    eVarJ.g(bVar);
                }
            } else if (eVarJ != null) {
                eVarJ.c(bVar);
            }
            this.f7622a.setValue(new j.c(bVar, i7));
        }
    }

    public final void f(h hVar, int i7, b bVar) {
        M5.m.e(hVar, "input");
        if (this.f7629h != 0) {
            return;
        }
        e eVarJ = j(i7);
        this.f7628g = eVarJ;
        this.f7629h = i7;
        this.f7630i = hVar;
        if (bVar != null) {
            if (i7 != -1) {
                if (i7 == 1 && eVarJ != null) {
                    eVarJ.h(bVar);
                }
            } else if (eVarJ != null) {
                eVarJ.d(bVar);
            }
            this.f7622a.setValue(new j.c(bVar, i7));
        }
    }

    public final void g() {
        boolean z7;
        boolean z8;
        C1874h<e> c1874h = this.f7626e;
        if (c1874h == null || !c1874h.isEmpty()) {
            for (e eVar : c1874h) {
                if (eVar.m() || eVar.n()) {
                    z7 = true;
                    break;
                }
            }
            z7 = false;
        } else {
            z7 = false;
        }
        C1874h<e> c1874h2 = this.f7627f;
        if (c1874h2 == null || !c1874h2.isEmpty()) {
            for (e eVar2 : c1874h2) {
                if (eVar2.m() || eVar2.n()) {
                    z8 = true;
                    break;
                }
            }
            z8 = false;
        } else {
            z8 = false;
        }
        boolean z9 = z7 || z8;
        boolean z10 = this.f7635n != z7;
        boolean z11 = this.f7634m != z8;
        boolean z12 = this.f7636o != z9;
        if (z10) {
            Iterator it = this.f7633l.iterator();
            while (it.hasNext()) {
                ((h) it.next()).f(z7);
            }
        }
        if (z11) {
            Iterator it2 = this.f7632k.iterator();
            while (it2.hasNext()) {
                ((h) it2.next()).f(z8);
            }
        }
        if (z12) {
            Iterator it3 = this.f7631j.iterator();
            while (it3.hasNext()) {
                ((h) it3.next()).f(z9);
            }
        }
        this.f7635n = z7;
        this.f7634m = z8;
        this.f7636o = z9;
        e eVarK = this.f7628g;
        if (eVarK == null) {
            eVarK = k(this, 0, 1, null);
        }
        l(eVarK);
    }

    public final void h(e eVar) {
        M5.m.e(eVar, "handler");
        if (M5.m.a(eVar, this.f7628g)) {
            int i7 = this.f7629h;
            if (i7 == -1) {
                eVar.a();
            } else if (i7 == 1) {
                eVar.e();
            }
            this.f7628g = null;
            this.f7629h = 0;
            this.f7630i = null;
        }
        this.f7626e.remove(eVar);
        this.f7627f.remove(eVar);
        eVar.y(null);
        g();
    }

    public final List i() {
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = this.f7626e.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.m() && !eVar.i().isEmpty()) {
                arrayList.addAll(eVar.i());
            }
        }
        Iterator<E> it2 = this.f7627f.iterator();
        while (it2.hasNext()) {
            e eVar2 = (e) it2.next();
            if (eVar2.m() && !eVar2.i().isEmpty()) {
                arrayList.addAll(eVar2.i());
            }
        }
        return arrayList;
    }

    public final e j(int i7) {
        Object next;
        Object next2;
        Object next3;
        Object obj = null;
        if (i7 == -1) {
            Iterator<E> it = this.f7626e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((e) next).m()) {
                    break;
                }
            }
            e eVar = (e) next;
            if (eVar != null) {
                return eVar;
            }
            Iterator<E> it2 = this.f7627f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next4 = it2.next();
                if (((e) next4).m()) {
                    obj = next4;
                    break;
                }
            }
            return (e) obj;
        }
        if (i7 == 0) {
            Iterator<E> it3 = this.f7626e.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                e eVar2 = (e) next2;
                if (eVar2.m() || eVar2.n()) {
                    break;
                }
            }
            e eVar3 = (e) next2;
            if (eVar3 != null) {
                return eVar3;
            }
            for (Object obj2 : this.f7627f) {
                e eVar4 = (e) obj2;
                if (eVar4.m() || eVar4.n()) {
                    obj = obj2;
                    break;
                }
            }
            return (e) obj;
        }
        if (i7 != 1) {
            throw new IllegalStateException(("Unsupported direction: '" + i7 + "'.").toString());
        }
        Iterator<E> it4 = this.f7626e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it4.next();
            if (((e) next3).n()) {
                break;
            }
        }
        e eVar5 = (e) next3;
        if (eVar5 != null) {
            return eVar5;
        }
        Iterator<E> it5 = this.f7627f.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next5 = it5.next();
            if (((e) next5).n()) {
                obj = next5;
                break;
            }
        }
        return (e) obj;
    }

    public final void l(e eVar) {
        f fVar;
        e eVarK = this.f7628g;
        if (eVarK == null) {
            eVarK = k(this, 0, 1, null);
        }
        if (M5.m.a(eVarK, eVar)) {
            if (eVarK == null) {
                fVar = new f();
            } else {
                fVar = new f(eVarK.j(), i(), eVarK.l());
            }
            if (M5.m.a((f) this.f7624c.getValue(), fVar)) {
                return;
            }
            this.f7624c.setValue(fVar);
            Iterator it = this.f7633l.iterator();
            while (it.hasNext()) {
                ((h) it.next()).g(fVar);
            }
            Iterator it2 = this.f7632k.iterator();
            while (it2.hasNext()) {
                ((h) it2.next()).g(fVar);
            }
            Iterator it3 = this.f7631j.iterator();
            while (it3.hasNext()) {
                ((h) it3.next()).g(fVar);
            }
        }
    }
}
