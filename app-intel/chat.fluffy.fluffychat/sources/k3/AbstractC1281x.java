package k3;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import k3.AbstractC1277t;

/* renamed from: k3.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1281x implements Map, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public static final Map.Entry[] f19024o = new Map.Entry[0];

    /* renamed from: l, reason: collision with root package name */
    public transient AbstractC1258B f19025l;

    /* renamed from: m, reason: collision with root package name */
    public transient AbstractC1258B f19026m;

    /* renamed from: n, reason: collision with root package name */
    public transient AbstractC1277t f19027n;

    /* renamed from: k3.x$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Comparator f19028a;

        /* renamed from: b, reason: collision with root package name */
        public Object[] f19029b;

        /* renamed from: c, reason: collision with root package name */
        public int f19030c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f19031d;

        /* renamed from: e, reason: collision with root package name */
        public C0217a f19032e;

        /* renamed from: k3.x$a$a, reason: collision with other inner class name */
        public static final class C0217a {

            /* renamed from: a, reason: collision with root package name */
            public final Object f19033a;

            /* renamed from: b, reason: collision with root package name */
            public final Object f19034b;

            /* renamed from: c, reason: collision with root package name */
            public final Object f19035c;

            public C0217a(Object obj, Object obj2, Object obj3) {
                this.f19033a = obj;
                this.f19034b = obj2;
                this.f19035c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f19033a + "=" + this.f19034b + " and " + this.f19033a + "=" + this.f19035c);
            }
        }

        public a() {
            this(4);
        }

        public static void k(Object[] objArr, int i7, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = i8 * 2;
                Object obj = objArr[i9];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i9 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i8] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i7, U.b(comparator).f(H.t()));
            for (int i10 = 0; i10 < i7; i10++) {
                int i11 = i10 * 2;
                objArr[i11] = entryArr[i10].getKey();
                objArr[i11 + 1] = entryArr[i10].getValue();
            }
        }

        public AbstractC1281x a() {
            return d();
        }

        public final AbstractC1281x b(boolean z7) {
            Object[] objArrF;
            C0217a c0217a;
            C0217a c0217a2;
            if (z7 && (c0217a2 = this.f19032e) != null) {
                throw c0217a2.a();
            }
            int length = this.f19030c;
            if (this.f19028a == null) {
                objArrF = this.f19029b;
            } else {
                if (this.f19031d) {
                    this.f19029b = Arrays.copyOf(this.f19029b, length * 2);
                }
                objArrF = this.f19029b;
                if (!z7) {
                    objArrF = f(objArrF, this.f19030c);
                    if (objArrF.length < this.f19029b.length) {
                        length = objArrF.length >>> 1;
                    }
                }
                k(objArrF, length, this.f19028a);
            }
            this.f19031d = true;
            X xO = X.o(length, objArrF, this);
            if (!z7 || (c0217a = this.f19032e) == null) {
                return xO;
            }
            throw c0217a.a();
        }

        public AbstractC1281x c() {
            return b(false);
        }

        public AbstractC1281x d() {
            return b(true);
        }

        public final void e(int i7) {
            int i8 = i7 * 2;
            Object[] objArr = this.f19029b;
            if (i8 > objArr.length) {
                this.f19029b = Arrays.copyOf(objArr, AbstractC1277t.b.c(objArr.length, i8));
                this.f19031d = false;
            }
        }

        public final Object[] f(Object[] objArr, int i7) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i8 = i7 - 1; i8 >= 0; i8--) {
                Object obj = objArr[i8 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i8);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i7 - bitSet.cardinality()) * 2];
            int i9 = 0;
            int i10 = 0;
            while (i9 < i7 * 2) {
                if (bitSet.get(i9 >>> 1)) {
                    i9 += 2;
                } else {
                    int i11 = i10 + 1;
                    int i12 = i9 + 1;
                    Object obj2 = objArr[i9];
                    Objects.requireNonNull(obj2);
                    objArr2[i10] = obj2;
                    i10 += 2;
                    i9 += 2;
                    Object obj3 = objArr[i12];
                    Objects.requireNonNull(obj3);
                    objArr2[i11] = obj3;
                }
            }
            return objArr2;
        }

        public a g(Object obj, Object obj2) {
            e(this.f19030c + 1);
            AbstractC1267i.a(obj, obj2);
            Object[] objArr = this.f19029b;
            int i7 = this.f19030c;
            objArr[i7 * 2] = obj;
            objArr[(i7 * 2) + 1] = obj2;
            this.f19030c = i7 + 1;
            return this;
        }

        public a h(Map.Entry entry) {
            return g(entry.getKey(), entry.getValue());
        }

        public a i(Iterable iterable) {
            if (iterable instanceof Collection) {
                e(this.f19030c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                h((Map.Entry) it.next());
            }
            return this;
        }

        public a j(Map map) {
            return i(map.entrySet());
        }

        public a(int i7) {
            this.f19029b = new Object[i7 * 2];
            this.f19030c = 0;
            this.f19031d = false;
        }
    }

    public static a a() {
        return new a();
    }

    public static AbstractC1281x b(Iterable iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.i(iterable);
        return aVar.a();
    }

    public static AbstractC1281x c(Map map) {
        if ((map instanceof AbstractC1281x) && !(map instanceof SortedMap)) {
            AbstractC1281x abstractC1281x = (AbstractC1281x) map;
            if (!abstractC1281x.h()) {
                return abstractC1281x;
            }
        }
        return b(map.entrySet());
    }

    public static AbstractC1281x j() {
        return X.f18893s;
    }

    public static AbstractC1281x k(Object obj, Object obj2) {
        AbstractC1267i.a(obj, obj2);
        return X.n(1, new Object[]{obj, obj2});
    }

    public static AbstractC1281x l(Object obj, Object obj2, Object obj3, Object obj4) {
        AbstractC1267i.a(obj, obj2);
        AbstractC1267i.a(obj3, obj4);
        return X.n(2, new Object[]{obj, obj2, obj3, obj4});
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract AbstractC1258B d();

    public abstract AbstractC1258B e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return H.g(this, obj);
    }

    public abstract AbstractC1277t f();

    @Override // java.util.Map
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC1258B entrySet() {
        AbstractC1258B abstractC1258B = this.f19025l;
        if (abstractC1258B != null) {
            return abstractC1258B;
        }
        AbstractC1258B abstractC1258BD = d();
        this.f19025l = abstractC1258BD;
        return abstractC1258BD;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public abstract boolean h();

    @Override // java.util.Map
    public int hashCode() {
        return d0.d(entrySet());
    }

    @Override // java.util.Map
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public AbstractC1258B keySet() {
        AbstractC1258B abstractC1258B = this.f19026m;
        if (abstractC1258B != null) {
            return abstractC1258B;
        }
        AbstractC1258B abstractC1258BE = e();
        this.f19026m = abstractC1258BE;
        return abstractC1258BE;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC1277t values() {
        AbstractC1277t abstractC1277t = this.f19027n;
        if (abstractC1277t != null) {
            return abstractC1277t;
        }
        AbstractC1277t abstractC1277tF = f();
        this.f19027n = abstractC1277tF;
        return abstractC1277tF;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return H.p(this);
    }
}
