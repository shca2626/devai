package V5;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class A extends z {
    public static final String s0(String str, int i7) {
        M5.m.e(str, "<this>");
        if (i7 >= 0) {
            String strSubstring = str.substring(S5.e.f(i7, str.length()));
            M5.m.d(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    public static String t0(String str, int i7) {
        M5.m.e(str, "<this>");
        if (i7 >= 0) {
            return v0(str, S5.e.b(str.length() - i7, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    public static char u0(CharSequence charSequence) {
        M5.m.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(y.D(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final String v0(String str, int i7) {
        M5.m.e(str, "<this>");
        if (i7 >= 0) {
            String strSubstring = str.substring(0, S5.e.f(i7, str.length()));
            M5.m.d(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }
}
