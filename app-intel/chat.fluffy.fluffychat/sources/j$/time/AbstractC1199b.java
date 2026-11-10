package j$.time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

/* renamed from: j$.time.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1199b {
    public static /* synthetic */ List a(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static C1198a b() {
        String id = TimeZone.getDefault().getID();
        Map map = ZoneId.f18200a;
        Objects.requireNonNull(id, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        String str = (String) map.get(id);
        if (str != null) {
            id = str;
        }
        return new C1198a(ZoneId.of(id));
    }
}
