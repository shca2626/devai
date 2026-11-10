package L3;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f5474a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f5475b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f5474a = aVar;
        int length = iArr.length;
        int i7 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f5475b = iArr;
            return;
        }
        while (i7 < length && iArr[i7] == 0) {
            i7++;
        }
        if (i7 == length) {
            this.f5475b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i7];
        this.f5475b = iArr2;
        System.arraycopy(iArr, i7, iArr2, 0, iArr2.length);
    }

    public b a(b bVar) {
        if (!this.f5474a.equals(bVar.f5474a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e()) {
            return bVar;
        }
        if (bVar.e()) {
            return this;
        }
        int[] iArr = this.f5475b;
        int[] iArr2 = bVar.f5475b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i7 = length; i7 < iArr.length; i7++) {
            iArr3[i7] = a.a(iArr2[i7 - length], iArr[i7]);
        }
        return new b(this.f5474a, iArr3);
    }

    public int b(int i7) {
        if (i7 == 0) {
            return c(0);
        }
        if (i7 == 1) {
            int iA = 0;
            for (int i8 : this.f5475b) {
                iA = a.a(iA, i8);
            }
            return iA;
        }
        int[] iArr = this.f5475b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i9 = 1; i9 < length; i9++) {
            iA2 = a.a(this.f5474a.j(i7, iA2), this.f5475b[i9]);
        }
        return iA2;
    }

    public int c(int i7) {
        return this.f5475b[(r0.length - 1) - i7];
    }

    public int d() {
        return this.f5475b.length - 1;
    }

    public boolean e() {
        return this.f5475b[0] == 0;
    }

    public b f(int i7) {
        if (i7 == 0) {
            return this.f5474a.g();
        }
        if (i7 == 1) {
            return this;
        }
        int length = this.f5475b.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = this.f5474a.j(this.f5475b[i8], i7);
        }
        return new b(this.f5474a, iArr);
    }

    public b g(b bVar) {
        if (!this.f5474a.equals(bVar.f5474a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e() || bVar.e()) {
            return this.f5474a.g();
        }
        int[] iArr = this.f5475b;
        int length = iArr.length;
        int[] iArr2 = bVar.f5475b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = iArr[i7];
            for (int i9 = 0; i9 < length2; i9++) {
                int i10 = i7 + i9;
                iArr3[i10] = a.a(iArr3[i10], this.f5474a.j(i8, iArr2[i9]));
            }
        }
        return new b(this.f5474a, iArr3);
    }

    public b h(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f5474a.g();
        }
        int length = this.f5475b.length;
        int[] iArr = new int[i7 + length];
        for (int i9 = 0; i9 < length; i9++) {
            iArr[i9] = this.f5474a.j(this.f5475b[i9], i8);
        }
        return new b(this.f5474a, iArr);
    }

    public String toString() {
        if (e()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    if (iD == d()) {
                        sb.append("-");
                    } else {
                        sb.append(" - ");
                    }
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    int i7 = this.f5474a.i(iC);
                    if (i7 == 0) {
                        sb.append('1');
                    } else if (i7 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i7);
                    }
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
