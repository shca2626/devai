package z5;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: z5.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1866J extends C1865I {
    public static Set h(Set set, Iterable iterable) {
        M5.m.e(set, "<this>");
        M5.m.e(iterable, "elements");
        Collection<?> collectionS = C1886t.s(iterable);
        if (collectionS.isEmpty()) {
            return C1889w.b0(set);
        }
        if (!(collectionS instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionS);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!((Set) collectionS).contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }
}
