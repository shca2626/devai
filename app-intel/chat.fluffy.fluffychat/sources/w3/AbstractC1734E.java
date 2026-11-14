package w3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import u3.EnumC1662s;

/* renamed from: w3.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1734E {

    /* renamed from: w3.E$b */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f23307a;

        /* renamed from: w3.E$b$a */
        public class a extends b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f23308b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method) {
                super();
                this.f23308b = method;
            }

            @Override // w3.AbstractC1734E.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f23308b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e7) {
                    throw new RuntimeException("Failed invoking canAccess", e7);
                }
            }
        }

        /* renamed from: w3.E$b$b, reason: collision with other inner class name */
        public class C0284b extends b {
            public C0284b() {
                super();
            }

            @Override // w3.AbstractC1734E.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (w.c()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0284b();
            }
            f23307a = aVar;
        }

        public b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f23307a.a(accessibleObject, obj);
    }

    public static EnumC1662s b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return EnumC1662s.ALLOW;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }
}
