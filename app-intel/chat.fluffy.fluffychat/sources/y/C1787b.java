package y;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import z.AbstractC1825a;
import z5.C1880k;
import z5.C1892w;

/* renamed from: y.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1787b implements Collection, Set, N5.b {

    /* renamed from: l, reason: collision with root package name */
    public int[] f23794l;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f23795m;

    /* renamed from: n, reason: collision with root package name */
    public int f23796n;

    /* renamed from: y.b$a */
    public final class a extends AbstractC1792g {
        public a() {
            super(C1787b.this.j());
        }

        @Override // y.AbstractC1792g
        public Object a(int i7) {
            return C1787b.this.o(i7);
        }

        @Override // y.AbstractC1792g
        public void b(int i7) {
            C1787b.this.k(i7);
        }
    }

    public C1787b() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i7;
        int iC;
        int iJ = j();
        if (obj == null) {
            iC = AbstractC1789d.d(this);
            i7 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i7 = iHashCode;
            iC = AbstractC1789d.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i8 = ~iC;
        if (iJ >= h().length) {
            int i9 = 8;
            if (iJ >= 8) {
                i9 = (iJ >> 1) + iJ;
            } else if (iJ < 4) {
                i9 = 4;
            }
            int[] iArrH = h();
            Object[] objArrG = g();
            AbstractC1789d.a(this, i9);
            if (iJ != j()) {
                throw new ConcurrentModificationException();
            }
            if (!(h().length == 0)) {
                C1880k.j(iArrH, h(), 0, 0, iArrH.length, 6, null);
                C1880k.k(objArrG, g(), 0, 0, objArrG.length, 6, null);
            }
        }
        if (i8 < iJ) {
            int i10 = i8 + 1;
            C1880k.f(h(), h(), i10, i8, iJ);
            C1880k.h(g(), g(), i10, i8, iJ);
        }
        if (iJ != j() || i8 >= h().length) {
            throw new ConcurrentModificationException();
        }
        h()[i8] = i7;
        g()[i8] = obj;
        n(j() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        M5.m.e(collection, "elements");
        f(j() + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (j() != 0) {
            m(AbstractC1825a.f24030a);
            l(AbstractC1825a.f24032c);
            n(0);
        }
        if (j() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        M5.m.e(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int iJ = j();
            for (int i7 = 0; i7 < iJ; i7++) {
                if (!((Set) obj).contains(o(i7))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final void f(int i7) {
        int iJ = j();
        if (h().length < i7) {
            int[] iArrH = h();
            Object[] objArrG = g();
            AbstractC1789d.a(this, i7);
            if (j() > 0) {
                C1880k.j(iArrH, h(), 0, 0, j(), 6, null);
                C1880k.k(objArrG, g(), 0, 0, j(), 6, null);
            }
        }
        if (j() != iJ) {
            throw new ConcurrentModificationException();
        }
    }

    public final Object[] g() {
        return this.f23795m;
    }

    public final int[] h() {
        return this.f23794l;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrH = h();
        int iJ = j();
        int i7 = 0;
        for (int i8 = 0; i8 < iJ; i8++) {
            i7 += iArrH[i8];
        }
        return i7;
    }

    public int i() {
        return this.f23796n;
    }

    public final int indexOf(Object obj) {
        return obj == null ? AbstractC1789d.d(this) : AbstractC1789d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return j() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public final int j() {
        return this.f23796n;
    }

    public final Object k(int i7) {
        int i8;
        Object[] objArr;
        int iJ = j();
        Object obj = g()[i7];
        if (iJ <= 1) {
            clear();
            return obj;
        }
        int i9 = iJ - 1;
        if (h().length <= 8 || j() >= h().length / 3) {
            if (i7 < i9) {
                int i10 = i7 + 1;
                C1880k.f(h(), h(), i7, i10, iJ);
                C1880k.h(g(), g(), i7, i10, iJ);
            }
            g()[i9] = null;
        } else {
            int iJ2 = j() > 8 ? j() + (j() >> 1) : 8;
            int[] iArrH = h();
            Object[] objArrG = g();
            AbstractC1789d.a(this, iJ2);
            if (i7 > 0) {
                C1880k.j(iArrH, h(), 0, 0, i7, 6, null);
                objArr = objArrG;
                C1880k.k(objArr, g(), 0, 0, i7, 6, null);
                i8 = i7;
            } else {
                i8 = i7;
                objArr = objArrG;
            }
            if (i8 < i9) {
                int i11 = i8 + 1;
                C1880k.f(iArrH, h(), i8, i11, iJ);
                C1880k.h(objArr, g(), i8, i11, iJ);
            }
        }
        if (iJ != j()) {
            throw new ConcurrentModificationException();
        }
        n(i9);
        return obj;
    }

    public final void l(Object[] objArr) {
        M5.m.e(objArr, "<set-?>");
        this.f23795m = objArr;
    }

    public final void m(int[] iArr) {
        M5.m.e(iArr, "<set-?>");
        this.f23794l = iArr;
    }

    public final void n(int i7) {
        this.f23796n = i7;
    }

    public final Object o(int i7) {
        return g()[i7];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        k(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        M5.m.e(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        M5.m.e(collection, "elements");
        boolean z7 = false;
        for (int iJ = j() - 1; -1 < iJ; iJ--) {
            if (!C1892w.A(collection, g()[iJ])) {
                k(iJ);
                z7 = true;
            }
        }
        return z7;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return i();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return C1880k.n(this.f23795m, 0, this.f23796n);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(j() * 14);
        sb.append('{');
        int iJ = j();
        for (int i7 = 0; i7 < iJ; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            Object objO = o(i7);
            if (objO != this) {
                sb.append(objO);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        M5.m.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public C1787b(int i7) {
        this.f23794l = AbstractC1825a.f24030a;
        this.f23795m = AbstractC1825a.f24032c;
        if (i7 > 0) {
            AbstractC1789d.a(this, i7);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        M5.m.e(objArr, "array");
        Object[] objArrA = AbstractC1788c.a(objArr, this.f23796n);
        C1880k.h(this.f23795m, objArrA, 0, 0, this.f23796n);
        M5.m.d(objArrA, "result");
        return objArrA;
    }

    public /* synthetic */ C1787b(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 0 : i7);
    }
}
