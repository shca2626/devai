package z5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: z5.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1881o extends C1880n {
    public static ArrayList f(Object... objArr) {
        M5.m.e(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(g(objArr, true));
    }

    public static final Collection g(Object[] objArr, boolean z7) {
        M5.m.e(objArr, "<this>");
        return new C1873g(objArr, z7);
    }

    public static /* synthetic */ Collection h(Object[] objArr, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return g(objArr, z7);
    }

    public static List i() {
        return C1891y.f24177l;
    }

    public static S5.c j(Collection collection) {
        M5.m.e(collection, "<this>");
        return new S5.c(0, collection.size() - 1);
    }

    public static int k(List list) {
        M5.m.e(list, "<this>");
        return list.size() - 1;
    }

    public static List l(Object... objArr) {
        M5.m.e(objArr, "elements");
        return objArr.length > 0 ? C1877k.d(objArr) : i();
    }

    public static final List m(List list) {
        M5.m.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : C1880n.d(list.get(0)) : i();
    }

    public static void n() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
