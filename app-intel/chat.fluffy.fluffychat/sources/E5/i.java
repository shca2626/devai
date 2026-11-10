package E5;

import M5.m;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f2377a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final a f2378b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    public static a f2379c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f2380a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f2381b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f2382c;

        public a(Method method, Method method2, Method method3) {
            this.f2380a = method;
            this.f2381b = method2;
            this.f2382c = method3;
        }
    }

    public final a a(E5.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", null), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f2379c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f2378b;
            f2379c = aVar3;
            return aVar3;
        }
    }

    public final String b(E5.a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        m.e(aVar, "continuation");
        a aVarA = f2379c;
        if (aVarA == null) {
            aVarA = a(aVar);
        }
        if (aVarA != f2378b && (method = aVarA.f2380a) != null && (objInvoke = method.invoke(aVar.getClass(), null)) != null && (method2 = aVarA.f2381b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = aVarA.f2382c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }
}
