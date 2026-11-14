package V5;

import z5.AbstractC1872c;

/* loaded from: classes.dex */
public class w extends v {
    public static String p(char[] cArr) {
        M5.m.e(cArr, "<this>");
        return new String(cArr);
    }

    public static String q(char[] cArr, int i7, int i8) {
        M5.m.e(cArr, "<this>");
        AbstractC1872c.f24186l.a(i7, i8, cArr.length);
        return new String(cArr, i7, i8 - i7);
    }

    public static final boolean r(String str, String str2, boolean z7) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "suffix");
        return !z7 ? str.endsWith(str2) : u(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean s(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return r(str, str2, z7);
    }

    public static boolean t(String str, String str2, boolean z7) {
        return str == null ? str2 == null : !z7 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final boolean u(String str, int i7, String str2, int i8, int i9, boolean z7) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "other");
        return !z7 ? str.regionMatches(i7, str2, i8, i9) : str.regionMatches(z7, i7, str2, i8, i9);
    }

    public static final String v(String str, String str2, String str3, boolean z7) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "oldValue");
        M5.m.e(str3, "newValue");
        int i7 = 0;
        int iH = y.H(str, str2, 0, z7);
        if (iH < 0) {
            return str;
        }
        int length = str2.length();
        int iB = S5.e.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i7, iH);
            sb.append(str3);
            i7 = iH + length;
            if (iH >= str.length()) {
                break;
            }
            iH = y.H(str, str2, iH + iB, z7);
        } while (iH > 0);
        sb.append((CharSequence) str, i7, str.length());
        String string = sb.toString();
        M5.m.d(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String w(String str, String str2, String str3, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        return v(str, str2, str3, z7);
    }

    public static boolean x(String str, String str2, boolean z7) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "prefix");
        return !z7 ? str.startsWith(str2) : u(str, 0, str2, 0, str2.length(), z7);
    }

    public static /* synthetic */ boolean y(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return x(str, str2, z7);
    }
}
