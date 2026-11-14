package A5;

import M5.m;
import N5.c;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import z5.AbstractC1872c;

/* loaded from: classes.dex */
public final class d implements Map, Serializable, N5.c {

    /* renamed from: y, reason: collision with root package name */
    public static final a f288y = new a(null);

    /* renamed from: z, reason: collision with root package name */
    public static final d f289z;

    /* renamed from: l, reason: collision with root package name */
    public Object[] f290l;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f291m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f292n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f293o;

    /* renamed from: p, reason: collision with root package name */
    public int f294p;

    /* renamed from: q, reason: collision with root package name */
    public int f295q;

    /* renamed from: r, reason: collision with root package name */
    public int f296r;

    /* renamed from: s, reason: collision with root package name */
    public int f297s;

    /* renamed from: t, reason: collision with root package name */
    public int f298t;

    /* renamed from: u, reason: collision with root package name */
    public A5.f f299u;

    /* renamed from: v, reason: collision with root package name */
    public g f300v;

    /* renamed from: w, reason: collision with root package name */
    public A5.e f301w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f302x;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final int c(int i7) {
            return Integer.highestOneBit(S5.e.b(i7, 1) * 3);
        }

        public final int d(int i7) {
            return Integer.numberOfLeadingZeros(i7) + 1;
        }

        public final d e() {
            return d.f289z;
        }

        public a() {
        }
    }

    public static final class b extends C0006d implements Iterator, N5.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            m.e(dVar, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public c next() {
            a();
            if (b() >= d().f295q) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            c cVar = new c(d(), c());
            e();
            return cVar;
        }

        public final void i(StringBuilder sb) {
            m.e(sb, "sb");
            if (b() >= d().f295q) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().f290l[c()];
            if (obj == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = d().f291m;
            m.b(objArr);
            Object obj2 = objArr[c()];
            if (obj2 == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int j() {
            if (b() >= d().f295q) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().f290l[c()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = d().f291m;
            m.b(objArr);
            Object obj2 = objArr[c()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    public static final class c implements Map.Entry, c.a {

        /* renamed from: l, reason: collision with root package name */
        public final d f303l;

        /* renamed from: m, reason: collision with root package name */
        public final int f304m;

        /* renamed from: n, reason: collision with root package name */
        public final int f305n;

        public c(d dVar, int i7) {
            m.e(dVar, "map");
            this.f303l = dVar;
            this.f304m = i7;
            this.f305n = dVar.f297s;
        }

        private final void a() {
            if (this.f303l.f297s != this.f305n) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return m.a(entry.getKey(), getKey()) && m.a(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            a();
            return this.f303l.f290l[this.f304m];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            a();
            Object[] objArr = this.f303l.f291m;
            m.b(objArr);
            return objArr[this.f304m];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            this.f303l.l();
            Object[] objArrJ = this.f303l.j();
            int i7 = this.f304m;
            Object obj2 = objArrJ[i7];
            objArrJ[i7] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* renamed from: A5.d$d, reason: collision with other inner class name */
    public static class C0006d {

        /* renamed from: l, reason: collision with root package name */
        public final d f306l;

        /* renamed from: m, reason: collision with root package name */
        public int f307m;

        /* renamed from: n, reason: collision with root package name */
        public int f308n;

        /* renamed from: o, reason: collision with root package name */
        public int f309o;

        public C0006d(d dVar) {
            m.e(dVar, "map");
            this.f306l = dVar;
            this.f308n = -1;
            this.f309o = dVar.f297s;
            e();
        }

        public final void a() {
            if (this.f306l.f297s != this.f309o) {
                throw new ConcurrentModificationException();
            }
        }

        public final int b() {
            return this.f307m;
        }

        public final int c() {
            return this.f308n;
        }

        public final d d() {
            return this.f306l;
        }

        public final void e() {
            while (this.f307m < this.f306l.f295q) {
                int[] iArr = this.f306l.f292n;
                int i7 = this.f307m;
                if (iArr[i7] >= 0) {
                    return;
                } else {
                    this.f307m = i7 + 1;
                }
            }
        }

        public final void f(int i7) {
            this.f307m = i7;
        }

        public final void g(int i7) {
            this.f308n = i7;
        }

        public final boolean hasNext() {
            return this.f307m < this.f306l.f295q;
        }

        public final void remove() {
            a();
            if (this.f308n == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.f306l.l();
            this.f306l.J(this.f308n);
            this.f308n = -1;
            this.f309o = this.f306l.f297s;
        }
    }

    public static final class e extends C0006d implements Iterator, N5.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(dVar);
            m.e(dVar, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().f295q) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().f290l[c()];
            e();
            return obj;
        }
    }

    public static final class f extends C0006d implements Iterator, N5.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(dVar);
            m.e(dVar, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().f295q) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object[] objArr = d().f291m;
            m.b(objArr);
            Object obj = objArr[c()];
            e();
            return obj;
        }
    }

    static {
        d dVar = new d(0);
        dVar.f302x = true;
        f289z = dVar;
    }

    public d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i7, int i8) {
        this.f290l = objArr;
        this.f291m = objArr2;
        this.f292n = iArr;
        this.f293o = iArr2;
        this.f294p = i7;
        this.f295q = i8;
        this.f296r = f288y.d(x());
    }

    private final void G() {
        this.f297s++;
    }

    private final void q(int i7) {
        if (i7 < 0) {
            throw new OutOfMemoryError();
        }
        if (i7 > v()) {
            int iE = AbstractC1872c.f24186l.e(v(), i7);
            this.f290l = A5.c.e(this.f290l, iE);
            Object[] objArr = this.f291m;
            this.f291m = objArr != null ? A5.c.e(objArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.f292n, iE);
            m.d(iArrCopyOf, "copyOf(...)");
            this.f292n = iArrCopyOf;
            int iC = f288y.c(iE);
            if (iC > x()) {
                H(iC);
            }
        }
    }

    private final void r(int i7) {
        if (N(i7)) {
            m(true);
        } else {
            q(this.f295q + i7);
        }
    }

    public Collection A() {
        g gVar = this.f300v;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f300v = gVar2;
        return gVar2;
    }

    public final int B(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f296r;
    }

    public final e C() {
        return new e(this);
    }

    public final boolean D(Collection collection) {
        boolean z7 = false;
        if (collection.isEmpty()) {
            return false;
        }
        r(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (E((Map.Entry) it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public final boolean E(Map.Entry entry) {
        int i7 = i(entry.getKey());
        Object[] objArrJ = j();
        if (i7 >= 0) {
            objArrJ[i7] = entry.getValue();
            return true;
        }
        int i8 = (-i7) - 1;
        if (m.a(entry.getValue(), objArrJ[i8])) {
            return false;
        }
        objArrJ[i8] = entry.getValue();
        return true;
    }

    public final boolean F(int i7) {
        int iB = B(this.f290l[i7]);
        int i8 = this.f294p;
        while (true) {
            int[] iArr = this.f293o;
            if (iArr[iB] == 0) {
                iArr[iB] = i7 + 1;
                this.f292n[i7] = iB;
                return true;
            }
            i8--;
            if (i8 < 0) {
                return false;
            }
            iB = iB == 0 ? x() - 1 : iB - 1;
        }
    }

    public final void H(int i7) {
        G();
        int i8 = 0;
        if (this.f295q > size()) {
            m(false);
        }
        this.f293o = new int[i7];
        this.f296r = f288y.d(i7);
        while (i8 < this.f295q) {
            int i9 = i8 + 1;
            if (!F(i8)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i8 = i9;
        }
    }

    public final boolean I(Map.Entry entry) {
        m.e(entry, "entry");
        l();
        int iT = t(entry.getKey());
        if (iT < 0) {
            return false;
        }
        Object[] objArr = this.f291m;
        m.b(objArr);
        if (!m.a(objArr[iT], entry.getValue())) {
            return false;
        }
        J(iT);
        return true;
    }

    public final void J(int i7) {
        A5.c.f(this.f290l, i7);
        Object[] objArr = this.f291m;
        if (objArr != null) {
            A5.c.f(objArr, i7);
        }
        K(this.f292n[i7]);
        this.f292n[i7] = -1;
        this.f298t = size() - 1;
        G();
    }

    public final void K(int i7) {
        int iF = S5.e.f(this.f294p * 2, x() / 2);
        int i8 = 0;
        int i9 = i7;
        do {
            i7 = i7 == 0 ? x() - 1 : i7 - 1;
            i8++;
            if (i8 > this.f294p) {
                this.f293o[i9] = 0;
                return;
            }
            int[] iArr = this.f293o;
            int i10 = iArr[i7];
            if (i10 == 0) {
                iArr[i9] = 0;
                return;
            }
            if (i10 < 0) {
                iArr[i9] = -1;
            } else {
                int i11 = i10 - 1;
                if (((B(this.f290l[i11]) - i7) & (x() - 1)) >= i8) {
                    this.f293o[i9] = i10;
                    this.f292n[i11] = i9;
                }
                iF--;
            }
            i9 = i7;
            i8 = 0;
            iF--;
        } while (iF >= 0);
        this.f293o[i9] = -1;
    }

    public final boolean L(Object obj) {
        l();
        int iT = t(obj);
        if (iT < 0) {
            return false;
        }
        J(iT);
        return true;
    }

    public final boolean M(Object obj) {
        l();
        int iU = u(obj);
        if (iU < 0) {
            return false;
        }
        J(iU);
        return true;
    }

    public final boolean N(int i7) {
        int iV = v();
        int i8 = this.f295q;
        int i9 = iV - i8;
        int size = i8 - size();
        return i9 < i7 && i9 + size >= i7 && size >= v() / 4;
    }

    public final f O() {
        return new f(this);
    }

    @Override // java.util.Map
    public void clear() {
        l();
        int i7 = this.f295q - 1;
        if (i7 >= 0) {
            int i8 = 0;
            while (true) {
                int[] iArr = this.f292n;
                int i9 = iArr[i8];
                if (i9 >= 0) {
                    this.f293o[i9] = 0;
                    iArr[i8] = -1;
                }
                if (i8 == i7) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        A5.c.g(this.f290l, 0, this.f295q);
        Object[] objArr = this.f291m;
        if (objArr != null) {
            A5.c.g(objArr, 0, this.f295q);
        }
        this.f298t = 0;
        this.f295q = 0;
        G();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return t(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return u(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return w();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Map) && p((Map) obj);
        }
        return true;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iT = t(obj);
        if (iT < 0) {
            return null;
        }
        Object[] objArr = this.f291m;
        m.b(objArr);
        return objArr[iT];
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarS = s();
        int iJ = 0;
        while (bVarS.hasNext()) {
            iJ += bVarS.j();
        }
        return iJ;
    }

    public final int i(Object obj) {
        l();
        while (true) {
            int iB = B(obj);
            int iF = S5.e.f(this.f294p * 2, x() / 2);
            int i7 = 0;
            while (true) {
                int i8 = this.f293o[iB];
                if (i8 <= 0) {
                    if (this.f295q < v()) {
                        int i9 = this.f295q;
                        int i10 = i9 + 1;
                        this.f295q = i10;
                        this.f290l[i9] = obj;
                        this.f292n[i9] = iB;
                        this.f293o[iB] = i10;
                        this.f298t = size() + 1;
                        G();
                        if (i7 > this.f294p) {
                            this.f294p = i7;
                        }
                        return i9;
                    }
                    r(1);
                } else {
                    if (m.a(this.f290l[i8 - 1], obj)) {
                        return -i8;
                    }
                    i7++;
                    if (i7 > iF) {
                        H(x() * 2);
                        break;
                    }
                    iB = iB == 0 ? x() - 1 : iB - 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] j() {
        Object[] objArr = this.f291m;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrD = A5.c.d(v());
        this.f291m = objArrD;
        return objArrD;
    }

    public final Map k() {
        l();
        this.f302x = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f289z;
        m.c(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return y();
    }

    public final void l() {
        if (this.f302x) {
            throw new UnsupportedOperationException();
        }
    }

    public final void m(boolean z7) {
        int i7;
        Object[] objArr = this.f291m;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i7 = this.f295q;
            if (i8 >= i7) {
                break;
            }
            int[] iArr = this.f292n;
            int i10 = iArr[i8];
            if (i10 >= 0) {
                Object[] objArr2 = this.f290l;
                objArr2[i9] = objArr2[i8];
                if (objArr != null) {
                    objArr[i9] = objArr[i8];
                }
                if (z7) {
                    iArr[i9] = i10;
                    this.f293o[i10] = i9 + 1;
                }
                i9++;
            }
            i8++;
        }
        A5.c.g(this.f290l, i9, i7);
        if (objArr != null) {
            A5.c.g(objArr, i9, this.f295q);
        }
        this.f295q = i9;
    }

    public final boolean n(Collection collection) {
        m.e(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!o((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean o(Map.Entry entry) {
        m.e(entry, "entry");
        int iT = t(entry.getKey());
        if (iT < 0) {
            return false;
        }
        Object[] objArr = this.f291m;
        m.b(objArr);
        return m.a(objArr[iT], entry.getValue());
    }

    public final boolean p(Map map) {
        return size() == map.size() && n(map.entrySet());
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        l();
        int i7 = i(obj);
        Object[] objArrJ = j();
        if (i7 >= 0) {
            objArrJ[i7] = obj2;
            return null;
        }
        int i8 = (-i7) - 1;
        Object obj3 = objArrJ[i8];
        objArrJ[i8] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        m.e(map, "from");
        l();
        D(map.entrySet());
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        l();
        int iT = t(obj);
        if (iT < 0) {
            return null;
        }
        Object[] objArr = this.f291m;
        m.b(objArr);
        Object obj2 = objArr[iT];
        J(iT);
        return obj2;
    }

    public final b s() {
        return new b(this);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return z();
    }

    public final int t(Object obj) {
        int iB = B(obj);
        int i7 = this.f294p;
        while (true) {
            int i8 = this.f293o[iB];
            if (i8 == 0) {
                return -1;
            }
            if (i8 > 0) {
                int i9 = i8 - 1;
                if (m.a(this.f290l[i9], obj)) {
                    return i9;
                }
            }
            i7--;
            if (i7 < 0) {
                return -1;
            }
            iB = iB == 0 ? x() - 1 : iB - 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b bVarS = s();
        int i7 = 0;
        while (bVarS.hasNext()) {
            if (i7 > 0) {
                sb.append(", ");
            }
            bVarS.i(sb);
            i7++;
        }
        sb.append("}");
        String string = sb.toString();
        m.d(string, "toString(...)");
        return string;
    }

    public final int u(Object obj) {
        int i7 = this.f295q;
        while (true) {
            i7--;
            if (i7 < 0) {
                return -1;
            }
            if (this.f292n[i7] >= 0) {
                Object[] objArr = this.f291m;
                m.b(objArr);
                if (m.a(objArr[i7], obj)) {
                    return i7;
                }
            }
        }
    }

    public final int v() {
        return this.f290l.length;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return A();
    }

    public Set w() {
        A5.e eVar = this.f301w;
        if (eVar != null) {
            return eVar;
        }
        A5.e eVar2 = new A5.e(this);
        this.f301w = eVar2;
        return eVar2;
    }

    public final int x() {
        return this.f293o.length;
    }

    public Set y() {
        A5.f fVar = this.f299u;
        if (fVar != null) {
            return fVar;
        }
        A5.f fVar2 = new A5.f(this);
        this.f299u = fVar2;
        return fVar2;
    }

    public int z() {
        return this.f298t;
    }

    public d() {
        this(8);
    }

    public d(int i7) {
        this(A5.c.d(i7), null, new int[i7], new int[f288y.c(i7)], 2, 0);
    }
}
