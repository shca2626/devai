package p3;

import java.util.concurrent.Executor;

/* renamed from: p3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC1443a implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
