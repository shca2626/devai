package androidx.lifecycle;

import V1.f;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import y5.AbstractC1817l;
import y5.C1810e;
import y5.C1813h;
import y5.InterfaceC1809d;
import z5.C1863G;

/* loaded from: classes.dex */
public final class H implements f.b {

    /* renamed from: a, reason: collision with root package name */
    public final V1.f f12363a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12364b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f12365c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1809d f12366d;

    public H(V1.f fVar, final P p7) {
        M5.m.e(fVar, "savedStateRegistry");
        M5.m.e(p7, "viewModelStoreOwner");
        this.f12363a = fVar;
        this.f12366d = C1810e.a(new L5.a() { // from class: androidx.lifecycle.G
            @Override // L5.a
            public final Object d() {
                return H.f(p7);
            }
        });
    }

    public static final I f(P p7) {
        return F.e(p7);
    }

    @Override // V1.f.b
    public Bundle a() {
        C1813h[] c1813hArr;
        Map mapH = C1863G.h();
        if (mapH.isEmpty()) {
            c1813hArr = new C1813h[0];
        } else {
            ArrayList arrayList = new ArrayList(mapH.size());
            for (Map.Entry entry : mapH.entrySet()) {
                arrayList.add(AbstractC1817l.a((String) entry.getKey(), entry.getValue()));
            }
            c1813hArr = (C1813h[]) arrayList.toArray(new C1813h[0]);
        }
        Bundle bundleA = V.e.a((C1813h[]) Arrays.copyOf(c1813hArr, c1813hArr.length));
        Bundle bundleA2 = V1.j.a(bundleA);
        Bundle bundle = this.f12365c;
        if (bundle != null) {
            V1.j.b(bundleA2, bundle);
        }
        for (Map.Entry entry2 : d().e().entrySet()) {
            String str = (String) entry2.getKey();
            Bundle bundleA3 = ((C) entry2.getValue()).a().a();
            if (!V1.c.f(V1.c.a(bundleA3))) {
                V1.j.c(bundleA2, str, bundleA3);
            }
        }
        this.f12364b = false;
        return bundleA;
    }

    public final Bundle c(String str) {
        C1813h[] c1813hArr;
        M5.m.e(str, "key");
        e();
        Bundle bundle = this.f12365c;
        if (bundle == null || !V1.c.b(V1.c.a(bundle), str)) {
            return null;
        }
        Bundle bundleD = V1.c.d(V1.c.a(bundle), str);
        if (bundleD == null) {
            Map mapH = C1863G.h();
            if (mapH.isEmpty()) {
                c1813hArr = new C1813h[0];
            } else {
                ArrayList arrayList = new ArrayList(mapH.size());
                for (Map.Entry entry : mapH.entrySet()) {
                    arrayList.add(AbstractC1817l.a((String) entry.getKey(), entry.getValue()));
                }
                c1813hArr = (C1813h[]) arrayList.toArray(new C1813h[0]);
            }
            bundleD = V.e.a((C1813h[]) Arrays.copyOf(c1813hArr, c1813hArr.length));
            V1.j.a(bundleD);
        }
        V1.j.e(V1.j.a(bundle), str);
        if (V1.c.f(V1.c.a(bundle))) {
            this.f12365c = null;
        }
        return bundleD;
    }

    public final I d() {
        return (I) this.f12366d.getValue();
    }

    public final void e() {
        C1813h[] c1813hArr;
        if (this.f12364b) {
            return;
        }
        Bundle bundleA = this.f12363a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Map mapH = C1863G.h();
        if (mapH.isEmpty()) {
            c1813hArr = new C1813h[0];
        } else {
            ArrayList arrayList = new ArrayList(mapH.size());
            for (Map.Entry entry : mapH.entrySet()) {
                arrayList.add(AbstractC1817l.a((String) entry.getKey(), entry.getValue()));
            }
            c1813hArr = (C1813h[]) arrayList.toArray(new C1813h[0]);
        }
        Bundle bundleA2 = V.e.a((C1813h[]) Arrays.copyOf(c1813hArr, c1813hArr.length));
        Bundle bundleA3 = V1.j.a(bundleA2);
        Bundle bundle = this.f12365c;
        if (bundle != null) {
            V1.j.b(bundleA3, bundle);
        }
        if (bundleA != null) {
            V1.j.b(bundleA3, bundleA);
        }
        this.f12365c = bundleA2;
        this.f12364b = true;
        d();
    }
}
