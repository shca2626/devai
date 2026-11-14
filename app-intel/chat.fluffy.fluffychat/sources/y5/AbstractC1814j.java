package y5;

import y5.C1813i;

/* renamed from: y5.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1814j {
    public static final Object a(Throwable th) {
        M5.m.e(th, "exception");
        return new C1813i.b(th);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof C1813i.b) {
            throw ((C1813i.b) obj).f24012l;
        }
    }
}
