package b6;

import java.util.Iterator;
import y5.C1806a;

/* renamed from: b6.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0871g {
    public static final void a(C5.i iVar, Throwable th) {
        Iterator it = AbstractC0870f.a().iterator();
        while (it.hasNext()) {
            try {
                ((W5.K) it.next()).M(iVar, th);
            } catch (Throwable th2) {
                AbstractC0870f.b(W5.L.b(th, th2));
            }
        }
        try {
            C1806a.a(th, new C0872h(iVar));
        } catch (Throwable unused) {
        }
        AbstractC0870f.b(th);
    }
}
