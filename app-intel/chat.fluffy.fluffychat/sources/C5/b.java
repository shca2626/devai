package C5;

import C5.i;
import L5.l;
import M5.m;

/* loaded from: classes.dex */
public abstract class b implements i.c {

    /* renamed from: l, reason: collision with root package name */
    public final l f1386l;

    /* renamed from: m, reason: collision with root package name */
    public final i.c f1387m;

    public b(i.c cVar, l lVar) {
        m.e(cVar, "baseKey");
        m.e(lVar, "safeCast");
        this.f1386l = lVar;
        this.f1387m = cVar instanceof b ? ((b) cVar).f1387m : cVar;
    }

    public final boolean a(i.c cVar) {
        m.e(cVar, "key");
        return cVar == this || this.f1387m == cVar;
    }

    public final i.b b(i.b bVar) {
        m.e(bVar, "element");
        return (i.b) this.f1386l.a(bVar);
    }
}
