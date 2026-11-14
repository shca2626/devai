package g1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: g1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1079h {

    /* renamed from: a, reason: collision with root package name */
    public final Map f16091a = new LinkedHashMap();

    public void a(C1078g c1078g) {
        long[] jArr = c1078g.f16089e;
        if (jArr.length <= 0 || this.f16091a.containsKey(Long.valueOf(jArr[0]))) {
            return;
        }
        this.f16091a.put(Long.valueOf(c1078g.f16089e[0]), c1078g);
    }

    public C1078g b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (C1078g c1078g : this.f16091a.values()) {
            arrayList.add(c1078g.f16086b);
            arrayList2.add(c1078g.f16087c);
            arrayList3.add(c1078g.f16088d);
            arrayList4.add(c1078g.f16089e);
        }
        return new C1078g(o3.g.f((int[][]) arrayList.toArray(new int[arrayList.size()][])), o3.i.b((long[][]) arrayList2.toArray(new long[arrayList2.size()][])), o3.i.b((long[][]) arrayList3.toArray(new long[arrayList3.size()][])), o3.i.b((long[][]) arrayList4.toArray(new long[arrayList4.size()][])));
    }

    public int c() {
        return this.f16091a.size();
    }
}
