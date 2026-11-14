package w2;

import C2.g;
import C2.l;
import M5.m;
import android.content.Context;
import android.net.ConnectivityManager;

/* loaded from: classes.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f23301a = a.f23302a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f23302a = new a();

        public final c a(Context context, boolean z7, b bVar, l lVar) {
            m.e(context, "context");
            m.e(bVar, "listener");
            if (!z7) {
                return C1729a.f23299b;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) L.b.h(context, ConnectivityManager.class);
            if (connectivityManager == null || L.b.a(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                if (lVar != null && lVar.a() <= 5) {
                    lVar.b("NetworkObserver", 5, "Unable to register network observer.", null);
                }
                return C1729a.f23299b;
            }
            try {
                return new d(connectivityManager, bVar);
            } catch (Exception e7) {
                if (lVar != null) {
                    g.a(lVar, "NetworkObserver", new RuntimeException("Failed to register network observer.", e7));
                }
                return C1729a.f23299b;
            }
        }
    }

    public interface b {
        void a(boolean z7);
    }

    boolean a();

    void shutdown();
}
