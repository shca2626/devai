package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class c0 extends AbstractMap {

    /* renamed from: l, reason: collision with root package name */
    public List f12003l;

    /* renamed from: m, reason: collision with root package name */
    public Map f12004m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12005n;

    /* renamed from: o, reason: collision with root package name */
    public volatile f f12006o;

    /* renamed from: p, reason: collision with root package name */
    public Map f12007p;

    /* renamed from: q, reason: collision with root package name */
    public volatile c f12008q;

    public class a extends c0 {
        public a() {
            super(null);
        }

        @Override // androidx.datastore.preferences.protobuf.c0
        public void p() {
            if (!o()) {
                if (k() > 0) {
                    android.support.v4.media.session.b.a(j(0).getKey());
                    throw null;
                }
                Iterator it = m().iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.b.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            }
            super.p();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.r((Comparable) obj, obj2);
        }
    }

    public class c extends f {
        public c() {
            super(c0.this, null);
        }

        @Override // androidx.datastore.preferences.protobuf.c0.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(c0.this, null);
        }

        public /* synthetic */ c(c0 c0Var, a aVar) {
            this();
        }
    }

    public class d implements Map.Entry, Comparable {

        /* renamed from: l, reason: collision with root package name */
        public final Comparable f12013l;

        /* renamed from: m, reason: collision with root package name */
        public Object f12014m;

        public d(c0 c0Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return getKey().compareTo(dVar.getKey());
        }

        public final boolean d(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f12013l;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return d(this.f12013l, entry.getKey()) && d(this.f12014m, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f12014m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f12013l;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f12014m;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            c0.this.g();
            Object obj2 = this.f12014m;
            this.f12014m = obj;
            return obj2;
        }

        public String toString() {
            return this.f12013l + "=" + this.f12014m;
        }

        public d(Comparable comparable, Object obj) {
            this.f12013l = comparable;
            this.f12014m = obj;
        }
    }

    public class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = c0.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            c0.this.r((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(c0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            c0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c0.this.size();
        }

        public /* synthetic */ f(c0 c0Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ c0(a aVar) {
        this();
    }

    public static c0 q() {
        return new a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f12003l.isEmpty()) {
            this.f12003l.clear();
        }
        if (this.f12004m.isEmpty()) {
            return;
        }
        this.f12004m.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f12004m.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f12006o == null) {
            this.f12006o = new f(this, null);
        }
        return this.f12006o;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return super.equals(obj);
        }
        c0 c0Var = (c0) obj;
        int size = size();
        if (size != c0Var.size()) {
            return false;
        }
        int iK = k();
        if (iK != c0Var.k()) {
            return entrySet().equals(c0Var.entrySet());
        }
        for (int i7 = 0; i7 < iK; i7++) {
            if (!j(i7).equals(c0Var.j(i7))) {
                return false;
            }
        }
        if (iK != size) {
            return this.f12004m.equals(c0Var.f12004m);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f12003l
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f12003l
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.c0$d r2 = (androidx.datastore.preferences.protobuf.c0.d) r2
            java.lang.Comparable r2 = r2.getKey()
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L20
            int r0 = r0 + 1
        L1e:
            int r5 = -r0
            return r5
        L20:
            if (r2 != 0) goto L23
            return r1
        L23:
            r0 = 0
        L24:
            if (r0 > r1) goto L47
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f12003l
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.c0$d r3 = (androidx.datastore.preferences.protobuf.c0.d) r3
            java.lang.Comparable r3 = r3.getKey()
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L40
            int r2 = r2 + (-1)
            r1 = r2
            goto L24
        L40:
            if (r3 <= 0) goto L46
            int r2 = r2 + 1
            r0 = r2
            goto L24
        L46:
            return r2
        L47:
            int r0 = r0 + 1
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c0.f(java.lang.Comparable):int");
    }

    public final void g() {
        if (this.f12005n) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((d) this.f12003l.get(iF)).getValue() : this.f12004m.get(comparable);
    }

    public Set h() {
        if (this.f12008q == null) {
            this.f12008q = new c(this, null);
        }
        return this.f12008q;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i7 = 0; i7 < iK; i7++) {
            iHashCode += ((d) this.f12003l.get(i7)).hashCode();
        }
        return l() > 0 ? iHashCode + this.f12004m.hashCode() : iHashCode;
    }

    public final void i() {
        g();
        if (!this.f12003l.isEmpty() || (this.f12003l instanceof ArrayList)) {
            return;
        }
        this.f12003l = new ArrayList(16);
    }

    public Map.Entry j(int i7) {
        return (Map.Entry) this.f12003l.get(i7);
    }

    public int k() {
        return this.f12003l.size();
    }

    public int l() {
        return this.f12004m.size();
    }

    public Iterable m() {
        return this.f12004m.isEmpty() ? Collections.EMPTY_SET : this.f12004m.entrySet();
    }

    public final SortedMap n() {
        g();
        if (this.f12004m.isEmpty() && !(this.f12004m instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f12004m = treeMap;
            this.f12007p = treeMap.descendingMap();
        }
        return (SortedMap) this.f12004m;
    }

    public boolean o() {
        return this.f12005n;
    }

    public void p() {
        if (this.f12005n) {
            return;
        }
        this.f12004m = this.f12004m.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f12004m);
        this.f12007p = this.f12007p.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f12007p);
        this.f12005n = true;
    }

    public Object r(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((d) this.f12003l.get(iF)).setValue(obj);
        }
        i();
        int i7 = -(iF + 1);
        if (i7 >= 16) {
            return n().put(comparable, obj);
        }
        if (this.f12003l.size() == 16) {
            d dVar = (d) this.f12003l.remove(15);
            n().put(dVar.getKey(), dVar.getValue());
        }
        this.f12003l.add(i7, new d(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return s(iF);
        }
        if (this.f12004m.isEmpty()) {
            return null;
        }
        return this.f12004m.remove(comparable);
    }

    public final Object s(int i7) {
        g();
        Object value = ((d) this.f12003l.remove(i7)).getValue();
        if (!this.f12004m.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            this.f12003l.add(new d(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f12003l.size() + this.f12004m.size();
    }

    public class b implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public int f12009l;

        /* renamed from: m, reason: collision with root package name */
        public Iterator f12010m;

        public b() {
            this.f12009l = c0.this.f12003l.size();
        }

        public final Iterator a() {
            if (this.f12010m == null) {
                this.f12010m = c0.this.f12007p.entrySet().iterator();
            }
            return this.f12010m;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List list = c0.this.f12003l;
            int i7 = this.f12009l - 1;
            this.f12009l = i7;
            return (Map.Entry) list.get(i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i7 = this.f12009l;
            return (i7 > 0 && i7 <= c0.this.f12003l.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(c0 c0Var, a aVar) {
            this();
        }
    }

    public class e implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public int f12016l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f12017m;

        /* renamed from: n, reason: collision with root package name */
        public Iterator f12018n;

        public e() {
            this.f12016l = -1;
        }

        public final Iterator a() {
            if (this.f12018n == null) {
                this.f12018n = c0.this.f12004m.entrySet().iterator();
            }
            return this.f12018n;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f12017m = true;
            int i7 = this.f12016l + 1;
            this.f12016l = i7;
            return i7 < c0.this.f12003l.size() ? (Map.Entry) c0.this.f12003l.get(this.f12016l) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12016l + 1 < c0.this.f12003l.size() || (!c0.this.f12004m.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f12017m) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f12017m = false;
            c0.this.g();
            if (this.f12016l >= c0.this.f12003l.size()) {
                a().remove();
                return;
            }
            c0 c0Var = c0.this;
            int i7 = this.f12016l;
            this.f12016l = i7 - 1;
            c0Var.s(i7);
        }

        public /* synthetic */ e(c0 c0Var, a aVar) {
            this();
        }
    }

    public c0() {
        this.f12003l = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        this.f12004m = map;
        this.f12007p = map;
    }
}
