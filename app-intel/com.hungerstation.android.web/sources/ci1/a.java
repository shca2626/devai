package ci1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes6.dex */
public final class a {
    private static int a(int i12) {
        if (i12 < 3) {
            return i12 + 1;
        }
        if (i12 < 1073741824) {
            return (int) ((i12 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    static <T> HashSet<T> b(int i12) {
        return new HashSet<>(a(i12));
    }

    public static <K, V> LinkedHashMap<K, V> c(int i12) {
        return new LinkedHashMap<>(a(i12));
    }

    public static <T> List<T> d(int i12) {
        return i12 == 0 ? Collections.emptyList() : new ArrayList(i12);
    }
}
