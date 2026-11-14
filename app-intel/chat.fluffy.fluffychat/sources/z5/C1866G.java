package z5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import y5.C1812h;

/* renamed from: z5.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1866G extends C1865F {
    public static Map h() {
        C1895z c1895z = C1895z.f24204l;
        M5.m.c(c1895z, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c1895z;
    }

    public static Object i(Map map, Object obj) {
        M5.m.e(map, "<this>");
        return C1864E.a(map, obj);
    }

    public static HashMap j(C1812h... c1812hArr) {
        M5.m.e(c1812hArr, "pairs");
        HashMap map = new HashMap(C1865F.e(c1812hArr.length));
        p(map, c1812hArr);
        return map;
    }

    public static Map k(C1812h... c1812hArr) {
        M5.m.e(c1812hArr, "pairs");
        return c1812hArr.length > 0 ? t(c1812hArr, new LinkedHashMap(C1865F.e(c1812hArr.length))) : h();
    }

    public static Map l(C1812h... c1812hArr) {
        M5.m.e(c1812hArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(C1865F.e(c1812hArr.length));
        p(linkedHashMap, c1812hArr);
        return linkedHashMap;
    }

    public static final Map m(Map map) {
        M5.m.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : C1865F.g(map) : h();
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
            C1812h c1812h = (C1812h) it.next();
            map.put(c1812h.a(), c1812h.b());
        }
    }

    public static final void p(Map map, C1812h[] c1812hArr) {
        M5.m.e(map, "<this>");
        M5.m.e(c1812hArr, "pairs");
        for (C1812h c1812h : c1812hArr) {
            map.put(c1812h.a(), c1812h.b());
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
            return r(iterable, new LinkedHashMap(C1865F.e(collection.size())));
        }
        return C1865F.f((C1812h) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
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
        return size != 0 ? size != 1 ? u(map) : C1865F.g(map) : h();
    }

    public static final Map t(C1812h[] c1812hArr, Map map) {
        M5.m.e(c1812hArr, "<this>");
        M5.m.e(map, "destination");
        p(map, c1812hArr);
        return map;
    }

    public static Map u(Map map) {
        M5.m.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
