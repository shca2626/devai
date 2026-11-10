package com.amazonaws.util;

/* loaded from: classes7.dex */
public enum CodecUtils {
    ;

    static int sanitize(String str, byte[] bArr) {
        int length = bArr.length;
        char[] charArray = str.toCharArray();
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            char c12 = charArray[i13];
            if (c12 != '\r' && c12 != '\n' && c12 != ' ') {
                if (c12 > 127) {
                    throw new IllegalArgumentException("Invalid character found at position " + i13 + " for " + str);
                }
                bArr[i12] = (byte) c12;
                i12++;
            }
        }
        return i12;
    }

    static void sanityCheckLastPos(int i12, int i13) {
        if ((i12 & i13) != 0) {
            throw new IllegalArgumentException("Invalid last non-pad character detected");
        }
    }

    public static byte[] toBytesDirect(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i12 = 0; i12 < length; i12++) {
            char c12 = charArray[i12];
            if (c12 > 127) {
                throw new IllegalArgumentException("Invalid character found at position " + i12 + " for " + str);
            }
            bArr[i12] = (byte) c12;
        }
        return bArr;
    }

    public static String toStringDirect(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int length = bArr.length;
        int i12 = 0;
        int i13 = 0;
        while (i12 < length) {
            cArr[i13] = (char) bArr[i12];
            i12++;
            i13++;
        }
        return new String(cArr);
    }
}
