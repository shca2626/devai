package z5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* renamed from: z5.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1872c extends AbstractC1871b implements List, N5.a {

    /* renamed from: l, reason: collision with root package name */
    public static final a f24186l = new a(null);

    /* renamed from: z5.c$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(int i7, int i8, int i9) {
            if (i7 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("startIndex: " + i7 + ", endIndex: " + i8 + ", size: " + i9);
            }
            if (i7 <= i8) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i7 + " > endIndex: " + i8);
        }

        public final void b(int i7, int i8) {
            if (i7 < 0 || i7 >= i8) {
                throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
            }
        }

        public final void c(int i7, int i8) {
            if (i7 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
            }
        }

        public final void d(int i7, int i8, int i9) {
            if (i7 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("fromIndex: " + i7 + ", toIndex: " + i8 + ", size: " + i9);
            }
            if (i7 <= i8) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i7 + " > toIndex: " + i8);
        }

        public final int e(int i7, int i8) {
            int i9 = i7 + (i7 >> 1);
            if (i9 - i8 < 0) {
                i9 = i8;
            }
            return i9 - 2147483639 > 0 ? i8 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i9;
        }

        public final boolean f(Collection collection, Collection collection2) {
            M5.m.e(collection, "c");
            M5.m.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!M5.m.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection collection) {
            M5.m.e(collection, "c");
            Iterator it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public a() {
        }
    }

    /* renamed from: z5.c$b */
    public class b implements Iterator, N5.a {

        /* renamed from: l, reason: collision with root package name */
        public int f24187l;

        public b() {
        }

        public final int a() {
            return this.f24187l;
        }

        public final void b(int i7) {
            this.f24187l = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24187l < AbstractC1872c.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC1872c abstractC1872c = AbstractC1872c.this;
            int i7 = this.f24187l;
            this.f24187l = i7 + 1;
            return abstractC1872c.get(i7);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: z5.c$c, reason: collision with other inner class name */
    public class C0298c extends b implements ListIterator, N5.a {
        public C0298c(int i7) {
            super();
            AbstractC1872c.f24186l.c(i7, AbstractC1872c.this.size());
            b(i7);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC1872c abstractC1872c = AbstractC1872c.this;
            b(a() - 1);
            return abstractC1872c.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: z5.c$d */
    public static final class d extends AbstractC1872c implements RandomAccess {

        /* renamed from: m, reason: collision with root package name */
        public final AbstractC1872c f24190m;

        /* renamed from: n, reason: collision with root package name */
        public final int f24191n;

        /* renamed from: o, reason: collision with root package name */
        public int f24192o;

        public d(AbstractC1872c abstractC1872c, int i7, int i8) {
            M5.m.e(abstractC1872c, "list");
            this.f24190m = abstractC1872c;
            this.f24191n = i7;
            AbstractC1872c.f24186l.d(i7, i8, abstractC1872c.size());
            this.f24192o = i8 - i7;
        }

        @Override // z5.AbstractC1871b
        public int g() {
            return this.f24192o;
        }

        @Override // z5.AbstractC1872c, java.util.List
        public Object get(int i7) {
            AbstractC1872c.f24186l.b(i7, this.f24192o);
            return this.f24190m.get(this.f24191n + i7);
        }

        @Override // z5.AbstractC1872c, java.util.List
        public List subList(int i7, int i8) {
            AbstractC1872c.f24186l.d(i7, i8, this.f24192o);
            AbstractC1872c abstractC1872c = this.f24190m;
            int i9 = this.f24191n;
            return new d(abstractC1872c, i7 + i9, i9 + i8);
        }
    }

    @Override // java.util.List
    public void add(int i7, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f24186l.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i7);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f24186l.g(this);
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (M5.m.a(it.next(), obj)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (M5.m.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new C0298c(0);
    }

    @Override // java.util.List
    public Object remove(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i7, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i7, int i8) {
        return new d(this, i7, i8);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i7) {
        return new C0298c(i7);
    }
}
