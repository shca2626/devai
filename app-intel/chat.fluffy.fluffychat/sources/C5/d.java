package C5;

import C5.i;
import L5.p;
import M5.m;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class d implements i, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final i f1388l;

    /* renamed from: m, reason: collision with root package name */
    public final i.b f1389m;

    public d(i iVar, i.b bVar) {
        m.e(iVar, "left");
        m.e(bVar, "element");
        this.f1388l = iVar;
        this.f1389m = bVar;
    }

    public static final String h(String str, i.b bVar) {
        m.e(str, "acc");
        m.e(bVar, "element");
        if (str.length() == 0) {
            return bVar.toString();
        }
        return str + ", " + bVar;
    }

    @Override // C5.i
    public Object R(Object obj, p pVar) {
        m.e(pVar, "operation");
        return pVar.n(this.f1388l.R(obj, pVar), this.f1389m);
    }

    @Override // C5.i
    public i.b a(i.c cVar) {
        m.e(cVar, "key");
        d dVar = this;
        while (true) {
            i.b bVarA = dVar.f1389m.a(cVar);
            if (bVarA != null) {
                return bVarA;
            }
            i iVar = dVar.f1388l;
            if (!(iVar instanceof d)) {
                return iVar.a(cVar);
            }
            dVar = (d) iVar;
        }
    }

    public final boolean c(i.b bVar) {
        return m.a(a(bVar.getKey()), bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.g() == g() && dVar.f(this);
    }

    public final boolean f(d dVar) {
        while (c(dVar.f1389m)) {
            i iVar = dVar.f1388l;
            if (!(iVar instanceof d)) {
                m.c(iVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return c((i.b) iVar);
            }
            dVar = (d) iVar;
        }
        return false;
    }

    public final int g() {
        int i7 = 2;
        d dVar = this;
        while (true) {
            i iVar = dVar.f1388l;
            dVar = iVar instanceof d ? (d) iVar : null;
            if (dVar == null) {
                return i7;
            }
            i7++;
        }
    }

    public int hashCode() {
        return this.f1388l.hashCode() + this.f1389m.hashCode();
    }

    @Override // C5.i
    public /* bridge */ i n(i iVar) {
        return i.a.b(this, iVar);
    }

    @Override // C5.i
    public i o(i.c cVar) {
        m.e(cVar, "key");
        if (this.f1389m.a(cVar) != null) {
            return this.f1388l;
        }
        i iVarO = this.f1388l.o(cVar);
        return iVarO == this.f1388l ? this : iVarO == j.f1392l ? this.f1389m : new d(iVarO, this.f1389m);
    }

    public String toString() {
        return '[' + ((String) R("", new p() { // from class: C5.c
            @Override // L5.p
            public final Object n(Object obj, Object obj2) {
                return d.h((String) obj, (i.b) obj2);
            }
        })) + ']';
    }
}
