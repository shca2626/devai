package z5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: z5.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1889t extends C1888s {
    public static boolean q(Collection collection, Iterable iterable) {
        M5.m.e(collection, "<this>");
        M5.m.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public static boolean r(Collection collection, Object[] objArr) {
        M5.m.e(collection, "<this>");
        M5.m.e(objArr, "elements");
        return collection.addAll(C1880k.d(objArr));
    }

    public static final Collection s(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : C1892w.X(iterable);
    }

    public static final boolean t(Iterable iterable, L5.l lVar, boolean z7) {
        Iterator it = iterable.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            if (((Boolean) lVar.a(it.next())).booleanValue() == z7) {
                it.remove();
                z8 = true;
            }
        }
        return z8;
    }

    public static final boolean u(List list, L5.l lVar, boolean z7) {
        int i7;
        if (!(list instanceof RandomAccess)) {
            M5.m.c(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return t(M5.A.a(list), lVar, z7);
        }
        int iK = C1884o.k(list);
        if (iK >= 0) {
            int i8 = 0;
            i7 = 0;
            while (true) {
                Object obj = list.get(i8);
                if (((Boolean) lVar.a(obj)).booleanValue() != z7) {
                    if (i7 != i8) {
                        list.set(i7, obj);
                    }
                    i7++;
                }
                if (i8 == iK) {
                    break;
                }
                i8++;
            }
        } else {
            i7 = 0;
        }
        if (i7 >= list.size()) {
            return false;
        }
        int iK2 = C1884o.k(list);
        if (i7 > iK2) {
            return true;
        }
        while (true) {
            list.remove(iK2);
            if (iK2 == i7) {
                return true;
            }
            iK2--;
        }
    }

    public static boolean v(Iterable iterable, L5.l lVar) {
        M5.m.e(iterable, "<this>");
        M5.m.e(lVar, "predicate");
        return t(iterable, lVar, true);
    }

    public static boolean w(List list, L5.l lVar) {
        M5.m.e(list, "<this>");
        M5.m.e(lVar, "predicate");
        return u(list, lVar, true);
    }

    public static Object x(List list) {
        M5.m.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(C1884o.k(list));
    }

    public static boolean y(Iterable iterable, L5.l lVar) {
        M5.m.e(iterable, "<this>");
        M5.m.e(lVar, "predicate");
        return t(iterable, lVar, false);
    }
}
