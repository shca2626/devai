package k3;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import k3.AbstractC1264f;
import k3.H;

/* renamed from: k3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1262d extends AbstractC1264f implements Serializable {

    /* renamed from: p, reason: collision with root package name */
    public transient Map f18930p;

    /* renamed from: q, reason: collision with root package name */
    public transient int f18931q;

    /* renamed from: k3.d$b */
    public class b extends AbstractC0215d {
        public b() {
            super();
        }

        @Override // k3.AbstractC1262d.AbstractC0215d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(Object obj, Object obj2) {
            return H.h(obj, obj2);
        }
    }

    /* renamed from: k3.d$c */
    public class c extends H.n {

        /* renamed from: n, reason: collision with root package name */
        public final transient Map f18934n;

        /* renamed from: k3.d$c$a */
        public class a extends H.h {
            public a() {
            }

            @Override // k3.H.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return AbstractC1268j.c(c.this.f18934n.entrySet(), obj);
            }

            @Override // k3.H.h
            public Map f() {
                return c.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return c.this.new b();
            }

            @Override // k3.H.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractC1262d.this.x(entry.getKey());
                return true;
            }
        }

        /* renamed from: k3.d$c$b */
        public class b implements Iterator {

            /* renamed from: l, reason: collision with root package name */
            public final Iterator f18937l;

            /* renamed from: m, reason: collision with root package name */
            public Collection f18938m;

            public b() {
                this.f18937l = c.this.f18934n.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.f18937l.next();
                this.f18938m = (Collection) entry.getValue();
                return c.this.e(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f18937l.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                j3.o.w(this.f18938m != null, "no calls to next() since the last call to remove()");
                this.f18937l.remove();
                AbstractC1262d.q(AbstractC1262d.this, this.f18938m.size());
                this.f18938m.clear();
                this.f18938m = null;
            }
        }

        public c(Map map) {
            this.f18934n = map;
        }

        @Override // k3.H.n
        public Set a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) H.n(this.f18934n, obj);
            if (collection == null) {
                return null;
            }
            return AbstractC1262d.this.z(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f18934n == AbstractC1262d.this.f18930p) {
                AbstractC1262d.this.clear();
            } else {
                E.c(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return H.m(this.f18934n, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.f18934n.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionS = AbstractC1262d.this.s();
            collectionS.addAll(collection);
            AbstractC1262d.q(AbstractC1262d.this, collection.size());
            collection.clear();
            return collectionS;
        }

        public Map.Entry e(Map.Entry entry) {
            Object key = entry.getKey();
            return H.h(key, AbstractC1262d.this.z(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f18934n.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f18934n.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set g() {
            return AbstractC1262d.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f18934n.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f18934n.toString();
        }
    }

    /* renamed from: k3.d$d, reason: collision with other inner class name */
    public abstract class AbstractC0215d implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public final Iterator f18940l;

        /* renamed from: m, reason: collision with root package name */
        public Object f18941m = null;

        /* renamed from: n, reason: collision with root package name */
        public Collection f18942n = null;

        /* renamed from: o, reason: collision with root package name */
        public Iterator f18943o = E.h();

        public AbstractC0215d() {
            this.f18940l = AbstractC1262d.this.f18930p.entrySet().iterator();
        }

        public abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18940l.hasNext() || this.f18943o.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f18943o.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f18940l.next();
                this.f18941m = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.f18942n = collection;
                this.f18943o = collection.iterator();
            }
            return a(Q.a(this.f18941m), this.f18943o.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f18943o.remove();
            Collection collection = this.f18942n;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f18940l.remove();
            }
            AbstractC1262d.o(AbstractC1262d.this);
        }
    }

    /* renamed from: k3.d$e */
    public class e extends H.k {

        /* renamed from: k3.d$e$a */
        public class a implements Iterator {

            /* renamed from: l, reason: collision with root package name */
            public Map.Entry f18946l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ Iterator f18947m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ e f18948n;

            public a(e eVar, Iterator it) {
                this.f18947m = it;
                this.f18948n = eVar;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f18947m.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.f18947m.next();
                this.f18946l = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                j3.o.w(this.f18946l != null, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) this.f18946l.getValue();
                this.f18947m.remove();
                AbstractC1262d.q(AbstractC1262d.this, collection.size());
                collection.clear();
                this.f18946l = null;
            }
        }

        public e(Map map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            E.c(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return f().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || f().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return f().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(this, f().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) f().remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractC1262d.q(AbstractC1262d.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* renamed from: k3.d$f */
    public final class f extends i implements NavigableMap {
        public f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryCeilingEntry = h().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return e(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return h().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return AbstractC1262d.this.new f(h().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryFirstEntry = h().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return e(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryFloorEntry = h().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return e(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return h().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryHigherEntry = h().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return e(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return h().higherKey(obj);
        }

        @Override // k3.AbstractC1262d.i
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet f() {
            return AbstractC1262d.this.new g(h());
        }

        @Override // k3.AbstractC1262d.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        public Map.Entry k(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionS = AbstractC1262d.this.s();
            collectionS.addAll((Collection) entry.getValue());
            it.remove();
            return H.h(entry.getKey(), AbstractC1262d.this.y(collectionS));
        }

        @Override // k3.AbstractC1262d.i
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap h() {
            return (NavigableMap) super.h();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryLastEntry = h().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return e(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryLowerEntry = h().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return e(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return h().lowerKey(obj);
        }

        @Override // k3.AbstractC1262d.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // k3.AbstractC1262d.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return g();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return k(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return k(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z7) {
            return AbstractC1262d.this.new f(h().headMap(obj, z7));
        }

        @Override // k3.AbstractC1262d.i, k3.AbstractC1262d.c, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z7, Object obj2, boolean z8) {
            return AbstractC1262d.this.new f(h().subMap(obj, z7, obj2, z8));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z7) {
            return AbstractC1262d.this.new f(h().tailMap(obj, z7));
        }
    }

    /* renamed from: k3.d$g */
    public final class g extends j implements NavigableSet {
        public g(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return g().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return AbstractC1262d.this.new g(g().descendingMap());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return g().floorKey(obj);
        }

        @Override // k3.AbstractC1262d.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return g().higherKey(obj);
        }

        @Override // k3.AbstractC1262d.j
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap g() {
            return (NavigableMap) super.g();
        }

        @Override // k3.AbstractC1262d.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // k3.AbstractC1262d.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return g().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return E.p(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return E.p(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z7) {
            return AbstractC1262d.this.new g(g().headMap(obj, z7));
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z7, Object obj2, boolean z8) {
            return AbstractC1262d.this.new g(g().subMap(obj, z7, obj2, z8));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z7) {
            return AbstractC1262d.this.new g(g().tailMap(obj, z7));
        }
    }

    /* renamed from: k3.d$h */
    public class h extends l implements RandomAccess {
        public h(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }
    }

    /* renamed from: k3.d$i */
    public class i extends c implements SortedMap {

        /* renamed from: p, reason: collision with root package name */
        public SortedSet f18952p;

        public i(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return h().comparator();
        }

        public SortedSet f() {
            return AbstractC1262d.this.new j(h());
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return h().firstKey();
        }

        @Override // k3.AbstractC1262d.c, java.util.AbstractMap, java.util.Map
        public SortedSet g() {
            SortedSet sortedSet = this.f18952p;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetF = f();
            this.f18952p = sortedSetF;
            return sortedSetF;
        }

        public SortedMap h() {
            return (SortedMap) this.f18934n;
        }

        public SortedMap headMap(Object obj) {
            return AbstractC1262d.this.new i(h().headMap(obj));
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return h().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return AbstractC1262d.this.new i(h().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return AbstractC1262d.this.new i(h().tailMap(obj));
        }
    }

    /* renamed from: k3.d$j */
    public class j extends e implements SortedSet {
        public j(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return g().firstKey();
        }

        public SortedMap g() {
            return (SortedMap) super.f();
        }

        public SortedSet headSet(Object obj) {
            return AbstractC1262d.this.new j(g().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return g().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return AbstractC1262d.this.new j(g().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return AbstractC1262d.this.new j(g().tailMap(obj));
        }
    }

    public AbstractC1262d(Map map) {
        j3.o.d(map.isEmpty());
        this.f18930p = map;
    }

    public static /* synthetic */ int n(AbstractC1262d abstractC1262d) {
        int i7 = abstractC1262d.f18931q;
        abstractC1262d.f18931q = i7 + 1;
        return i7;
    }

    public static /* synthetic */ int o(AbstractC1262d abstractC1262d) {
        int i7 = abstractC1262d.f18931q;
        abstractC1262d.f18931q = i7 - 1;
        return i7;
    }

    public static /* synthetic */ int p(AbstractC1262d abstractC1262d, int i7) {
        int i8 = abstractC1262d.f18931q + i7;
        abstractC1262d.f18931q = i8;
        return i8;
    }

    public static /* synthetic */ int q(AbstractC1262d abstractC1262d, int i7) {
        int i8 = abstractC1262d.f18931q - i7;
        abstractC1262d.f18931q = i8;
        return i8;
    }

    public static Iterator w(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public final List A(Object obj, List list, k kVar) {
        return list instanceof RandomAccess ? new h(obj, list, kVar) : new l(obj, list, kVar);
    }

    @Override // k3.AbstractC1264f, k3.J
    public Collection a() {
        return super.a();
    }

    @Override // k3.J
    public void clear() {
        Iterator it = this.f18930p.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f18930p.clear();
        this.f18931q = 0;
    }

    @Override // k3.AbstractC1264f
    public Collection f() {
        return new AbstractC1264f.a();
    }

    @Override // k3.J
    public Collection get(Object obj) {
        Collection collectionT = (Collection) this.f18930p.get(obj);
        if (collectionT == null) {
            collectionT = t(obj);
        }
        return z(obj, collectionT);
    }

    @Override // k3.AbstractC1264f
    public Collection h() {
        return new AbstractC1264f.b();
    }

    @Override // k3.AbstractC1264f
    public Iterator i() {
        return new b();
    }

    @Override // k3.AbstractC1264f
    public Iterator k() {
        return new a();
    }

    @Override // k3.J
    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.f18930p.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f18931q++;
            return true;
        }
        Collection collectionT = t(obj);
        if (!collectionT.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f18931q++;
        this.f18930p.put(obj, collectionT);
        return true;
    }

    public abstract Collection s();

    @Override // k3.J
    public int size() {
        return this.f18931q;
    }

    public Collection t(Object obj) {
        return s();
    }

    public final Map u() {
        Map map = this.f18930p;
        return map instanceof NavigableMap ? new f((NavigableMap) this.f18930p) : map instanceof SortedMap ? new i((SortedMap) this.f18930p) : new c(this.f18930p);
    }

    public final Set v() {
        Map map = this.f18930p;
        return map instanceof NavigableMap ? new g((NavigableMap) this.f18930p) : map instanceof SortedMap ? new j((SortedMap) this.f18930p) : new e(this.f18930p);
    }

    @Override // k3.AbstractC1264f, k3.J
    public Collection values() {
        return super.values();
    }

    public final void x(Object obj) {
        Collection collection = (Collection) H.o(this.f18930p, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f18931q -= size;
        }
    }

    public abstract Collection y(Collection collection);

    public abstract Collection z(Object obj, Collection collection);

    /* renamed from: k3.d$k */
    public class k extends AbstractCollection {

        /* renamed from: l, reason: collision with root package name */
        public final Object f18955l;

        /* renamed from: m, reason: collision with root package name */
        public Collection f18956m;

        /* renamed from: n, reason: collision with root package name */
        public final k f18957n;

        /* renamed from: o, reason: collision with root package name */
        public final Collection f18958o;

        public k(Object obj, Collection collection, k kVar) {
            this.f18955l = obj;
            this.f18956m = collection;
            this.f18957n = kVar;
            this.f18958o = kVar == null ? null : kVar.h();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            j();
            boolean zIsEmpty = this.f18956m.isEmpty();
            boolean zAdd = this.f18956m.add(obj);
            if (zAdd) {
                AbstractC1262d.n(AbstractC1262d.this);
                if (zIsEmpty) {
                    f();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f18956m.addAll(collection);
            if (zAddAll) {
                AbstractC1262d.p(AbstractC1262d.this, this.f18956m.size() - size);
                if (size == 0) {
                    f();
                }
            }
            return zAddAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f18956m.clear();
            AbstractC1262d.q(AbstractC1262d.this, size);
            k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            j();
            return this.f18956m.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            j();
            return this.f18956m.containsAll(collection);
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            j();
            return this.f18956m.equals(obj);
        }

        public void f() {
            k kVar = this.f18957n;
            if (kVar != null) {
                kVar.f();
            } else {
                AbstractC1262d.this.f18930p.put(this.f18955l, this.f18956m);
            }
        }

        public k g() {
            return this.f18957n;
        }

        public Collection h() {
            return this.f18956m;
        }

        @Override // java.util.Collection
        public int hashCode() {
            j();
            return this.f18956m.hashCode();
        }

        public Object i() {
            return this.f18955l;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            j();
            return new a();
        }

        public void j() {
            Collection collection;
            k kVar = this.f18957n;
            if (kVar != null) {
                kVar.j();
                if (this.f18957n.h() != this.f18958o) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f18956m.isEmpty() || (collection = (Collection) AbstractC1262d.this.f18930p.get(this.f18955l)) == null) {
                    return;
                }
                this.f18956m = collection;
            }
        }

        public void k() {
            k kVar = this.f18957n;
            if (kVar != null) {
                kVar.k();
            } else if (this.f18956m.isEmpty()) {
                AbstractC1262d.this.f18930p.remove(this.f18955l);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            j();
            boolean zRemove = this.f18956m.remove(obj);
            if (zRemove) {
                AbstractC1262d.o(AbstractC1262d.this);
                k();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f18956m.removeAll(collection);
            if (zRemoveAll) {
                AbstractC1262d.p(AbstractC1262d.this, this.f18956m.size() - size);
                k();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            j3.o.q(collection);
            int size = size();
            boolean zRetainAll = this.f18956m.retainAll(collection);
            if (zRetainAll) {
                AbstractC1262d.p(AbstractC1262d.this, this.f18956m.size() - size);
                k();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            j();
            return this.f18956m.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            j();
            return this.f18956m.toString();
        }

        /* renamed from: k3.d$k$a */
        public class a implements Iterator {

            /* renamed from: l, reason: collision with root package name */
            public final Iterator f18960l;

            /* renamed from: m, reason: collision with root package name */
            public final Collection f18961m;

            public a() {
                Collection collection = k.this.f18956m;
                this.f18961m = collection;
                this.f18960l = AbstractC1262d.w(collection);
            }

            public Iterator a() {
                b();
                return this.f18960l;
            }

            public void b() {
                k.this.j();
                if (k.this.f18956m != this.f18961m) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f18960l.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                b();
                return this.f18960l.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f18960l.remove();
                AbstractC1262d.o(AbstractC1262d.this);
                k.this.k();
            }

            public a(Iterator it) {
                this.f18961m = k.this.f18956m;
                this.f18960l = it;
            }
        }
    }

    /* renamed from: k3.d$l */
    public class l extends k implements List {

        /* renamed from: k3.d$l$a */
        public class a extends k.a implements ListIterator {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean zIsEmpty = l.this.isEmpty();
                c().add(obj);
                AbstractC1262d.n(AbstractC1262d.this);
                if (zIsEmpty) {
                    l.this.f();
                }
            }

            public final ListIterator c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c().set(obj);
            }

            public a(int i7) {
                super(l.this.l().listIterator(i7));
            }
        }

        public l(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }

        @Override // java.util.List
        public void add(int i7, Object obj) {
            j();
            boolean zIsEmpty = h().isEmpty();
            l().add(i7, obj);
            AbstractC1262d.n(AbstractC1262d.this);
            if (zIsEmpty) {
                f();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i7, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = l().addAll(i7, collection);
            if (zAddAll) {
                AbstractC1262d.p(AbstractC1262d.this, h().size() - size);
                if (size == 0) {
                    f();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public Object get(int i7) {
            j();
            return l().get(i7);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            j();
            return l().indexOf(obj);
        }

        public List l() {
            return (List) h();
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            j();
            return l().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            j();
            return new a();
        }

        @Override // java.util.List
        public Object remove(int i7) {
            j();
            Object objRemove = l().remove(i7);
            AbstractC1262d.o(AbstractC1262d.this);
            k();
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i7, Object obj) {
            j();
            return l().set(i7, obj);
        }

        @Override // java.util.List
        public List subList(int i7, int i8) {
            j();
            return AbstractC1262d.this.A(i(), l().subList(i7, i8), g() == null ? this : g());
        }

        @Override // java.util.List
        public ListIterator listIterator(int i7) {
            j();
            return new a(i7);
        }
    }

    /* renamed from: k3.d$a */
    public class a extends AbstractC0215d {
        public a() {
            super();
        }

        @Override // k3.AbstractC1262d.AbstractC0215d
        public Object a(Object obj, Object obj2) {
            return obj2;
        }
    }
}
