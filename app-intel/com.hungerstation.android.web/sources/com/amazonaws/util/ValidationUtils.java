package com.amazonaws.util;

import java.util.Collection;

/* loaded from: classes7.dex */
public class ValidationUtils {
    public static void assertAllAreNull(String str, Object... objArr) {
        for (Object obj : objArr) {
            if (obj != null) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static int assertIsPositive(int i12, String str) {
        if (i12 > 0) {
            return i12;
        }
        throw new IllegalArgumentException(String.format("%s must be positive", str));
    }

    public static <T extends Collection<?>> T assertNotEmpty(T t12, String str) {
        assertNotNull(t12, str);
        if (t12.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty", str));
        }
        return t12;
    }

    public static <T> T assertNotNull(T t12, String str) {
        if (t12 != null) {
            return t12;
        }
        throw new IllegalArgumentException(String.format("%s cannot be null", str));
    }

    public static void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String assertStringNotEmpty(String str, String str2) {
        assertNotNull(str, str2);
        if (str.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty", str2));
        }
        return str;
    }

    public static <T> T[] assertNotEmpty(T[] tArr, String str) {
        assertNotNull(tArr, str);
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", str));
    }
}
