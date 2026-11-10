package N3;

import D3.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final J3.b f6372a;

    /* renamed from: b, reason: collision with root package name */
    public final J3.b f6373b;

    /* renamed from: c, reason: collision with root package name */
    public final e f6374c;

    public a(J3.b bVar) throws f {
        int iL = bVar.l();
        if (iL < 8 || iL > 144 || (iL & 1) != 0) {
            throw f.a();
        }
        this.f6374c = j(bVar);
        J3.b bVarA = a(bVar);
        this.f6372a = bVarA;
        this.f6373b = new J3.b(bVarA.o(), bVarA.l());
    }

    public static e j(J3.b bVar) {
        return e.h(bVar.l(), bVar.o());
    }

    public final J3.b a(J3.b bVar) {
        int iF = this.f6374c.f();
        int iE = this.f6374c.e();
        if (bVar.l() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.f6374c.c();
        int iB = this.f6374c.b();
        int i7 = iF / iC;
        int i8 = iE / iB;
        J3.b bVar2 = new J3.b(i8 * iB, i7 * iC);
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = i9 * iC;
            for (int i11 = 0; i11 < i8; i11++) {
                int i12 = i11 * iB;
                for (int i13 = 0; i13 < iC; i13++) {
                    int i14 = ((iC + 2) * i9) + 1 + i13;
                    int i15 = i10 + i13;
                    for (int i16 = 0; i16 < iB; i16++) {
                        if (bVar.g(((iB + 2) * i11) + 1 + i16, i14)) {
                            bVar2.s(i12 + i16, i15);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    public e b() {
        return this.f6374c;
    }

    public byte[] c() throws f {
        byte[] bArr = new byte[this.f6374c.g()];
        int iL = this.f6372a.l();
        int iO = this.f6372a.o();
        int i7 = 0;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        int i9 = 4;
        while (true) {
            if (i9 == iL && i7 == 0 && !z7) {
                bArr[i8] = (byte) d(iL, iO);
                i9 -= 2;
                i7 += 2;
                i8++;
                z7 = true;
            } else {
                int i10 = iL - 2;
                if (i9 == i10 && i7 == 0 && (iO & 3) != 0 && !z8) {
                    bArr[i8] = (byte) e(iL, iO);
                    i9 -= 2;
                    i7 += 2;
                    i8++;
                    z8 = true;
                } else if (i9 == iL + 4 && i7 == 2 && (iO & 7) == 0 && !z9) {
                    bArr[i8] = (byte) f(iL, iO);
                    i9 -= 2;
                    i7 += 2;
                    i8++;
                    z9 = true;
                } else if (i9 == i10 && i7 == 0 && (iO & 7) == 4 && !z10) {
                    bArr[i8] = (byte) g(iL, iO);
                    i9 -= 2;
                    i7 += 2;
                    i8++;
                    z10 = true;
                } else {
                    while (true) {
                        if (i9 < iL && i7 >= 0 && !this.f6373b.g(i7, i9)) {
                            bArr[i8] = (byte) i(i9, i7, iL, iO);
                            i8++;
                        }
                        int i11 = i9 - 2;
                        int i12 = i7 + 2;
                        if (i11 < 0 || i12 >= iO) {
                            break;
                        }
                        i9 = i11;
                        i7 = i12;
                    }
                    int i13 = i9 - 1;
                    int i14 = i7 + 5;
                    while (true) {
                        if (i13 >= 0 && i14 < iO && !this.f6373b.g(i14, i13)) {
                            bArr[i8] = (byte) i(i13, i14, iL, iO);
                            i8++;
                        }
                        int i15 = i13 + 2;
                        int i16 = i14 - 2;
                        if (i15 >= iL || i16 < 0) {
                            break;
                        }
                        i13 = i15;
                        i14 = i16;
                    }
                    i9 = i13 + 5;
                    i7 = i14 - 1;
                }
            }
            if (i9 >= iL && i7 >= iO) {
                break;
            }
        }
        if (i8 == this.f6374c.g()) {
            return bArr;
        }
        throw f.a();
    }

    public final int d(int i7, int i8) {
        int i9 = i7 - 1;
        int i10 = (h(i9, 0, i7, i8) ? 1 : 0) << 1;
        if (h(i9, 1, i7, i8)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(i9, 2, i7, i8)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(0, i8 - 2, i7, i8)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        int i14 = i8 - 1;
        if (h(0, i14, i7, i8)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        if (h(1, i14, i7, i8)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (h(2, i14, i7, i8)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        return h(3, i14, i7, i8) ? i17 | 1 : i17;
    }

    public final int e(int i7, int i8) {
        int i9 = (h(i7 + (-3), 0, i7, i8) ? 1 : 0) << 1;
        if (h(i7 - 2, 0, i7, i8)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(i7 - 1, 0, i7, i8)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(0, i8 - 4, i7, i8)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(0, i8 - 3, i7, i8)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(0, i8 - 2, i7, i8)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        int i15 = i8 - 1;
        if (h(0, i15, i7, i8)) {
            i14 |= 1;
        }
        int i16 = i14 << 1;
        return h(1, i15, i7, i8) ? i16 | 1 : i16;
    }

    public final int f(int i7, int i8) {
        int i9 = i7 - 1;
        int i10 = (h(i9, 0, i7, i8) ? 1 : 0) << 1;
        int i11 = i8 - 1;
        if (h(i9, i11, i7, i8)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        int i13 = i8 - 3;
        if (h(0, i13, i7, i8)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        int i15 = i8 - 2;
        if (h(0, i15, i7, i8)) {
            i14 |= 1;
        }
        int i16 = i14 << 1;
        if (h(0, i11, i7, i8)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (h(1, i13, i7, i8)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (h(1, i15, i7, i8)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return h(1, i11, i7, i8) ? i19 | 1 : i19;
    }

    public final int g(int i7, int i8) {
        int i9 = (h(i7 + (-3), 0, i7, i8) ? 1 : 0) << 1;
        if (h(i7 - 2, 0, i7, i8)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(i7 - 1, 0, i7, i8)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(0, i8 - 2, i7, i8)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        int i13 = i8 - 1;
        if (h(0, i13, i7, i8)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        if (h(1, i13, i7, i8)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(2, i13, i7, i8)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return h(3, i13, i7, i8) ? i16 | 1 : i16;
    }

    public final boolean h(int i7, int i8, int i9, int i10) {
        if (i7 < 0) {
            i7 += i9;
            i8 += 4 - ((i9 + 4) & 7);
        }
        if (i8 < 0) {
            i8 += i10;
            i7 += 4 - ((i10 + 4) & 7);
        }
        if (i7 >= i9) {
            i7 -= i9;
        }
        this.f6373b.s(i8, i7);
        return this.f6372a.g(i8, i7);
    }

    public final int i(int i7, int i8, int i9, int i10) {
        int i11 = i7 - 2;
        int i12 = i8 - 2;
        int i13 = (h(i11, i12, i9, i10) ? 1 : 0) << 1;
        int i14 = i8 - 1;
        if (h(i11, i14, i9, i10)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i7 - 1;
        if (h(i16, i12, i9, i10)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (h(i16, i14, i9, i10)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (h(i16, i8, i9, i10)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (h(i7, i12, i9, i10)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (h(i7, i14, i9, i10)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        return h(i7, i8, i9, i10) ? i21 | 1 : i21;
    }
}
