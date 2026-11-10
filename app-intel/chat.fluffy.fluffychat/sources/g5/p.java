package g5;

import h5.j;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16438a;

    /* renamed from: b, reason: collision with root package name */
    public b f16439b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16440c;

    public class a implements j.c {
        public a() {
        }

        private void a(h5.i iVar, j.d dVar) {
            try {
                p.this.f16439b.c(((Integer) iVar.b()).intValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", p.c(e7), null);
            }
        }

        private void b(h5.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                p.this.f16439b.e(l.a(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null));
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", p.c(e7), null);
            }
        }

        private void c(h5.i iVar, j.d dVar) {
            try {
                p.this.f16439b.d(((Integer) ((Map) iVar.b()).get("id")).intValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", p.c(e7), null);
            }
        }

        private void e(h5.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                p.this.f16439b.a(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", p.c(e7), null);
            }
        }

        private void f(h5.i iVar, j.d dVar) {
            List list = (List) iVar.b();
            try {
                p.this.f16439b.b(new m(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", p.c(e7), null);
            }
        }

        public final void d(h5.i iVar, j.d dVar) {
            dVar.success(Boolean.valueOf(p.this.f16439b.f()));
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (p.this.f16439b == null) {
            }
            U4.b.f("PlatformViewsChannel2", "Received '" + iVar.f16895a + "' message.");
            String str = iVar.f16895a;
            str.getClass();
            switch (str) {
                case "create":
                    b(iVar, dVar);
                    break;
                case "clearFocus":
                    a(iVar, dVar);
                    break;
                case "touch":
                    f(iVar, dVar);
                    break;
                case "setDirection":
                    e(iVar, dVar);
                    break;
                case "isSurfaceControlEnabled":
                    d(iVar, dVar);
                    break;
                case "dispose":
                    c(iVar, dVar);
                    break;
                default:
                    dVar.notImplemented();
                    break;
            }
        }
    }

    public interface b {
        void a(int i7, int i8);

        void b(m mVar);

        void c(int i7);

        void d(int i7);

        void e(l lVar);

        boolean f();
    }

    public p(X4.a aVar) {
        a aVar2 = new a();
        this.f16440c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/platform_views_2", h5.p.f16910b);
        this.f16438a = jVar;
        jVar.e(aVar2);
    }

    public static String c(Exception exc) {
        return U4.b.d(exc);
    }

    public void d(int i7) {
        h5.j jVar = this.f16438a;
        if (jVar == null) {
            return;
        }
        jVar.c("viewFocused", Integer.valueOf(i7));
    }

    public void e(b bVar) {
        this.f16439b = bVar;
    }
}
