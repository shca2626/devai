package W5;

import b6.C0852E;

/* renamed from: W5.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0629k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0852E f9159a = new C0852E("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    public static final C0852E f9160b = new C0852E("CLOSED_EMPTY");

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
