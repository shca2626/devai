package X4;

import h5.b;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import u5.C1668d;

/* loaded from: classes.dex */
public class c implements h5.b, X4.e {

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f9318a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f9319b;

    /* renamed from: c, reason: collision with root package name */
    public Map f9320c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9321d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f9322e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f9323f;

    /* renamed from: g, reason: collision with root package name */
    public int f9324g;

    /* renamed from: h, reason: collision with root package name */
    public final d f9325h;

    /* renamed from: i, reason: collision with root package name */
    public WeakHashMap f9326i;

    /* renamed from: j, reason: collision with root package name */
    public i f9327j;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f9328a;

        /* renamed from: b, reason: collision with root package name */
        public int f9329b;

        /* renamed from: c, reason: collision with root package name */
        public long f9330c;

        public b(ByteBuffer byteBuffer, int i7, long j7) {
            this.f9328a = byteBuffer;
            this.f9329b = i7;
            this.f9330c = j7;
        }
    }

    /* renamed from: X4.c$c, reason: collision with other inner class name */
    public static class C0081c implements d {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorService f9331a;

        public C0081c(ExecutorService executorService) {
            this.f9331a = executorService;
        }

        @Override // X4.c.d
        public void a(Runnable runnable) {
            this.f9331a.execute(runnable);
        }
    }

    public interface d {
        void a(Runnable runnable);
    }

    public static class e implements i {

        /* renamed from: a, reason: collision with root package name */
        public ExecutorService f9332a = U4.a.e().b();

        @Override // X4.c.i
        public d a(b.d dVar) {
            return dVar.a() ? new h(this.f9332a) : new C0081c(this.f9332a);
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final b.a f9333a;

        /* renamed from: b, reason: collision with root package name */
        public final d f9334b;

        public f(b.a aVar, d dVar) {
            this.f9333a = aVar;
            this.f9334b = dVar;
        }
    }

    public static class g implements b.InterfaceC0193b {

        /* renamed from: a, reason: collision with root package name */
        public final FlutterJNI f9335a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9336b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f9337c = new AtomicBoolean(false);

        public g(FlutterJNI flutterJNI, int i7) {
            this.f9335a = flutterJNI;
            this.f9336b = i7;
        }

        @Override // h5.b.InterfaceC0193b
        public void a(ByteBuffer byteBuffer) {
            if (this.f9337c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f9335a.invokePlatformMessageEmptyResponseCallback(this.f9336b);
            } else {
                this.f9335a.invokePlatformMessageResponseCallback(this.f9336b, byteBuffer, byteBuffer.position());
            }
        }
    }

    public static class h implements d {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorService f9338a;

        /* renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue f9339b = new ConcurrentLinkedQueue();

        /* renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f9340c = new AtomicBoolean(false);

        public h(ExecutorService executorService) {
            this.f9338a = executorService;
        }

        @Override // X4.c.d
        public void a(Runnable runnable) {
            this.f9339b.add(runnable);
            this.f9338a.execute(new X4.d(this));
        }

        public final void c() {
            if (this.f9340c.compareAndSet(false, true)) {
                try {
                    Runnable runnable = (Runnable) this.f9339b.poll();
                    if (runnable != null) {
                        runnable.run();
                    }
                } finally {
                    this.f9340c.set(false);
                    if (!this.f9339b.isEmpty()) {
                        this.f9338a.execute(new X4.d(this));
                    }
                }
            }
        }
    }

    public interface i {
        d a(b.d dVar);
    }

    public static class j implements b.c {
        public j() {
        }
    }

    public c(FlutterJNI flutterJNI, i iVar) {
        this.f9319b = new HashMap();
        this.f9320c = new HashMap();
        this.f9321d = new Object();
        this.f9322e = new AtomicBoolean(false);
        this.f9323f = new HashMap();
        this.f9324g = 1;
        this.f9325h = new X4.f();
        this.f9326i = new WeakHashMap();
        this.f9318a = flutterJNI;
        this.f9327j = iVar;
    }

    public static /* synthetic */ void i(c cVar, String str, int i7, f fVar, ByteBuffer byteBuffer, long j7) {
        cVar.getClass();
        C1668d.i("PlatformChannel ScheduleHandler on " + str, i7);
        try {
            C1668d c1668dJ = C1668d.j("DartMessenger#handleMessageFromDart on " + str);
            try {
                cVar.l(fVar, byteBuffer, i7);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
                if (c1668dJ != null) {
                    c1668dJ.close();
                }
            } finally {
            }
        } finally {
            cVar.f9318a.cleanupMessageData(j7);
        }
    }

    public static void k(Error error) {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, error);
    }

    @Override // h5.b
    public b.c a(b.d dVar) {
        d dVarA = this.f9327j.a(dVar);
        j jVar = new j();
        this.f9326i.put(jVar, dVarA);
        return jVar;
    }

    @Override // h5.b
    public void b(String str, b.a aVar) {
        f(str, aVar, null);
    }

    @Override // h5.b
    public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0193b interfaceC0193b) {
        C1668d c1668dJ = C1668d.j("DartMessenger#send on " + str);
        try {
            U4.b.f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i7 = this.f9324g;
            this.f9324g = i7 + 1;
            if (interfaceC0193b != null) {
                this.f9323f.put(Integer.valueOf(i7), interfaceC0193b);
            }
            if (byteBuffer == null) {
                this.f9318a.dispatchEmptyPlatformMessage(str, i7);
            } else {
                this.f9318a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i7);
            }
            if (c1668dJ != null) {
                c1668dJ.close();
            }
        } catch (Throwable th) {
            if (c1668dJ != null) {
                try {
                    c1668dJ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // h5.b
    public void e(String str, ByteBuffer byteBuffer) {
        U4.b.f("DartMessenger", "Sending message over channel '" + str + "'");
        d(str, byteBuffer, null);
    }

    @Override // h5.b
    public void f(String str, b.a aVar, b.c cVar) {
        d dVar;
        if (aVar == null) {
            U4.b.f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f9321d) {
                this.f9319b.remove(str);
            }
            return;
        }
        if (cVar != null) {
            dVar = (d) this.f9326i.get(cVar);
            if (dVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            dVar = null;
        }
        U4.b.f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f9321d) {
            try {
                this.f9319b.put(str, new f(aVar, dVar));
                List<b> list = (List) this.f9320c.remove(str);
                if (list == null) {
                    return;
                }
                for (b bVar : list) {
                    j(str, (f) this.f9319b.get(str), bVar.f9328a, bVar.f9329b, bVar.f9330c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // X4.e
    public void g(int i7, ByteBuffer byteBuffer) {
        U4.b.f("DartMessenger", "Received message reply from Dart.");
        b.InterfaceC0193b interfaceC0193b = (b.InterfaceC0193b) this.f9323f.remove(Integer.valueOf(i7));
        if (interfaceC0193b != null) {
            try {
                U4.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                interfaceC0193b.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e7) {
                k(e7);
            } catch (Exception e8) {
                U4.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e8);
            }
        }
    }

    @Override // X4.e
    public void h(String str, ByteBuffer byteBuffer, int i7, long j7) {
        f fVar;
        boolean z7;
        U4.b.f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f9321d) {
            try {
                fVar = (f) this.f9319b.get(str);
                z7 = this.f9322e.get() && fVar == null;
                if (z7) {
                    if (!this.f9320c.containsKey(str)) {
                        this.f9320c.put(str, new LinkedList());
                    }
                    ((List) this.f9320c.get(str)).add(new b(byteBuffer, i7, j7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            return;
        }
        j(str, fVar, byteBuffer, i7, j7);
    }

    public final void j(final String str, final f fVar, final ByteBuffer byteBuffer, final int i7, final long j7) {
        d dVar = fVar != null ? fVar.f9334b : null;
        C1668d.d("PlatformChannel ScheduleHandler on " + str, i7);
        Runnable runnable = new Runnable() { // from class: X4.b
            @Override // java.lang.Runnable
            public final void run() {
                c.i(this.f9312l, str, i7, fVar, byteBuffer, j7);
            }
        };
        if (dVar == null) {
            dVar = this.f9325h;
        }
        dVar.a(runnable);
    }

    public final void l(f fVar, ByteBuffer byteBuffer, int i7) {
        if (fVar == null) {
            U4.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
            this.f9318a.invokePlatformMessageEmptyResponseCallback(i7);
            return;
        }
        try {
            U4.b.f("DartMessenger", "Deferring to registered handler to process message.");
            fVar.f9333a.a(byteBuffer, new g(this.f9318a, i7));
        } catch (Error e7) {
            k(e7);
        } catch (Exception e8) {
            U4.b.c("DartMessenger", "Uncaught exception in binary message listener", e8);
            this.f9318a.invokePlatformMessageEmptyResponseCallback(i7);
        }
    }

    public c(FlutterJNI flutterJNI) {
        this(flutterJNI, new e());
    }
}
