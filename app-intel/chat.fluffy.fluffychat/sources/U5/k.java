package U5;

import M5.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import z5.C1864H;
import z5.C1865I;
import z5.C1880n;
import z5.C1881o;

/* loaded from: classes.dex */
public class k extends i {

    public static final class a implements Iterable, N5.a {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ d f8471l;

        public a(d dVar) {
            this.f8471l = dVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f8471l.iterator();
        }
    }

    public static Iterable g(d dVar) {
        m.e(dVar, "<this>");
        return new a(dVar);
    }

    public static final d h(d dVar, L5.l lVar) {
        m.e(dVar, "<this>");
        m.e(lVar, "predicate");
        return new b(dVar, false, lVar);
    }

    public static final d i(d dVar) {
        m.e(dVar, "<this>");
        d dVarH = h(dVar, new L5.l() { // from class: U5.j
            @Override // L5.l
            public final Object a(Object obj) {
                return Boolean.valueOf(k.j(obj));
            }
        });
        m.c(dVarH, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return dVarH;
    }

    public static final boolean j(Object obj) {
        return obj == null;
    }

    public static d k(d dVar, L5.l lVar) {
        m.e(dVar, "<this>");
        m.e(lVar, "transform");
        return new l(dVar, lVar);
    }

    public static d l(d dVar, L5.l lVar) {
        m.e(dVar, "<this>");
        m.e(lVar, "transform");
        return i(new l(dVar, lVar));
    }

    public static List m(d dVar) {
        m.e(dVar, "<this>");
        Iterator it = dVar.iterator();
        if (!it.hasNext()) {
            return C1881o.i();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return C1880n.d(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static Set n(d dVar) {
        m.e(dVar, "<this>");
        Iterator it = dVar.iterator();
        if (!it.hasNext()) {
            return C1865I.d();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return C1864H.c(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }
}
