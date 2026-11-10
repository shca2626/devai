package E0;

import android.os.Bundle;
import j3.InterfaceC1232f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k3.AbstractC1279v;

/* renamed from: E0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0320f {
    public static AbstractC1279v a(InterfaceC1232f interfaceC1232f, List list) {
        AbstractC1279v.a aVarO = AbstractC1279v.o();
        for (int i7 = 0; i7 < list.size(); i7++) {
            aVarO.a(interfaceC1232f.apply((Bundle) j3.o.q((Bundle) list.get(i7))));
        }
        return aVarO.k();
    }

    public static ArrayList b(Collection collection, InterfaceC1232f interfaceC1232f) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) interfaceC1232f.apply(it.next()));
        }
        return arrayList;
    }
}
