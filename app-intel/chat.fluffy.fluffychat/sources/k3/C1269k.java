package k3;

import j3.AbstractC1237k;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* renamed from: k3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1269k extends AbstractMap implements Serializable {

    /* renamed from: u, reason: collision with root package name */
    public static final Object f18983u = new Object();

    /* renamed from: l, reason: collision with root package name */
    public transient Object f18984l;

    /* renamed from: m, reason: collision with root package name */
    public transient int[] f18985m;

    /* renamed from: n, reason: collision with root package name */
    public transient Object[] f18986n;

    /* renamed from: o, reason: collision with root package name */
    public transient Object[] f18987o;

    /* renamed from: p, reason: collision with root package name */
    public transient int f18988p;

    /* renamed from: q, reason: collision with root package name */
    public transient int f18989q;

    /* renamed from: r, reason: collision with root package name */
    public transient Set f18990r;

    /* renamed from: s, reason: collision with root package name */
    public transient Set f18991s;

    /* renamed from: t, reason: collision with root package name */
    public transient Collection f18992t;

    /* renamed from: k3.k$a */
    public class a extends e {
        public a() {
            super(C1269k.this, null);
        }

        @Override // k3.C1269k.e
        public Object b(int i7) {
            return C1269k.this.H(i7);
        }
    }

    /* renamed from: k3.k$b */
    public class b extends e {
        public b() {
            super(C1269k.this, null);
        }

        @Override // k3.C1269k.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry b(int i7) {
            return C1269k.this.new g(i7);
        }
    }

    /* renamed from: k3.k$c */
    public class c extends e {
        public c() {
            super(C1269k.this, null);
        }

        @Override // k3.C1269k.e
        public Object b(int i7) {
            return C1269k.this.X(i7);
        }
    }

    /* renamed from: k3.k$d */
    public class d extends AbstractSet {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1269k.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map mapX = C1269k.this.x();
            if (mapX != null) {
                return mapX.entrySet().contains(obj);
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int iE = C1269k.this.E(entry.getKey());
                if (iE != -1 && AbstractC1237k.a(C1269k.this.X(iE), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C1269k.this.z();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iC;
            int iF;
            Map mapX = C1269k.this.x();
            if (mapX != null) {
                return mapX.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (C1269k.this.K() || (iF = AbstractC1270l.f(entry.getKey(), entry.getValue(), (iC = C1269k.this.C()), C1269k.this.O(), C1269k.this.M(), C1269k.this.N(), C1269k.this.P())) == -1) {
                return false;
            }
            C1269k.this.J(iF, iC);
            C1269k.e(C1269k.this);
            C1269k.this.D();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1269k.this.size();
        }
    }

    /* renamed from: k3.k$f */
    public class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1269k.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C1269k.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C1269k.this.I();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map mapX = C1269k.this.x();
            return mapX != null ? mapX.keySet().remove(obj) : C1269k.this.L(obj) != C1269k.f18983u;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1269k.this.size();
        }
    }

    /* renamed from: k3.k$g */
    public final class g extends AbstractC1263e {

        /* renamed from: l, reason: collision with root package name */
        public final Object f19002l;

        /* renamed from: m, reason: collision with root package name */
        public int f19003m;

        public g(int i7) {
            this.f19002l = C1269k.this.H(i7);
            this.f19003m = i7;
        }

        public final void a() {
            int i7 = this.f19003m;
            if (i7 == -1 || i7 >= C1269k.this.size() || !AbstractC1237k.a(this.f19002l, C1269k.this.H(this.f19003m))) {
                this.f19003m = C1269k.this.E(this.f19002l);
            }
        }

        @Override // k3.AbstractC1263e, java.util.Map.Entry
        public Object getKey() {
            return this.f19002l;
        }

        @Override // k3.AbstractC1263e, java.util.Map.Entry
        public Object getValue() {
            Map mapX = C1269k.this.x();
            if (mapX != null) {
                return Q.a(mapX.get(this.f19002l));
            }
            a();
            int i7 = this.f19003m;
            return i7 == -1 ? Q.b() : C1269k.this.X(i7);
        }

        @Override // k3.AbstractC1263e, java.util.Map.Entry
        public Object setValue(Object obj) {
            Map mapX = C1269k.this.x();
            if (mapX != null) {
                return Q.a(mapX.put(this.f19002l, obj));
            }
            a();
            int i7 = this.f19003m;
            if (i7 == -1) {
                C1269k.this.put(this.f19002l, obj);
                return Q.b();
            }
            Object objX = C1269k.this.X(i7);
            C1269k.this.W(this.f19003m, obj);
            return objX;
        }
    }

    /* renamed from: k3.k$h */
    public class h extends AbstractCollection {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            C1269k.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return C1269k.this.Y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return C1269k.this.size();
        }
    }

    public C1269k() {
        F(3);
    }

    public static /* synthetic */ int e(C1269k c1269k) {
        int i7 = c1269k.f18989q;
        c1269k.f18989q = i7 - 1;
        return i7;
    }

    public static C1269k r() {
        return new C1269k();
    }

    public static C1269k w(int i7) {
        return new C1269k(i7);
    }

    public int A() {
        return isEmpty() ? -1 : 0;
    }

    public int B(int i7) {
        int i8 = i7 + 1;
        if (i8 < this.f18989q) {
            return i8;
        }
        return -1;
    }

    public final int C() {
        return (1 << (this.f18988p & 31)) - 1;
    }

    public void D() {
        this.f18988p += 32;
    }

    public final int E(Object obj) {
        if (K()) {
            return -1;
        }
        int iC = AbstractC1276s.c(obj);
        int iC2 = C();
        int iH = AbstractC1270l.h(O(), iC & iC2);
        if (iH == 0) {
            return -1;
        }
        int iB = AbstractC1270l.b(iC, iC2);
        do {
            int i7 = iH - 1;
            int iY = y(i7);
            if (AbstractC1270l.b(iY, iC2) == iB && AbstractC1237k.a(obj, H(i7))) {
                return i7;
            }
            iH = AbstractC1270l.c(iY, iC2);
        } while (iH != 0);
        return -1;
    }

    public void F(int i7) {
        j3.o.e(i7 >= 0, "Expected size must be >= 0");
        this.f18988p = o3.g.g(i7, 1, 1073741823);
    }

    public void G(int i7, Object obj, Object obj2, int i8, int i9) {
        T(i7, AbstractC1270l.d(i8, 0, i9));
        V(i7, obj);
        W(i7, obj2);
    }

    public final Object H(int i7) {
        return N()[i7];
    }

    public Iterator I() {
        Map mapX = x();
        return mapX != null ? mapX.keySet().iterator() : new a();
    }

    public void J(int i7, int i8) {
        Object objO = O();
        int[] iArrM = M();
        Object[] objArrN = N();
        Object[] objArrP = P();
        int size = size();
        int i9 = size - 1;
        if (i7 >= i9) {
            objArrN[i7] = null;
            objArrP[i7] = null;
            iArrM[i7] = 0;
            return;
        }
        Object obj = objArrN[i9];
        objArrN[i7] = obj;
        objArrP[i7] = objArrP[i9];
        objArrN[i9] = null;
        objArrP[i9] = null;
        iArrM[i7] = iArrM[i9];
        iArrM[i9] = 0;
        int iC = AbstractC1276s.c(obj) & i8;
        int iH = AbstractC1270l.h(objO, iC);
        if (iH == size) {
            AbstractC1270l.i(objO, iC, i7 + 1);
            return;
        }
        while (true) {
            int i10 = iH - 1;
            int i11 = iArrM[i10];
            int iC2 = AbstractC1270l.c(i11, i8);
            if (iC2 == size) {
                iArrM[i10] = AbstractC1270l.d(i11, i7 + 1, i8);
                return;
            }
            iH = iC2;
        }
    }

    public boolean K() {
        return this.f18984l == null;
    }

    public final Object L(Object obj) {
        if (K()) {
            return f18983u;
        }
        int iC = C();
        int iF = AbstractC1270l.f(obj, null, iC, O(), M(), N(), null);
        if (iF == -1) {
            return f18983u;
        }
        Object objX = X(iF);
        J(iF, iC);
        this.f18989q--;
        D();
        return objX;
    }

    public final int[] M() {
        int[] iArr = this.f18985m;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] N() {
        Object[] objArr = this.f18986n;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object O() {
        Object obj = this.f18984l;
        Objects.requireNonNull(obj);
        return obj;
    }

    public final Object[] P() {
        Object[] objArr = this.f18987o;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public void Q(int i7) {
        this.f18985m = Arrays.copyOf(M(), i7);
        this.f18986n = Arrays.copyOf(N(), i7);
        this.f18987o = Arrays.copyOf(P(), i7);
    }

    public final void R(int i7) {
        int iMin;
        int length = M().length;
        if (i7 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        Q(iMin);
    }

    public final int S(int i7, int i8, int i9, int i10) {
        Object objA = AbstractC1270l.a(i8);
        int i11 = i8 - 1;
        if (i10 != 0) {
            AbstractC1270l.i(objA, i9 & i11, i10 + 1);
        }
        Object objO = O();
        int[] iArrM = M();
        for (int i12 = 0; i12 <= i7; i12++) {
            int iH = AbstractC1270l.h(objO, i12);
            while (iH != 0) {
                int i13 = iH - 1;
                int i14 = iArrM[i13];
                int iB = AbstractC1270l.b(i14, i7) | i12;
                int i15 = iB & i11;
                int iH2 = AbstractC1270l.h(objA, i15);
                AbstractC1270l.i(objA, i15, iH);
                iArrM[i13] = AbstractC1270l.d(iB, iH2, i11);
                iH = AbstractC1270l.c(i14, i7);
            }
        }
        this.f18984l = objA;
        U(i11);
        return i11;
    }

    public final void T(int i7, int i8) {
        M()[i7] = i8;
    }

    public final void U(int i7) {
        this.f18988p = AbstractC1270l.d(this.f18988p, 32 - Integer.numberOfLeadingZeros(i7), 31);
    }

    public final void V(int i7, Object obj) {
        N()[i7] = obj;
    }

    public final void W(int i7, Object obj) {
        P()[i7] = obj;
    }

    public final Object X(int i7) {
        return P()[i7];
    }

    public Iterator Y() {
        Map mapX = x();
        return mapX != null ? mapX.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (K()) {
            return;
        }
        D();
        Map mapX = x();
        if (mapX != null) {
            this.f18988p = o3.g.g(size(), 3, 1073741823);
            mapX.clear();
            this.f18984l = null;
            this.f18989q = 0;
            return;
        }
        Arrays.fill(N(), 0, this.f18989q, (Object) null);
        Arrays.fill(P(), 0, this.f18989q, (Object) null);
        AbstractC1270l.g(O());
        Arrays.fill(M(), 0, this.f18989q, 0);
        this.f18989q = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map mapX = x();
        return mapX != null ? mapX.containsKey(obj) : E(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map mapX = x();
        if (mapX != null) {
            return mapX.containsValue(obj);
        }
        for (int i7 = 0; i7 < this.f18989q; i7++) {
            if (AbstractC1237k.a(obj, X(i7))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f18991s;
        if (set != null) {
            return set;
        }
        Set setS = s();
        this.f18991s = setS;
        return setS;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Map mapX = x();
        if (mapX != null) {
            return mapX.get(obj);
        }
        int iE = E(obj);
        if (iE == -1) {
            return null;
        }
        n(iE);
        return X(iE);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f18990r;
        if (set != null) {
            return set;
        }
        Set setU = u();
        this.f18990r = setU;
        return setU;
    }

    public int o(int i7, int i8) {
        return i7 - 1;
    }

    public int p() {
        j3.o.w(K(), "Arrays already allocated");
        int i7 = this.f18988p;
        int iJ = AbstractC1270l.j(i7);
        this.f18984l = AbstractC1270l.a(iJ);
        U(iJ - 1);
        this.f18985m = new int[i7];
        this.f18986n = new Object[i7];
        this.f18987o = new Object[i7];
        return i7;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (K()) {
            p();
        }
        Map mapX = x();
        if (mapX != null) {
            return mapX.put(obj, obj2);
        }
        int[] iArrM = M();
        Object[] objArrN = N();
        Object[] objArrP = P();
        int i7 = this.f18989q;
        int i8 = i7 + 1;
        int iC = AbstractC1276s.c(obj);
        int iC2 = C();
        int i9 = iC & iC2;
        int iH = AbstractC1270l.h(O(), i9);
        if (iH != 0) {
            int iB = AbstractC1270l.b(iC, iC2);
            int i10 = 0;
            while (true) {
                int i11 = iH - 1;
                int i12 = iArrM[i11];
                if (AbstractC1270l.b(i12, iC2) == iB && AbstractC1237k.a(obj, objArrN[i11])) {
                    Object obj3 = objArrP[i11];
                    objArrP[i11] = obj2;
                    n(i11);
                    return obj3;
                }
                int iC3 = AbstractC1270l.c(i12, iC2);
                i10++;
                if (iC3 != 0) {
                    obj = obj;
                    obj2 = obj2;
                    iH = iC3;
                } else {
                    if (i10 >= 9) {
                        return q().put(obj, obj2);
                    }
                    if (i8 > iC2) {
                        iC2 = S(iC2, AbstractC1270l.e(iC2), iC, i7);
                    } else {
                        iArrM[i11] = AbstractC1270l.d(i12, i8, iC2);
                    }
                }
            }
        } else if (i8 > iC2) {
            iC2 = S(iC2, AbstractC1270l.e(iC2), iC, i7);
        } else {
            AbstractC1270l.i(O(), i9, i8);
        }
        int i13 = iC2;
        R(i8);
        G(i7, obj, obj2, iC, i13);
        this.f18989q = i8;
        D();
        return null;
    }

    public Map q() {
        Map mapT = t(C() + 1);
        int iA = A();
        while (iA >= 0) {
            mapT.put(H(iA), X(iA));
            iA = B(iA);
        }
        this.f18984l = mapT;
        this.f18985m = null;
        this.f18986n = null;
        this.f18987o = null;
        D();
        return mapT;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Map mapX = x();
        if (mapX != null) {
            return mapX.remove(obj);
        }
        Object objL = L(obj);
        if (objL == f18983u) {
            return null;
        }
        return objL;
    }

    public Set s() {
        return new d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map mapX = x();
        return mapX != null ? mapX.size() : this.f18989q;
    }

    public Map t(int i7) {
        return new LinkedHashMap(i7, 1.0f);
    }

    public Set u() {
        return new f();
    }

    public Collection v() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f18992t;
        if (collection != null) {
            return collection;
        }
        Collection collectionV = v();
        this.f18992t = collectionV;
        return collectionV;
    }

    public Map x() {
        Object obj = this.f18984l;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int y(int i7) {
        return M()[i7];
    }

    public Iterator z() {
        Map mapX = x();
        return mapX != null ? mapX.entrySet().iterator() : new b();
    }

    public C1269k(int i7) {
        F(i7);
    }

    /* renamed from: k3.k$e */
    public abstract class e implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public int f18997l;

        /* renamed from: m, reason: collision with root package name */
        public int f18998m;

        /* renamed from: n, reason: collision with root package name */
        public int f18999n;

        public e() {
            this.f18997l = C1269k.this.f18988p;
            this.f18998m = C1269k.this.A();
            this.f18999n = -1;
        }

        public final void a() {
            if (C1269k.this.f18988p != this.f18997l) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract Object b(int i7);

        public void c() {
            this.f18997l += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18998m >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i7 = this.f18998m;
            this.f18999n = i7;
            Object objB = b(i7);
            this.f18998m = C1269k.this.B(this.f18998m);
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            AbstractC1267i.d(this.f18999n >= 0);
            c();
            C1269k c1269k = C1269k.this;
            c1269k.remove(c1269k.H(this.f18999n));
            this.f18998m = C1269k.this.o(this.f18998m, this.f18999n);
            this.f18999n = -1;
        }

        public /* synthetic */ e(C1269k c1269k, a aVar) {
            this();
        }
    }

    public void n(int i7) {
    }
}
