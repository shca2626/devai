package z5;

import java.util.Collections;
import java.util.Map;
import y5.C1813h;

/* renamed from: z5.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1862F extends C1861E {
    public static Map b(Map map) {
        M5.m.e(map, "builder");
        return ((A5.d) map).k();
    }

    public static Map c() {
        return new A5.d();
    }

    public static Map d(int i7) {
        return new A5.d(i7);
    }

    public static int e(int i7) {
        if (i7 < 0) {
            return i7;
        }
        if (i7 < 3) {
            return i7 + 1;
        }
        if (i7 < 1073741824) {
            return (int) ((i7 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map f(C1813h c1813h) {
        M5.m.e(c1813h, "pair");
        Map mapSingletonMap = Collections.singletonMap(c1813h.c(), c1813h.d());
        M5.m.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map g(Map map) {
        M5.m.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        M5.m.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
