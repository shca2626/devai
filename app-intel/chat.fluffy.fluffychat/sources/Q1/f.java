package Q1;

import java.util.List;
import z5.C1883n;
import z5.C1884o;
import z5.C1889t;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final List f7618a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7619b;

    public f(List list, int i7) {
        this.f7618a = list;
        this.f7619b = i7;
        if (list.isEmpty() && i7 == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i7 >= 0 && i7 < size) {
                return;
            }
        }
        throw new IllegalArgumentException(("Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '" + i7 + "', bounds = '" + C1884o.j(list) + "'.").toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f7619b == fVar.f7619b && M5.m.a(this.f7618a, fVar.f7618a);
    }

    public int hashCode() {
        return (this.f7619b * 31) + this.f7618a.hashCode();
    }

    public String toString() {
        return "NavigationEventHistory(currentIndex=" + this.f7619b + ", mergedHistory=" + this.f7618a + ')';
    }

    public f() {
        this(C1884o.i(), -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(g gVar, List list, List list2) {
        M5.m.e(gVar, "currentInfo");
        M5.m.e(list, "backInfo");
        M5.m.e(list2, "forwardInfo");
        List listC = C1883n.c();
        C1889t.q(listC, list);
        listC.add(gVar);
        C1889t.q(listC, list2);
        this(C1883n.a(listC), list.size());
    }
}
