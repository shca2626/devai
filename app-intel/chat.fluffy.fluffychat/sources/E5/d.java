package E5;

import C5.i;
import M5.m;

/* loaded from: classes.dex */
public abstract class d extends a {

    /* renamed from: m, reason: collision with root package name */
    public final C5.i f2375m;

    /* renamed from: n, reason: collision with root package name */
    public transient C5.e f2376n;

    public d(C5.e eVar, C5.i iVar) {
        super(eVar);
        this.f2375m = iVar;
    }

    @Override // C5.e
    public C5.i getContext() {
        C5.i iVar = this.f2375m;
        m.b(iVar);
        return iVar;
    }

    @Override // E5.a
    public void r() {
        C5.e eVar = this.f2376n;
        if (eVar != null && eVar != this) {
            i.b bVarA = getContext().a(C5.f.f1390a);
            m.b(bVarA);
            ((C5.f) bVarA).t(eVar);
        }
        this.f2376n = c.f2374l;
    }

    public final C5.e t() {
        C5.e eVarB = this.f2376n;
        if (eVarB == null) {
            C5.f fVar = (C5.f) getContext().a(C5.f.f1390a);
            if (fVar == null || (eVarB = fVar.B(this)) == null) {
                eVarB = this;
            }
            this.f2376n = eVarB;
        }
        return eVarB;
    }

    public d(C5.e eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }
}
