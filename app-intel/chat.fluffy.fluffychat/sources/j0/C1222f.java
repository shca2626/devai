package j0;

import androidx.datastore.preferences.protobuf.AbstractC0788t;
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
public final class C1222f extends AbstractC0788t implements L {
    private static final C1222f DEFAULT_INSTANCE;
    private static volatile T PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private E preferences_ = E.f();

    /* renamed from: j0.f$a */
    public static final class a extends AbstractC0788t.a implements L {
        public /* synthetic */ a(AbstractC1221e abstractC1221e) {
            this();
        }

        public a x(String str, C1224h c1224h) {
            str.getClass();
            c1224h.getClass();
            s();
            ((C1222f) this.f12235m).T().put(str, c1224h);
            return this;
        }

        public a() {
            super(C1222f.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: j0.f$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final D f18671a = D.d(l0.b.f12132v, "", l0.b.f12134x, C1224h.c0());
    }

    static {
        C1222f c1222f = new C1222f();
        DEFAULT_INSTANCE = c1222f;
        AbstractC0788t.P(C1222f.class, c1222f);
    }

    public static a X() {
        return (a) DEFAULT_INSTANCE.v();
    }

    public static C1222f Y(InputStream inputStream) {
        return (C1222f) AbstractC0788t.N(DEFAULT_INSTANCE, inputStream);
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

    @Override // androidx.datastore.preferences.protobuf.AbstractC0788t
    public final Object y(AbstractC0788t.e eVar, Object obj, Object obj2) {
        T bVar;
        AbstractC1221e abstractC1221e = null;
        switch (AbstractC1221e.f18670a[eVar.ordinal()]) {
            case 1:
                return new C1222f();
            case 2:
                return new a(abstractC1221e);
            case 3:
                return AbstractC0788t.L(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f18671a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                T t7 = PARSER;
                if (t7 != null) {
                    return t7;
                }
                synchronized (C1222f.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC0788t.b(DEFAULT_INSTANCE);
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
