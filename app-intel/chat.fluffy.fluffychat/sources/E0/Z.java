package E0;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    public final a f2121a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0329o f2122b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0329o f2123c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2124d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2125e;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2126a;

        /* renamed from: b, reason: collision with root package name */
        public PowerManager.WakeLock f2127b;

        public a(Context context) {
            this.f2126a = context;
        }

        public final void d(final AtomicBoolean atomicBoolean) {
            if (atomicBoolean.get()) {
                new Thread(new Runnable() { // from class: E0.Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2119l.e(atomicBoolean);
                    }
                }, "ExoPlayer:WakeLockManager").start();
            }
        }

        public final synchronized void e(AtomicBoolean atomicBoolean) {
            PowerManager.WakeLock wakeLock;
            if (atomicBoolean.get() && (wakeLock = this.f2127b) != null) {
                wakeLock.release();
            }
        }

        public final synchronized void f(boolean z7, boolean z8) {
            if (z7) {
                if (this.f2127b == null) {
                    if (this.f2126a.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                        AbstractC0332s.h("WakeLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                        return;
                    }
                    PowerManager powerManager = (PowerManager) this.f2126a.getSystemService("power");
                    if (powerManager == null) {
                        AbstractC0332s.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                        return;
                    } else {
                        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                        this.f2127b = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.setReferenceCounted(false);
                    }
                }
            }
            if (this.f2127b == null) {
                return;
            }
            if (Z.h(z7, z8)) {
                this.f2127b.acquire();
            } else {
                this.f2127b.release();
            }
        }
    }

    public Z(Context context, Looper looper, InterfaceC0321g interfaceC0321g) {
        this.f2121a = new a(context.getApplicationContext());
        this.f2122b = interfaceC0321g.c(looper, null);
        this.f2123c = interfaceC0321g.c(Looper.getMainLooper(), null);
    }

    public static /* synthetic */ void a(Z z7, AtomicBoolean atomicBoolean, boolean z8, boolean z9) {
        z7.getClass();
        atomicBoolean.set(false);
        z7.f2121a.f(z8, z9);
    }

    public static boolean h(boolean z7, boolean z8) {
        return z7 && z8;
    }

    public final void e(final boolean z7, final boolean z8) {
        if (h(z7, z8)) {
            this.f2122b.c(new Runnable() { // from class: E0.V
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2110l.f2121a.f(z7, z8);
                }
            });
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.f2123c.f(new Runnable() { // from class: E0.W
            @Override // java.lang.Runnable
            public final void run() {
                this.f2113l.f2121a.d(atomicBoolean);
            }
        }, 1000L);
        this.f2122b.c(new Runnable() { // from class: E0.X
            @Override // java.lang.Runnable
            public final void run() {
                Z.a(this.f2115l, atomicBoolean, z7, z8);
            }
        });
    }

    public void f(boolean z7) {
        if (this.f2124d == z7) {
            return;
        }
        this.f2124d = z7;
        e(z7, this.f2125e);
    }

    public void g(boolean z7) {
        if (this.f2125e == z7) {
            return;
        }
        this.f2125e = z7;
        if (this.f2124d) {
            e(true, z7);
        }
    }
}
