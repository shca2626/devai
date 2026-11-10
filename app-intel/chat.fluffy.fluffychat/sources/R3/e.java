package R3;

/* loaded from: classes.dex */
public final class e extends p {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f8035j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    public final int[] f8036i = new int[4];

    public static void s(StringBuilder sb, int i7) throws D3.j {
        for (int i8 = 0; i8 < 10; i8++) {
            if (i7 == f8035j[i8]) {
                sb.insert(0, (char) (i8 + 48));
                return;
            }
        }
        throw D3.j.a();
    }

    @Override // R3.p
    public int l(J3.a aVar, int[] iArr, StringBuilder sb) throws D3.j {
        int[] iArr2 = this.f8036i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = aVar.k();
        int i7 = iArr[1];
        int i8 = 0;
        for (int i9 = 0; i9 < 6 && i7 < iK; i9++) {
            int iJ = p.j(aVar, iArr2, i7, p.f8062h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i10 : iArr2) {
                i7 += i10;
            }
            if (iJ >= 10) {
                i8 |= 1 << (5 - i9);
            }
        }
        s(sb, i8);
        int i11 = p.n(aVar, i7, true, p.f8059e)[1];
        for (int i12 = 0; i12 < 6 && i11 < iK; i12++) {
            sb.append((char) (p.j(aVar, iArr2, i11, p.f8061g) + 48));
            for (int i13 : iArr2) {
                i11 += i13;
            }
        }
        return i11;
    }

    @Override // R3.p
    public D3.a q() {
        return D3.a.EAN_13;
    }
}
