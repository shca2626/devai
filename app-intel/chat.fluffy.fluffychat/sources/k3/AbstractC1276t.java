package k3;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* renamed from: k3.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1276t extends AbstractCollection implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final Object[] f19012l = new Object[0];

    /* renamed from: k3.t$a */
    public static abstract class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f19013a;

        /* renamed from: b, reason: collision with root package name */
        public int f19014b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19015c;

        public a(int i7) {
            AbstractC1266i.b(i7, "initialCapacity");
            this.f19013a = new Object[i7];
            this.f19014b = 0;
        }

        @Override // k3.AbstractC1276t.b
        public b b(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(collection.size());
                if (collection instanceof AbstractC1276t) {
                    this.f19014b = ((AbstractC1276t) collection).g(this.f19013a, this.f19014b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a d(Object obj) {
            j3.o.q(obj);
            g(1);
            Object[] objArr = this.f19013a;
            int i7 = this.f19014b;
            this.f19014b = i7 + 1;
            objArr[i7] = obj;
            return this;
        }

        public b e(Object... objArr) {
            f(objArr, objArr.length);
            return this;
        }

        public final void f(Object[] objArr, int i7) {
            S.c(objArr, i7);
            g(i7);
            System.arraycopy(objArr, 0, this.f19013a, this.f19014b, i7);
            this.f19014b += i7;
        }

        public final void g(int i7) {
            Object[] objArr = this.f19013a;
            int iC = b.c(objArr.length, this.f19014b + i7);
            if (iC > objArr.length || this.f19015c) {
                this.f19013a = Arrays.copyOf(this.f19013a, iC);
                this.f19015c = false;
            }
        }
    }

    /* renamed from: k3.t$b */
    public static abstract class b {
        public static int c(int i7, int i8) {
            if (i8 < 0) {
                throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
            }
            if (i8 <= i7) {
                return i7;
            }
            int iHighestOneBit = i7 + (i7 >> 1) + 1;
            if (iHighestOneBit < i8) {
                iHighestOneBit = Integer.highestOneBit(i8 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public abstract b a(Object obj);

        public b b(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public AbstractC1278v f() {
        return isEmpty() ? AbstractC1278v.v() : AbstractC1278v.m(toArray());
    }

    public int g(Object[] objArr, int i7) {
        h0 it = iterator();
        while (it.hasNext()) {
            objArr[i7] = it.next();
            i7++;
        }
        return i7;
    }

    public Object[] h() {
        return null;
    }

    public int i() {
        throw new UnsupportedOperationException();
    }

    public int j() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean k();

    /* renamed from: l */
    public abstract h0 iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f19012l);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        j3.o.q(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrH = h();
            if (objArrH != null) {
                return V.a(objArrH, j(), i(), objArr);
            }
            objArr = S.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        g(objArr, 0);
        return objArr;
    }
}
