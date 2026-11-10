package androidx.lifecycle;

import androidx.lifecycle.AbstractC0804j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0797c {

    /* renamed from: c, reason: collision with root package name */
    public static C0797c f12390c = new C0797c();

    /* renamed from: a, reason: collision with root package name */
    public final Map f12391a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f12392b = new HashMap();

    /* renamed from: androidx.lifecycle.c$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f12393a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map f12394b;

        public a(Map map) {
            this.f12394b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0804j.a aVar = (AbstractC0804j.a) entry.getValue();
                List arrayList = (List) this.f12393a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f12393a.put(aVar, arrayList);
                }
                arrayList.add((b) entry.getKey());
            }
        }

        public static void b(List list, InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(interfaceC0808n, aVar, obj);
                }
            }
        }

        public void a(InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b((List) this.f12393a.get(aVar), interfaceC0808n, aVar, obj);
            b((List) this.f12393a.get(AbstractC0804j.a.ON_ANY), interfaceC0808n, aVar, obj);
        }
    }

    /* renamed from: androidx.lifecycle.c$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f12395a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f12396b;

        public b(int i7, Method method) throws SecurityException {
            this.f12395a = i7;
            this.f12396b = method;
            method.setAccessible(true);
        }

        public void a(InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i7 = this.f12395a;
                if (i7 == 0) {
                    this.f12396b.invoke(obj, null);
                } else if (i7 == 1) {
                    this.f12396b.invoke(obj, interfaceC0808n);
                } else {
                    if (i7 != 2) {
                        return;
                    }
                    this.f12396b.invoke(obj, interfaceC0808n, aVar);
                }
            } catch (IllegalAccessException e7) {
                throw new RuntimeException(e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Failed to call observer method", e8.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12395a == bVar.f12395a && this.f12396b.getName().equals(bVar.f12396b.getName());
        }

        public int hashCode() {
            return (this.f12395a * 31) + this.f12396b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i7;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f12394b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f12394b.entrySet()) {
                e(map, (b) entry.getKey(), (AbstractC0804j.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z7 = false;
        for (Method method : methodArr) {
            w wVar = (w) method.getAnnotation(w.class);
            if (wVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i7 = 0;
                } else {
                    if (!InterfaceC0808n.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i7 = 1;
                }
                AbstractC0804j.a aVarValue = wVar.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0804j.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0804j.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i7 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new b(i7, method), aVarValue, cls);
                z7 = true;
            }
        }
        a aVar = new a(map);
        this.f12391a.put(cls, aVar);
        this.f12392b.put(cls, Boolean.valueOf(z7));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e7) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e7);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.f12391a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f12392b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((w) method.getAnnotation(w.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f12392b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, b bVar, AbstractC0804j.a aVar, Class cls) {
        AbstractC0804j.a aVar2 = (AbstractC0804j.a) map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f12396b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }
}
