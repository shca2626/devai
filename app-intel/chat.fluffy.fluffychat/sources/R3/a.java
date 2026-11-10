package R3;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f8018d = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8019e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f8020f = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f8021a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public int[] f8022b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    public int f8023c = 0;

    public static boolean h(char[] cArr, char c7) {
        if (cArr != null) {
            for (char c8 : cArr) {
                if (c8 == c7) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // R3.k
    public D3.n c(int i7, J3.a aVar, Map map) throws D3.j {
        int i8;
        Arrays.fill(this.f8022b, 0);
        k(aVar);
        int iJ = j();
        this.f8021a.setLength(0);
        int i9 = iJ;
        while (true) {
            int iL = l(i9);
            if (iL == -1) {
                throw D3.j.a();
            }
            this.f8021a.append((char) iL);
            i8 = i9 + 8;
            if ((this.f8021a.length() > 1 && h(f8020f, f8018d[iL])) || i8 >= this.f8023c) {
                break;
            }
            i9 = i8;
        }
        int i10 = i9 + 7;
        int i11 = this.f8022b[i10];
        int i12 = 0;
        for (int i13 = -8; i13 < -1; i13++) {
            i12 += this.f8022b[i8 + i13];
        }
        if (i8 < this.f8023c && i11 < i12 / 2) {
            throw D3.j.a();
        }
        m(iJ);
        for (int i14 = 0; i14 < this.f8021a.length(); i14++) {
            StringBuilder sb = this.f8021a;
            sb.setCharAt(i14, f8018d[sb.charAt(i14)]);
        }
        char cCharAt = this.f8021a.charAt(0);
        char[] cArr = f8020f;
        if (!h(cArr, cCharAt)) {
            throw D3.j.a();
        }
        StringBuilder sb2 = this.f8021a;
        if (!h(cArr, sb2.charAt(sb2.length() - 1))) {
            throw D3.j.a();
        }
        if (this.f8021a.length() <= 3) {
            throw D3.j.a();
        }
        if (map == null || !map.containsKey(D3.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f8021a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f8021a.deleteCharAt(0);
        }
        int i15 = 0;
        for (int i16 = 0; i16 < iJ; i16++) {
            i15 += this.f8022b[i16];
        }
        float f7 = i15;
        while (iJ < i10) {
            i15 += this.f8022b[iJ];
            iJ++;
        }
        float f8 = i7;
        D3.n nVar = new D3.n(this.f8021a.toString(), null, new D3.p[]{new D3.p(f7, f8), new D3.p(i15, f8)}, D3.a.CODABAR);
        nVar.h(D3.o.SYMBOLOGY_IDENTIFIER, "]F0");
        return nVar;
    }

    public final void i(int i7) {
        int[] iArr = this.f8022b;
        int i8 = this.f8023c;
        iArr[i8] = i7;
        int i9 = i8 + 1;
        this.f8023c = i9;
        if (i9 >= iArr.length) {
            int[] iArr2 = new int[i9 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            this.f8022b = iArr2;
        }
    }

    public final int j() throws D3.j {
        for (int i7 = 1; i7 < this.f8023c; i7 += 2) {
            int iL = l(i7);
            if (iL != -1 && h(f8020f, f8018d[iL])) {
                int i8 = 0;
                for (int i9 = i7; i9 < i7 + 7; i9++) {
                    i8 += this.f8022b[i9];
                }
                if (i7 == 1 || this.f8022b[i7 - 1] >= i8 / 2) {
                    return i7;
                }
            }
        }
        throw D3.j.a();
    }

    public final void k(J3.a aVar) throws D3.j {
        int i7 = 0;
        this.f8023c = 0;
        int iH = aVar.h(0);
        int iK = aVar.k();
        if (iH >= iK) {
            throw D3.j.a();
        }
        boolean z7 = true;
        while (iH < iK) {
            if (aVar.c(iH) != z7) {
                i7++;
            } else {
                i(i7);
                z7 = !z7;
                i7 = 1;
            }
            iH++;
        }
        i(i7);
    }

    public final int l(int i7) {
        int i8 = i7 + 7;
        if (i8 >= this.f8023c) {
            return -1;
        }
        int[] iArr = this.f8022b;
        int i9 = Integer.MAX_VALUE;
        int i10 = 0;
        int i11 = Integer.MAX_VALUE;
        int i12 = 0;
        for (int i13 = i7; i13 < i8; i13 += 2) {
            int i14 = iArr[i13];
            if (i14 < i11) {
                i11 = i14;
            }
            if (i14 > i12) {
                i12 = i14;
            }
        }
        int i15 = (i11 + i12) / 2;
        int i16 = 0;
        for (int i17 = i7 + 1; i17 < i8; i17 += 2) {
            int i18 = iArr[i17];
            if (i18 < i9) {
                i9 = i18;
            }
            if (i18 > i16) {
                i16 = i18;
            }
        }
        int i19 = (i9 + i16) / 2;
        int i20 = 128;
        int i21 = 0;
        for (int i22 = 0; i22 < 7; i22++) {
            i20 >>= 1;
            if (iArr[i7 + i22] > ((i22 & 1) == 0 ? i15 : i19)) {
                i21 |= i20;
            }
        }
        while (true) {
            int[] iArr2 = f8019e;
            if (i10 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i10] == i21) {
                return i10;
            }
            i10++;
        }
    }

    public final void m(int i7) throws D3.j {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f8021a.length() - 1;
        int i8 = i7;
        int i9 = 0;
        while (true) {
            if (i9 > length) {
                break;
            }
            int i10 = f8019e[this.f8021a.charAt(i9)];
            for (int i11 = 6; i11 >= 0; i11--) {
                int i12 = (i11 & 1) + ((i10 & 1) * 2);
                iArr[i12] = iArr[i12] + this.f8022b[i8 + i11];
                iArr2[i12] = iArr2[i12] + 1;
                i10 >>= 1;
            }
            i8 += 8;
            i9++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i13 = 0; i13 < 2; i13++) {
            fArr2[i13] = 0.0f;
            int i14 = i13 + 2;
            int i15 = iArr[i14];
            int i16 = iArr2[i14];
            float f7 = ((iArr[i13] / iArr2[i13]) + (i15 / i16)) / 2.0f;
            fArr2[i14] = f7;
            fArr[i13] = f7;
            fArr[i14] = ((i15 * 2.0f) + 1.5f) / i16;
        }
        int i17 = i7;
        for (int i18 = 0; i18 <= length; i18++) {
            int i19 = f8019e[this.f8021a.charAt(i18)];
            for (int i20 = 6; i20 >= 0; i20--) {
                int i21 = (i20 & 1) + ((i19 & 1) * 2);
                float f8 = this.f8022b[i17 + i20];
                if (f8 < fArr2[i21] || f8 > fArr[i21]) {
                    throw D3.j.a();
                }
                i19 >>= 1;
            }
            i17 += 8;
        }
    }
}
