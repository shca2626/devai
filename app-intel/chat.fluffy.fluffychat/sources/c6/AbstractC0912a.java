package c6;

import C5.e;
import L5.p;
import W5.Y;
import b6.AbstractC0874j;
import y5.AbstractC1815j;
import y5.C1814i;
import y5.C1824s;

/* renamed from: c6.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0912a {
    public static final void a(e eVar, Throwable th) throws Throwable {
        if (th instanceof Y) {
            th = ((Y) th).getCause();
        }
        C1814i.a aVar = C1814i.f24004m;
        eVar.resumeWith(C1814i.b(AbstractC1815j.a(th)));
        throw th;
    }

    public static final void b(e eVar, e eVar2) throws Throwable {
        try {
            e eVarC = D5.b.c(eVar);
            C1814i.a aVar = C1814i.f24004m;
            AbstractC0874j.b(eVarC, C1814i.b(C1824s.f24014a));
        } catch (Throwable th) {
            a(eVar2, th);
        }
    }

    public static final void c(p pVar, Object obj, e eVar) {
        try {
            e eVarC = D5.b.c(D5.b.a(pVar, obj, eVar));
            C1814i.a aVar = C1814i.f24004m;
            AbstractC0874j.b(eVarC, C1814i.b(C1824s.f24014a));
        } catch (Throwable th) {
            a(eVar, th);
        }
    }
}
