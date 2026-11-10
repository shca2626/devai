package z5;

import java.util.Collections;
import java.util.Set;

/* renamed from: z5.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1864H {
    public static Set a(Set set) {
        M5.m.e(set, "builder");
        return ((A5.h) set).g();
    }

    public static Set b() {
        return new A5.h();
    }

    public static Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        M5.m.d(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
