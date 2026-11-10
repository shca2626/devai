package R3;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f8050a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f8051b = new StringBuilder();

    public static Map c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(D3.o.class);
        enumMap.put((EnumMap) D3.o.ISSUE_NUMBER, (D3.o) Integer.valueOf(str));
        return enumMap;
    }

    public final int a(J3.a aVar, int[] iArr, StringBuilder sb) throws D3.j {
        int[] iArr2 = this.f8050a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = aVar.k();
        int iH = iArr[1];
        int i7 = 0;
        for (int i8 = 0; i8 < 2 && iH < iK; i8++) {
            int iJ = p.j(aVar, iArr2, iH, p.f8062h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i9 : iArr2) {
                iH += i9;
            }
            if (iJ >= 10) {
                i7 |= 1 << (1 - i8);
            }
            if (i8 != 1) {
                iH = aVar.h(aVar.g(iH));
            }
        }
        if (sb.length() != 2) {
            throw D3.j.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i7) {
            return iH;
        }
        throw D3.j.a();
    }

    public D3.n b(int i7, J3.a aVar, int[] iArr) throws D3.j {
        StringBuilder sb = this.f8051b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map mapC = c(string);
        float f7 = i7;
        D3.n nVar = new D3.n(string, null, new D3.p[]{new D3.p((iArr[0] + iArr[1]) / 2.0f, f7), new D3.p(iA, f7)}, D3.a.UPC_EAN_EXTENSION);
        if (mapC != null) {
            nVar.g(mapC);
        }
        return nVar;
    }
}
