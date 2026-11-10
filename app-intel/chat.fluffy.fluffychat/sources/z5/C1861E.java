package z5;

import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: z5.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1861E {
    public static final Object a(Map map, Object obj) {
        M5.m.e(map, "<this>");
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
