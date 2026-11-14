package z3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import u3.C1654k;
import w3.AbstractC1736G;

/* renamed from: z3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1843a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f24098a;

    /* renamed from: z3.a$b */
    public static abstract class b {
        public b() {
        }

        public abstract Method a(Class cls, Field field);

        public abstract Constructor b(Class cls);

        public abstract String[] c(Class cls);

        public abstract boolean d(Class cls);
    }

    /* renamed from: z3.a$c */
    public static class c extends b {
        public c() {
            super();
        }

        @Override // z3.AbstractC1843a.b
        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // z3.AbstractC1843a.b
        public Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // z3.AbstractC1843a.b
        public String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // z3.AbstractC1843a.b
        public boolean d(Class cls) {
            return false;
        }
    }

    /* renamed from: z3.a$d */
    public static class d extends b {

        /* renamed from: a, reason: collision with root package name */
        public final Method f24099a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f24100b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f24101c;

        /* renamed from: d, reason: collision with root package name */
        public final Method f24102d;

        @Override // z3.AbstractC1843a.b
        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), null);
            } catch (ReflectiveOperationException e7) {
                throw AbstractC1843a.d(e7);
            }
        }

        @Override // z3.AbstractC1843a.b
        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f24100b.invoke(cls, null);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i7 = 0; i7 < objArr.length; i7++) {
                    clsArr[i7] = (Class) this.f24102d.invoke(objArr[i7], null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e7) {
                throw AbstractC1843a.d(e7);
            }
        }

        @Override // z3.AbstractC1843a.b
        public String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f24100b.invoke(cls, null);
                String[] strArr = new String[objArr.length];
                for (int i7 = 0; i7 < objArr.length; i7++) {
                    strArr[i7] = (String) this.f24101c.invoke(objArr[i7], null);
                }
                return strArr;
            } catch (ReflectiveOperationException e7) {
                throw AbstractC1843a.d(e7);
            }
        }

        @Override // z3.AbstractC1843a.b
        public boolean d(Class cls) {
            try {
                return ((Boolean) this.f24099a.invoke(cls, null)).booleanValue();
            } catch (ReflectiveOperationException e7) {
                throw AbstractC1843a.d(e7);
            }
        }

        public d() throws ClassNotFoundException {
            super();
            this.f24099a = Class.class.getMethod("isRecord", null);
            this.f24100b = Class.class.getMethod("getRecordComponents", null);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.f24101c = cls.getMethod("getName", null);
            this.f24102d = cls.getMethod("getType", null);
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (ReflectiveOperationException unused) {
            cVar = new c();
        }
        f24098a = cVar;
    }

    public static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i7 = 0; i7 < parameterTypes.length; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i7].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z7) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z7 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method h(Class cls, Field field) {
        return f24098a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f24098a.b(cls);
    }

    public static String j(Exception exc) {
        if (!exc.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            return "";
        }
        String message = exc.getMessage();
        return "\nSee " + AbstractC1736G.a((message == null || !message.contains("to module com.google.gson")) ? "reflection-inaccessible" : "reflection-inaccessible-to-module-gson");
    }

    public static String[] k(Class cls) {
        return f24098a.c(cls);
    }

    public static boolean l(Class cls) {
        if (n(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    public static boolean m(Class cls) {
        return f24098a.d(cls);
    }

    public static boolean n(Class cls) {
        return Modifier.isStatic(cls.getModifiers());
    }

    public static void o(AccessibleObject accessibleObject) throws SecurityException {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e7) {
            throw new C1654k("Failed making " + g(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type." + j(e7), e7);
        }
    }

    public static String p(Constructor constructor) throws SecurityException {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e7) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e7.getMessage() + j(e7);
        }
    }
}
