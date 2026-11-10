package z5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: z5.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1880n {
    public static List a(List list) {
        M5.m.e(list, "builder");
        return ((A5.b) list).s();
    }

    public static final Object[] b(Object[] objArr, boolean z7) {
        M5.m.e(objArr, "<this>");
        if (z7 && M5.m.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        M5.m.d(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List c() {
        return new A5.b(0, 1, null);
    }

    public static List d(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        M5.m.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static Object[] e(int i7, Object[] objArr) {
        M5.m.e(objArr, "array");
        if (i7 < objArr.length) {
            objArr[i7] = null;
        }
        return objArr;
    }
}
