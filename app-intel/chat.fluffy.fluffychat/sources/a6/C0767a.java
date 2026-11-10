package a6;

import java.util.concurrent.CancellationException;

/* renamed from: a6.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0767a extends CancellationException {

    /* renamed from: l, reason: collision with root package name */
    public final transient Object f10851l;

    public C0767a(Object obj) {
        super("Flow was aborted, no more elements needed");
        this.f10851l = obj;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
