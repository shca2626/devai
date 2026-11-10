package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Map f18327a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f18328b;

    public u(Map map) {
        this.f18327a = map;
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l7 = (Long) entry2.getKey();
                t tVar = a.f18277b;
                map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l7));
            }
            ArrayList arrayList2 = new ArrayList(map3.values());
            Collections.sort(arrayList2, a.f18277b);
            map2.put((z) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            map2.put(null, arrayList);
        }
        Collections.sort(arrayList, a.f18277b);
        this.f18328b = map2;
    }

    public final String a(long j7, z zVar) {
        Map map = (Map) this.f18327a.get(zVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j7));
        }
        return null;
    }
}
