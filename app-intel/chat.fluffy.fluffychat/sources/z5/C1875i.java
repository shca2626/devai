package z5;

import java.lang.reflect.Array;

/* renamed from: z5.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1875i {
    public static final Object[] a(Object[] objArr, int i7) throws NegativeArraySizeException {
        M5.m.e(objArr, "reference");
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i7);
        M5.m.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void b(int i7, int i8) {
        if (i7 <= i8) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i7 + ") is greater than size (" + i8 + ").");
    }
}
