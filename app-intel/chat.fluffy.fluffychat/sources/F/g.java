package F;

import F.f;

/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f2431m;

    public g(m mVar) {
        super(mVar);
        if (mVar instanceof j) {
            this.f2414e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f2414e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // F.f
    public void d(int i7) {
        if (this.f2419j) {
            return;
        }
        this.f2419j = true;
        this.f2416g = i7;
        for (d dVar : this.f2420k) {
            dVar.a(dVar);
        }
    }
}
