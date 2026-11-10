package J3;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f4724n = new int[0];

    /* renamed from: l, reason: collision with root package name */
    public int[] f4725l;

    /* renamed from: m, reason: collision with root package name */
    public int f4726m;

    public a() {
        this.f4726m = 0;
        this.f4725l = f4724n;
    }

    public static int[] m(int i7) {
        return new int[(i7 + 31) / 32];
    }

    public void a() {
        int length = this.f4725l.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.f4725l[i7] = 0;
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f4725l.clone(), this.f4726m);
    }

    public boolean c(int i7) {
        return ((1 << (i7 & 31)) & this.f4725l[i7 / 32]) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4726m == aVar.f4726m && Arrays.equals(this.f4725l, aVar.f4725l);
    }

    public int[] f() {
        return this.f4725l;
    }

    public int g(int i7) {
        int i8 = this.f4726m;
        if (i7 >= i8) {
            return i8;
        }
        int i9 = i7 / 32;
        int i10 = (-(1 << (i7 & 31))) & this.f4725l[i9];
        while (i10 == 0) {
            i9++;
            int[] iArr = this.f4725l;
            if (i9 == iArr.length) {
                return this.f4726m;
            }
            i10 = iArr[i9];
        }
        return Math.min((i9 * 32) + Integer.numberOfTrailingZeros(i10), this.f4726m);
    }

    public int h(int i7) {
        int i8 = this.f4726m;
        if (i7 >= i8) {
            return i8;
        }
        int i9 = i7 / 32;
        int i10 = (-(1 << (i7 & 31))) & (~this.f4725l[i9]);
        while (i10 == 0) {
            i9++;
            int[] iArr = this.f4725l;
            if (i9 == iArr.length) {
                return this.f4726m;
            }
            i10 = ~iArr[i9];
        }
        return Math.min((i9 * 32) + Integer.numberOfTrailingZeros(i10), this.f4726m);
    }

    public int hashCode() {
        return (this.f4726m * 31) + Arrays.hashCode(this.f4725l);
    }

    public int k() {
        return this.f4726m;
    }

    public boolean l(int i7, int i8, boolean z7) {
        if (i8 < i7 || i7 < 0 || i8 > this.f4726m) {
            throw new IllegalArgumentException();
        }
        if (i8 == i7) {
            return true;
        }
        int i9 = i8 - 1;
        int i10 = i7 / 32;
        int i11 = i9 / 32;
        int i12 = i10;
        while (i12 <= i11) {
            int i13 = (2 << (i12 >= i11 ? 31 & i9 : 31)) - (1 << (i12 > i10 ? 0 : i7 & 31));
            int i14 = this.f4725l[i12] & i13;
            if (!z7) {
                i13 = 0;
            }
            if (i14 != i13) {
                return false;
            }
            i12++;
        }
        return true;
    }

    public void n() {
        int[] iArr = new int[this.f4725l.length];
        int i7 = (this.f4726m - 1) / 32;
        int i8 = i7 + 1;
        for (int i9 = 0; i9 < i8; i9++) {
            iArr[i7 - i9] = Integer.reverse(this.f4725l[i9]);
        }
        int i10 = this.f4726m;
        int i11 = i8 * 32;
        if (i10 != i11) {
            int i12 = i11 - i10;
            int i13 = iArr[0] >>> i12;
            for (int i14 = 1; i14 < i8; i14++) {
                int i15 = iArr[i14];
                iArr[i14 - 1] = i13 | (i15 << (32 - i12));
                i13 = i15 >>> i12;
            }
            iArr[i7] = i13;
        }
        this.f4725l = iArr;
    }

    public void o(int i7) {
        int[] iArr = this.f4725l;
        int i8 = i7 / 32;
        iArr[i8] = (1 << (i7 & 31)) | iArr[i8];
    }

    public void p(int i7, int i8) {
        this.f4725l[i7 / 32] = i8;
    }

    public String toString() {
        int i7 = this.f4726m;
        StringBuilder sb = new StringBuilder(i7 + (i7 / 8) + 1);
        for (int i8 = 0; i8 < this.f4726m; i8++) {
            if ((i8 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(c(i8) ? 'X' : '.');
        }
        return sb.toString();
    }

    public a(int i7) {
        this.f4726m = i7;
        this.f4725l = m(i7);
    }

    public a(int[] iArr, int i7) {
        this.f4725l = iArr;
        this.f4726m = i7;
    }
}
