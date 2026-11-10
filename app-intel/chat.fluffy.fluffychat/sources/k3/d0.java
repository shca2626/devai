package k3;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import k3.AbstractC1268j;

/* loaded from: classes.dex */
public abstract class d0 {

    public class a extends e {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Set f18965l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Set f18966m;

        /* renamed from: k3.d0$a$a, reason: collision with other inner class name */
        public class C0216a extends AbstractC1260b {

            /* renamed from: n, reason: collision with root package name */
            public final Iterator f18967n;

            public C0216a() {
                this.f18967n = a.this.f18965l.iterator();
            }

            @Override // k3.AbstractC1260b
            public Object a() {
                while (this.f18967n.hasNext()) {
                    Object next = this.f18967n.next();
                    if (a.this.f18966m.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f18965l = set;
            this.f18966m = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f18965l.contains(obj) && this.f18966m.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return this.f18965l.containsAll(collection) && this.f18966m.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public h0 iterator() {
            return new C0216a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f18966m, this.f18965l);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator it = this.f18965l.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (this.f18966m.contains(it.next())) {
                    i7++;
                }
            }
            return i7;
        }
    }

    public static class b extends AbstractC1268j.a implements Set {
        public b(Set set, j3.p pVar) {
            super(set, pVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return d0.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return d0.d(this);
        }
    }

    public static class c extends b implements SortedSet {
        public c(SortedSet sortedSet, j3.p pVar) {
            super(sortedSet, pVar);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return ((SortedSet) this.f18979l).comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return E.j(this.f18979l.iterator(), this.f18980m);
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return new c(((SortedSet) this.f18979l).headSet(obj), this.f18980m);
        }

        @Override // java.util.SortedSet
        public Object last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f18979l;
            while (true) {
                Object objLast = sortedSetHeadSet.last();
                if (this.f18980m.apply(objLast)) {
                    return objLast;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return new c(((SortedSet) this.f18979l).subSet(obj, obj2), this.f18980m);
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return new c(((SortedSet) this.f18979l).tailSet(obj), this.f18980m);
        }
    }

    public static abstract class d extends AbstractSet {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return d0.i(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) j3.o.q(collection));
        }
    }

    public static abstract class e extends AbstractSet {
        public /* synthetic */ e(c0 c0Var) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public e() {
        }
    }

    public static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static Set b(Set set, j3.p pVar) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, pVar);
        }
        if (!(set instanceof b)) {
            return new b((Set) j3.o.q(set), (j3.p) j3.o.q(pVar));
        }
        b bVar = (b) set;
        return new b((Set) bVar.f18979l, j3.q.c(bVar.f18980m, pVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SortedSet c(SortedSet sortedSet, j3.p pVar) {
        if (!(sortedSet instanceof b)) {
            return new c((SortedSet) j3.o.q(sortedSet), (j3.p) j3.o.q(pVar));
        }
        b bVar = (b) sortedSet;
        return new c((SortedSet) bVar.f18979l, j3.q.c(bVar.f18980m, pVar));
    }

    public static int d(Set set) {
        Iterator it = set.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i7 = ~(~(i7 + (next != null ? next.hashCode() : 0)));
        }
        return i7;
    }

    public static e e(Set set, Set set2) {
        j3.o.r(set, "set1");
        j3.o.r(set2, "set2");
        return new a(set, set2);
    }

    public static HashSet f() {
        return new HashSet();
    }

    public static HashSet g(int i7) {
        return new HashSet(H.e(i7));
    }

    public static Set h() {
        return Collections.newSetFromMap(H.l());
    }

    public static boolean i(Set set, Collection collection) {
        j3.o.q(collection);
        if (collection instanceof N) {
            collection = ((N) collection).b();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? j(set, collection.iterator()) : E.q(set.iterator(), collection);
    }

    public static boolean j(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
