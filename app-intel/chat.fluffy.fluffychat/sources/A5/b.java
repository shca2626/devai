package A5;

import M5.m;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import z5.AbstractC1872c;
import z5.AbstractC1874e;
import z5.C1880k;
import z5.C1883n;

/* loaded from: classes.dex */
public final class b extends AbstractC1874e implements List, RandomAccess, Serializable, N5.b {

    /* renamed from: o, reason: collision with root package name */
    public static final C0005b f270o = new C0005b(null);

    /* renamed from: p, reason: collision with root package name */
    public static final b f271p;

    /* renamed from: l, reason: collision with root package name */
    public Object[] f272l;

    /* renamed from: m, reason: collision with root package name */
    public int f273m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f274n;

    public static final class a extends AbstractC1874e implements List, RandomAccess, Serializable, N5.b {

        /* renamed from: l, reason: collision with root package name */
        public Object[] f275l;

        /* renamed from: m, reason: collision with root package name */
        public final int f276m;

        /* renamed from: n, reason: collision with root package name */
        public int f277n;

        /* renamed from: o, reason: collision with root package name */
        public final a f278o;

        /* renamed from: p, reason: collision with root package name */
        public final b f279p;

        /* renamed from: A5.b$a$a, reason: collision with other inner class name */
        public static final class C0004a implements ListIterator, N5.a {

            /* renamed from: l, reason: collision with root package name */
            public final a f280l;

            /* renamed from: m, reason: collision with root package name */
            public int f281m;

            /* renamed from: n, reason: collision with root package name */
            public int f282n;

            /* renamed from: o, reason: collision with root package name */
            public int f283o;

            public C0004a(a aVar, int i7) {
                m.e(aVar, "list");
                this.f280l = aVar;
                this.f281m = i7;
                this.f282n = -1;
                this.f283o = ((AbstractList) aVar).modCount;
            }

            public final void a() {
                if (((AbstractList) this.f280l.f279p).modCount != this.f283o) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                a();
                a aVar = this.f280l;
                int i7 = this.f281m;
                this.f281m = i7 + 1;
                aVar.add(i7, obj);
                this.f282n = -1;
                this.f283o = ((AbstractList) this.f280l).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f281m < this.f280l.f277n;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f281m > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                a();
                if (this.f281m >= this.f280l.f277n) {
                    throw new NoSuchElementException();
                }
                int i7 = this.f281m;
                this.f281m = i7 + 1;
                this.f282n = i7;
                return this.f280l.f275l[this.f280l.f276m + this.f282n];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f281m;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                a();
                int i7 = this.f281m;
                if (i7 <= 0) {
                    throw new NoSuchElementException();
                }
                int i8 = i7 - 1;
                this.f281m = i8;
                this.f282n = i8;
                return this.f280l.f275l[this.f280l.f276m + this.f282n];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f281m - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                a();
                int i7 = this.f282n;
                if (i7 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                this.f280l.g(i7);
                this.f281m = this.f282n;
                this.f282n = -1;
                this.f283o = ((AbstractList) this.f280l).modCount;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                a();
                int i7 = this.f282n;
                if (i7 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.f280l.set(i7, obj);
            }
        }

        public a(Object[] objArr, int i7, int i8, a aVar, b bVar) {
            m.e(objArr, "backing");
            m.e(bVar, "root");
            this.f275l = objArr;
            this.f276m = i7;
            this.f277n = i8;
            this.f278o = aVar;
            this.f279p = bVar;
            ((AbstractList) this).modCount = ((AbstractList) bVar).modCount;
        }

        private final void o() {
            if (((AbstractList) this.f279p).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void s() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            p();
            o();
            n(this.f276m + this.f277n, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
            m.e(collection, "elements");
            p();
            o();
            int size = collection.size();
            m(this.f276m + this.f277n, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            p();
            o();
            u(this.f276m, this.f277n);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            o();
            if (obj != this) {
                return (obj instanceof List) && q((List) obj);
            }
            return true;
        }

        @Override // z5.AbstractC1874e
        public int f() {
            o();
            return this.f277n;
        }

        @Override // z5.AbstractC1874e
        public Object g(int i7) {
            p();
            o();
            AbstractC1872c.f24186l.b(i7, this.f277n);
            return t(this.f276m + i7);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i7) {
            o();
            AbstractC1872c.f24186l.b(i7, this.f277n);
            return this.f275l[this.f276m + i7];
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            o();
            return A5.c.i(this.f275l, this.f276m, this.f277n);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            o();
            for (int i7 = 0; i7 < this.f277n; i7++) {
                if (m.a(this.f275l[this.f276m + i7], obj)) {
                    return i7;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            o();
            return this.f277n == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            o();
            for (int i7 = this.f277n - 1; i7 >= 0; i7--) {
                if (m.a(this.f275l[this.f276m + i7], obj)) {
                    return i7;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator() {
            return listIterator(0);
        }

        public final void m(int i7, Collection collection, int i8) {
            s();
            a aVar = this.f278o;
            if (aVar != null) {
                aVar.m(i7, collection, i8);
            } else {
                this.f279p.q(i7, collection, i8);
            }
            this.f275l = this.f279p.f272l;
            this.f277n += i8;
        }

        public final void n(int i7, Object obj) {
            s();
            a aVar = this.f278o;
            if (aVar != null) {
                aVar.n(i7, obj);
            } else {
                this.f279p.r(i7, obj);
            }
            this.f275l = this.f279p.f272l;
            this.f277n++;
        }

        public final void p() {
            if (r()) {
                throw new UnsupportedOperationException();
            }
        }

        public final boolean q(List list) {
            return A5.c.h(this.f275l, this.f276m, this.f277n, list);
        }

        public final boolean r() {
            return this.f279p.f274n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            p();
            o();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                g(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection collection) {
            m.e(collection, "elements");
            p();
            o();
            return v(this.f276m, this.f277n, collection, false) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection collection) {
            m.e(collection, "elements");
            p();
            o();
            return v(this.f276m, this.f277n, collection, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i7, Object obj) {
            p();
            o();
            AbstractC1872c.f24186l.b(i7, this.f277n);
            Object[] objArr = this.f275l;
            int i8 = this.f276m;
            Object obj2 = objArr[i8 + i7];
            objArr[i8 + i7] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i7, int i8) {
            AbstractC1872c.f24186l.d(i7, i8, this.f277n);
            return new a(this.f275l, this.f276m + i7, i8 - i7, this, this.f279p);
        }

        public final Object t(int i7) {
            s();
            a aVar = this.f278o;
            this.f277n--;
            return aVar != null ? aVar.t(i7) : this.f279p.z(i7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray(Object[] objArr) {
            m.e(objArr, "array");
            o();
            int length = objArr.length;
            int i7 = this.f277n;
            if (length >= i7) {
                Object[] objArr2 = this.f275l;
                int i8 = this.f276m;
                C1880k.h(objArr2, objArr, 0, i8, i7 + i8);
                return C1883n.e(this.f277n, objArr);
            }
            Object[] objArr3 = this.f275l;
            int i9 = this.f276m;
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr3, i9, i7 + i9, objArr.getClass());
            m.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            o();
            return A5.c.j(this.f275l, this.f276m, this.f277n, this);
        }

        public final void u(int i7, int i8) {
            if (i8 > 0) {
                s();
            }
            a aVar = this.f278o;
            if (aVar != null) {
                aVar.u(i7, i8);
            } else {
                this.f279p.A(i7, i8);
            }
            this.f277n -= i8;
        }

        public final int v(int i7, int i8, Collection collection, boolean z7) {
            a aVar = this.f278o;
            int iV = aVar != null ? aVar.v(i7, i8, collection, z7) : this.f279p.B(i7, i8, collection, z7);
            if (iV > 0) {
                s();
            }
            this.f277n -= iV;
            return iV;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i7) {
            o();
            AbstractC1872c.f24186l.c(i7, this.f277n);
            return new C0004a(this, i7);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i7, Object obj) {
            p();
            o();
            AbstractC1872c.f24186l.c(i7, this.f277n);
            n(this.f276m + i7, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i7, Collection collection) {
            m.e(collection, "elements");
            p();
            o();
            AbstractC1872c.f24186l.c(i7, this.f277n);
            int size = collection.size();
            m(this.f276m + i7, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            o();
            Object[] objArr = this.f275l;
            int i7 = this.f276m;
            return C1880k.n(objArr, i7, this.f277n + i7);
        }
    }

    /* renamed from: A5.b$b, reason: collision with other inner class name */
    public static final class C0005b {
        public /* synthetic */ C0005b(M5.g gVar) {
            this();
        }

        public C0005b() {
        }
    }

    public static final class c implements ListIterator, N5.a {

        /* renamed from: l, reason: collision with root package name */
        public final b f284l;

        /* renamed from: m, reason: collision with root package name */
        public int f285m;

        /* renamed from: n, reason: collision with root package name */
        public int f286n;

        /* renamed from: o, reason: collision with root package name */
        public int f287o;

        public c(b bVar, int i7) {
            m.e(bVar, "list");
            this.f284l = bVar;
            this.f285m = i7;
            this.f286n = -1;
            this.f287o = ((AbstractList) bVar).modCount;
        }

        private final void a() {
            if (((AbstractList) this.f284l).modCount != this.f287o) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            a();
            b bVar = this.f284l;
            int i7 = this.f285m;
            this.f285m = i7 + 1;
            bVar.add(i7, obj);
            this.f286n = -1;
            this.f287o = ((AbstractList) this.f284l).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f285m < this.f284l.f273m;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f285m > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            a();
            if (this.f285m >= this.f284l.f273m) {
                throw new NoSuchElementException();
            }
            int i7 = this.f285m;
            this.f285m = i7 + 1;
            this.f286n = i7;
            return this.f284l.f272l[this.f286n];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f285m;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            a();
            int i7 = this.f285m;
            if (i7 <= 0) {
                throw new NoSuchElementException();
            }
            int i8 = i7 - 1;
            this.f285m = i8;
            this.f286n = i8;
            return this.f284l.f272l[this.f286n];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f285m - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i7 = this.f286n;
            if (i7 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.f284l.g(i7);
            this.f285m = this.f286n;
            this.f286n = -1;
            this.f287o = ((AbstractList) this.f284l).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            a();
            int i7 = this.f286n;
            if (i7 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f284l.set(i7, obj);
        }
    }

    static {
        b bVar = new b(0);
        bVar.f274n = true;
        f271p = bVar;
    }

    public b() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int i7, int i8) {
        if (i8 > 0) {
            y();
        }
        Object[] objArr = this.f272l;
        C1880k.h(objArr, objArr, i7, i7 + i8, this.f273m);
        Object[] objArr2 = this.f272l;
        int i9 = this.f273m;
        A5.c.g(objArr2, i9 - i8, i9);
        this.f273m -= i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int B(int i7, int i8, Collection collection, boolean z7) {
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = i7 + i9;
            if (collection.contains(this.f272l[i11]) == z7) {
                Object[] objArr = this.f272l;
                i9++;
                objArr[i10 + i7] = objArr[i11];
                i10++;
            } else {
                i9++;
            }
        }
        int i12 = i8 - i10;
        Object[] objArr2 = this.f272l;
        C1880k.h(objArr2, objArr2, i7 + i10, i8 + i7, this.f273m);
        Object[] objArr3 = this.f272l;
        int i13 = this.f273m;
        A5.c.g(objArr3, i13 - i12, i13);
        if (i12 > 0) {
            y();
        }
        this.f273m -= i12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int i7, Collection collection, int i8) {
        y();
        x(i7, i8);
        Iterator it = collection.iterator();
        for (int i9 = 0; i9 < i8; i9++) {
            this.f272l[i7 + i9] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(int i7, Object obj) {
        y();
        x(i7, 1);
        this.f272l[i7] = obj;
    }

    private final void t() {
        if (this.f274n) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean u(List list) {
        return A5.c.h(this.f272l, 0, this.f273m, list);
    }

    private final void y() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z(int i7) {
        y();
        Object[] objArr = this.f272l;
        Object obj = objArr[i7];
        C1880k.h(objArr, objArr, i7, i7 + 1, this.f273m);
        A5.c.f(this.f272l, this.f273m - 1);
        this.f273m--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        t();
        r(this.f273m, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        t();
        int size = collection.size();
        q(this.f273m, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        t();
        A(0, this.f273m);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof List) && u((List) obj);
        }
        return true;
    }

    @Override // z5.AbstractC1874e
    public int f() {
        return this.f273m;
    }

    @Override // z5.AbstractC1874e
    public Object g(int i7) {
        t();
        AbstractC1872c.f24186l.b(i7, this.f273m);
        return z(i7);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i7) {
        AbstractC1872c.f24186l.b(i7, this.f273m);
        return this.f272l[i7];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return A5.c.i(this.f272l, 0, this.f273m);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i7 = 0; i7 < this.f273m; i7++) {
            if (m.a(this.f272l[i7], obj)) {
                return i7;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f273m == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i7 = this.f273m - 1; i7 >= 0; i7--) {
            if (m.a(this.f272l[i7], obj)) {
                return i7;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        t();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            g(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        t();
        return B(0, this.f273m, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        t();
        return B(0, this.f273m, collection, true) > 0;
    }

    public final List s() {
        t();
        this.f274n = true;
        return this.f273m > 0 ? this : f271p;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i7, Object obj) {
        t();
        AbstractC1872c.f24186l.b(i7, this.f273m);
        Object[] objArr = this.f272l;
        Object obj2 = objArr[i7];
        objArr[i7] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List subList(int i7, int i8) {
        AbstractC1872c.f24186l.d(i7, i8, this.f273m);
        return new a(this.f272l, i7, i8 - i7, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        m.e(objArr, "array");
        int length = objArr.length;
        int i7 = this.f273m;
        if (length >= i7) {
            C1880k.h(this.f272l, objArr, 0, 0, i7);
            return C1883n.e(this.f273m, objArr);
        }
        Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f272l, 0, i7, objArr.getClass());
        m.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return A5.c.j(this.f272l, 0, this.f273m, this);
    }

    public final void v(int i7) {
        if (i7 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f272l;
        if (i7 > objArr.length) {
            this.f272l = A5.c.e(this.f272l, AbstractC1872c.f24186l.e(objArr.length, i7));
        }
    }

    public final void w(int i7) {
        v(this.f273m + i7);
    }

    public final void x(int i7, int i8) {
        w(i8);
        Object[] objArr = this.f272l;
        C1880k.h(objArr, objArr, i7 + i8, i7, this.f273m);
        this.f273m += i8;
    }

    public b(int i7) {
        this.f272l = A5.c.d(i7);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i7) {
        AbstractC1872c.f24186l.c(i7, this.f273m);
        return new c(this, i7);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i7, Object obj) {
        t();
        AbstractC1872c.f24186l.c(i7, this.f273m);
        r(i7, obj);
    }

    public /* synthetic */ b(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 10 : i7);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i7, Collection collection) {
        m.e(collection, "elements");
        t();
        AbstractC1872c.f24186l.c(i7, this.f273m);
        int size = collection.size();
        q(i7, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return C1880k.n(this.f272l, 0, this.f273m);
    }
}
