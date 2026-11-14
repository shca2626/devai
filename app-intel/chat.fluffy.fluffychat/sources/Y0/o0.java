package Y0;

import B0.H;
import B0.v;

/* loaded from: classes.dex */
public final class o0 extends AbstractC0681y {

    /* renamed from: f, reason: collision with root package name */
    public final B0.v f9792f;

    public o0(B0.H h7, B0.v vVar) {
        super(h7);
        this.f9792f = vVar;
    }

    public static o0 s(B0.H h7, B0.v vVar) {
        return h7 instanceof o0 ? new o0(((o0) h7).f9846e, vVar) : new o0(h7, vVar);
    }

    @Override // Y0.AbstractC0681y, B0.H
    public H.c o(int i7, H.c cVar, long j7) {
        super.o(i7, cVar, j7);
        B0.v vVar = this.f9792f;
        cVar.f409c = vVar;
        v.h hVar = vVar.f827b;
        cVar.f408b = hVar != null ? hVar.f929h : null;
        return cVar;
    }
}
