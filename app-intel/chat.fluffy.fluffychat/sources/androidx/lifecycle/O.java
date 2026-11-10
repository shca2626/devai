package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class O {

    /* renamed from: a, reason: collision with root package name */
    public final Map f12388a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f12388a.values().iterator();
        while (it.hasNext()) {
            ((M) it.next()).b();
        }
        this.f12388a.clear();
    }

    public final M b(String str) {
        M5.m.e(str, "key");
        return (M) this.f12388a.get(str);
    }

    public final Set c() {
        return new HashSet(this.f12388a.keySet());
    }

    public final void d(String str, M m7) {
        M5.m.e(str, "key");
        M5.m.e(m7, "viewModel");
        M m8 = (M) this.f12388a.put(str, m7);
        if (m8 != null) {
            m8.b();
        }
    }
}
