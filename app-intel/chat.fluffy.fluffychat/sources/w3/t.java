package w3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import u3.C1654k;
import u3.EnumC1662s;
import z3.AbstractC1843a;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Map f23329a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f23330b;

    /* renamed from: c, reason: collision with root package name */
    public final List f23331c;

    public t(Map map, boolean z7, List list) {
        this.f23329a = map;
        this.f23330b = z7;
        this.f23331c = list;
    }

    public static InterfaceC1731B A(final Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new InterfaceC1731B() { // from class: w3.s
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.k(type);
                }
            };
        }
        if (cls == EnumMap.class) {
            return new InterfaceC1731B() { // from class: w3.b
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.f(type);
                }
            };
        }
        return null;
    }

    public static /* synthetic */ Map a() {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ Collection b() {
        return new ArrayList();
    }

    public static /* synthetic */ Map c() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Object d(String str) {
        throw new C1654k(str);
    }

    public static /* synthetic */ Object e(Class cls) {
        try {
            return AbstractC1737H.f23313a.d(cls);
        } catch (Exception e7) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e7);
        }
    }

    public static /* synthetic */ Object f(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new C1654k("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new C1654k("Invalid EnumMap type: " + type.toString());
    }

    public static /* synthetic */ Map g() {
        return new ConcurrentSkipListMap();
    }

    public static /* synthetic */ Map h() {
        return new TreeMap();
    }

    public static /* synthetic */ Object i(String str) {
        throw new C1654k(str);
    }

    public static /* synthetic */ Collection j() {
        return new LinkedHashSet();
    }

    public static /* synthetic */ Object k(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new C1654k("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new C1654k("Invalid EnumSet type: " + type.toString());
    }

    public static /* synthetic */ Object l(String str) {
        throw new C1654k(str);
    }

    public static /* synthetic */ Object m(String str) {
        throw new C1654k(str);
    }

    public static /* synthetic */ Map n() {
        return new z();
    }

    public static /* synthetic */ Object o(String str) {
        throw new C1654k(str);
    }

    public static /* synthetic */ Collection p() {
        return new TreeSet();
    }

    public static /* synthetic */ Object q(Constructor constructor) {
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e7) {
            throw AbstractC1843a.e(e7);
        } catch (InstantiationException e8) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC1843a.c(constructor) + "' with no args", e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC1843a.c(constructor) + "' with no args", e9.getCause());
        }
    }

    public static /* synthetic */ Collection r() {
        return new ArrayDeque();
    }

    public static /* synthetic */ Object s(String str) {
        throw new C1654k(str);
    }

    public static String t(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + AbstractC1736G.a("r8-abstract-class");
    }

    public static boolean v(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return true;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        return actualTypeArguments.length != 0 && v.k(actualTypeArguments[0]) == String.class;
    }

    public static InterfaceC1731B w(Class cls) {
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new InterfaceC1731B() { // from class: w3.m
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.b();
                }
            };
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new InterfaceC1731B() { // from class: w3.n
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.j();
                }
            };
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new InterfaceC1731B() { // from class: w3.o
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.p();
                }
            };
        }
        if (cls.isAssignableFrom(ArrayDeque.class)) {
            return new InterfaceC1731B() { // from class: w3.p
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.r();
                }
            };
        }
        return null;
    }

    public static InterfaceC1731B x(Class cls, EnumC1662s enumC1662s) throws NoSuchMethodException, SecurityException {
        final String strP;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            EnumC1662s enumC1662s2 = EnumC1662s.ALLOW;
            if (enumC1662s == enumC1662s2 || (AbstractC1734E.a(declaredConstructor, null) && (enumC1662s != EnumC1662s.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (enumC1662s != enumC1662s2 || (strP = AbstractC1843a.p(declaredConstructor)) == null) ? new InterfaceC1731B() { // from class: w3.j
                    @Override // w3.InterfaceC1731B
                    public final Object a() {
                        return t.q(declaredConstructor);
                    }
                } : new InterfaceC1731B() { // from class: w3.i
                    @Override // w3.InterfaceC1731B
                    public final Object a() {
                        return t.i(strP);
                    }
                };
            }
            final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return new InterfaceC1731B() { // from class: w3.h
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.l(str);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static InterfaceC1731B y(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return w(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return z(type, cls);
        }
        return null;
    }

    public static InterfaceC1731B z(Type type, Class cls) {
        if (cls.isAssignableFrom(z.class) && v(type)) {
            return new InterfaceC1731B() { // from class: w3.c
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.n();
                }
            };
        }
        if (cls.isAssignableFrom(LinkedHashMap.class)) {
            return new InterfaceC1731B() { // from class: w3.d
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.c();
                }
            };
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new InterfaceC1731B() { // from class: w3.e
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.h();
                }
            };
        }
        if (cls.isAssignableFrom(ConcurrentHashMap.class)) {
            return new InterfaceC1731B() { // from class: w3.f
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.a();
                }
            };
        }
        if (cls.isAssignableFrom(ConcurrentSkipListMap.class)) {
            return new InterfaceC1731B() { // from class: w3.g
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.g();
                }
            };
        }
        return null;
    }

    public final InterfaceC1731B B(final Class cls) {
        if (this.f23330b) {
            return new InterfaceC1731B() { // from class: w3.q
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.e(cls);
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new InterfaceC1731B() { // from class: w3.r
            @Override // w3.InterfaceC1731B
            public final Object a() {
                return t.m(str);
            }
        };
    }

    public String toString() {
        return this.f23329a.toString();
    }

    public InterfaceC1731B u(B3.a aVar, boolean z7) throws NoSuchMethodException, SecurityException {
        Type typeD = aVar.d();
        Class clsC = aVar.c();
        android.support.v4.media.session.b.a(this.f23329a.get(typeD));
        android.support.v4.media.session.b.a(this.f23329a.get(clsC));
        InterfaceC1731B interfaceC1731BA = A(typeD, clsC);
        if (interfaceC1731BA != null) {
            return interfaceC1731BA;
        }
        EnumC1662s enumC1662sB = AbstractC1734E.b(this.f23331c, clsC);
        InterfaceC1731B interfaceC1731BX = x(clsC, enumC1662sB);
        if (interfaceC1731BX != null) {
            return interfaceC1731BX;
        }
        InterfaceC1731B interfaceC1731BY = y(typeD, clsC);
        if (interfaceC1731BY != null) {
            return interfaceC1731BY;
        }
        final String strT = t(clsC);
        if (strT != null) {
            return new InterfaceC1731B() { // from class: w3.a
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.o(strT);
                }
            };
        }
        if (!z7) {
            final String str = "Unable to create instance of " + clsC + "; Register an InstanceCreator or a TypeAdapter for this type.";
            return new InterfaceC1731B() { // from class: w3.k
                @Override // w3.InterfaceC1731B
                public final Object a() {
                    return t.d(str);
                }
            };
        }
        if (enumC1662sB == EnumC1662s.ALLOW) {
            return B(clsC);
        }
        final String str2 = "Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new InterfaceC1731B() { // from class: w3.l
            @Override // w3.InterfaceC1731B
            public final Object a() {
                return t.s(str2);
            }
        };
    }
}
