package k3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import k3.AbstractC1277t;

/* renamed from: k3.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1279v extends AbstractC1277t implements List, RandomAccess {

    /* renamed from: m, reason: collision with root package name */
    public static final i0 f19019m = new b(W.f18890p, 0);

    /* renamed from: k3.v$a */
    public static final class a extends AbstractC1277t.a {
        public a() {
            this(4);
        }

        @Override // k3.AbstractC1277t.b
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            super.d(obj);
            return this;
        }

        public a i(Object... objArr) {
            super.e(objArr);
            return this;
        }

        public a j(Iterable iterable) {
            super.b(iterable);
            return this;
        }

        public AbstractC1279v k() {
            this.f19016c = true;
            return AbstractC1279v.n(this.f19014a, this.f19015b);
        }

        public AbstractC1279v l(Comparator comparator) {
            this.f19016c = true;
            Arrays.sort(this.f19014a, 0, this.f19015b, comparator);
            return AbstractC1279v.n(this.f19014a, this.f19015b);
        }

        public a(int i7) {
            super(i7);
        }
    }

    /* renamed from: k3.v$b */
    public static class b extends AbstractC1259a {

        /* renamed from: n, reason: collision with root package name */
        public final AbstractC1279v f19020n;

        public b(AbstractC1279v abstractC1279v, int i7) {
            super(abstractC1279v.size(), i7);
            this.f19020n = abstractC1279v;
        }

        @Override // k3.AbstractC1259a
        public Object a(int i7) {
            return this.f19020n.get(i7);
        }
    }

    /* renamed from: k3.v$c */
    public class c extends AbstractC1279v {

        /* renamed from: n, reason: collision with root package name */
        public final transient int f19021n;

        /* renamed from: o, reason: collision with root package name */
        public final transient int f19022o;

        public c(int i7, int i8) {
            this.f19021n = i7;
            this.f19022o = i8;
        }

        @Override // k3.AbstractC1279v, java.util.List
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public AbstractC1279v subList(int i7, int i8) {
            j3.o.u(i7, i8, this.f19022o);
            AbstractC1279v abstractC1279v = AbstractC1279v.this;
            int i9 = this.f19021n;
            return abstractC1279v.subList(i7 + i9, i8 + i9);
        }

        @Override // java.util.List
        public Object get(int i7) {
            j3.o.o(i7, this.f19022o);
            return AbstractC1279v.this.get(i7 + this.f19021n);
        }

        @Override // k3.AbstractC1277t
        public Object[] h() {
            return AbstractC1279v.this.h();
        }

        @Override // k3.AbstractC1277t
        public int i() {
            return AbstractC1279v.this.j() + this.f19021n + this.f19022o;
        }

        @Override // k3.AbstractC1279v, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // k3.AbstractC1277t
        public int j() {
            return AbstractC1279v.this.j() + this.f19021n;
        }

        @Override // k3.AbstractC1277t
        public boolean k() {
            return true;
        }

        @Override // k3.AbstractC1279v, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f19022o;
        }

        @Override // k3.AbstractC1279v, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i7) {
            return super.listIterator(i7);
        }
    }

    public static AbstractC1279v A(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return q(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static AbstractC1279v B(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        j3.o.e(objArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr2 = new Object[objArr.length + 12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, objArr.length);
        return q(objArr2);
    }

    public static AbstractC1279v C(Comparator comparator, Iterable iterable) {
        j3.o.q(comparator);
        Object[] objArrK = D.k(iterable);
        S.b(objArrK);
        Arrays.sort(objArrK, comparator);
        return m(objArrK);
    }

    public static AbstractC1279v m(Object[] objArr) {
        return n(objArr, objArr.length);
    }

    public static AbstractC1279v n(Object[] objArr, int i7) {
        return i7 == 0 ? v() : new W(objArr, i7);
    }

    public static a o() {
        return new a();
    }

    public static a p(int i7) {
        AbstractC1267i.b(i7, "expectedSize");
        return new a(i7);
    }

    public static AbstractC1279v q(Object... objArr) {
        return m(S.b(objArr));
    }

    public static AbstractC1279v r(Collection collection) {
        if (!(collection instanceof AbstractC1277t)) {
            return q(collection.toArray());
        }
        AbstractC1279v abstractC1279vF = ((AbstractC1277t) collection).f();
        return abstractC1279vF.k() ? m(abstractC1279vF.toArray()) : abstractC1279vF;
    }

    public static AbstractC1279v s(Object[] objArr) {
        return objArr.length == 0 ? v() : q((Object[]) objArr.clone());
    }

    public static AbstractC1279v v() {
        return W.f18890p;
    }

    public static AbstractC1279v w(Object obj) {
        return q(obj);
    }

    public static AbstractC1279v x(Object obj, Object obj2) {
        return q(obj, obj2);
    }

    public static AbstractC1279v y(Object obj, Object obj2, Object obj3) {
        return q(obj, obj2, obj3);
    }

    public static AbstractC1279v z(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return q(obj, obj2, obj3, obj4, obj5);
    }

    @Override // java.util.List
    /* renamed from: D */
    public AbstractC1279v subList(int i7, int i8) {
        j3.o.u(i7, i8, size());
        int i9 = i8 - i7;
        return i9 == size() ? this : i9 == 0 ? v() : E(i7, i8);
    }

    public AbstractC1279v E(int i7, int i8) {
        return new c(i7, i8 - i7);
    }

    @Override // java.util.List
    public final void add(int i7, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i7, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // k3.AbstractC1277t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return G.c(this, obj);
    }

    @Override // k3.AbstractC1277t
    public int g(Object[] objArr, int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i7 + i8] = get(i8);
        }
        return i7 + size;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i7 = 1;
        for (int i8 = 0; i8 < size; i8++) {
            i7 = ~(~((i7 * 31) + get(i8).hashCode()));
        }
        return i7;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return G.d(this, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public h0 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return G.f(this, obj);
    }

    @Override // java.util.List
    public final Object remove(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i7, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public i0 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public i0 listIterator(int i7) {
        j3.o.s(i7, size());
        return isEmpty() ? f19019m : new b(this, i7);
    }

    @Override // k3.AbstractC1277t
    public final AbstractC1279v f() {
        return this;
    }
}
