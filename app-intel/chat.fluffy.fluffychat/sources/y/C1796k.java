package y;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import z.AbstractC1825a;
import z5.C1880k;

/* renamed from: y.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1796k {

    /* renamed from: l, reason: collision with root package name */
    public int[] f23820l;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f23821m;

    /* renamed from: n, reason: collision with root package name */
    public int f23822n;

    public C1796k() {
        this(0, 1, null);
    }

    public final int a(Object obj) {
        int i7 = this.f23822n * 2;
        Object[] objArr = this.f23821m;
        if (obj == null) {
            for (int i8 = 1; i8 < i7; i8 += 2) {
                if (objArr[i8] == null) {
                    return i8 >> 1;
                }
            }
            return -1;
        }
        for (int i9 = 1; i9 < i7; i9 += 2) {
            if (M5.m.a(obj, objArr[i9])) {
                return i9 >> 1;
            }
        }
        return -1;
    }

    public void b(int i7) {
        int i8 = this.f23822n;
        int[] iArr = this.f23820l;
        if (iArr.length < i7) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
            M5.m.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f23820l = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23821m, i7 * 2);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23821m = objArrCopyOf;
        }
        if (this.f23822n != i8) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(Object obj, int i7) {
        int i8 = this.f23822n;
        if (i8 == 0) {
            return -1;
        }
        int iA = AbstractC1825a.a(this.f23820l, i8, i7);
        if (iA < 0 || M5.m.a(obj, this.f23821m[iA << 1])) {
            return iA;
        }
        int i9 = iA + 1;
        while (i9 < i8 && this.f23820l[i9] == i7) {
            if (M5.m.a(obj, this.f23821m[i9 << 1])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = iA - 1; i10 >= 0 && this.f23820l[i10] == i7; i10--) {
            if (M5.m.a(obj, this.f23821m[i10 << 1])) {
                return i10;
            }
        }
        return ~i9;
    }

    public void clear() {
        if (this.f23822n > 0) {
            this.f23820l = AbstractC1825a.f24030a;
            this.f23821m = AbstractC1825a.f24032c;
            this.f23822n = 0;
        }
        if (this.f23822n > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public int d(Object obj) {
        return obj == null ? e() : c(obj, obj.hashCode());
    }

    public final int e() {
        int i7 = this.f23822n;
        if (i7 == 0) {
            return -1;
        }
        int iA = AbstractC1825a.a(this.f23820l, i7, 0);
        if (iA < 0 || this.f23821m[iA << 1] == null) {
            return iA;
        }
        int i8 = iA + 1;
        while (i8 < i7 && this.f23820l[i8] == 0) {
            if (this.f23821m[i8 << 1] == null) {
                return i8;
            }
            i8++;
        }
        for (int i9 = iA - 1; i9 >= 0 && this.f23820l[i9] == 0; i9--) {
            if (this.f23821m[i9 << 1] == null) {
                return i9;
            }
        }
        return ~i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof C1796k) {
                if (size() != ((C1796k) obj).size()) {
                    return false;
                }
                C1796k c1796k = (C1796k) obj;
                int i7 = this.f23822n;
                for (int i8 = 0; i8 < i7; i8++) {
                    Object objF = f(i8);
                    Object objJ = j(i8);
                    Object obj2 = c1796k.get(objF);
                    if (objJ == null) {
                        if (obj2 != null || !c1796k.containsKey(objF)) {
                            return false;
                        }
                    } else if (!M5.m.a(objJ, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i9 = this.f23822n;
            for (int i10 = 0; i10 < i9; i10++) {
                Object objF2 = f(i10);
                Object objJ2 = j(i10);
                Object obj3 = ((Map) obj).get(objF2);
                if (objJ2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!M5.m.a(objJ2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public Object f(int i7) {
        if (i7 >= 0 && i7 < this.f23822n) {
            return this.f23821m[i7 << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
    }

    public void g(C1796k c1796k) {
        M5.m.e(c1796k, "map");
        int i7 = c1796k.f23822n;
        b(this.f23822n + i7);
        if (this.f23822n != 0) {
            for (int i8 = 0; i8 < i7; i8++) {
                put(c1796k.f(i8), c1796k.j(i8));
            }
        } else if (i7 > 0) {
            C1880k.f(c1796k.f23820l, this.f23820l, 0, 0, i7);
            C1880k.h(c1796k.f23821m, this.f23821m, 0, 0, i7 << 1);
            this.f23822n = i7;
        }
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f23821m[(iD << 1) + 1];
        }
        return null;
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f23821m[(iD << 1) + 1] : obj2;
    }

    public Object h(int i7) {
        int i8;
        if (i7 < 0 || i7 >= (i8 = this.f23822n)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
        }
        Object[] objArr = this.f23821m;
        int i9 = i7 << 1;
        Object obj = objArr[i9 + 1];
        if (i8 <= 1) {
            clear();
            return obj;
        }
        int i10 = i8 - 1;
        int[] iArr = this.f23820l;
        if (iArr.length <= 8 || i8 >= iArr.length / 3) {
            if (i7 < i10) {
                int i11 = i7 + 1;
                C1880k.f(iArr, iArr, i7, i11, i8);
                Object[] objArr2 = this.f23821m;
                C1880k.h(objArr2, objArr2, i9, i11 << 1, i8 << 1);
            }
            Object[] objArr3 = this.f23821m;
            int i12 = i10 << 1;
            objArr3[i12] = null;
            objArr3[i12 + 1] = null;
        } else {
            int i13 = i8 > 8 ? i8 + (i8 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i13);
            M5.m.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f23820l = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23821m, i13 << 1);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23821m = objArrCopyOf;
            if (i8 != this.f23822n) {
                throw new ConcurrentModificationException();
            }
            if (i7 > 0) {
                C1880k.f(iArr, this.f23820l, 0, 0, i7);
                C1880k.h(objArr, this.f23821m, 0, 0, i9);
            }
            if (i7 < i10) {
                int i14 = i7 + 1;
                C1880k.f(iArr, this.f23820l, i7, i14, i8);
                C1880k.h(objArr, this.f23821m, i9, i14 << 1, i8 << 1);
            }
        }
        if (i8 != this.f23822n) {
            throw new ConcurrentModificationException();
        }
        this.f23822n = i10;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f23820l;
        Object[] objArr = this.f23821m;
        int i7 = this.f23822n;
        int i8 = 1;
        int i9 = 0;
        int iHashCode = 0;
        while (i9 < i7) {
            Object obj = objArr[i8];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i9];
            i9++;
            i8 += 2;
        }
        return iHashCode;
    }

    public Object i(int i7, Object obj) {
        if (i7 < 0 || i7 >= this.f23822n) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
        }
        int i8 = (i7 << 1) + 1;
        Object[] objArr = this.f23821m;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        return obj2;
    }

    public boolean isEmpty() {
        return this.f23822n <= 0;
    }

    public Object j(int i7) {
        if (i7 >= 0 && i7 < this.f23822n) {
            return this.f23821m[(i7 << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
    }

    public Object put(Object obj, Object obj2) {
        int i7 = this.f23822n;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(obj, iHashCode) : e();
        if (iC >= 0) {
            int i8 = (iC << 1) + 1;
            Object[] objArr = this.f23821m;
            Object obj3 = objArr[i8];
            objArr[i8] = obj2;
            return obj3;
        }
        int i9 = ~iC;
        int[] iArr = this.f23820l;
        if (i7 >= iArr.length) {
            int i10 = 8;
            if (i7 >= 8) {
                i10 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i10 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
            M5.m.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f23820l = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23821m, i10 << 1);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23821m = objArrCopyOf;
            if (i7 != this.f23822n) {
                throw new ConcurrentModificationException();
            }
        }
        if (i9 < i7) {
            int[] iArr2 = this.f23820l;
            int i11 = i9 + 1;
            C1880k.f(iArr2, iArr2, i11, i9, i7);
            Object[] objArr2 = this.f23821m;
            C1880k.h(objArr2, objArr2, i11 << 1, i9 << 1, this.f23822n << 1);
        }
        int i12 = this.f23822n;
        if (i7 == i12) {
            int[] iArr3 = this.f23820l;
            if (i9 < iArr3.length) {
                iArr3[i9] = iHashCode;
                Object[] objArr3 = this.f23821m;
                int i13 = i9 << 1;
                objArr3[i13] = obj;
                objArr3[i13 + 1] = obj2;
                this.f23822n = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return i(iD, obj2);
        }
        return null;
    }

    public int size() {
        return this.f23822n;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f23822n * 28);
        sb.append('{');
        int i7 = this.f23822n;
        for (int i8 = 0; i8 < i7; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            Object objF = f(i8);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i8);
            if (objJ != sb) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        M5.m.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public C1796k(int i7) {
        this.f23820l = i7 == 0 ? AbstractC1825a.f24030a : new int[i7];
        this.f23821m = i7 == 0 ? AbstractC1825a.f24032c : new Object[i7 << 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !M5.m.a(obj2, j(iD))) {
            return false;
        }
        h(iD);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !M5.m.a(obj2, j(iD))) {
            return false;
        }
        i(iD, obj3);
        return true;
    }

    public /* synthetic */ C1796k(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 0 : i7);
    }

    public C1796k(C1796k c1796k) {
        this(0, 1, null);
        if (c1796k != null) {
            g(c1796k);
        }
    }
}
