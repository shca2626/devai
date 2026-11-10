package k0;

import M5.m;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import z5.C1889w;

/* renamed from: k0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1245a {
    public static final Set a(Set set) {
        m.e(set, "set");
        Set setUnmodifiableSet = Collections.unmodifiableSet(C1889w.b0(set));
        m.d(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final Map b(Map map) {
        m.e(map, "map");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        m.d(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }
}
