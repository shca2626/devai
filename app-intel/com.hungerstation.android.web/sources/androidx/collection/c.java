package androidx.collection;

import java.lang.reflect.Array;

/* loaded from: classes6.dex */
class c {
    static <T> T[] a(T[] tArr, int i12) {
        if (tArr.length < i12) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i12));
        }
        if (tArr.length > i12) {
            tArr[i12] = null;
        }
        return tArr;
    }
}
