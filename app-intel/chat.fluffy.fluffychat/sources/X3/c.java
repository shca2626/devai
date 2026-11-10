package X3;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f9294a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f9295b;

    public c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f9294a = bVar;
        int length = iArr.length;
        int i7 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f9295b = iArr;
            return;
        }
        while (i7 < length && iArr[i7] == 0) {
            i7++;
        }
        if (i7 == length) {
            this.f9295b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i7];
        this.f9295b = iArr2;
        System.arraycopy(iArr, i7, iArr2, 0, iArr2.length);
    }

    public c a(c cVar) {
        if (!this.f9294a.equals(cVar.f9294a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return cVar;
        }
        if (cVar.e()) {
            return this;
        }
        int[] iArr = this.f9295b;
        int[] iArr2 = cVar.f9295b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i7 = length; i7 < iArr.length; i7++) {
            iArr3[i7] = this.f9294a.a(iArr2[i7 - length], iArr[i7]);
        }
        return new c(this.f9294a, iArr3);
    }

    public int b(int i7) {
        if (i7 == 0) {
            return c(0);
        }
        if (i7 == 1) {
            int iA = 0;
            for (int i8 : this.f9295b) {
                iA = this.f9294a.a(iA, i8);
            }
            return iA;
        }
        int[] iArr = this.f9295b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i9 = 1; i9 < length; i9++) {
            b bVar = this.f9294a;
            iA2 = bVar.a(bVar.i(i7, iA2), this.f9295b[i9]);
        }
        return iA2;
    }

    public int c(int i7) {
        return this.f9295b[(r0.length - 1) - i7];
    }

    public int d() {
        return this.f9295b.length - 1;
    }

    public boolean e() {
        return this.f9295b[0] == 0;
    }

    public c f(int i7) {
        if (i7 == 0) {
            return this.f9294a.f();
        }
        if (i7 == 1) {
            return this;
        }
        int length = this.f9295b.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = this.f9294a.i(this.f9295b[i8], i7);
        }
        return new c(this.f9294a, iArr);
    }

    public c g(c cVar) {
        if (!this.f9294a.equals(cVar.f9294a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || cVar.e()) {
            return this.f9294a.f();
        }
        int[] iArr = this.f9295b;
        int length = iArr.length;
        int[] iArr2 = cVar.f9295b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = iArr[i7];
            for (int i9 = 0; i9 < length2; i9++) {
                int i10 = i7 + i9;
                b bVar = this.f9294a;
                iArr3[i10] = bVar.a(iArr3[i10], bVar.i(i8, iArr2[i9]));
            }
        }
        return new c(this.f9294a, iArr3);
    }

    public c h(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f9294a.f();
        }
        int length = this.f9295b.length;
        int[] iArr = new int[i7 + length];
        for (int i9 = 0; i9 < length; i9++) {
            iArr[i9] = this.f9294a.i(this.f9295b[i9], i8);
        }
        return new c(this.f9294a, iArr);
    }

    public c i() {
        int length = this.f9295b.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = this.f9294a.j(0, this.f9295b[i7]);
        }
        return new c(this.f9294a, iArr);
    }

    public c j(c cVar) {
        if (this.f9294a.equals(cVar.f9294a)) {
            return cVar.e() ? this : a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    sb.append(iC);
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
