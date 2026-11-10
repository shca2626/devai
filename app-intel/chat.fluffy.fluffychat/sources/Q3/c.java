package Q3;

import D3.d;
import D3.f;
import J3.e;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final L3.c f7680a = new L3.c(L3.a.f5466o);

    public final int a(byte[] bArr, int i7, int i8, int i9, int i10) throws d {
        int i11 = i8 + i9;
        int i12 = i10 == 0 ? 1 : 2;
        int[] iArr = new int[i11 / i12];
        for (int i13 = 0; i13 < i11; i13++) {
            if (i10 == 0 || i13 % 2 == i10 - 1) {
                iArr[i13 / i12] = bArr[i13 + i7] & 255;
            }
        }
        try {
            int iA = this.f7680a.a(iArr, i9 / i12);
            for (int i14 = 0; i14 < i8; i14++) {
                if (i10 == 0 || i14 % 2 == i10 - 1) {
                    bArr[i14 + i7] = (byte) iArr[i14 / i12];
                }
            }
            return iA;
        } catch (L3.d unused) {
            throw d.a();
        }
    }

    public e b(J3.b bVar, Map map) throws f, d {
        int iA;
        byte[] bArr;
        byte[] bArrA = new a(bVar).a();
        int iA2 = a(bArrA, 0, 10, 10, 0);
        int i7 = bArrA[0] & 15;
        if (i7 == 2 || i7 == 3 || i7 == 4) {
            iA = iA2 + a(bArrA, 20, 84, 40, 1) + a(bArrA, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i7 != 5) {
                throw f.a();
            }
            iA = iA2 + a(bArrA, 20, 68, 56, 1) + a(bArrA, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        e eVarA = b.a(bArr, i7);
        eVarA.n(Integer.valueOf(iA));
        return eVarA;
    }
}
