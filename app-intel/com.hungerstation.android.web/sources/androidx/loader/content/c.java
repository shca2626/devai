package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
abstract class c<Result> {

    /* renamed from: f, reason: collision with root package name */
    private static Handler f8101f;

    /* renamed from: c, reason: collision with root package name */
    private volatile e f8103c = e.PENDING;

    /* renamed from: d, reason: collision with root package name */
    final AtomicBoolean f8104d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    final AtomicBoolean f8105e = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    private final FutureTask<Result> f8102b = new b(new a());

    class a implements Callable<Result> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            c.this.f8105e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) c.this.b();
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    class b extends FutureTask<Result> {
        b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                c.this.j(get());
            } catch (InterruptedException unused) {
            } catch (CancellationException unused2) {
                c.this.j(null);
            } catch (ExecutionException e12) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e12.getCause());
            } catch (Throwable th2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th2);
            }
        }
    }

    /* renamed from: androidx.loader.content.c$c, reason: collision with other inner class name */
    class RunnableC0159c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f8108b;

        RunnableC0159c(Object obj) {
            this.f8108b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(this.f8108b);
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8110a;

        static {
            int[] iArr = new int[e.values().length];
            f8110a = iArr;
            try {
                iArr[e.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8110a[e.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum e {
        PENDING,
        RUNNING,
        FINISHED
    }

    c() {
    }

    private static Handler e() {
        Handler handler;
        synchronized (c.class) {
            try {
                if (f8101f == null) {
                    f8101f = new Handler(Looper.getMainLooper());
                }
                handler = f8101f;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    public final boolean a(boolean z12) {
        this.f8104d.set(true);
        return this.f8102b.cancel(z12);
    }

    protected abstract Result b();

    public final void c(Executor executor) {
        if (this.f8103c == e.PENDING) {
            this.f8103c = e.RUNNING;
            executor.execute(this.f8102b);
            return;
        }
        int i12 = d.f8110a[this.f8103c.ordinal()];
        if (i12 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i12 == 2) {
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        throw new IllegalStateException("We should never reach this state");
    }

    void d(Result result) {
        if (f()) {
            g(result);
        } else {
            h(result);
        }
        this.f8103c = e.FINISHED;
    }

    public final boolean f() {
        return this.f8104d.get();
    }

    protected void g(Result result) {
    }

    protected void h(Result result) {
    }

    void i(Result result) {
        e().post(new RunnableC0159c(result));
    }

    void j(Result result) {
        if (this.f8105e.get()) {
            return;
        }
        i(result);
    }
}
