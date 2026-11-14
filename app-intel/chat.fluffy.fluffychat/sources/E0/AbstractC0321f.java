package E0;

import android.os.Bundle;
import j3.InterfaceC1231f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k3.AbstractC1278v;

/* renamed from: E0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0321f {
    public static AbstractC1278v a(InterfaceC1231f interfaceC1231f, List list) {
        AbstractC1278v.a aVarO = AbstractC1278v.o();
        for (int i7 = 0; i7 < list.size(); i7++) {
            aVarO.a(interfaceC1231f.apply((Bundle) j3.o.q((Bundle) list.get(i7))));
        }
        return aVarO.k();
    }

    public static ArrayList b(Collection collection, InterfaceC1231f interfaceC1231f) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) interfaceC1231f.apply(it.next()));
        }
        return arrayList;
    }
}
