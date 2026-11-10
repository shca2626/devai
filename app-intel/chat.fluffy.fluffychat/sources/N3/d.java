package N3;

import D3.f;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final L3.c f6392a = new L3.c(L3.a.f5464m);

    public final int a(byte[] bArr, int i7) throws D3.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = bArr[i8] & 255;
        }
        try {
            int iA = this.f6392a.a(iArr, bArr.length - i7);
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) iArr[i9];
            }
            return iA;
        } catch (L3.d unused) {
            throw D3.d.a();
        }
    }

    public J3.e b(J3.b bVar) throws f {
        a aVar = new a(bVar);
        b[] bVarArrB = b.b(aVar.c(), aVar.b());
        int iC = 0;
        for (b bVar2 : bVarArrB) {
            iC += bVar2.c();
        }
        byte[] bArr = new byte[iC];
        int length = bVarArrB.length;
        int iA = 0;
        for (int i7 = 0; i7 < length; i7++) {
            b bVar3 = bVarArrB[i7];
            byte[] bArrA = bVar3.a();
            int iC2 = bVar3.c();
            iA += a(bArrA, iC2);
            for (int i8 = 0; i8 < iC2; i8++) {
                bArr[(i8 * length) + i7] = bArrA[i8];
            }
        }
        J3.e eVarA = c.a(bArr);
        eVarA.n(Integer.valueOf(iA));
        return eVarA;
    }
}
