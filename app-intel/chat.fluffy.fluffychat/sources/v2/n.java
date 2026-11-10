package v2;

import p2.InterfaceC1441c;
import v2.p;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1441c f22946a;

    /* renamed from: b, reason: collision with root package name */
    public final u f22947b;

    /* renamed from: c, reason: collision with root package name */
    public final y f22948c;

    public n(InterfaceC1441c interfaceC1441c, u uVar, y yVar) {
        M5.m.e(interfaceC1441c, "referenceCounter");
        M5.m.e(uVar, "strongMemoryCache");
        M5.m.e(yVar, "weakMemoryCache");
        this.f22946a = interfaceC1441c;
        this.f22947b = uVar;
        this.f22948c = yVar;
    }

    public final p.a a(m mVar) {
        if (mVar == null) {
            return null;
        }
        p.a aVarB = this.f22947b.b(mVar);
        if (aVarB == null) {
            aVarB = this.f22948c.b(mVar);
        }
        if (aVarB != null) {
            this.f22946a.c(aVarB.b());
        }
        return aVarB;
    }
}
