package V;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public abstract class g {

    public static class a implements Executor {

        /* renamed from: l, reason: collision with root package name */
        public final Handler f8486l;

        public a(Handler handler) {
            this.f8486l = (Handler) Y.h.j(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f8486l.post((Runnable) Y.h.j(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f8486l + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
