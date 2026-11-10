package Q3;

import D3.f;
import J3.e;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f7674a = {53, 54, 43, 44, 45, 46, 47, 48, 37, 38};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f7675b = {55, 56, 57, 58, 59, 60, 49, 50, 51, 52};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f7676c = {39, 40, 41, 42, 31, 32};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f7677d = {33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[][] f7678e = {new byte[]{39, 40, 41, 42, 31, 32}, new byte[]{33, 34, 35, 36, 25, 26}, new byte[]{27, 28, 29, 30, 19, 20}, new byte[]{21, 22, 23, 24, 13, 14}, new byte[]{15, 16, 17, 18, 7, 8}, new byte[]{9, 10, 11, 12, 1, 2}};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f7679f = {"\rABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001e\ufffbÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8"};

    public static e a(byte[] bArr, int i7) throws f {
        String strH;
        StringBuilder sb = new StringBuilder(144);
        if (i7 == 2 || i7 == 3) {
            if (i7 == 2) {
                int iF = f(bArr);
                int iG = g(bArr);
                if (iG > 10) {
                    throw f.a();
                }
                strH = new DecimalFormat("0000000000".substring(0, iG)).format(iF);
            } else {
                strH = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(c(bArr));
            String str2 = decimalFormat.format(i(bArr));
            sb.append(e(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strH + (char) 29 + str + (char) 29 + str2 + (char) 29);
            } else {
                sb.insert(0, strH + (char) 29 + str + (char) 29 + str2 + (char) 29);
            }
        } else if (i7 == 4) {
            sb.append(e(bArr, 1, 93));
        } else if (i7 == 5) {
            sb.append(e(bArr, 1, 77));
        }
        return new e(bArr, sb.toString(), null, String.valueOf(i7));
    }

    public static int b(int i7, byte[] bArr) {
        int i8 = i7 - 1;
        return ((1 << (5 - (i8 % 6))) & bArr[i8 / 6]) == 0 ? 0 : 1;
    }

    public static int c(byte[] bArr) {
        return d(bArr, f7674a);
    }

    public static int d(byte[] bArr, byte[] bArr2) {
        int iB = 0;
        for (int i7 = 0; i7 < bArr2.length; i7++) {
            iB += b(bArr2[i7], bArr) << ((bArr2.length - i7) - 1);
        }
        return iB;
    }

    public static String e(byte[] bArr, int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        int i9 = i7;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        while (i9 < i7 + i8) {
            char cCharAt = f7679f[i11].charAt(bArr[i9]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i12 = i11;
                    i11 = cCharAt - 65520;
                    i10 = 1;
                    break;
                case 65525:
                    i10 = 2;
                    i12 = i11;
                    i11 = 0;
                    break;
                case 65526:
                    i10 = 3;
                    i12 = i11;
                    i11 = 0;
                    break;
                case 65527:
                    i10 = -1;
                    i11 = 0;
                    break;
                case 65528:
                    i10 = -1;
                    i11 = 1;
                    break;
                case 65529:
                    i10 = -1;
                    break;
                case 65530:
                default:
                    sb.append(cCharAt);
                    break;
                case 65531:
                    int i13 = (bArr[i9 + 1] << 24) + (bArr[i9 + 2] << 18) + (bArr[i9 + 3] << 12) + (bArr[i9 + 4] << 6);
                    i9 += 5;
                    sb.append(new DecimalFormat("000000000").format(i13 + bArr[i9]));
                    break;
            }
            int i14 = i10 - 1;
            if (i10 == 0) {
                i11 = i12;
            }
            i9++;
            i10 = i14;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static int f(byte[] bArr) {
        return d(bArr, f7677d);
    }

    public static int g(byte[] bArr) {
        return d(bArr, f7676c);
    }

    public static String h(byte[] bArr) {
        byte[][] bArr2 = f7678e;
        StringBuilder sb = new StringBuilder(bArr2.length);
        for (byte[] bArr3 : bArr2) {
            sb.append(f7679f[0].charAt(d(bArr, bArr3)));
        }
        return sb.toString();
    }

    public static int i(byte[] bArr) {
        return d(bArr, f7675b);
    }
}
