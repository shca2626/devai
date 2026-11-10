package k4;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class i implements D3.q {

    /* renamed from: a, reason: collision with root package name */
    public D3.l f19071a;

    /* renamed from: b, reason: collision with root package name */
    public List f19072b = new ArrayList();

    public i(D3.l lVar) {
        this.f19071a = lVar;
    }

    @Override // D3.q
    public void a(D3.p pVar) {
        this.f19072b.add(pVar);
    }

    public D3.n b(D3.c cVar) {
        this.f19072b.clear();
        try {
            D3.l lVar = this.f19071a;
            if (lVar instanceof D3.i) {
                D3.n nVarD = ((D3.i) lVar).d(cVar);
                this.f19071a.reset();
                return nVarD;
            }
            D3.n nVarA = lVar.a(cVar);
            this.f19071a.reset();
            return nVarA;
        } catch (Exception unused) {
            this.f19071a.reset();
            return null;
        } catch (Throwable th) {
            this.f19071a.reset();
            throw th;
        }
    }

    public D3.n c(D3.h hVar) {
        return b(e(hVar));
    }

    public List d() {
        return new ArrayList(this.f19072b);
    }

    public D3.c e(D3.h hVar) {
        return new D3.c(new J3.k(hVar));
    }
}
