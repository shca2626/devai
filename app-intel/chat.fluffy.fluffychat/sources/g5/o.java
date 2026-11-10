package g5;

import g5.o;
import h5.j;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16429a;

    /* renamed from: b, reason: collision with root package name */
    public e f16430b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16431c;

    public class a implements j.c {
        public a() {
        }

        public static /* synthetic */ void a(j.d dVar, c cVar) {
            if (cVar == null) {
                dVar.error("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap map = new HashMap();
            map.put("width", Double.valueOf(cVar.f16433a));
            map.put("height", Double.valueOf(cVar.f16434b));
            dVar.success(map);
        }

        public final void b(h5.i iVar, j.d dVar) {
            try {
                o.this.f16430b.c(((Integer) iVar.b()).intValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        public final void c(h5.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            boolean z7 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer byteBufferWrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (o.this.f16430b.o()) {
                    U4.b.e("PlatformViewsChannel", "Using HCPP platform view rendering strategy.");
                    o.this.f16430b.i(l.a(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), ((Integer) map.get("direction")).intValue(), byteBufferWrap));
                    dVar.success(null);
                    return;
                }
                U4.b.e("PlatformViewsChannel", "Using legacy platform view rendering strategy.");
                if (z7) {
                    o.this.f16430b.j(l.b(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), ((Integer) map.get("direction")).intValue(), byteBufferWrap));
                    dVar.success(null);
                    return;
                }
                boolean z8 = map.containsKey("hybridFallback") && ((Boolean) map.get("hybridFallback")).booleanValue();
                long jM = o.this.f16430b.m(l.c(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z8, byteBufferWrap));
                if (jM != -2) {
                    dVar.success(Long.valueOf(jM));
                } else {
                    if (!z8) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                    dVar.success(null);
                }
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        public final void d(h5.i iVar, j.d dVar) {
            try {
                o.this.f16430b.d(((Integer) ((Map) iVar.b()).get("id")).intValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        public final void e(h5.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                o.this.f16430b.k(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        public final void f(h5.i iVar, final j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                o.this.f16430b.h(new d(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b() { // from class: g5.n
                    @Override // g5.o.b
                    public final void a(o.c cVar) {
                        o.a.a(dVar, cVar);
                    }
                });
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        public final void g(h5.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                o.this.f16430b.a(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        public final void h(h5.i iVar, j.d dVar) {
            try {
                o.this.f16430b.e(((Boolean) iVar.b()).booleanValue());
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        public final void i(h5.i iVar, j.d dVar) {
            List list = (List) iVar.b();
            try {
                o.this.f16430b.b(new m(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar.success(null);
            } catch (IllegalStateException e7) {
                dVar.error("error", o.c(e7), null);
            }
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (o.this.f16430b == null) {
            }
            U4.b.f("PlatformViewsChannel", "Received '" + iVar.f16895a + "' message.");
            String str = iVar.f16895a;
            str.getClass();
            switch (str) {
                case "create":
                    c(iVar, dVar);
                    break;
                case "offset":
                    e(iVar, dVar);
                    break;
                case "resize":
                    f(iVar, dVar);
                    break;
                case "clearFocus":
                    b(iVar, dVar);
                    break;
                case "synchronizeToNativeViewHierarchy":
                    h(iVar, dVar);
                    break;
                case "touch":
                    i(iVar, dVar);
                    break;
                case "setDirection":
                    g(iVar, dVar);
                    break;
                case "dispose":
                    d(iVar, dVar);
                    break;
                default:
                    dVar.notImplemented();
                    break;
            }
        }
    }

    public interface b {
        void a(c cVar);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f16433a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16434b;

        public c(int i7, int i8) {
            this.f16433a = i7;
            this.f16434b = i8;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f16435a;

        /* renamed from: b, reason: collision with root package name */
        public final double f16436b;

        /* renamed from: c, reason: collision with root package name */
        public final double f16437c;

        public d(int i7, double d7, double d8) {
            this.f16435a = i7;
            this.f16436b = d7;
            this.f16437c = d8;
        }
    }

    public interface e {
        void a(int i7, int i8);

        void b(m mVar);

        void c(int i7);

        void d(int i7);

        void e(boolean z7);

        void h(d dVar, b bVar);

        void i(l lVar);

        void j(l lVar);

        void k(int i7, double d7, double d8);

        long m(l lVar);

        boolean o();
    }

    public o(X4.a aVar) {
        a aVar2 = new a();
        this.f16431c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/platform_views", h5.p.f16910b);
        this.f16429a = jVar;
        jVar.e(aVar2);
    }

    public static String c(Exception exc) {
        return U4.b.d(exc);
    }

    public void d(int i7) {
        h5.j jVar = this.f16429a;
        if (jVar == null) {
            return;
        }
        jVar.c("viewFocused", Integer.valueOf(i7));
    }

    public void e(e eVar) {
        this.f16430b = eVar;
    }
}
