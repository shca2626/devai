package E0;

import java.util.concurrent.Executor;

/* renamed from: E0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0316a {

    /* renamed from: a, reason: collision with root package name */
    public static Executor f2128a;

    public static synchronized Executor a() {
        try {
            if (f2128a == null) {
                f2128a = U.Q0("ExoPlayer:BackgroundExecutor");
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2128a;
    }
}
