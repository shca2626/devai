package c2;

import M5.m;
import M5.n;
import java.lang.reflect.Method;
import l2.C1302a;

/* renamed from: c2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0901a {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f13960a;

    /* renamed from: c2.a$a, reason: collision with other inner class name */
    public static final class C0138a extends n implements L5.a {
        public C0138a() {
            super(0);
        }

        @Override // L5.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Class d() throws ClassNotFoundException {
            Class<?> clsLoadClass = C0901a.this.f13960a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
            m.d(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            return clsLoadClass;
        }
    }

    /* renamed from: c2.a$b */
    public static final class b extends n implements L5.a {
        public b() {
            super(0);
        }

        @Override // L5.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean d() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
            Method declaredMethod = C0901a.this.d().getDeclaredMethod("getWindowExtensions", null);
            Class clsC = C0901a.this.c();
            C1302a c1302a = C1302a.f19557a;
            m.d(declaredMethod, "getWindowExtensionsMethod");
            return Boolean.valueOf(c1302a.c(declaredMethod, clsC) && c1302a.d(declaredMethod));
        }
    }

    public C0901a(ClassLoader classLoader) {
        m.e(classLoader, "loader");
        this.f13960a = classLoader;
    }

    public final Class c() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f13960a.loadClass("androidx.window.extensions.WindowExtensions");
        m.d(clsLoadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return clsLoadClass;
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f13960a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        m.d(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return clsLoadClass;
    }

    public final boolean e() {
        return C1302a.f19557a.a(new C0138a());
    }

    public final boolean f() {
        return e() && C1302a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new b());
    }
}
