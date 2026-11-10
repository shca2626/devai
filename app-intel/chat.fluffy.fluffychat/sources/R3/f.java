package R3;

/* loaded from: classes.dex */
public final class f extends p {

    /* renamed from: i, reason: collision with root package name */
    public final int[] f8037i = new int[4];

    @Override // R3.p
    public int l(J3.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f8037i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = aVar.k();
        int i7 = iArr[1];
        for (int i8 = 0; i8 < 4 && i7 < iK; i8++) {
            sb.append((char) (p.j(aVar, iArr2, i7, p.f8061g) + 48));
            for (int i9 : iArr2) {
                i7 += i9;
            }
        }
        int i10 = p.n(aVar, i7, true, p.f8059e)[1];
        for (int i11 = 0; i11 < 4 && i10 < iK; i11++) {
            sb.append((char) (p.j(aVar, iArr2, i10, p.f8061g) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        return i10;
    }

    @Override // R3.p
    public D3.a q() {
        return D3.a.EAN_8;
    }
}
