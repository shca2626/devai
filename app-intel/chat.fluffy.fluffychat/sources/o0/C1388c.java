package o0;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: o0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1388c extends AbstractC1392g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20336a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f20337b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f20338c;

    /* renamed from: o0.c$a */
    public class a implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Collection f20339l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1390e f20340m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f20341n;

        public a(Collection collection, InterfaceC1390e interfaceC1390e, boolean z7) {
            this.f20339l = collection;
            this.f20340m = interfaceC1390e;
            this.f20341n = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f20339l.isEmpty()) {
                C1388c.this.n();
                C1388c.this.d();
                C1388c.this.l(C1388c.g(this.f20339l), this.f20340m, this.f20341n);
            } else {
                InterfaceC1390e interfaceC1390e = this.f20340m;
                if (interfaceC1390e != null) {
                    interfaceC1390e.a(0, null);
                }
            }
        }
    }

    public C1388c(Context context, Executor executor) {
        this.f20337b = new HashMap();
        if (executor == null) {
            throw new NullPointerException("Executor can not be null.");
        }
        this.f20336a = context.getApplicationContext();
        this.f20338c = executor;
    }

    public static ArrayList f(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((AbstractC1389d) it.next()).f());
        }
        return arrayList;
    }

    public static Bundle g(Collection collection) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("androidx.enterprise.feedback.APP_STATES", f(collection));
        return bundle;
    }

    public static ExecutorService h() {
        return new ThreadPoolExecutor(0, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    @Override // o0.AbstractC1392g
    public void c(Collection collection, InterfaceC1390e interfaceC1390e) {
        m(collection, interfaceC1390e, true);
    }

    public void d() {
        Collection collectionI = i();
        collectionI.add("com.android.vending");
        e(collectionI);
    }

    public final void e(Collection collection) {
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.f20337b.containsKey(str)) {
                hashSet.add(str);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (ServiceInfo serviceInfo : j(new Intent("androidx.enterprise.feedback.action.APP_STATES"), hashSet)) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
            C1387b c1387b = new C1387b(this.f20338c, this.f20336a, intent, 1);
            c1387b.a();
            this.f20337b.put(serviceInfo.packageName, c1387b);
        }
    }

    public final Collection i() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.f20336a.getSystemService("device_policy");
        List<ComponentName> activeAdmins = devicePolicyManager.getActiveAdmins();
        if (activeAdmins == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ComponentName componentName : activeAdmins) {
            if (devicePolicyManager.isDeviceOwnerApp(componentName.getPackageName()) || devicePolicyManager.isProfileOwnerApp(componentName.getPackageName())) {
                arrayList.add(componentName.getPackageName());
            }
        }
        return arrayList;
    }

    public final Collection j(Intent intent, Collection collection) {
        List<ResolveInfo> listQueryIntentServices = this.f20336a.getPackageManager().queryIntentServices(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            if (collection.contains(resolveInfo.serviceInfo.packageName)) {
                arrayList.add(resolveInfo.serviceInfo);
            }
        }
        return arrayList;
    }

    public final boolean k(String str) {
        return (Build.VERSION.SDK_INT < 26 && ((C1387b) this.f20337b.get(str)).b()) || ((C1387b) this.f20337b.get(str)).c() || !AbstractC1392g.a(this.f20336a, str);
    }

    public void l(Bundle bundle, InterfaceC1390e interfaceC1390e, boolean z7) {
        if (interfaceC1390e != null) {
            interfaceC1390e = new C1391f(this.f20337b.size(), interfaceC1390e);
        }
        Iterator it = this.f20337b.values().iterator();
        while (it.hasNext()) {
            ((C1387b) it.next()).d(new C1393h(bundle, interfaceC1390e, z7));
        }
    }

    public final void m(Collection collection, InterfaceC1390e interfaceC1390e, boolean z7) {
        this.f20338c.execute(new a(collection, interfaceC1390e, z7));
    }

    public void n() {
        Iterator it = this.f20337b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (k((String) entry.getKey())) {
                ((C1387b) entry.getValue()).f();
                it.remove();
            }
        }
    }

    public C1388c(Context context) {
        this(context, h());
    }
}
