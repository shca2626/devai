package g2;

import M5.x;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import d2.C0981d;
import h2.InterfaceC1139a;
import i2.AbstractC1152a;
import y5.C1809e;
import y5.InterfaceC1808d;

/* renamed from: g2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1102f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16191a = a.f16192a;

    /* renamed from: g2.f$a */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final boolean f16193b = false;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f16192a = new a();

        /* renamed from: c, reason: collision with root package name */
        public static final String f16194c = x.b(InterfaceC1102f.class).b();

        /* renamed from: d, reason: collision with root package name */
        public static final InterfaceC1808d f16195d = C1809e.a(C0176a.f16197m);

        /* renamed from: e, reason: collision with root package name */
        public static g f16196e = C1098b.f16167a;

        /* renamed from: g2.f$a$a, reason: collision with other inner class name */
        public static final class C0176a extends M5.n implements L5.a {

            /* renamed from: m, reason: collision with root package name */
            public static final C0176a f16197m = new C0176a();

            public C0176a() {
                super(0);
            }

            @Override // L5.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InterfaceC1139a d() {
                WindowLayoutComponent windowLayoutComponentG;
                try {
                    ClassLoader classLoader = InterfaceC1102f.class.getClassLoader();
                    C1101e c1101e = classLoader != null ? new C1101e(classLoader, new C0981d(classLoader)) : null;
                    if (c1101e == null || (windowLayoutComponentG = c1101e.g()) == null) {
                        return null;
                    }
                    AbstractC1152a.C0197a c0197a = AbstractC1152a.f17405a;
                    M5.m.d(classLoader, "loader");
                    return c0197a.a(windowLayoutComponentG, new C0981d(classLoader));
                } catch (Throwable unused) {
                    if (a.f16193b) {
                        Log.d(a.f16194c, "Failed to load WindowExtensions");
                    }
                    return null;
                }
            }
        }

        public final InterfaceC1139a c() {
            return (InterfaceC1139a) f16195d.getValue();
        }

        public final InterfaceC1102f d(Context context) {
            M5.m.e(context, "context");
            InterfaceC1139a interfaceC1139aC = c();
            if (interfaceC1139aC == null) {
                interfaceC1139aC = androidx.window.layout.adapter.sidecar.b.f13490c.a(context);
            }
            return f16196e.a(new i(o.f16214b, interfaceC1139aC));
        }
    }

    Z5.d a(Activity activity);
}
