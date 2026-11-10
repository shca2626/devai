package w3;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: w3.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1738H {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC1738H f23307a = c();

    /* renamed from: w3.H$a */
    public class a extends AbstractC1738H {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f23308b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f23309c;

        public a(Method method, Object obj) {
            this.f23308b = method;
            this.f23309c = obj;
        }

        @Override // w3.AbstractC1738H
        public Object d(Class cls) {
            AbstractC1738H.b(cls);
            return this.f23308b.invoke(this.f23309c, cls);
        }
    }

    /* renamed from: w3.H$b */
    public class b extends AbstractC1738H {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f23310b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f23311c;

        public b(Method method, int i7) {
            this.f23310b = method;
            this.f23311c = i7;
        }

        @Override // w3.AbstractC1738H
        public Object d(Class cls) {
            AbstractC1738H.b(cls);
            return this.f23310b.invoke(null, cls, Integer.valueOf(this.f23311c));
        }
    }

    /* renamed from: w3.H$c */
    public class c extends AbstractC1738H {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f23312b;

        public c(Method method) {
            this.f23312b = method;
        }

        @Override // w3.AbstractC1738H
        public Object d(Class cls) {
            AbstractC1738H.b(cls);
            return this.f23312b.invoke(null, cls, Object.class);
        }
    }

    /* renamed from: w3.H$d */
    public class d extends AbstractC1738H {
        @Override // w3.AbstractC1738H
        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    public static void b(Class cls) {
        String strT = t.t(cls);
        if (strT == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strT);
    }

    public static AbstractC1738H c() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    return new d();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new c(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new b(declaredMethod3, iIntValue);
        }
    }

    public abstract Object d(Class cls);
}
