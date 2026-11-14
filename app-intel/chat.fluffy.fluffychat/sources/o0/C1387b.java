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
public class C1387b {

    /* renamed from: b, reason: collision with root package name */
    public final Context f20321b;

    /* renamed from: c, reason: collision with root package name */
    public final Intent f20322c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20323d;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f20328i;

    /* renamed from: a, reason: collision with root package name */
    public Messenger f20320a = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20324e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20325f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20326g = false;

    /* renamed from: h, reason: collision with root package name */
    public final Queue f20327h = new ArrayDeque();

    /* renamed from: j, reason: collision with root package name */
    public final ServiceConnection f20329j = new a();

    /* renamed from: o0.b$a */
    public class a implements ServiceConnection {

        /* renamed from: o0.b$a$a, reason: collision with other inner class name */
        public class RunnableC0232a implements Runnable {
            public RunnableC0232a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
                C1387b.this.f20325f = true;
            }
        }

        /* renamed from: o0.b$a$b, reason: collision with other inner class name */
        public class RunnableC0233b implements Runnable {

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ ComponentName f20332l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ IBinder f20333m;

            public RunnableC0233b(ComponentName componentName, IBinder iBinder) {
                this.f20332l = componentName;
                this.f20333m = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() throws RemoteException {
                C1387b c1387b = C1387b.this;
                c1387b.f20324e = false;
                if (!AbstractC1392g.a(c1387b.f20321b, this.f20332l.getPackageName())) {
                    a.this.a();
                    C1387b.this.f20325f = true;
                } else {
                    C1387b.this.f20320a = new Messenger(this.f20333m);
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
                C1387b c1387b = C1387b.this;
                c1387b.f20324e = true;
                c1387b.f20320a = null;
            }
        }

        public a() {
        }

        public void a() {
            while (!C1387b.this.f20327h.isEmpty()) {
                ((C1393h) C1387b.this.f20327h.poll()).c();
            }
        }

        public void b() throws RemoteException {
            while (!C1387b.this.f20327h.isEmpty()) {
                C1387b c1387b = C1387b.this;
                c1387b.e((C1393h) c1387b.f20327h.poll());
            }
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            C1387b.this.f20328i.execute(new RunnableC0232a());
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1387b.this.f20328i.execute(new RunnableC0233b(componentName, iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1387b.this.f20328i.execute(new c());
        }
    }

    public C1387b(Executor executor, Context context, Intent intent, int i7) {
        if (executor == null) {
            throw new NullPointerException("executor must not be null");
        }
        if (context == null) {
            throw new NullPointerException("context must not be null");
        }
        if (intent == null) {
            throw new NullPointerException("bindIntent must not be null");
        }
        this.f20328i = executor;
        this.f20321b = context;
        this.f20322c = intent;
        this.f20323d = i7;
    }

    public void a() {
        if (this.f20326g) {
            throw new IllegalStateException("Each BufferedServiceConnection can only be bound once.");
        }
        this.f20326g = true;
        this.f20321b.bindService(this.f20322c, this.f20329j, this.f20323d);
    }

    public boolean b() {
        return this.f20324e;
    }

    public boolean c() {
        return this.f20325f;
    }

    public void d(C1393h c1393h) {
        if (this.f20325f) {
            c1393h.c();
        } else {
            if (this.f20320a != null) {
                e(c1393h);
                return;
            }
            while (this.f20327h.size() >= 100) {
                ((C1393h) this.f20327h.poll()).b(3, null);
            }
            this.f20327h.add(c1393h);
        }
    }

    public void e(C1393h c1393h) throws RemoteException {
        try {
            this.f20320a.send(c1393h.a());
            c1393h.c();
        } catch (TransactionTooLargeException e7) {
            c1393h.b(2, e7);
        } catch (RemoteException e8) {
            c1393h.b(1, e8);
        }
    }

    public void f() {
        if (!this.f20326g) {
            throw new IllegalStateException("bindService must be called before unbind");
        }
        this.f20325f = true;
        this.f20321b.unbindService(this.f20329j);
    }
}
