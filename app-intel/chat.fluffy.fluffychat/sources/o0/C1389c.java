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
public final class C1389c extends AbstractC1393g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20337a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f20338b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f20339c;

    /* renamed from: o0.c$a */
    public class a implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Collection f20340l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1391e f20341m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f20342n;

        public a(Collection collection, InterfaceC1391e interfaceC1391e, boolean z7) {
            this.f20340l = collection;
            this.f20341m = interfaceC1391e;
            this.f20342n = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f20340l.isEmpty()) {
                C1389c.this.n();
                C1389c.this.d();
                C1389c.this.l(C1389c.g(this.f20340l), this.f20341m, this.f20342n);
            } else {
                InterfaceC1391e interfaceC1391e = this.f20341m;
                if (interfaceC1391e != null) {
                    interfaceC1391e.a(0, null);
                }
            }
        }
    }

    public C1389c(Context context, Executor executor) {
        this.f20338b = new HashMap();
        if (executor == null) {
            throw new NullPointerException("Executor can not be null.");
        }
        this.f20337a = context.getApplicationContext();
        this.f20339c = executor;
    }

    public static ArrayList f(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((AbstractC1390d) it.next()).f());
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

    @Override // o0.AbstractC1393g
    public void c(Collection collection, InterfaceC1391e interfaceC1391e) {
        m(collection, interfaceC1391e, true);
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
            if (!this.f20338b.containsKey(str)) {
                hashSet.add(str);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (ServiceInfo serviceInfo : j(new Intent("androidx.enterprise.feedback.action.APP_STATES"), hashSet)) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
            C1388b c1388b = new C1388b(this.f20339c, this.f20337a, intent, 1);
            c1388b.a();
            this.f20338b.put(serviceInfo.packageName, c1388b);
        }
    }

    public final Collection i() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.f20337a.getSystemService("device_policy");
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
        List<ResolveInfo> listQueryIntentServices = this.f20337a.getPackageManager().queryIntentServices(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            if (collection.contains(resolveInfo.serviceInfo.packageName)) {
                arrayList.add(resolveInfo.serviceInfo);
            }
        }
        return arrayList;
    }

    public final boolean k(String str) {
        return (Build.VERSION.SDK_INT < 26 && ((C1388b) this.f20338b.get(str)).b()) || ((C1388b) this.f20338b.get(str)).c() || !AbstractC1393g.a(this.f20337a, str);
    }

    public void l(Bundle bundle, InterfaceC1391e interfaceC1391e, boolean z7) {
        if (interfaceC1391e != null) {
            interfaceC1391e = new C1392f(this.f20338b.size(), interfaceC1391e);
        }
        Iterator it = this.f20338b.values().iterator();
        while (it.hasNext()) {
            ((C1388b) it.next()).d(new C1394h(bundle, interfaceC1391e, z7));
        }
    }

    public final void m(Collection collection, InterfaceC1391e interfaceC1391e, boolean z7) {
        this.f20339c.execute(new a(collection, interfaceC1391e, z7));
    }

    public void n() {
        Iterator it = this.f20338b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (k((String) entry.getKey())) {
                ((C1388b) entry.getValue()).f();
                it.remove();
            }
        }
    }

    public C1389c(Context context) {
        this(context, h());
    }
}
