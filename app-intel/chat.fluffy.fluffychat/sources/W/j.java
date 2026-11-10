package W;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class j {

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public String f8935a;

        /* renamed from: b, reason: collision with root package name */
        public int f8936b;

        /* renamed from: W.j$a$a, reason: collision with other inner class name */
        public static class C0074a extends Thread {

            /* renamed from: l, reason: collision with root package name */
            public final int f8937l;

            public C0074a(Runnable runnable, String str, int i7) {
                super(runnable, str);
                this.f8937l = i7;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f8937l);
                super.run();
            }
        }

        public a(String str, int i7) {
            this.f8935a = str;
            this.f8936b = i7;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0074a(runnable, this.f8935a, this.f8936b);
        }
    }

    public static class b implements Executor {

        /* renamed from: l, reason: collision with root package name */
        public final Handler f8938l;

        public b(Handler handler) {
            this.f8938l = (Handler) Y.h.j(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f8938l.post((Runnable) Y.h.j(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f8938l + " is shutting down");
        }
    }

    public static class c implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public Callable f8939l;

        /* renamed from: m, reason: collision with root package name */
        public Y.a f8940m;

        /* renamed from: n, reason: collision with root package name */
        public Handler f8941n;

        public class a implements Runnable {

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ Y.a f8942l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ Object f8943m;

            public a(Y.a aVar, Object obj) {
                this.f8942l = aVar;
                this.f8943m = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8942l.accept(this.f8943m);
            }
        }

        public c(Handler handler, Callable callable, Y.a aVar) {
            this.f8939l = callable;
            this.f8940m = aVar;
            this.f8941n = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            Object objCall;
            try {
                objCall = this.f8939l.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f8941n.post(new a(this.f8940m, objCall));
        }
    }

    public static ThreadPoolExecutor a(String str, int i7, int i8) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i8, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i7));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b(Handler handler) {
        return new b(handler);
    }

    public static void c(Executor executor, Callable callable, Y.a aVar) {
        executor.execute(new c(W.b.a(), callable, aVar));
    }

    public static Object d(ExecutorService executorService, Callable callable, int i7) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i7, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e7) {
            throw e7;
        } catch (ExecutionException e8) {
            throw new RuntimeException(e8);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
