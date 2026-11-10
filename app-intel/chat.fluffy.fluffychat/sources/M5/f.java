package M5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f5714a = new Object[0];

    public static final Object[] a(Collection collection) {
        m.e(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            return f5714a;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return f5714a;
        }
        Object[] objArrCopyOf = new Object[size];
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            objArrCopyOf[i7] = it.next();
            if (i8 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i9 = ((i8 * 3) + 1) >>> 1;
                if (i9 <= i8) {
                    i9 = 2147483645;
                    if (i8 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i9);
                m.d(objArrCopyOf, "copyOf(...)");
            } else if (!it.hasNext()) {
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i8);
                m.d(objArrCopyOf2, "copyOf(...)");
                return objArrCopyOf2;
            }
            i7 = i8;
        }
    }

    public static final Object[] b(Collection collection, Object[] objArr) throws NegativeArraySizeException {
        Object[] objArrCopyOf;
        m.e(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i7 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    m.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i8 = i7 + 1;
                    objArrCopyOf[i7] = it.next();
                    if (i8 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i9 = ((i8 * 3) + 1) >>> 1;
                        if (i9 <= i8) {
                            i9 = 2147483645;
                            if (i8 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i9);
                        m.d(objArrCopyOf, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf == objArr) {
                            objArr[i8] = null;
                            return objArr;
                        }
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i8);
                        m.d(objArrCopyOf2, "copyOf(...)");
                        return objArrCopyOf2;
                    }
                    i7 = i8;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }
}
