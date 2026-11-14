package P4;

import M5.m;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import c5.InterfaceC0911a;
import h5.j;

/* loaded from: classes.dex */
public final class a implements InterfaceC0911a {

    /* renamed from: l, reason: collision with root package name */
    public j f7556l;

    public final void a(h5.b bVar, Context context) {
        this.f7556l = new j(bVar, "dev.fluttercommunity.plus/device_info");
        PackageManager packageManager = context.getPackageManager();
        m.d(packageManager, "getPackageManager(...)");
        Object systemService = context.getSystemService("activity");
        m.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ContentResolver contentResolver = context.getContentResolver();
        m.b(contentResolver);
        b bVar2 = new b(packageManager, (ActivityManager) systemService, contentResolver);
        j jVar = this.f7556l;
        if (jVar == null) {
            m.o("methodChannel");
            jVar = null;
        }
        jVar.e(bVar2);
    }

    @Override // c5.InterfaceC0911a
    public void onAttachedToEngine(InterfaceC0911a.b bVar) {
        m.e(bVar, "binding");
        h5.b bVarB = bVar.b();
        m.d(bVarB, "getBinaryMessenger(...)");
        Context contextA = bVar.a();
        m.d(contextA, "getApplicationContext(...)");
        a(bVarB, contextA);
    }

    @Override // c5.InterfaceC0911a
    public void onDetachedFromEngine(InterfaceC0911a.b bVar) {
        m.e(bVar, "binding");
        j jVar = this.f7556l;
        if (jVar == null) {
            m.o("methodChannel");
            jVar = null;
        }
        jVar.e(null);
    }
}
