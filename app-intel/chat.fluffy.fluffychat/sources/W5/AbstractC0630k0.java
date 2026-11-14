package W5;

import b6.C0853E;

/* renamed from: W5.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0630k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0853E f9159a = new C0853E("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    public static final C0853E f9160b = new C0853E("CLOSED_EMPTY");

    public static final long c(long j7) {
        if (j7 <= 0) {
            return 0L;
        }
        if (j7 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j7 * 1000000;
    }
}
