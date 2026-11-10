package g5;

import android.content.pm.PackageManager;
import h5.j;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16442a;

    /* renamed from: b, reason: collision with root package name */
    public final PackageManager f16443b;

    /* renamed from: c, reason: collision with root package name */
    public b f16444c;

    /* renamed from: d, reason: collision with root package name */
    public final j.c f16445d;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (q.this.f16444c == null) {
                return;
            }
            String str = iVar.f16895a;
            Object obj = iVar.f16896b;
            str.getClass();
            if (!str.equals("ProcessText.processTextAction")) {
                if (!str.equals("ProcessText.queryTextActions")) {
                    dVar.notImplemented();
                    return;
                }
                try {
                    dVar.success(q.this.f16444c.b());
                    return;
                } catch (IllegalStateException e7) {
                    dVar.error("error", e7.getMessage(), null);
                    return;
                }
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                q.this.f16444c.a((String) arrayList.get(0), (String) arrayList.get(1), ((Boolean) arrayList.get(2)).booleanValue(), dVar);
            } catch (IllegalStateException e8) {
                dVar.error("error", e8.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, boolean z7, j.d dVar);

        Map b();
    }

    public q(X4.a aVar, PackageManager packageManager) {
        a aVar2 = new a();
        this.f16445d = aVar2;
        this.f16443b = packageManager;
        h5.j jVar = new h5.j(aVar, "flutter/processtext", h5.p.f16910b);
        this.f16442a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f16444c = bVar;
    }
}
