package k3;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class V {
    public static Object[] a(Object[] objArr, int i7, int i8, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i7, i8, objArr2.getClass());
    }

    public static Object[] b(Object[] objArr, int i7) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, 0);
        }
        return Arrays.copyOf(objArr, i7);
    }

    public static Map c(int i7) {
        return C1268k.w(i7);
    }

    public static Map d() {
        return C1268k.r();
    }
}
