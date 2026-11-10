package z5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: z5.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1885s extends C1884r {
    public static void p(List list, Comparator comparator) {
        M5.m.e(list, "<this>");
        M5.m.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
