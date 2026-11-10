package W3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f8965a = new HashMap();

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry entry : this.f8965a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > iIntValue) {
                iIntValue = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add((Integer) entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == iIntValue) {
                arrayList.add((Integer) entry.getKey());
            }
        }
        return V3.a.b(arrayList);
    }

    public void b(int i7) {
        Integer num = (Integer) this.f8965a.get(Integer.valueOf(i7));
        if (num == null) {
            num = 0;
        }
        this.f8965a.put(Integer.valueOf(i7), Integer.valueOf(num.intValue() + 1));
    }
}
