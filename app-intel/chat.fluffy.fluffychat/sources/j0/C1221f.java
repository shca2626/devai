package j0;

import androidx.datastore.preferences.protobuf.AbstractC0789t;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.E;
import androidx.datastore.preferences.protobuf.L;
import androidx.datastore.preferences.protobuf.T;
import androidx.datastore.preferences.protobuf.l0;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* renamed from: j0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1221f extends AbstractC0789t implements L {
    private static final C1221f DEFAULT_INSTANCE;
    private static volatile T PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private E preferences_ = E.f();

    /* renamed from: j0.f$a */
    public static final class a extends AbstractC0789t.a implements L {
        public /* synthetic */ a(AbstractC1220e abstractC1220e) {
            this();
        }

        public a x(String str, C1223h c1223h) {
            str.getClass();
            c1223h.getClass();
            s();
            ((C1221f) this.f12235m).T().put(str, c1223h);
            return this;
        }

        public a() {
            super(C1221f.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: j0.f$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final D f18670a = D.d(l0.b.f12132v, "", l0.b.f12134x, C1223h.c0());
    }

    static {
        C1221f c1221f = new C1221f();
        DEFAULT_INSTANCE = c1221f;
        AbstractC0789t.P(C1221f.class, c1221f);
    }

    public static a X() {
        return (a) DEFAULT_INSTANCE.v();
    }

    public static C1221f Y(InputStream inputStream) {
        return (C1221f) AbstractC0789t.N(DEFAULT_INSTANCE, inputStream);
    }

    public final Map T() {
        return V();
    }

    public Map U() {
        return Collections.unmodifiableMap(W());
    }

    public final E V() {
        if (!this.preferences_.l()) {
            this.preferences_ = this.preferences_.o();
        }
        return this.preferences_;
    }

    public final E W() {
        return this.preferences_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0789t
    public final Object y(AbstractC0789t.e eVar, Object obj, Object obj2) {
        T bVar;
        AbstractC1220e abstractC1220e = null;
        switch (AbstractC1220e.f18669a[eVar.ordinal()]) {
            case 1:
                return new C1221f();
            case 2:
                return new a(abstractC1220e);
            case 3:
                return AbstractC0789t.L(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f18670a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                T t7 = PARSER;
                if (t7 != null) {
                    return t7;
                }
                synchronized (C1221f.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC0789t.b(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
