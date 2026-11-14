package y;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import z.AbstractC1825a;

/* renamed from: y.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1786a extends C1796k implements Map {

    /* renamed from: o, reason: collision with root package name */
    public C0290a f23782o;

    /* renamed from: p, reason: collision with root package name */
    public c f23783p;

    /* renamed from: q, reason: collision with root package name */
    public e f23784q;

    /* renamed from: y.a$a, reason: collision with other inner class name */
    public final class C0290a extends AbstractSet {
        public C0290a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C1786a.this.new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1786a.this.size();
        }
    }

    /* renamed from: y.a$b */
    public final class b extends AbstractC1792g {
        public b() {
            super(C1786a.this.size());
        }

        @Override // y.AbstractC1792g
        public Object a(int i7) {
            return C1786a.this.f(i7);
        }

        @Override // y.AbstractC1792g
        public void b(int i7) {
            C1786a.this.h(i7);
        }
    }

    /* renamed from: y.a$d */
    public final class d implements Iterator, Map.Entry {

        /* renamed from: l, reason: collision with root package name */
        public int f23788l;

        /* renamed from: m, reason: collision with root package name */
        public int f23789m = -1;

        /* renamed from: n, reason: collision with root package name */
        public boolean f23790n;

        public d() {
            this.f23788l = C1786a.this.size() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f23789m++;
            this.f23790n = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f23790n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC1825a.c(entry.getKey(), C1786a.this.f(this.f23789m)) && AbstractC1825a.c(entry.getValue(), C1786a.this.j(this.f23789m));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f23790n) {
                return C1786a.this.f(this.f23789m);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f23790n) {
                return C1786a.this.j(this.f23789m);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23789m < this.f23788l;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f23790n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objF = C1786a.this.f(this.f23789m);
            Object objJ = C1786a.this.j(this.f23789m);
            return (objF == null ? 0 : objF.hashCode()) ^ (objJ != null ? objJ.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f23790n) {
                throw new IllegalStateException();
            }
            C1786a.this.h(this.f23789m);
            this.f23789m--;
            this.f23788l--;
            this.f23790n = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f23790n) {
                return C1786a.this.i(this.f23789m, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: y.a$f */
    public final class f extends AbstractC1792g {
        public f() {
            super(C1786a.this.size());
        }

        @Override // y.AbstractC1792g
        public Object a(int i7) {
            return C1786a.this.j(i7);
        }

        @Override // y.AbstractC1792g
        public void b(int i7) {
            C1786a.this.h(i7);
        }
    }

    public C1786a() {
    }

    public static boolean l(Set set, Object obj) {
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

    @Override // y.C1796k, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // y.C1796k, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        C0290a c0290a = this.f23782o;
        if (c0290a != null) {
            return c0290a;
        }
        C0290a c0290a2 = new C0290a();
        this.f23782o = c0290a2;
        return c0290a2;
    }

    @Override // y.C1796k, java.util.Map
    public Object get(Object obj) {
        return super.get(obj);
    }

    public boolean k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public Set keySet() {
        c cVar = this.f23783p;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f23783p = cVar2;
        return cVar2;
    }

    public boolean m(Collection collection) {
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return size != size();
    }

    public boolean n(Collection collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(f(size2))) {
                h(size2);
            }
        }
        return size != size();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        b(size() + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // y.C1796k, java.util.Map
    public Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // java.util.Map
    public Collection values() {
        e eVar = this.f23784q;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        this.f23784q = eVar2;
        return eVar2;
    }

    public C1786a(int i7) {
        super(i7);
    }

    /* renamed from: y.a$c */
    public final class c implements Set {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            C1786a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return C1786a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return C1786a.this.k(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return C1786a.l(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int size = C1786a.this.size() - 1; size >= 0; size--) {
                Object objF = C1786a.this.f(size);
                iHashCode += objF == null ? 0 : objF.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return C1786a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return C1786a.this.new b();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iD = C1786a.this.d(obj);
            if (iD < 0) {
                return false;
            }
            C1786a.this.h(iD);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return C1786a.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return C1786a.this.n(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return C1786a.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int size = C1786a.this.size();
            Object[] objArr = new Object[size];
            for (int i7 = 0; i7 < size; i7++) {
                objArr[i7] = C1786a.this.f(i7);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i7 = 0; i7 < size; i7++) {
                objArr[i7] = C1786a.this.f(i7);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    /* renamed from: y.a$e */
    public final class e implements Collection {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            C1786a.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return C1786a.this.a(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return C1786a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return C1786a.this.new f();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iA = C1786a.this.a(obj);
            if (iA < 0) {
                return false;
            }
            C1786a.this.h(iA);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int size = C1786a.this.size();
            int i7 = 0;
            boolean z7 = false;
            while (i7 < size) {
                if (collection.contains(C1786a.this.j(i7))) {
                    C1786a.this.h(i7);
                    i7--;
                    size--;
                    z7 = true;
                }
                i7++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int size = C1786a.this.size();
            int i7 = 0;
            boolean z7 = false;
            while (i7 < size) {
                if (!collection.contains(C1786a.this.j(i7))) {
                    C1786a.this.h(i7);
                    i7--;
                    size--;
                    z7 = true;
                }
                i7++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public int size() {
            return C1786a.this.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int size = C1786a.this.size();
            Object[] objArr = new Object[size];
            for (int i7 = 0; i7 < size; i7++) {
                objArr[i7] = C1786a.this.j(i7);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i7 = 0; i7 < size; i7++) {
                objArr[i7] = C1786a.this.j(i7);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    public C1786a(C1796k c1796k) {
        super(c1796k);
    }
}
