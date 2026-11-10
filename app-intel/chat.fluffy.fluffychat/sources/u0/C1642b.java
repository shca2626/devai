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
import y5.AbstractC1817l;
import y5.C1813h;
import z5.C1863G;

/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1642b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f22733a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f22734b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f22735c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f22736d;

    /* renamed from: e, reason: collision with root package name */
    public final f.b f22737e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1642b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final Bundle c(C1642b c1642b) {
        C1813h[] c1813hArr;
        for (Map.Entry entry : C1863G.s(c1642b.f22736d).entrySet()) {
            c1642b.d((String) entry.getKey(), ((p) entry.getValue()).getValue());
        }
        for (Map.Entry entry2 : C1863G.s(c1642b.f22734b).entrySet()) {
            c1642b.d((String) entry2.getKey(), ((f.b) entry2.getValue()).a());
        }
        Map map = c1642b.f22733a;
        if (map.isEmpty()) {
            c1813hArr = new C1813h[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry3 : map.entrySet()) {
                arrayList.add(AbstractC1817l.a((String) entry3.getKey(), entry3.getValue()));
            }
            c1813hArr = (C1813h[]) arrayList.toArray(new C1813h[0]);
        }
        Bundle bundleA = e.a((C1813h[]) Arrays.copyOf(c1813hArr, c1813hArr.length));
        j.a(bundleA);
        return bundleA;
    }

    public final f.b b() {
        return this.f22737e;
    }

    public final void d(String str, Object obj) {
        m.e(str, "key");
        this.f22733a.put(str, obj);
        p pVar = (p) this.f22735c.get(str);
        if (pVar != null) {
            pVar.setValue(obj);
        }
        p pVar2 = (p) this.f22736d.get(str);
        if (pVar2 != null) {
            pVar2.setValue(obj);
        }
    }

    public C1642b(Map map) {
        m.e(map, "initialState");
        this.f22733a = C1863G.u(map);
        this.f22734b = new LinkedHashMap();
        this.f22735c = new LinkedHashMap();
        this.f22736d = new LinkedHashMap();
        this.f22737e = new f.b() { // from class: u0.a
            @Override // V1.f.b
            public final Bundle a() {
                return C1642b.c(this.f22732a);
            }
        };
    }

    public /* synthetic */ C1642b(Map map, int i7, g gVar) {
        this((i7 & 1) != 0 ? C1863G.h() : map);
    }
}
