package z5;

import java.util.Collection;

/* renamed from: z5.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1885p extends C1884o {
    public static int o(Iterable iterable, int i7) {
        M5.m.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i7;
    }
}
