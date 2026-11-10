package J3;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public int f4727l;

    /* renamed from: m, reason: collision with root package name */
    public int f4728m;

    /* renamed from: n, reason: collision with root package name */
    public int f4729n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f4730o;

    public b(int i7) {
        this(i7, i7);
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f4728m * (this.f4727l + 1));
        for (int i7 = 0; i7 < this.f4728m; i7++) {
            for (int i8 = 0; i8 < this.f4727l; i8++) {
                sb.append(g(i8, i7) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f4727l, this.f4728m, this.f4729n, (int[]) this.f4730o.clone());
    }

    public void c() {
        int length = this.f4730o.length;
        for (int i7 = 0; i7 < length; i7++) {
            int[] iArr = this.f4730o;
            iArr[i7] = ~iArr[i7];
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4727l == bVar.f4727l && this.f4728m == bVar.f4728m && this.f4729n == bVar.f4729n && Arrays.equals(this.f4730o, bVar.f4730o);
    }

    public void f(int i7, int i8) {
        int i9 = (i8 * this.f4729n) + (i7 / 32);
        int[] iArr = this.f4730o;
        iArr[i9] = (1 << (i7 & 31)) ^ iArr[i9];
    }

    public boolean g(int i7, int i8) {
        return ((this.f4730o[(i8 * this.f4729n) + (i7 / 32)] >>> (i7 & 31)) & 1) != 0;
    }

    public int[] h() {
        int length = this.f4730o.length - 1;
        while (length >= 0 && this.f4730o[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i7 = this.f4729n;
        int i8 = length / i7;
        int i9 = (length % i7) * 32;
        int i10 = 31;
        while ((this.f4730o[length] >>> i10) == 0) {
            i10--;
        }
        return new int[]{i9 + i10, i8};
    }

    public int hashCode() {
        int i7 = this.f4727l;
        return (((((((i7 * 31) + i7) * 31) + this.f4728m) * 31) + this.f4729n) * 31) + Arrays.hashCode(this.f4730o);
    }

    public int[] k() {
        int i7 = this.f4727l;
        int i8 = this.f4728m;
        int i9 = -1;
        int i10 = -1;
        for (int i11 = 0; i11 < this.f4728m; i11++) {
            int i12 = 0;
            while (true) {
                int i13 = this.f4729n;
                if (i12 < i13) {
                    int i14 = this.f4730o[(i13 * i11) + i12];
                    if (i14 != 0) {
                        if (i11 < i8) {
                            i8 = i11;
                        }
                        if (i11 > i10) {
                            i10 = i11;
                        }
                        int i15 = i12 * 32;
                        if (i15 < i7) {
                            int i16 = 0;
                            while ((i14 << (31 - i16)) == 0) {
                                i16++;
                            }
                            int i17 = i16 + i15;
                            if (i17 < i7) {
                                i7 = i17;
                            }
                        }
                        if (i15 + 31 > i9) {
                            int i18 = 31;
                            while ((i14 >>> i18) == 0) {
                                i18--;
                            }
                            int i19 = i15 + i18;
                            if (i19 > i9) {
                                i9 = i19;
                            }
                        }
                    }
                    i12++;
                }
            }
        }
        if (i9 < i7 || i10 < i8) {
            return null;
        }
        return new int[]{i7, i8, (i9 - i7) + 1, (i10 - i8) + 1};
    }

    public int l() {
        return this.f4728m;
    }

    public a m(int i7, a aVar) {
        if (aVar == null || aVar.k() < this.f4727l) {
            aVar = new a(this.f4727l);
        } else {
            aVar.a();
        }
        int i8 = i7 * this.f4729n;
        for (int i9 = 0; i9 < this.f4729n; i9++) {
            aVar.p(i9 * 32, this.f4730o[i8 + i9]);
        }
        return aVar;
    }

    public int[] n() {
        int[] iArr;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            iArr = this.f4730o;
            if (i8 >= iArr.length || iArr[i8] != 0) {
                break;
            }
            i8++;
        }
        if (i8 == iArr.length) {
            return null;
        }
        int i9 = this.f4729n;
        int i10 = i8 / i9;
        int i11 = (i8 % i9) * 32;
        while ((iArr[i8] << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i11 + i7, i10};
    }

    public int o() {
        return this.f4727l;
    }

    public void p(int i7) {
        int i8 = i7 % 360;
        if (i8 != 0) {
            if (i8 == 90) {
                r();
                return;
            }
            if (i8 == 180) {
                q();
            } else {
                if (i8 != 270) {
                    throw new IllegalArgumentException("degrees must be a multiple of 0, 90, 180, or 270");
                }
                r();
                q();
            }
        }
    }

    public void q() {
        a aVar = new a(this.f4727l);
        a aVar2 = new a(this.f4727l);
        int i7 = (this.f4728m + 1) / 2;
        for (int i8 = 0; i8 < i7; i8++) {
            aVar = m(i8, aVar);
            int i9 = (this.f4728m - 1) - i8;
            aVar2 = m(i9, aVar2);
            aVar.n();
            aVar2.n();
            u(i8, aVar2);
            u(i9, aVar);
        }
    }

    public void r() {
        int i7 = this.f4728m;
        int i8 = this.f4727l;
        int i9 = (i7 + 31) / 32;
        int[] iArr = new int[i9 * i8];
        for (int i10 = 0; i10 < this.f4728m; i10++) {
            for (int i11 = 0; i11 < this.f4727l; i11++) {
                if (((this.f4730o[(this.f4729n * i10) + (i11 / 32)] >>> (i11 & 31)) & 1) != 0) {
                    int i12 = (((i8 - 1) - i11) * i9) + (i10 / 32);
                    iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
                }
            }
        }
        this.f4727l = i7;
        this.f4728m = i8;
        this.f4729n = i9;
        this.f4730o = iArr;
    }

    public void s(int i7, int i8) {
        int i9 = (i8 * this.f4729n) + (i7 / 32);
        int[] iArr = this.f4730o;
        iArr[i9] = (1 << (i7 & 31)) | iArr[i9];
    }

    public void t(int i7, int i8, int i9, int i10) {
        if (i8 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i10 < 1 || i9 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i11 = i9 + i7;
        int i12 = i10 + i8;
        if (i12 > this.f4728m || i11 > this.f4727l) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i8 < i12) {
            int i13 = this.f4729n * i8;
            for (int i14 = i7; i14 < i11; i14++) {
                int[] iArr = this.f4730o;
                int i15 = (i14 / 32) + i13;
                iArr[i15] = iArr[i15] | (1 << (i14 & 31));
            }
            i8++;
        }
    }

    public String toString() {
        return v("X ", "  ");
    }

    public void u(int i7, a aVar) {
        int[] iArrF = aVar.f();
        int[] iArr = this.f4730o;
        int i8 = this.f4729n;
        System.arraycopy(iArrF, 0, iArr, i7 * i8, i8);
    }

    public String v(String str, String str2) {
        return a(str, str2, "\n");
    }

    public b(int i7, int i8) {
        if (i7 < 1 || i8 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f4727l = i7;
        this.f4728m = i8;
        int i9 = (i7 + 31) / 32;
        this.f4729n = i9;
        this.f4730o = new int[i9 * i8];
    }

    public b(int i7, int i8, int i9, int[] iArr) {
        this.f4727l = i7;
        this.f4728m = i8;
        this.f4729n = i9;
        this.f4730o = iArr;
    }
}
