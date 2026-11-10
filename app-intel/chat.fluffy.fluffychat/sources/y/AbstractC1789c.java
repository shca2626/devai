package y;

import java.lang.reflect.Array;

/* renamed from: y.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1789c {
    public static Object[] a(Object[] objArr, int i7) {
        if (objArr.length < i7) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i7);
        }
        if (objArr.length > i7) {
            objArr[i7] = null;
        }
        return objArr;
    }
}
