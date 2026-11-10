package V1;

import V1.b;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final W1.b f8605a;

    /* renamed from: b, reason: collision with root package name */
    public b.C0071b f8606b;

    public interface a {
        void a(i iVar);
    }

    public interface b {
        Bundle a();
    }

    public f(W1.b bVar) {
        M5.m.e(bVar, "impl");
        this.f8605a = bVar;
    }

    public final Bundle a(String str) {
        M5.m.e(str, "key");
        return this.f8605a.c(str);
    }

    public final b b(String str) {
        M5.m.e(str, "key");
        return this.f8605a.d(str);
    }

    public final void c(String str, b bVar) {
        M5.m.e(str, "key");
        M5.m.e(bVar, "provider");
        this.f8605a.j(str, bVar);
    }

    public final void d(Class cls) throws NoSuchMethodException, SecurityException {
        M5.m.e(cls, "clazz");
        if (!this.f8605a.e()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        b.C0071b c0071b = this.f8606b;
        if (c0071b == null) {
            c0071b = new b.C0071b(this);
        }
        this.f8606b = c0071b;
        try {
            cls.getDeclaredConstructor(null);
            b.C0071b c0071b2 = this.f8606b;
            if (c0071b2 != null) {
                String name = cls.getName();
                M5.m.d(name, "getName(...)");
                c0071b2.b(name);
            }
        } catch (NoSuchMethodException e7) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e7);
        }
    }
}
