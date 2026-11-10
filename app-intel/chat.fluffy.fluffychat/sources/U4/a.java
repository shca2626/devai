package U4;

import a5.C0765d;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static a f8446d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f8447e;

    /* renamed from: a, reason: collision with root package name */
    public C0765d f8448a;

    /* renamed from: b, reason: collision with root package name */
    public FlutterJNI.c f8449b;

    /* renamed from: c, reason: collision with root package name */
    public ExecutorService f8450c;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public C0765d f8451a;

        /* renamed from: b, reason: collision with root package name */
        public FlutterJNI.c f8452b;

        /* renamed from: c, reason: collision with root package name */
        public ExecutorService f8453c;

        /* renamed from: U4.a$b$a, reason: collision with other inner class name */
        public class ThreadFactoryC0070a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            public int f8454a;

            public ThreadFactoryC0070a() {
                this.f8454a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i7 = this.f8454a;
                this.f8454a = i7 + 1;
                sb.append(i7);
                thread.setName(sb.toString());
                return thread;
            }
        }

        public a a() {
            b();
            return new a(this.f8451a, null, this.f8452b, this.f8453c);
        }

        public final void b() {
            if (this.f8452b == null) {
                this.f8452b = new FlutterJNI.c();
            }
            if (this.f8453c == null) {
                this.f8453c = Executors.newCachedThreadPool(new ThreadFactoryC0070a());
            }
            if (this.f8451a == null) {
                this.f8451a = new C0765d(this.f8452b.a(), this.f8453c);
            }
        }
    }

    public static a e() {
        f8447e = true;
        if (f8446d == null) {
            f8446d = new b().a();
        }
        return f8446d;
    }

    public Y4.a a() {
        return null;
    }

    public ExecutorService b() {
        return this.f8450c;
    }

    public C0765d c() {
        return this.f8448a;
    }

    public FlutterJNI.c d() {
        return this.f8449b;
    }

    public a(C0765d c0765d, Y4.a aVar, FlutterJNI.c cVar, ExecutorService executorService) {
        this.f8448a = c0765d;
        this.f8449b = cVar;
        this.f8450c = executorService;
    }
}
