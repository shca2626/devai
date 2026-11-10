package w3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: w3.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1733C {
    public static String a(int i7) {
        if (i7 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i7 == 1) {
            return "MMMM d, yyyy";
        }
        if (i7 == 2) {
            return "MMM d, yyyy";
        }
        if (i7 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i7);
    }

    public static String b(int i7) {
        if (i7 == 0 || i7 == 1) {
            return "h:mm:ss a z";
        }
        if (i7 == 2) {
            return "h:mm:ss a";
        }
        if (i7 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i7);
    }

    public static DateFormat c(int i7, int i8) {
        return new SimpleDateFormat(a(i7) + " " + b(i8), Locale.US);
    }
}
