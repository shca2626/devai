package z5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import y5.C1813h;

/* renamed from: z5.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1863G extends C1862F {
    public static Map h() {
        C1892z c1892z = C1892z.f24178l;
        M5.m.c(c1892z, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c1892z;
    }

    public static Object i(Map map, Object obj) {
        M5.m.e(map, "<this>");
        return C1861E.a(map, obj);
    }

    public static HashMap j(C1813h... c1813hArr) {
        M5.m.e(c1813hArr, "pairs");
        HashMap map = new HashMap(C1862F.e(c1813hArr.length));
        p(map, c1813hArr);
        return map;
    }

    public static Map k(C1813h... c1813hArr) {
        M5.m.e(c1813hArr, "pairs");
        return c1813hArr.length > 0 ? t(c1813hArr, new LinkedHashMap(C1862F.e(c1813hArr.length))) : h();
    }

    public static Map l(C1813h... c1813hArr) {
        M5.m.e(c1813hArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(C1862F.e(c1813hArr.length));
        p(linkedHashMap, c1813hArr);
        return linkedHashMap;
    }

    public static final Map m(Map map) {
        M5.m.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : C1862F.g(map) : h();
    }

    public static Map n(Map map, Map map2) {
        M5.m.e(map, "<this>");
        M5.m.e(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final void o(Map map, Iterable iterable) {
        M5.m.e(map, "<this>");
        M5.m.e(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C1813h c1813h = (C1813h) it.next();
            map.put(c1813h.a(), c1813h.b());
        }
    }

    public static final void p(Map map, C1813h[] c1813hArr) {
        M5.m.e(map, "<this>");
        M5.m.e(c1813hArr, "pairs");
        for (C1813h c1813h : c1813hArr) {
            map.put(c1813h.a(), c1813h.b());
        }
    }

    public static Map q(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m(r(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return r(iterable, new LinkedHashMap(C1862F.e(collection.size())));
        }
        return C1862F.f((C1813h) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final Map r(Iterable iterable, Map map) {
        M5.m.e(iterable, "<this>");
        M5.m.e(map, "destination");
        o(map, iterable);
        return map;
    }

    public static Map s(Map map) {
        M5.m.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? u(map) : C1862F.g(map) : h();
    }

    public static final Map t(C1813h[] c1813hArr, Map map) {
        M5.m.e(c1813hArr, "<this>");
        M5.m.e(map, "destination");
        p(map, c1813hArr);
        return map;
    }

    public static Map u(Map map) {
        M5.m.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
