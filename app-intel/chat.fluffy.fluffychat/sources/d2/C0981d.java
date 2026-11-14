package d2;

import M5.m;
import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import y5.C1823s;

/* renamed from: d2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0981d {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f15125a;

    /* renamed from: d2.d$a */
    public static final class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final T5.b f15126a;

        /* renamed from: b, reason: collision with root package name */
        public final L5.l f15127b;

        public a(T5.b bVar, L5.l lVar) {
            m.e(bVar, "clazz");
            m.e(lVar, "consumer");
            this.f15126a = bVar;
            this.f15127b = lVar;
        }

        public final void a(Object obj) {
            m.e(obj, "parameter");
            this.f15127b.a(obj);
        }

        public final boolean b(Method method, Object[] objArr) {
            return m.a(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        public final boolean c(Method method, Object[] objArr) {
            return m.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean d(Method method, Object[] objArr) {
            return m.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        public final boolean e(Method method, Object[] objArr) {
            return m.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            m.e(obj, "obj");
            m.e(method, "method");
            if (b(method, objArr)) {
                a(T5.c.a(this.f15126a, objArr != null ? objArr[0] : null));
                return C1823s.f24020a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f15127b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f15127b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* renamed from: d2.d$b */
    public interface b {
        void dispose();
    }

    /* renamed from: d2.d$c */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f15128a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f15129b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f15130c;

        public c(Method method, Object obj, Object obj2) {
            this.f15128a = method;
            this.f15129b = obj;
            this.f15130c = obj2;
        }

        @Override // d2.C0981d.b
        public void dispose() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f15128a.invoke(this.f15129b, this.f15130c);
        }
    }

    public C0981d(ClassLoader classLoader) {
        m.e(classLoader, "loader");
        this.f15125a = classLoader;
    }

    public final Object a(T5.b bVar, L5.l lVar) throws IllegalArgumentException {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f15125a, new Class[]{d()}, new a(bVar, lVar));
        m.d(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return objNewProxyInstance;
    }

    public final Class b() {
        try {
            return d();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final b c(Object obj, T5.b bVar, String str, String str2, Activity activity, L5.l lVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m.e(obj, "obj");
        m.e(bVar, "clazz");
        m.e(str, "addMethodName");
        m.e(str2, "removeMethodName");
        m.e(activity, "activity");
        m.e(lVar, "consumer");
        Object objA = a(bVar, lVar);
        obj.getClass().getMethod(str, Activity.class, d()).invoke(obj, activity, objA);
        return new c(obj.getClass().getMethod(str2, d()), obj, objA);
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f15125a.loadClass("java.util.function.Consumer");
        m.d(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }
}
