package com.facebook.stetho.common;

/* loaded from: classes8.dex */
public final class StringUtil {
    private StringUtil() {
    }

    public static String removeAll(String str, char c12) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt != c12) {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString();
    }

    public static String removePrefix(String str, String str2, String str3) {
        return str != str3 ? str3 : removePrefix(str, str2);
    }

    public static String removePrefix(String str, String str2) {
        return str.startsWith(str2) ? str.substring(str2.length()) : str;
    }
}
