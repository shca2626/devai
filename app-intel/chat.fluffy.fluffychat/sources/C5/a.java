package C5;

import C5.i;
import L5.p;
import M5.m;

/* loaded from: classes.dex */
public abstract class a implements i.b {

    /* renamed from: l, reason: collision with root package name */
    public final i.c f1385l;

    public a(i.c cVar) {
        m.e(cVar, "key");
        this.f1385l = cVar;
    }

    @Override // C5.i
    public /* bridge */ Object R(Object obj, p pVar) {
        return i.b.a.a(this, obj, pVar);
    }

    @Override // C5.i.b, C5.i
    public /* bridge */ i.b a(i.c cVar) {
        return i.b.a.b(this, cVar);
    }

    @Override // C5.i.b
    public i.c getKey() {
        return this.f1385l;
    }

    @Override // C5.i
    public /* bridge */ i n(i iVar) {
        return i.b.a.d(this, iVar);
    }

    @Override // C5.i
    public /* bridge */ i o(i.c cVar) {
        return i.b.a.c(this, cVar);
    }
}
