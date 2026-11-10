package d6;

import b6.AbstractC0853F;
import b6.AbstractC0855H;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f15277a = AbstractC0853F.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b, reason: collision with root package name */
    public static final long f15278b = AbstractC0855H.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f15279c = AbstractC0855H.e("kotlinx.coroutines.scheduler.core.pool.size", S5.e.b(AbstractC0853F.a(), 2), 1, 0, 8, null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f15280d = AbstractC0855H.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* renamed from: e, reason: collision with root package name */
    public static final long f15281e = TimeUnit.SECONDS.toNanos(AbstractC0855H.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* renamed from: f, reason: collision with root package name */
    public static g f15282f = C1005e.f15268a;

    public static final h b(Runnable runnable, long j7, boolean z7) {
        return new i(runnable, j7, z7);
    }

    public static final String c(boolean z7) {
        return z7 ? "Blocking" : "Non-blocking";
    }
}
