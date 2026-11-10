package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes8.dex */
public class i {
    private static String a(int i12) {
        if (i12 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i12 == 1) {
            return "MMMM d, yyyy";
        }
        if (i12 == 2) {
            return "MMM d, yyyy";
        }
        if (i12 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i12);
    }

    private static String b(int i12) {
        if (i12 == 0 || i12 == 1) {
            return "h:mm:ss a z";
        }
        if (i12 == 2) {
            return "h:mm:ss a";
        }
        if (i12 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i12);
    }

    public static DateFormat c(int i12, int i13) {
        return new SimpleDateFormat(a(i12) + " " + b(i13), Locale.US);
    }
}
