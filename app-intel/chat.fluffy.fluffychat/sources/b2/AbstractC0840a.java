package b2;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import y.C1786a;

/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0840a {

    /* renamed from: a, reason: collision with root package name */
    public final C1786a f13708a;

    /* renamed from: b, reason: collision with root package name */
    public final C1786a f13709b;

    /* renamed from: c, reason: collision with root package name */
    public final C1786a f13710c;

    public AbstractC0840a(C1786a c1786a, C1786a c1786a2, C1786a c1786a3) {
        this.f13708a = c1786a;
        this.f13709b = c1786a2;
        this.f13710c = c1786a3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i7) {
        w(i7);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i7) {
        w(i7);
        C(charSequence);
    }

    public abstract void E(int i7);

    public void F(int i7, int i8) {
        w(i8);
        E(i7);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i7) {
        w(i7);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i7) {
        w(i7);
        I(str);
    }

    public void K(InterfaceC0842c interfaceC0842c, AbstractC0840a abstractC0840a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            e(interfaceC0842c.getClass()).invoke(null, interfaceC0842c, abstractC0840a);
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e7);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e8);
        } catch (NoSuchMethodException e9) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e9);
        } catch (InvocationTargetException e10) {
            if (!(e10.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e10);
            }
            throw ((RuntimeException) e10.getCause());
        }
    }

    public void L(InterfaceC0842c interfaceC0842c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC0842c == null) {
            I(null);
            return;
        }
        N(interfaceC0842c);
        AbstractC0840a abstractC0840aB = b();
        K(interfaceC0842c, abstractC0840aB);
        abstractC0840aB.a();
    }

    public void M(InterfaceC0842c interfaceC0842c, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        w(i7);
        L(interfaceC0842c);
    }

    public final void N(InterfaceC0842c interfaceC0842c) {
        try {
            I(c(interfaceC0842c.getClass()).getName());
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException(interfaceC0842c.getClass().getSimpleName() + " does not have a Parcelizer", e7);
        }
    }

    public abstract void a();

    public abstract AbstractC0840a b();

    public final Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f13710c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f13710c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws NoSuchMethodException, SecurityException {
        Method method = (Method) this.f13708a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC0840a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0840a.class);
        this.f13708a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = (Method) this.f13709b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, AbstractC0840a.class);
        this.f13709b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z7, int i7) {
        return !m(i7) ? z7 : g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i7) {
        return !m(i7) ? bArr : i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i7) {
        return !m(i7) ? charSequence : k();
    }

    public abstract boolean m(int i7);

    public InterfaceC0842c n(String str, AbstractC0840a abstractC0840a) {
        try {
            return (InterfaceC0842c) d(str).invoke(null, abstractC0840a);
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e7);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e8);
        } catch (NoSuchMethodException e9) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e9);
        } catch (InvocationTargetException e10) {
            if (e10.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e10.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e10);
        }
    }

    public abstract int o();

    public int p(int i7, int i8) {
        return !m(i8) ? i7 : o();
    }

    public abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i7) {
        return !m(i7) ? parcelable : q();
    }

    public abstract String s();

    public String t(String str, int i7) {
        return !m(i7) ? str : s();
    }

    public InterfaceC0842c u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public InterfaceC0842c v(InterfaceC0842c interfaceC0842c, int i7) {
        return !m(i7) ? interfaceC0842c : u();
    }

    public abstract void w(int i7);

    public abstract void y(boolean z7);

    public void z(boolean z7, int i7) {
        w(i7);
        y(z7);
    }

    public void x(boolean z7, boolean z8) {
    }
}
