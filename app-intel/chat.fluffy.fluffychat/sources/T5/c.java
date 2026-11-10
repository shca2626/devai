package T5;

import M5.m;

/* loaded from: classes.dex */
public abstract class c {
    public static final Object a(b bVar, Object obj) {
        m.e(bVar, "<this>");
        if (bVar.c(obj)) {
            m.c(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + bVar.a());
    }
}
