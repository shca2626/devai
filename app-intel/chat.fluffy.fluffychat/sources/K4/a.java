package K4;

import I4.b;
import M5.m;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: l, reason: collision with root package name */
    public final List f5414l;

    public a(List list) {
        m.e(list, "order");
        this.f5414l = list;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        Object next;
        if (bVar == null && bVar2 == null) {
            return 0;
        }
        if (bVar == null) {
            return -1;
        }
        if (bVar2 == null) {
            return 1;
        }
        Class<?> cls = bVar.getClass();
        Class<?> cls2 = bVar2.getClass();
        if (m.a(cls, cls2)) {
            return 0;
        }
        Iterator it = this.f5414l.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Class cls3 = (Class) next;
            if (m.a(cls3, cls) || m.a(cls3, cls2)) {
                break;
            }
        }
        return m.a((Class) next, cls) ? -1 : 1;
    }
}
