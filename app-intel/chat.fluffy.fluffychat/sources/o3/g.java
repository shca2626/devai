package o3;

import j3.o;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class g extends h {

    public static class a extends AbstractList implements RandomAccess, Serializable {

        /* renamed from: l, reason: collision with root package name */
        public final int[] f20375l;

        /* renamed from: m, reason: collision with root package name */
        public final int f20376m;

        /* renamed from: n, reason: collision with root package name */
        public final int f20377n;

        public a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && g.l(this.f20375l, ((Integer) obj).intValue(), this.f20376m, this.f20377n) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f20375l[this.f20376m + i7] != aVar.f20375l[aVar.f20376m + i7]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer get(int i7) {
            o.o(i7, size());
            return Integer.valueOf(this.f20375l[this.f20376m + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer set(int i7, Integer num) {
            o.o(i7, size());
            int[] iArr = this.f20375l;
            int i8 = this.f20376m;
            int i9 = iArr[i8 + i7];
            iArr[i8 + i7] = ((Integer) o.q(num)).intValue();
            return Integer.valueOf(i9);
        }

        public int[] h() {
            return Arrays.copyOfRange(this.f20375l, this.f20376m, this.f20377n);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iJ = 1;
            for (int i7 = this.f20376m; i7 < this.f20377n; i7++) {
                iJ = (iJ * 31) + g.j(this.f20375l[i7]);
            }
            return iJ;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iL;
            if (!(obj instanceof Integer) || (iL = g.l(this.f20375l, ((Integer) obj).intValue(), this.f20376m, this.f20377n)) < 0) {
                return -1;
            }
            return iL - this.f20376m;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iM;
            if (!(obj instanceof Integer) || (iM = g.m(this.f20375l, ((Integer) obj).intValue(), this.f20376m, this.f20377n)) < 0) {
                return -1;
            }
            return iM - this.f20376m;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20377n - this.f20376m;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i7, int i8) {
            o.u(i7, i8, size());
            if (i7 == i8) {
                return Collections.EMPTY_LIST;
            }
            int[] iArr = this.f20375l;
            int i9 = this.f20376m;
            return new a(iArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f20375l[this.f20376m]);
            int i7 = this.f20376m;
            while (true) {
                i7++;
                if (i7 >= this.f20377n) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f20375l[i7]);
            }
        }

        public a(int[] iArr, int i7, int i8) {
            this.f20375l = iArr;
            this.f20376m = i7;
            this.f20377n = i8;
        }
    }

    public static List c(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new a(iArr);
    }

    public static int d(long j7) {
        int i7 = (int) j7;
        o.i(j7 == ((long) i7), "the total number of elements (%s) in the arrays must fit in an int", j7);
        return i7;
    }

    public static int e(long j7) {
        int i7 = (int) j7;
        o.i(((long) i7) == j7, "Out of range: %s", j7);
        return i7;
    }

    public static int[] f(int[]... iArr) {
        long length = 0;
        for (int[] iArr2 : iArr) {
            length += iArr2.length;
        }
        int[] iArr3 = new int[d(length)];
        int length2 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, length2, iArr4.length);
            length2 += iArr4.length;
        }
        return iArr3;
    }

    public static int g(int i7, int i8, int i9) {
        o.h(i8 <= i9, "min (%s) must be less than or equal to max (%s)", i8, i9);
        return Math.min(Math.max(i7, i8), i9);
    }

    public static int h(byte[] bArr) {
        o.h(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return i(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int i(byte b7, byte b8, byte b9, byte b10) {
        return (b7 << 24) | ((b8 & 255) << 16) | ((b9 & 255) << 8) | (b10 & 255);
    }

    public static int k(int[] iArr, int i7) {
        return l(iArr, i7, 0, iArr.length);
    }

    public static int l(int[] iArr, int i7, int i8, int i9) {
        while (i8 < i9) {
            if (iArr[i8] == i7) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static int m(int[] iArr, int i7, int i8, int i9) {
        for (int i10 = i9 - 1; i10 >= i8; i10--) {
            if (iArr[i10] == i7) {
                return i10;
            }
        }
        return -1;
    }

    public static int n(long j7) {
        if (j7 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j7 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j7;
    }

    public static int[] o(Collection collection) {
        if (collection instanceof a) {
            return ((a) collection).h();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = ((Number) o.q(array[i7])).intValue();
        }
        return iArr;
    }

    public static byte[] p(int i7) {
        return new byte[]{(byte) (i7 >> 24), (byte) (i7 >> 16), (byte) (i7 >> 8), (byte) i7};
    }

    public static Integer q(String str) {
        return r(str, 10);
    }

    public static Integer r(String str, int i7) {
        Long lE = i.e(str, i7);
        if (lE == null || lE.longValue() != lE.intValue()) {
            return null;
        }
        return Integer.valueOf(lE.intValue());
    }

    public static int j(int i7) {
        return i7;
    }
}
