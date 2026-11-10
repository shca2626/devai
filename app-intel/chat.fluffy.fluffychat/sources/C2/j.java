package C2;

import W5.InterfaceC0632m;
import java.io.IOException;
import k6.A;
import y5.AbstractC1815j;
import y5.C1814i;
import y5.C1824s;

/* loaded from: classes.dex */
public final class j implements k6.f, L5.l {

    /* renamed from: l, reason: collision with root package name */
    public final k6.e f1332l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0632m f1333m;

    public j(k6.e eVar, InterfaceC0632m interfaceC0632m) {
        M5.m.e(eVar, "call");
        M5.m.e(interfaceC0632m, "continuation");
        this.f1332l = eVar;
        this.f1333m = interfaceC0632m;
    }

    @Override // L5.l
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        f((Throwable) obj);
        return C1824s.f24014a;
    }

    @Override // k6.f
    public void b(k6.e eVar, IOException iOException) {
        M5.m.e(eVar, "call");
        M5.m.e(iOException, "e");
        if (eVar.e()) {
            return;
        }
        InterfaceC0632m interfaceC0632m = this.f1333m;
        C1814i.a aVar = C1814i.f24004m;
        interfaceC0632m.resumeWith(C1814i.b(AbstractC1815j.a(iOException)));
    }

    @Override // k6.f
    public void c(k6.e eVar, A a7) {
        M5.m.e(eVar, "call");
        M5.m.e(a7, "response");
        this.f1333m.resumeWith(C1814i.b(a7));
    }

    public void f(Throwable th) {
        try {
            this.f1332l.cancel();
        } catch (Throwable unused) {
        }
    }
}
