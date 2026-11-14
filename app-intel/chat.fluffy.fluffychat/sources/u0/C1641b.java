package u0;

import M5.g;
import M5.m;
import V.e;
import V1.f;
import V1.j;
import Z5.p;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import y5.AbstractC1816l;
import y5.C1812h;
import z5.C1866G;

/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1641b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f22739a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f22740b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f22741c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f22742d;

    /* renamed from: e, reason: collision with root package name */
    public final f.b f22743e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1641b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final Bundle c(C1641b c1641b) {
        C1812h[] c1812hArr;
        for (Map.Entry entry : C1866G.s(c1641b.f22742d).entrySet()) {
            c1641b.d((String) entry.getKey(), ((p) entry.getValue()).getValue());
        }
        for (Map.Entry entry2 : C1866G.s(c1641b.f22740b).entrySet()) {
            c1641b.d((String) entry2.getKey(), ((f.b) entry2.getValue()).a());
        }
        Map map = c1641b.f22739a;
        if (map.isEmpty()) {
            c1812hArr = new C1812h[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry3 : map.entrySet()) {
                arrayList.add(AbstractC1816l.a((String) entry3.getKey(), entry3.getValue()));
            }
            c1812hArr = (C1812h[]) arrayList.toArray(new C1812h[0]);
        }
        Bundle bundleA = e.a((C1812h[]) Arrays.copyOf(c1812hArr, c1812hArr.length));
        j.a(bundleA);
        return bundleA;
    }

    public final f.b b() {
        return this.f22743e;
    }

    public final void d(String str, Object obj) {
        m.e(str, "key");
        this.f22739a.put(str, obj);
        p pVar = (p) this.f22741c.get(str);
        if (pVar != null) {
            pVar.setValue(obj);
        }
        p pVar2 = (p) this.f22742d.get(str);
        if (pVar2 != null) {
            pVar2.setValue(obj);
        }
    }

    public C1641b(Map map) {
        m.e(map, "initialState");
        this.f22739a = C1866G.u(map);
        this.f22740b = new LinkedHashMap();
        this.f22741c = new LinkedHashMap();
        this.f22742d = new LinkedHashMap();
        this.f22743e = new f.b() { // from class: u0.a
            @Override // V1.f.b
            public final Bundle a() {
                return C1641b.c(this.f22738a);
            }
        };
    }

    public /* synthetic */ C1641b(Map map, int i7, g gVar) {
        this((i7 & 1) != 0 ? C1866G.h() : map);
    }
}
