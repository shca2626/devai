package z5;

import java.util.Collections;
import java.util.Map;
import y5.C1812h;

/* renamed from: z5.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1865F extends C1864E {
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

    public static Map f(C1812h c1812h) {
        M5.m.e(c1812h, "pair");
        Map mapSingletonMap = Collections.singletonMap(c1812h.c(), c1812h.d());
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
