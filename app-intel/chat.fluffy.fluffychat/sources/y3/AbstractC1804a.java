package y3;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* renamed from: y3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1804a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f23999a = DesugarTimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i7, char c7) {
        return i7 < str.length() && str.charAt(i7) == c7;
    }

    public static int b(String str, int i7) {
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < '0' || cCharAt > '9') {
                return i7;
            }
            i7++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00df A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:21:0x005b, B:23:0x006b, B:24:0x006d, B:26:0x0079, B:27:0x007c, B:29:0x0082, B:33:0x008c, B:38:0x009c, B:40:0x00a4, B:51:0x00d9, B:53:0x00df, B:55:0x00e5, B:79:0x0192, B:59:0x00ef, B:60:0x010a, B:61:0x010b, B:65:0x0127, B:67:0x0134, B:70:0x013d, B:72:0x015c, B:75:0x016b, B:76:0x018d, B:78:0x0190, B:64:0x0116, B:81:0x01c3, B:82:0x01ca, B:44:0x00bc, B:45:0x00bf), top: B:93:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c3 A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:21:0x005b, B:23:0x006b, B:24:0x006d, B:26:0x0079, B:27:0x007c, B:29:0x0082, B:33:0x008c, B:38:0x009c, B:40:0x00a4, B:51:0x00d9, B:53:0x00df, B:55:0x00e5, B:79:0x0192, B:59:0x00ef, B:60:0x010a, B:61:0x010b, B:65:0x0127, B:67:0x0134, B:70:0x013d, B:72:0x015c, B:75:0x016b, B:76:0x018d, B:78:0x0190, B:64:0x0116, B:81:0x01c3, B:82:0x01ca, B:44:0x00bc, B:45:0x00bf), top: B:93:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date c(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.AbstractC1804a.c(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int d(String str, int i7, int i8) {
        int i9;
        int i10;
        if (i7 < 0 || i8 > str.length() || i7 > i8) {
            throw new NumberFormatException(str);
        }
        if (i7 < i8) {
            i10 = i7 + 1;
            int iDigit = Character.digit(str.charAt(i7), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = -iDigit;
        } else {
            i9 = 0;
            i10 = i7;
        }
        while (i10 < i8) {
            int i11 = i10 + 1;
            int iDigit2 = Character.digit(str.charAt(i10), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = (i9 * 10) - iDigit2;
            i10 = i11;
        }
        return -i9;
    }
}
