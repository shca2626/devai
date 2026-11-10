package g5;

import h5.j;
import java.util.HashMap;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16341a;

    /* renamed from: b, reason: collision with root package name */
    public b f16342b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16343c;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (i.this.f16342b == null) {
                return;
            }
            String str = iVar.f16895a;
            U4.b.f("MouseCursorChannel", "Received '" + str + "' message.");
            try {
                if (str.hashCode() == -1307105544 && str.equals("activateSystemCursor")) {
                    try {
                        i.this.f16342b.a((String) ((HashMap) iVar.f16896b).get("kind"));
                        dVar.success(Boolean.TRUE);
                    } catch (Exception e7) {
                        dVar.error("error", "Error when setting cursors: " + e7.getMessage(), null);
                    }
                }
            } catch (Exception e8) {
                dVar.error("error", "Unhandled error: " + e8.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str);
    }

    public i(X4.a aVar) {
        a aVar2 = new a();
        this.f16343c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/mousecursor", h5.p.f16910b);
        this.f16341a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f16342b = bVar;
    }
}
