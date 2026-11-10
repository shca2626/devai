package B2;

import C5.e;
import x2.f;
import x2.j;
import x2.n;
import y5.C1824s;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f1128c = new a();

    @Override // B2.b
    public Object a(c cVar, j jVar, e eVar) {
        if (jVar instanceof n) {
            cVar.onSuccess(((n) jVar).a());
        } else if (jVar instanceof f) {
            cVar.onError(jVar.a());
        }
        return C1824s.f24014a;
    }

    public String toString() {
        return "coil.transition.NoneTransition";
    }
}
