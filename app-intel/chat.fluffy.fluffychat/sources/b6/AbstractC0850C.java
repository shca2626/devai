package b6;

/* renamed from: b6.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0850C {
    public static final AbstractC0849B b(Object obj) {
        if (obj == AbstractC0866b.f13775a) {
            throw new IllegalStateException("Does not contain segment");
        }
        M5.m.c(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (AbstractC0849B) obj;
    }

    public static final boolean c(Object obj) {
        return obj == AbstractC0866b.f13775a;
    }

    public static Object a(Object obj) {
        return obj;
    }
}
