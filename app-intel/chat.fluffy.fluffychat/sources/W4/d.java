package W4;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile d f9073b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f9074a = new HashMap();

    public static d b() {
        if (f9073b == null) {
            synchronized (d.class) {
                try {
                    if (f9073b == null) {
                        f9073b = new d();
                    }
                } finally {
                }
            }
        }
        return f9073b;
    }

    public io.flutter.embedding.engine.b a(String str) {
        return (io.flutter.embedding.engine.b) this.f9074a.get(str);
    }
}
