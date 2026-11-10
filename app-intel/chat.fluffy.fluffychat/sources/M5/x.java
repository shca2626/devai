package M5;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static final y f5724a;

    /* renamed from: b, reason: collision with root package name */
    public static final T5.b[] f5725b;

    static {
        y yVar = null;
        try {
            yVar = (y) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (yVar == null) {
            yVar = new y();
        }
        f5724a = yVar;
        f5725b = new T5.b[0];
    }

    public static T5.e a(j jVar) {
        return f5724a.a(jVar);
    }

    public static T5.b b(Class cls) {
        return f5724a.b(cls);
    }

    public static T5.d c(Class cls) {
        return f5724a.c(cls, "");
    }

    public static T5.f d(p pVar) {
        return f5724a.d(pVar);
    }

    public static T5.g e(r rVar) {
        return f5724a.e(rVar);
    }

    public static String f(i iVar) {
        return f5724a.f(iVar);
    }

    public static String g(n nVar) {
        return f5724a.g(nVar);
    }
}
