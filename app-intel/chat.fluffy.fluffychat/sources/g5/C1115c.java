package g5;

import h5.j;
import java.util.HashMap;
import java.util.Map;

/* renamed from: g5.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1115c {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16314a;

    /* renamed from: b, reason: collision with root package name */
    public Map f16315b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16316c;

    /* renamed from: g5.c$a */
    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            C1115c.a(C1115c.this);
        }
    }

    public C1115c(X4.a aVar) {
        a aVar2 = new a();
        this.f16316c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/deferredcomponent", h5.p.f16910b);
        this.f16314a = jVar;
        jVar.e(aVar2);
        U4.a.e().a();
        this.f16315b = new HashMap();
    }

    public static /* synthetic */ Y4.a a(C1115c c1115c) {
        c1115c.getClass();
        return null;
    }
}
