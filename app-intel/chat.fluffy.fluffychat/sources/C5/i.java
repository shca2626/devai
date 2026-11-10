package C5;

import C5.f;
import C5.i;
import L5.p;
import M5.m;

/* loaded from: classes.dex */
public interface i {

    public static final class a {
        public static i b(i iVar, i iVar2) {
            m.e(iVar2, "context");
            return iVar2 == j.f1392l ? iVar : (i) iVar2.R(iVar, new p() { // from class: C5.h
                @Override // L5.p
                public final Object n(Object obj, Object obj2) {
                    return i.a.c((i) obj, (i.b) obj2);
                }
            });
        }

        public static i c(i iVar, b bVar) {
            m.e(iVar, "acc");
            m.e(bVar, "element");
            i iVarO = iVar.o(bVar.getKey());
            j jVar = j.f1392l;
            if (iVarO == jVar) {
                return bVar;
            }
            f.b bVar2 = f.f1390a;
            f fVar = (f) iVarO.a(bVar2);
            if (fVar == null) {
                return new d(iVarO, bVar);
            }
            i iVarO2 = iVarO.o(bVar2);
            return iVarO2 == jVar ? new d(bVar, fVar) : new d(new d(iVarO2, bVar), fVar);
        }
    }

    public interface b extends i {

        public static final class a {
            public static Object a(b bVar, Object obj, p pVar) {
                m.e(pVar, "operation");
                return pVar.n(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                m.e(cVar, "key");
                if (!m.a(bVar.getKey(), cVar)) {
                    return null;
                }
                m.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static i c(b bVar, c cVar) {
                m.e(cVar, "key");
                return m.a(bVar.getKey(), cVar) ? j.f1392l : bVar;
            }

            public static i d(b bVar, i iVar) {
                m.e(iVar, "context");
                return a.b(bVar, iVar);
            }
        }

        @Override // C5.i
        b a(c cVar);

        c getKey();
    }

    public interface c {
    }

    Object R(Object obj, p pVar);

    b a(c cVar);

    i n(i iVar);

    i o(c cVar);
}
