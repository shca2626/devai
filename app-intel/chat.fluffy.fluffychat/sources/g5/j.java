package g5;

import h5.j;
import java.util.HashMap;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16345a;

    /* renamed from: b, reason: collision with root package name */
    public final j.c f16346b;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            dVar.success(null);
        }
    }

    public j(X4.a aVar) {
        a aVar2 = new a();
        this.f16346b = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/navigation", h5.f.f16894a);
        this.f16345a = jVar;
        jVar.e(aVar2);
    }

    public void a() {
        U4.b.f("NavigationChannel", "Sending message to pop route.");
        this.f16345a.c("popRoute", null);
    }

    public void b(String str) {
        U4.b.f("NavigationChannel", "Sending message to push route information '" + str + "'");
        HashMap map = new HashMap();
        map.put("location", str);
        this.f16345a.c("pushRouteInformation", map);
    }

    public void c(String str) {
        U4.b.f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f16345a.c("setInitialRoute", str);
    }
}
