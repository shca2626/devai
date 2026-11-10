package o0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/* renamed from: o0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1388b {

    /* renamed from: b, reason: collision with root package name */
    public final Context f20322b;

    /* renamed from: c, reason: collision with root package name */
    public final Intent f20323c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20324d;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f20329i;

    /* renamed from: a, reason: collision with root package name */
    public Messenger f20321a = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20325e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20326f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20327g = false;

    /* renamed from: h, reason: collision with root package name */
    public final Queue f20328h = new ArrayDeque();

    /* renamed from: j, reason: collision with root package name */
    public final ServiceConnection f20330j = new a();

    /* renamed from: o0.b$a */
    public class a implements ServiceConnection {

        /* renamed from: o0.b$a$a, reason: collision with other inner class name */
        public class RunnableC0232a implements Runnable {
            public RunnableC0232a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
                C1388b.this.f20326f = true;
            }
        }

        /* renamed from: o0.b$a$b, reason: collision with other inner class name */
        public class RunnableC0233b implements Runnable {

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ ComponentName f20333l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ IBinder f20334m;

            public RunnableC0233b(ComponentName componentName, IBinder iBinder) {
                this.f20333l = componentName;
                this.f20334m = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() throws RemoteException {
                C1388b c1388b = C1388b.this;
                c1388b.f20325e = false;
                if (!AbstractC1393g.a(c1388b.f20322b, this.f20333l.getPackageName())) {
                    a.this.a();
                    C1388b.this.f20326f = true;
                } else {
                    C1388b.this.f20321a = new Messenger(this.f20334m);
                    a.this.b();
                }
            }
        }

        /* renamed from: o0.b$a$c */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1388b c1388b = C1388b.this;
                c1388b.f20325e = true;
                c1388b.f20321a = null;
            }
        }

        public a() {
        }

        public void a() {
            while (!C1388b.this.f20328h.isEmpty()) {
                ((C1394h) C1388b.this.f20328h.poll()).c();
            }
        }

        public void b() throws RemoteException {
            while (!C1388b.this.f20328h.isEmpty()) {
                C1388b c1388b = C1388b.this;
                c1388b.e((C1394h) c1388b.f20328h.poll());
            }
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            C1388b.this.f20329i.execute(new RunnableC0232a());
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1388b.this.f20329i.execute(new RunnableC0233b(componentName, iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1388b.this.f20329i.execute(new c());
        }
    }

    public C1388b(Executor executor, Context context, Intent intent, int i7) {
        if (executor == null) {
            throw new NullPointerException("executor must not be null");
        }
        if (context == null) {
            throw new NullPointerException("context must not be null");
        }
        if (intent == null) {
            throw new NullPointerException("bindIntent must not be null");
        }
        this.f20329i = executor;
        this.f20322b = context;
        this.f20323c = intent;
        this.f20324d = i7;
    }

    public void a() {
        if (this.f20327g) {
            throw new IllegalStateException("Each BufferedServiceConnection can only be bound once.");
        }
        this.f20327g = true;
        this.f20322b.bindService(this.f20323c, this.f20330j, this.f20324d);
    }

    public boolean b() {
        return this.f20325e;
    }

    public boolean c() {
        return this.f20326f;
    }

    public void d(C1394h c1394h) {
        if (this.f20326f) {
            c1394h.c();
        } else {
            if (this.f20321a != null) {
                e(c1394h);
                return;
            }
            while (this.f20328h.size() >= 100) {
                ((C1394h) this.f20328h.poll()).b(3, null);
            }
            this.f20328h.add(c1394h);
        }
    }

    public void e(C1394h c1394h) throws RemoteException {
        try {
            this.f20321a.send(c1394h.a());
            c1394h.c();
        } catch (TransactionTooLargeException e7) {
            c1394h.b(2, e7);
        } catch (RemoteException e8) {
            c1394h.b(1, e8);
        }
    }

    public void f() {
        if (!this.f20327g) {
            throw new IllegalStateException("bindService must be called before unbind");
        }
        this.f20326f = true;
        this.f20322b.unbindService(this.f20330j);
    }
}
