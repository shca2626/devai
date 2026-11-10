package K;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import b.InterfaceC0816a;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: d, reason: collision with root package name */
    public static String f4958d;

    /* renamed from: g, reason: collision with root package name */
    public static f f4961g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4962a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f4963b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f4957c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static Set f4959e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f4960f = new Object();

    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    public static class b {
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        public static NotificationChannel b(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        public static List c(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    public static class c {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }

    public static class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public final String f4964a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4965b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4966c;

        /* renamed from: d, reason: collision with root package name */
        public final Notification f4967d;

        public d(String str, int i7, String str2, Notification notification) {
            this.f4964a = str;
            this.f4965b = i7;
            this.f4966c = str2;
            this.f4967d = notification;
        }

        @Override // K.r.g
        public void a(InterfaceC0816a interfaceC0816a) {
            interfaceC0816a.c(this.f4964a, this.f4965b, this.f4966c, this.f4967d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f4964a + ", id:" + this.f4965b + ", tag:" + this.f4966c + "]";
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f4968a;

        /* renamed from: b, reason: collision with root package name */
        public final IBinder f4969b;

        public e(ComponentName componentName, IBinder iBinder) {
            this.f4968a = componentName;
            this.f4969b = iBinder;
        }
    }

    public static class f implements Handler.Callback, ServiceConnection {

        /* renamed from: l, reason: collision with root package name */
        public final Context f4970l;

        /* renamed from: m, reason: collision with root package name */
        public final HandlerThread f4971m;

        /* renamed from: n, reason: collision with root package name */
        public final Handler f4972n;

        /* renamed from: o, reason: collision with root package name */
        public final Map f4973o = new HashMap();

        /* renamed from: p, reason: collision with root package name */
        public Set f4974p = new HashSet();

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ComponentName f4975a;

            /* renamed from: c, reason: collision with root package name */
            public InterfaceC0816a f4977c;

            /* renamed from: b, reason: collision with root package name */
            public boolean f4976b = false;

            /* renamed from: d, reason: collision with root package name */
            public ArrayDeque f4978d = new ArrayDeque();

            /* renamed from: e, reason: collision with root package name */
            public int f4979e = 0;

            public a(ComponentName componentName) {
                this.f4975a = componentName;
            }
        }

        public f(Context context) {
            this.f4970l = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f4971m = handlerThread;
            handlerThread.start();
            this.f4972n = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f4976b) {
                return true;
            }
            boolean zBindService = this.f4970l.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f4975a), this, 33);
            aVar.f4976b = zBindService;
            if (zBindService) {
                aVar.f4979e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f4975a);
                this.f4970l.unbindService(this);
            }
            return aVar.f4976b;
        }

        public final void b(a aVar) {
            if (aVar.f4976b) {
                this.f4970l.unbindService(this);
                aVar.f4976b = false;
            }
            aVar.f4977c = null;
        }

        public final void c(g gVar) {
            j();
            for (a aVar : this.f4973o.values()) {
                aVar.f4978d.add(gVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = (a) this.f4973o.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f4973o.get(componentName);
            if (aVar != null) {
                aVar.f4977c = InterfaceC0816a.AbstractBinderC0128a.e(iBinder);
                aVar.f4979e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = (a) this.f4973o.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f4975a + ", " + aVar.f4978d.size() + " queued tasks");
            }
            if (aVar.f4978d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f4977c == null) {
                i(aVar);
                return;
            }
            while (true) {
                g gVar = (g) aVar.f4978d.peek();
                if (gVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + gVar);
                    }
                    gVar.a(aVar.f4977c);
                    aVar.f4978d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f4975a);
                    }
                } catch (RemoteException e7) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f4975a, e7);
                }
            }
            if (aVar.f4978d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(g gVar) {
            this.f4972n.obtainMessage(0, gVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                c((g) message.obj);
                return true;
            }
            if (i7 == 1) {
                e eVar = (e) message.obj;
                e(eVar.f4968a, eVar.f4969b);
                return true;
            }
            if (i7 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i7 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f4972n.hasMessages(3, aVar.f4975a)) {
                return;
            }
            int i7 = aVar.f4979e;
            int i8 = i7 + 1;
            aVar.f4979e = i8;
            if (i8 <= 6) {
                int i9 = (1 << i7) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i9 + " ms");
                }
                this.f4972n.sendMessageDelayed(this.f4972n.obtainMessage(3, aVar.f4975a), i9);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f4978d.size() + " tasks to " + aVar.f4975a + " after " + aVar.f4979e + " retries");
            aVar.f4978d.clear();
        }

        public final void j() {
            Set setH = r.h(this.f4970l);
            if (setH.equals(this.f4974p)) {
                return;
            }
            this.f4974p = setH;
            List<ResolveInfo> listQueryIntentServices = this.f4970l.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setH.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f4973o.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f4973o.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f4973o.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    b((a) entry.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f4972n.obtainMessage(1, new e(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f4972n.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface g {
        void a(InterfaceC0816a interfaceC0816a);
    }

    public r(Context context) {
        this.f4962a = context;
        this.f4963b = (NotificationManager) context.getSystemService("notification");
    }

    public static r g(Context context) {
        return new r(context);
    }

    public static Set h(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f4957c) {
            if (string != null) {
                try {
                    if (!string.equals(f4958d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f4959e = hashSet;
                        f4958d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f4959e;
        }
        return set;
    }

    public static boolean n(Notification notification) {
        Bundle bundleA = k.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return a.a(this.f4963b);
    }

    public boolean b() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 29) {
            return true;
        }
        return i7 < 34 ? this.f4962a.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0 : c.a(this.f4963b);
    }

    public void c(int i7) {
        d(null, i7);
    }

    public void d(String str, int i7) {
        this.f4963b.cancel(str, i7);
    }

    public void e() {
        this.f4963b.cancelAll();
    }

    public void f(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(this.f4963b, notificationChannel);
        }
    }

    public NotificationChannel i(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return b.b(this.f4963b, str);
        }
        return null;
    }

    public List j() {
        return Build.VERSION.SDK_INT >= 26 ? b.c(this.f4963b) : Collections.EMPTY_LIST;
    }

    public void k(int i7, Notification notification) {
        l(null, i7, notification);
    }

    public void l(String str, int i7, Notification notification) {
        if (!n(notification)) {
            this.f4963b.notify(str, i7, notification);
        } else {
            m(new d(this.f4962a.getPackageName(), i7, str, notification));
            this.f4963b.cancel(str, i7);
        }
    }

    public final void m(g gVar) {
        synchronized (f4960f) {
            try {
                if (f4961g == null) {
                    f4961g = new f(this.f4962a.getApplicationContext());
                }
                f4961g.h(gVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
