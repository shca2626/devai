package O4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import h5.c;
import java.util.List;

/* loaded from: classes.dex */
public class d extends BroadcastReceiver implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public final Context f7303l;

    /* renamed from: m, reason: collision with root package name */
    public final O4.a f7304m;

    /* renamed from: n, reason: collision with root package name */
    public c.b f7305n;

    /* renamed from: o, reason: collision with root package name */
    public final Handler f7306o = new Handler(Looper.getMainLooper());

    /* renamed from: p, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f7307p;

    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            d dVar = d.this;
            dVar.j(dVar.f7304m.a(network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            d dVar = d.this;
            dVar.j(dVar.f7304m.b(networkCapabilities));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            d.this.i();
        }
    }

    public d(Context context, O4.a aVar) {
        this.f7303l = context;
        this.f7304m = aVar;
    }

    public final /* synthetic */ void f() {
        this.f7305n.success(this.f7304m.d());
    }

    public final /* synthetic */ void g(List list) {
        this.f7305n.success(list);
    }

    public void h() {
        if (this.f7307p != null) {
            try {
                this.f7304m.c().unregisterNetworkCallback(this.f7307p);
            } catch (Exception unused) {
            } finally {
                this.f7307p = null;
            }
        }
    }

    public final void i() {
        this.f7306o.postDelayed(new Runnable() { // from class: O4.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f7302l.f();
            }
        }, 500L);
    }

    public final void j(final List list) {
        this.f7306o.post(new Runnable() { // from class: O4.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f7300l.g(list);
            }
        });
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        h();
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        this.f7305n = bVar;
        this.f7307p = new a();
        this.f7304m.c().registerDefaultNetworkCallback(this.f7307p);
        j(this.f7304m.d());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.b bVar = this.f7305n;
        if (bVar != null) {
            bVar.success(this.f7304m.d());
        }
    }
}
