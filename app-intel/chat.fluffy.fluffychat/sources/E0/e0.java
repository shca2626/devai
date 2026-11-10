package E0;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f2152a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0329o f2153b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0329o f2154c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2155d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2156e;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2157a;

        /* renamed from: b, reason: collision with root package name */
        public WifiManager.WifiLock f2158b;

        public a(Context context) {
            this.f2157a = context;
        }

        public final void c(final AtomicBoolean atomicBoolean) {
            if (atomicBoolean.get()) {
                new Thread(new Runnable() { // from class: E0.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2144l.d(atomicBoolean);
                    }
                }, "ExoPlayer:WifiLockManager").start();
            }
        }

        public final synchronized void d(AtomicBoolean atomicBoolean) {
            WifiManager.WifiLock wifiLock;
            if (atomicBoolean.get() && (wifiLock = this.f2158b) != null) {
                wifiLock.release();
            }
        }

        public void e(boolean z7, boolean z8) {
            if (z7 && this.f2158b == null) {
                if (this.f2157a.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                    AbstractC0332s.h("WifiLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                    return;
                }
                WifiManager wifiManager = (WifiManager) this.f2157a.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    AbstractC0332s.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                    return;
                } else {
                    WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                    this.f2158b = wifiLockCreateWifiLock;
                    wifiLockCreateWifiLock.setReferenceCounted(false);
                }
            }
            if (this.f2158b == null) {
                return;
            }
            if (e0.h(z7, z8)) {
                this.f2158b.acquire();
            } else {
                this.f2158b.release();
            }
        }
    }

    public e0(Context context, Looper looper, InterfaceC0321g interfaceC0321g) {
        this.f2152a = new a(context.getApplicationContext());
        this.f2153b = interfaceC0321g.c(looper, null);
        this.f2154c = interfaceC0321g.c(Looper.getMainLooper(), null);
    }

    public static /* synthetic */ void a(e0 e0Var, AtomicBoolean atomicBoolean, boolean z7, boolean z8) {
        e0Var.getClass();
        atomicBoolean.set(false);
        e0Var.f2152a.e(z7, z8);
    }

    public static boolean h(boolean z7, boolean z8) {
        return z7 && z8;
    }

    public final void e(final boolean z7, final boolean z8) {
        if (h(z7, z8)) {
            this.f2153b.c(new Runnable() { // from class: E0.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2129l.f2152a.e(z7, z8);
                }
            });
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.f2154c.f(new Runnable() { // from class: E0.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2134l.f2152a.c(atomicBoolean);
            }
        }, 1000L);
        this.f2153b.c(new Runnable() { // from class: E0.c0
            @Override // java.lang.Runnable
            public final void run() {
                e0.a(this.f2138l, atomicBoolean, z7, z8);
            }
        });
    }

    public void f(boolean z7) {
        if (this.f2155d == z7) {
            return;
        }
        this.f2155d = z7;
        e(z7, this.f2156e);
    }

    public void g(boolean z7) {
        if (this.f2156e == z7) {
            return;
        }
        this.f2156e = z7;
        if (this.f2155d) {
            e(true, z7);
        }
    }
}
