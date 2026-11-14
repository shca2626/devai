package b6;

import java.util.Collection;
import java.util.ServiceLoader;

/* renamed from: b6.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0871f {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection f13779a = U5.k.m(U5.h.b(ServiceLoader.load(W5.K.class, W5.K.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return f13779a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        try {
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
        } catch (Throwable unused) {
        }
    }
}
