package o5;

import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z5.AbstractC1860D;
import z5.C1878l;
import z5.C1880n;
import z5.C1881o;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f20479a = new s();

    public final boolean a(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) obj2;
            if (objArr.length == objArr2.length) {
                Iterable iterableX = C1878l.x(objArr);
                if (!(iterableX instanceof Collection) || !((Collection) iterableX).isEmpty()) {
                    Iterator it = iterableX.iterator();
                    while (it.hasNext()) {
                        int iNextInt = ((AbstractC1860D) it).nextInt();
                        if (!f20479a.a(objArr[iNextInt], objArr2[iNextInt])) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() == list2.size()) {
                Iterable iterableJ = C1881o.j((Collection) obj);
                if (!(iterableJ instanceof Collection) || !((Collection) iterableJ).isEmpty()) {
                    Iterator it2 = iterableJ.iterator();
                    while (it2.hasNext()) {
                        int iNextInt2 = ((AbstractC1860D) it2).nextInt();
                        if (!f20479a.a(list.get(iNextInt2), list2.get(iNextInt2))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
            return M5.m.a(obj, obj2);
        }
        Map map = (Map) obj;
        Map map2 = (Map) obj2;
        if (map.size() == map2.size()) {
            if (!map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!map2.containsKey(entry.getKey()) || !f20479a.a(entry.getValue(), map2.get(entry.getKey()))) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final List b(Throwable th) {
        M5.m.e(th, "exception");
        return C1881o.l(th.getClass().getSimpleName(), th.toString(), "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
    }

    public final List c(Object obj) {
        return C1880n.d(obj);
    }
}
