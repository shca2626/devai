package x0;

import M5.m;
import d.AbstractC0950F;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import y5.C1824s;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final d f23443a = new d();

    /* renamed from: b, reason: collision with root package name */
    public final Map f23444b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Set f23445c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f23446d;

    public final void d(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        m.e(str, "key");
        m.e(autoCloseable, "closeable");
        if (this.f23446d) {
            f(autoCloseable);
            return;
        }
        synchronized (this.f23443a) {
            autoCloseable2 = (AutoCloseable) this.f23444b.put(str, autoCloseable);
        }
        f(autoCloseable2);
    }

    public final void e() {
        if (this.f23446d) {
            return;
        }
        this.f23446d = true;
        synchronized (this.f23443a) {
            try {
                Iterator it = this.f23444b.values().iterator();
                while (it.hasNext()) {
                    f((AutoCloseable) it.next());
                }
                Iterator it2 = this.f23445c.iterator();
                while (it2.hasNext()) {
                    f((AutoCloseable) it2.next());
                }
                this.f23445c.clear();
                C1824s c1824s = C1824s.f24014a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                AbstractC0950F.a(autoCloseable);
            } catch (Exception e7) {
                throw new RuntimeException(e7);
            }
        }
    }

    public final AutoCloseable g(String str) {
        AutoCloseable autoCloseable;
        m.e(str, "key");
        synchronized (this.f23443a) {
            autoCloseable = (AutoCloseable) this.f23444b.get(str);
        }
        return autoCloseable;
    }
}
