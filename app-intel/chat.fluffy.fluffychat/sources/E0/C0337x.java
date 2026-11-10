package E0;

import E0.C0337x;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* renamed from: E0.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0337x {

    /* renamed from: f, reason: collision with root package name */
    public static C0337x f2218f;

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2219a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f2220b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2221c;

    /* renamed from: d, reason: collision with root package name */
    public int f2222d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2223e;

    /* renamed from: E0.x$b */
    public static final class b {

        /* renamed from: E0.x$b$a */
        public static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* renamed from: a, reason: collision with root package name */
            public final C0337x f2224a;

            public a(C0337x c0337x) {
                this.f2224a = c0337x;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f2224a.m(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, C0337x c0337x) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) j3.o.q((TelephonyManager) context.getSystemService("phone"));
                a aVar = new a(c0337x);
                telephonyManager.registerTelephonyCallback(c0337x.f2219a, aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                c0337x.m(5);
            }
        }
    }

    /* renamed from: E0.x$c */
    public interface c {
        void a(int i7);
    }

    /* renamed from: E0.x$d */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f2225a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f2226b;

        public d(c cVar, Executor executor) {
            this.f2225a = new WeakReference(cVar);
            this.f2226b = executor;
        }

        public static /* synthetic */ void a(d dVar) {
            c cVar = (c) dVar.f2225a.get();
            if (cVar != null) {
                cVar.a(C0337x.this.g());
            }
        }

        public void b() {
            this.f2226b.execute(new Runnable() { // from class: E0.B
                @Override // java.lang.Runnable
                public final void run() {
                    C0337x.d.a(this.f2016l);
                }
            });
        }

        public boolean c() {
            return this.f2225a.get() == null;
        }
    }

    /* renamed from: E0.x$e */
    public final class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            C0337x.this.f2219a.execute(new Runnable() { // from class: E0.C
                @Override // java.lang.Runnable
                public final void run() {
                    C0337x.this.i(context);
                }
            });
        }
    }

    public C0337x(final Context context) {
        Executor executorA = AbstractC0315a.a();
        this.f2219a = executorA;
        this.f2220b = new CopyOnWriteArrayList();
        this.f2221c = new Object();
        this.f2222d = 0;
        executorA.execute(new Runnable() { // from class: E0.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f2216l.j(context);
            }
        });
    }

    public static synchronized C0337x e(Context context) {
        try {
            if (f2218f == null) {
                f2218f = new C0337x(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2218f;
    }

    public static int f(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case StdKeyDeserializer.TYPE_URL /* 14 */:
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
            case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return Build.VERSION.SDK_INT >= 29 ? 9 : 0;
        }
    }

    public static int h(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i7 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i7 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return f(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i7;
    }

    public int g() {
        int i7;
        synchronized (this.f2221c) {
            i7 = this.f2222d;
        }
        return i7;
    }

    public final void i(Context context) {
        int iH = h(context);
        if (Build.VERSION.SDK_INT < 31 || iH != 5) {
            m(iH);
        } else {
            b.a(context, this);
        }
    }

    public final void j(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new e(), intentFilter);
    }

    public void k(c cVar, Executor executor) {
        boolean z7;
        l();
        d dVar = new d(cVar, executor);
        synchronized (this.f2221c) {
            this.f2220b.add(dVar);
            z7 = this.f2223e;
        }
        if (z7) {
            dVar.b();
        }
    }

    public final void l() {
        Iterator it = this.f2220b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.c()) {
                this.f2220b.remove(dVar);
            }
        }
    }

    public final void m(int i7) {
        l();
        synchronized (this.f2221c) {
            try {
                if (this.f2223e && this.f2222d == i7) {
                    return;
                }
                this.f2223e = true;
                this.f2222d = i7;
                Iterator it = this.f2220b.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
