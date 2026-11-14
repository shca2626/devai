package l2;

import M5.m;
import T5.b;
import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1302a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1302a f19557a = new C1302a();

    public static final boolean e(String str, L5.a aVar) {
        m.e(aVar, "block");
        try {
            boolean zBooleanValue = ((Boolean) aVar.d()).booleanValue();
            if (!zBooleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("ClassNotFound: ");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            Log.e("ReflectionGuard", sb.toString());
            return false;
        } catch (NoSuchMethodException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NoSuchMethod: ");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            Log.e("ReflectionGuard", sb2.toString());
            return false;
        }
    }

    public final boolean a(L5.a aVar) {
        m.e(aVar, "classLoader");
        try {
            aVar.d();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean b(Method method, b bVar) {
        m.e(method, "<this>");
        m.e(bVar, "clazz");
        return c(method, K5.a.a(bVar));
    }

    public final boolean c(Method method, Class cls) {
        m.e(method, "<this>");
        m.e(cls, "clazz");
        return method.getReturnType().equals(cls);
    }

    public final boolean d(Method method) {
        m.e(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }
}
