package w2;

import M5.m;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import w2.c;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f23303b;

    /* renamed from: c, reason: collision with root package name */
    public final c.b f23304c;

    /* renamed from: d, reason: collision with root package name */
    public final a f23305d;

    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            m.e(network, "network");
            d.this.d(network, true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            m.e(network, "network");
            d.this.d(network, false);
        }
    }

    public d(ConnectivityManager connectivityManager, c.b bVar) {
        m.e(connectivityManager, "connectivityManager");
        m.e(bVar, "listener");
        this.f23303b = connectivityManager;
        this.f23304c = bVar;
        a aVar = new a();
        this.f23305d = aVar;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), aVar);
    }

    @Override // w2.c
    public boolean a() {
        Network[] allNetworks = this.f23303b.getAllNetworks();
        m.d(allNetworks, "connectivityManager.allNetworks");
        for (Network network : allNetworks) {
            m.d(network, "it");
            if (c(network)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Network network) {
        NetworkCapabilities networkCapabilities = this.f23303b.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    public final void d(Network network, boolean z7) {
        boolean zC;
        Network[] allNetworks = this.f23303b.getAllNetworks();
        m.d(allNetworks, "connectivityManager.allNetworks");
        int length = allNetworks.length;
        boolean z8 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                break;
            }
            Network network2 = allNetworks[i7];
            if (m.a(network2, network)) {
                zC = z7;
            } else {
                m.d(network2, "it");
                zC = c(network2);
            }
            if (zC) {
                z8 = true;
                break;
            }
            i7++;
        }
        this.f23304c.a(z8);
    }

    @Override // w2.c
    public void shutdown() {
        this.f23303b.unregisterNetworkCallback(this.f23305d);
    }
}
