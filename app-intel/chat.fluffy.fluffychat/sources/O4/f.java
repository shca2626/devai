package O4;

import android.content.Context;
import android.net.ConnectivityManager;
import c5.InterfaceC0910a;
import h5.j;

/* loaded from: classes.dex */
public class f implements InterfaceC0910a {

    /* renamed from: l, reason: collision with root package name */
    public j f7310l;

    /* renamed from: m, reason: collision with root package name */
    public h5.c f7311m;

    /* renamed from: n, reason: collision with root package name */
    public d f7312n;

    public final void a(h5.b bVar, Context context) {
        this.f7310l = new j(bVar, "dev.fluttercommunity.plus/connectivity");
        this.f7311m = new h5.c(bVar, "dev.fluttercommunity.plus/connectivity_status");
        a aVar = new a((ConnectivityManager) context.getSystemService("connectivity"));
        e eVar = new e(aVar);
        this.f7312n = new d(context, aVar);
        this.f7310l.e(eVar);
        this.f7311m.d(this.f7312n);
    }

    public final void b() {
        this.f7310l.e(null);
        this.f7311m.d(null);
        this.f7312n.onCancel(null);
        this.f7310l = null;
        this.f7311m = null;
        this.f7312n = null;
    }

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        a(bVar.b(), bVar.a());
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        b();
    }
}
