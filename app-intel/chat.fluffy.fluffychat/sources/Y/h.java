package Y;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class h {
    public static void a(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static float c(float f7, String str) {
        if (Float.isNaN(f7)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (!Float.isInfinite(f7)) {
            return f7;
        }
        throw new IllegalArgumentException(str + " must not be infinite");
    }

    public static float d(float f7, float f8, float f9, String str) {
        if (f7 < f8) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f8), Float.valueOf(f9)));
        }
        if (f7 <= f9) {
            return f7;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f8), Float.valueOf(f9)));
    }

    public static int e(int i7, int i8, int i9, String str) {
        if (i7 < i8) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i8), Integer.valueOf(i9)));
        }
        if (i7 <= i9) {
            return i7;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    public static long f(long j7, long j8, long j9, String str) {
        if (j7 < j8) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j8), Long.valueOf(j9)));
        }
        if (j7 <= j9) {
            return j7;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j8), Long.valueOf(j9)));
    }

    public static int g(int i7) {
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalArgumentException();
    }

    public static int h(int i7, String str) {
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalArgumentException(str);
    }

    public static int i(int i7, int i8) {
        if ((i7 & i8) == i7) {
            return i7;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i7) + ", but only 0x" + Integer.toHexString(i8) + " are allowed");
    }

    public static Object j(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object k(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static void l(boolean z7, String str) {
        if (!z7) {
            throw new IllegalStateException(str);
        }
    }

    public static CharSequence m(CharSequence charSequence, Object obj) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return charSequence;
    }
}
