package v2;

import p2.InterfaceC1440c;
import v2.p;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1440c f22952a;

    /* renamed from: b, reason: collision with root package name */
    public final u f22953b;

    /* renamed from: c, reason: collision with root package name */
    public final y f22954c;

    public n(InterfaceC1440c interfaceC1440c, u uVar, y yVar) {
        M5.m.e(interfaceC1440c, "referenceCounter");
        M5.m.e(uVar, "strongMemoryCache");
        M5.m.e(yVar, "weakMemoryCache");
        this.f22952a = interfaceC1440c;
        this.f22953b = uVar;
        this.f22954c = yVar;
    }

    public final p.a a(m mVar) {
        if (mVar == null) {
            return null;
        }
        p.a aVarB = this.f22953b.b(mVar);
        if (aVarB == null) {
            aVarB = this.f22954c.b(mVar);
        }
        if (aVarB != null) {
            this.f22952a.c(aVarB.b());
        }
        return aVarB;
    }
}
