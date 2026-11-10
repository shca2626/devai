package G0;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Map f3215a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map f3216b;

    public synchronized void a(Map map) {
        this.f3216b = null;
        this.f3215a.clear();
        this.f3215a.putAll(map);
    }

    public synchronized Map b() {
        try {
            if (this.f3216b == null) {
                this.f3216b = Collections.unmodifiableMap(new HashMap(this.f3215a));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f3216b;
    }
}
