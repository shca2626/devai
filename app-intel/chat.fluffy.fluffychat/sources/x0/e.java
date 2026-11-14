package x0;

import M5.m;
import d.AbstractC0951F;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import y5.C1823s;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final d f23449a = new d();

    /* renamed from: b, reason: collision with root package name */
    public final Map f23450b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Set f23451c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f23452d;

    public final void d(String str, AutoCloseable autoCloseable) throws Exception {
        AutoCloseable autoCloseable2;
        m.e(str, "key");
        m.e(autoCloseable, "closeable");
        if (this.f23452d) {
            f(autoCloseable);
            return;
        }
        synchronized (this.f23449a) {
            autoCloseable2 = (AutoCloseable) this.f23450b.put(str, autoCloseable);
        }
        f(autoCloseable2);
    }

    public final void e() {
        if (this.f23452d) {
            return;
        }
        this.f23452d = true;
        synchronized (this.f23449a) {
            try {
                Iterator it = this.f23450b.values().iterator();
                while (it.hasNext()) {
                    f((AutoCloseable) it.next());
                }
                Iterator it2 = this.f23451c.iterator();
                while (it2.hasNext()) {
                    f((AutoCloseable) it2.next());
                }
                this.f23451c.clear();
                C1823s c1823s = C1823s.f24020a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable != null) {
            try {
                AbstractC0951F.a(autoCloseable);
            } catch (Exception e7) {
                throw new RuntimeException(e7);
            }
        }
    }

    public final AutoCloseable g(String str) {
        AutoCloseable autoCloseable;
        m.e(str, "key");
        synchronized (this.f23449a) {
            autoCloseable = (AutoCloseable) this.f23450b.get(str);
        }
        return autoCloseable;
    }
}
