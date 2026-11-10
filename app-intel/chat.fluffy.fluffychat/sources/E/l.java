package E;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends e {

    /* renamed from: w0, reason: collision with root package name */
    public ArrayList f2015w0 = new ArrayList();

    public void H0() {
        ArrayList arrayList = this.f2015w0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = (e) this.f2015w0.get(i7);
            if (eVar instanceof l) {
                ((l) eVar).H0();
            }
        }
    }

    public void I0(e eVar) {
        this.f2015w0.remove(eVar);
        eVar.t0(null);
    }

    public void J0() {
        this.f2015w0.clear();
    }

    @Override // E.e
    public void W() {
        this.f2015w0.clear();
        super.W();
    }

    @Override // E.e
    public void X(D.c cVar) {
        super.X(cVar);
        int size = this.f2015w0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((e) this.f2015w0.get(i7)).X(cVar);
        }
    }

    public void b(e eVar) {
        this.f2015w0.add(eVar);
        if (eVar.E() != null) {
            ((l) eVar.E()).I0(eVar);
        }
        eVar.t0(this);
    }
}
