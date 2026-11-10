package w3;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class z extends AbstractMap implements Serializable {

    /* renamed from: t, reason: collision with root package name */
    public static final Comparator f23349t = new a();

    /* renamed from: l, reason: collision with root package name */
    public final Comparator f23350l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f23351m;

    /* renamed from: n, reason: collision with root package name */
    public e f23352n;

    /* renamed from: o, reason: collision with root package name */
    public int f23353o;

    /* renamed from: p, reason: collision with root package name */
    public int f23354p;

    /* renamed from: q, reason: collision with root package name */
    public final e f23355q;

    /* renamed from: r, reason: collision with root package name */
    public b f23356r;

    /* renamed from: s, reason: collision with root package name */
    public c f23357s;

    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            z.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && z.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = z.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            z.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return z.this.f23353o;
        }
    }

    public final class c extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a().f23371q;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            z.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return z.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return z.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return z.this.f23353o;
        }
    }

    public abstract class d implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public e f23362l;

        /* renamed from: m, reason: collision with root package name */
        public e f23363m = null;

        /* renamed from: n, reason: collision with root package name */
        public int f23364n;

        public d() {
            this.f23362l = z.this.f23355q.f23369o;
            this.f23364n = z.this.f23354p;
        }

        public final e a() {
            e eVar = this.f23362l;
            z zVar = z.this;
            if (eVar == zVar.f23355q) {
                throw new NoSuchElementException();
            }
            if (zVar.f23354p != this.f23364n) {
                throw new ConcurrentModificationException();
            }
            this.f23362l = eVar.f23369o;
            this.f23363m = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f23362l != z.this.f23355q;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f23363m;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            z.this.f(eVar, true);
            this.f23363m = null;
            this.f23364n = z.this.f23354p;
        }
    }

    public z() {
        this(f23349t, true);
    }

    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public e b(Object obj, boolean z7) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.f23350l;
        e eVar2 = this.f23352n;
        if (eVar2 != null) {
            Comparable comparable = comparator == f23349t ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f23371q) : comparator.compare(obj, eVar2.f23371q);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.f23367m : eVar2.f23368n;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        e eVar4 = eVar2;
        if (!z7) {
            return null;
        }
        e eVar5 = this.f23355q;
        if (eVar4 != null) {
            eVar = new e(this.f23351m, eVar4, obj, eVar5, eVar5.f23370p);
            if (iCompareTo < 0) {
                eVar4.f23367m = eVar;
            } else {
                eVar4.f23368n = eVar;
            }
            e(eVar4, true);
        } else {
            if (comparator == f23349t && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f23351m, eVar4, obj, eVar5, eVar5.f23370p);
            this.f23352n = eVar;
        }
        this.f23353o++;
        this.f23354p++;
        return eVar;
    }

    public e c(Map.Entry entry) {
        e eVarD = d(entry.getKey());
        if (eVarD == null || !a(eVarD.f23373s, entry.getValue())) {
            return null;
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f23352n = null;
        this.f23353o = 0;
        this.f23354p++;
        e eVar = this.f23355q;
        eVar.f23370p = eVar;
        eVar.f23369o = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    public e d(Object obj) {
        if (obj != null) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public final void e(e eVar, boolean z7) {
        while (eVar != null) {
            e eVar2 = eVar.f23367m;
            e eVar3 = eVar.f23368n;
            int i7 = eVar2 != null ? eVar2.f23374t : 0;
            int i8 = eVar3 != null ? eVar3.f23374t : 0;
            int i9 = i7 - i8;
            if (i9 == -2) {
                e eVar4 = eVar3.f23367m;
                e eVar5 = eVar3.f23368n;
                int i10 = (eVar4 != null ? eVar4.f23374t : 0) - (eVar5 != null ? eVar5.f23374t : 0);
                if (i10 == -1 || (i10 == 0 && !z7)) {
                    i(eVar);
                } else {
                    j(eVar3);
                    i(eVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 2) {
                e eVar6 = eVar2.f23367m;
                e eVar7 = eVar2.f23368n;
                int i11 = (eVar6 != null ? eVar6.f23374t : 0) - (eVar7 != null ? eVar7.f23374t : 0);
                if (i11 == 1 || (i11 == 0 && !z7)) {
                    j(eVar);
                } else {
                    i(eVar2);
                    j(eVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 0) {
                eVar.f23374t = i7 + 1;
                if (z7) {
                    return;
                }
            } else {
                eVar.f23374t = Math.max(i7, i8) + 1;
                if (!z7) {
                    return;
                }
            }
            eVar = eVar.f23366l;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.f23356r;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f23356r = bVar2;
        return bVar2;
    }

    public void f(e eVar, boolean z7) {
        int i7;
        if (z7) {
            e eVar2 = eVar.f23370p;
            eVar2.f23369o = eVar.f23369o;
            eVar.f23369o.f23370p = eVar2;
        }
        e eVar3 = eVar.f23367m;
        e eVar4 = eVar.f23368n;
        e eVar5 = eVar.f23366l;
        int i8 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f23367m = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f23368n = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f23353o--;
            this.f23354p++;
            return;
        }
        e eVarB = eVar3.f23374t > eVar4.f23374t ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e eVar6 = eVar.f23367m;
        if (eVar6 != null) {
            i7 = eVar6.f23374t;
            eVarB.f23367m = eVar6;
            eVar6.f23366l = eVarB;
            eVar.f23367m = null;
        } else {
            i7 = 0;
        }
        e eVar7 = eVar.f23368n;
        if (eVar7 != null) {
            i8 = eVar7.f23374t;
            eVarB.f23368n = eVar7;
            eVar7.f23366l = eVarB;
            eVar.f23368n = null;
        }
        eVarB.f23374t = Math.max(i7, i8) + 1;
        h(eVar, eVarB);
    }

    public e g(Object obj) {
        e eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f23373s;
        }
        return null;
    }

    public final void h(e eVar, e eVar2) {
        e eVar3 = eVar.f23366l;
        eVar.f23366l = null;
        if (eVar2 != null) {
            eVar2.f23366l = eVar3;
        }
        if (eVar3 == null) {
            this.f23352n = eVar2;
        } else if (eVar3.f23367m == eVar) {
            eVar3.f23367m = eVar2;
        } else {
            eVar3.f23368n = eVar2;
        }
    }

    public final void i(e eVar) {
        e eVar2 = eVar.f23367m;
        e eVar3 = eVar.f23368n;
        e eVar4 = eVar3.f23367m;
        e eVar5 = eVar3.f23368n;
        eVar.f23368n = eVar4;
        if (eVar4 != null) {
            eVar4.f23366l = eVar;
        }
        h(eVar, eVar3);
        eVar3.f23367m = eVar;
        eVar.f23366l = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f23374t : 0, eVar4 != null ? eVar4.f23374t : 0) + 1;
        eVar.f23374t = iMax;
        eVar3.f23374t = Math.max(iMax, eVar5 != null ? eVar5.f23374t : 0) + 1;
    }

    public final void j(e eVar) {
        e eVar2 = eVar.f23367m;
        e eVar3 = eVar.f23368n;
        e eVar4 = eVar2.f23367m;
        e eVar5 = eVar2.f23368n;
        eVar.f23367m = eVar5;
        if (eVar5 != null) {
            eVar5.f23366l = eVar;
        }
        h(eVar, eVar2);
        eVar2.f23368n = eVar;
        eVar.f23366l = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f23374t : 0, eVar5 != null ? eVar5.f23374t : 0) + 1;
        eVar.f23374t = iMax;
        eVar2.f23374t = Math.max(iMax, eVar4 != null ? eVar4.f23374t : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.f23357s;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f23357s = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f23351m) {
            throw new NullPointerException("value == null");
        }
        e eVarB = b(obj, true);
        Object obj3 = eVarB.f23373s;
        eVarB.f23373s = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f23373s;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f23353o;
    }

    public z(boolean z7) {
        this(f23349t, z7);
    }

    public z(Comparator comparator, boolean z7) {
        this.f23353o = 0;
        this.f23354p = 0;
        this.f23350l = comparator == null ? f23349t : comparator;
        this.f23351m = z7;
        this.f23355q = new e(z7);
    }

    public static final class e implements Map.Entry {

        /* renamed from: l, reason: collision with root package name */
        public e f23366l;

        /* renamed from: m, reason: collision with root package name */
        public e f23367m;

        /* renamed from: n, reason: collision with root package name */
        public e f23368n;

        /* renamed from: o, reason: collision with root package name */
        public e f23369o;

        /* renamed from: p, reason: collision with root package name */
        public e f23370p;

        /* renamed from: q, reason: collision with root package name */
        public final Object f23371q;

        /* renamed from: r, reason: collision with root package name */
        public final boolean f23372r;

        /* renamed from: s, reason: collision with root package name */
        public Object f23373s;

        /* renamed from: t, reason: collision with root package name */
        public int f23374t;

        public e(boolean z7) {
            this.f23371q = null;
            this.f23372r = z7;
            this.f23370p = this;
            this.f23369o = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f23367m; eVar2 != null; eVar2 = eVar2.f23367m) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f23368n; eVar2 != null; eVar2 = eVar2.f23368n) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f23371q;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f23373s;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f23371q;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f23373s;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f23371q;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f23373s;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f23372r) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f23373s;
            this.f23373s = obj;
            return obj2;
        }

        public String toString() {
            return this.f23371q + "=" + this.f23373s;
        }

        public e(boolean z7, e eVar, Object obj, e eVar2, e eVar3) {
            this.f23366l = eVar;
            this.f23371q = obj;
            this.f23372r = z7;
            this.f23374t = 1;
            this.f23369o = eVar2;
            this.f23370p = eVar3;
            eVar3.f23369o = this;
            eVar2.f23370p = this;
        }
    }
}
