package E5;

import M5.m;
import java.io.Serializable;
import y5.AbstractC1814j;
import y5.C1813i;

/* loaded from: classes.dex */
public abstract class a implements C5.e, e, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final C5.e f2373l;

    public a(C5.e eVar) {
        this.f2373l = eVar;
    }

    @Override // E5.e
    public e f() {
        C5.e eVar = this.f2373l;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public C5.e l(Object obj, C5.e eVar) {
        m.e(eVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public final C5.e m() {
        return this.f2373l;
    }

    public StackTraceElement o() {
        return g.c(this);
    }

    public abstract Object q(Object obj);

    @Override // C5.e
    public final void resumeWith(Object obj) {
        Object objQ;
        C5.e eVar = this;
        while (true) {
            h.b(eVar);
            a aVar = (a) eVar;
            C5.e eVar2 = aVar.f2373l;
            m.b(eVar2);
            try {
                objQ = aVar.q(obj);
            } catch (Throwable th) {
                C1813i.a aVar2 = C1813i.f24010m;
                obj = C1813i.b(AbstractC1814j.a(th));
            }
            if (objQ == D5.c.e()) {
                return;
            }
            obj = C1813i.b(objQ);
            aVar.r();
            if (!(eVar2 instanceof a)) {
                eVar2.resumeWith(obj);
                return;
            }
            eVar = eVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object objO = o();
        if (objO == null) {
            objO = getClass().getName();
        }
        sb.append(objO);
        return sb.toString();
    }

    public void r() {
    }
}
