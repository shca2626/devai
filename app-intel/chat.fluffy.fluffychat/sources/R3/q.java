package R3;

/* loaded from: classes.dex */
public final class q extends p {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f8066j = {1, 1, 1, 1, 1, 1};

    /* renamed from: k, reason: collision with root package name */
    public static final int[][] f8067k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: i, reason: collision with root package name */
    public final int[] f8068i = new int[4];

    public static String s(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c7 = cArr[5];
        switch (c7) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c7);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c7);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    public static void t(StringBuilder sb, int i7) throws D3.j {
        for (int i8 = 0; i8 <= 1; i8++) {
            for (int i9 = 0; i9 < 10; i9++) {
                if (i7 == f8067k[i8][i9]) {
                    sb.insert(0, (char) (i8 + 48));
                    sb.append((char) (i9 + 48));
                    return;
                }
            }
        }
        throw D3.j.a();
    }

    @Override // R3.p
    public boolean h(String str) {
        return super.h(s(str));
    }

    @Override // R3.p
    public int[] k(J3.a aVar, int i7) {
        return p.n(aVar, i7, true, f8066j);
    }

    @Override // R3.p
    public int l(J3.a aVar, int[] iArr, StringBuilder sb) throws D3.j {
        int[] iArr2 = this.f8068i;
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
        t(sb, i8);
        return i7;
    }

    @Override // R3.p
    public D3.a q() {
        return D3.a.UPC_E;
    }
}
