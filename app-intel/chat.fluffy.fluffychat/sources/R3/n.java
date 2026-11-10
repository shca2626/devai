package R3;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8052c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    public final int[] f8053a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f8054b = new StringBuilder();

    public static int c(int i7) throws D3.j {
        for (int i8 = 0; i8 < 10; i8++) {
            if (i7 == f8052c[i8]) {
                return i8;
            }
        }
        throw D3.j.a();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i7 = length - 2; i7 >= 0; i7 -= 2) {
            iCharAt += charSequence.charAt(i7) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
            iCharAt2 += charSequence.charAt(i8) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e(java.lang.String r5) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 48
            r3 = 1
            if (r1 == r2) goto L4d
            r2 = 53
            if (r1 == r2) goto L4a
            r2 = 57
            java.lang.String r4 = ""
            if (r1 == r2) goto L15
            goto L4f
        L15:
            int r1 = r5.hashCode()
            r2 = -1
            switch(r1) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r0 = r2
            goto L3e
        L1f:
            java.lang.String r0 = "99991"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L28
            goto L1d
        L28:
            r0 = 2
            goto L3e
        L2a:
            java.lang.String r0 = "99990"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L33
            goto L1d
        L33:
            r0 = r3
            goto L3e
        L35:
            java.lang.String r1 = "90000"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L3e
            goto L1d
        L3e:
            switch(r0) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r4 = "$"
            goto L4f
        L4d:
            java.lang.String r4 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L75
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "0"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            goto L79
        L75:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L79:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: R3.n.e(java.lang.String):java.lang.String");
    }

    public static Map f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(D3.o.class);
        enumMap.put((EnumMap) D3.o.SUGGESTED_PRICE, (D3.o) strE);
        return enumMap;
    }

    public final int a(J3.a aVar, int[] iArr, StringBuilder sb) throws D3.j {
        int[] iArr2 = this.f8053a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = aVar.k();
        int iH = iArr[1];
        int i7 = 0;
        for (int i8 = 0; i8 < 5 && iH < iK; i8++) {
            int iJ = p.j(aVar, iArr2, iH, p.f8062h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i9 : iArr2) {
                iH += i9;
            }
            if (iJ >= 10) {
                i7 |= 1 << (4 - i8);
            }
            if (i8 != 4) {
                iH = aVar.h(aVar.g(iH));
            }
        }
        if (sb.length() != 5) {
            throw D3.j.a();
        }
        if (d(sb.toString()) == c(i7)) {
            return iH;
        }
        throw D3.j.a();
    }

    public D3.n b(int i7, J3.a aVar, int[] iArr) throws D3.j {
        StringBuilder sb = this.f8054b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map mapF = f(string);
        float f7 = i7;
        D3.n nVar = new D3.n(string, null, new D3.p[]{new D3.p((iArr[0] + iArr[1]) / 2.0f, f7), new D3.p(iA, f7)}, D3.a.UPC_EAN_EXTENSION);
        if (mapF != null) {
            nVar.g(mapF);
        }
        return nVar;
    }
}
