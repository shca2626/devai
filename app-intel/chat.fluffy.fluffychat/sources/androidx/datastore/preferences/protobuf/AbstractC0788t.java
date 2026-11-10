package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0770a;
import androidx.datastore.preferences.protobuf.AbstractC0789u;
import androidx.datastore.preferences.protobuf.K;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0788t extends AbstractC0770a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0788t> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected h0 unknownFields = h0.c();

    /* renamed from: androidx.datastore.preferences.protobuf.t$a */
    public static abstract class a extends AbstractC0770a.AbstractC0102a {

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC0788t f12234l;

        /* renamed from: m, reason: collision with root package name */
        public AbstractC0788t f12235m;

        public a(AbstractC0788t abstractC0788t) {
            this.f12234l = abstractC0788t;
            if (abstractC0788t.G()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f12235m = w();
        }

        public static void v(Object obj, Object obj2) {
            V.a().d(obj).a(obj, obj2);
        }

        private AbstractC0788t w() {
            return this.f12234l.M();
        }

        @Override // androidx.datastore.preferences.protobuf.L
        public final boolean a() {
            return AbstractC0788t.F(this.f12235m, false);
        }

        public final AbstractC0788t p() {
            AbstractC0788t abstractC0788tI = i();
            if (abstractC0788tI.a()) {
                return abstractC0788tI;
            }
            throw AbstractC0770a.AbstractC0102a.o(abstractC0788tI);
        }

        @Override // androidx.datastore.preferences.protobuf.K.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public AbstractC0788t i() {
            if (!this.f12235m.G()) {
                return this.f12235m;
            }
            this.f12235m.H();
            return this.f12235m;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0770a.AbstractC0102a
        /* renamed from: r, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a n() {
            a aVarH = b().h();
            aVarH.f12235m = i();
            return aVarH;
        }

        public final void s() {
            if (this.f12235m.G()) {
                return;
            }
            t();
        }

        public void t() {
            AbstractC0788t abstractC0788tW = w();
            v(abstractC0788tW, this.f12235m);
            this.f12235m = abstractC0788tW;
        }

        @Override // androidx.datastore.preferences.protobuf.L
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public AbstractC0788t b() {
            return this.f12234l;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.t$b */
    public static class b extends AbstractC0771b {

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC0788t f12236b;

        public b(AbstractC0788t abstractC0788t) {
            this.f12236b = abstractC0788t;
        }

        @Override // androidx.datastore.preferences.protobuf.T
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public AbstractC0788t b(AbstractC0776g abstractC0776g, C0782m c0782m) {
            return AbstractC0788t.O(this.f12236b, abstractC0776g, c0782m);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.t$c */
    public static abstract class c extends AbstractC0788t implements L {
        protected C0786q extensions = C0786q.f();

        public C0786q R() {
            if (this.extensions.l()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0788t, androidx.datastore.preferences.protobuf.L
        public /* bridge */ /* synthetic */ K b() {
            return super.b();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0788t, androidx.datastore.preferences.protobuf.K
        public /* bridge */ /* synthetic */ K.a h() {
            return super.h();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.t$d */
    public static class d extends AbstractC0780k {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.t$e */
    public enum e {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static AbstractC0788t A(Class cls) throws ClassNotFoundException {
        AbstractC0788t abstractC0788t = defaultInstanceMap.get(cls);
        if (abstractC0788t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0788t = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e7) {
                throw new IllegalStateException("Class initialization cannot fail.", e7);
            }
        }
        if (abstractC0788t != null) {
            return abstractC0788t;
        }
        AbstractC0788t abstractC0788tB = ((AbstractC0788t) j0.i(cls)).b();
        if (abstractC0788tB == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, abstractC0788tB);
        return abstractC0788tB;
    }

    public static Object E(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e7);
        } catch (InvocationTargetException e8) {
            Throwable cause = e8.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean F(AbstractC0788t abstractC0788t, boolean z7) {
        byte bByteValue = ((Byte) abstractC0788t.w(e.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zD = V.a().d(abstractC0788t).d(abstractC0788t);
        if (z7) {
            abstractC0788t.x(e.SET_MEMOIZED_IS_INITIALIZED, zD ? abstractC0788t : null);
        }
        return zD;
    }

    public static AbstractC0789u.b J(AbstractC0789u.b bVar) {
        int size = bVar.size();
        return bVar.c(size == 0 ? 10 : size * 2);
    }

    public static Object L(K k7, String str, Object[] objArr) {
        return new X(k7, str, objArr);
    }

    public static AbstractC0788t N(AbstractC0788t abstractC0788t, InputStream inputStream) {
        return q(O(abstractC0788t, AbstractC0776g.g(inputStream), C0782m.b()));
    }

    public static AbstractC0788t O(AbstractC0788t abstractC0788t, AbstractC0776g abstractC0776g, C0782m c0782m) throws C0790v {
        AbstractC0788t abstractC0788tM = abstractC0788t.M();
        try {
            Z zD = V.a().d(abstractC0788tM);
            zD.b(abstractC0788tM, C0777h.O(abstractC0776g), c0782m);
            zD.c(abstractC0788tM);
            return abstractC0788tM;
        } catch (f0 e7) {
            throw e7.a().k(abstractC0788tM);
        } catch (C0790v e8) {
            e = e8;
            if (e.a()) {
                e = new C0790v(e);
            }
            throw e.k(abstractC0788tM);
        } catch (IOException e9) {
            if (e9.getCause() instanceof C0790v) {
                throw ((C0790v) e9.getCause());
            }
            throw new C0790v(e9).k(abstractC0788tM);
        } catch (RuntimeException e10) {
            if (e10.getCause() instanceof C0790v) {
                throw ((C0790v) e10.getCause());
            }
            throw e10;
        }
    }

    public static void P(Class cls, AbstractC0788t abstractC0788t) {
        abstractC0788t.I();
        defaultInstanceMap.put(cls, abstractC0788t);
    }

    public static AbstractC0788t q(AbstractC0788t abstractC0788t) throws C0790v {
        if (abstractC0788t == null || abstractC0788t.a()) {
            return abstractC0788t;
        }
        throw abstractC0788t.m().a().k(abstractC0788t);
    }

    public static AbstractC0789u.b z() {
        return W.h();
    }

    @Override // androidx.datastore.preferences.protobuf.L
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final AbstractC0788t b() {
        return (AbstractC0788t) w(e.GET_DEFAULT_INSTANCE);
    }

    public int C() {
        return this.memoizedHashCode;
    }

    public boolean D() {
        return C() == 0;
    }

    public boolean G() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void H() {
        V.a().d(this).c(this);
        I();
    }

    public void I() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.K
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final a h() {
        return (a) w(e.NEW_BUILDER);
    }

    public AbstractC0788t M() {
        return (AbstractC0788t) w(e.NEW_MUTABLE_INSTANCE);
    }

    public void Q(int i7) {
        this.memoizedHashCode = i7;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final boolean a() {
        return F(this, true);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0770a
    public int e() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return V.a().d(this).f(this, (AbstractC0788t) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public int f() {
        return j(null);
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public void g(AbstractC0778i abstractC0778i) {
        V.a().d(this).e(this, C0779j.P(abstractC0778i));
    }

    public int hashCode() {
        if (G()) {
            return t();
        }
        if (D()) {
            Q(t());
        }
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0770a
    public int j(Z z7) {
        if (!G()) {
            if (e() != Integer.MAX_VALUE) {
                return e();
            }
            int iU = u(z7);
            n(iU);
            return iU;
        }
        int iU2 = u(z7);
        if (iU2 >= 0) {
            return iU2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iU2);
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public final T k() {
        return (T) w(e.GET_PARSER);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0770a
    public void n(int i7) {
        if (i7 >= 0) {
            this.memoizedSerializedSize = (i7 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i7);
        }
    }

    public Object p() {
        return w(e.BUILD_MESSAGE_INFO);
    }

    public void r() {
        this.memoizedHashCode = 0;
    }

    public void s() {
        n(Integer.MAX_VALUE);
    }

    public int t() {
        return V.a().d(this).i(this);
    }

    public String toString() {
        return M.f(this, super.toString());
    }

    public final int u(Z z7) {
        return z7 == null ? V.a().d(this).g(this) : z7.g(this);
    }

    public final a v() {
        return (a) w(e.NEW_BUILDER);
    }

    public Object w(e eVar) {
        return y(eVar, null, null);
    }

    public Object x(e eVar, Object obj) {
        return y(eVar, obj, null);
    }

    public abstract Object y(e eVar, Object obj, Object obj2);
}
