package U5;

import M5.m;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h extends f {

    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f8470a;

        public a(Iterator it) {
            this.f8470a = it;
        }

        @Override // U5.d
        public Iterator iterator() {
            return this.f8470a;
        }
    }

    public static d b(Iterator it) {
        m.e(it, "<this>");
        return c(new a(it));
    }

    public static final d c(d dVar) {
        m.e(dVar, "<this>");
        return dVar instanceof U5.a ? dVar : new U5.a(dVar);
    }

    public static d d(final L5.a aVar) {
        m.e(aVar, "nextFunction");
        return c(new c(aVar, new L5.l() { // from class: U5.g
            @Override // L5.l
            public final Object a(Object obj) {
                return h.e(aVar, obj);
            }
        }));
    }

    public static final Object e(L5.a aVar, Object obj) {
        m.e(obj, "it");
        return aVar.d();
    }
}
