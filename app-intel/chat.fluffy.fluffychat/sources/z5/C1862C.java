package z5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: z5.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1862C {
    public static Map a(InterfaceC1861B interfaceC1861B) {
        M5.m.e(interfaceC1861B, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = interfaceC1861B.b();
        while (itB.hasNext()) {
            Object objA = interfaceC1861B.a(itB.next());
            Object vVar = linkedHashMap.get(objA);
            if (vVar == null && !linkedHashMap.containsKey(objA)) {
                vVar = new M5.v();
            }
            M5.v vVar2 = (M5.v) vVar;
            vVar2.f5722l++;
            linkedHashMap.put(objA, vVar2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            M5.m.c(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            M5.A.c(entry).setValue(Integer.valueOf(((M5.v) entry.getValue()).f5722l));
        }
        return M5.A.b(linkedHashMap);
    }
}
