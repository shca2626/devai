package z5;

import java.util.HashSet;
import java.util.Set;

/* renamed from: z5.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1868I extends C1867H {
    public static Set d() {
        return C1860A.f24184l;
    }

    public static HashSet e(Object... objArr) {
        M5.m.e(objArr, "elements");
        return (HashSet) C1881l.M(objArr, new HashSet(C1865F.e(objArr.length)));
    }

    public static final Set f(Set set) {
        M5.m.e(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : C1867H.c(set.iterator().next()) : d();
    }

    public static Set g(Object... objArr) {
        M5.m.e(objArr, "elements");
        return C1881l.T(objArr);
    }
}
