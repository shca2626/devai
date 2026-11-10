package A5;

import M5.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c {
    public static final Object[] d(int i7) {
        if (i7 >= 0) {
            return new Object[i7];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final Object[] e(Object[] objArr, int i7) {
        m.e(objArr, "<this>");
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i7);
        m.d(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static final void f(Object[] objArr, int i7) {
        m.e(objArr, "<this>");
        objArr[i7] = null;
    }

    public static final void g(Object[] objArr, int i7, int i8) {
        m.e(objArr, "<this>");
        while (i7 < i8) {
            f(objArr, i7);
            i7++;
        }
    }

    public static final boolean h(Object[] objArr, int i7, int i8, List list) {
        if (i8 != list.size()) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (!m.a(objArr[i7 + i9], list.get(i9))) {
                return false;
            }
        }
        return true;
    }

    public static final int i(Object[] objArr, int i7, int i8) {
        int iHashCode = 1;
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj = objArr[i7 + i9];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final String j(Object[] objArr, int i7, int i8, Collection collection) {
        StringBuilder sb = new StringBuilder((i8 * 3) + 2);
        sb.append("[");
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i7 + i9];
            if (obj == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        m.d(string, "toString(...)");
        return string;
    }
}
