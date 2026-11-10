package ch;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f17167a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f17168b;

    /* renamed from: c, reason: collision with root package name */
    static final int[] f17169c;

    /* renamed from: d, reason: collision with root package name */
    static final int[] f17170d;

    /* renamed from: e, reason: collision with root package name */
    static final int[] f17171e;

    /* renamed from: f, reason: collision with root package name */
    static final int[] f17172f;

    /* renamed from: g, reason: collision with root package name */
    static final int[] f17173g;

    /* renamed from: h, reason: collision with root package name */
    static final int[] f17174h;

    /* renamed from: i, reason: collision with root package name */
    static final int[] f17175i;

    /* renamed from: j, reason: collision with root package name */
    static final int[] f17176j;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        f17167a = charArray;
        int length = charArray.length;
        f17168b = new byte[length];
        for (int i12 = 0; i12 < length; i12++) {
            f17168b[i12] = (byte) f17167a[i12];
        }
        int[] iArr = new int[256];
        for (int i13 = 0; i13 < 32; i13++) {
            iArr[i13] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f17169c = iArr;
        int length2 = iArr.length;
        int[] iArr2 = new int[length2];
        System.arraycopy(iArr, 0, iArr2, 0, length2);
        for (int i14 = UserVerificationMethods.USER_VERIFY_PATTERN; i14 < 256; i14++) {
            iArr2[i14] = (i14 & 224) == 192 ? 2 : (i14 & 240) == 224 ? 3 : (i14 & 248) == 240 ? 4 : -1;
        }
        f17170d = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i15 = 33; i15 < 256; i15++) {
            if (Character.isJavaIdentifierPart((char) i15)) {
                iArr3[i15] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        f17171e = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, 256);
        Arrays.fill(iArr4, UserVerificationMethods.USER_VERIFY_PATTERN, UserVerificationMethods.USER_VERIFY_PATTERN, 0);
        f17172f = iArr4;
        int[] iArr5 = new int[256];
        int[] iArr6 = f17170d;
        System.arraycopy(iArr6, UserVerificationMethods.USER_VERIFY_PATTERN, iArr5, UserVerificationMethods.USER_VERIFY_PATTERN, UserVerificationMethods.USER_VERIFY_PATTERN);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        f17173g = iArr5;
        int[] iArr7 = new int[256];
        System.arraycopy(iArr6, UserVerificationMethods.USER_VERIFY_PATTERN, iArr7, UserVerificationMethods.USER_VERIFY_PATTERN, UserVerificationMethods.USER_VERIFY_PATTERN);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        f17174h = iArr7;
        int[] iArr8 = new int[UserVerificationMethods.USER_VERIFY_PATTERN];
        for (int i16 = 0; i16 < 32; i16++) {
            iArr8[i16] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        f17175i = iArr8;
        int[] iArr9 = new int[UserVerificationMethods.USER_VERIFY_PATTERN];
        f17176j = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i17 = 0; i17 < 10; i17++) {
            f17176j[i17 + 48] = i17;
        }
        for (int i18 = 0; i18 < 6; i18++) {
            int[] iArr10 = f17176j;
            int i19 = i18 + 10;
            iArr10[i18 + 97] = i19;
            iArr10[i18 + 65] = i19;
        }
    }

    public static void a(StringBuilder sb2, String str) {
        int[] iArr = f17175i;
        int length = iArr.length;
        int length2 = str.length();
        for (int i12 = 0; i12 < length2; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt >= length || iArr[cCharAt] == 0) {
                sb2.append(cCharAt);
            } else {
                sb2.append('\\');
                int i13 = iArr[cCharAt];
                if (i13 < 0) {
                    sb2.append('u');
                    sb2.append('0');
                    sb2.append('0');
                    char[] cArr = f17167a;
                    sb2.append(cArr[cCharAt >> 4]);
                    sb2.append(cArr[cCharAt & 15]);
                } else {
                    sb2.append((char) i13);
                }
            }
        }
    }

    public static int b(int i12) {
        if (i12 > 127) {
            return -1;
        }
        return f17176j[i12];
    }

    public static char[] c() {
        return (char[]) f17167a.clone();
    }

    public static int[] d() {
        return f17175i;
    }

    public static int[] e() {
        return f17169c;
    }

    public static int[] f() {
        return f17171e;
    }
}
