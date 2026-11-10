package C5;

import C5.i;
import M5.m;

/* loaded from: classes.dex */
public interface f extends i.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1390a = b.f1391l;

    public static final class a {
        public static i.b a(f fVar, i.c cVar) {
            i.b bVarB;
            m.e(cVar, "key");
            if (!(cVar instanceof C5.b)) {
                if (f.f1390a != cVar) {
                    return null;
                }
                m.c(fVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return fVar;
            }
            C5.b bVar = (C5.b) cVar;
            if (!bVar.a(fVar.getKey()) || (bVarB = bVar.b(fVar)) == null) {
                return null;
            }
            return bVarB;
        }

        public static i b(f fVar, i.c cVar) {
            m.e(cVar, "key");
            if (!(cVar instanceof C5.b)) {
                return f.f1390a == cVar ? j.f1392l : fVar;
            }
            C5.b bVar = (C5.b) cVar;
            return (!bVar.a(fVar.getKey()) || bVar.b(fVar) == null) ? fVar : j.f1392l;
        }
    }

    public static final class b implements i.c {

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ b f1391l = new b();
    }

    e B(e eVar);

    void t(e eVar);
}
