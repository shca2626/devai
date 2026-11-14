package androidx.lifecycle;

import V1.f;
import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import u0.C1641b;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: c, reason: collision with root package name */
    public static final a f12352c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map f12353a;

    /* renamed from: b, reason: collision with root package name */
    public C1641b f12354b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                bundle = bundle2;
            }
            if (bundle == null) {
                return new C();
            }
            ClassLoader classLoader = C.class.getClassLoader();
            M5.m.b(classLoader);
            bundle.setClassLoader(classLoader);
            return new C(V1.c.g(V1.c.a(bundle)));
        }

        public a() {
        }
    }

    public C(Map map) {
        M5.m.e(map, "initialState");
        this.f12353a = new LinkedHashMap();
        this.f12354b = new C1641b(map);
    }

    public final f.b a() {
        return this.f12354b.b();
    }

    public C() {
        this.f12353a = new LinkedHashMap();
        this.f12354b = new C1641b(null, 1, null);
    }
}
