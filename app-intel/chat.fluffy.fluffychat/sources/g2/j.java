package g2;

import java.util.List;
import z5.C1892w;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final List f16207a;

    public j(List list) {
        M5.m.e(list, "displayFeatures");
        this.f16207a = list;
    }

    public final List a() {
        return this.f16207a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !M5.m.a(j.class, obj.getClass())) {
            return false;
        }
        return M5.m.a(this.f16207a, ((j) obj).f16207a);
    }

    public int hashCode() {
        return this.f16207a.hashCode();
    }

    public String toString() {
        return C1892w.L(this.f16207a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
