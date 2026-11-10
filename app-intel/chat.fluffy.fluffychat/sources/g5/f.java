package g5;

import h5.j;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16322a;

    /* renamed from: b, reason: collision with root package name */
    public b f16323b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16324c;

    public class a implements j.c {

        /* renamed from: l, reason: collision with root package name */
        public Map f16325l = new HashMap();

        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (f.this.f16323b == null) {
                dVar.success(this.f16325l);
                return;
            }
            String str = iVar.f16895a;
            str.getClass();
            if (!str.equals("getKeyboardState")) {
                dVar.notImplemented();
                return;
            }
            try {
                this.f16325l = f.this.f16323b.b();
            } catch (IllegalStateException e7) {
                dVar.error("error", e7.getMessage(), null);
            }
            dVar.success(this.f16325l);
        }
    }

    public interface b {
        Map b();
    }

    public f(h5.b bVar) {
        a aVar = new a();
        this.f16324c = aVar;
        h5.j jVar = new h5.j(bVar, "flutter/keyboard", h5.p.f16910b);
        this.f16322a = jVar;
        jVar.e(aVar);
    }

    public void b(b bVar) {
        this.f16323b = bVar;
    }
}
